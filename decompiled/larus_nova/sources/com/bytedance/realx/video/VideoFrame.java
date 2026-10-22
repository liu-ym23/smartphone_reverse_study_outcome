package com.bytedance.realx.video;

import android.graphics.Matrix;
import android.opengl.EGLContext;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.RefCounted;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class VideoFrame implements RefCounted {
    private final Buffer buffer;
    private int colorSpace;
    private final ByteBuffer extendedData;
    private boolean isFlip;
    private int iso;
    private final int rotation;
    private final long timestampNs;

    public interface Buffer extends RefCounted {

        /* JADX INFO: renamed from: com.bytedance.realx.video.VideoFrame$Buffer$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static NV12Buffer $default$toNV12(Buffer r100) {
                RXLogging.e("VideoFrame", "toNV12 has not been implemented, default return null");
                return null;
            }
        }

        public interface BufferType {
            public static final int I420 = 3;
            public static final int Null = 0;
            public static final int Nv12 = 1;
            public static final int Nv21 = 2;
            public static final int RGBA = 5;
            public static final int Texture = 4;
        }

        Buffer copyData();

        Buffer cropAndScale(int r100, int r101, int r102, int r103, int r104, int r105);

        int getBufferType();

        int getHeight();

        int getWidth();

        @Override // com.bytedance.realx.base.RefCounted
        void release();

        @Override // com.bytedance.realx.base.RefCounted
        void retain();

        Buffer scaleAndFill(int r100, int r101, int r102, int r103);

        I420Buffer toI420();

        NV12Buffer toNV12();
    }

    public static final enum ColorSpace extends Enum<ColorSpace> {
        private static final /* synthetic */ ColorSpace[] $VALUES = null;
        public static final ColorSpace kUnknown = null;
        public static final ColorSpace kYCbCrBT601FullRange = null;
        public static final ColorSpace kYCbCrBT601LimitedRange = null;
        public static final ColorSpace kYCbCrBT709FullRange = null;
        public static final ColorSpace kYCbCrBT709LimitedRange = null;
        private int colorSpace;

        static {
            ColorSpace r100 = new ColorSpace("kUnknown", 0, 0);
            kUnknown = r100;
            ColorSpace r101 = new ColorSpace("kYCbCrBT601LimitedRange", 1, 1);
            kYCbCrBT601LimitedRange = r101;
            ColorSpace r102 = new ColorSpace("kYCbCrBT601FullRange", 2, 2);
            kYCbCrBT601FullRange = r102;
            ColorSpace r103 = new ColorSpace("kYCbCrBT709LimitedRange", 3, 3);
            kYCbCrBT709LimitedRange = r103;
            ColorSpace r104 = new ColorSpace("kYCbCrBT709FullRange", 4, 4);
            kYCbCrBT709FullRange = r104;
            $VALUES = new ColorSpace[]{r100, r101, r102, r103, r104};
        }

        public static ColorSpace[] values() {
            return (ColorSpace[]) $VALUES.clone();
        }

        public int getColorSpace() {
            return this.colorSpace;
        }

        public static ColorSpace valueOf(String r100) {
            return (ColorSpace) r27.a.a(ColorSpace.class, r100);
        }

        private ColorSpace(String r100, int r101, int r102) {
            super(r100, r101);
            this.colorSpace = r102;
        }
    }

    public interface I420Buffer extends Buffer {

        /* JADX INFO: renamed from: com.bytedance.realx.video.VideoFrame$I420Buffer$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static int $default$getBufferType(I420Buffer r100) {
                return 3;
            }
        }

        @Override // com.bytedance.realx.video.VideoFrame.Buffer
        int getBufferType();

        ByteBuffer getDataU();

        ByteBuffer getDataV();

        ByteBuffer getDataY();

        int getStrideU();

        int getStrideV();

        int getStrideY();
    }

    public interface NV12Buffer extends Buffer {

        /* JADX INFO: renamed from: com.bytedance.realx.video.VideoFrame$NV12Buffer$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static int $default$getBufferType(NV12Buffer r100) {
                return 1;
            }
        }

        @Override // com.bytedance.realx.video.VideoFrame.Buffer
        int getBufferType();

        ByteBuffer getDataUV();

        ByteBuffer getDataY();

        int getStrideUV();

        int getStrideY();
    }

    public interface TextureBuffer extends Buffer {

        /* JADX INFO: renamed from: com.bytedance.realx.video.VideoFrame$TextureBuffer$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static int $default$getBufferType(TextureBuffer r100) {
                return 4;
            }
        }

        public static final enum Type extends Enum<Type> {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type OES = null;
            public static final Type RGB = null;
            private final int glTarget;

            static {
                Type r100 = new Type("OES", 0, 36197);
                OES = r100;
                Type r101 = new Type("RGB", 1, 3553);
                RGB = r101;
                $VALUES = new Type[]{r100, r101};
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public int getGlTarget() {
                return this.glTarget;
            }

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.glTarget = r102;
            }
        }

        Buffer cropAndScaleWithFilter(int r100, int r101, int r102, int r103, int r104, int r105, int r106);

        @Override // com.bytedance.realx.video.VideoFrame.Buffer
        int getBufferType();

        EGLContext getEglContext();

        long getNativeEglContext();

        FilterType getScaleFilter();

        int getTextureId();

        Matrix getTransformMatrix();

        Type getType();

        int getTypeGlTarget();

        int getUnscaledHeight();

        int getUnscaledWidth();

        float[] nativeGetTransFormMatrix();
    }

    public int getRotatedHeight() {
        if ((this.rotation % 180) != 0) goto L7;
        return this.buffer.getHeight();
    L7:
        return this.buffer.getWidth();
    }

    public int getRotatedWidth() {
        if ((this.rotation % 180) != 0) goto L7;
        return this.buffer.getWidth();
    L7:
        return this.buffer.getHeight();
    }

    @Override // com.bytedance.realx.base.RefCounted
    public void release() {
        this.buffer.release();
    }

    @Override // com.bytedance.realx.base.RefCounted
    public void retain() {
        this.buffer.retain();
    }

    public Buffer getBuffer() {
        return this.buffer;
    }

    public int getColorSpace() {
        return this.colorSpace;
    }

    public ByteBuffer getExtendedData() {
        return this.extendedData;
    }

    public boolean getFlipState() {
        return this.isFlip;
    }

    public int getIso() {
        return this.iso;
    }

    public int getRotation() {
        return this.rotation;
    }

    public long getTimestampNs() {
        return this.timestampNs;
    }

    public static ByteBuffer allocateDirectByteBuffer(int r100) {
        return ByteBuffer.allocateDirect(r100);
    }

    public void setFlipState(boolean r100) {
        this.isFlip = r100;
    }

    public void setIso(int r100) {
        this.iso = r100;
    }

    public VideoFrame(Buffer r100, int r101, long r102) {
        this(r100, null, r101, r102);
    }

    public VideoFrame(Buffer r100, int r101, long r102, boolean r103) {
        this.isFlip = false;
        this.colorSpace = 0;
        this.iso = -1;
        if (r100 == null) goto L11;
        if ((r101 % 90) != 0) goto L9;
        this.buffer = r100;
        this.rotation = r101;
        this.timestampNs = r102;
        this.extendedData = null;
        this.isFlip = r103;
        return;
    L9:
        throw new IllegalArgumentException("rotation must be a multiple of 90");
    L11:
        throw new IllegalArgumentException("buffer not allowed to be null");
    }

    public VideoFrame(Buffer r100, ByteBuffer r101, int r102, long r103) {
        this.isFlip = false;
        this.colorSpace = 0;
        this.iso = -1;
        if (r100 == null) goto L11;
        if ((r102 % 90) != 0) goto L9;
        this.buffer = r100;
        this.rotation = r102;
        this.timestampNs = r103;
        this.extendedData = r101;
        return;
    L9:
        throw new IllegalArgumentException("rotation must be a multiple of 90");
    L11:
        throw new IllegalArgumentException("buffer not allowed to be null");
    }

    public VideoFrame(Buffer r100, ByteBuffer r101, int r102, long r103, boolean r104) {
        this.isFlip = false;
        this.colorSpace = 0;
        this.iso = -1;
        if (r100 == null) goto L11;
        if ((r102 % 90) != 0) goto L9;
        this.buffer = r100;
        this.rotation = r102;
        this.timestampNs = r103;
        this.extendedData = r101;
        this.isFlip = r104;
        return;
    L9:
        throw new IllegalArgumentException("rotation must be a multiple of 90");
    L11:
        throw new IllegalArgumentException("buffer not allowed to be null");
    }

    public VideoFrame(Buffer r100, ByteBuffer r101, int r102, long r103, boolean r104, int r105) {
        this.isFlip = false;
        this.colorSpace = 0;
        this.iso = -1;
        if (r100 == null) goto L11;
        if ((r102 % 90) != 0) goto L9;
        this.buffer = r100;
        this.rotation = r102;
        this.timestampNs = r103;
        this.extendedData = r101;
        this.isFlip = r104;
        this.colorSpace = r105;
        return;
    L9:
        throw new IllegalArgumentException("rotation must be a multiple of 90");
    L11:
        throw new IllegalArgumentException("buffer not allowed to be null");
    }
}
