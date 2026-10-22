package com.bytedance.android.shopping.deepfeed.utlis;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.shopping.deepfeed.data.api.Coupon;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import he3.a0;
import he3.b0;
import he3.e1;
import he3.e2;
import he3.h2;
import he3.k0;
import he3.k1;
import he3.m0;
import he3.n0;
import he3.p0;
import he3.p1;
import he3.r1;
import he3.y;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final e1 a(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$baseInfo");
        InFeedProductPackDataElements r2 = d(r1);
        if (r2 == null) goto L10;
        List<p0> r0 = r2.getProducts();
        if (r0 == null) goto L10;
        p0 r3 = (p0) CollectionsKt.firstOrNull(r0);
        if (r3 == null) goto L10;
        e1 r4 = r3.b();
        if (r4 == null) goto L10;
        return r4;
    L10:
        if (r2 == null) goto L16;
        n0 r5 = r2.getSliceCard();
        if (r5 == null) goto L16;
        k0 r6 = r5.e();
        if (r6 == null) goto L16;
        return r6.b();
    L16:
        return null;
    }

    public static final InFeedProductPackDataElements d(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$elements");
        InFeedProductPackData r2 = r1.getPackData();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getElements();
    }

    public static final String e(InFeedProductPackDataElements r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$eventProductId");
        List<p0> r0 = r1.getProducts();
        if (r0 == null) goto L10;
        p0 r2 = (p0) CollectionsKt.firstOrNull(r0);
        if (r2 == null) goto L10;
        e1 r3 = r2.b();
        if (r3 == null) goto L10;
        String r4 = r3.a();
        if (r4 == null) goto L10;
        return r4;
    L10:
        n0 r5 = r1.getSliceCard();
        if (r5 == null) goto L17;
        k0 r6 = r5.e();
        if (r6 == null) goto L17;
        e1 r7 = r6.b();
        if (r7 == null) goto L17;
        return r7.a();
    L17:
        return null;
    }

    public static final List<e2> f(InFeedProductPackDataElements r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$eventProductVideo");
        List<p0> r0 = r1.getProducts();
        if (r0 == null) goto L10;
        p0 r2 = (p0) CollectionsKt.firstOrNull(r0);
        if (r2 == null) goto L10;
        k1 r3 = r2.g();
        if (r3 == null) goto L10;
        List<e2> r4 = r3.c();
        if (r4 == null) goto L10;
        return r4;
    L10:
        n0 r5 = r1.getSliceCard();
        if (r5 == null) goto L17;
        y r6 = r5.c;
        if (r6 == null) goto L17;
        a0 r7 = r6.a();
        if (r7 == null) goto L17;
        return r7.c();
    L17:
        return null;
    }

    public static final boolean g(Coupon r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$isValid");
        Integer r0 = r6.getStatus();
        if (r0 != null) goto L6;
    L12:
        return false;
    L6:
        if (r0.intValue() != 1) goto L12;
        if (r6.getCountDown() == null) goto L12;
        if (r6.getCountDown().longValue() <= 0) goto L12;
        return true;
    }

    public static final List<InFeedUrlModel> h(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$mainImage");
        InFeedProductPackDataElements r2 = d(r1);
        if (r2 == null) goto L12;
        List<p0> r0 = r2.getProducts();
        if (r0 == null) goto L12;
        p0 r3 = (p0) CollectionsKt.firstOrNull(r0);
        if (r3 == null) goto L12;
        k1 r4 = r3.g();
        if (r4 == null) goto L12;
        List<InFeedUrlModel> r5 = r4.b();
        if (r5 == null) goto L12;
        return r5;
    L12:
        if (r2 == null) goto L20;
        n0 r6 = r2.getSliceCard();
        if (r6 == null) goto L20;
        y r7 = r6.c;
        if (r7 == null) goto L20;
        a0 r8 = r7.a();
        if (r8 == null) goto L20;
        return r8.a();
    L20:
        return null;
    }

    public static final p1 i(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$priceInfo");
        InFeedProductPackDataElements r2 = d(r1);
        if (r2 == null) goto L10;
        List<p0> r0 = r2.getProducts();
        if (r0 == null) goto L10;
        p0 r3 = (p0) CollectionsKt.firstOrNull(r0);
        if (r3 == null) goto L10;
        p1 r4 = r3.k();
        if (r4 == null) goto L10;
        return r4;
    L10:
        if (r2 == null) goto L16;
        n0 r5 = r2.getSliceCard();
        if (r5 == null) goto L16;
        y r6 = r5.c;
        if (r6 == null) goto L16;
        return r6.c();
    L16:
        return null;
    }

    public static final h2 j(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$promotionInfo");
        InFeedProductPackDataElements r2 = d(r1);
        if (r2 == null) goto L10;
        List<p0> r0 = r2.getProducts();
        if (r0 == null) goto L10;
        p0 r3 = (p0) CollectionsKt.firstOrNull(r0);
        if (r3 == null) goto L10;
        h2 r4 = r3.l();
        if (r4 == null) goto L10;
        return r4;
    L10:
        if (r2 == null) goto L16;
        n0 r5 = r2.getSliceCard();
        if (r5 == null) goto L16;
        k0 r6 = r5.e();
        if (r6 == null) goto L16;
        return r6.f();
    L16:
        return null;
    }

    public static final r1 k(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$recReason");
        InFeedProductPackDataElements r2 = d(r1);
        if (r2 == null) goto L10;
        List<p0> r0 = r2.getProducts();
        if (r0 == null) goto L10;
        p0 r3 = (p0) CollectionsKt.firstOrNull(r0);
        if (r3 == null) goto L10;
        r1 r4 = r3.m();
        if (r4 == null) goto L10;
        return r4;
    L10:
        if (r2 == null) goto L16;
        n0 r5 = r2.getSliceCard();
        if (r5 == null) goto L16;
        y r6 = r5.c;
        if (r6 == null) goto L16;
        return r6.d();
    L16:
        return null;
    }

    public static final Map<String, Object> l(InFeedProductPackDataElements r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$trackInfo");
        List<p0> r0 = r1.getProducts();
        if (r0 == null) goto L8;
        p0 r2 = (p0) CollectionsKt.firstOrNull(r0);
        if (r2 == null) goto L8;
        Map<String, Object> r3 = r2.s();
        if (r3 == null) goto L8;
        return r3;
    L8:
        n0 r4 = r1.getSliceCard();
        if (r4 == null) goto L13;
        k0 r5 = r4.e();
        if (r5 == null) goto L13;
        return r5.h();
    L13:
        return null;
    }

    public static final List<e2> m(InFeedProductV2 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$video");
        InFeedProductPackDataElements r2 = d(r1);
        if (r2 == null) goto L12;
        List<p0> r0 = r2.getProducts();
        if (r0 == null) goto L12;
        p0 r3 = (p0) CollectionsKt.firstOrNull(r0);
        if (r3 == null) goto L12;
        k1 r4 = r3.g();
        if (r4 == null) goto L12;
        List<e2> r5 = r4.c();
        if (r5 == null) goto L12;
        return r5;
    L12:
        if (r2 == null) goto L20;
        n0 r6 = r2.getSliceCard();
        if (r6 == null) goto L20;
        y r7 = r6.c;
        if (r7 == null) goto L20;
        a0 r8 = r7.a();
        if (r8 == null) goto L20;
        return r8.c();
    L20:
        return null;
    }

    public static final Map<String, Object> b(InFeedProductV2 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$commonParams");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        LinkedHashMap r1 = new LinkedHashMap();
        n0 r4 = r2.slcCard();
        if (r4 == null) goto L14;
        Map<String, ? extends Object> r5 = r4.b;
        if (r5 == null) goto L14;
        r1.putAll(r5);
    L14:
        n0 r6 = r2.slcCard();
        if (r6 == null) goto L33;
        m0 r7 = r6.g();
        if (r7 == null) goto L33;
        Map<String, Object> r8 = r7.c();
        if (r8 == null) goto L21;
        r1.putAll(r8);
    L21:
        Map<String, b0> r9 = r7.a();
        if (r9 == null) goto L33;
        b0 r10 = r9.get(r3);
        if (r10 == null) goto L33;
        if (r10.a() == false) goto L30;
        Map<String, Object> r11 = r7.b();
        if (r11 == null) goto L30;
        r1.putAll(r11);
    L30:
        Map<String, Object> r12 = r10.b();
        if (r12 == null) goto L33;
        r1.putAll(r12);
    L33:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static final String c(InFeedProductV2 r4, String r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "btm");
        Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
        String r0 = null;
        if (r4 == null) goto L7;
        InFeedProductPackData r7 = r4.getPackData();
        if (r7 == null) goto L7;
        InFeedProductPackDataElements r8 = r7.getElements();
    L8:
        if (r8 == null) goto L15;
        List<p0> r1 = r8.getProducts();
        if (r1 == null) goto L15;
        p0 r2 = (p0) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L15;
        Map<String, Object> r3 = r2.s();
        if (r3 == null) goto L15;
    L22:
        BcmParams r9 = new BcmParams();
        r9.put("bst_group_type", "product");
        int r10 = vd3.a.a;
        if (r3 == null) goto L29;
        String r11 = r3.toString();
        if (r11 == null) goto L29;
        JSONObject r12 = com.bytedance.android.ec.hybrid.list.util.k.c(r11);
        if (r12 == null) goto L29;
        r0 = r12.optString("standard_chain_param");
    L29:
        vd3.a.a(r9, r0);
        return le3.b.d(r5, r6, r9);
    L15:
        if (r8 == null) goto L21;
        n0 r13 = r8.getSliceCard();
        if (r13 == null) goto L21;
        k0 r14 = r13.e();
        if (r14 == null) goto L21;
        r3 = r14.h();
    L21:
        r3 = null;
    L7:
        r8 = null;
        goto L8
    }
}
