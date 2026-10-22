package com.bytedance.ee.plugin.common.ttpdfreader;

/* JADX INFO: loaded from: classes19.dex */
public class CharLocation {
    public static final CharLocation UNKNOWN = null;
    public final int charIndex;
    public final int pageIndex;

    static {
        UNKNOWN = new CharLocation(-1, -1);
    }

    public String toString() {
        return "CharLocation@" + hashCode() + "{pageIndex=" + this.pageIndex + ", charIndex=" + this.charIndex + '}';
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof CharLocation) == true) goto L5;
        return false;
    L5:
        CharLocation r101 = (CharLocation) r100;
        if (this.pageIndex == r101.pageIndex) goto L8;
        return false;
    L8:
        if (this.charIndex != r101.charIndex) goto L12;
        return true;
    L12:
        return false;
    }

    public CharLocation(int r100, int r101) {
        this.pageIndex = r100;
        this.charIndex = r101;
    }
}
