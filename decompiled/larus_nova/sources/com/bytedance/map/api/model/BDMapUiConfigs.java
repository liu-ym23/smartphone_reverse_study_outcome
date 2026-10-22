package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public final class BDMapUiConfigs {
    private final Boolean allGesturesEnabled;
    private final Boolean compassEnabled;
    private final Boolean gestureScaleByMapCenter;
    private final Boolean indoorSwitchEnabled;
    private final Integer logoBottomMarginPx;
    private final Integer logoLeftMarginPx;
    private final Integer logoPosition;
    private final Boolean myLocationButtonEnabled;
    private final Boolean rotateGesturesEnabled;
    private final Boolean scaleControlsEnabled;
    private final Boolean scrollGesturesEnabled;
    private final Boolean tiltGesturesEnabled;
    private final Boolean zoomControlsEnabled;
    private final Boolean zoomGesturesEnabled;
    private final Boolean zoomInByScreenCenter;
    private final Integer zoomPosition;

    /* JADX INFO: renamed from: com.bytedance.map.api.model.BDMapUiConfigs$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Boolean allGesturesEnabled;
        private Boolean compassEnabled;
        private Boolean gestureScaleByMapCenter;
        private Boolean indoorSwitchEnabled;
        private Integer logoBottomMarginPx;
        private Integer logoLeftMarginPx;
        private Integer logoPosition;
        private Boolean myLocationButtonEnabled;
        private Boolean rotateGesturesEnabled;
        private Boolean scaleControlsEnabled;
        private Boolean scrollGesturesEnabled;
        private Boolean tiltGesturesEnabled;
        private Boolean zoomControlsEnabled;
        private Boolean zoomGesturesEnabled;
        private Boolean zoomInByScreenCenter;
        private Integer zoomPosition;

        public Builder() {
        }

        public BDMapUiConfigs build() {
            return new BDMapUiConfigs(this, null);
        }

        public static /* synthetic */ Boolean access$000(Builder r100) {
            return r100.scaleControlsEnabled;
        }

        public static /* synthetic */ Boolean access$100(Builder r100) {
            return r100.zoomControlsEnabled;
        }

        public static /* synthetic */ Integer access$1000(Builder r100) {
            return r100.logoPosition;
        }

        public static /* synthetic */ Integer access$1100(Builder r100) {
            return r100.zoomPosition;
        }

        public static /* synthetic */ Boolean access$1200(Builder r100) {
            return r100.indoorSwitchEnabled;
        }

        public static /* synthetic */ Integer access$1300(Builder r100) {
            return r100.logoLeftMarginPx;
        }

        public static /* synthetic */ Integer access$1400(Builder r100) {
            return r100.logoBottomMarginPx;
        }

        public static /* synthetic */ Boolean access$1500(Builder r100) {
            return r100.zoomInByScreenCenter;
        }

        public static /* synthetic */ Boolean access$200(Builder r100) {
            return r100.myLocationButtonEnabled;
        }

        public static /* synthetic */ Boolean access$300(Builder r100) {
            return r100.compassEnabled;
        }

        public static /* synthetic */ Boolean access$400(Builder r100) {
            return r100.allGesturesEnabled;
        }

        public static /* synthetic */ Boolean access$500(Builder r100) {
            return r100.rotateGesturesEnabled;
        }

        public static /* synthetic */ Boolean access$600(Builder r100) {
            return r100.zoomGesturesEnabled;
        }

        public static /* synthetic */ Boolean access$700(Builder r100) {
            return r100.scrollGesturesEnabled;
        }

        public static /* synthetic */ Boolean access$800(Builder r100) {
            return r100.tiltGesturesEnabled;
        }

        public static /* synthetic */ Boolean access$900(Builder r100) {
            return r100.gestureScaleByMapCenter;
        }

        public Builder setAllGesturesEnabled(boolean r100) {
            this.allGesturesEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setCompassEnabled(boolean r100) {
            this.compassEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setGestureScaleByMapCenter(boolean r100) {
            this.gestureScaleByMapCenter = Boolean.valueOf(r100);
            return this;
        }

        public Builder setIndoorSwitchEnabled(boolean r100) {
            this.indoorSwitchEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setLogoBottomMargin(int r100) {
            this.logoBottomMarginPx = Integer.valueOf(r100);
            return this;
        }

        public Builder setLogoLeftMargin(int r100) {
            this.logoLeftMarginPx = Integer.valueOf(r100);
            return this;
        }

        public Builder setLogoPosition(int r100) {
            this.logoPosition = Integer.valueOf(r100);
            return this;
        }

        public Builder setMyLocationButtonEnabled(boolean r100) {
            this.myLocationButtonEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setRotateGesturesEnabled(boolean r100) {
            this.rotateGesturesEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setScaleControlsEnabled(boolean r100) {
            this.scaleControlsEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setScrollGesturesEnabled(boolean r100) {
            this.scrollGesturesEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setTiltGesturesEnabled(boolean r100) {
            this.tiltGesturesEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setZoomControlsEnabled(boolean r100) {
            this.zoomControlsEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setZoomGesturesEnabled(boolean r100) {
            this.zoomGesturesEnabled = Boolean.valueOf(r100);
            return this;
        }

        public Builder setZoomInByScreenCenter(boolean r100) {
            this.zoomInByScreenCenter = Boolean.valueOf(r100);
            return this;
        }

        public Builder setZoomPosition(int r100) {
            this.zoomPosition = Integer.valueOf(r100);
            return this;
        }
    }

    public Boolean getAllGesturesEnabled() {
        return this.allGesturesEnabled;
    }

    public Boolean getCompassEnabled() {
        return this.compassEnabled;
    }

    public Boolean getGestureScaleByMapCenter() {
        return this.gestureScaleByMapCenter;
    }

    public Boolean getIndoorSwitchEnabled() {
        return this.indoorSwitchEnabled;
    }

    public Integer getLogoBottomMargin() {
        return this.logoBottomMarginPx;
    }

    public Integer getLogoLeftMargin() {
        return this.logoLeftMarginPx;
    }

    public Integer getLogoPosition() {
        return this.logoPosition;
    }

    public Boolean getMyLocationButtonEnabled() {
        return this.myLocationButtonEnabled;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.rotateGesturesEnabled;
    }

    public Boolean getScaleControlsEnabled() {
        return this.scaleControlsEnabled;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.scrollGesturesEnabled;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.tiltGesturesEnabled;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zoomControlsEnabled;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zoomGesturesEnabled;
    }

    public Boolean getZoomInByScreenCenter() {
        return this.zoomInByScreenCenter;
    }

    public Integer getZoomPosition() {
        return this.zoomPosition;
    }

    private BDMapUiConfigs(Builder r100) {
        this.scaleControlsEnabled = Builder.access$000(r100);
        this.zoomControlsEnabled = Builder.access$100(r100);
        this.myLocationButtonEnabled = Builder.access$200(r100);
        this.compassEnabled = Builder.access$300(r100);
        this.allGesturesEnabled = Builder.access$400(r100);
        this.rotateGesturesEnabled = Builder.access$500(r100);
        this.zoomGesturesEnabled = Builder.access$600(r100);
        this.scrollGesturesEnabled = Builder.access$700(r100);
        this.tiltGesturesEnabled = Builder.access$800(r100);
        this.gestureScaleByMapCenter = Builder.access$900(r100);
        this.logoPosition = Builder.access$1000(r100);
        this.zoomPosition = Builder.access$1100(r100);
        this.indoorSwitchEnabled = Builder.access$1200(r100);
        this.logoLeftMarginPx = Builder.access$1300(r100);
        this.logoBottomMarginPx = Builder.access$1400(r100);
        this.zoomInByScreenCenter = Builder.access$1500(r100);
    }

    public /* synthetic */ BDMapUiConfigs(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
