package com.bytedance.realx.video;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes21.dex */
public class EncodedImage {
    public final int actualHeight;
    public final int actualWidth;
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final boolean completeFrame;
    public final long compositionTimeUs;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;

    /* JADX INFO: renamed from: qp, reason: collision with root package name */
    public final Integer f267126qp;
    public final int rotation;
    public final int svcLayerNum;

    /* JADX INFO: renamed from: com.bytedance.realx.video.EncodedImage$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int actualHeight;
        private int actualWidth;
        private ByteBuffer buffer;
        private long captureTimeNs;
        private boolean completeFrame;
        private long compositionTimeUs;
        private int encodedHeight;
        private int encodedWidth;
        private FrameType frameType;

        /* JADX INFO: renamed from: qp, reason: collision with root package name */
        private Integer f267127qp;
        private int rotation;
        private int svcLayerNum;

        public EncodedImage createEncodedImage() {
            return new EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.actualWidth, this.actualHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.f267127qp, this.svcLayerNum, this.compositionTimeUs, null);
        }

        private Builder() {
            this.f267127qp = -1;
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        public Builder setActualHeight(int r100) {
            this.actualHeight = r100;
            return this;
        }

        public Builder setActualWidth(int r100) {
            this.actualWidth = r100;
            return this;
        }

        public Builder setBuffer(ByteBuffer r100) {
            this.buffer = r100;
            return this;
        }

        public Builder setCaptureTimeMs(long r100) {
            this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(r100);
            return this;
        }

        public Builder setCaptureTimeNs(long r100) {
            this.captureTimeNs = r100;
            return this;
        }

        public Builder setCompleteFrame(boolean r100) {
            this.completeFrame = r100;
            return this;
        }

        public Builder setCompositionTimeUs(long r100) {
            this.compositionTimeUs = r100;
            return this;
        }

        public Builder setEncodedHeight(int r100) {
            this.encodedHeight = r100;
            return this;
        }

        public Builder setEncodedWidth(int r100) {
            this.encodedWidth = r100;
            return this;
        }

        public Builder setFrameType(FrameType r100) {
            this.frameType = r100;
            return this;
        }

        public Builder setQp(Integer r100) {
            this.f267127qp = r100;
            return this;
        }

        public Builder setRotation(int r100) {
            this.rotation = r100;
            return this;
        }

        public Builder setSvcLayerNum(int r100) {
            this.svcLayerNum = r100;
            return this;
        }
    }

    public static final enum FrameType extends Enum<FrameType> {
        private static final /* synthetic */ FrameType[] $VALUES = null;
        public static final FrameType kBiPredicted = null;
        public static final FrameType kEmpty = null;
        public static final FrameType kIntra = null;
        public static final FrameType kLtrRecovery = null;
        public static final FrameType kPredicted = null;
        public static final FrameType kUnknow = null;
        private final int nativeIndex;

        static {
            FrameType r100 = new FrameType("kUnknow", 0, 0);
            kUnknow = r100;
            FrameType r101 = new FrameType("kIntra", 1, 1);
            kIntra = r101;
            FrameType r102 = new FrameType("kPredicted", 2, 2);
            kPredicted = r102;
            FrameType r103 = new FrameType("kBiPredicted", 3, 3);
            kBiPredicted = r103;
            FrameType r104 = new FrameType("kEmpty", 4, 4);
            kEmpty = r104;
            FrameType r105 = new FrameType("kLtrRecovery", 5, 5);
            kLtrRecovery = r105;
            $VALUES = new FrameType[]{r100, r101, r102, r103, r104, r105};
        }

        public static FrameType[] values() {
            return (FrameType[]) $VALUES.clone();
        }

        public int getNative() {
            return this.nativeIndex;
        }

        public static FrameType fromNativeIndex(int r100) {
            FrameType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            FrameType r104 = r101[r103];
            if (r104.getNative() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Unknown native frame type: " + r100);
        }

        public static FrameType valueOf(int r100) {
            FrameType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            FrameType r104 = r101[r103];
            if (r104.nativeIndex == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return kUnknow;
        }

        public static FrameType valueOf(String r100) {
            return (FrameType) r27.a.a(FrameType.class, r100);
        }

        private FrameType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeIndex = r102;
        }
    }

    public static Builder builder() {
        return new Builder(null);
    }

    private int getFrameType() {
        return this.frameType.getNative();
    }

    private ByteBuffer getBuffer() {
        return this.buffer;
    }

    private long getCaptureTimeNs() {
        return this.captureTimeNs;
    }

    private boolean getCompleteFrame() {
        return this.completeFrame;
    }

    private long getCompositionTimeUs() {
        return this.compositionTimeUs;
    }

    private int getEncodedHeight() {
        return this.encodedHeight;
    }

    private int getEncodedWidth() {
        return this.encodedWidth;
    }

    private Integer getQp() {
        return this.f267126qp;
    }

    private int getRotation() {
        return this.rotation;
    }

    private int getSvcLayerNum() {
        return this.svcLayerNum;
    }

    private EncodedImage(ByteBuffer r100, int r101, int r102, int r103, int r104, long r105, FrameType r106, int r107, boolean r110, Integer r111, int r112, long r113) {
        this.buffer = r100;
        this.encodedWidth = r101;
        this.encodedHeight = r102;
        this.actualWidth = r103;
        this.actualHeight = r104;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(r105);
        this.captureTimeNs = r105;
        this.frameType = r106;
        this.rotation = r107;
        this.completeFrame = r110;
        this.f267126qp = r111;
        this.svcLayerNum = r112;
        this.compositionTimeUs = r113;
    }

    public /* synthetic */ EncodedImage(ByteBuffer r100, int r101, int r102, int r103, int r104, long r105, FrameType r106, int r107, boolean r110, Integer r111, int r112, long r113, AnonymousClass1 r114) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113);
    }
}
