package com.bytedance.ee.bear.middleground.comment.card;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.uitls.RecyclerViewScrollHelper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 implements Runnable {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ RecyclerViewScrollHelper.SetSmoothScroller b;

    public m0(RecyclerView r1, RecyclerViewScrollHelper.SetSmoothScroller r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerViewScrollHelper.b(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
