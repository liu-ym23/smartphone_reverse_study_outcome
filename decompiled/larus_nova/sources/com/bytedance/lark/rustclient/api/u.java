package com.bytedance.lark.rustclient.api;

import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class u<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Object, Object> f253934a;

    public u(Function1<Object, Object> r100) {
        this.f253934a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        s r101 = (s) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return t.e(r101, this.f253934a);
    }
}
