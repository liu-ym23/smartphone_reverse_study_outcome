package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class i1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiTreeMoreProvider f242495a;

    public i1(WikiTreeMoreProvider r100) {
        this.f242495a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f242495a.f242351s = true;
        tt5.a.d("WikiTreeMoreProvider", "bindSpaceInfo fail: " + ((Throwable) r100));
        this.f242495a.g();
    }
}
