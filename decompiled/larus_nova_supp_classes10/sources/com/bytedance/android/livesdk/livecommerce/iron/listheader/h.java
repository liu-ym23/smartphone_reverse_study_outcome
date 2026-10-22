package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.event.d2;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ gi2.a b;
    public final /* synthetic */ String c;

    public h(List r1, gi2.a r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r0 = this.a;     // Catch: Throwable -> L12
        if (r0 == null) goto L15;
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L27;
        RitTagTrack r4 = ((ECRitTag) r1.next()).getTagTrack();     // Catch: Throwable -> L12
        gi2.a r2 = this.b;     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        if (r4 == null) goto L6;
        int r3 = d2.a;     // Catch: Throwable -> L12
        d2.d(r2, "live_shop_entrance_cart_list", r4, null, "a1.b0715.c9204.d7082", this.c);     // Catch: Throwable -> L12
        goto L6
    L27:
        return;
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L26;
        throw th;
    }
}
