package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i3<T> implements Observer {
    public final /* synthetic */ ECShopTopBarSearchPresenterV2 a;

    public i3(ECShopTopBarSearchPresenterV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Float r5 = (Float) r4;
        ECShopTopBarSearchPresenterV2.s0(this.a, r5.floatValue());
        ECShopTopBarSearchPresenterV2 r0 = this.a;
        float r6 = r5.floatValue();
        if (r0.u0() == false) goto L10;
        float r7 = RangesKt.coerceIn(1.0f - r6, 0.0f, 1.0f);
        r0.x0(r7, r0.t0());
        ECStoreCollapsibleTextView r1 = r0.u;
        if (r1 == null) goto L9;
        r1.f(r7);
        return;
    L9:
        return;
    }
}
