package com.bytedance.map.api;

import android.content.Context;
import com.bytedance.map.api.model.BDLatLng;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class MapInitConfig {
    private String mBizName;
    private BDLatLng mCenter;
    private Context mContext;
    private Map<String, Object> mExtraParams;
    private boolean mIsCompassEnabled;
    private boolean mIsLoadCustomMapStyleFromAssets;
    private boolean mIsRotateGesturesEnabled;
    private boolean mIsScaleControlsEnabled;
    private boolean mIsScrollGesturesEnabled;
    private boolean mIsTiltGesturesEnabled;
    private boolean mIsTrafficEnabled;
    private boolean mIsZoomControlsEnabled;
    private boolean mIsZoomGesturesEnabled;
    private int mMapContainer;
    private int mMapStyle;
    private int mMapType;
    private boolean mShowScaleControl;
    private float mZoom;

    public static class Builder {
        private String mBizName;
        private BDLatLng mCenter;
        private Context mContext;
        private Map<String, Object> mExtraParams;
        private boolean mIsCompassEnabled;
        private boolean mIsLoadCustomMapStyleFromAssets;
        private boolean mIsRotateGesturesEnabled;
        private boolean mIsScaleControlsEnabled;
        private boolean mIsScrollGesturesEnabled;
        private boolean mIsTiltGesturesEnabled;
        private boolean mIsTrafficEnabled;
        private boolean mIsZoomControlsEnabled;
        private boolean mIsZoomGesturesEnabled;
        private int mMapContainer;
        int mMapStyle;
        private int mMapType;
        private boolean mShowScaleControl;
        float mZoom;

        public MapInitConfig build() {
            if (this.mContext == null) goto L7;
            return new MapInitConfig(this);
        L7:
            throw new IllegalArgumentException("Context is empty!");
        }

        public Builder(Context r100) {
            this.mMapType = 1;
            this.mMapContainer = 0;
            this.mZoom = 10.0f;
            this.mMapStyle = 1;
            this.mIsTrafficEnabled = false;
            this.mIsScaleControlsEnabled = false;
            this.mIsZoomControlsEnabled = false;
            this.mIsCompassEnabled = false;
            this.mShowScaleControl = false;
            this.mIsZoomGesturesEnabled = true;
            this.mIsScrollGesturesEnabled = true;
            this.mIsRotateGesturesEnabled = false;
            this.mIsTiltGesturesEnabled = false;
            this.mIsLoadCustomMapStyleFromAssets = true;
            this.mContext = r100;
        }

        public static /* synthetic */ Context access$000(Builder r100) {
            return r100.mContext;
        }

        public static /* synthetic */ int access$100(Builder r100) {
            return r100.mMapType;
        }

        public static /* synthetic */ boolean access$1000(Builder r100) {
            return r100.mIsScrollGesturesEnabled;
        }

        public static /* synthetic */ boolean access$1100(Builder r100) {
            return r100.mIsRotateGesturesEnabled;
        }

        public static /* synthetic */ boolean access$1200(Builder r100) {
            return r100.mIsTiltGesturesEnabled;
        }

        public static /* synthetic */ boolean access$1300(Builder r100) {
            return r100.mIsLoadCustomMapStyleFromAssets;
        }

        public static /* synthetic */ String access$1400(Builder r100) {
            return r100.mBizName;
        }

        public static /* synthetic */ Map access$1500(Builder r100) {
            return r100.mExtraParams;
        }

        public static /* synthetic */ int access$200(Builder r100) {
            return r100.mMapContainer;
        }

        public static /* synthetic */ BDLatLng access$300(Builder r100) {
            return r100.mCenter;
        }

        public static /* synthetic */ boolean access$400(Builder r100) {
            return r100.mIsTrafficEnabled;
        }

        public static /* synthetic */ boolean access$500(Builder r100) {
            return r100.mIsScaleControlsEnabled;
        }

        public static /* synthetic */ boolean access$600(Builder r100) {
            return r100.mIsZoomControlsEnabled;
        }

        public static /* synthetic */ boolean access$700(Builder r100) {
            return r100.mIsCompassEnabled;
        }

        public static /* synthetic */ boolean access$800(Builder r100) {
            return r100.mShowScaleControl;
        }

        public static /* synthetic */ boolean access$900(Builder r100) {
            return r100.mIsZoomGesturesEnabled;
        }

        public Builder setBizName(String r100) {
            this.mBizName = r100;
            return this;
        }

        public Builder setCenter(BDLatLng r100) {
            this.mCenter = r100;
            return this;
        }

        public Builder setCompassEnabled(boolean r100) {
            this.mIsCompassEnabled = r100;
            return this;
        }

        public Builder setExtraParams(Map<String, Object> r100) {
            this.mExtraParams = r100;
            return this;
        }

        public Builder setLoadCustomMapStyleFromAssets(boolean r100) {
            this.mIsLoadCustomMapStyleFromAssets = r100;
            return this;
        }

        public Builder setMapContainer(int r100) {
            this.mMapContainer = r100;
            return this;
        }

        public Builder setMapStyle(int r100) {
            this.mMapStyle = r100;
            return this;
        }

        public Builder setMapType(int r100) {
            this.mMapType = r100;
            return this;
        }

        public Builder setRotateGesturesEnabled(boolean r100) {
            this.mIsRotateGesturesEnabled = r100;
            return this;
        }

        public Builder setScaleControlsEnabled(boolean r100) {
            this.mIsScaleControlsEnabled = r100;
            return this;
        }

        public Builder setScrollGesturesEnabled(boolean r100) {
            this.mIsScrollGesturesEnabled = r100;
            return this;
        }

        public Builder setShowScaleControl(boolean r100) {
            this.mShowScaleControl = r100;
            return this;
        }

        public Builder setTiltGesturesEnabled(boolean r100) {
            this.mIsTiltGesturesEnabled = r100;
            return this;
        }

        public Builder setTrafficEnabled(boolean r100) {
            this.mIsTrafficEnabled = r100;
            return this;
        }

        public Builder setZoom(float r100) {
            this.mZoom = r100;
            return this;
        }

        public Builder setZoomControlsEnabled(boolean r100) {
            this.mIsZoomControlsEnabled = r100;
            return this;
        }

        public Builder setZoomGesturesEnabled(boolean r100) {
            this.mIsZoomGesturesEnabled = r100;
            return this;
        }
    }

    public String getBizName() {
        return this.mBizName;
    }

    public BDLatLng getCenter() {
        return this.mCenter;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Map<String, Object> getExtraParams() {
        return this.mExtraParams;
    }

    public int getMapContainer() {
        return this.mMapContainer;
    }

    public int getMapStyle() {
        return this.mMapStyle;
    }

    public int getMapType() {
        return this.mMapType;
    }

    public float getZoom() {
        return this.mZoom;
    }

    public boolean isCompassEnabled() {
        return this.mIsCompassEnabled;
    }

    public boolean isLoadCustomMapStyleFromAssets() {
        return this.mIsLoadCustomMapStyleFromAssets;
    }

    public boolean isRotateGesturesEnabled() {
        return this.mIsRotateGesturesEnabled;
    }

    public boolean isScaleControlsEnabled() {
        return this.mIsScaleControlsEnabled;
    }

    public boolean isScrollGesturesEnabled() {
        return this.mIsScrollGesturesEnabled;
    }

    public boolean isShowScaleControl() {
        return this.mShowScaleControl;
    }

    public boolean isTiltGesturesEnabled() {
        return this.mIsTiltGesturesEnabled;
    }

    public boolean isTrafficEnabled() {
        return this.mIsTrafficEnabled;
    }

    public boolean isZoomControlsEnabled() {
        return this.mIsZoomControlsEnabled;
    }

    public boolean isZoomGesturesEnabled() {
        return this.mIsZoomGesturesEnabled;
    }

    public MapInitConfig(Builder r100) {
        this.mMapType = 1;
        this.mMapContainer = 0;
        this.mZoom = 10.0f;
        this.mMapStyle = 1;
        this.mIsTrafficEnabled = false;
        this.mIsScaleControlsEnabled = false;
        this.mIsZoomControlsEnabled = false;
        this.mIsCompassEnabled = false;
        this.mShowScaleControl = false;
        this.mIsZoomGesturesEnabled = true;
        this.mIsScrollGesturesEnabled = true;
        this.mIsRotateGesturesEnabled = false;
        this.mIsTiltGesturesEnabled = false;
        this.mIsLoadCustomMapStyleFromAssets = true;
        this.mContext = Builder.access$000(r100);
        this.mMapType = Builder.access$100(r100);
        this.mMapContainer = Builder.access$200(r100);
        this.mCenter = Builder.access$300(r100);
        this.mZoom = r100.mZoom;
        this.mMapStyle = r100.mMapStyle;
        this.mIsTrafficEnabled = Builder.access$400(r100);
        this.mIsScaleControlsEnabled = Builder.access$500(r100);
        this.mIsZoomControlsEnabled = Builder.access$600(r100);
        this.mIsCompassEnabled = Builder.access$700(r100);
        this.mShowScaleControl = Builder.access$800(r100);
        this.mIsZoomGesturesEnabled = Builder.access$900(r100);
        this.mIsScrollGesturesEnabled = Builder.access$1000(r100);
        this.mIsRotateGesturesEnabled = Builder.access$1100(r100);
        this.mIsTiltGesturesEnabled = Builder.access$1200(r100);
        this.mIsLoadCustomMapStyleFromAssets = Builder.access$1300(r100);
        this.mBizName = Builder.access$1400(r100);
        this.mExtraParams = Builder.access$1500(r100);
    }

    public void setBizName(String r100) {
        this.mBizName = r100;
    }

    public void setCenter(BDLatLng r100) {
        this.mCenter = r100;
    }

    public void setCompassEnabled(boolean r100) {
        this.mIsCompassEnabled = r100;
    }

    public void setContext(Context r100) {
        this.mContext = r100;
    }

    public void setExtraParams(Map<String, Object> r100) {
        this.mExtraParams = r100;
    }

    public void setLoadCustomMapStyleFromAssets(boolean r100) {
        this.mIsLoadCustomMapStyleFromAssets = r100;
    }

    public void setMapContainer(int r100) {
        this.mMapContainer = r100;
    }

    public void setMapStyle(int r100) {
        this.mMapStyle = r100;
    }

    public void setMapType(int r100) {
        this.mMapType = r100;
    }

    public void setRotateGesturesEnabled(boolean r100) {
        this.mIsRotateGesturesEnabled = r100;
    }

    public void setScaleControlsEnabled(boolean r100) {
        this.mIsScaleControlsEnabled = r100;
    }

    public void setScrollGesturesEnabled(boolean r100) {
        this.mIsScrollGesturesEnabled = r100;
    }

    public void setShowScaleControl(boolean r100) {
        this.mShowScaleControl = r100;
    }

    public void setTiltGesturesEnabled(boolean r100) {
        this.mIsTiltGesturesEnabled = r100;
    }

    public void setTrafficEnabled(boolean r100) {
        this.mIsTrafficEnabled = r100;
    }

    public void setZoom(float r100) {
        this.mZoom = r100;
    }

    public void setZoomControlsEnabled(boolean r100) {
        this.mIsZoomControlsEnabled = r100;
    }

    public void setZoomGesturesEnabled(boolean r100) {
        this.mIsZoomGesturesEnabled = r100;
    }
}
