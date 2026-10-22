package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ InteractionAutoRecycleView a;

    public final void a() {
        LinearLayoutManager r0 = this.a.getLayoutManager();
        if (r0 == null) goto L12;
        LinearLayoutManager r1 = r0;
        this.a.c.setTargetPosition(r1.findLastVisibleItemPosition() + 1);
        int r2 = this.a.c.getTargetPosition();
        RecyclerView.Adapter r3 = this.a.getAdapter();
        if (r3 == null) goto L7;
        int r4 = r3.getItemCount();
    L8:
        if (r2 >= r4) goto L13;
        r1.startSmoothScroll(this.a.c);
        InteractionAutoRecycleView.r(this.a).postDelayed(this, 1500);
        return;
    L13:
        return;
    L7:
        r4 = 0;
        goto L8
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
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

    public c(InteractionAutoRecycleView r1) {
        this.a = r1;
    }
}
