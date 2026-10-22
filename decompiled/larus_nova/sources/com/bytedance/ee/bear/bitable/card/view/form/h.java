package com.bytedance.ee.bear.bitable.card.view.form;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f208445a;

    public h(e.a r100) {
        this.f208445a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("ShareUtils", "forms share failed", (Throwable) r100, false);
        e.b r101 = this.f208445a.f208436f;
        if (r101 == null) goto L6;
        r101.onError();
        return;
    }
}
