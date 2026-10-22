package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class q0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceMoreProvider f242541a;

    public q0(WikiSpaceMoreProvider r100) {
        this.f242541a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("WikiSpaceMoreProvider", "loadSpaceInfoFromNetwork fail: " + ((Throwable) r100));
        this.f242541a.g();
    }
}
