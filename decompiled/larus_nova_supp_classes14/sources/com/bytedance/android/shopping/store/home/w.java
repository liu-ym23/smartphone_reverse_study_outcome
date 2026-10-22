package com.bytedance.android.shopping.store.home;

import com.bytedance.android.shopping.store.arch.FoldAdaptedFrameLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ FoldAdaptedFrameLayout a;

    public w(FoldAdaptedFrameLayout r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L8;
        FoldAdaptedFrameLayout r3 = this.a;
        if (r3 == null) goto L9;
        r3.setBackgroundColor(0);
        return;
    L9:
        return;
    }
}
