package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s0<T, R> implements Function {
    public s0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final T apply(T r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        WikiInfo r101 = (WikiInfo) ((up5.b) r100).f551048a;
        WikiException.validate(eu5.b.f474075a, r101);
        return r100;
    }
}
