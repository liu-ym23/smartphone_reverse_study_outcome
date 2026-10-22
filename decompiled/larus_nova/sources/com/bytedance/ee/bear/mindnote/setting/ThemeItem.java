package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
class ThemeItem implements NonProguard {
    private String activeImg;
    private String key;
    private String normalImg;
    private String title;

    public String toString() {
        return "ThemeItem{key='" + this.key + "', title='" + this.title + "', normalImg='" + this.normalImg + "', activeImg='" + this.activeImg + "'}";
    }

    public ThemeItem() {
        this.key = "";
        this.title = "";
        this.normalImg = "";
        this.activeImg = "";
    }

    public String getActiveImg() {
        return this.activeImg;
    }

    public String getKey() {
        return this.key;
    }

    public String getNormalImg() {
        return this.normalImg;
    }

    public String getTitle() {
        return this.title;
    }

    public void setActiveImg(String r100) {
        this.activeImg = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setNormalImg(String r100) {
        this.normalImg = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
