package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n<T> f211629a = null;

    static {
        f211629a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("DynamicViewHolder", "fetch field fails in observeTableBean", (Throwable) r100, false);
    }
}
