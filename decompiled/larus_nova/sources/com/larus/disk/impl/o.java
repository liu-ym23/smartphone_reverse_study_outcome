package com.larus.disk.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class o implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f330779a;

    public /* synthetic */ o(boolean r100) {
        this.f330779a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        boolean r101 = this.f330779a;
        com.larus.disk.api.c r102 = (com.larus.disk.api.c) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        return Long.valueOf(r102.b(r101));
    }
}
