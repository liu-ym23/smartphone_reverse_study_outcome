package com.ss.android.ttve.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.ss.android.ttve.nativePort.TEJpegUtils;
import com.ss.android.ttve.nativePort.TEUtils;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.l;
import com.ss.android.vesdk.n0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes38.dex */
public class VEFrame implements Parcelable {
    public static final Parcelable.Creator<VEFrame> CREATOR = null;
    private static final String TAG = "VEFrame";
    protected ETEPixelFormat format;
    protected boolean fromFrontCamera;
    protected int height;
    protected FrameBase mInternalFrame;
    private HashMap<String, String> mMetaDataMap;
    protected int rotation;
    protected long timeStamp;
    protected int width;

    public static class BitmapFrame extends FrameBase {
        protected Bitmap bitmap;

        @Override // com.ss.android.ttve.model.VEFrame.FrameBase
        public void recycle() {
            Bitmap r100 = this.bitmap;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isRecycled() == true) goto L9;
            this.bitmap.recycle();
            return;
        }

        public BitmapFrame(Bitmap r100) {
            this.bitmap = r100;
        }
    }

    public static class ByteArrayFrame extends FrameBase {
        byte[] byteArray;

        public byte[] getByteArray() {
            return this.byteArray;
        }

        public ByteArrayFrame(byte[] r100) {
            this.byteArray = r100;
        }
    }

    public static class ByteBufferFrame extends FrameBase {
        private mgc.a allocator;
        protected ByteBuffer byteBuffer;

        @Override // com.ss.android.ttve.model.VEFrame.FrameBase
        public void recycle() {
            mgc.a r100 = this.allocator;
            if (r100 == null) goto L15;
            ByteBuffer r101 = this.byteBuffer;
            l r102 = (l) r100;
            monitor-enter(r102);
            if (r101 != null) goto L16;
        L10:
            monitor-exit(r102);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        L16:
            if (((LinkedList) r102.f455869a).contains(r101) == true) goto L10;
            ((LinkedList) r102.f455869a).add(r101);     // Catch: Throwable -> L12
            goto L10
        }

        public ByteBuffer getByteBuffer() {
            return this.byteBuffer;
        }

        public ByteBufferFrame(ByteBuffer r100) {
            this.byteBuffer = r100;
        }

        public ByteBufferFrame(ByteBuffer r100, mgc.a r101) {
            this(r100);
            this.allocator = r101;
        }
    }

    public static class CacheableByteBufferFrame extends ByteBufferFrame {
        @Override // com.ss.android.ttve.model.VEFrame.ByteBufferFrame, com.ss.android.ttve.model.VEFrame.FrameBase
        public final void recycle() {
        }
    }

    public static final enum ETEPixelFormat extends Enum<ETEPixelFormat> {
        public static final ETEPixelFormat TEPIXEL_FORMAT_JPEG = null;
        public static final ETEPixelFormat TEPIXEL_FORMAT_YUV420 = null;
        public static final ETEPixelFormat TEPixFmt_ARGB8 = null;
        public static final ETEPixelFormat TEPixFmt_BGR233 = null;
        public static final ETEPixelFormat TEPixFmt_BGR8 = null;
        public static final ETEPixelFormat TEPixFmt_BGRA8 = null;
        public static final ETEPixelFormat TEPixFmt_CVPixelBuffer = null;
        public static final ETEPixelFormat TEPixFmt_Count = null;
        public static final ETEPixelFormat TEPixFmt_GRAY8 = null;
        public static final ETEPixelFormat TEPixFmt_NV12 = null;
        public static final ETEPixelFormat TEPixFmt_NV21 = null;
        public static final ETEPixelFormat TEPixFmt_OpenGL_OES = null;
        public static final ETEPixelFormat TEPixFmt_OpenGL_RGB565 = null;
        public static final ETEPixelFormat TEPixFmt_OpenGL_RGB8 = null;
        public static final ETEPixelFormat TEPixFmt_OpenGL_RGBA8 = null;
        public static final ETEPixelFormat TEPixFmt_RGB233 = null;
        public static final ETEPixelFormat TEPixFmt_RGB565 = null;
        public static final ETEPixelFormat TEPixFmt_RGB8 = null;
        public static final ETEPixelFormat TEPixFmt_RGBA8 = null;
        public static final ETEPixelFormat TEPixFmt_UYVY422 = null;
        public static final ETEPixelFormat TEPixFmt_YUV420P = null;
        public static final ETEPixelFormat TEPixFmt_YUV422P = null;
        public static final ETEPixelFormat TEPixFmt_YUYV422 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ETEPixelFormat[] f449895a = null;

        static {
            ETEPixelFormat r100 = new ETEPixelFormat("TEPixFmt_YUV420P", 0);
            TEPixFmt_YUV420P = r100;
            ETEPixelFormat r101 = new ETEPixelFormat("TEPixFmt_YUYV422", 1);
            TEPixFmt_YUYV422 = r101;
            ETEPixelFormat r102 = new ETEPixelFormat("TEPixFmt_YUV422P", 2);
            TEPixFmt_YUV422P = r102;
            ETEPixelFormat r103 = new ETEPixelFormat("TEPixFmt_UYVY422", 3);
            TEPixFmt_UYVY422 = r103;
            ETEPixelFormat r104 = new ETEPixelFormat("TEPixFmt_NV12", 4);
            TEPixFmt_NV12 = r104;
            ETEPixelFormat r105 = new ETEPixelFormat("TEPixFmt_NV21", 5);
            TEPixFmt_NV21 = r105;
            ETEPixelFormat r110 = new ETEPixelFormat("TEPixFmt_GRAY8", 6);
            TEPixFmt_GRAY8 = r110;
            ETEPixelFormat r111 = new ETEPixelFormat("TEPixFmt_RGB8", 7);
            TEPixFmt_RGB8 = r111;
            ETEPixelFormat r112 = new ETEPixelFormat("TEPixFmt_BGR8", 8);
            TEPixFmt_BGR8 = r112;
            ETEPixelFormat r113 = new ETEPixelFormat("TEPixFmt_RGB233", 9);
            TEPixFmt_RGB233 = r113;
            ETEPixelFormat r114 = new ETEPixelFormat("TEPixFmt_BGR233", 10);
            TEPixFmt_BGR233 = r114;
            ETEPixelFormat r115 = new ETEPixelFormat("TEPixFmt_ARGB8", 11);
            TEPixFmt_ARGB8 = r115;
            ETEPixelFormat r106 = new ETEPixelFormat("TEPixFmt_RGBA8", 12);
            TEPixFmt_RGBA8 = r106;
            ETEPixelFormat r107 = new ETEPixelFormat("TEPixFmt_BGRA8", 13);
            TEPixFmt_BGRA8 = r107;
            ETEPixelFormat r108 = new ETEPixelFormat("TEPixFmt_OpenGL_RGB8", 14);
            TEPixFmt_OpenGL_RGB8 = r108;
            ETEPixelFormat r109 = new ETEPixelFormat("TEPixFmt_OpenGL_RGBA8", 15);
            TEPixFmt_OpenGL_RGBA8 = r109;
            ETEPixelFormat r116 = new ETEPixelFormat("TEPixFmt_CVPixelBuffer", 16);
            TEPixFmt_CVPixelBuffer = r116;
            ETEPixelFormat r117 = new ETEPixelFormat("TEPixFmt_OpenGL_OES", 17);
            TEPixFmt_OpenGL_OES = r117;
            ETEPixelFormat r118 = new ETEPixelFormat("TEPIXEL_FORMAT_JPEG", 18);
            TEPIXEL_FORMAT_JPEG = r118;
            ETEPixelFormat r119 = new ETEPixelFormat("TEPIXEL_FORMAT_YUV420", 19);
            TEPIXEL_FORMAT_YUV420 = r119;
            ETEPixelFormat r120 = new ETEPixelFormat("TEPixFmt_OpenGL_RGB565", 20);
            TEPixFmt_OpenGL_RGB565 = r120;
            ETEPixelFormat r121 = new ETEPixelFormat("TEPixFmt_RGB565", 21);
            TEPixFmt_RGB565 = r121;
            ETEPixelFormat r122 = new ETEPixelFormat("TEPixFmt_Count", 22);
            TEPixFmt_Count = r122;
            f449895a = new ETEPixelFormat[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122};
        }

        public static ETEPixelFormat[] values() {
            return (ETEPixelFormat[]) f449895a.clone();
        }

        public static ETEPixelFormat valueOf(String r100) {
            return (ETEPixelFormat) r27.a.a(ETEPixelFormat.class, r100);
        }

        public ETEPixelFormat(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class FrameBase implements Parcelable {
        public static final Parcelable.Creator<FrameBase> CREATOR = null;

        public class a implements Parcelable.Creator<FrameBase> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final FrameBase createFromParcel(Parcel r100) {
                return new FrameBase(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final FrameBase[] newArray(int r100) {
                return new FrameBase[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void recycle() {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
        }

        static {
            CREATOR = new a();
        }

        public FrameBase() {
        }

        public FrameBase(Parcel r100) {
        }
    }

    public static class IntArrayFrame extends FrameBase {
        int[] intArray;

        public int[] getIntArray() {
            return this.intArray;
        }

        public IntArrayFrame(int[] r100) {
            this.intArray = r100;
        }
    }

    public static final enum Operation extends Enum<Operation> {
        public static final Operation OP_CONVERT = null;
        public static final Operation OP_COPY = null;
        public static final Operation OP_ROTATION = null;
        public static final Operation OP_SCALE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Operation[] f449896a = null;

        static {
            Operation r100 = new Operation("OP_SCALE", 0);
            OP_SCALE = r100;
            Operation r101 = new Operation("OP_ROTATION", 1);
            OP_ROTATION = r101;
            Operation r102 = new Operation("OP_CONVERT", 2);
            OP_CONVERT = r102;
            Operation r103 = new Operation("OP_COPY", 3);
            OP_COPY = r103;
            f449896a = new Operation[]{r100, r101, r102, r103};
        }

        public static Operation[] values() {
            return (Operation[]) f449896a.clone();
        }

        public static Operation valueOf(String r100) {
            return (Operation) r27.a.a(Operation.class, r100);
        }

        public Operation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class TextureDescFrame extends FrameBase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f449897a;

        public final String toString() {
            return super.toString() + ", texDesc:" + this.f449897a;
        }

        public TextureDescFrame(String r100) {
            this.f449897a = r100;
        }
    }

    public static class TextureFrame extends FrameBase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EGLContext f449898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f449899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f449900c;

        public EGLContext getContext() {
            return this.f449898a;
        }

        public TextureFrame(EGLContext r100, int r101, float[] r102) {
            this.f449899b = 0;
            this.f449900c = null;
            this.f449898a = r100;
            this.f449899b = r101;
            this.f449900c = r102;
        }
    }

    public static class YUVByteBufferPlaneFrame extends FrameBase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer[] f449901a;

        public YUVByteBufferPlaneFrame(ByteBuffer r100, ByteBuffer r101, ByteBuffer r102) {
            this.f449901a = new ByteBuffer[]{r100, r101, r102};
        }
    }

    public static class YUVPlansFrame extends FrameBase {
        e planes;

        public Image.Plane[] getPlanes() {
            return this.planes.f449913a;
        }

        public YUVPlansFrame(e r100) {
            this.planes = r100;
        }
    }

    public class a implements Parcelable.Creator<VEFrame> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEFrame createFromParcel(Parcel r100) {
            return new VEFrame(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEFrame[] newArray(int r100) {
            return new VEFrame[r100];
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f449902a = null;

        static {
            int[] r100 = new int[ETEPixelFormat.values().length];
            f449902a = r100;
            r100[ETEPixelFormat.TEPIXEL_FORMAT_YUV420.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f449902a[ETEPixelFormat.TEPixFmt_YUV420P.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f449902a[ETEPixelFormat.TEPixFmt_NV12.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f449902a[ETEPixelFormat.TEPixFmt_NV21.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f449902a[ETEPixelFormat.TEPIXEL_FORMAT_JPEG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public ByteBuffer getByteBuffer() {
        FrameBase r100 = this.mInternalFrame;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "get bytebuffer data failed, no internal frame!");
        return null;
    L7:
        if ((r100 instanceof ByteArrayFrame) == false) goto L14;
        if (getFormat() != ETEPixelFormat.TEPIXEL_FORMAT_JPEG) goto L12;
        return null;
    L12:
        return ByteBuffer.wrap(((ByteArrayFrame) this.mInternalFrame).getByteArray());
    L14:
        if ((r100 instanceof ByteBufferFrame) == true) goto L16;
        VELogUtil.e(TAG, "get bytebuffer data failed, not support: ".concat(r100.getClass().getName()));
        return null;
    L16:
        return ((ByteBufferFrame) r100).getByteBuffer();
    }

    public byte[] getByteData() {
        FrameBase r100 = this.mInternalFrame;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "get yuv byte data failed, no internal frame!");
        return null;
    L7:
        if ((r100 instanceof ByteArrayFrame) == true) goto L9;
        return null;
    L9:
        return ((ByteArrayFrame) r100).getByteArray();
    }

    public int getFormatOrdinal() {
        return this.format.ordinal();
    }

    public byte[] getJpegData() {
        FrameBase r100 = this.mInternalFrame;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "get jpeg data failed, no internal frame!");
        return null;
    L7:
        if (this.format == ETEPixelFormat.TEPIXEL_FORMAT_JPEG) goto L11;
        VELogUtil.e(TAG, "get jpeg data failed, internal frame format: " + this.format);
        return null;
    L11:
        if ((r100 instanceof ByteArrayFrame) == true) goto L13;
        return null;
    L13:
        return ((ByteArrayFrame) r100).getByteArray();
    }

    public VERenderContext getRenderContext() {
        FrameBase r100 = this.mInternalFrame;
        VERenderContext.a r101 = null;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "get render context failed, no internal frame!");
        return null;
    L7:
        if ((r100 instanceof TextureFrame) == false) goto L10;
        VERenderContext r102 = new VERenderContext(r101);
        VERenderContext.access$102(r102, VERenderContext.RenderEnvType.VE_RENDER_ENV_OPENGL);
        VERenderContext.access$202(r102, ((TextureFrame) r100).getContext());
        return r102;
    L10:
        return null;
    }

    public int getTextureID() {
        FrameBase r100 = this.mInternalFrame;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "get texture id failed, no internal frame!");
        return -1;
    L7:
        if ((r100 instanceof TextureFrame) == true) goto L9;
        return -1;
    L9:
        return ((TextureFrame) r100).f449899b;
    }

    public float[] getTextureTransformMatrix() {
        FrameBase r100 = this.mInternalFrame;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "get texture transform matrix failed, no internal frame!");
        return null;
    L7:
        if ((r100 instanceof TextureFrame) == false) goto L12;
        float[] r101 = ((TextureFrame) r100).f449900c;
        if (r101 != null) goto L11;
        VELogUtil.w(TAG, "transform matrix data is null!");
    L11:
        return r101;
    L12:
        return null;
    }

    public Image.Plane[] getYUVPlanes() {
        FrameBase r100 = this.mInternalFrame;
        if (r100 != null) goto L7;
        VELogUtil.e(TAG, "get yuv data failed, no internal frame!");
        return null;
    L7:
        if ((r100 instanceof YUVPlansFrame) == true) goto L9;
        return null;
    L9:
        return ((YUVPlansFrame) r100).getPlanes();
    }

    public void recycle() {
        FrameBase r100 = this.mInternalFrame;
        if (r100 == null) goto L6;
        r100.recycle();
        return;
    }

    public synchronized Bitmap toBitmap() {
        monitor-enter(this);
        FrameBase r100 = this.mInternalFrame;     // Catch: Throwable -> L63
        if (r100 != null) goto L10;
        monitor-exit(this);
        return null;
    L10:
        if ((r100 instanceof ByteBufferFrame) == false) goto L26;
        ETEPixelFormat r101 = this.format;     // Catch: Throwable -> L63
        if (r101 != ETEPixelFormat.TEPixFmt_RGBA8) goto L19;
        if (this.rotation != 0) goto L19;
        ByteBuffer r102 = ((ByteBufferFrame) r100).byteBuffer;     // Catch: Throwable -> L63
        Bitmap r103 = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L63
        r102.rewind();     // Catch: Throwable -> L63
        r102.position(0);     // Catch: Throwable -> L63
        r103.copyPixelsFromBuffer(r102);     // Catch: Throwable -> L63
        monitor-exit(this);
        return r103;
    L19:
        if (r101 == ETEPixelFormat.TEPixFmt_ARGB8) goto L21;
    L60:
        VELogUtil.e(TAG, "toBitmap failed. Invalid mInternalFrame: ".concat(r100.getClass().getName()));     // Catch: Throwable -> L63
        monitor-exit(this);
        return null;
    L21:
        if (this.rotation != 0) goto L60;
        ByteBuffer r104 = ((ByteBufferFrame) r100).byteBuffer;     // Catch: Throwable -> L63
        r104.rewind();     // Catch: Throwable -> L63
        int r105 = r104.capacity();     // Catch: Throwable -> L63
        byte[] r106 = new byte[r105];     // Catch: Throwable -> L63
        r104.get(r106, 0, r105);     // Catch: Throwable -> L63
        TEUtils.nativeTransPixels2Bitmap(r106, this.width, this.height);     // Catch: Throwable -> L63
        Bitmap r107 = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L63
        r107.copyPixelsFromBuffer(ByteBuffer.wrap(r106));     // Catch: Throwable -> L63
        monitor-exit(this);
        return r107;
    L26:
        if ((r100 instanceof IntArrayFrame) == false) goto L42;
        ETEPixelFormat r108 = this.format;     // Catch: Throwable -> L63
        if (r108 != ETEPixelFormat.TEPixFmt_RGBA8) goto L35;
        if (this.rotation != 0) goto L35;
        Bitmap r109 = Bitmap.createBitmap(((IntArrayFrame) r100).intArray, this.width, this.height, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L63
        monitor-exit(this);
        return r109;
    L35:
        if (r108 != ETEPixelFormat.TEPixFmt_ARGB8) goto L60;
        if (this.rotation != 0) goto L60;
        Bitmap r110 = Bitmap.createBitmap(((IntArrayFrame) r100).intArray, this.width, this.height, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L63
        monitor-exit(this);
        return r110;
    L42:
        if ((r100 instanceof ByteArrayFrame) == false) goto L56;
        ETEPixelFormat r111 = this.format;     // Catch: Throwable -> L63
        if (r111 != ETEPixelFormat.TEPixFmt_RGBA8) goto L51;
        if (this.rotation != 0) goto L51;
        Bitmap r112 = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L63
        r112.copyPixelsFromBuffer(ByteBuffer.wrap(((ByteArrayFrame) this.mInternalFrame).byteArray));     // Catch: Throwable -> L63
        monitor-exit(this);
        return r112;
    L51:
        if (r111 != ETEPixelFormat.TEPIXEL_FORMAT_JPEG) goto L60;
        byte[] r113 = ((ByteArrayFrame) r100).byteArray;     // Catch: Throwable -> L63
        Bitmap r114 = BitmapFactory.decodeByteArray(r113, 0, r113.length);     // Catch: Throwable -> L63
        monitor-exit(this);
        return r114;
    L56:
        if ((r100 instanceof BitmapFrame) == false) goto L60;
        Bitmap r115 = ((BitmapFrame) r100).bitmap;     // Catch: Throwable -> L63
        monitor-exit(this);
        return r115;
    L63:
        th = move-exception;
        throw th;
    }

    public ETEPixelFormat getFormat() {
        return this.format;
    }

    public FrameBase getFrame() {
        return this.mInternalFrame;
    }

    public int getHeight() {
        return this.height;
    }

    public HashMap<String, String> getMetaData() {
        return this.mMetaDataMap;
    }

    public int getRotation() {
        return this.rotation;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isFromFrontCamera() {
        return this.fromFrontCamera;
    }

    public VEFrame(Parcel r100) {
        this.format = ETEPixelFormat.TEPixFmt_Count;
        ETEPixelFormat r101 = null;
        this.mMetaDataMap = null;
        int r102 = r100.readInt();
        if (r102 == (-1)) goto L6;
        r101 = ETEPixelFormat.values()[r102];
    L6:
        this.format = r101;
        this.mInternalFrame = (FrameBase) r100.readParcelable(FrameBase.class.getClassLoader());
        this.rotation = r100.readInt();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.timeStamp = r100.readLong();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.fromFrontCamera = r103;
        return;
    L9:
        r103 = false;
        goto L10
    }

    public static ByteBuffer allocateFrame(int r100) {
        return ByteBuffer.allocateDirect(r100).order(ByteOrder.LITTLE_ENDIAN);
    }

    public void dumpImageToPath(String r100) {
        if (this.mInternalFrame != null) goto L6;
        VELogUtil.e(TAG, "dump image failed! internal frame is null!");
        return;
    L6:
        String r101 = r100 + "_VEFrame" + ("_" + this.width + "x" + this.height) + ("_" + System.currentTimeMillis());
        int r102 = b.f449902a[this.format.ordinal()];
        if (r102 == 1) goto L85;
        int r103 = 0;
        PolarisFileOutputStreamWrapper r104 = null;
        if (r102 != 2) goto L11;
        FrameBase r105 = this.mInternalFrame;
        if ((r105 instanceof YUVByteBufferPlaneFrame) == false) goto L84;
        ByteBuffer[] r106 = ((YUVByteBufferPlaneFrame) r105).f449901a;
        if (r106 != null) goto L87;
        VELogUtil.e("VEImageUtils", "Input null plane, failed to save yuv!");
        return;
    L87:
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L68 IOException -> L70
        int r108 = r106.length;     // Catch: Throwable -> L64 IOException -> L66
    L57:
        if (r103 >= r108) goto L60;
        ByteBuffer r109 = r106[r103];     // Catch: Throwable -> L64 IOException -> L66
        byte[] r110 = new byte[r109.remaining()];     // Catch: Throwable -> L64 IOException -> L66
        r109.get(r110);     // Catch: Throwable -> L64 IOException -> L66
        r107.write(r110);     // Catch: Throwable -> L64 IOException -> L66
        r109.rewind();     // Catch: Throwable -> L64 IOException -> L66
        r103 = r103 + 1;
        goto L57
    L60:
        r107.close();     // Catch: IOException -> L62
    L97:
        return;
    L66:
        e = e;
        r104 = r107;
    L71:
        VELogUtil.e("VEImageUtils", "save yuv failed!");     // Catch: Throwable -> L68
        e.printStackTrace();     // Catch: Throwable -> L68
        if (r104 == null) goto L111;
        r104.close();     // Catch: IOException -> L62
        goto L97
    L111:
        return;
    L64:
        th = th;
    L78:
        if (r107 != null) goto L89;
    L83:
        throw th;
    L89:
        r107.close();     // Catch: IOException -> L81
    L81:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "saveYUVToPath, close FileOutputStream failed!");
        e.printStackTrace();
    L70:
        e = e;
    L68:
        th = th;
        r107 = r104;
    L62:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "saveYUVToPath, close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L84:
        String r111 = r101 + "_YUV420P.yuv";
        VELogUtil.i(TAG, "Start to dump VEFrame to " + r111);
        n0.c(getYUVPlanes(), this.width, this.height, r111);
        n0.a(getByteBuffer(), r111);
        n0.b(getByteData(), r111);
        return;
    L11:
        if (r102 != 3) goto L13;
        String r112 = r101 + "_NV12.yuv";
        VELogUtil.i(TAG, "Start to dump VEFrame to " + r112);
        n0.c(getYUVPlanes(), this.width, this.height, r112);
        n0.a(getByteBuffer(), r112);
        n0.b(getByteData(), r112);
        return;
    L13:
        if (r102 != 4) goto L15;
        String r113 = r101 + "_NV21.yuv";
        VELogUtil.i(TAG, "Start to dump VEFrame to " + r113);
        n0.c(getYUVPlanes(), this.width, this.height, r113);
        n0.a(getByteBuffer(), r113);
        n0.b(getByteData(), r113);
        return;
    L15:
        if (r102 == 5) goto L20;
        Bitmap r114 = toBitmap();
        if (r114.isRecycled() == false) goto L19;
        VELogUtil.e("VEImageUtils", "Can't compress a recycled bitmap");
        return;
    L19:
        TEJpegUtils.compressToJPEG(r114, 80, r101);
        return;
    L20:
        String r115 = r101 + "_JPEG.jpeg";
        VELogUtil.i(TAG, "Start to dump VEFrame to " + r115);
        byte[] r116 = getJpegData();
        if (r116 != null) goto L102;
        VELogUtil.e("VEImageUtils", "Input null data, failed to save jpeg!");
        return;
    L102:
        PolarisFileOutputStreamWrapper r117 = new PolarisFileOutputStreamWrapper(r115);     // Catch: Throwable -> L33 IOException -> L35
        r117.write(r116, 0, r116.length);     // Catch: Throwable -> L29 IOException -> L31
        r117.close();     // Catch: IOException -> L27
    L92:
    L95:
        return;
    L31:
        e = e;
        r104 = r117;
    L36:
        VELogUtil.e("VEImageUtils", "save jpeg failed！");     // Catch: Throwable -> L33
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r104 == null) goto L95;
        r104.close();     // Catch: IOException -> L27
    L29:
        th = th;
    L42:
        if (r117 != null) goto L100;
    L47:
        throw th;
    L100:
        r117.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
    L35:
        e = e;
    L27:
        e = move-exception;
        VELogUtil.e("VEImageUtils", "close FileOutputStream failed!");
        e.printStackTrace();
    L33:
        th = th;
        r117 = r104;
        goto L42
    L85:
        String r118 = r101 + "_YUV420.yuv";
        VELogUtil.i(TAG, "Start to dump VEFrame to " + r118);
        n0.c(getYUVPlanes(), this.width, this.height, r118);
        n0.a(getByteBuffer(), r118);
        n0.b(getByteData(), r118);
    }

    public void setFromFrontCamera(boolean r100) {
        this.fromFrontCamera = r100;
    }

    public void setMetaData(HashMap<String, String> r100) {
        this.mMetaDataMap = r100;
    }

    public void setRotation(int r100) {
        if (r100 >= 0) goto L5;
        int r101 = (r100 % 360) + 360;
    L6:
        if (r101 != 360) goto L8;
        r101 = 0;
    L8:
        this.rotation = r101;
        return;
    L5:
        r101 = r100 % 360;
        goto L6
    }

    public static VEFrame createByteBufferFrame(Bitmap r100, long r110) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isRecycled() == true) goto L10;
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.getByteCount()).order(ByteOrder.LITTLE_ENDIAN);
        r100.copyPixelsToBuffer(r101);
        VEFrame r102 = new VEFrame(r100.getWidth(), r100.getHeight(), 0, r110, ETEPixelFormat.TEPixFmt_RGBA8);
        r102.mInternalFrame = new ByteBufferFrame(r101);
        return r102;
    L10:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        ETEPixelFormat r102 = this.format;
        if (r102 != null) goto L5;
        int r103 = -1;
    L6:
        r100.writeInt(r103);
        r100.writeParcelable(this.mInternalFrame, r101);
        r100.writeInt(this.rotation);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeLong(this.timeStamp);
        r100.writeByte(this.fromFrontCamera ? 1 : 0);
        return;
    L5:
        r103 = r102.ordinal();
        goto L6
    }

    public static VEFrame createBitmapFrame(Bitmap r100, int r101, long r110) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isRecycled() == true) goto L10;
        VEFrame r102 = new VEFrame(r100.getWidth(), r100.getHeight(), r101, r110, ETEPixelFormat.TEPixFmt_RGBA8);
        r102.mInternalFrame = new BitmapFrame(r100);
        return r102;
    L10:
        return null;
    }

    public VEFrame(int r100, int r101, int r102, long r103, ETEPixelFormat r104) {
        ETEPixelFormat r105 = ETEPixelFormat.TEPixFmt_YUV420P;
        this.mMetaDataMap = null;
        this.width = r100;
        this.height = r101;
        this.rotation = r102;
        this.timeStamp = r103;
        this.format = r104;
    }

    public static VEFrame createByteArrayFrame(byte[] r100, int r101, int r110, int r111, long r112, ETEPixelFormat r113) {
        VEFrame r102 = new VEFrame(r101, r110, r111, r112, r113);
        r102.mInternalFrame = new ByteArrayFrame(r100);
        return r102;
    }

    private static VEFrame createByteBufferFrame(ByteBuffer r100, int r101, int r110, int r111, long r112, int r113) {
        if (r113 >= 0) goto L4;
    L8:
        VELogUtil.e(TAG, "createByteBufferFrame failed. Invalid order: " + r113);
        return null;
    L4:
        if (r113 >= ETEPixelFormat.values().length) goto L8;
        return createByteBufferFrame(r100, r101, r110, r111, r112, ETEPixelFormat.values()[r113]);
    }

    public static VEFrame createIntArrayFrame(int[] r100, int r101, int r110, int r111, long r112, ETEPixelFormat r113) {
        VEFrame r102 = new VEFrame(r101, r110, r111, r112, r113);
        r102.mInternalFrame = new IntArrayFrame(r100);
        return r102;
    }

    public static VEFrame createTextureFrame(String r100, int r101, int r110, int r111, long r112, int r113) {
        VEFrame r102 = new VEFrame(r101, r110, r111, r112, ETEPixelFormat.values()[r113]);
        r102.mInternalFrame = new TextureDescFrame(r100);
        return r102;
    }

    public static VEFrame createYUVPlanFrame(e r100, int r101, int r110, int r111, long r112, ETEPixelFormat r113) {
        VEFrame r102 = new VEFrame(r101, r110, r111, r112, r113);
        r102.mInternalFrame = new YUVPlansFrame(r100);
        return r102;
    }

    public static VEFrame createByteBufferFrame(ByteBuffer r100, int r101, int r110, int r111, long r112, ETEPixelFormat r113) {
        return createByteBufferFrame(r100, r101, r110, r111, r112, r113, null);
    }

    public static VEFrame createByteBufferFrame(ByteBuffer r100, int r101, int r110, int r111, long r112, ETEPixelFormat r113, mgc.a r114) {
        VEFrame r102 = new VEFrame(r101, r110, r111, r112, r113);
        r102.mInternalFrame = new ByteBufferFrame(r100, r114);
        return r102;
    }

    public static VEFrame createTextureFrame(int r100, float[] r110, int r111, int r112, int r113, long r114, int r115) {
        return createTextureFrame(EGL14.eglGetCurrentContext(), r100, r110, r111, r112, r113, r114, ETEPixelFormat.values()[r115]);
    }

    public static VEFrame createTextureFrame(EGLContext r100, int r101, float[] r110, int r111, int r112, int r113, long r114, ETEPixelFormat r115) {
        VEFrame r102 = new VEFrame(r111, r112, r113, r114, r115);
        r102.mInternalFrame = new TextureFrame(r100, r101, r110);
        return r102;
    }

    public static VEFrame createYUVByteBufferPlaneFrame(ByteBuffer r100, ByteBuffer r101, ByteBuffer r110, int r111, int r112, int r113, long r114, int r115) {
        VEFrame r102 = new VEFrame(r111, r112, r113, r114, ETEPixelFormat.values()[r115]);
        r102.mInternalFrame = new YUVByteBufferPlaneFrame(r100, r101, r110);
        return r102;
    }
}
