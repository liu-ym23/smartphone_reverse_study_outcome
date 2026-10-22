package com.bytedance.common.utility.android;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class ManifestData {
    public static int getInt(Context r100, String r101) {
        Object r102 = readKey(r100, r101);
        if (r102 != null) goto L6;
        return -1;
    L6:
        return ((Integer) r102).intValue();
    }

    public static String getString(Context r100, String r101) {
        Object r102 = readKey(r100, r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        return (String) r102;
    }

    private static Object readKey(Context r100, String r101) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData.get(r101);
    L7:
        return null;
    }
}
