package androidx.camera.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_MediaSpec extends MediaSpec {
    private final AudioSpec audioSpec;
    private final int outputFormat;
    private final VideoSpec videoSpec;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_MediaSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends MediaSpec.Builder {
        private AudioSpec audioSpec;
        private Integer outputFormat;
        private VideoSpec videoSpec;

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec build() {
            if (this.videoSpec != null) goto L5;
            String r0 = " videoSpec";
        L7:
            if (this.audioSpec != null) goto L10;
            r0 = r0 + " audioSpec";
        L10:
            if (this.outputFormat != null) goto L13;
            r0 = r0 + " outputFormat";
        L13:
            if (r0.isEmpty() == false) goto L17;
            return new AutoValue_MediaSpec(this.videoSpec, this.audioSpec, this.outputFormat.intValue(), null);
        L17:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public AudioSpec getAudioSpec() {
            AudioSpec r0 = this.audioSpec;
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new IllegalStateException("Property \"audioSpec\" has not been set");
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public VideoSpec getVideoSpec() {
            VideoSpec r0 = this.videoSpec;
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new IllegalStateException("Property \"videoSpec\" has not been set");
        }

        public Builder() {
        }

        private Builder(MediaSpec r2) {
            this.videoSpec = r2.getVideoSpec();
            this.audioSpec = r2.getAudioSpec();
            this.outputFormat = Integer.valueOf(r2.getOutputFormat());
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setAudioSpec(AudioSpec r2) {
            if (r2 == null) goto L6;
            this.audioSpec = r2;
            return this;
        L6:
            throw new NullPointerException("Null audioSpec");
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setOutputFormat(int r1) {
            this.outputFormat = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setVideoSpec(VideoSpec r2) {
            if (r2 == null) goto L6;
            this.videoSpec = r2;
            return this;
        L6:
            throw new NullPointerException("Null videoSpec");
        }

        public /* synthetic */ Builder(MediaSpec r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public int hashCode() {
        return ((((this.videoSpec.hashCode() ^ 1000003) * 1000003) ^ this.audioSpec.hashCode()) * 1000003) ^ this.outputFormat;
    }

    @Override // androidx.camera.video.MediaSpec
    public MediaSpec.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "MediaSpec{videoSpec=" + this.videoSpec + ", audioSpec=" + this.audioSpec + ", outputFormat=" + this.outputFormat + "}";
    }

    @Override // androidx.camera.video.MediaSpec
    public AudioSpec getAudioSpec() {
        return this.audioSpec;
    }

    @Override // androidx.camera.video.MediaSpec
    public int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.video.MediaSpec
    public VideoSpec getVideoSpec() {
        return this.videoSpec;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof MediaSpec) == false) goto L16;
        MediaSpec r6 = (MediaSpec) r5;
        if (this.videoSpec.equals(r6.getVideoSpec()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.audioSpec.equals(r6.getAudioSpec()) == false) goto L14;
        if (this.outputFormat != r6.getOutputFormat()) goto L14;
        return true;
    L16:
        return false;
    }

    private AutoValue_MediaSpec(VideoSpec r1, AudioSpec r2, int r3) {
        this.videoSpec = r1;
        this.audioSpec = r2;
        this.outputFormat = r3;
    }

    public /* synthetic */ AutoValue_MediaSpec(VideoSpec r1, AudioSpec r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }
}
