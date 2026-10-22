package com.bytedance.android.livesdk.log.filter;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z extends a<am2.n> implements q {
    static {
    }

    public z() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r1) {
        super.a(r1);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r5, am2.n r6) {
        am2.n r7 = r6;
        super.u(r5, r7);
        boolean r0 = tb1.c.a;
        if (r0 == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r7.b) == true) goto L8;
        r5.put("IESLiveEffectAdTrackExtraServiceKey", r7.b);
        this.b.put("IESLiveEffectAdTrackExtraServiceKey", r7.b);
    L8:
        if (TextUtils.isEmpty(r7.c) == true) goto L11;
        r5.put("ad_extra_data", r7.c);
        this.b.put("ad_extra_data", r7.c);
    L11:
        if (TextUtils.isEmpty(r7.d) == true) goto L14;
        r5.put("is_other_channel", r7.d);
        this.b.put("is_other_channel", r7.d);
        r5.put("is_ad", "1");
        this.b.put("is_ad", "1");
    L14:
        if (TextUtils.isEmpty(r7.e) == true) goto L18;
        if (r0 == false) goto L18;
        r5.put("enter_from_merge", r7.e);
    L18:
        if (TextUtils.isEmpty(r7.a()) == true) goto L21;
        r5.put("ad_plan_id", r7.a());
    L21:
        if (TextUtils.isEmpty(r7.c()) == true) goto L24;
        r5.put("creative_id", r7.c());
    L24:
        if (TextUtils.isEmpty(r7.b()) == true) goto L28;
        r5.put("preview_extra_info", r7.b());
        return;
    }
}
