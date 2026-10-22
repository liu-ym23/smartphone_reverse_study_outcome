package com.bytedance.ee.bear.drive.biz.preview.vc.pdf;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DrivePdfState implements NonProguard {
    private int activePageNumber;
    private boolean isPresentationMode;
    private int pageNumber;
    private float pageOffsetLeft;
    private float pageOffsetTop;
    private float scale;
    private V2Offset v2;

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
        return "DrivePdfState{scale=" + this.scale + ", pageNumber=" + this.pageNumber + ", pageOffsetTop=" + this.pageOffsetTop + ", pageOffsetLeft=" + this.pageOffsetLeft + ", isPresentationMode=" + this.isPresentationMode + ", activePageNumber=" + this.activePageNumber + ", v2=" + this.v2 + '}';
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
        return this.v2;
    }

    public boolean isIsPresentationMode() {
        return this.isPresentationMode;
    }

    public void setActivePageNumber(int r1) {
        this.activePageNumber = r1;
    }

    public void setIsPresentationMode(boolean r1) {
        this.isPresentationMode = r1;
    }

    public void setPageNumber(int r1) {
        this.pageNumber = r1;
    }

    public void setPageOffsetLeft(float r1) {
        this.pageOffsetLeft = r1;
    }

    public void setPageOffsetTop(float r1) {
        this.pageOffsetTop = r1;
    }

    public void setScale(float r1) {
        this.scale = r1;
    }

    public void setV2(V2Offset r1) {
        this.v2 = r1;
    }
}
