package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedPluginsInfo;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedUrlInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f218992a;

    public d(AssociatedDocViewModel.b r100) {
        this.f218992a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        a.b r101 = this.f218992a;
        AssociatedUrlInfo r102 = (AssociatedUrlInfo) ((Result) r100).data;
        if (r102 == null) goto L5;
        AssociatedPluginsInfo r103 = r102.getPluginsInfo();
    L6:
        r101.a(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
