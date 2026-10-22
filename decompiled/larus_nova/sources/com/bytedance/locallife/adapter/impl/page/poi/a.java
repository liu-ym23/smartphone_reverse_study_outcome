package com.bytedance.locallife.adapter.impl.page.poi;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes20.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f256495a = null;

    static {
        f256495a = new a();
    }

    public a() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 == null) goto L7;
        r101.intValue();
        return;
    }
}
