package com.bytedance.ee.bear.wikiv2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiFragment f240690a;

    public e(WikiFragment r100) {
        this.f240690a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        WikiFragment r101 = this.f240690a;
        int r102 = WikiFragment.f240459l;
        r101.Z90().c(0);
        ((wwc.c) r100).request(Long.MAX_VALUE);
    }
}
