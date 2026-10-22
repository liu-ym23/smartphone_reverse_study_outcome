package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ h a;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l b;

    public k(h r1, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        this.a.f = null;
        int r0 = r5.intValue() + 1;
        if (r5.intValue() >= 0) goto L5;
    L13:
        this.a.b.add(r5);
        h r6 = this.a;
        if (r6.d == true) goto L19;
        Runnable r7 = r6.f;
        if (r7 == null) goto L20;
        r7.run();
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (this.a.b.contains(Integer.valueOf(r0)) == true) goto L13;
        List<com.bytedance.android.ec.model.k> r1 = this.b.b;
        if (r1 == null) goto L13;
        com.bytedance.android.ec.model.k r2 = (com.bytedance.android.ec.model.k) CollectionsKt.getOrNull(r1, r0);
        if (r2 == null) goto L13;
        if (r2.getType() != 2) goto L13;
        h r3 = this.a;
        r3.f = new j(this, r0);
        goto L13
    }
}
