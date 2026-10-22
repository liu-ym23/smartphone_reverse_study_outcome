package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class s0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceMoreProvider f242550a;

    public s0(WikiSpaceMoreProvider r100) {
        this.f242550a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("WikiSpaceMoreProvider", "getRootPermPuller fail: " + ((Throwable) r100));
        this.f242550a.g();
    }
}
