package com.bytedance.ee.bear.drive.loader.impl;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import uu5.i;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<f85.a> f224472a;

    public d(i<f85.a> r100) {
        this.f224472a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Boolean) r100, "it");
        return this.f224472a;
    }
}
