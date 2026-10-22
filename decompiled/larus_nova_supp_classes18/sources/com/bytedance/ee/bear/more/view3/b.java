package com.bytedance.ee.bear.more.view3;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.more.protocol3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ MoreFragmentV3 a;

    public b(MoreFragmentV3 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        k r4 = (k) r3;
        if ((r4 instanceof zj5.b) == false) goto L5;
        MoreFragmentV3 r0 = this.a;
        int r1 = MoreFragmentV3.n;
        r0.ea0(r4);
        return;
    L5:
        MoreFragmentV3 r2 = this.a;
        int r5 = MoreFragmentV3.n;
        ((MoreAdapter) r2.l.getValue()).z2(r4);
    }
}
