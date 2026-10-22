package com.larksuite.component.card.utils;

import android.app.ActivityManager;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f283985a;

    public static final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AtomicBoolean r101 = f283985a;     // Catch: Throwable -> L16
        if (r101 == null) goto L6;
        Boolean r102 = Boolean.valueOf(r101.get());     // Catch: Throwable -> L16
    L7:
        if (r102 != null) goto L9;
        Object r103 = r100.getSystemService("activity");     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L16
        if (((ActivityManager) r103).getDeviceConfigurationInfo().reqGlEsVersion < 196608) goto L13;
        boolean r104 = true;
    L14:
        f283985a = new AtomicBoolean(r104);     // Catch: Throwable -> L16
        return r104;
    L13:
        r104 = false;
        goto L14
    L9:
        return r102.booleanValue();
    L6:
        r102 = null;
    L16:
        return true;
    }

    public static final boolean b(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }
}
