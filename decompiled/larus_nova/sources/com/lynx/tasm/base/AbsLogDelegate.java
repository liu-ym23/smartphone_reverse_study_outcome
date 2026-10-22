package com.lynx.tasm.base;

/* JADX INFO: loaded from: classes32.dex */
public abstract class AbsLogDelegate {
    public static final int TYPE_INC = 2;
    public static final int TYPE_OVERRIDE = 1;
    public int mMinimumLoggingLevel;

    private void println(int r100, String r101, String r102) {
    }

    public void k(String r100, String r101) {
    }

    public int type() {
        return 2;
    }

    public AbsLogDelegate() {
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

    public boolean isLoggable(LogSource r100, int r101) {
        if (this.mMinimumLoggingLevel > r101) goto L5;
        return true;
    L5:
        return false;
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
