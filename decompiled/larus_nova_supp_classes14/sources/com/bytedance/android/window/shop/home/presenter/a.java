package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ AbsWindowFloatPresenter a;

    public a(AbsWindowFloatPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual(this.a.h, Boolean.TRUE)) == false) goto L5;
        return;
    L5:
        this.a.N();
    }
}
