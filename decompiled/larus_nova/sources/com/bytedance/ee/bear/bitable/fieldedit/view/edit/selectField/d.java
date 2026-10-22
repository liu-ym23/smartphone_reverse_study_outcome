package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f211615a = null;

    static {
        f211615a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DynamicViewHolder", "fetch field fails when targetFieldBean", (Throwable) r100, false);
    }
}
