package com.bytedance.android.window.shop.home;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ECWindowParam c;

    public h(k r1, String r2, ECWindowParam r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        if (((Boolean) r5).booleanValue() == false) goto L7;
        List<Runnable> r6 = this.a.a;
        ArrayList r7 = (ArrayList) r6;
        r7.add(new g(this.b, this.c.getAuthorId(), this.c.getSecAuthorId()));
        return;
    }
}
