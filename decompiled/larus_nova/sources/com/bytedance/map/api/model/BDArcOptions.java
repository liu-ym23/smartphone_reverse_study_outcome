package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public class BDArcOptions {
    private int mColor;
    private BDLatLng mEndLatLng;
    private String mId;
    private BDLatLng mMiddleLatLng;
    private BDLatLng mStartLatLng;
    private boolean mVisible;
    private int mWidth;
    private float mZIndex;

    public BDArcOptions() {
        this.mVisible = true;
    }

    public int getColor() {
        return this.mColor;
    }

    public BDLatLng getEndLatLng() {
        return this.mEndLatLng;
    }

    public String getId() {
        return this.mId;
    }

    public BDLatLng getMiddleLatLng() {
        return this.mMiddleLatLng;
    }

    public BDLatLng getStartLatLng() {
        return this.mStartLatLng;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public BDArcOptions color(int r100) {
        this.mColor = r100;
        return this;
    }

    public BDArcOptions end(BDLatLng r100) {
        this.mEndLatLng = r100;
        return this;
    }

    public BDArcOptions middle(BDLatLng r100) {
        this.mMiddleLatLng = r100;
        return this;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public BDArcOptions start(BDLatLng r100) {
        this.mStartLatLng = r100;
        return this;
    }

    public BDArcOptions visible(boolean r100) {
        this.mVisible = r100;
        return this;
    }

    public BDArcOptions width(int r100) {
        this.mWidth = r100;
        return this;
    }

    public BDArcOptions zIndex(float r100) {
        this.mZIndex = r100;
        return this;
    }
}
