package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ ExplainCardWidgetController a;
    public final /* synthetic */ ECUIPromotion b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function1 e;

    public l(ExplainCardWidgetController r1, ECUIPromotion r2, boolean r3, String r4, Function1 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExplainCardWidgetController r0 = this.a;     // Catch: Throwable -> L7
        if (r0.m == true) goto L10;
        ExplainCardWidgetController.b(r0, this.b, false, true, this.c, this.d, this.e);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
