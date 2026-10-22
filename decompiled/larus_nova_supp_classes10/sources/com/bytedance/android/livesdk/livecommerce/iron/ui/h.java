package com.bytedance.android.livesdk.livecommerce.iron.ui;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.livesdk.livecommerce.event.g0;
import com.bytedance.android.livesdk.livecommerce.event.v0;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xi2.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ ECPromotionListHintBannerView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ECPromotionList.p c;
    public final /* synthetic */ JSONObject d;

    public h(ECPromotionListHintBannerView r1, String r2, ECPromotionList.p r3, JSONObject r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        Map<String, String> r2 = null;
        g0 r0 = new g0(this.b, null);
        m0 r1 = this.c.trackInfo;
        if (r1 == null) goto L5;
        r2 = r1.c();
    L5:
        r0.g(r2);
        r0.l("a1.b0715.c298306.d93817", BtmSDK.INSTANCE.getPageId(PageFinder.via(this.a)));
        if (this.c.bannerType != 6) goto L19;
        JSONObject r3 = this.d;
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.optString("creative_id").length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L21;
        v0 r5 = new v0("live_show_exchange_coupon_entrance");
        r5.o();
        Pair[] r6 = new Pair[2];
        r6[0] = TuplesKt.to("anchor_id", this.d.optString("anchor_id"));
        String r7 = this.a.a;
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        r6[1] = TuplesKt.to("room_id", r7);
        r5.n(MapsKt.mapOf(r6));
        String r8 = this.d.optString("creative_id");
        Intrinsics.checkNotNullParameter(r8, "creativeId");
        r5.f("value", r8);
        String r9 = this.d.optString("log_extra");
        Intrinsics.checkNotNullParameter(r9, "logExtra");
        r5.f("log_extra", r9);
        r5.k();
        return;
    L21:
        return;
    L12:
        r4 = false;
        goto L13
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
