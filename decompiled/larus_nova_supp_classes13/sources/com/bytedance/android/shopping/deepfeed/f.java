package com.bytedance.android.shopping.deepfeed;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductRecyclerview;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Runnable {
    public final /* synthetic */ DeepFeedProductRecyclerview a;
    public final /* synthetic */ LinearLayoutManager b;
    public final /* synthetic */ DeepFeedProductFragment c;

    public f(DeepFeedProductRecyclerview r1, LinearLayoutManager r2, DeepFeedProductFragment r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.isComputingLayout() == true) goto L13;
        View r0 = this.c.m.findSnapView(this.b);
        if (r0 == null) goto L14;
        this.c.V = this.b.getPosition(r0);
        int[] r1 = this.c.m.calculateDistanceToFinalSnap(this.b, r0);
        if (r1[0] == 0) goto L9;
    L10:
        Logger.i(this.c.K, "start scolly by " + r1[0] + ", " + r1[1]);
        this.a.scrollBy(r1[0], r1[1]);
    L11:
        this.c.ma0(this.b, r0, false, false);
        return;
    L9:
        if (r1[1] == 0) goto L11;
    L14:
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
