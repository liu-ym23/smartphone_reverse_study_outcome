package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setDark(boolean r1) {
        this.isDark = r1;
    }

    public void setOutline(boolean r1) {
        this.isOutline = r1;
    }
}
