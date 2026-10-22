package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s0<T, R> implements Function {
    public s0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T apply(T r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        WikiInfo r0 = (WikiInfo) ((up5.b) r3).a;
        WikiException.validate(eu5.b.a, r0);
        return r3;
    }
}
