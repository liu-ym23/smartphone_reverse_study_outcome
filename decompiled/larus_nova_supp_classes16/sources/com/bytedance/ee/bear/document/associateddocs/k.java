package com.bytedance.ee.bear.document.associateddocs;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ a.InterfaceC0055a a;

    public k(AssociatedDocViewModel.c r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.a(null);
        tt5.a.d("AssociatedDocNetExecutor", "createAndAssociatedDoc error, " + ((Throwable) r3).getMessage());
    }
}
