package com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown;

import com.bytedance.android.ec.core.utils.l1;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements l1.a {
    public final /* synthetic */ AuctionCountDownService a;

    public final void onFinish() {
        Iterator<T> r0 = this.a.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((l1.a) r0.next()).onFinish();
        goto L4
    }

    public final void onStart() {
        Iterator<T> r0 = this.a.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((l1.a) r0.next()).onStart();
        goto L4
    }

    public a(AuctionCountDownService r1) {
        this.a = r1;
    }

    public final void onTick(long r3) {
        AuctionCountDownService r0 = this.a;
        r0.l = true;
        Iterator<T> r1 = r0.k.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((l1.a) r1.next()).onTick(r3);
        goto L4
    L6:
        this.a.l = false;
    }
}
