package com.ss.android.lark.forwardv2.dto;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class StickImage implements Serializable {
    private int mHeight;
    private String mKey;
    private int mWidth;

    public StickImage() {
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getKey() {
        return this.mKey;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setHeight(int r100) {
        this.mHeight = r100;
    }

    public void setKey(String r100) {
        this.mKey = r100;
    }

    public void setWidth(int r100) {
        this.mWidth = r100;
    }
}
