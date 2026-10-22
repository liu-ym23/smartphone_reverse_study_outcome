package com.larus.ivykit;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f351627a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f351628b = null;

    static {
        StringBuilder r100 = new StringBuilder("nova_");
        AppHost.Companion r101 = AppHost.f326268a;
        r100.append(r101.getAppId());
        f351627a = r100.toString();
        f351628b = "nova_" + r101.getAppId();
    }

    public static String a() {
        if (AppHost.f326268a.isOversea() == false) goto L6;
        return f351628b;
    L6:
        return f351627a;
    }
}
