package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T> f211990a = null;

    static {
        f211990a = new f();
    }

    public f() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("DateFilterValueEditViewHolder", "getFilterDurations failed, " + ((Throwable) r100));
    }
}
