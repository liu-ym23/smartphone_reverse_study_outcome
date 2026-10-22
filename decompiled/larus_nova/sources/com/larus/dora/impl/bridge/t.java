package com.larus.dora.impl.bridge;

import android.app.Application;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f332115a = 0;

    static {
    }

    public static boolean a(Intent r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Intrinsics.checkNotNullParameter(r101, "url");
        Application r102 = AppHost.f326268a.getApplication();
        if (r100.resolveActivity(r102.getPackageManager()) != null) goto L6;
        FLogger.f375446a.e("DoraOpenTargetLauncher", "no activity can open ".concat(r101));
        return false;
    L6:
        r100.addFlags(268435456);
        r102.startActivity(r100);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        FLogger.f375446a.e("DoraOpenTargetLauncher", "start activity failed: ".concat(r101), e);
        return false;
    }
}
