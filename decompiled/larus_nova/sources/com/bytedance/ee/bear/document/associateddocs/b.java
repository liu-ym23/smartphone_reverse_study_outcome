package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f218989a;

    public b(a.e r100) {
        this.f218989a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("AssociatedDocNetExecutor", "associatedExitingDoc success");
        this.f218989a.a(((Result) r100).code, "");
    }
}
