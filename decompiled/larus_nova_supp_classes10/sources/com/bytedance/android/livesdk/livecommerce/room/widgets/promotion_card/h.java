package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ ExplainCardWidgetController a;

    public h(ExplainCardWidgetController r1) {
        this.a = r1;
    }

    public final void a() {
        ExplainCardViewModel r0 = this.a.e;
        if (r0 == null) goto L14;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L15;
        ECUIPromotion r2 = (ECUIPromotion) r1.a();
        if (r2 == null) goto L16;
        String r3 = r2.getScheme();
        if (r3 == null) goto L17;
        int r4 = ECSdk.a;
        ca3.c r5 = (ca3.c) ECSdk.a(ca3.c.class);
        if (r5 == null) goto L18;
        r5.b("live", CollectionsKt.mutableListOf(new String[]{r3}), "card");
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
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
