package com.bytedance.map.api.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.bytedance.map.api.listener.LocationChangeListener;

/* JADX INFO: loaded from: classes21.dex */
public class BDLocationOverlayConfig {
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_INFO = "errorInfo";
    public static final String LOCATION_TYPE = "locationType";
    public static final int LOCATION_TYPE_FOLLOW = 2;
    public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_LOCATION_ROTATE = 4;
    public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 5;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 7;
    public static final int LOCATION_TYPE_SHOW = 0;
    private float anchorU;
    private float anchorV;
    private long intervalMs;
    private int locationType;
    private LocationChangeListener mLocationChangeListener;
    private Bitmap myLocationIcon;
    private boolean myLocationOverlayEnabled;
    private boolean myLocationOverlayVisible;
    private int radiusFillColor;
    private int strokeColor;
    private float strokeWidth;
    private int zIndex;

    public BDLocationOverlayConfig() {
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.radiusFillColor = Color.argb(100, 0, 0, 180);
        this.strokeColor = Color.argb(255, 0, 0, 220);
        this.strokeWidth = 1.0f;
        this.locationType = 4;
        this.intervalMs = 2000;
        this.zIndex = 0;
        this.myLocationOverlayVisible = true;
        this.myLocationOverlayEnabled = false;
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public long getIntervalMs() {
        return this.intervalMs;
    }

    public LocationChangeListener getLocationChangeListener() {
        return this.mLocationChangeListener;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public Bitmap getMyLocationIcon() {
        return this.myLocationIcon;
    }

    public int getRadiusFillColor() {
        return this.radiusFillColor;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public int getZIndex() {
        return this.zIndex;
    }

    public boolean isMyLocationOverlayEnabled() {
        return this.myLocationOverlayEnabled;
    }

    public boolean isMyLocationVisible() {
        return this.myLocationOverlayVisible;
    }

    public void setAnchorU(float r100) {
        this.anchorU = r100;
    }

    public void setAnchorV(float r100) {
        this.anchorV = r100;
    }

    public void setIntervalMs(long r100) {
        this.intervalMs = r100;
    }

    public void setLocationChangeListener(LocationChangeListener r100) {
        this.mLocationChangeListener = r100;
    }

    public void setLocationType(int r100) {
        this.locationType = r100;
    }

    public void setMyLocationIcon(Bitmap r100) {
        this.myLocationIcon = r100;
    }

    public void setMyLocationOverlayEnabled(boolean r100) {
        this.myLocationOverlayEnabled = r100;
    }

    public void setMyLocationVisible(boolean r100) {
        this.myLocationOverlayVisible = r100;
    }

    public void setRadiusFillColor(int r100) {
        this.radiusFillColor = r100;
    }

    public void setStrokeColor(int r100) {
        this.strokeColor = r100;
    }

    public void setStrokeWidth(float r100) {
        this.strokeWidth = r100;
    }

    public void setZIndex(int r100) {
        this.zIndex = r100;
    }
}
