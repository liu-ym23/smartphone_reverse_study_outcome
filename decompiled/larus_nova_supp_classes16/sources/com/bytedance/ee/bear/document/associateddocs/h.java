package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.plugin.AssociatedAppUrlPlugin;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ a.e a;

    public h(AssociatedAppUrlPlugin.d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Result r4 = (Result) r3;
        if (r4.code != 0) goto L5;
        tt5.a.h("AssociatedDocNetExecutor", "disassociateExitingDoc success,");
    L5:
        this.a.a(r4.code, "");
    }
}
