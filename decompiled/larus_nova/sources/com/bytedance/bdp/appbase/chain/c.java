package com.bytedance.bdp.appbase.chain;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes11.dex */
public final class c<T, R> implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f200690a;

    public c(Function2 r100) {
        this.f200690a = r100;
    }

    @Override // com.bytedance.bdp.appbase.chain.j
    public /* bridge */ /* synthetic */ Object call(Object r100, f r101) {
        return call((Throwable) r100, r101);
    }

    public final R call(Throwable r100, f r101) {
        return (R) this.f200690a.invoke(r101, r100);
    }
}
