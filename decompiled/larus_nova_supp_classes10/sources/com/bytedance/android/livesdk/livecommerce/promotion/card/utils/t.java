package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements Runnable {
    public final /* synthetic */ PromotionListEventActionImplV2 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;

    public t(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2) {
        this.a = r1;
        this.b = "livesdk_have_seen_cover_animation_icon";
        this.c = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r1 = this.b;     // Catch: Throwable -> L7
        com.bytedance.android.ec.common.api.jump.model.b r2 = this.c;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        r2 = com.bytedance.android.ec.common.api.jump.model.b.a;     // Catch: Throwable -> L7
    L5:
        PromotionListEventActionImplKt.a(new sg2.v(r1, r2), this.a.a, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
