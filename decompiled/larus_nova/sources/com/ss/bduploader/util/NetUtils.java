package com.ss.bduploader.util;

import android.content.Context;

/* JADX INFO: loaded from: classes40.dex */
public class NetUtils {
    private static Context gContext;

    public NetUtils() {
    }

    public static Context getApplicationContext() {
        return gContext;
    }

    public static void setApplicationContext(Context r100) {
        if (gContext != null) goto L6;
        gContext = r100;
        return;
    }
}
