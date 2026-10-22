package androidx.camera.core.resolutionselector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ResolutionSelector {
    public static final int PREFER_CAPTURE_RATE_OVER_HIGHER_RESOLUTION = 0;
    public static final int PREFER_HIGHER_RESOLUTION_OVER_CAPTURE_RATE = 1;
    private final int mAllowedResolutionMode;
    private final AspectRatioStrategy mAspectRatioStrategy;
    private final ResolutionFilter mResolutionFilter;
    private final ResolutionStrategy mResolutionStrategy;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AllowedResolutionMode {
    }

    public static final class Builder {
        private int mAllowedResolutionMode;
        private AspectRatioStrategy mAspectRatioStrategy;
        private ResolutionFilter mResolutionFilter;
        private ResolutionStrategy mResolutionStrategy;

        public ResolutionSelector build() {
            return new ResolutionSelector(this.mAspectRatioStrategy, this.mResolutionStrategy, this.mResolutionFilter, this.mAllowedResolutionMode);
        }

        public Builder() {
            this.mAspectRatioStrategy = AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY;
            this.mResolutionStrategy = null;
            this.mResolutionFilter = null;
            this.mAllowedResolutionMode = 0;
        }

        private Builder(ResolutionSelector r2) {
            this.mAspectRatioStrategy = AspectRatioStrategy.RATIO_4_3_FALLBACK_AUTO_STRATEGY;
            this.mResolutionStrategy = null;
            this.mResolutionFilter = null;
            this.mAllowedResolutionMode = 0;
            this.mAspectRatioStrategy = r2.getAspectRatioStrategy();
            this.mResolutionStrategy = r2.getResolutionStrategy();
            this.mResolutionFilter = r2.getResolutionFilter();
            this.mAllowedResolutionMode = r2.getAllowedResolutionMode();
        }

        public static Builder fromResolutionSelector(ResolutionSelector r1) {
            return new Builder(r1);
        }

        public Builder setAllowedResolutionMode(int r1) {
            this.mAllowedResolutionMode = r1;
            return this;
        }

        public Builder setAspectRatioStrategy(AspectRatioStrategy r1) {
            this.mAspectRatioStrategy = r1;
            return this;
        }

        public Builder setResolutionFilter(ResolutionFilter r1) {
            this.mResolutionFilter = r1;
            return this;
        }

        public Builder setResolutionStrategy(ResolutionStrategy r1) {
            this.mResolutionStrategy = r1;
            return this;
        }
    }

    public int getAllowedResolutionMode() {
        return this.mAllowedResolutionMode;
    }

    public AspectRatioStrategy getAspectRatioStrategy() {
        return this.mAspectRatioStrategy;
    }

    public ResolutionFilter getResolutionFilter() {
        return this.mResolutionFilter;
    }

    public ResolutionStrategy getResolutionStrategy() {
        return this.mResolutionStrategy;
    }

    public ResolutionSelector(AspectRatioStrategy r1, ResolutionStrategy r2, ResolutionFilter r3, int r4) {
        this.mAspectRatioStrategy = r1;
        this.mResolutionStrategy = r2;
        this.mResolutionFilter = r3;
        this.mAllowedResolutionMode = r4;
    }
}
