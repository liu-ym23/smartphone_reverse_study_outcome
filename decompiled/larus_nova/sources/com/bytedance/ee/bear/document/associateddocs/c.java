package com.bytedance.ee.bear.document.associateddocs;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f218991a;

    public c(a.e r100) {
        this.f218991a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("AssociatedDocNetExecutor", "associatedExitingDoc error, " + ((Throwable) r100).getMessage());
        this.f218991a.a(-1, null);
    }
}
