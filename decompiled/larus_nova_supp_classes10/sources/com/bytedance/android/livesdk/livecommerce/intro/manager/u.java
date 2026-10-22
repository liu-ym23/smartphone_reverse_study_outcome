package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u {
    public int a;
    public final qh2.c b;
    public final Function0<Integer> c;

    public final int a(float r7) {
        int r0 = ((Number) this.c.invoke()).intValue();
        boolean r1 = false;
        if (r0 > 0) goto L5;
        return 0;
    L5:
        Integer r2 = Integer.valueOf(this.b.B());
        if (r2.intValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        Integer r5 = null;
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (this.a != 0) goto L17;
        if (r2 == null) goto L17;
        this.a = r2.intValue();
    L17:
        Integer r4 = Integer.valueOf(this.a);
        if (r4.intValue() <= 0) goto L20;
        r1 = true;
    L20:
        if (r1 == false) goto L22;
        r5 = r4;
    L22:
        if (r5 == null) goto L24;
        int r6 = r5.intValue();
    L25:
        int r8 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.a("[anim] " + hashCode() + ", calcPublicHeight fraction:" + r7 + " publicScreenHeight:" + r6 + " targetHeight:" + r0);
        return r6 - ((int) ((r6 - UtilityKotlinExtentionsKt.d(Integer.valueOf(r0))) * RangesKt.coerceIn(r7, 0.0f, 1.0f)));
    L24:
        r6 = UtilityKotlinExtentionsKt.d(195);
        goto L25
    L8:
        r3 = false;
        goto L9
    }

    public u(qh2.c r2, Function0<Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "widgetCallback");
        Intrinsics.checkNotNullParameter(r3, "commentHeight");
        this.b = r2;
        this.c = r3;
    }

    public final void b(int r3, int r4, int r5) {
        int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.a("[anim] " + hashCode() + ", updateAnimStatus type:" + r3 + " height:" + r4 + " requestPublicHeight:" + r5);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM() == false) goto L6;
        this.b.g(r4, r5);
        return;
    L6:
        if (r3 != 100) goto L8;
    L18:
        this.b.g(r4, r5);
        return;
    L8:
        if (r3 == 120) goto L18;
        if (r3 != 200) goto L12;
    L17:
        this.b.g(0, 0);
        return;
    L12:
        if (r3 == 220) goto L17;
        if (r3 != 230) goto L23;
        this.b.g(r4, r5);
        return;
    }
}
