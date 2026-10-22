package com.bytedance.ies.bullet.base;

import android.app.Application;
import com.bytedance.ies.bullet.service.base.q0;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import kotlin.jvm.internal.Intrinsics;
import s26.e;
import v26.j;
import w26.d;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f246303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f246305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g16.b f246306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f246307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ies.bullet.service.sdk.b f246308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f246309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f246310h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ies.bullet.secure.e f246311i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f246303a, r101.f246303a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246304b, r101.f246304b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f246303a.hashCode() * 31) + this.f246304b.hashCode();
    }

    public final String toString() {
        return "InitializeConfig(application=" + this.f246303a + ", bid=" + this.f246304b + ')';
    }

    public final void b(q0 r100) {
        if (r100 != null) goto L5;
        r100 = new q0();
    L5:
        a(r.class, new MonitorReportService(r100));
    }

    public c(Application r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "bid");
        this.f246303a = r100;
        this.f246304b = r101;
        e.a r102 = new e.a();
        Intrinsics.checkNotNullParameter(r101, "bid");
        r102.f540313b = r101;
        this.f246309g = new e(r102);
    }

    public final <T extends q26.c> void a(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Intrinsics.checkNotNullParameter(r101, "instance");
        this.f246309g.a(r100.getName(), r101);
    }
}
