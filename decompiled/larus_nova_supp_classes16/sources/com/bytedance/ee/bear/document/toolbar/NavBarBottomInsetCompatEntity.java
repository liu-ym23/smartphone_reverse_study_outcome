package com.bytedance.ee.bear.document.toolbar;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setMaxHeight(int r1) {
        this.maxHeight = r1;
    }

    public void setMinHeight(int r1) {
        this.minHeight = r1;
    }

    public void setMinLimit(int r1) {
        this.minLimit = r1;
    }

    public void setPadding(int r1) {
        this.padding = r1;
    }
}
