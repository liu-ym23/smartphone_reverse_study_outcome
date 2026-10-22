package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n<T> implements Observer {
    public final /* synthetic */ ECShopBackgroundPresenterBrand.a a;

    public n(ECShopBackgroundPresenterBrand.a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        if (r6.intValue() <= 0) goto L6;
        return;
    L6:
        if (this.a.a.T().isCroppedStyle() == true) goto L20;
        ECShopBackgroundPresenterBrand r0 = this.a.a;
        int r7 = r6.intValue();
        if (r0.E <= 0) goto L21;
        dm.a.a("ECShopBackgroundPresenterBrand").a("updatebgSize " + r7);
        Ref.IntRef r1 = new Ref.IntRef();
        r1.element = r0.E + Math.abs(r7);
        Ref.IntRef r8 = new Ref.IntRef();
        r8.element = (r0.F * r1.element) / r0.E;
        ViewGroup r2 = r0.v0();
        if (r2 == null) goto L14;
        wg.a.d(r2, r1.element);
        wg.a.i(r2, r8.element);
        com.bytedance.android.ec.core.utils.d2.d(r2, (-(r8.element - r0.F)) / 2, 0, 0, 0);
        r2.post(new r(r0));
    L14:
        View r9 = (View) r0.z.getValue();
        if (r9 == null) goto L18;
        wg.a.d(r9, (r0.D * r1.element) / r0.E);
        wg.a.i(r9, (r0.F * r1.element) / r0.E);
        return;
    L18:
        return;
    L21:
        return;
    }
}
