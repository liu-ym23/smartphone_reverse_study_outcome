package com.ss.android.lark.sticker.core.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class StickerFileInfo implements Serializable {
    private String FilePath;
    private int height;
    private String key;
    private String url;
    private int width;

    public StickerFileInfo() {
    }

    public String getFilePath() {
        return this.FilePath;
    }

    public int getHeight() {
        return this.height;
    }

    public String getKey() {
        return this.key;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public void setFilePath(String r100) {
        this.FilePath = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    public StickerFileInfo(String r100, String r101, String r102, int r103, int r104) {
        this.key = r100;
        this.url = r101;
        this.FilePath = r102;
        this.width = r103;
        this.height = r104;
    }
}
