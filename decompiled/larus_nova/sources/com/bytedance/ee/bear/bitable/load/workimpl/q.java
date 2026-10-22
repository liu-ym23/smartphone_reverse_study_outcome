package com.bytedance.ee.bear.bitable.load.workimpl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<T> f214584a = null;

    static {
        f214584a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.f("SetupTimeOutWork", r101, false);
        iu5.d.a("SetupTimeOutWork", r101);
    }
}
