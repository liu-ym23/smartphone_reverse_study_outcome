package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t<T> f211645a = null;

    static {
        f211645a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("BitableFieldEditFragment", "fetch meta failed, " + ((Throwable) r100));
    }
}
