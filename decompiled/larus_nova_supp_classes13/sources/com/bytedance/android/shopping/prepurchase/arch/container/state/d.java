package com.bytedance.android.shopping.prepurchase.arch.container.state;

import androidx.lifecycle.MutableLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> extends ObservableData<T> {
    public d() {
        super(new MutableLiveData());
    }

    public d(T r2) {
        super(new MutableLiveData(r2));
    }

    public final void g(T r2) {
        MutableLiveData r0 = this.c;
        if (r0 == null) goto L7;
        r0.setValue(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T>");
    }
}
