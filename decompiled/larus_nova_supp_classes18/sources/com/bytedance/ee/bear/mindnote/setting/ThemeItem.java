package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setActiveImg(String r1) {
        this.activeImg = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setNormalImg(String r1) {
        this.normalImg = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
