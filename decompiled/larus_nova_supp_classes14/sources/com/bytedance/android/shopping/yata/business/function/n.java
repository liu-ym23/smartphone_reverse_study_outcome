package com.bytedance.android.shopping.yata.business.function;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.buynow.yata.abilities.BuyNowUIAbility;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n extends com.bytedance.kmp.ec.yata.event.common.b {
    public final kl3.a a;

    public static final class a {
    }

    static {
    }

    public n(com.bytedance.android.shopping.buynow.yata.abilities.a r2) {
        Intrinsics.checkNotNullParameter(r2, "abilities");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r9) {
        Intrinsics.checkNotNullParameter(r9, "input");
        Map r0 = this.a.c().a(r9);
        if (r0 == null) goto L5;
        Object r2 = r0.get("view_code");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r0 == null) goto L12;
        Object r1 = r0.get("position");
    L14:
        if ((r1 instanceof String) == true) goto L16;
        r1 = null;
    L16:
        String r4 = (String) r1;
        RecyclerView r5 = this.a.b().f(r3);
        if (this.a.d().b(r5) == false) goto L20;
        r5 = this.a.c().e(r3);
    L20:
        if (this.a.d().b(r5) == false) goto L23;
        r5 = this.a.c().g(r3);
    L23:
        if (this.a.d().b(r5) == false) goto L26;
        ll3.b.a(this.a, "selfScrollToPosition", "target view is empty", r9);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L26:
        if (r4 == null) goto L39;
        int r6 = r4.hashCode();
        if (r6 == (-1383228885)) goto L37;
        if (r6 != 115029) goto L39;
        if (r4.equals(ScrollPosition.POSITION_TOP) == false) goto L39;
    L38:
        BuyNowUIAbility r11 = this.a.b();
        Intrinsics.checkNotNull(r5);
        r11.j(r5, r4);
    L40:
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L37:
        if (r4.equals(ScrollPosition.POSITION_BOTTOM) == true) goto L38;
    L39:
        ll3.b.a(this.a, "selfScrollToPosition", "position is not support", r9);
        goto L40
    L12:
        r1 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
