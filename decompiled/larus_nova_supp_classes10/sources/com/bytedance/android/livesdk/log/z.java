package com.bytedance.android.livesdk.log;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.room.logger.ILivePromotionActionListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z implements ILivePromotionActionListener, com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final Map<String, String> d;
    public final Map<String, String> e;
    public final Map<String, String> f;
    public final Map<String, String> g;
    public final Long h;

    public static m0 a(String r3, JSONObject r4, Map r5) {
        m0 r0 = new m0();
        if (r4 == null) goto L6;
        Map<String, String> r1 = r0.a;
        HashMap r2 = (HashMap) r1;
        r2.put("ad_extra_data", r4.toString());
    L6:
        r0.c(r5);
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.b("refer", r3);
    L9:
        return r0;
    }

    public final void onClickPromotion(String r6, String r7, String r8, JSONObject r9) {
        if (this.a == false) goto L6;
        jc1.k.f(ILiveDouPlusService.class).logEvent(true, r6, r7, a(r8, r9, this.d).a);
    L6:
        if (this.b == false) goto L17;
        jc1.k.f(ILiveDouPlusService.class).logEvent(true, r6, r7, a(r8, r9, this.e).a);
        if (com.bytedance.android.live.core.feed.a.a().c(this.h) == true) goto L12;
        if (com.bytedance.android.live.core.feed.a.a().b(this.h) == false) goto L17;
    L12:
        if (TextUtils.equals("slidecart_click", r7) == false) goto L14;
    L15:
        jc1.k.f(ILiveDouPlusService.class).logEvent(true, "draw_ad", "click", a(r8, r9, this.e).a);
        goto L17
    L14:
        if (TextUtils.equals("click_product", r7) == true) goto L15;
    L17:
        if (this.c == true) goto L19;
        return;
    L19:
        if (TextUtils.equals("click_product", r7) == false) goto L23;
        jc1.k.f(ILiveDouPlusService.class).logEvent(true, "live_ad", "realtime_click", a(r8, r9, this.g).a);
        return;
    }

    public z(boolean r1, boolean r2, boolean r3, Map r4, Map r5, Map r6, Map r7, Long r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r6;
        this.h = r8;
    }
}
