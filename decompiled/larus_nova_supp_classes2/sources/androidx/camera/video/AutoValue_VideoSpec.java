package androidx.camera.video;

import android.util.Range;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_VideoSpec extends VideoSpec {
    private final int aspectRatio;
    private final Range<Integer> bitrate;
    private final Range<Integer> frameRate;
    private final QualitySelector qualitySelector;

    /* JADX INFO: renamed from: androidx.camera.video.AutoValue_VideoSpec$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends VideoSpec.Builder {
        private Integer aspectRatio;
        private Range<Integer> bitrate;
        private Range<Integer> frameRate;
        private QualitySelector qualitySelector;

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec build() {
            if (this.qualitySelector != null) goto L5;
            String r0 = " qualitySelector";
        L7:
            if (this.frameRate != null) goto L10;
            r0 = r0 + " frameRate";
        L10:
            if (this.bitrate != null) goto L13;
            r0 = r0 + " bitrate";
        L13:
            if (this.aspectRatio != null) goto L16;
            r0 = r0 + " aspectRatio";
        L16:
            if (r0.isEmpty() == false) goto L20;
            return new AutoValue_VideoSpec(this.qualitySelector, this.frameRate, this.bitrate, this.aspectRatio.intValue(), null);
        L20:
            throw new IllegalStateException("Missing required properties:".concat(r0));
        L5:
            r0 = "";
            goto L7
        }

        public Builder() {
        }

        private Builder(VideoSpec r2) {
            this.qualitySelector = r2.getQualitySelector();
            this.frameRate = r2.getFrameRate();
            this.bitrate = r2.getBitrate();
            this.aspectRatio = Integer.valueOf(r2.getAspectRatio());
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setAspectRatio(int r1) {
            this.aspectRatio = Integer.valueOf(r1);
            return this;
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setBitrate(Range<Integer> r2) {
            if (r2 == null) goto L6;
            this.bitrate = r2;
            return this;
        L6:
            throw new NullPointerException("Null bitrate");
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setFrameRate(Range<Integer> r2) {
            if (r2 == null) goto L6;
            this.frameRate = r2;
            return this;
        L6:
            throw new NullPointerException("Null frameRate");
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setQualitySelector(QualitySelector r2) {
            if (r2 == null) goto L6;
            this.qualitySelector = r2;
            return this;
        L6:
            throw new NullPointerException("Null qualitySelector");
        }

        public /* synthetic */ Builder(VideoSpec r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public int hashCode() {
        return ((((((this.qualitySelector.hashCode() ^ 1000003) * 1000003) ^ this.frameRate.hashCode()) * 1000003) ^ this.bitrate.hashCode()) * 1000003) ^ this.aspectRatio;
    }

    @Override // androidx.camera.video.VideoSpec
    public VideoSpec.Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "VideoSpec{qualitySelector=" + this.qualitySelector + ", frameRate=" + this.frameRate + ", bitrate=" + this.bitrate + ", aspectRatio=" + this.aspectRatio + "}";
    }

    @Override // androidx.camera.video.VideoSpec
    public int getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.camera.video.VideoSpec
    public Range<Integer> getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.VideoSpec
    public Range<Integer> getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.video.VideoSpec
    public QualitySelector getQualitySelector() {
        return this.qualitySelector;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoSpec) == false) goto L18;
        VideoSpec r6 = (VideoSpec) r5;
        if (this.qualitySelector.equals(r6.getQualitySelector()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.frameRate.equals(r6.getFrameRate()) == false) goto L16;
        if (this.bitrate.equals(r6.getBitrate()) == false) goto L16;
        if (this.aspectRatio != r6.getAspectRatio()) goto L16;
        return true;
    L18:
        return false;
    }

    private AutoValue_VideoSpec(QualitySelector r1, Range<Integer> r2, Range<Integer> r3, int r4) {
        this.qualitySelector = r1;
        this.frameRate = r2;
        this.bitrate = r3;
        this.aspectRatio = r4;
    }

    public /* synthetic */ AutoValue_VideoSpec(QualitySelector r1, Range r2, Range r3, int r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }
}
