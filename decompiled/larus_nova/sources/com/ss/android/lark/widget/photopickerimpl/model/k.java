package com.ss.android.lark.widget.photopickerimpl.model;

import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: classes38.dex */
public final class k<T> implements RxScheduledExecutor.Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T> f447817a = null;

    static {
        f447817a = new k();
    }

    public k() {
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Object r100) {
        int r101 = ldc.h.f508886a;
        ldc.h.b.a("PP_PhotoModel", "refresh error : " + ((Throwable) r100));
    }
}
