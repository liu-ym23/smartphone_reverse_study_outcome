package com.bytedance.android.shopping.mall.homepage.card.live;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public final CopyOnWriteArrayList<b> a;
    public final CopyOnWriteArrayList<c> b;

    public n() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
    }

    public final void a(boolean r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).j(r3);
        goto L4
    }
}
