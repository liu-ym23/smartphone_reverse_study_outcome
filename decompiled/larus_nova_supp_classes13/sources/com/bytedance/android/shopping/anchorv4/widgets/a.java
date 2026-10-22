package com.bytedance.android.shopping.anchorv4.widgets;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ ECCoordinatorRecyclerView a;

    public a(ECCoordinatorRecyclerView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.j.isFinished() == false) goto L9;
        RecyclerView r0 = this.a;     // Catch: Throwable -> L6
        r0.y(r0, 0);     // Catch: Throwable -> L6
        ECCoordinatorRecyclerView r1 = this.a;     // Catch: Throwable -> L6
        r1.y(r1.getSecondaryScrollView(), 0);     // Catch: Throwable -> L6
        return;
    }
}
