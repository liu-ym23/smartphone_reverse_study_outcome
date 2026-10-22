package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.quoto.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f218995a;

    public g(a.e r100) {
        this.f218995a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f218995a.a(-1, null);
        ((t) org.koin.java.a.c(t.class, null, null, 6)).a(r101, null);
        ((t) org.koin.java.a.c(t.class, null, null, 6)).p(r101, null, false);
        tt5.a.d("AssociatedDocNetExecutor", "createAndAssociatedDoc error, " + r101.getMessage());
    }
}
