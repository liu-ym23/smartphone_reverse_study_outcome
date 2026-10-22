package com.bytedance.android.livesdk.livecommerce.promotionlist.repository;

import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mj2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListTabPromotionData {
    public static final /* synthetic */ int f = 0;
    public List<? extends ql.a> a;
    public final int b;
    public final int c;
    public final int d;
    public List<j> e;

    public static final class Companion {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARN: Type inference failed for: r13v4, types: [com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListTabPromotionData$Companion$handleNeedRemoveList$4] */
        /* JADX WARN: Type inference failed for: r15v2, types: [java.util.ArrayList, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r15v3 */
        /* JADX WARN: Type inference failed for: r15v5, types: [java.util.List] */
        public static Pair a(final ql.a r12, List r13, List r14, List r15) {
            Intrinsics.checkNotNullParameter(r15, "list");
            ArrayList r0 = new ArrayList();
            if (r12 == null) goto L5;
            r0.add(r12);
        L5:
            ArrayList r1 = new ArrayList();
            if (r13 == null) goto L26;
            Iterator r16 = r13.iterator();
            int r4 = 0;
        L9:
            if (r16.hasNext() == false) goto L26;
            Object r5 = r16.next();
            int r6 = r4 + 1;
            if (r4 >= 0) goto L13;
            CollectionsKt.throwIndexOverflow();
        L13:
            ql.a r7 = (ql.a) r5;
            String r8 = r7.getPromotionId();
            if (r12 == null) goto L16;
            String r9 = r12.getPromotionId();
        L18:
            if (Intrinsics.areEqual(r8, r9) == true) goto L20;
            r0.add(r7);
        L25:
            r4 = r6;
            goto L9
        L20:
            if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == true) goto L23;
            r4 = 0;
        L23:
            r1.add(new j(r4, r7));
            goto L25
        L16:
            r9 = null;
        L26:
            List r17 = CollectionsKt.toMutableList(r15);
            ?? r18 = new ArrayList();
            Iterator r19 = r17.iterator();
            int r10 = 0;
        L27:
            boolean r11 = true;
            if (r19.hasNext() == false) goto L52;
            Object r20 = r19.next();
            int r21 = r10 + 1;
            if (r10 >= 0) goto L32;
            CollectionsKt.throwIndexOverflow();
        L32:
            ql.a r22 = (ql.a) r20;
            if (r10 < (5 - r0.size())) goto L35;
        L47:
            if (r11 == true) goto L49;
            r1.add(new j(r10, r22));
        L49:
            if (r11 == false) goto L51;
            r18.add(r20);
        L51:
            r10 = r21;
            goto L27
        L35:
            if (r0.isEmpty() == true) goto L43;
            Iterator r23 = r0.iterator();
        L39:
            if (r23.hasNext() == false) goto L43;
            if (Intrinsics.areEqual(((ql.a) r23.next()).getPromotionId(), r22.getPromotionId()) == false) goto L39;
            boolean r24 = true;
        L44:
            if (r24 == false) goto L47;
            r11 = false;
        L43:
            r24 = false;
            goto L44
        L52:
            if (r14 == null) goto L85;
            r18 = CollectionsKt.toMutableList(r18);
            Iterator r110 = r14.iterator();
        L55:
            if (r110.hasNext() == false) goto L85;
            ql.a r111 = (ql.a) r110.next();
            String r25 = r111.getPromotionId();
            if (r12 == null) goto L59;
            String r26 = r12.getPromotionId();
        L61:
            if ((!Intrinsics.areEqual(r25, r26)) == true) goto L62;
            r1.add(new j(r111.getDynamicRecommendIndex(), r111));
            goto L55
        L62:
            Iterator r27 = r18.iterator();
            int r28 = 0;
        L64:
            if (r27.hasNext() == false) goto L74;
            ql.a r29 = (ql.a) r27.next();
            if (r29.isDynamicRecommended() == false) goto L68;
        L70:
            boolean r30 = false;
        L71:
            if (r30 == true) goto L75;
            r28 = r28 + 1;
        L75:
            Integer r31 = Integer.valueOf(r28);
            if (r31.intValue() <= 0) goto L78;
            boolean r32 = true;
        L79:
            if (r32 == true) goto L82;
            r31 = null;
        L82:
            if (r31 == null) goto L55;
            ListProtector.add(r18, r31.intValue(), r111);
            goto L55
        L78:
            r32 = false;
            goto L79
        L68:
            if (r29.getRealIndex() < r111.getDynamicRecommendIndex()) goto L70;
            r30 = true;
            goto L71
        L74:
            r28 = -1;
            goto L75
        L59:
            r26 = null;
        L85:
            ?? r112 = new LivePromotionListTabPromotionData$Companion$handleNeedRemoveList$4(r12);
            Iterator r113 = r0.iterator();
        L87:
            if (r113.hasNext() == false) goto L89;
            r112.invoke((ql.a) r113.next());
            goto L87
        L89:
            Iterator r114 = ((Iterable) r18).iterator();
        L91:
            if (r114.hasNext() == false) goto L93;
            r112.invoke((ql.a) r114.next());
            goto L91
        L93:
            Iterator r115 = r1.iterator();
        L95:
            if (r115.hasNext() == false) goto L97;
            r112.invoke(((j) r115.next()).b);
            goto L95
        L97:
            ArrayList r116 = new ArrayList();
            r116.addAll(r0);
            r116.addAll((Collection) r18);
            return TuplesKt.to(r116, r1);
        }
    }

    static {
    }

    public final List<ql.a> a() {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.a);
        List<j> r1 = this.e;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(((j) r3.next()).b);
        goto L4
    L6:
        r0.addAll(r2);
        return r0;
    }

    public final void b(ql.a r12, boolean r13) {
        ArrayList r0 = null;
        if (r12 == null) goto L5;
        String r1 = r12.getPromotionId();
    L7:
        if (this.b != 0) goto L110;
        List<? extends ql.a> r2 = this.a;
        ArrayList r5 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L19;
        Object r6 = r3.next();
        ql.a r7 = (ql.a) r6;
        if (r7.isRelatedInfo() == true) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L10;
        r5.add(r6);
        goto L10
    L14:
        if (r7.isDynamicRecommended() == true) goto L16;
        r8 = true;
        goto L17
    L19:
        List r4 = CollectionsKt.toMutableList(r5);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L42;
        List<j> r9 = this.e;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L23:
        if (r11.hasNext() == false) goto L32;
        Object r14 = r11.next();
        j r15 = (j) r14;
        if (r15.b.isRelatedInfo() == true) goto L27;
    L29:
        boolean r16 = false;
    L30:
        if (r16 == false) goto L23;
        r10.add(r14);
        goto L23
    L27:
        if (r15.b.isDynamicRecommended() == true) goto L29;
        r16 = true;
        goto L30
    L32:
        int r17 = CollectionsKt.getLastIndex(r10);
    L33:
        if (r17 < 0) goto L63;
        j r18 = (j) CollectionsKt.getOrNull(r10, r17);
        if (r18 == null) goto L41;
        int r19 = r4.size();
        int r110 = r18.a;
        if (r110 < 0) goto L41;
        if (r19 < r110) goto L41;
        ListProtector.add(r4, r110, r18.b);
    L41:
        r17 = r17 - 1;
    L63:
        Unit r20 = Unit.INSTANCE;
        List<? extends ql.a> r21 = this.a;
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r21.iterator();
    L65:
        if (r23.hasNext() == false) goto L69;
        Object r24 = r23.next();
        if (((ql.a) r24).isDynamicRecommended() == false) goto L65;
        r22.add(r24);
        goto L65
    L69:
        List r25 = CollectionsKt.toMutableList(r22);
        List<j> r26 = this.e;
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r28 = r26.iterator();
    L71:
        if (r28.hasNext() == false) goto L73;
        r27.add(((j) r28.next()).b);
        goto L71
    L73:
        ArrayList r29 = new ArrayList();
        Iterator r30 = r27.iterator();
    L75:
        if (r30.hasNext() == false) goto L80;
        Object r31 = r30.next();
        if (((ql.a) r31).isDynamicRecommended() == false) goto L75;
        r29.add(r31);
        goto L75
    L80:
        if ((!r29.isEmpty()) == false) goto L82;
        r0 = r29;
    L82:
        if (r0 == null) goto L84;
        r25.addAll(r0);
    L84:
        Unit r32 = Unit.INSTANCE;
        List<? extends ql.a> r33 = this.a;
        ArrayList r34 = new ArrayList();
        Iterator<T> r35 = r33.iterator();
    L86:
        if (r35.hasNext() == false) goto L95;
        Object r36 = r35.next();
        ql.a r37 = (ql.a) r36;
        if (r37.isOnTopExplaining() == false) goto L90;
    L92:
        boolean r38 = false;
    L93:
        if (r38 == false) goto L86;
        r34.add(r36);
        goto L86
    L90:
        if (r37.isRelatedInfo() == true) goto L92;
        r38 = true;
        goto L93
    L95:
        List r39 = CollectionsKt.toMutableList(r34);
        List<j> r40 = this.e;
        ArrayList r41 = new ArrayList();
        Iterator<T> r42 = r40.iterator();
    L97:
        if (r42.hasNext() == false) goto L101;
        Object r43 = r42.next();
        if ((!((j) r43).b.isRelatedInfo()) == false) goto L97;
        r41.add(r43);
        goto L97
    L101:
        int r44 = CollectionsKt.getLastIndex(r41);
    L102:
        if (r44 < 0) goto L109;
        j r45 = (j) ListProtector.get(r41, r44);
        int r46 = r39.size();
        int r111 = r45.a;
        if (r111 < 0) goto L108;
        if (r46 < r111) goto L108;
        ListProtector.add(r39, r111, r45.b);
    L108:
        r44 = r44 - 1;
        goto L102
    L109:
        Unit r47 = Unit.INSTANCE;
        Pair r112 = Companion.a(r12, r4, r25, r39);
        this.a = (List) r112.getFirst();
        this.e = (List) r112.getSecond();
        goto L110
    L42:
        List<j> r48 = this.e;
        ArrayList r49 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r48, 10));
        Iterator<T> r50 = r48.iterator();
    L44:
        if (r50.hasNext() == false) goto L46;
        r49.add(((j) r50.next()).b);
        goto L44
    L46:
        ArrayList r51 = new ArrayList();
        Iterator r52 = r49.iterator();
    L48:
        if (r52.hasNext() == false) goto L58;
        Object r53 = r52.next();
        ql.a r54 = (ql.a) r53;
        if (r54.isRelatedInfo() == true) goto L52;
    L54:
        boolean r55 = false;
    L55:
        if (r55 == false) goto L48;
        r51.add(r53);
        goto L48
    L52:
        if (r54.isDynamicRecommended() == true) goto L54;
        r55 = true;
        goto L55
    L58:
        if ((!r51.isEmpty()) == true) goto L61;
        r51 = null;
    L61:
        if (r51 == null) goto L63;
        r4.addAll(r51);
    L110:
        Iterator<T> r113 = this.a.iterator();
    L112:
        if (r113.hasNext() == false) goto L123;
        ql.a r56 = (ql.a) r113.next();
        if ((!Intrinsics.areEqual(r56.getPromotionId(), r1)) == true) goto L115;
        if (r56.getExplainType() == 2) goto L112;
        r56.setExplainType(1);
        goto L112
    L115:
        if (r13 == false) goto L119;
        ECUIAskExplainInfo r57 = r56.getAskExplainInfo();
        if (r57 == null) goto L119;
        r57.resetAckExplainStatus();
    L119:
        r56.setExplainType(0);
        goto L112
    L123:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public LivePromotionListTabPromotionData(List<? extends ql.a> r2, int r3, int r4, int r5, List<j> r6) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r6, "removedPromotions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
