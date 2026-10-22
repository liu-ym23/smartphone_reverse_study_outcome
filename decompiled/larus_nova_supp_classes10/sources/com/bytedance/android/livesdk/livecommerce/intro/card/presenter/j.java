package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j extends oh2.a {
    public IntroPromotionVO i;
    public Long j;

    public final void F() {
        throw null;
    }

    public static final boolean E(final j r4, com.bytedance.android.livesdk.livecommerce.intro.card.vm.a r5) {
        IntroPromotionVO r0 = r4.i;
        if (r0 == null) goto L11;
        r5.getClass();
        final Long r1 = null;
        if ((!Intrinsics.areEqual(null, r0.getPromotionId())) == true) goto L11;
        if ((!Intrinsics.areEqual(null, r0.getProductId())) == true) goto L11;
        UtilityKotlinExtentionsKt.f(r4.j, r4.i, new KIntroCardPresenter$logShowDurationEvent$1(r4, r1));
        r4.j = null;
        r4.F();
        return true;
    L11:
        return false;
    }
}
