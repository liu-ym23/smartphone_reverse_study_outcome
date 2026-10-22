package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class ThumbnailData implements NonProguard {
    String imgData;
    boolean isDefault;

    public String getImgData() {
        return this.imgData;
    }

    public boolean getIsDefault() {
        return this.isDefault;
    }

    public void setImgData(String r100) {
        this.imgData = r100;
    }

    public void setIsDefault(boolean r100) {
        this.isDefault = r100;
    }

    public ThumbnailData(boolean r100, String r101) {
        this.isDefault = r100;
        this.imgData = r101;
    }
}
