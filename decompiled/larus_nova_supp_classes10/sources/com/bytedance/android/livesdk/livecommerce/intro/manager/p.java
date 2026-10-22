package com.bytedance.android.livesdk.livecommerce.intro.manager;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroUpdateType;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ i a;

    public p(i r1) {
        this.a = r1;
    }

    public final void onChanged(Object r13) {
        uh2.c r14 = (uh2.c) r13;
        String r0 = null;
        if (r14 == null) goto L5;
        List<uh2.a> r1 = r14.a;
    L6:
        if (r14 == null) goto L8;
        IntroUpdateType r15 = r14.getType();
    L9:
        if (r1 == null) goto L48;
        uh2.a r2 = (uh2.a) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L49;
        this.a.getClass();
        Pair r4 = i.k(r2);
        if (this.a.a(null) == false) goto L20;
        this.a.getClass();
        if (r15 != IntroUpdateType.MUST_SHOW_NEW_CARD) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == true) goto L20;
        boolean r8 = true;
    L21:
        com.bytedance.android.livesdk.livecommerce.intro.controller.b r9 = this.a.d.get(r2.getIntroType());
        if (r9 == null) goto L50;
        String r5 = r9.j();
        if (r4 == null) goto L27;
        r0 = (String) r4.getFirst();
    L27:
        if (Intrinsics.areEqual(r5, r0) == false) goto L46;
        this.a.getClass();
        if (r15 != IntroUpdateType.MUST_SHOW_NEW_CARD) goto L31;
        boolean r6 = true;
    L32:
        if (r6 == true) goto L46;
        if ((r2 instanceof IntroPromotionVO) == true) goto L36;
    L38:
        boolean r7 = false;
    L40:
        if (r15 == IntroUpdateType.CREATE) goto L42;
    L45:
        r9.m(r2, true, r8);
        return;
    L42:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_POP_SAME_CARD_EXTEND() == true) goto L44;
        if (r7 == false) goto L45;
    L44:
        r9.m(r2, false, r8);
        return;
    L36:
        if (((IntroPromotionVO) r2).getShouldExtendSameCardDuration() == false) goto L38;
        r7 = true;
        goto L40
    L31:
        r6 = false;
    L46:
        this.a.m.d(new b(r2.getIntroType(), new m(r9, r4, r2, r8, this), new n(r9, r2, r8)), new o(r9, r2, r8));
        return;
    L50:
        return;
    L17:
        r3 = false;
    L20:
        r8 = false;
        goto L21
    L49:
        return;
    L48:
        return;
    L8:
        r15 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
