package com.lynx.tasm.behavior.ui.utils;

/* JADX INFO: loaded from: classes32.dex */
public final class c {
    public c() {
    }

    public static int a(int r100, int r101) {
        if (r101 != 255) goto L6;
        return r100;
    L6:
        if (r101 == 0) goto L8;
        int r102 = r101 + (r101 >> 7);
        int r103 = (((r100 >>> 24) * r102) >> 8) << 24;
        return (r100 & 16777215) | r103;
    L8:
        return r100 & 16777215;
    }
}
