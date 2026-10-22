package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y1<T> implements Observer {
    public final /* synthetic */ w1 a;

    public y1(w1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        String r7 = ((com.bytedance.android.shopping.store.home.entity.l) r6).b;
        if (com.bytedance.android.shopping.extensions.k.c(r7) == true) goto L6;
        r7 = null;
    L6:
        if (r7 == null) goto L11;
        w1 r0 = this.a;
        if (r0.w == false) goto L12;
        com.bytedance.android.ec.sdk.helper.p r2 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r1 = r0.u().c();
        int r3 = com.bytedance.android.ec.store.utils.b.a;
        r2.openSchema(r1, com.bytedance.android.ec.store.utils.b.b(r7, "c366460.d75972", PageFinder.via(this.a.y()), null));
        this.a.w = false;
        return;
    L12:
        return;
    }
}
