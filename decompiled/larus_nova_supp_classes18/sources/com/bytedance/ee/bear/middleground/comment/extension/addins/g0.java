package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 implements Runnable {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ e0.e b;
    public final /* synthetic */ ef5.m c;
    public final /* synthetic */ int d;

    public g0(RecyclerView r1, e0.e r2, ef5.m r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.a.isAttachedToWindow() == false) goto L10;
        this.b.c(this.c, this.d);     // Catch: Throwable -> L7
        return;
    }
}
