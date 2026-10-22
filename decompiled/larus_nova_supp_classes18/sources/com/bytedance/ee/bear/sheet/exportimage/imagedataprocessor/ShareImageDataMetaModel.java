package com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setHeight(int r1) {
        this.height = r1;
    }

    public void setWidth(int r1) {
        this.width = r1;
    }
}
