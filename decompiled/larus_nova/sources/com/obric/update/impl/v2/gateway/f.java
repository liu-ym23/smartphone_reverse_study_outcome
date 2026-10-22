package com.obric.update.impl.v2.gateway;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.update.impl.v2.handler.ObricInitHandler$createAppCommonContext$1;
import com.obric.update.impl.v2.handler.g;
import com.obric.update.impl.v2.handler.h;
import com.ss.android.update.IUpdateConfig;
import com.ss.android.update.OnUpdateStatusChangedListener;
import com.ss.android.update.UpdateServiceImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yhc.f0;
import yhc.m;
import yhc.v;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public static PolarisFileWrapper b() {
        return com.ss.android.update.d.x().I();
    }

    public static int c() {
        com.ss.android.update.d r100 = com.ss.android.update.d.x();
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.f455272k == true) goto L7;
        r100.U();     // Catch: Throwable -> L10
        r100.f455272k = true;     // Catch: Throwable -> L10
    L7:
        int r101 = r100.f455278n;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return r101;
    }

    public static void a(ObricInitHandler$createAppCommonContext$1 r100, final v r101, g r102, com.obric.update.impl.v2.handler.a r103, h r104) {
        Intrinsics.checkNotNullParameter(r100, "appCommonContext");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "logger");
        Intrinsics.checkNotNullParameter(r103, "eventReporter");
        Intrinsics.checkNotNullParameter(r104, "listener");
        IUpdateConfig r105 = new e(r101);
        m.f567709a = r102;
        yhc.b.f567684a = r103;
        f0.f567694c = r100;
        f0.f567692a = r105;
        f0.f567693b = new UpdateServiceImpl();
        com.ss.android.update.d r106 = com.ss.android.update.d.x();
        monitor-enter(r106);
        List<OnUpdateStatusChangedListener> r107 = r106.f455265g0;     // Catch: Throwable -> L13
        monitor-enter(r107);     // Catch: Throwable -> L13
        ((ArrayList) r106.f455265g0).add(r104);     // Catch: Throwable -> L10
        monitor-exit(r107);     // Catch: Throwable -> L10
        monitor-exit(r106);     // Catch: Throwable -> L13
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
