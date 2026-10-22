package kna;

import android.content.Context;
import com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f504324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObricPerformancePowerMonitorConfig f504325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f504326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f504327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f504328e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f504324a, r101.f504324a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f504325b, r101.f504325b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f504326c, r101.f504326c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f504327d, r101.f504327d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f504328e, r101.f504328e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f504324a.hashCode() * 31) + this.f504325b.hashCode()) * 31;
        d r101 = this.f504326c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f504327d.hashCode()) * 31) + this.f504328e.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PowerMonitorInitConfig(context=" + this.f504324a + ", settings=" + this.f504325b + ", reportDelegate=" + this.f504326c + ", appBackgroundDelegate=" + this.f504327d + ", screenStateDelegate=" + this.f504328e + ')';
    }

    public final Context getContext() {
        return this.f504324a;
    }

    public f(Context r100, ObricPerformancePowerMonitorConfig r101, ObricPerformanceMonitorServiceImpl.AnonymousClass1.a r102, ObricPerformanceMonitorServiceImpl.AnonymousClass1.b r103, ObricPerformanceMonitorServiceImpl.AnonymousClass1.c r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "settings");
        Intrinsics.checkNotNullParameter(r103, "appBackgroundDelegate");
        Intrinsics.checkNotNullParameter(r104, "screenStateDelegate");
        this.f504324a = r100;
        this.f504325b = r101;
        this.f504326c = r102;
        this.f504327d = r103;
        this.f504328e = r104;
    }
}
