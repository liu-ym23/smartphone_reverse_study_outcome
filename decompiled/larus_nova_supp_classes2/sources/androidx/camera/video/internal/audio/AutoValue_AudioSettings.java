package androidx.camera.video.internal.audio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_AudioSettings extends AudioSettings {
    private final int audioFormat;
    private final int audioSource;
    private final int channelCount;
    private final int sampleRate;

    /* JADX INFO: renamed from: androidx.camera.video.internal.audio.AutoValue_AudioSettings$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends AudioSettings.Builder {
        private Integer audioFormat;
        private Integer audioSource;
        private Integer channelCount;
        private Integer sampleRate;

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings autoBuild() {
            if (this.audioSource != null) goto L5;
            String r0 = " audioSource";
        L7:
            if (this.sampleRate != null) goto L10;
            r0 = r0 + " sampleRate";
        L10:
            if (this.channelCount != null) goto L13;
            r0 = r0 + " channelCount";
        L13:
            if (this.audioFormat != null) goto L16;
            r0 = r0 + " audioFormat";
        L16:
            if (r0.isEmpty() == false) goto L20;
            return new AutoValue_AudioSettings(this.audioSource.intValue(), this.sampleRate.intValue(), this.channelCount.intValue(), this.audioFormat.intValue(), null);
        L20:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        private Builder(AudioSettings r2) {
            this.audioSource = Integer.valueOf(r2.getAudioSource());
            this.sampleRate = Integer.valueOf(r2.getSampleRate());
            this.channelCount = Integer.valueOf(r2.getChannelCount());
            this.audioFormat = Integer.valueOf(r2.getAudioFormat());
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setAudioFormat(int r1) {
            this.audioFormat = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setAudioSource(int r1) {
            this.audioSource = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setChannelCount(int r1) {
            this.channelCount = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setSampleRate(int r1) {
            this.sampleRate = Integer.valueOf(r1);
            return this;
        }

        public /* synthetic */ Builder(AudioSettings r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public int hashCode() {
        return ((((((this.audioSource ^ 1000003) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channelCount) * 1000003) ^ this.audioFormat;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public AudioSettings.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "AudioSettings{audioSource=" + this.audioSource + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", audioFormat=" + this.audioFormat + "}";
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getAudioFormat() {
        return this.audioFormat;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getAudioSource() {
        return this.audioSource;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioSettings) == false) goto L18;
        AudioSettings r6 = (AudioSettings) r5;
        if (this.audioSource == r6.getAudioSource()) goto L10;
    L16:
        return false;
    L10:
        if (this.sampleRate != r6.getSampleRate()) goto L16;
        if (this.channelCount != r6.getChannelCount()) goto L16;
        if (this.audioFormat != r6.getAudioFormat()) goto L16;
        return true;
    L18:
        return false;
    }

    private AutoValue_AudioSettings(int r1, int r2, int r3, int r4) {
        this.audioSource = r1;
        this.sampleRate = r2;
        this.channelCount = r3;
        this.audioFormat = r4;
    }

    public /* synthetic */ AutoValue_AudioSettings(int r1, int r2, int r3, int r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }
}
