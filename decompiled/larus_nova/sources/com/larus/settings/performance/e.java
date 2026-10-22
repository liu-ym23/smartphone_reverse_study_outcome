package com.larus.settings.performance;

import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes31.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f368552a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f368553b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f368554c = null;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.settings.performance.b, java.lang.Object] */
    static {
        f368553b = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "systemBatteryRecorderConfig", "getSystemBatteryRecorderConfig()Lcom/larus/settings/performance/SystemBatteryRecorderConfig;", 0))};
        f368552a = new e();
        ?? r100 = new b();
        Intrinsics.checkNotNullParameter(r100, "initializer");
        f368554c = new a(r100);
    }

    public e() {
    }

    public static SystemBatteryRecorderConfig b() {
        int r100 = l0.f375430a;
        SystemBatteryRecorderConfig r101 = (SystemBatteryRecorderConfig) l0.a(new SystemBatteryRecorderConfig(false, false, 0, 0, null, null, 63, null), new c());
        FLogger.f375446a.i("PerfSettings", "systemBatteryRecorderConfig: " + r101);
        return r101;
    }

    public final SystemBatteryRecorderConfig a() {
        return (SystemBatteryRecorderConfig) f368554c.getValue(this, f368553b[0]);
    }
}
