package com.lynx.base.log;

/* JADX INFO: loaded from: classes32.dex */
public abstract class AbsBaseLogDelegate {
    public int mMinimumLoggingLevel;

    private void println(int r100, String r101, String r102) {
    }

    public AbsBaseLogDelegate() {
        this.mMinimumLoggingLevel = 4;
    }

    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    public boolean isLoggable(int r100) {
        if (this.mMinimumLoggingLevel > r100) goto L5;
        return true;
    L5:
        return false;
    }

    public void setMinimumLoggingLevel(int r100) {
        this.mMinimumLoggingLevel = r100;
    }

    public void d(String r100, String r101) {
        println(3, r100, r101);
    }

    public void e(String r100, String r101) {
        println(6, r100, r101);
    }

    public void i(String r100, String r101) {
        println(4, r100, r101);
    }

    public void v(String r100, String r101) {
        println(2, r100, r101);
    }

    public void w(String r100, String r101) {
        println(5, r100, r101);
    }

    public void log(int r100, String r101, String r102) {
        println(r100, r101, r102);
    }
}
