package com.bytedance.ee.bear.drive.biz.preview.vc.pdf;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class DrivePdfState implements NonProguard {
    private int activePageNumber;
    private boolean isPresentationMode;
    private int pageNumber;
    private float pageOffsetLeft;
    private float pageOffsetTop;
    private float scale;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    private V2Offset f223812v2;

    public static class V2Offset implements NonProguard {
        public int pageNumber;
        public float pageOffsetTop;

        public V2Offset() {
        }

        public String toString() {
            return "V2Offset{pageNumber=" + this.pageNumber + ", pageOffsetTop=" + this.pageOffsetTop + '}';
        }
    }

    public String toString() {
        return "DrivePdfState{scale=" + this.scale + ", pageNumber=" + this.pageNumber + ", pageOffsetTop=" + this.pageOffsetTop + ", pageOffsetLeft=" + this.pageOffsetLeft + ", isPresentationMode=" + this.isPresentationMode + ", activePageNumber=" + this.activePageNumber + ", v2=" + this.f223812v2 + '}';
    }

    public DrivePdfState() {
        this.scale = 1.0f;
    }

    public int getActivePageNumber() {
        return this.activePageNumber;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public float getPageOffsetLeft() {
        return this.pageOffsetLeft;
    }

    public float getPageOffsetTop() {
        return this.pageOffsetTop;
    }

    public float getScale() {
        return this.scale;
    }

    public V2Offset getV2() {
        return this.f223812v2;
    }

    public boolean isIsPresentationMode() {
        return this.isPresentationMode;
    }

    public void setActivePageNumber(int r100) {
        this.activePageNumber = r100;
    }

    public void setIsPresentationMode(boolean r100) {
        this.isPresentationMode = r100;
    }

    public void setPageNumber(int r100) {
        this.pageNumber = r100;
    }

    public void setPageOffsetLeft(float r100) {
        this.pageOffsetLeft = r100;
    }

    public void setPageOffsetTop(float r100) {
        this.pageOffsetTop = r100;
    }

    public void setScale(float r100) {
        this.scale = r100;
    }

    public void setV2(V2Offset r100) {
        this.f223812v2 = r100;
    }
}
