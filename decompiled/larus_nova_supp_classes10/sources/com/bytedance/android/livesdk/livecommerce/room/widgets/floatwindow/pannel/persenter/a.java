package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter;

import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ScrollingLinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Runnable {
    public final /* synthetic */ ECFloatWindowCarouselPresenter a;
    public final /* synthetic */ ScrollingLinearLayoutManager b;
    public final /* synthetic */ RecyclerView c;

    public a(ECFloatWindowCarouselPresenter r1, ScrollingLinearLayoutManager r2, RecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ECFloatWindowCarouselPresenter r0 = this.a;
        if (r0.o == true) goto L6;
        return;
    L6:
        if (r0.E().getItemCount() <= 1) goto L27;
        View r1 = ((PagerSnapHelper) this.a.g.getValue()).findSnapView(this.b);
        if (r1 == null) goto L28;
        int r2 = this.b.getPosition(r1);
        if (r2 == (-1)) goto L29;
        int r3 = (r2 + 1) % this.a.E().getItemCount();
        int r4 = this.a.E().getItemCount();
        if (r3 < 0) goto L19;
        if (r4 <= r3) goto L19;
        this.c.smoothScrollToPosition(r3);
    L19:
        ECFloatWindowCarouselPresenter r5 = this.a;
        a r6 = r5.l;
        if (r5.o == false) goto L24;
        if (r6 == null) goto L25;
        r5.n.postDelayed(r6, r5.m);
        return;
    L25:
        return;
    L24:
        return;
    L29:
        return;
    L28:
        return;
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
