package com.bytedance.ee.bear.wikiv2;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ l a;

    public j(l r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        List r3 = (List) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        this.a.getClass();
        return r3;
    }
}
