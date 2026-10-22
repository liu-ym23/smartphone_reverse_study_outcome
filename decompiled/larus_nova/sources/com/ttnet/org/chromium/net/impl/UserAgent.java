package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alipay.sdk.m.u.i;
import com.ttnet.org.chromium.net.TTNetVersion;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class UserAgent {
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static final Object sLock = null;
    private static int sVersionCode;

    private UserAgent() {
    }

    static {
        sLock = new Object();
        sVersionCode = 0;
    }

    private static void appendCronetVersion(StringBuilder r100) {
        r100.append(" Cronet/");
        r100.append(TTNetVersion.VERSION);
    }

    public static String from(Context r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getPackageName());
        r101.append('/');
        r101.append(versionFromContext(r100));
        r101.append(" (Linux; U; Android ");
        r101.append(Build.VERSION.RELEASE);
        r101.append("; ");
        r101.append(Locale.getDefault().toString());
        String r102 = Build.MODEL;
        if (r102.length() <= 0) goto L5;
        r101.append("; ");
        r101.append(r102);
    L5:
        String r103 = Build.ID;
        if (r103.length() <= 0) goto L8;
        r101.append("; Build/");
        r101.append(r103);
    L8:
        r101.append(i.f25853b);
        appendCronetVersion(r101);
        r101.append(')');
        return r101.toString();
    }

    public static String getQuicUserAgentIdFrom(Context r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getPackageName());
        appendCronetVersion(r101);
        return r101.toString();
    }

    private static int versionFromContext(Context r100) {
        Object r101 = sLock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sVersionCode == 0) goto L16;
    L9:
        int r102 = sVersionCode;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L16:
        sVersionCode = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L15 Throwable -> L12
        goto L9
    }
}
