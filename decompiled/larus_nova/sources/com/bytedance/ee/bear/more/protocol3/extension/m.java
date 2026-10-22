package com.bytedance.ee.bear.more.protocol3.extension;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T> f234837a = null;

    static {
        f234837a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DefMoreInfoBehavior", "objInfoFlow err. ", (Throwable) r100, false);
    }
}
