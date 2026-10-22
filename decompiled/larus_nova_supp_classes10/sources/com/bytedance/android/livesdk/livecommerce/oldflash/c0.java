package com.bytedance.android.livesdk.livecommerce.oldflash;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0<T> implements Observer {
    public final /* synthetic */ LiveFlashNewFragment a;

    public c0(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        a r4 = (a) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.q == true) goto L7;
        LiveFlashNewFragment.na0(this.a);
    L7:
        r4.g = "";
        r4.q = !r4.q;
        LiveFlashNewFragment r0 = this.a;
        int r1 = LiveFlashNewFragment.w;
        LiveFlashViewModel r2 = (LiveFlashViewModel) r0.g;
        if (r2 == null) goto L12;
        q r5 = r2.getEventHelper();
        if (r5 == null) goto L12;
        r5.a(r4.q, r4.b);
    L12:
        LiveFlashNewFragment.ra0(this.a);
        this.a.la0(false, false);
    }
}
