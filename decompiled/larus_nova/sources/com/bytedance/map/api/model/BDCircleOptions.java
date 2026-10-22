package com.bytedance.map.api.model;

import android.graphics.Color;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes21.dex */
public class BDCircleOptions {
    private float mAlpha;
    private BDLatLng mCenter;
    private int mFillColor;
    private String mId;
    private double mRadius;
    private int mStrokeColor;
    private float mStrokeWidth;
    private float mZIndex;

    public BDCircleOptions() {
        this.mRadius = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mZIndex = 0.0f;
        this.mFillColor = Color.argb(0, 255, 255, 255);
        this.mStrokeColor = Color.argb(255, 0, 0, 0);
        this.mStrokeWidth = 10.0f;
        this.mAlpha = 1.0f;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public BDLatLng getCenter() {
        return this.mCenter;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public String getId() {
        return this.mId;
    }

    public double getRadius() {
        return this.mRadius;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public float getzIndex() {
        return this.mZIndex;
    }

    public void setAlpha(float r100) {
        this.mAlpha = r100;
    }

    public void setCenter(BDLatLng r100) {
        this.mCenter = r100;
    }

    public void setFillColor(int r100) {
        this.mFillColor = r100;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setRadius(double r100) {
        this.mRadius = r100;
    }

    public void setStrokeColor(int r100) {
        this.mStrokeColor = r100;
    }

    public void setStrokeWidth(float r100) {
        this.mStrokeWidth = r100;
    }

    public void setzIndex(float r100) {
        this.mZIndex = r100;
    }
}
