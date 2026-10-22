package com.bytedance.bdnavigationsdk.network.config;

import android.content.SharedPreferences;
import com.bytedance.bdnavigationsdk.a0;
import com.bytedance.bdnavigationsdk.contants.Constants;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ouc.v;
import ouc.w;
import y84.j;
import y84.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements g.b {
    public static final u84.a a = null;
    public static final g b = null;
    public static final Object c = null;

    public c() {
    }

    static {
        c r0 = new c();
        c = new Object();
        g r1 = new g();
        b = r1;
        Intrinsics.checkNotNull(r1);
        r1.d = r0;
        int r2 = u84.b.a;
        u84.a r3 = u84.c.a;
        a = r3;
        if (r3 == null) goto L26;
        String r4 = r3.a(Constants.BDNAConfiguration.getValue());
        if (r4 == null) goto L27;
        b r5 = (b) ouc.a.d.c(b.Companion.serializer(), r4);     // Catch: Exception -> L20
        com.bytedance.bdnavigationsdk.network.report.a r6 = r5.a;     // Catch: Exception -> L20
        if (r6 == null) goto L16;
        Object r7 = com.bytedance.bdnavigationsdk.network.report.d.c;     // Catch: Exception -> L20
        monitor-enter(r7);     // Catch: Exception -> L20
        com.bytedance.bdnavigationsdk.network.report.d.a = r6;     // Catch: Throwable -> L13
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r7);     // Catch: Exception -> L20
        goto L16
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L16:
        List<j> r9 = r5.b;     // Catch: Exception -> L20
        if (r9 == null) goto L28;
        o.b(r9);     // Catch: Exception -> L20
        Unit r10 = Unit.INSTANCE;     // Catch: Exception -> L20
        return;
    L28:
        return;
    L20:
        e = move-exception;
        r84.a.b("加载配置失败", e, 1);
        Unit r11 = Unit.INSTANCE;
        return;
    L27:
        return;
    }

    public static void c(com.bytedance.bdnavigationsdk.b r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Object r0 = c;
        monitor-enter(r0);
        String r2 = r5.a;     // Catch: Throwable -> L7
        a0 r6 = r5.e;     // Catch: Throwable -> L7
        d r1 = new d(r2, r6.a, r6.b, r6.c);     // Catch: Throwable -> L7
        g r7 = b;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L7
        r7.c(r1);     // Catch: Throwable -> L7
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdnavigationsdk.network.config.g.b
    public final void a(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        r84.a.b("获取配置回调处理失败", r3, 1);
    }

    @Override // com.bytedance.bdnavigationsdk.network.config.g.b
    public final void b(e r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        String r2 = null;
        r84.a.d(null, "获取配置回调处理成功", 5);
        b r0 = r7.c;
        if (r0 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r0, "configInfo");
        u84.a r1 = a;
        if (r1 == null) goto L18;
        String r3 = Constants.BDNAConfiguration.getValue();
        v r4 = w.a(new a());
        r2 = r4.a(b.Companion.serializer(), r0);     // Catch: Exception -> L10
    L12:
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r2, "text");
        tpa.a r5 = r1.a;
        if (r5 == null) goto L18;
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        SharedPreferences.Editor r6 = r5.a.edit().putString(r3, r2);
        if (r5.b == false) goto L17;
        r6.commit();
        goto L18
    L17:
        r6.apply();
    L10:
        e = move-exception;
        e.printStackTrace();
    L18:
        com.bytedance.bdnavigationsdk.network.report.a r8 = r7.c.a;
        if (r8 == null) goto L28;
        Object r9 = com.bytedance.bdnavigationsdk.network.report.d.c;
        monitor-enter(r9);
        com.bytedance.bdnavigationsdk.network.report.d.a = r8;     // Catch: Throwable -> L25
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r9);
    L25:
        th = move-exception;
        throw th;
    L28:
        List<j> r11 = r7.c.b;
        if (r11 == null) goto L36;
        o.b(r11);
        return;
    }
}
