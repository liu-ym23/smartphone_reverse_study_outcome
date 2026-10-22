package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.quoto.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ a.e a;

    public g(a.e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        this.a.a(-1, null);
        ((t) org.koin.java.a.c(t.class, null, null, 6)).a(r5, null);
        ((t) org.koin.java.a.c(t.class, null, null, 6)).p(r5, null, false);
        tt5.a.d("AssociatedDocNetExecutor", "createAndAssociatedDoc error, " + r5.getMessage());
    }
}
