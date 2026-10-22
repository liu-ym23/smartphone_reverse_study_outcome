package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements Runnable {
    public final /* synthetic */ RelatedCardWidgetController a;

    public t(RelatedCardWidgetController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RelatedCardWidgetController.f(this.a, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
