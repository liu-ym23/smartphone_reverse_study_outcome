package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y<T> f211642a = null;

    static {
        f211642a = new y();
    }

    public y() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("SelectFieldEditViewHolder", "fetch new option meta failed, " + ((Throwable) r100));
    }
}
