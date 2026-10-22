package androidx.camera.video.internal.encoder;

import android.util.Size;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_VideoEncoderConfig extends VideoEncoderConfig {
    private final int IFrameInterval;
    private final int bitrate;
    private final int colorFormat;
    private final VideoEncoderDataSpace dataSpace;
    private final int frameRate;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;
    private final Size resolution;

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.AutoValue_VideoEncoderConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends VideoEncoderConfig.Builder {
        private Integer IFrameInterval;
        private Integer bitrate;
        private Integer colorFormat;
        private VideoEncoderDataSpace dataSpace;
        private Integer frameRate;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;
        private Size resolution;

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig build() {
            if (this.mimeType != null) goto L5;
            String r0 = " mimeType";
        L7:
            if (this.profile != null) goto L10;
            r0 = r0 + " profile";
        L10:
            if (this.inputTimebase != null) goto L13;
            r0 = r0 + " inputTimebase";
        L13:
            if (this.resolution != null) goto L16;
            r0 = r0 + " resolution";
        L16:
            if (this.colorFormat != null) goto L19;
            r0 = r0 + " colorFormat";
        L19:
            if (this.dataSpace != null) goto L22;
            r0 = r0 + " dataSpace";
        L22:
            if (this.frameRate != null) goto L25;
            r0 = r0 + " frameRate";
        L25:
            if (this.IFrameInterval != null) goto L28;
            r0 = r0 + " IFrameInterval";
        L28:
            if (this.bitrate != null) goto L31;
            r0 = r0 + " bitrate";
        L31:
            if (r0.isEmpty() == false) goto L35;
            return new AutoValue_VideoEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.resolution, this.colorFormat.intValue(), this.dataSpace, this.frameRate.intValue(), this.IFrameInterval.intValue(), this.bitrate.intValue(), null);
        L35:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setBitrate(int r1) {
            this.bitrate = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setColorFormat(int r1) {
            this.colorFormat = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setDataSpace(VideoEncoderDataSpace r2) {
            if (r2 == null) goto L6;
            this.dataSpace = r2;
            return this;
        L6:
            throw new NullPointerException("Null dataSpace");
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setFrameRate(int r1) {
            this.frameRate = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setIFrameInterval(int r1) {
            this.IFrameInterval = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setInputTimebase(Timebase r2) {
            if (r2 == null) goto L6;
            this.inputTimebase = r2;
            return this;
        L6:
            throw new NullPointerException("Null inputTimebase");
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setMimeType(String r2) {
            if (r2 == null) goto L6;
            this.mimeType = r2;
            return this;
        L6:
            throw new NullPointerException("Null mimeType");
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setProfile(int r1) {
            this.profile = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setResolution(Size r2) {
            if (r2 == null) goto L6;
            this.resolution = r2;
            return this;
        L6:
            throw new NullPointerException("Null resolution");
        }
    }

    public int hashCode() {
        return ((((((((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.resolution.hashCode()) * 1000003) ^ this.colorFormat) * 1000003) ^ this.dataSpace.hashCode()) * 1000003) ^ this.frameRate) * 1000003) ^ this.IFrameInterval) * 1000003) ^ this.bitrate;
    }

    public String toString() {
        return "VideoEncoderConfig{mimeType=" + this.mimeType + ", profile=" + this.profile + ", inputTimebase=" + this.inputTimebase + ", resolution=" + this.resolution + ", colorFormat=" + this.colorFormat + ", dataSpace=" + this.dataSpace + ", frameRate=" + this.frameRate + ", IFrameInterval=" + this.IFrameInterval + ", bitrate=" + this.bitrate + "}";
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getColorFormat() {
        return this.colorFormat;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public VideoEncoderDataSpace getDataSpace() {
        return this.dataSpace;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getIFrameInterval() {
        return this.IFrameInterval;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public Size getResolution() {
        return this.resolution;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoEncoderConfig) == false) goto L28;
        VideoEncoderConfig r6 = (VideoEncoderConfig) r5;
        if (this.mimeType.equals(r6.getMimeType()) == true) goto L10;
    L26:
        return false;
    L10:
        if (this.profile != r6.getProfile()) goto L26;
        if (this.inputTimebase.equals(r6.getInputTimebase()) == false) goto L26;
        if (this.resolution.equals(r6.getResolution()) == false) goto L26;
        if (this.colorFormat != r6.getColorFormat()) goto L26;
        if (this.dataSpace.equals(r6.getDataSpace()) == false) goto L26;
        if (this.frameRate != r6.getFrameRate()) goto L26;
        if (this.IFrameInterval != r6.getIFrameInterval()) goto L26;
        if (this.bitrate != r6.getBitrate()) goto L26;
        return true;
    L28:
        return false;
    }

    private AutoValue_VideoEncoderConfig(String r1, int r2, Timebase r3, Size r4, int r5, VideoEncoderDataSpace r6, int r7, int r8, int r9) {
        this.mimeType = r1;
        this.profile = r2;
        this.inputTimebase = r3;
        this.resolution = r4;
        this.colorFormat = r5;
        this.dataSpace = r6;
        this.frameRate = r7;
        this.IFrameInterval = r8;
        this.bitrate = r9;
    }

    public /* synthetic */ AutoValue_VideoEncoderConfig(String r1, int r2, Timebase r3, Size r4, int r5, VideoEncoderDataSpace r6, int r7, int r8, int r9, AnonymousClass1 r10) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
