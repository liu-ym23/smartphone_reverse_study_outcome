package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y0<T> implements Consumer {
    public final /* synthetic */ WikiTreeCtrlView a;

    public y0(WikiTreeCtrlView r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        String r0 = this.a.e;
        tt5.a.e(r0, "requestNodePerm fail. ", (Throwable) r4, false);
    }
}
