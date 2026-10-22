package com.bytedance.android.shopping.deepfeed.utlis;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import he3.b1;
import he3.m;
import he3.m1;
import he3.n0;
import he3.p0;
import he3.q;
import he3.r;
import he3.y;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final List<q> a(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$aiRecommend");
        p0 r2 = r1.cardData();
        if (r2 == null) goto L9;
        m1 r3 = r2.i();
        if (r3 == null) goto L9;
        m r4 = r3.a();
        if (r4 == null) goto L9;
        return r4.a();
    L9:
        return null;
    }

    public static final boolean b(InFeedProductV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$hasLive");
        Intrinsics.checkNotNullParameter(r2, "$this$liveInfo");
        p0 r0 = r2.cardData();
        Boolean r1 = null;
        if (r0 == null) goto L10;
        m1 r3 = r0.i();
        if (r3 == null) goto L10;
        m r4 = r3.a();
        if (r4 == null) goto L10;
        r r5 = r4.b();
        if (r5 == null) goto L10;
    L16:
        if (r5 == null) goto L19;
        r1 = r5.c();
    L19:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L10:
        n0 r6 = r2.slcCard();
        if (r6 == null) goto L15;
        y r7 = r6.c;
        if (r7 == null) goto L15;
        r5 = r7.b();
    L15:
        r5 = null;
        goto L16
    }

    public static final boolean c(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isShowAiRecommend");
        List<q> r2 = a(r1);
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        return !r3;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L10
    }

    public static final boolean d(InFeedProductV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isShowLiveInteraction");
        InFeedProductPackData r3 = r2.getPackData();
        if (r3 == null) goto L30;
        InFeedProductPackDataElements r4 = r3.getElements();
        if (r4 == null) goto L30;
        List<p0> r5 = r4.getProducts();
        if (r5 == null) goto L30;
        p0 r6 = (p0) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L30;
        m1 r7 = r6.i();
        if (r7 == null) goto L30;
        m r8 = r7.a();
        if (r8 == null) goto L30;
        r r9 = r8.b();
        if (r9 == null) goto L30;
        if (Intrinsics.areEqual(r9.c(), Boolean.TRUE) == false) goto L30;
        int r0 = com.bytedance.forest.utils.h.a;
        b1 r1 = r9.d();
        String r10 = null;
        if (r1 == null) goto L21;
        String r11 = r1.a();
    L23:
        if (com.bytedance.forest.utils.h.a(r11) == false) goto L30;
        b1 r12 = r9.d();
        if (r12 == null) goto L28;
        r10 = r12.b();
    L28:
        if (com.bytedance.forest.utils.h.a(r10) == false) goto L30;
        return true;
    L21:
        r11 = null;
    L30:
        return false;
    }
}
