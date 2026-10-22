package com.bytedance.android.shopping.yata.business.function;

import android.view.View;
import com.bytedance.android.shopping.buynow.yata.abilities.BuyNowUIAbility;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public l(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r9) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Map r0 = this.a.c().a(r9);
        if (r0 == null) goto L5;
        Object r1 = r0.get("position");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        View r3 = this.a.c().f(r9);
        if (this.a.d().b(r3) == false) goto L13;
        ll3.b.a(this.a, "selfScrollItemToPosition", "touch view is null", r9);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L13:
        if (r2 != null) goto L16;
    L21:
        ll3.b.a(this.a, "selfScrollItemToPosition", "position is not support", r9);
    L22:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L16:
        if (r2.hashCode() != 939658448) goto L21;
        if (r2.equals(ScrollPosition.POSITION_HORIZONTAL_CENTER) == false) goto L21;
        BuyNowUIAbility r12 = this.a.b();
        Intrinsics.checkNotNull(r3);
        r12.h(r3, r2);
        goto L22
    L5:
        r1 = null;
        goto L7
    }
}
