package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ PromotionCardLoadOptUtils a;

    public j(PromotionCardLoadOptUtils r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OptCardUtil.b(null, "handleResponse invoke callback");     // Catch: Throwable -> L6
        Function1<? super ECUIPromotion, Unit> r0 = this.a.g;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.invoke(this.a.d);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
