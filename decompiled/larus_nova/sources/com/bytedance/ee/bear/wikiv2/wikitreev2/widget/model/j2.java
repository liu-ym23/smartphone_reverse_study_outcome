package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j2<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j2<T, R> f241938a = null;

    static {
        f241938a = new j2();
    }

    public j2() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Boolean r101 = (Boolean) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return new ar5.b.a(r101.booleanValue());
    }
}
