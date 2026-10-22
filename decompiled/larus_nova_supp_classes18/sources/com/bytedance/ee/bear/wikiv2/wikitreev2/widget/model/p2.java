package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p2<T, R> implements Function {
    public static final p2<T, R> a = null;

    static {
        a = new p2();
    }

    public p2() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Throwable) r2, "it");
        tt5.a.k("Wiki_WikiTreeRepository", "requestWikiTreeWithPathResolve failed, fallback to legacy tree");
        return new ar5.b.a(false);
    }
}
