package com.bytedance.android.shopping.feed.viewmodel;

import android.content.Context;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.enumeration.GoodPriceCardOrStripType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yd3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public boolean a;
    public int b;
    public int c;
    public List<rd3.a> d;
    public List<rd3.a> e;
    public final Context f;
    public final ProductFeedViewModel g;

    public final Context getContext() {
        return this.f;
    }

    public static List a(List r6) {
        List r0 = r6;
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        p r2 = ((rd3.a) r1.next()).i();
        if (r2 == null) goto L4;
        if (r2.a != 1001) goto L4;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L37;
        ArrayList r7 = new ArrayList();
        Iterator r4 = r0.iterator();
    L14:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        p r8 = ((rd3.a) r5).i();
        if (r8 != null) goto L18;
    L21:
        boolean r9 = true;
    L22:
        if (r9 == false) goto L14;
        r7.add(r5);
        goto L14
    L18:
        if (r8.getType() != 7) goto L21;
        r9 = false;
        goto L22
    L25:
        return CollectionsKt.toMutableList(r7);
    L37:
        return r6;
    L10:
        r3 = false;
        goto L11
    }

    public final void b(rd3.a r9) {
        String r0 = r9.e();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if ((!r3) == true) goto L13;
        r0 = null;
    L13:
        if (r0 != null) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r9.b, GoodPriceCardOrStripType.GOOD_PRICE_CARD_1.getType()) == false) goto L30;
        List<Object> r2 = this.g.getHeaderList();
        int r4 = r2.size();
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L58;
        Object r6 = CollectionsKt.getOrNull(r2, r5);
        if ((r6 instanceof PromotionProductStruct) == false) goto L28;
        PromotionProductBaseStruct r7 = ((PromotionProductStruct) r6).getBaseInfo();
        if (r7 == null) goto L23;
        String r8 = r7.getProductId();
    L25:
        if (Intrinsics.areEqual(r8, r0) == false) goto L28;
        ListProtector.add(this.e, 0, r9);
        List<rd3.a> r10 = a(this.e);
        this.e = r10;
        this.g.setFirstLoadGuessULikeResourceCardList(r10);
        return;
    L23:
        r8 = null;
    L28:
        r5 = r5 + 1;
        goto L17
    L58:
        return;
    L30:
        if (Intrinsics.areEqual(r9.b, GoodPriceCardOrStripType.GOOD_PRICE_CARD_2.getType()) == false) goto L57;
        int r11 = this.d.size();
    L32:
        if (r1 >= r11) goto L59;
        rd3.a r12 = (rd3.a) CollectionsKt.getOrNull(this.d, r1);
        if ((r12 instanceof rd3.a) == false) goto L47;
        Promotion r13 = r12.f();
        if (r13 == null) goto L42;
        PromotionProductStruct r14 = r13.getPromotionInfo();
        if (r14 == null) goto L42;
        PromotionProductBaseStruct r15 = r14.getBaseInfo();
        if (r15 == null) goto L42;
        String r16 = r15.getProductId();
    L44:
        if (Intrinsics.areEqual(r16, r0) == false) goto L47;
        r12.q = true;
        ListProtector.add(this.d, r1 + 1, r9);
        return;
    L42:
        r16 = null;
    L47:
        r1 = r1 + 1;
        goto L32
    L59:
        return;
    L57:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    public b(Context r2, ProductFeedViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.f = r2;
        this.g = r3;
        this.b = -1;
        this.c = -1;
        this.d = new ArrayList();
        this.e = new ArrayList();
    }
}
