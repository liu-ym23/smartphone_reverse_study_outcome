package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f244913a;

    public static String a(Context r100) {
        if (f244913a != null) goto L6;
        String r101 = hy5.c.a().replace(r100.getPackageName(), "p").replace(":", "_");
        f244913a = r101;
        f244913a = r101.replace(".", "_");
    L6:
        return f244913a;
    }
}
