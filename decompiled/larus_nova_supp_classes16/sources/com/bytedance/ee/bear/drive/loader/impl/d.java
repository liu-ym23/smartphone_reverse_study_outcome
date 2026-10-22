package com.bytedance.ee.bear.drive.loader.impl;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import uu5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ i<f85.a> a;

    public d(i<f85.a> r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Boolean) r2, "it");
        return this.a;
    }
}
