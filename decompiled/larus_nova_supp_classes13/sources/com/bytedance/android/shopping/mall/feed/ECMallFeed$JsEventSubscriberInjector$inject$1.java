package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.shopping.mall.homepage.pagecard.PageCard;
import com.bytedance.android.shopping.mall.homepage.tools.ECMallFavoriteSectionHelper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeed$JsEventSubscriberInjector$inject$1 implements com.bytedance.android.ec.hybrid.card.event.e {
    public final /* synthetic */ ECMallFeed.l a;

    public ECMallFeed$JsEventSubscriberInjector$inject$1(ECMallFeed.l r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.ec.hybrid.card.event.d r29) {
        Intrinsics.checkNotNullParameter(r29, "jsEvent");
        Map r0 = r29.b;
        if (r0 == null) goto L261;
        Object r2 = r0.get("tab_id");
        if ((r2 instanceof Integer) == true) goto L7;
        r2 = null;
    L7:
        Integer r3 = (Integer) r2;
        Object r4 = r0.get("force_refresh");
        Boolean r5 = Boolean.TRUE;
        boolean r12 = Intrinsics.areEqual(r4, r5);
        boolean r6 = Intrinsics.areEqual(r0.get("scroll_to_category_section"), r5);
        Object r7 = r0.get("click_time");
        if ((r7 instanceof Long) == true) goto L10;
        r7 = null;
    L10:
        Long r8 = (Long) r7;
        if (r8 == null) goto L13;
        long r9 = r8.longValue();
    L14:
        boolean r16 = Intrinsics.areEqual(r0.get("animated"), r5);
        Object r10 = r0.get("tabInfo");
        if ((r10 instanceof Map) == true) goto L17;
        r10 = null;
    L17:
        com.bytedance.android.shopping.api.mall.common.tools.c r15 = new com.bytedance.android.shopping.api.mall.common.tools.c((Map) r10, Intrinsics.areEqual(r0.get("is_guide_icon_showing"), r5), r12);
        if (r12 == false) goto L20;
    L22:
        final Integer r11 = this.a.c.R;
        Object r13 = r0.get("auto_switch");
        if ((r13 instanceof Boolean) == true) goto L25;
        r13 = null;
    L25:
        boolean r14 = Intrinsics.areEqual((Boolean) r13, r5);
        ECMallFeed r17 = this.a.c;
        Object r18 = r0.get("tab_id");
        if ((r18 instanceof Integer) == true) goto L28;
        r18 = null;
    L28:
        r17.k0((Integer) r18);
        ECMallFeed r19 = this.a.c;
        Object r110 = r0.get("tab_name");
        if ((r110 instanceof String) == true) goto L31;
        r110 = null;
    L31:
        r19.S = (String) r110;
        if (r3 == null) goto L36;
        if (r12 == false) goto L36;
        this.a.c.V.y(r3.intValue());
    L36:
        if ((!Intrinsics.areEqual(r11, r3)) == false) goto L172;
        this.a.c.M();
        h93.a r20 = this.a.c.V.B;
        if (r20 == null) goto L41;
        r20.a = true;
        r20.e = "click_tab";
        r20.c = System.currentTimeMillis();
        r20.g = r11;
        r20.i = 1;
    L41:
        Object r21 = r0.get("deliveryInfo");
        if ((r21 instanceof Map) == true) goto L44;
        r21 = null;
    L44:
        Map r22 = (Map) r21;
        if (r22 == null) goto L47;
        Object r23 = r22.get("delivery_biz_id");
    L49:
        if ((r23 instanceof String) == true) goto L51;
        r23 = null;
    L51:
        final String r24 = (String) r23;
        if (r24 != null) goto L54;
        r24 = "";
    L54:
        final ECMallFeed r25 = this.a.c;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r24, "mallModuleDeliveryId");
        ECMallFeed.ReportAbility r111 = r25.j0;
        com.bytedance.android.shopping.api.mall.common.tools.c r26 = r15;
        LinkedHashMap r112 = new LinkedHashMap();
        Integer r27 = r3;
        boolean r28 = r14;
        r112.put("eventName", "bst_module_show");
        LinkedHashMap r30 = new LinkedHashMap();
        if (r25.V.s() != null) goto L57;
        r0 = r0;
        long r210 = r9;
        boolean r211 = r12;
    L163:
        h93.a r1 = this.a.c.V.B;
        if (r1 == null) goto L173;
        Map r31 = r0;
        Object r32 = r31.get("switch_type");
        if ((r32 instanceof String) == true) goto L168;
        r32 = null;
    L168:
        r1.d = (String) r32;
        Object r33 = r31.get("guide_type");
        if ((r33 instanceof LinkedHashMap) == true) goto L171;
        r33 = null;
    L171:
        r1.f = (LinkedHashMap) r33;
        r1.b = System.currentTimeMillis();
        r1.h = r11;
    L173:
        final Function0<Unit> r34 = new ECMallFeed$JsEventSubscriberInjector$inject$1$onReceiveJsEvent$$inlined$let$lambda$1(this);
        if (r6 == true) goto L176;
    L216:
        com.bytedance.android.shopping.api.mall.common.tools.c r35 = r26;
        if (r28 == false) goto L245;
        if (r27 == null) goto L245;
        ECMallFeed r36 = this.a.c;
        int r37 = r27.intValue();
        r36.getClass();
        if (com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostUserService().isLogin() == true) goto L223;
        return;
    L223:
        if (r36.J != null) goto L226;
        return;
    L226:
        if (r36.V.s() != null) goto L228;
        r36.R(null, "landing");
        return;
    L228:
        List<com.bytedance.android.shopping.api.mall.common.tools.d> r38 = r36.V.s();
        if (r38 == null) goto L241;
        Iterator<T> r39 = r38.iterator();
    L232:
        if (r39.hasNext() == false) goto L239;
        Object r40 = r39.next();
        if (((com.bytedance.android.shopping.api.mall.common.tools.d) r40).a != r37) goto L236;
        boolean r41 = true;
    L237:
        if (r41 == false) goto L232;
        Object r42 = r40;
    L240:
        com.bytedance.android.shopping.api.mall.common.tools.d r43 = (com.bytedance.android.shopping.api.mall.common.tools.d) r42;
    L242:
        if (r43 == null) goto L268;
        r36.o0("landing", r43, false);
        return;
    L268:
        return;
    L236:
        r41 = false;
        goto L237
    L239:
        r42 = null;
        goto L240
    L241:
        r43 = null;
    L245:
        this.a.c.s0(r11, Long.valueOf(r210), r211, "click", r35, r34);
        return;
    L176:
        if ((!Intrinsics.areEqual(ECMallFeed.a(this.a.c), "category_tab_section")) == false) goto L216;
        Integer r44 = this.a.c.R;
        if (r44 == null) goto L262;
        int r45 = r44.intValue();
        ECMallFeed r46 = this.a.c;
        r46.V.y = r45;
        if (((Boolean) r46.s.getValue()).booleanValue() == false) goto L215;
        com.bytedance.android.shopping.mall.homepage.pagecard.d r47 = this.a.c.G1;
        if (r47 == null) goto L184;
        com.bytedance.android.shopping.mall.homepage.pagecard.c r48 = r47.a();
    L185:
        if (r48 == null) goto L193;
        PageCard r49 = r48.a;
        if (r49 == null) goto L193;
        if (r49.c() == true) goto L193;
        if (this.a.c.y() == false) goto L193;
        boolean r50 = true;
    L194:
        if (r50 == false) goto L215;
        ECMallFavoriteSectionHelper r51 = this.a.c.V;
        List<com.bytedance.android.shopping.api.mall.common.tools.d> r52 = r51.s();
        if (r52 == null) goto L215;
        Iterator<com.bytedance.android.shopping.api.mall.common.tools.d> r53 = r52.iterator();
        int r54 = 0;
    L200:
        if (r53.hasNext() == false) goto L208;
        if (r53.next().a != r45) goto L204;
        boolean r55 = true;
    L205:
        if (r55 == true) goto L206;
        r54 = r54 + 1;
        goto L200
    L206:
        int r113 = r54;
    L209:
        if (r113 < 0) goto L215;
        com.bytedance.android.shopping.api.mall.common.tools.d r56 = (com.bytedance.android.shopping.api.mall.common.tools.d) CollectionsKt.getOrNull(r52, r113);
        if (r56 == null) goto L215;
        if ((!Intrinsics.areEqual(r56.e, Boolean.TRUE)) == false) goto L215;
        r51.w(r56.a, true, null, null);
        goto L215
    L204:
        r55 = false;
        goto L205
    L208:
        r113 = -1;
    L193:
        r50 = false;
        goto L194
    L184:
        r48 = null;
    L215:
        final com.bytedance.android.shopping.api.mall.common.tools.c r57 = r26;
        ECMallFeed.h0(this.a.c, "category_tab_section", 10, r16, 2.0f, null, 16);
        final long r58 = r210;
        final boolean r59 = r211;
        Observer<Boolean> r60 = new ECMallFeed$JsEventSubscriberInjector$inject$1$onReceiveJsEvent$$inlined$let$lambda$2(r11, r58, r59, r57, r34, this);
        ECMallFeed r61 = this.a.c;
        r61.C0.observe(r61.A1.s4(), r60);
        return;
    L262:
        return;
    L57:
        Integer r62 = r25.V.B.i;
        if (r62 != null) goto L60;
        r210 = r9;
        r211 = r12;
    L63:
        if (r62 != null) goto L66;
    L69:
        Pair r63 = new Pair(-1, -1);
    L70:
        Integer r64 = (Integer) r63.component1();
        Integer r65 = (Integer) r63.component2();
        r30.put("tab_id", String.valueOf(r64));
        r30.put("cursor", Integer.valueOf(r25.L));
        r30.put("page_num", Integer.valueOf(r25.M));
        List<com.bytedance.android.shopping.api.mall.common.tools.d> r66 = r25.V.s();
        if (r66 == null) goto L90;
        Iterator r67 = r66.iterator();
    L74:
        if (r67.hasNext() == false) goto L85;
        Object r114 = r67.next();
        int r68 = ((com.bytedance.android.shopping.api.mall.common.tools.d) r114).a;
        if (r64 != null) goto L78;
        Iterator r212 = r67;
    L81:
        boolean r69 = false;
    L82:
        if (r69 == true) goto L86;
        r67 = r212;
    L86:
        com.bytedance.android.shopping.api.mall.common.tools.d r115 = (com.bytedance.android.shopping.api.mall.common.tools.d) r114;
        if (r115 == null) goto L90;
        r30.put("tab_name", r115.b);
        r30.put("tab_order", Integer.valueOf(r115.c));
        r30.put("tab_title", r115.g);
        r30.put("tab_type", String.valueOf(r115.d));
        goto L90
    L78:
        r212 = r67;
        if (r68 != r64.intValue()) goto L81;
        r69 = true;
        goto L82
    L85:
        r114 = null;
    L90:
        if (Intrinsics.areEqual(r25.V.B.d, "click_tab") == false) goto L109;
        r30.put("from_tab_id", String.valueOf(r65));
        List<com.bytedance.android.shopping.api.mall.common.tools.d> r70 = r25.V.s();
        if (r70 == null) goto L109;
        Iterator<T> r71 = r70.iterator();
    L95:
        if (r71.hasNext() == false) goto L105;
        Object r72 = r71.next();
        int r73 = ((com.bytedance.android.shopping.api.mall.common.tools.d) r72).a;
        if (r65 != null) goto L100;
    L102:
        boolean r74 = false;
    L103:
        if (r74 == false) goto L95;
    L106:
        com.bytedance.android.shopping.api.mall.common.tools.d r75 = (com.bytedance.android.shopping.api.mall.common.tools.d) r72;
        if (r75 == null) goto L109;
        r30.put("from_tab_name", r75.b);
        r30.put("from_tab_order", Integer.valueOf(r75.c));
        r30.put("from_tab_title", r75.g);
        r30.put("from_tab_type", String.valueOf(r75.d));
        goto L109
    L100:
        if (r73 != r65.intValue()) goto L102;
        r74 = true;
        goto L103
    L105:
        r72 = null;
    L109:
        r30.put("enter_type", r25.V.B.d);
        r25.V.B.getClass();
        r30.put("leave_type", r25.V.B.e);
        Boolean r76 = r25.V.B.j;
        Boolean r77 = Boolean.TRUE;
        if (Intrinsics.areEqual(r76, r77) == false) goto L112;
        long r116 = Math.max(r25.V.B.k, 0);
        h93.a r78 = r25.V.B;
        r30.put("stay_duration", Long.valueOf(Math.max((r78.c - r78.b) - r116, 0)));
        h93.a r79 = r25.V.B;
        r79.k = 0;
        r79.j = Boolean.FALSE;
    L114:
        if (r25.V.B.f == null) goto L134;
        Object r80 = r112.get("is_picture_showing");
        if (r80 != null) goto L119;
        r80 = Boolean.FALSE;
    L119:
        if ((r80 instanceof Boolean) == true) goto L121;
        r80 = null;
    L121:
        r30.put("is_picture_showing", Integer.valueOf(Intrinsics.areEqual((Boolean) r80, r77) ? 1 : 0));
        Object r81 = "is_guide_icon_showing";
        Object r82 = r112.get(r81);
        if (r82 != null) goto L125;
        r82 = Boolean.FALSE;
    L125:
        if ((r82 instanceof Boolean) == true) goto L127;
        r82 = null;
    L127:
        r30.put(r81, Integer.valueOf(Intrinsics.areEqual((Boolean) r82, r77) ? 1 : 0));
        Object r84 = r112.get("is_animation_showing");
        if (r84 != null) goto L131;
        r84 = Boolean.FALSE;
    L131:
        if ((r84 instanceof Boolean) == true) goto L133;
        r84 = null;
    L133:
        r30.put("is_animation_showing", Integer.valueOf(Intrinsics.areEqual((Boolean) r84, r77) ? 1 : 0));
    L135:
        Object r85 = r30.get("is_picture_showing");
        if ((r85 instanceof Integer) == true) goto L138;
        r85 = null;
    L138:
        Integer r86 = (Integer) r85;
        if (r86 == null) goto L141;
        int r87 = r86.intValue();
    L142:
        Object r88 = r30.get(r81);
        if ((r88 instanceof Integer) == true) goto L145;
        r88 = null;
    L145:
        Integer r89 = (Integer) r88;
        if (r89 == null) goto L148;
        int r90 = r89.intValue();
    L149:
        Object r91 = r30.get("is_animation_showing");
        if ((r91 instanceof Integer) == true) goto L152;
        r91 = null;
    L152:
        Integer r92 = (Integer) r91;
        if (r92 == null) goto L155;
        int r94 = r92.intValue();
    L157:
        if (Math.max(r87, Math.max(r90, r94)) != 1) goto L159;
        boolean r95 = true;
    L160:
        r30.put("is_guide_showing", Boolean.valueOf(r95));
        r30.put("channel_page_status", r25.V.B.l);
        r112.put("params", r30);
        r112.put("btm", "c9582.d0");
        Unit r96 = Unit.INSTANCE;
        k93.g.a.a(r111, r112, null, null, 14);
        com.ss.android.common.applog.k0 r97 = com.ss.android.common.applog.k0.d();
        if (r97 == null) goto L163;
        r97.b(new ECMallFeed$bstModuleShowReport$2(r25, r24));
        goto L163
    L159:
        r95 = false;
        goto L160
    L155:
        r94 = 0;
        goto L157
    L148:
        r90 = 0;
        goto L149
    L141:
        r87 = 0;
        goto L142
    L134:
        r81 = r10;
        r30.put("is_picture_showing", 0);
        r30.put(r81, 0);
        r30.put("is_animation_showing", 0);
        goto L135
    L112:
        h93.a r98 = r25.V.B;
        r30.put("stay_duration", Long.valueOf(Math.max(r98.c - r98.b, 0)));
        goto L114
    L66:
        if (r62.intValue() != 2) goto L69;
        r63 = new Pair(r25.R, r25.V.B.g);
        goto L70
    L60:
        r211 = r12;
        r210 = r9;
        if (r62.intValue() != 1) goto L63;
        h93.a r99 = r25.V.B;
        r63 = new Pair(r99.g, r99.h);
        goto L70
    L47:
        r23 = null;
        goto L49
    L172:
        r27 = r3;
        r28 = r14;
        r210 = r9;
        r211 = r12;
        r26 = r15;
        goto L173
    L20:
        if (Intrinsics.areEqual(r3, this.a.c.R) == false) goto L22;
        return;
    L13:
        r9 = System.currentTimeMillis();
        goto L14
    }
}
