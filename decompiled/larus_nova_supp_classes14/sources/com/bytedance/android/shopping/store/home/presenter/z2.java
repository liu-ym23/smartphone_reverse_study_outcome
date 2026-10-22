package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z2<T> implements Observer {
    public final /* synthetic */ t2.b a;

    public z2(t2.b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        Pair r2 = (Pair) r1;
        t2.r0(this.a.a);
    }
}
