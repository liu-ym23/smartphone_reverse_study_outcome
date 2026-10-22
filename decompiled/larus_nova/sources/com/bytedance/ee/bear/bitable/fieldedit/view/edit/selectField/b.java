package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f211579a = null;

    static {
        f211579a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DynamicViewHolder", "fetch new conditionId fail when add new", (Throwable) r100, false);
    }
}
