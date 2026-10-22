package com.bytedance.kmp.performance.api;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b<Object> f252614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Object, Unit> f252615b;

    @Override // java.lang.AutoCloseable
    public final void close() {
        b<Object> r100 = this.f252614a;
        Function1<Object, Unit> r101 = this.f252615b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "callback");
        r100.f252616a.remove(r101);
    }

    public a(b<Object> r100, Function1<Object, Unit> r101) {
        this.f252614a = r100;
        this.f252615b = r101;
    }
}
