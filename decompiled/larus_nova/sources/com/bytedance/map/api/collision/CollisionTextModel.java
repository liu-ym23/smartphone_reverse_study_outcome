package com.bytedance.map.api.collision;

import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IMarker;

/* JADX INFO: loaded from: classes21.dex */
public class CollisionTextModel {
    public static final int CENTER = 1;
    public static final int TOP_BOTTOM = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f265483id;
    private int mAlignmentType;
    private int mContentPadding;
    private int mHeight;
    private BDLatLng mLatLng;
    private int mWidth;
    private int mZIndex;
    private IMarker marker;

    public String toString() {
        return "CollisionTextModel{marker=" + this.marker + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mContentPadding=" + this.mContentPadding + ", mLatLng=" + this.mLatLng + ", mZIndex=" + this.mZIndex + ", mAlignmentType=" + this.mAlignmentType + '}';
    }

    public int getAlignmentType() {
        return this.mAlignmentType;
    }

    public int getContentPadding() {
        return this.mContentPadding;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getId() {
        return this.f265483id;
    }

    public BDLatLng getLatLng() {
        return this.mLatLng;
    }

    public IMarker getMarker() {
        return this.marker;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public CollisionTextModel(IMarker r100) {
        this.marker = r100;
    }

    public void setAlignmentType(int r100) {
        this.mAlignmentType = r100;
    }

    public void setContentPadding(int r100) {
        this.mContentPadding = r100;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
    }

    public void setId(String r100) {
        this.f265483id = r100;
    }

    public void setLatLng(BDLatLng r100) {
        this.mLatLng = r100;
    }

    public void setMarker(IMarker r100) {
        this.marker = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }

    public void setZIndex(int r100) {
        this.mZIndex = r100;
    }
}
