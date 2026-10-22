package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a3<T> implements Observer {
    public final /* synthetic */ t2.b a;

    public a3(t2.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Float r2 = (Float) r1;
        t2.r0(this.a.a);
    }
}
