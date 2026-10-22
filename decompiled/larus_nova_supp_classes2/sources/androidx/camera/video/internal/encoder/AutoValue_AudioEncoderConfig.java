package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_AudioEncoderConfig extends AudioEncoderConfig {
    private final int bitrate;
    private final int channelCount;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;
    private final int sampleRate;

    /* JADX INFO: renamed from: androidx.camera.video.internal.encoder.AutoValue_AudioEncoderConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends AudioEncoderConfig.Builder {
        private Integer bitrate;
        private Integer channelCount;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;
        private Integer sampleRate;

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig autoBuild() {
            if (this.mimeType != null) goto L5;
            String r0 = " mimeType";
        L7:
            if (this.profile != null) goto L10;
            r0 = r0 + " profile";
        L10:
            if (this.inputTimebase != null) goto L13;
            r0 = r0 + " inputTimebase";
        L13:
            if (this.bitrate != null) goto L16;
            r0 = r0 + " bitrate";
        L16:
            if (this.sampleRate != null) goto L19;
            r0 = r0 + " sampleRate";
        L19:
            if (this.channelCount != null) goto L22;
            r0 = r0 + " channelCount";
        L22:
            if (r0.isEmpty() == false) goto L26;
            return new AutoValue_AudioEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.bitrate.intValue(), this.sampleRate.intValue(), this.channelCount.intValue(), null);
        L26:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setBitrate(int r1) {
            this.bitrate = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setChannelCount(int r1) {
            this.channelCount = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setInputTimebase(Timebase r2) {
            if (r2 == null) goto L6;
            this.inputTimebase = r2;
            return this;
        L6:
            throw new NullPointerException("Null inputTimebase");
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setMimeType(String r2) {
            if (r2 == null) goto L6;
            this.mimeType = r2;
            return this;
        L6:
            throw new NullPointerException("Null mimeType");
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setProfile(int r1) {
            this.profile = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setSampleRate(int r1) {
            this.sampleRate = Integer.valueOf(r1);
            return this;
        }
    }

    public int hashCode() {
        return ((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channelCount;
    }

    public String toString() {
        return "AudioEncoderConfig{mimeType=" + this.mimeType + ", profile=" + this.profile + ", inputTimebase=" + this.inputTimebase + ", bitrate=" + this.bitrate + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + "}";
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioEncoderConfig) == false) goto L22;
        AudioEncoderConfig r6 = (AudioEncoderConfig) r5;
        if (this.mimeType.equals(r6.getMimeType()) == true) goto L10;
    L20:
        return false;
    L10:
        if (this.profile != r6.getProfile()) goto L20;
        if (this.inputTimebase.equals(r6.getInputTimebase()) == false) goto L20;
        if (this.bitrate != r6.getBitrate()) goto L20;
        if (this.sampleRate != r6.getSampleRate()) goto L20;
        if (this.channelCount != r6.getChannelCount()) goto L20;
        return true;
    L22:
        return false;
    }

    private AutoValue_AudioEncoderConfig(String r1, int r2, Timebase r3, int r4, int r5, int r6) {
        this.mimeType = r1;
        this.profile = r2;
        this.inputTimebase = r3;
        this.bitrate = r4;
        this.sampleRate = r5;
        this.channelCount = r6;
    }

    public /* synthetic */ AutoValue_AudioEncoderConfig(String r1, int r2, Timebase r3, int r4, int r5, int r6, AnonymousClass1 r7) {
        this(r1, r2, r3, r4, r5, r6);
    }
}
