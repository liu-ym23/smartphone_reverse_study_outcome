package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import com.lynx.tasm.LynxError;

/* JADX INFO: loaded from: classes23.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278189a = "f";

    public f() {
    }

    public static String a(String r100) {
        Context r101 = ContextUtil.getInstance();
        if (r101 != null) goto L13;
        return "";
    L13:
        return r101.getPackageManager().getPackageInfo(r100, 0).versionName;
    L10:
        e = move-exception;
        e.b(f278189a, "getVersion NameNotFoundException : " + e.getMessage());
    L12:
        return "";
    L8:
        e = move-exception;
        e.b(f278189a, "getVersion: " + e.getMessage());
    L7:
        e.b(f278189a, LynxError.LYNX_THROWABLE);
        goto L12
    }

    public static int b(String r100) {
        Context r101 = ContextUtil.getInstance();
        if (r101 != null) goto L11;
        return 0;
    L11:
        return r101.getPackageManager().getPackageInfo(r100, 0).versionCode;
    L9:
        e.b(f278189a, "getVersion NameNotFoundException");
    L10:
        return 0;
    L7:
        e = move-exception;
        e.b(f278189a, "getVersion: " + e.getMessage());
        goto L10
    }
}
