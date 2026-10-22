package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.bean.AppUrlAssociatedDocResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC3111a f218998a;

    public j(AssociatedDocViewModel.c r100) {
        this.f218998a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f218998a.a((AppUrlAssociatedDocResult) ((Result) r100).data);
    }
}
