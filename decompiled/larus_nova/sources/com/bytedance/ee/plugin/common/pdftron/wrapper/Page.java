package com.bytedance.ee.plugin.common.pdftron.wrapper;

/* JADX INFO: loaded from: classes19.dex */
public class Page {
    public static final int e_0 = 0;
    public static final int e_180 = 2;
    public static final int e_270 = 3;
    public static final int e_90 = 1;
    private double mHeight;
    private Object mSrcPage;
    private double mWidth;
    private int pageRotation;

    public Page() {
    }

    public double getHeight() {
        return this.mHeight;
    }

    public int getPageRotation() {
        return this.pageRotation;
    }

    public Object getSrcPage() {
        return this.mSrcPage;
    }

    public double getWidth() {
        return this.mWidth;
    }

    public Page(Object r100) {
        this.mSrcPage = r100;
    }

    public void setHeight(double r100) {
        this.mHeight = r100;
    }

    public void setPageRotation(int r100) {
        this.pageRotation = r100;
    }

    public void setSrcPage(Object r100) {
        this.mSrcPage = r100;
    }

    public void setWidth(double r100) {
        this.mWidth = r100;
    }

    public Page(Object r100, double r101, double r102, int r103) {
        this.mSrcPage = r100;
        this.mWidth = r101;
        this.mHeight = r102;
        this.pageRotation = r103;
    }
}
