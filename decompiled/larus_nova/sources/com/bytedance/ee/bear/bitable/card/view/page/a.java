package com.bytedance.ee.bear.bitable.card.view.page;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f208569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AutoSubscribeConfirmDialog f208570b;

    public a(boolean r100, AutoSubscribeConfirmDialog r101) {
        this.f208569a = r100;
        this.f208570b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SimpleRequestResult r101 = (SimpleRequestResult) r100;
        if (this.f208569a == true) goto L5;
        return;
    L5:
        if (r101.code != 0) goto L9;
        this.f208570b.f208459k.closeAutoSubscribe();
        return;
    }
}
