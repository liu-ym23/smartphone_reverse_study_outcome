package com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource;

import android.text.TextUtils;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.c1;
import com.bytedance.android.ec.model.response.d1;
import com.bytedance.android.ec.model.response.h1;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuctionInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2HotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.model.ECV2InteractionData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2UpdatedCommentaryVideoInfo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListCacheCenter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListTabPromotionData;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mj2.e;
import mj2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListLocalDataSourceUpdateDelegate implements tj2.c {
    public final a a;
    public final LivePromotionListCacheCenter b;

    public final List<ql.a> e() {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.a.f());
        LivePromotionListCacheCenter r1 = this.b;
        if (r1 != null) goto L5;
    L42:
        List r2 = CollectionsKt.emptyList();
    L43:
        r0.addAll(r2);
        return r0;
    L5:
        if (r1.b != null) goto L7;
        r2 = CollectionsKt.emptyList();
    L40:
        if (r2 == null) goto L42;
    L7:
        ArrayList r3 = new ArrayList();
        e r4 = r1.b;
        if (r4 == null) goto L12;
        List<? extends ql.a> r5 = r4.a;
        if (r5 == null) goto L12;
        r3.addAll(r5);
    L12:
        e r6 = r1.b;
        if (r6 == null) goto L17;
        List<? extends ql.a> r7 = r6.b;
        if (r7 == null) goto L17;
        r3.addAll(r7);
    L17:
        e r8 = r1.b;
        if (r8 == null) goto L23;
        ql.a r9 = r8.c;
        if (r9 == null) goto L23;
        r3.add(r9);
    L23:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L29;
        e r10 = r1.b;
        if (r10 == null) goto L34;
        List<? extends ql.a> r11 = r10.e;
        if (r11 == null) goto L34;
        r3.addAll(r11);
    L34:
        e r12 = r1.b;
        if (r12 == null) goto L39;
        List<? extends ql.a> r13 = r12.f;
        if (r13 == null) goto L39;
        r3.addAll(r13);
    L39:
        r2 = r3;
        goto L40
    L29:
        e r14 = r1.b;
        if (r14 == null) goto L34;
        ql.a r15 = r14.d;
        if (r15 == null) goto L34;
        r3.add(r15);
        goto L34
    }

    @Override // tj2.c
    public final void a(ECV2AuctionInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "auctionInfo");
        Iterator r0 = ((ArrayList) e()).iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        ql.a r1 = (ql.a) r0.next();
        if ((r1 instanceof ECUIPromotionV2) == true) goto L8;
        r1 = null;
    L8:
        ECUIPromotionV2 r2 = (ECUIPromotionV2) r1;
        if (r2 == null) goto L4;
        if (Intrinsics.areEqual(r2.getProductId(), String.valueOf(r6.productId)) == false) goto L4;
        if (r2.isAuction() == false) goto L4;
        r2.setAuctionInfo(r6.toECPromotionAuctionInfo());
        d1 r3 = r2.getPrice();
        if (r3 == null) goto L4;
        h1 r4 = r3.c();
        if (r4 == null) goto L4;
        c1 r5 = r4.b();
        if (r5 == null) goto L4;
        r5.d(r6.price);
        goto L4
    }

    @Override // tj2.c
    public final void d(List<? extends ql.a> r17) {
        Intrinsics.checkNotNullParameter(r17, "promotions");
        a r3 = this.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r17, "promotions");
        Iterator<T> r4 = r17.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if (((ql.a) r5).isOnTopExplaining() == false) goto L4;
    L9:
        ql.a r6 = (ql.a) r5;
        if (r6 == null) goto L12;
        r3.d(r6, CollectionsKt.emptyList(), false);
    L12:
        Iterator r7 = ((ArrayList) r3.c()).iterator();
    L14:
        if (r7.hasNext() == false) goto L63;
        LivePromotionListTabPromotionData r8 = (LivePromotionListTabPromotionData) ((Pair) r7.next()).getSecond();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r17, "promotions");
        List<? extends ql.a> r9 = CollectionsKt.toMutableList(r8.a);
        Iterator<T> r10 = r9.iterator();
        int r11 = 0;
    L17:
        if (r10.hasNext() == false) goto L41;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        ql.a r14 = (ql.a) r12;
        Iterator<T> r15 = r17.iterator();
    L23:
        if (r15.hasNext() == false) goto L33;
        Object r16 = r15.next();
        ql.a r18 = (ql.a) r16;
        if (Intrinsics.areEqual(r18.getUniTag(), r14.getUniTag()) == true) goto L27;
    L29:
        boolean r19 = false;
    L30:
        if (r19 == false) goto L23;
    L34:
        ql.a r110 = (ql.a) r16;
        if (r110 == null) goto L37;
        ql.a r20 = l.a(r110);
    L38:
        if (r20 == null) goto L40;
        r20.setIronIndex(r14.getIronIndex());
        r20.setRealIndex(r14.getRealIndex());
        r20.setRelatedInfo(r14.isRelatedInfo());
        r20.setDynamicRecommendIndex(r14.getDynamicRecommendIndex());
        r20.copyIconDataFromPromotion(r14);
        r20.setDynamicSlot(r14.getDynamicSlot());
        ListProtector.set(r9, r11, r20);
    L40:
        r11 = r13;
        goto L17
    L37:
        r20 = null;
        goto L38
    L27:
        if (r18.isOnTopExplaining() == true) goto L29;
        r19 = true;
        goto L30
    L33:
        r16 = null;
        goto L34
    L41:
        r8.a = r9;
        Iterator<T> r21 = r8.e.iterator();
    L43:
        if (r21.hasNext() == false) goto L14;
        j r22 = (j) r21.next();
        Iterator<T> r23 = r17.iterator();
    L46:
        if (r23.hasNext() == false) goto L55;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((ql.a) r24).getUniTag(), r22.b.getUniTag()) == true) goto L50;
    L52:
        boolean r25 = false;
    L53:
        if (r25 == false) goto L46;
    L56:
        ql.a r26 = (ql.a) r24;
        if (r26 == null) goto L59;
        ql.a r27 = l.a(r26);
    L60:
        if (r27 == null) goto L43;
        r27.setIronIndex(r22.b.getIronIndex());
        r27.setRealIndex(r22.b.getRealIndex());
        r27.setRelatedInfo(r22.b.isRelatedInfo());
        r27.setDynamicRecommendIndex(r22.b.getDynamicRecommendIndex());
        r27.copyIconDataFromPromotion(r22.b);
        r27.setDynamicSlot(r22.b.getDynamicSlot());
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r22.b = r27;
        goto L43
    L59:
        r27 = null;
        goto L60
    L50:
        if (r22.b.isOnTopExplaining() == true) goto L52;
        r25 = true;
        goto L53
    L55:
        r24 = null;
        goto L56
    L63:
        LivePromotionListCacheCenter r28 = this.b;
        if (r28 == null) goto L255;
        Intrinsics.checkNotNullParameter(r17, "promotions");
        Iterator<T> r2 = r17.iterator();
    L67:
        if (r2.hasNext() == false) goto L71;
        Object r29 = r2.next();
        if (((ql.a) r29).isOnTopExplaining() == false) goto L67;
    L72:
        ql.a r30 = (ql.a) r29;
        if (r30 == null) goto L78;
        e r31 = r28.b;
        if (r31 == null) goto L78;
        r31.c = r30;
    L78:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L104;
        e r32 = r28.b;
        if (r32 == null) goto L128;
        List<? extends ql.a> r33 = r32.e;
        if (r33 == null) goto L128;
        ArrayList r34 = new ArrayList();
        Iterator<T> r35 = r33.iterator();
    L85:
        if (r35.hasNext() == false) goto L103;
        ql.a r36 = (ql.a) r35.next();
        int r37 = l.a;
        Iterator<T> r38 = r17.iterator();
    L88:
        if (r38.hasNext() == false) goto L96;
        Object r39 = r38.next();
        String r40 = ((ql.a) r39).getUniTag();
        if (r36 == null) goto L92;
        String r111 = r36.getUniTag();
    L94:
        if (Intrinsics.areEqual(r40, r111) == false) goto L88;
    L97:
        ql.a r41 = l.a((ql.a) r39);
        if (r41 == null) goto L100;
        r41.setRelatedInfo(r36.isRelatedInfo());
        r41.copyIconDataFromPromotion(r36);
        r41.setDynamicSlot(r36.getDynamicSlot());
    L101:
        if (r41 == null) goto L85;
        r34.add(r41);
        goto L85
    L100:
        r41 = null;
        goto L101
    L92:
        r111 = null;
        goto L94
    L96:
        r39 = null;
        goto L97
    L103:
        r32.e = r34;
    L128:
        e r42 = r28.b;
        if (r42 == null) goto L149;
        List<? extends ql.a> r43 = r42.f;
        if (r43 == null) goto L149;
        ArrayList r44 = new ArrayList();
        Iterator<T> r45 = r43.iterator();
    L134:
        if (r45.hasNext() == false) goto L148;
        ql.a r46 = (ql.a) r45.next();
        int r47 = l.a;
        Iterator<T> r48 = r17.iterator();
    L137:
        if (r48.hasNext() == false) goto L141;
        Object r49 = r48.next();
        if (Intrinsics.areEqual(((ql.a) r49).getUniTag(), r46.getUniTag()) == false) goto L137;
    L142:
        ql.a r50 = l.a((ql.a) r49);
        if (r50 == null) goto L145;
        r50.setDynamicRecommendIndex(r46.getDynamicRecommendIndex());
        r50.setRelatedInfo(r46.isRelatedInfo());
        r50.copyIconDataFromPromotion(r46);
        r50.setDynamicSlot(r46.getDynamicSlot());
    L146:
        if (r50 == null) goto L134;
        r44.add(r50);
        goto L134
    L145:
        r50 = null;
        goto L146
    L141:
        r49 = null;
        goto L142
    L148:
        r42.f = r44;
    L149:
        e r51 = r28.b;
        if (r51 == null) goto L175;
        List<? extends ql.a> r52 = r51.b;
        if (r52 == null) goto L173;
        List<? extends ql.a> r53 = CollectionsKt.toMutableList(r52);
        if (r53 == null) goto L173;
        Iterator<T> r54 = r53.iterator();
        int r55 = 0;
    L157:
        if (r54.hasNext() == false) goto L172;
        Object r56 = r54.next();
        int r57 = r55 + 1;
        if (r55 >= 0) goto L161;
        CollectionsKt.throwIndexOverflow();
    L161:
        ql.a r58 = (ql.a) r56;
        Iterator<T> r59 = r17.iterator();
    L163:
        if (r59.hasNext() == false) goto L167;
        Object r112 = r59.next();
        if (Intrinsics.areEqual(((ql.a) r112).getUniTag(), r58.getUniTag()) == false) goto L163;
    L168:
        ql.a r113 = (ql.a) r112;
        if (r113 == null) goto L171;
        r113.setIronIndex(r58.getIronIndex());
        r113.setRealIndex(r58.getRealIndex());
        r113.setRelatedInfo(r58.isRelatedInfo());
        r113.copyIconDataFromPromotion(r58);
        r113.setDynamicSlot(r58.getDynamicSlot());
        ListProtector.set(r53, r55, r113);
    L171:
        r55 = r57;
        goto L157
    L167:
        r112 = null;
        goto L168
    L172:
        Unit r60 = Unit.INSTANCE;
    L174:
        r51.b = r53;
    L173:
        r53 = null;
    L175:
        e r61 = r28.b;
        if (r61 == null) goto L256;
        List<? extends ql.a> r62 = r61.a;
        if (r62 == null) goto L199;
        List<? extends ql.a> r63 = CollectionsKt.toMutableList(r62);
        if (r63 == null) goto L199;
        Iterator<T> r64 = r63.iterator();
        int r65 = 0;
    L183:
        if (r64.hasNext() == false) goto L198;
        Object r66 = r64.next();
        int r67 = r65 + 1;
        if (r65 >= 0) goto L187;
        CollectionsKt.throwIndexOverflow();
    L187:
        ql.a r68 = (ql.a) r66;
        Iterator<T> r69 = r17.iterator();
    L189:
        if (r69.hasNext() == false) goto L193;
        Object r70 = r69.next();
        if (Intrinsics.areEqual(((ql.a) r70).getUniTag(), r68.getUniTag()) == false) goto L189;
    L194:
        ql.a r71 = (ql.a) r70;
        if (r71 == null) goto L197;
        r71.setIronIndex(r68.getIronIndex());
        r71.setRealIndex(r68.getRealIndex());
        r71.setRelatedInfo(r68.isRelatedInfo());
        r71.copyIconDataFromPromotion(r68);
        r71.setDynamicSlot(r68.getDynamicSlot());
        ListProtector.set(r63, r65, r71);
    L197:
        r65 = r67;
        goto L183
    L193:
        r70 = null;
        goto L194
    L198:
        Unit r1 = Unit.INSTANCE;
        List<? extends ql.a> r72 = r63;
    L200:
        r61.a = r72;
        return;
    L199:
        r72 = null;
        goto L200
    L256:
        return;
    L104:
        Iterator<T> r73 = r17.iterator();
    L106:
        if (r73.hasNext() == false) goto L116;
        Object r74 = r73.next();
        String r75 = ((ql.a) r74).getUniTag();
        e r76 = r28.b;
        if (r76 == null) goto L112;
        ql.a r77 = r76.d;
        if (r77 == null) goto L112;
        String r78 = r77.getUniTag();
    L114:
        if (Intrinsics.areEqual(r75, r78) == false) goto L106;
    L117:
        ql.a r79 = (ql.a) r74;
        if (r79 == null) goto L128;
        e r80 = r28.b;
        if (r80 == null) goto L128;
        ql.a r81 = r80.d;
        if (r81 == null) goto L128;
        ql.a r82 = l.a(r79);
        if (r82 == null) goto L126;
        r82.setRelatedInfo(r81.isRelatedInfo());
        r82.copyIconDataFromPromotion(r81);
        r82.setDynamicSlot(r81.getDynamicSlot());
        Unit r83 = Unit.INSTANCE;
    L127:
        r80.d = r82;
        goto L128
    L126:
        r82 = null;
    L112:
        r78 = null;
        goto L114
    L116:
        r74 = null;
        goto L117
    L71:
        r29 = null;
        goto L72
    L255:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public LivePromotionListLocalDataSourceUpdateDelegate(a r2, LivePromotionListCacheCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "localDataSource");
        this.a = r2;
        this.b = r3;
    }

    @Override // tj2.c
    public final void b(ECV2UpdatedCommentaryVideoInfo r10, List<Long> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r0 = r11.size();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L31;
        Iterator r3 = ((ArrayList) e()).iterator();
    L8:
        if (r3.hasNext() == false) goto L30;
        ql.a r4 = (ql.a) r3.next();
        if (TextUtils.equals(r4.getProductId(), String.valueOf(ListProtector.get(r11, r2))) == false) goto L8;
        if (r10 == null) goto L21;
        if (r10.action != 2) goto L21;
        if ((r4 instanceof ECUIPromotion) == true) goto L18;
        r4 = null;
    L18:
        ECUIPromotion r5 = (ECUIPromotion) r4;
        if (r5 == null) goto L8;
        r5.hasCommentaryVideo = true;
    L21:
        if (r10 == null) goto L8;
        if (r10.action != 1) goto L8;
        if ((r4 instanceof ECUIPromotion) == true) goto L27;
        r4 = null;
    L27:
        ECUIPromotion r6 = (ECUIPromotion) r4;
        if (r6 == null) goto L8;
        r6.hasCommentaryVideo = false;
        goto L8
    L30:
        r2 = r2 + 1;
        goto L5
    }

    @Override // tj2.c
    public final boolean c(ECV2HotAtmosphere r8, ECV2InteractionData r9, List<Long> r10) {
        int r0 = 0;
        if (r10 != null) goto L5;
        return false;
    L5:
        int r1 = r10.size();
        boolean r2 = false;
    L6:
        if (r0 >= r1) goto L15;
        String r3 = String.valueOf(ListProtector.get(r10, r0));
        Iterator r4 = ((ArrayList) e()).iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        ql.a r5 = (ql.a) r4.next();
        if (TextUtils.equals(r5.getProductId(), r3) == false) goto L9;
        if (r8 == null) goto L9;
        r5.updateHotAtmosphere(r8);
        UtilityKotlinExtentionsKt.f(r9, r5.getAtmosphereHeaderStateOrDefault(), LivePromotionListLocalDataSourceUpdateDelegate$updateHotAtmosphere$1.INSTANCE);
        r2 = true;
        goto L9
    L14:
        r0 = r0 + 1;
        goto L6
    L15:
        return r2;
    }
}
