package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class p2<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p2<T, R> f242002a = null;

    static {
        f242002a = new p2();
    }

    public p2() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((Throwable) r100, "it");
        tt5.a.k("Wiki_WikiTreeRepository", "requestWikiTreeWithPathResolve failed, fallback to legacy tree");
        return new ar5.b.a(false);
    }
}
