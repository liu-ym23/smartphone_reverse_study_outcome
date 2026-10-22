package com.larus.home.impl.privacy;

import android.content.Context;
import android.content.Intent;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final a a = null;
    public static String b;
    public static String c;
    public static PolarisFileWrapper d;
    public static final Keva e = null;

    public a() {
    }

    static {
        a = new a();
        e = Keva.getRepo("flow_privacy", 1);
    }

    public static boolean a() {
        if (d.e == false) goto L6;
    L7:
        return true;
    L6:
        if (AppHost.a.isOversea() == true) goto L7;
        PolarisFileWrapper r0 = d;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("flagFile");
        r0 = null;
    L12:
        return r0.exists();
    }

    public static void b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        KillMySelfBroadcastReceiver.a r1 = KillMySelfBroadcastReceiver.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        r2.sendBroadcast(new Intent("com.larus.nova.kill_process").setPackage(r2.getPackageName()), KillMySelfBroadcastReceiver.a.a(r2));
    }

    public final void registerReceiver(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        KillMySelfBroadcastReceiver.a.registerReceiver(r2);
    }
}
