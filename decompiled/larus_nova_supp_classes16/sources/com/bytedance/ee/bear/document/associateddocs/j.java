package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.bean.AppUrlAssociatedDocResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ a.InterfaceC0055a a;

    public j(AssociatedDocViewModel.c r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r2) {
        this.a.a((AppUrlAssociatedDocResult) ((Result) r2).data);
    }
}
