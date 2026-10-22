package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.a1;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.z0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z implements Runnable {
    public final /* synthetic */ PromotionListEventActionImplV2 a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public z(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        LiveRoomParams r0 = this.b.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        ECUIPromotionV2 r1 = this.b.a;
        if (r1 == null) goto L32;
        ECUIPromotionV2 r2 = r1;
        StringBuilder r3 = new StringBuilder("livesdk_");
        z0 r4 = r2.getImage();
        String r5 = null;
        if (r4 == null) goto L11;
        a1 r6 = r4.c();
        if (r6 == null) goto L11;
        s1 r7 = r6.g();
        if (r7 == null) goto L11;
        String r8 = r7.c();
    L12:
        String r9 = "";
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        r3.append(r8);
        r3.append('_');
        r3.append(this.c);
        String r10 = r3.toString();
        z0 r11 = r2.getImage();
        if (r11 == null) goto L22;
        a1 r12 = r11.c();
        if (r12 == null) goto L22;
        s1 r13 = r12.g();
        if (r13 == null) goto L22;
        Map r14 = r13.d();
    L23:
        sg2.v r15 = new sg2.v(r10, this.b);
        if (r0 == null) goto L26;
        r5 = r0.getAuthorId();
    L26:
        if (r5 == null) goto L29;
        r9 = r5;
    L29:
        r15.c("author_id", r9);
        r15.c("commodity_id", r2.getPromotionId());
        r15.c("commodity_type", r2.getEventItemType());
        r15.c("product_id", r2.getProductId());
        r15.a("with_sku", !r2.getSingleSku() ? 1 : 0);
        r15.d(r14);
        r15.d(r2.getEventParams());
        PromotionListEventActionImplKt.a(r15, this.a.a, this.d);
        return;
    L22:
        r14 = null;
    L11:
        r8 = null;
        goto L12
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
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
