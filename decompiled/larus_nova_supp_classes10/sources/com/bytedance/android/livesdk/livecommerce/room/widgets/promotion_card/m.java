package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements Runnable {
    public final /* synthetic */ ExplainCardWidgetController a;

    public m(ExplainCardWidgetController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.a.a(this.a, null, null, 7);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
