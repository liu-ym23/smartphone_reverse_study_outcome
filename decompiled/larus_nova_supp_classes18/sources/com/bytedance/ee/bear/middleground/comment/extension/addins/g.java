package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements Runnable {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ f c;

    public g(com.bytedance.ee.bear.middleground.comment.uitls.p r1, RecyclerView r2, f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.a.getActivity().isFinishing() == false) goto L5;
        return;
    L5:
        if (this.b.isAttachedToWindow() == false) goto L15;
        uu5.m<RecyclerView> r0 = this.c.c();     // Catch: Throwable -> L8
        f r1 = this.c;     // Catch: Throwable -> L8
        RecyclerView r2 = this.b;     // Catch: Throwable -> L8
        r1.c.add(r0);     // Catch: Throwable -> L8
        r0.a(r2);     // Catch: Throwable -> L8
        return;
    }
}
