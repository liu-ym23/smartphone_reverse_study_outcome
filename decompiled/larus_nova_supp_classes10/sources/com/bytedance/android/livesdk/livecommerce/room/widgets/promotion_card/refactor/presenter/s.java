package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements Runnable {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ r b;
    public final /* synthetic */ List c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;

    public s(ViewGroup r1, r r2, List r3, int r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.E(this.b, this.d + 1, this.c, this.e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
