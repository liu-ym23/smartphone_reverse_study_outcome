package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
class ThemeData implements NonProguard {
    private boolean isDark;
    private boolean isOutline;

    public String toString() {
        return "ThemeData{isDark=" + this.isDark + '}';
    }

    public ThemeData() {
        this.isOutline = false;
    }

    public boolean isDark() {
        return this.isDark;
    }

    public boolean isOutline() {
        return this.isOutline;
    }

    public void setDark(boolean r100) {
        this.isDark = r100;
    }

    public void setOutline(boolean r100) {
        this.isOutline = r100;
    }
}
