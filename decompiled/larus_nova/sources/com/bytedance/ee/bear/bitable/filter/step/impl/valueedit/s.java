package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s<T> f212023a = null;

    static {
        f212023a = new s();
    }

    public s() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("SelectFilterValueEditViewHolder", "fetch color list failed, " + ((Throwable) r100));
    }
}
