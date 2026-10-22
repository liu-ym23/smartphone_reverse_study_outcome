package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.sdk.helper.p;
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
import sg2.v;
import xi2.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ ECPromotionListHintBannerView g;
    public final /* synthetic */ ECPromotionList.p h;
    public final /* synthetic */ JSONObject i;
    public final /* synthetic */ gi2.a j;
    public final /* synthetic */ int k;

    public static final class a implements Runnable {
        public final /* synthetic */ g a;
        public final /* synthetic */ String b;

        public a(g r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Map<String, String> r2 = null;
            g0 r0 = new g0(this.b, null);
            m0 r1 = this.a.h.trackInfo;
            if (r1 == null) goto L5;
            r2 = r1.c();
        L5:
            r0.g(r2);
            r0.l("a1.b0715.c298306.d93817", BtmSDK.INSTANCE.getPageId(PageFinder.via(this.a.g)));
            g r3 = this.a;
            if (r3.h.bannerType != 6) goto L19;
            JSONObject r4 = r3.i;
            if (r4 != null) goto L10;
            return;
        L10:
            if (r4.optString("creative_id").length() <= 0) goto L12;
            boolean r5 = true;
        L13:
            if (r5 == false) goto L21;
            v0 r6 = new v0("live_click_exchange_coupon_entrance");
            r6.o();
            Pair[] r7 = new Pair[2];
            r7[0] = TuplesKt.to("anchor_id", this.a.i.optString("anchor_id"));
            String r8 = this.a.g.a;
            if (r8 != null) goto L17;
            r8 = "";
        L17:
            r7[1] = TuplesKt.to("room_id", r8);
            r6.n(MapsKt.mapOf(r7));
            String r9 = this.a.i.optString("creative_id");
            Intrinsics.checkNotNullParameter(r9, "creativeId");
            r6.f("value", r9);
            String r10 = this.a.i.optString("log_extra");
            Intrinsics.checkNotNullParameter(r10, "logExtra");
            r6.f("log_extra", r10);
            r6.k();
            return;
        L21:
            return;
        L12:
            r5 = false;
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

    public final void a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        com.bytedance.android.btm.api.model.d r6 = BtmUtilsKt.e("a1.b0715.c298306.d93817", PageFinder.via(this.g));
        p r0 = p.a;
        String r1 = this.h.jumpUrl;
        Map<String, String> r2 = null;
        if (r1 == null) goto L5;
        String r3 = BtmUtilsKt.b(r1, r6);
    L6:
        r0.d(r3, com.bytedance.android.ec.sdk.plugin.e.getActivity(this.g.getContext()));
        StringBuilder r4 = new StringBuilder("livesdk_click_");
        m0 r7 = this.h.trackInfo;
        if (r7 == null) goto L9;
        String r8 = r7.b();
    L10:
        r4.append(r8);
        String r9 = r4.toString();
        oh.a.c(r9, new a(this, r9));
        com.bytedance.android.ec.common.api.jump.model.b r10 = this.j;
        if (r10 != null) goto L14;
        r10 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L14:
        v r11 = new v("livesdk_common_banner_click", r10);
        m0 r12 = this.h.trackInfo;
        if (r12 == null) goto L17;
        r2 = r12.c();
    L17:
        r11.d(r2);
        r11.a("banner_type", this.h.bannerType);
        r11.a("tab_rank", this.k + 1);
        r11.i(r6.a);
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public g(ECPromotionListHintBannerView r1, ECPromotionList.p r2, JSONObject r3, gi2.a r4, int r5) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        super(null, null, 3);
    }
}
