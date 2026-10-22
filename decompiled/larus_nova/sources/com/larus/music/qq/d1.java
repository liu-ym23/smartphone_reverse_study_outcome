package com.larus.music.qq;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public class d1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<T, Unit> f359522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f359523b;

    public d1(g0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f359522a = r100;
    }

    public final void a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (this.f359523b == true) goto L5;
        this.f359522a.invoke(r100);
    L5:
        this.f359523b = true;
    }
}
