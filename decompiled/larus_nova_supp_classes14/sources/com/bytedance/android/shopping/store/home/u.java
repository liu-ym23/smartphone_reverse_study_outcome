package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.arch.FoldAdaptedFrameLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ FoldAdaptedFrameLayout a;

    public u(FoldAdaptedFrameLayout r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        FoldAdaptedFrameLayout r0 = this.a;
        if (r0 == null) goto L6;
        r0.setAdaptedEnabled(r3.booleanValue());
        return;
    }
}
