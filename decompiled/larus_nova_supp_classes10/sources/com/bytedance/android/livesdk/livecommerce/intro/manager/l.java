package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.hybrid.bridges.ECLiveCardActionMethod;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements com.bytedance.android.livesdk.livecommerce.eventcenter.d.a {
    public final /* synthetic */ i a;

    public l(i r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d.a
    public final void a(String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r11, "eventName");
        if (Intrinsics.areEqual(r11, "refresh_pop_card") == false) goto L25;
        if ((r12 instanceof ECLiveCardActionMethod.b) == false) goto L23;
        ECLiveCardActionMethod.b r13 = (ECLiveCardActionMethod.b) r12;
        String r14 = r13.a;
        if (r14 != null) goto L9;
        return;
    L9:
        if ((!Intrinsics.areEqual(r14, this.a.k.roomId())) == true) goto L28;
        ECLiveABUtils r15 = ECLiveABUtils.INSTANCE;
        int r16 = r15.getEC_LIVE_OUTER_CALL_MAP_RULE().b(r13.b);
        String r4 = r15.getEC_LIVE_OUTER_CALL_MAP_RULE().a();
        i r17 = this.a;
        Map r5 = MapsKt.mapOf(TuplesKt.to("request_scene", String.valueOf(r16)));
        if (r17.f == null) goto L14;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[refreshIntroCard] filter refresh during open price animation");
        return;
    L14:
        uh2.c r18 = r17.j.getIntroVOLiveData().a();
        if (r18 != null) goto L17;
        return;
    L17:
        if ((!r18.a.isEmpty()) == true) goto L20;
        r18 = null;
    L20:
        if (r18 == null) goto L31;
        IntroManagerViewModel.queryIntro$default(r17.j, IntroCardScene.REFRESH_MESSAGE, null, null, r4, r5, false, null, 32, null);
        return;
    L31:
        return;
    L28:
        return;
    L23:
        c.a.a(this.a, IntroCardScene.REFRESH_MESSAGE, 64);
        return;
    L25:
        if (Intrinsics.areEqual(r11, "get_pop_card") == false) goto L34;
        c.a.a(this.a, IntroCardScene.GET_CARD, 64);
        return;
    }
}
