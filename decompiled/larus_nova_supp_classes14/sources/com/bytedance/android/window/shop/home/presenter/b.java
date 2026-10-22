package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ AbsWindowFloatPresenter a;

    public b(AbsWindowFloatPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Pair r3 = (Pair) r2;
        if ((!Intrinsics.areEqual(this.a.h, Boolean.TRUE)) == true) goto L7;
        this.a.N();
        return;
    }
}
