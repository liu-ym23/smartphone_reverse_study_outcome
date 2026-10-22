package com.ss.ttvideoengine.log;

/* JADX INFO: loaded from: classes34.dex */
public class VRTracker {
    private int mDimension;
    private int mProjectStyle;
    private int mVideoStyle;
    private int mViewSize;

    public VRTracker() {
        this.mVideoStyle = Integer.MIN_VALUE;
        this.mDimension = Integer.MIN_VALUE;
        this.mProjectStyle = Integer.MIN_VALUE;
        this.mViewSize = Integer.MIN_VALUE;
    }

    public int getDimension() {
        return this.mDimension;
    }

    public int getProjectStyle() {
        return this.mProjectStyle;
    }

    public int getVideoStyle() {
        return this.mVideoStyle;
    }

    public int getViewSize() {
        return this.mViewSize;
    }

    public void setDimension(int r100) {
        this.mDimension = r100;
    }

    public void setProjectStyle(int r100) {
        this.mProjectStyle = r100;
    }

    public void setVideoStyle(int r100) {
        this.mVideoStyle = r100;
    }

    public void setViewSize(int r100) {
        this.mViewSize = r100;
    }
}
