package com.ss.android.lark.conditional.access.display;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomDisplayModule f418055a;

    public b(CustomDisplayModule r100) {
        this.f418055a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        this.f418055a.b(0);
    }
}
