package com.larus.home.impl.sdk;

import android.app.Application;
import android.content.Context;
import android.os.BatteryManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import hq9.g3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a2 implements com.larus.platform.api.f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f346136a = null;

    static {
        f346136a = new a2();
    }

    public a2() {
    }

    @Override // com.larus.platform.api.f1
    public final int a() {
        int r100 = zt7.g.f573633a;
        Application r101 = xu3.a.getContext();
        if (r101 != null) goto L5;
        int r102 = -1;
    L6:
        FLogger.f375446a.d("SystemResourceUtils", "battery level is " + r102);
        return r102;
    L5:
        Object r103 = r101.getSystemService("batterymanager");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.os.BatteryManager");
        r102 = ((BatteryManager) r103).getIntProperty(4);
        goto L6
    }

    @Override // com.larus.platform.api.f1
    public final int c() {
        int r100 = zt7.g.f573633a;
        int r101 = com.bytedance.apm.util.i.f190674f;
        FLogger.f375446a.d("SystemResourceUtils", "refresh rate is " + r101);
        return r101;
    }

    @Override // com.larus.platform.api.f1
    public final hq9.q0 d() {
        int r100 = zt7.g.f573633a;
        st3.a.b().getClass();
        ts3.a r101 = st3.a.a();
        FLogger.f375446a.d("SystemResourceUtils", "cpu usage is " + r101.f547363a + ", cpu speed is " + r101.f547364b);
        Intrinsics.checkNotNull(r101);
        return new hq9.q0(r101.f547363a);
    }

    @Override // com.larus.platform.api.f1
    public final float e() {
        int r100 = zt7.g.f573633a;
        float r101 = ss3.i.a.f543398a.f543396d;
        FLogger.f375446a.d("SystemResourceUtils", "battery temperature is " + r101);
        return r101;
    }

    @Override // com.larus.platform.api.f1
    public final g3 b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = zt7.g.f573633a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ts3.b r111 = ss3.c.a(r110);
        FLogger.f375446a.d("SystemResourceUtils", "total pss is " + r111.f547373i);
        Intrinsics.checkNotNull(r111);
        return new g3(r111.f547367c, r111.f547373i, r111.f547374j);
    }
}
