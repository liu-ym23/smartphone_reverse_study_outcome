package com.bytedance.ee.bear.middleground.comment.card;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements Runnable {
    public final /* synthetic */ FloatCardComment a;

    public l(FloatCardComment r1) {
        this.a = r1;
    }

    public final void a() {
        int r0 = com.bytedance.ee.util.ui.n.E(this.a.h());
        tt5.a.h("Comment#CardComment2", "Switch panelHeight2 = " + r0);
        this.a.f.W().invoke(Integer.valueOf(r0));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
