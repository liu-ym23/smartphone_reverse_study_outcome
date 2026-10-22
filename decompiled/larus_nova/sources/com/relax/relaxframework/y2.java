package com.relax.relaxframework;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<? extends AppTheme> f405357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<x2> f405358b;

    public y2(Function0<? extends AppTheme> r100, Function0<x2> r101) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "mediaQueryState");
        this.f405357a = r100;
        this.f405358b = r101;
    }
}
