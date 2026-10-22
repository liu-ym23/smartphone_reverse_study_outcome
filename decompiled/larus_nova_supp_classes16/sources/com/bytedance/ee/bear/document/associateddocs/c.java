package com.bytedance.ee.bear.document.associateddocs;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ a.e a;

    public c(a.e r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.d("AssociatedDocNetExecutor", "associatedExitingDoc error, " + ((Throwable) r3).getMessage());
        this.a.a(-1, null);
    }
}
