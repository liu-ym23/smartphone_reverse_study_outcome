package com.bytedance.ee.bear.middleground.permission.email;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f233844a = null;

    static {
        f233844a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("InviteEmailRouteActivity", "show()...error = " + ((Throwable) r100));
    }
}
