package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.hybrid.bridges.ECLiveCardActionMethod;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements com.bytedance.android.livesdk.livecommerce.eventcenter.d.a {
    public final /* synthetic */ ExplainCardWidgetController a;

    public e(ExplainCardWidgetController r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d.a
    public final void a(String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        if (Intrinsics.areEqual(r11, "refresh_pop_card") == true) goto L5;
        return;
    L5:
        if ((r12 instanceof ECLiveCardActionMethod.b) == false) goto L17;
        ECLiveCardActionMethod.b r13 = (ECLiveCardActionMethod.b) r12;
        String r14 = r13.a;
        if (r14 == null) goto L16;
        ml.b r0 = this.a.v;
        if (r0 == null) goto L11;
        String r1 = r0.roomId();
    L13:
        if ((!Intrinsics.areEqual(r14, r1)) == true) goto L19;
        ECLiveABUtils r15 = ECLiveABUtils.INSTANCE;
        int r16 = r15.getEC_LIVE_OUTER_CALL_MAP_RULE().d(r13.b);
        this.a.l(null, r15.getEC_LIVE_OUTER_CALL_MAP_RULE().c(), MapsKt.mapOf(TuplesKt.to("request_scene", String.valueOf(r16))));
        return;
    L19:
        return;
    L11:
        r1 = null;
        goto L13
    L16:
        return;
    L17:
        this.a.f(null, null, false, null, null, null, null);
    }
}
