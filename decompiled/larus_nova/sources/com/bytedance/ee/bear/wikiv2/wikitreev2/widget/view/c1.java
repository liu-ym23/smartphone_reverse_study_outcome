package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiTreeCtrlView f242426a;

    public c1(WikiTreeCtrlView r100) {
        this.f242426a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = this.f242426a.f242305e;
        tt5.a.e(r101, "fetchDocObjInfo fail. ", (Throwable) r100, false);
    }
}
