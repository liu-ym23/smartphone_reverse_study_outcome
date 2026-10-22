package com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource;

import android.util.LruCache;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.e0;
import com.bytedance.android.ec.model.response.y0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.LiveListTabResortAbility;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListCacheCenter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.repository.LivePromotionListTabPromotionData;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mj2.e;
import mj2.g;
import mj2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements tj2.b {
    public final LivePromotionListLocalDataSourceUpdateDelegate a;
    public Function0<? extends List<? extends ql.a>> b;
    public LivePromotionListTabPromotionData c;
    public final LruCache<String, LivePromotionListTabPromotionData> d;
    public ql.a e;
    public ql.a f;
    public List<? extends ql.a> g;
    public final List<String> h;
    public e i;
    public PromotionCategory j;
    public List<PromotionCategory> k;
    public mj2.d l;
    public final RoomContextController m;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a$a, reason: collision with other inner class name */
    public static final class C0093a {
    }

    static {
    }

    @Override // tj2.b
    public final void i() {
        this.j = null;
    }

    @Override // tj2.b
    public final void m() {
        this.c = null;
        this.d.evictAll();
    }

    public final List<ql.a> a() {
        PromotionCategory r0 = this.j;
        if (r0 != null) goto L5;
    L10:
        Function0<? extends List<? extends ql.a>> r1 = this.b;
        if (r1 != null) goto L13;
        return null;
    L13:
        return (List) r1.invoke();
    L5:
        if (r0.isAllTab() == true) goto L10;
        LivePromotionListTabPromotionData r2 = this.c;
        if (r2 != null) goto L15;
        return null;
    L15:
        return r2.a();
    }

    public final List<Pair<String, LivePromotionListTabPromotionData>> c() {
        ArrayList r0 = new ArrayList();
        LivePromotionListTabPromotionData r1 = this.c;
        if (r1 == null) goto L5;
        r0.add(TuplesKt.to("", r1));
    L5:
        Iterator<Map.Entry<String, LivePromotionListTabPromotionData>> r2 = this.d.snapshot().entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, LivePromotionListTabPromotionData> r3 = r2.next();
        r0.add(TuplesKt.to(r3.getKey(), r3.getValue()));
        goto L7
    L9:
        return r0;
    }

    @Override // tj2.b
    public final List<ql.a> f() {
        ArrayList r0 = new ArrayList();
        Function0<? extends List<? extends ql.a>> r1 = this.b;
        if (r1 == null) goto L7;
        List r2 = (List) r1.invoke();
        if (r2 == null) goto L7;
        r0.addAll(r2);
    L7:
        LivePromotionListTabPromotionData r3 = this.c;
        if (r3 == null) goto L10;
        r0.addAll(r3.a());
    L10:
        Iterator<T> r4 = this.d.snapshot().values().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r0.addAll(((LivePromotionListTabPromotionData) r4.next()).a());
        goto L12
    L14:
        return r0;
    }

    @Override // tj2.b
    public final PromotionCategory b() {
        return this.j;
    }

    @Override // tj2.b
    public final ql.a g() {
        return this.e;
    }

    @Override // tj2.b
    public final LivePromotionListLocalDataSourceUpdateDelegate k() {
        return this.a;
    }

    @Override // tj2.b
    public final e r() {
        return this.i;
    }

    @Override // tj2.b
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueIndex");
        if (Intrinsics.areEqual(r2, "") == false) goto L5;
        this.c = null;
        return;
    L5:
        this.d.remove(r2);
    }

    public final void h(String r6) {
        List<String> r0 = this.h;
        boolean r3 = false;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        if (Intrinsics.areEqual((String) r1.next(), r6) == false) goto L9;
        r3 = true;
    L14:
        if ((!r3) == true) goto L17;
        r0 = null;
    L17:
        if (r0 == null) goto L25;
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r0.add(r6);
        return;
    L25:
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // tj2.b
    public final void l(PromotionCategory r5) {
        this.j = r5;
        if (r5 == null) goto L5;
        r5.setSelected(true);
    L5:
        ql.d r1 = this.l.c;
        if (r1 == null) goto L28;
        String r2 = null;
        if (r5 == null) goto L10;
        String r3 = r5.getId();
    L11:
        r1.a = r3;
        if (r5 == null) goto L14;
        String r4 = r5.getCategoryType();
    L15:
        r1.b = r4;
        List<PromotionCategory> r6 = this.k;
        if (r6 == null) goto L18;
        String r0 = String.valueOf(CollectionsKt.indexOf(r6, r5) + 1);
    L19:
        r1.c = r0;
        if (r5 == null) goto L22;
        String r7 = r5.getUniqueIndex();
    L23:
        r1.d = r7;
        if (r5 == null) goto L26;
        r2 = r5.getName();
    L26:
        r1.e = r2;
        return;
    L22:
        r7 = null;
        goto L23
    L18:
        r0 = null;
        goto L19
    L14:
        r4 = null;
        goto L15
    L10:
        r3 = null;
        goto L11
    }

    @Override // tj2.b
    public final LivePromotionListTabPromotionData n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueIndex");
        if (Intrinsics.areEqual(r2, "") == false) goto L6;
        return this.c;
    L6:
        return this.d.get(r2);
    }

    @Override // tj2.b
    public final List<PromotionCategory> p(List<PromotionCategory> r13) {
        Intrinsics.checkNotNullParameter(r13, "newCategories");
        List<PromotionCategory> r0 = this.k;
        if (r0 == null) goto L12;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (((PromotionCategory) r2).getSelected() == false) goto L6;
    L11:
        PromotionCategory r3 = (PromotionCategory) r2;
    L13:
        ArrayList r4 = new ArrayList();
        List<PromotionCategory> r5 = this.k;
        if (r5 == null) goto L77;
        if ((!r5.isEmpty()) != true) goto L77;
        List<PromotionCategory> r6 = this.k;
        if (r6 == null) goto L21;
        r4.addAll(r6);
    L21:
        List<PromotionCategory> r14 = r13;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r14.iterator();
    L22:
        boolean r9 = false;
        if (r8.hasNext() == false) goto L40;
        Object r10 = r8.next();
        PromotionCategory r11 = (PromotionCategory) r10;
        if (r4.isEmpty() == true) goto L33;
        Iterator r12 = r4.iterator();
    L29:
        if (r12.hasNext() == false) goto L33;
        if (Intrinsics.areEqual(((PromotionCategory) r12.next()).getUniqueIndex(), r11.getUniqueIndex()) == false) goto L29;
        boolean r15 = true;
    L34:
        if (r15 == false) goto L36;
    L38:
        if (r9 == false) goto L22;
        r7.add(r10);
        goto L22
    L36:
        if (r11.getDisableAppend() == true) goto L38;
        r9 = true;
    L33:
        r15 = false;
        goto L34
    L40:
        r4.addAll(r7);
        Iterator r16 = r4.iterator();
    L42:
        if (r16.hasNext() == false) goto L61;
        PromotionCategory r17 = (PromotionCategory) r16.next();
        Iterator<T> r18 = r14.iterator();
    L45:
        if (r18.hasNext() == false) goto L49;
        Object r19 = r18.next();
        if (Intrinsics.areEqual(((PromotionCategory) r19).getUniqueIndex(), r17.getUniqueIndex()) == false) goto L45;
    L50:
        PromotionCategory r20 = (PromotionCategory) r19;
        if (r20 != null) goto L56;
        PromotionCategory.a r21 = PromotionCategory.Companion;
        String r22 = r17.getUniqueIndex();
        r21.getClass();
        if (PromotionCategory.a.b(r22) == true) goto L56;
        r17.setHasPromotions(false);
        r17.setNeedReload(true);
    L56:
        r17.setHasPromotions(true);
        if (r20 == null) goto L59;
        boolean r23 = r20.getNeedReload();
    L60:
        r17.setNeedReload(r23);
        goto L42
    L59:
        r23 = true;
        goto L60
    L49:
        r19 = null;
        goto L50
    L61:
        Iterator r110 = r4.iterator();
    L63:
        if (r110.hasNext() == false) goto L71;
        PromotionCategory r24 = (PromotionCategory) r110.next();
        if (r3 != null) goto L67;
    L69:
        boolean r25 = false;
    L70:
        r24.setSelected(r25);
        goto L63
    L67:
        if (Intrinsics.areEqual(r3.getUniqueIndex(), r24.getUniqueIndex()) == false) goto L69;
        r25 = true;
        goto L70
    L71:
        Lazy r111 = LiveDynamicContext.c;
        LiveListTabResortAbility r112 = (LiveListTabResortAbility) LiveDynamicContext.a.a().a().get("tab_resort");
        List<PromotionCategory> r26 = r4;
        if (r112 == null) goto L74;
        r26 = r112.f(r4, false);
    L74:
        this.k = r26;
        return r26;
    L77:
        return CollectionsKt.emptyList();
    L10:
        r2 = null;
        goto L11
    L12:
        r3 = null;
        goto L13
    }

    @Override // tj2.b
    public final void s(List<? extends ql.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "promotions");
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        ql.a r0 = (ql.a) r6.next();
        ql.b r1 = r0.getClientData();
        mj2.d r2 = this.l;
        r1.g = r2.e;
        r0.setPromotionListHeaderLabelNames(r2.b);
        ql.b r3 = r0.getClientData();
        mj2.d r4 = this.l;
        r3.f = r4.c;
        g r7 = r4.f;
        if (r7 == null) goto L4;
        ql.b r8 = r0.getClientData();
        r8.c = r7.a;
        ql.b r9 = r0.getClientData();
        r9.d = r7.c;
        goto L4
    }

    public a(RoomContextController r1, LivePromotionListCacheCenter r2) {
        this.m = r1;
        this.a = new LivePromotionListLocalDataSourceUpdateDelegate(this, r2);
        this.d = new LruCache(EComABUtils.liveListCacheTabDataCount());
        this.h = new ArrayList();
        this.l = new mj2.d(0);
    }

    public final void d(ql.a r5, List<String> r6, boolean r7) {
        ql.a r0 = this.e;
        if (r0 == null) goto L5;
        String r1 = r0.getPromotionId();
    L6:
        if (r5 == null) goto L8;
        String r2 = r5.getPromotionId();
    L10:
        if ((!Intrinsics.areEqual(r1, r2)) == false) goto L14;
        ((ArrayList) this.h).clear();
        if (r6 == null) goto L14;
        ((ArrayList) this.h).addAll(r6);
    L14:
        this.e = r5;
        if (r5 == null) goto L17;
        r5.setExplainType(2);
    L17:
        if (r5 == null) goto L21;
        ql.b r8 = r5.getClientData();
        if (r8 == null) goto L21;
        r8.f = this.l.c;
    L21:
        Iterator r9 = ((ArrayList) c()).iterator();
    L23:
        if (r9.hasNext() == false) goto L31;
        Pair r3 = (Pair) r9.next();
        String r4 = (String) r3.getFirst();
        LivePromotionListTabPromotionData r10 = (LivePromotionListTabPromotionData) r3.getSecond();
        if (((ArrayList) this.h).contains(r4) == true) goto L30;
        PromotionCategory.Companion.getClass();
        if (PromotionCategory.a.b(r4) == true) goto L30;
        r10.b(null, r7);
    L30:
        r10.b(r5, r7);
        goto L23
    L31:
        return;
    L8:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // tj2.b
    public final Pair<List<ql.a>, List<j>> q(String r8, String r9, e r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "roomId");
        Intrinsics.checkNotNullParameter(r10, "data");
        List<? extends ql.a> r1 = null;
        if (r11 != 0) goto L153;
        PromotionCategory.Companion.getClass();
        int r3 = 0;
        if (PromotionCategory.a.b(r8) == false) goto L83;
        ECLiveABUtils r12 = ECLiveABUtils.INSTANCE;
        if (r12.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L9;
    L15:
        ql.a r13 = r10.c;
        d(r13, null, true);
        PromotionListController r14 = ControllerExtensionsKt.c(this.m, r9).A().r;
        if (r12.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L51;
        List<? extends ql.a> r15 = r10.e;
        if (r15 == null) goto L27;
        Iterator<T> r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L25;
        Object r4 = r16.next();
        if (((ql.a) r4).containsIconTag("promotion_recommend") == false) goto L21;
    L26:
        ql.a r5 = (ql.a) r4;
    L28:
        if (r5 == null) goto L51;
        if (r14.x() == false) goto L51;
        List<? extends ql.a> r17 = r10.e;
        if (r17 == null) goto L41;
        Iterator<T> r18 = r17.iterator();
    L35:
        if (r18.hasNext() == false) goto L39;
        Object r6 = r18.next();
        if (((ql.a) r6).containsIconTag("promotion_recommend") == false) goto L35;
    L40:
        ql.a r7 = (ql.a) r6;
    L42:
        r14.e = true;
        if (r7 == null) goto L45;
        String r19 = r7.getProductId();
    L46:
        r14.f = r19;
        if (r7 == null) goto L49;
        String r20 = r7.getPromotionId();
    L50:
        r14.g = r20;
    L134:
        ECLiveABUtils r21 = ECLiveABUtils.INSTANCE;
        if (r21.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L137;
        this.g = r10.e;
    L139:
        if (r21.getEC_LIVE_PROMOTION_ENABLE_MUTABLE_RELATED() == false) goto L145;
        List<? extends ql.a> r22 = r10.e;
        if (r22 != null) goto L143;
    L146:
        int r23 = LivePromotionListTabPromotionData.f;
        List<? extends ql.a> r24 = r10.f;
        ArrayList r25 = new ArrayList();
        List<? extends ql.a> r0 = r10.b;
        if (r0 == null) goto L149;
        r25.addAll(r0);
    L149:
        List<? extends ql.a> r110 = r10.a;
        if (r110 == null) goto L152;
        r25.addAll(r110);
    L152:
        Unit r111 = Unit.INSTANCE;
        return LivePromotionListTabPromotionData.Companion.a(r13, r1, r24, r25);
    L143:
        if ((!r22.isEmpty()) == false) goto L146;
        r1 = r22;
        goto L146
    L145:
        r1 = CollectionsKt.listOfNotNull(r10.d);
        goto L146
    L137:
        this.f = r10.d;
        goto L139
    L49:
        r20 = null;
        goto L50
    L45:
        r19 = null;
        goto L46
    L39:
        r6 = null;
        goto L40
    L41:
        r7 = null;
        goto L42
    L25:
        r4 = null;
        goto L26
    L27:
        r5 = null;
    L51:
        ql.a r26 = r10.d;
        if (r26 != null) goto L54;
    L66:
        List<? extends ql.a> r27 = r10.f;
        if (r27 == null) goto L134;
        if ((!r27.isEmpty()) != true) goto L134;
        r14.e = true;
        List<? extends ql.a> r28 = r10.f;
        if (r28 == null) goto L75;
        ql.a r29 = (ql.a) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L75;
        String r30 = r29.getProductId();
    L76:
        r14.f = r30;
        List<? extends ql.a> r31 = r10.f;
        if (r31 == null) goto L81;
        ql.a r32 = (ql.a) CollectionsKt.firstOrNull(r31);
        if (r32 == null) goto L81;
        String r33 = r32.getPromotionId();
    L82:
        r14.g = r33;
    L81:
        r33 = null;
    L75:
        r30 = null;
        goto L76
    L54:
        if (r26.containsIconTag("promotion_recommend") != true) goto L66;
        if (r14.x() == false) goto L66;
        r14.e = true;
        ql.a r34 = r10.d;
        if (r34 == null) goto L60;
        String r35 = r34.getProductId();
    L61:
        r14.f = r35;
        ql.a r36 = r10.d;
        if (r36 == null) goto L64;
        String r37 = r36.getPromotionId();
    L65:
        r14.g = r37;
        goto L134
    L64:
        r37 = null;
        goto L65
    L60:
        r35 = null;
        goto L61
    L9:
        if (com.bytedance.android.livesdk.livecommerce.room.controller.related.c.a() != 1) goto L15;
        ql.a r112 = r10.d;
        if (r112 == null) goto L15;
        if (r112.containsIconTag("smart_product") != true) goto L15;
        r10.d = null;
        ControllerExtensionsKt.c(this.m, r9).A().t.M().c(false);
        goto L15
    L83:
        ql.a r38 = r10.c;
        if (r38 == null) goto L91;
        if (r11 != 0) goto L91;
        r13 = this.e;
        if (r13 == null) goto L89;
        r13.setIronIndex(r38.getIronIndex());
    L90:
        h(r8);
        goto L134
    L89:
        r13 = null;
    L91:
        List<? extends ql.a> r39 = r10.a;
        if (r39 == null) goto L133;
        List<? extends ql.a> r40 = r39;
        if ((r40 instanceof Collection) == true) goto L96;
    L98:
        Iterator<T> r41 = r40.iterator();
    L100:
        if (r41.hasNext() == false) goto L108;
        String r2 = ((ql.a) r41.next()).getPromotionId();
        ql.a r42 = this.e;
        if (r42 == null) goto L104;
        String r43 = r42.getPromotionId();
    L106:
        if (Intrinsics.areEqual(r2, r43) == false) goto L100;
        boolean r44 = true;
    L109:
        if (r44 != true) goto L133;
        ql.a r45 = this.e;
        if (r45 == null) goto L129;
        List<? extends ql.a> r46 = r10.a;
        if (r46 == null) goto L128;
        Iterator<T> r47 = r46.iterator();
    L116:
        if (r47.hasNext() == false) goto L124;
        Object r48 = r47.next();
        String r49 = ((ql.a) r48).getPromotionId();
        ql.a r50 = this.e;
        if (r50 == null) goto L120;
        String r51 = r50.getPromotionId();
    L122:
        if (Intrinsics.areEqual(r49, r51) == false) goto L116;
    L125:
        ql.a r52 = (ql.a) r48;
        if (r52 == null) goto L128;
        r3 = r52.getIronIndex();
        goto L128
    L120:
        r51 = null;
        goto L122
    L124:
        r48 = null;
    L128:
        r45.setIronIndex(r3);
    L129:
        if (r11 != 0) goto L131;
        r13 = this.e;
    L132:
        h(r8);
        goto L134
    L131:
        r13 = null;
        goto L132
    L104:
        r43 = null;
    L108:
        r44 = false;
        goto L109
    L96:
        if (r40.isEmpty() == false) goto L98;
    L133:
        r13 = null;
        goto L134
    L153:
        List<? extends ql.a> r53 = r10.a;
        if (r53 == null) goto L169;
        ArrayList r113 = new ArrayList();
        Iterator<T> r54 = r53.iterator();
    L157:
        if (r54.hasNext() == false) goto L165;
        Object r114 = r54.next();
        String r55 = ((ql.a) r114).getPromotionId();
        ql.a r56 = this.e;
        if (r56 == null) goto L161;
        String r57 = r56.getPromotionId();
    L163:
        if (Intrinsics.areEqual(r55, r57) == false) goto L157;
        r113.add(r114);
        goto L157
    L161:
        r57 = null;
        goto L163
    L165:
        Iterator r58 = r113.iterator();
    L167:
        if (r58.hasNext() == false) goto L171;
        ((ql.a) r58.next()).setExplainType(1);
    L171:
        return TuplesKt.to(r53, CollectionsKt.emptyList());
    L169:
        r53 = CollectionsKt.emptyList();
        goto L171
    }

    @Override // tj2.b
    public final void j(String r9, List<? extends ql.a> r10, int r11, int r12, int r13, List<j> r14) {
        Intrinsics.checkNotNullParameter(r9, "uniqueIndex");
        Intrinsics.checkNotNullParameter(r14, "removedPromotion");
        if (r10 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r9, "") == false) goto L8;
        this.c = new LivePromotionListTabPromotionData(r10, r11, r12, r13, r14);
        return;
    L8:
        this.d.put(r9, new LivePromotionListTabPromotionData(r10, r11, r12, r13, r14));
    }

    @Override // tj2.b
    public final void o(boolean r15, boolean r16, int r17, int r18, boolean r19, List r20, Function0 r21) {
        Intrinsics.checkNotNullParameter(r20, "promotions");
        Intrinsics.checkNotNullParameter(r21, "getCurrentPromotions");
        dm.a.a("LivePromotionListLocalDataSource").a("updateUIPromotionByListRawData offset = " + r18);
        List r2 = r20;
        Iterator r4 = r2.iterator();
        int r5 = 0;
        int r6 = 0;
        boolean r7 = false;
    L4:
        if (r4.hasNext() == false) goto L38;
        Object r8 = r4.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ECUIPromotionV2 r10 = (ql.a) r8;
        ql.b r11 = r10.getClientData();
        mj2.d r12 = this.l;
        r11.g = r12.e;
        r10.setHasFlagShopTag(r12.a);
        r10.setPromotionListHeaderLabelNames(this.l.b);
        r10.getClientData().f = this.l.c;
        r10.getClientData().b = !r19;
        g r13 = this.l.f;
        if (r13 == null) goto L12;
        r10.getClientData().c = r13.a;
        r10.getClientData().d = r13.c;
    L12:
        if (r6 > 5) goto L14;
        boolean r14 = true;
    L15:
        r10.setWithinFirstScreenLimit(r14);
        if (r7 == true) goto L37;
        e0 r110 = null;
        if ((r10 instanceof ECUIPromotionV2) == true) goto L20;
        ECUIPromotionV2 r22 = null;
    L21:
        ECUIPromotionV2 r23 = r22;
        if (r23 == null) goto L28;
        z0 r24 = r23.getImage();
        if (r24 == null) goto L28;
        List r25 = r24.g();
        if (r25 == null) goto L28;
        y0 r26 = (y0) CollectionsKt.firstOrNull(r25);
    L29:
        if (r26 == null) goto L31;
        r110 = r26.b();
    L31:
        if (r110 == null) goto L36;
        if (r26 == null) goto L36;
        if (r26.getType() != 1) goto L36;
        r10.setHasPreferredCouponEffect(true);
        r7 = true;
    L36:
        r10.setHasPreferredCouponEffect(false);
    L28:
        r26 = null;
        goto L29
    L20:
        r22 = r10;
    L37:
        r6 = r9;
        goto L4
    L14:
        r14 = false;
        goto L15
    L38:
        if (r15 == false) goto L50;
        Iterator r1 = r2.iterator();
    L41:
        if (r1.hasNext() == false) goto L84;
        Object r3 = r1.next();
        int r27 = r5 + 1;
        if (r5 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        ql.a r28 = (ql.a) r3;
        if (r17 == 0) goto L49;
        r5 = r28.getRealIndex();
    L49:
        r28.setLocalNum(r5);
        r5 = r27;
        goto L41
    L84:
        return;
    L50:
        if (r16 == false) goto L62;
        Iterator r29 = r2.iterator();
    L53:
        if (r29.hasNext() == false) goto L104;
        Object r30 = r29.next();
        int r31 = r5 + 1;
        if (r5 >= 0) goto L57;
        CollectionsKt.throwIndexOverflow();
    L57:
        ql.a r32 = (ql.a) r30;
        if (r17 == 0) goto L61;
        r5 = r32.getRealIndex();
    L61:
        r32.setLocalNum(r5);
        r5 = r31;
        goto L53
    L104:
        return;
    L62:
        if (r17 != 0) goto L77;
        Iterator r33 = r2.iterator();
        int r34 = 0;
    L65:
        if (r33.hasNext() == false) goto L70;
        Object r35 = r33.next();
        int r36 = r34 + 1;
        if (r34 >= 0) goto L69;
        CollectionsKt.throwIndexOverflow();
    L69:
        ((ql.a) r35).setLocalNum(r34);
        r34 = r36;
        goto L65
    L70:
        Iterator r37 = ((Iterable) r21.invoke()).iterator();
    L72:
        if (r37.hasNext() == false) goto L105;
        Object r38 = r37.next();
        int r39 = r5 + 1;
        if (r5 >= 0) goto L76;
        CollectionsKt.throwIndexOverflow();
    L76:
        ((ql.a) r38).setLocalNum(r5 + r20.size());
        r5 = r39;
        goto L72
    L105:
        return;
    L77:
        Iterator r40 = r2.iterator();
    L79:
        if (r40.hasNext() == false) goto L106;
        Object r41 = r40.next();
        int r42 = r5 + 1;
        if (r5 >= 0) goto L83;
        CollectionsKt.throwIndexOverflow();
    L83:
        ql.a r43 = (ql.a) r41;
        r43.setLocalNum(r43.getRealIndex());
        r5 = r42;
        goto L79
    }
}
