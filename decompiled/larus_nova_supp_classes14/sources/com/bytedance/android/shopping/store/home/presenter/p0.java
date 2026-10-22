package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p0<T> implements Observer {
    public final /* synthetic */ o0 a;
    public final /* synthetic */ float b;

    public p0(o0 r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        this.a.r0(this.b, r6.intValue() & 16777215, r6.intValue());
    }
}
