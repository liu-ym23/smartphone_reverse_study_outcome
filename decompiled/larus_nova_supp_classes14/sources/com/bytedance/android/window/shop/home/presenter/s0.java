package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.window.shop.repository.vo.ShopComponentResponseVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s0<T> implements Observer {
    public final /* synthetic */ t0 a;

    public s0(t0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        String r5 = ((ShopComponentResponseVO) r4).getExtraSchema();
        if (com.bytedance.android.shopping.extensions.k.c(r5) == true) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L14;
        t0 r0 = this.a;
        if (r0.m != null) goto L10;
        r0.m = new PthreadTimer("ECWindowExtraAibilityPresenter$openExtraSchema$1");
    L10:
        t0 r1 = this.a;
        r1.n = new r0(r5, this);
        t0 r6 = this.a;
        Timer r2 = r6.m;
        if (r2 == null) goto L15;
        r2.schedule(r6.n, 500);
        return;
    L15:
        return;
    }
}
