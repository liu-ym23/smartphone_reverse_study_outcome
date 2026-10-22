package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f339281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f339282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f339283c;

    public final void a() {
        this.f339283c = this.f339281a.invoke();
    }

    public j2(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "elapsedRealtime");
        this.f339281a = r100;
        this.f339282b = 800;
    }
}
