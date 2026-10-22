package com.bytedance.ee.bear.document.titlebar;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class TitleBarFixedInfo implements NonProguard {
    private boolean fixed;

    public TitleBarFixedInfo() {
    }

    public String toString() {
        return "titleBar is fixed " + this.fixed;
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public void setFixed(boolean r100) {
        this.fixed = r100;
    }
}
