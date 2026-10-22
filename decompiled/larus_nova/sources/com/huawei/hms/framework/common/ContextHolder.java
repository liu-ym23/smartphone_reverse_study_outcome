package com.huawei.hms.framework.common;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public class ContextHolder {
    private static final String TAG = "ContextHolder";
    private static Context sAppContext;
    private static Context sKitContext;

    public ContextHolder() {
    }

    public static Context getResourceContext() {
        if (getKitContext() == null) goto L7;
        return getKitContext();
    L7:
        return getAppContext();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static Context getKitContext() {
        return sKitContext;
    }

    public static void setAppContext(Context r100) {
        if (sAppContext == null) goto L5;
        return;
    L5:
        CheckParamUtils.checkNotNull(r100, "sAppContext == null");
        sAppContext = r100.getApplicationContext();
    }

    public static void setKitContext(Context r100) {
        CheckParamUtils.checkNotNull(r100, "sKitContext == null");
        sKitContext = r100;
    }
}
