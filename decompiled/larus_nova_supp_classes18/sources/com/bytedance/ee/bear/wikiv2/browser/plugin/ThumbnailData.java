package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ThumbnailData implements NonProguard {
    String imgData;
    boolean isDefault;

    public String getImgData() {
        return this.imgData;
    }

    public boolean getIsDefault() {
        return this.isDefault;
    }

    public void setImgData(String r1) {
        this.imgData = r1;
    }

    public void setIsDefault(boolean r1) {
        this.isDefault = r1;
    }

    public ThumbnailData(boolean r1, String r2) {
        this.isDefault = r1;
        this.imgData = r2;
    }
}
