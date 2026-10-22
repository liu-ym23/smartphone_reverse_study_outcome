package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements Runnable {
    public final /* synthetic */ ql.a a;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ il2.a d;

    public s(PromotionJumpDispatcher r1, ql.a r2, com.bytedance.android.btm.api.model.d r3, Context r4, il2.a r5) {
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final void a() {
        ECUILotteryInfo r0 = this.a.getLotteryInfo();
        if (r0 == null) goto L13;
        String r1 = r0.getJumpUrl();
        if (r1 == null) goto L13;
        UrlBuilderV2 r2 = new UrlBuilderV2(r1);
        r2.addOrReplaceParam("page_init_timestamp", System.currentTimeMillis());
        BtmUtilsKt.c(r2, this.b);
        String r3 = r2.build();
        if (r3 == null) goto L13;
        Context r4 = this.c;
        Handler r5 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.room.f.b(r4, r3);
        il2.a r6 = this.d;
        if (r6 == null) goto L19;
        il2.a r7 = il2.a.C0145a.a(r6, "open_lottery_panel", MapsKt.mapOf(TuplesKt.to("lottery_schema", r3)), false, null, null, null, 60);
        if (r7 == null) goto L20;
        ((LiveActionTracker) r7).e(false);
        return;
    L20:
        return;
    L19:
        return;
    L13:
        il2.a r8 = this.d;
        if (r8 == null) goto L22;
        il2.a r9 = il2.a.C0145a.a(r8, "open_lottery_panel", null, false, "schema_is_null", null, null, 48);
        if (r9 == null) goto L23;
        ((LiveActionTracker) r9).e(false);
        Unit r10 = Unit.INSTANCE;
        return;
    L23:
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
