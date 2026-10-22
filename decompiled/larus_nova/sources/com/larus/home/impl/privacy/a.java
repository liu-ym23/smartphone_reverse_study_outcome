package com.larus.home.impl.privacy;

import android.content.Context;
import android.content.Intent;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f346013a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f346014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f346015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PolarisFileWrapper f346016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Keva f346017e = null;

    public a() {
    }

    static {
        f346013a = new a();
        f346017e = Keva.getRepo("flow_privacy", 1);
    }

    public static boolean a() {
        if (d.f360144e == false) goto L6;
    L7:
        return true;
    L6:
        if (AppHost.f326268a.isOversea() == true) goto L7;
        PolarisFileWrapper r100 = f346016d;
        if (r100 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("flagFile");
        r100 = null;
    L12:
        return r100.exists();
    }

    public static void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        KillMySelfBroadcastReceiver.a r101 = KillMySelfBroadcastReceiver.f346002a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.sendBroadcast(new Intent("com.larus.nova.kill_process").setPackage(r100.getPackageName()), KillMySelfBroadcastReceiver.a.a(r100));
    }

    public final void registerReceiver(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        KillMySelfBroadcastReceiver.f346002a.registerReceiver(r100);
    }
}
