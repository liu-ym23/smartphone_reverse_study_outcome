package com.bytedance.ee.bear.bitable.filter.condition;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u<T> f211870a = null;

    static {
        f211870a = new u();
    }

    public u() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("UserFilterConditionView", "checkDataContentChanged failed, " + ((Throwable) r100));
    }
}
