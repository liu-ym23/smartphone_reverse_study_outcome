package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f3<T> implements Observer {
    public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

    public f3(ECShopTopBarSearchPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        uj3.j r3 = (uj3.j) r2;
        if (r3.f() == true) goto L12;
        uj3.j r4 = r3.a;
        if (r4 != null) goto L7;
    L9:
        ECViewFlipper r5 = this.a.x;
        if (r5 == null) goto L16;
        r5.startFlipping();
        return;
    L16:
        return;
    L7:
        if (r4.f() != true) goto L9;
    L12:
        ECViewFlipper r6 = this.a.x;
        if (r6 == null) goto L18;
        r6.stopFlipping();
        return;
    }
}
