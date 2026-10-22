package androidx.camera.video;

import android.util.Range;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_AudioSpec extends AudioSpec {
    private final Range<Integer> bitrate;
    private final int channelCount;
    private final Range<Integer> sampleRate;
    private final int source;
    private final int sourceFormat;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_AudioSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends AudioSpec.Builder {
        private Range<Integer> bitrate;
        private Integer channelCount;
        private Range<Integer> sampleRate;
        private Integer source;
        private Integer sourceFormat;

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec build() {
            if (this.bitrate != null) goto L5;
            String r0 = " bitrate";
        L7:
            if (this.sourceFormat != null) goto L10;
            r0 = r0 + " sourceFormat";
        L10:
            if (this.source != null) goto L13;
            r0 = r0 + " source";
        L13:
            if (this.sampleRate != null) goto L16;
            r0 = r0 + " sampleRate";
        L16:
            if (this.channelCount != null) goto L19;
            r0 = r0 + " channelCount";
        L19:
            if (r0.isEmpty() == false) goto L23;
            return new AutoValue_AudioSpec(this.bitrate, this.sourceFormat.intValue(), this.source.intValue(), this.sampleRate, this.channelCount.intValue(), null);
        L23:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        private Builder(AudioSpec r2) {
            this.bitrate = r2.getBitrate();
            this.sourceFormat = Integer.valueOf(r2.getSourceFormat());
            this.source = Integer.valueOf(r2.getSource());
            this.sampleRate = r2.getSampleRate();
            this.channelCount = Integer.valueOf(r2.getChannelCount());
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setBitrate(Range<Integer> r2) {
            if (r2 == null) goto L6;
            this.bitrate = r2;
            return this;
        L6:
            throw new NullPointerException("Null bitrate");
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setChannelCount(int r1) {
            this.channelCount = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setSampleRate(Range<Integer> r2) {
            if (r2 == null) goto L6;
            this.sampleRate = r2;
            return this;
        L6:
            throw new NullPointerException("Null sampleRate");
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setSource(int r1) {
            this.source = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.AudioSpec.Builder
        public AudioSpec.Builder setSourceFormat(int r1) {
            this.sourceFormat = Integer.valueOf(r1);
            return this;
        }

        public /* synthetic */ Builder(AudioSpec r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public int hashCode() {
        return ((((((((this.bitrate.hashCode() ^ 1000003) * 1000003) ^ this.sourceFormat) * 1000003) ^ this.source) * 1000003) ^ this.sampleRate.hashCode()) * 1000003) ^ this.channelCount;
    }

    @Override // androidx.camera.video.AudioSpec
    public AudioSpec.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "AudioSpec{bitrate=" + this.bitrate + ", sourceFormat=" + this.sourceFormat + ", source=" + this.source + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + "}";
    }

    @Override // androidx.camera.video.AudioSpec
    public Range<Integer> getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.AudioSpec
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.AudioSpec
    public Range<Integer> getSampleRate() {
        return this.sampleRate;
    }

    @Override // androidx.camera.video.AudioSpec
    public int getSource() {
        return this.source;
    }

    @Override // androidx.camera.video.AudioSpec
    public int getSourceFormat() {
        return this.sourceFormat;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AudioSpec) == false) goto L20;
        AudioSpec r6 = (AudioSpec) r5;
        if (this.bitrate.equals(r6.getBitrate()) == true) goto L10;
    L18:
        return false;
    L10:
        if (this.sourceFormat != r6.getSourceFormat()) goto L18;
        if (this.source != r6.getSource()) goto L18;
        if (this.sampleRate.equals(r6.getSampleRate()) == false) goto L18;
        if (this.channelCount != r6.getChannelCount()) goto L18;
        return true;
    L20:
        return false;
    }

    private AutoValue_AudioSpec(Range<Integer> r1, int r2, int r3, Range<Integer> r4, int r5) {
        this.bitrate = r1;
        this.sourceFormat = r2;
        this.source = r3;
        this.sampleRate = r4;
        this.channelCount = r5;
    }

    public /* synthetic */ AutoValue_AudioSpec(Range r1, int r2, int r3, Range r4, int r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }
}
