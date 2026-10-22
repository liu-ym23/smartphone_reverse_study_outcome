package com.ss.android.ugc.aweme.search.vision.crop.util;

/* JADX INFO: loaded from: classes40.dex */
public class HandleUtil {
    public static boolean a(float r100, float r101, float r102, float r103, float r104, float r105) {
        if (r100 > r102) goto L5;
    L9:
        return false;
    L5:
        if (r100 >= r103) goto L9;
        if (Math.abs(r101 - r104) > r105) goto L9;
        return true;
    }

    public static boolean b(float r100, float r101, float r102, float r103, float r104, float r105) {
        if (Math.abs(r100 - r102) <= r105) goto L5;
    L9:
        return false;
    L5:
        if (r101 <= r103) goto L9;
        if (r101 >= r104) goto L9;
        return true;
    }
}
