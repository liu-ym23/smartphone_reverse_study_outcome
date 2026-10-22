package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.document.associateddocs.plugin.AssociatedAppUrlPlugin;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.e f218997a;

    public i(AssociatedAppUrlPlugin.d r100) {
        this.f218997a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("AssociatedDocNetExecutor", "disassociateExitingDoc error, " + ((Throwable) r100).getMessage());
        this.f218997a.a(-1, "");
    }
}
