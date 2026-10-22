package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a.e a;

    public b(a.e r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.h("AssociatedDocNetExecutor", "associatedExitingDoc success");
        this.a.a(((Result) r3).code, "");
    }
}
