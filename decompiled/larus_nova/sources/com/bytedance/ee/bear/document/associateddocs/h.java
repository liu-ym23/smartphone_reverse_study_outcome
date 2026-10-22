package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.plugin.AssociatedAppUrlPlugin;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f218996a;

    public h(AssociatedAppUrlPlugin.d r100) {
        this.f218996a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result r101 = (Result) r100;
        if (r101.code != 0) goto L5;
        tt5.a.h("AssociatedDocNetExecutor", "disassociateExitingDoc success,");
    L5:
        this.f218996a.a(r101.code, "");
    }
}
