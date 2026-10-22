package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public static final /* synthetic */ int d = 0;
    public final ArrayList<String> a;
    public final ArrayList<String> b;
    public final ArrayList<String> c;

    public static final class a {
        public static String a(List r8, List r9) {
            Intrinsics.checkNotNullParameter(r8, "headResourceCardList");
            Intrinsics.checkNotNullParameter(r9, "productList");
            StringBuilder r0 = new StringBuilder();
            Iterator r10 = r8.iterator();
        L4:
            if (r10.hasNext() == false) goto L23;
            yd3.p r1 = ((rd3.a) r10.next()).i();
            if (r1 == null) goto L4;
            yd3.m r2 = r1.l();
            if (r2 == null) goto L4;
            List<Promotion> r3 = r2.h();
            if (r3 == null) goto L4;
            Iterator<Promotion> r4 = r3.iterator();
        L14:
            if (r4.hasNext() == false) goto L4;
            Promotion r5 = r4.next();
            StringBuilder r6 = new StringBuilder("2_");
            PromotionProductStruct r7 = r5.getPromotionInfo();
            if (r7 == null) goto L20;
            PromotionProductBaseStruct r11 = r7.getBaseInfo();
            if (r11 == null) goto L20;
            String r12 = r11.getProductId();
        L21:
            r6.append(r12);
            r0.append(r6.toString());
            r0.append(",");
        L20:
            r12 = null;
            goto L21
        L23:
            if (r9.size() <= 100) goto L25;
            int r13 = r9.size() - 100;
        L26:
            int r14 = r9.size();
        L27:
            if (r13 >= r14) goto L47;
            rd3.a r15 = (rd3.a) ListProtector.get(r9, r13);
            Integer r16 = r15.getType();
            if (r16 == null) goto L43;
            if (r16.intValue() != 2) goto L43;
            StringBuilder r17 = new StringBuilder("2_");
            Promotion r18 = r15.f();
            if (r18 == null) goto L40;
            PromotionProductStruct r19 = r18.getPromotionInfo();
            if (r19 == null) goto L40;
            PromotionProductBaseStruct r20 = r19.getBaseInfo();
            if (r20 == null) goto L40;
            String r21 = r20.getProductId();
        L41:
            r17.append(r21);
            r0.append(r17.toString());
        L40:
            r21 = null;
        L43:
            if (r13 >= (r9.size() - 1)) goto L45;
            r0.append(",");
        L45:
            r13 = r13 + 1;
            goto L27
        L47:
            return r0.toString();
        L25:
            r13 = 0;
            goto L26
        }
    }

    static {
    }

    public final String a() {
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r1 = this.b.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r0.append((String) r3);
        if (r2 >= (this.b.size() - 1)) goto L11;
        r0.append(",");
    L11:
        r2 = r4;
        goto L4
    L13:
        return r0.toString();
    }

    public m() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final void b(List<rd3.a> r6) {
        Intrinsics.checkNotNullParameter(r6, "productList");
        int r0 = this.b.size();
        if ((r6.size() + r0) <= 100) goto L5;
        ArrayList<String> r1 = this.b;
        r1.removeAll(r1.subList(0, (r0 + r6.size()) - 100));
    L5:
        int r2 = this.c.size();
        if ((r6.size() + r2) <= 100) goto L8;
        ArrayList<String> r3 = this.c;
        r3.removeAll(CollectionsKt.toSet(r3.subList(0, (r2 + r6.size()) - 100)));
    L8:
        Iterator<T> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L27;
        rd3.a r4 = (rd3.a) r7.next();
        Integer r5 = r4.getType();
        if (r5 == null) goto L10;
        if (r5.intValue() != 2) goto L10;
        Promotion r8 = r4.f();
        if (r8 == null) goto L23;
        PromotionProductStruct r9 = r8.getPromotionInfo();
        if (r9 == null) goto L23;
        PromotionProductBaseStruct r10 = r9.getBaseInfo();
        if (r10 == null) goto L23;
        String r11 = r10.getProductId();
    L24:
        this.b.add("2_" + r11);
        if (r11 == null) goto L10;
        this.c.add(r11);
    L23:
        r11 = null;
        goto L24
    }

    public final void c(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "productIds");
        this.a.addAll(r5);
        int r0 = this.b.size();
        if ((r5.size() + r0) <= 100) goto L5;
        ArrayList<String> r1 = this.b;
        r1.removeAll(r1.subList(0, (r0 + r5.size()) - 100));
    L5:
        this.b.addAll(r5);
    }
}
