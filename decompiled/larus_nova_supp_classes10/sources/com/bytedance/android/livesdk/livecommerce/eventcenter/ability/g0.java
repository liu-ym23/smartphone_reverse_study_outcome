package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "show_promotion_card_guide", description = "展示", service = {"LiveList"})
public final class g0 extends com.bytedance.android.livesdk.livecommerce.ability.d<sl.q> {
    public final b a;

    public static final class a {
    }

    static {
    }

    public g0(com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.w r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r4, sl.q r5, Object r6, il2.a r7, com.bytedance.android.livesdk.livecommerce.ability.e r8) {
        sl.q r9 = r5;
        if (r9 == null) goto L5;
        String r10 = r9.a();
    L7:
        if (r10 != null) goto L9;
    L20:
        if (r8 == null) goto L27;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r8, 0, null, 3);
        return;
    L27:
        return;
    L9:
        if (r9.c() == null) goto L20;
        if (r9.e() == null) goto L20;
        com.bytedance.android.ec.sdk.helper.q r11 = com.bytedance.android.ec.sdk.helper.q.a;
        int r12 = r11.getInt("ec_live_show_promotion_card_guide_ability_" + r9.a(), 0);
        if (r12 != 0) goto L18;
        this.a.a(r9);
        r11.d("ec_live_show_promotion_card_guide_ability_" + r9.a(), r12 + 1);
        if (r8 == null) goto L23;
        r8.onSuccess();
        return;
    L23:
        return;
    L18:
        if (r8 == null) goto L25;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r8, 1, null, 2);
        return;
    L25:
        return;
    L5:
        r10 = null;
        goto L7
    }
}
