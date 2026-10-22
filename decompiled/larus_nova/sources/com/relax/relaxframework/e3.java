package com.relax.relaxframework;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Double> f405068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModifierValuePattern f405069b;

    public e3(Function0<Double> r100, ModifierValuePattern r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "pattern");
        this.f405068a = r100;
        this.f405069b = r101;
    }
}
