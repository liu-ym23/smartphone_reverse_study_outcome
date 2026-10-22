package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l<T> f211441a = null;

    static {
        f211441a = new l();
    }

    public l() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("BitableFieldEditFragment", "checkConfirm failed, " + ((Throwable) r100));
    }
}
