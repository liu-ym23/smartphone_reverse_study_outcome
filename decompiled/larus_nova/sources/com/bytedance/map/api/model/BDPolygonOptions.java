package com.bytedance.map.api.model;

import android.graphics.Color;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class BDPolygonOptions {
    public static final int DOTTED_LINE_CIRCLE = 1;
    public static final int DOTTED_LINE_SQUARE = 0;
    private boolean mClickable;
    private int mDottedLineType;
    private int mFillColor;
    private String mId;
    private boolean mIsDottedStroke;
    private List<BDLatLng> mLatLngs;
    private int mStrokeColor;
    private float mStrokeWidth;
    private float mZIndex;

    public BDPolygonOptions() {
        this.mFillColor = Color.argb(0, 255, 255, 255);
        this.mStrokeColor = Color.argb(255, 0, 0, 0);
        this.mStrokeWidth = 10.0f;
        this.mZIndex = 0.0f;
        this.mIsDottedStroke = false;
        this.mDottedLineType = 0;
        this.mClickable = false;
    }

    public int getDottedLineType() {
        return this.mDottedLineType;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public String getId() {
        return this.mId;
    }

    public List<BDLatLng> getLatLngs() {
        return this.mLatLngs;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public boolean isDottedStroke() {
        return this.mIsDottedStroke;
    }

    public void setClickable(boolean r100) {
        this.mClickable = r100;
    }

    public void setDottedLineType(int r100) {
        this.mDottedLineType = r100;
    }

    public void setDottedStroke(boolean r100) {
        this.mIsDottedStroke = r100;
    }

    public void setFillColor(int r100) {
        this.mFillColor = r100;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setLatLngs(List<BDLatLng> r100) {
        this.mLatLngs = r100;
    }

    public void setStrokeColor(int r100) {
        this.mStrokeColor = r100;
    }

    public void setStrokeWidth(float r100) {
        this.mStrokeWidth = r100;
    }

    public void setZIndex(float r100) {
        this.mZIndex = r100;
    }
}
