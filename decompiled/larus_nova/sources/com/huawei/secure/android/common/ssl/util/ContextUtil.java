package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public class ContextUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f278179a;

    public ContextUtil() {
    }

    public static Context getInstance() {
        return f278179a;
    }

    public static void setContext(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (f278179a != null) goto L8;
        f278179a = r100.getApplicationContext();
        return;
    }
}
