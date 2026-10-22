package com.obric.performance.power.monitor.utils;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/obric/performance/power/monitor/utils/EnsureLoad;", "", "<init>", "()V", "TAG", "", "soLoaded", "", "getSoLoaded", "()Z", "setSoLoaded", "(Z)V", "init", "", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnsureLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnsureLoad f403830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f403831b = false;

    public EnsureLoad() {
    }

    public final void init() {
    }

    static {
        f403830a = new EnsureLoad();
        System.currentTimeMillis();     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
        f403831b = true;     // Catch: Throwable -> L5
        System.currentTimeMillis();     // Catch: Throwable -> L5
        return;
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("performance_power", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> performance_power");
        a.c("performance_power");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> performance_power");
    }
}
