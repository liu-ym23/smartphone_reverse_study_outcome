package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements Runnable {
    public final /* synthetic */ RelatedCardWidgetController a;

    public w(RelatedCardWidgetController r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RelatedCardWidgetController r0 = this.a;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        UtilityKotlinExtentionsKt.b.post(new v(r0));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
