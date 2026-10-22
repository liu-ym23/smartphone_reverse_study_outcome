package com.bytedance.ee.bear.document.associateddocs;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f218993a;

    public e(AssociatedDocViewModel.b r100) {
        this.f218993a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f218993a.a(null);
        tt5.a.d("AssociatedDocNetExecutor", "createAndAssociatedDoc error, " + ((Throwable) r100).getMessage());
    }
}
