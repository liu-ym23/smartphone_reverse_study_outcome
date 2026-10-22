package com.bytedance.locallife.pdp.biz.common.cache;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T, R> f261016a = null;

    static {
        f261016a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        xw6.a r101 = (xw6.a) r100;
        Intrinsics.checkNotNullParameter(r101, "goodsDetailEntity");
        lp6.a r102 = r101.f565253e;
        return new lp6.a(r102.f510230a, r102.f510231b, 4);
    }
}
