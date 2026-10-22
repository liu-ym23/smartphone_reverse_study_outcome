package com.larus.im.internal.utils;

import android.content.Context;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d0 implements m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<d0> f350531e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PowerManager f350532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g0> f350533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f350534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0 f350535d;

    public static final class a {
    }

    static {
        f350531e = LazyKt.lazy(new b0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.os.PowerManager$OnThermalStatusChangedListener, com.larus.im.internal.utils.c0] */
    @Override // com.larus.im.internal.utils.m
    public final void b() {
        if (this.f350535d == null) goto L5;
        return;
    L5:
        ?? r100 = new c0(this);
        this.f350532a.addThermalStatusListener(this.f350534c, r100);
        this.f350535d = r100;
    }

    @Override // com.larus.im.internal.utils.m
    public final int getCurrentThermalStatus() {
        return this.f350532a.getCurrentThermalStatus();
    }

    public d0(Context r100) {
        Context r101 = r100.getApplicationContext();
        Object r102 = r101.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.os.PowerManager");
        this.f350532a = (PowerManager) r102;
        this.f350533b = new ArrayList();
        this.f350534c = r101.getMainExecutor();
    }

    @Override // com.larus.im.internal.utils.m
    public final void a(com.larus.im.internal.rtcsdk.impl.v.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<g0> r101 = this.f350533b;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f350533b).contains(r100) == true) goto L7;
        ((ArrayList) this.f350533b).add(r100);     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
    }
}
