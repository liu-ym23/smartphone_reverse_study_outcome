package com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class ShareImageDataMetaModel implements NonProguard {
    private int height;
    private int width;

    public ShareImageDataMetaModel() {
    }

    public String toString() {
        return "ShareImageDataMetaModel{width=" + this.width + ", height=" + this.height + '}';
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
