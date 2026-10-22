package com.bytedance.ee.bear.document.associateddocs;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ a.b a;

    public e(AssociatedDocViewModel.b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        this.a.a(null);
        tt5.a.d("AssociatedDocNetExecutor", "createAndAssociatedDoc error, " + ((Throwable) r3).getMessage());
    }
}
