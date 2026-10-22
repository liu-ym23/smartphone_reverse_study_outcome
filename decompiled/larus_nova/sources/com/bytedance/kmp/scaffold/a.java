package com.bytedance.kmp.scaffold;

import com.bytedance.kmp.performance.reporter.SimpleKPerfReporter;
import com.bytedance.kmp.performance.reporter.b;
import com.bytedance.kmp.performance.reporter.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f252860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f252861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f252862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f252863d;

    public a(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        long r102 = -1;
    L7:
        if ((r101 & 2) == 0) goto L9;
        SimpleKPerfReporter r103 = b.f252838a;
    L11:
        if ((r101 & 4) == 0) goto L13;
        r100 = false;
    L13:
        Intrinsics.checkNotNullParameter(r103, "reporter");
        this.f252860a = r102;
        this.f252861b = r103;
        this.f252862c = r100;
        this.f252863d = false;
        return;
    L9:
        r103 = null;
        goto L11
    L5:
        r102 = 0;
        goto L7
    }
}
