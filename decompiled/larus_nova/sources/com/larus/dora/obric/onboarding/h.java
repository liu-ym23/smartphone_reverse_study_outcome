package com.larus.dora.obric.onboarding;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<ObricDoraGEnvAuthResult, Unit> f340860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f340861b;

    public h(j r100) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        this.f340860a = r100;
    }

    public final void a(ObricDoraGEnvAuthResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        if (this.f340861b == false) goto L5;
        return;
    L5:
        this.f340861b = true;
        this.f340860a.invoke(r100);
    }
}
