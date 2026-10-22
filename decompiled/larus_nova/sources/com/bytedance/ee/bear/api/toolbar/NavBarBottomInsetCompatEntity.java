package com.bytedance.ee.bear.api.toolbar;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = "doc_toolbar_android_compat")
public class NavBarBottomInsetCompatEntity implements NonProguard {
    private boolean enable;
    private int maxHeight;
    private int minHeight;
    private int minLimit;
    private int padding;

    public String toString() {
        return "NavBarBottomInsetCompatEntity{maxHeight=" + this.maxHeight + ", minHeight=" + this.minHeight + ", minLimit=" + this.minLimit + ", padding=" + this.padding + ", enable=" + this.enable + '}';
    }

    public NavBarBottomInsetCompatEntity() {
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMinLimit() {
        return this.minLimit;
    }

    public int getPadding() {
        return this.padding;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setMaxHeight(int r100) {
        this.maxHeight = r100;
    }

    public void setMinHeight(int r100) {
        this.minHeight = r100;
    }

    public void setMinLimit(int r100) {
        this.minLimit = r100;
    }

    public void setPadding(int r100) {
        this.padding = r100;
    }
}
