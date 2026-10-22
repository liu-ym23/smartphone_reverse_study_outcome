package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.store.slicecard.view.ECShopTrustFloatBarContentView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECShopTrustFloatBarContentView> {
    public Map<String, ? extends Object> H3;
    public float I3;

    public static final class a {
    }

    static {
    }

    public k(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.I3 = 1.0f;
    }

    public static Map o1(Object r2) {
        if ((r2 instanceof Map) == true) goto L5;
        r2 = null;
    L5:
        Map r3 = (Map) r2;
        if (r3 != null) goto L8;
        return null;
    L8:
        return p1(r3);
    }

    public static Map p1(Map r5) {
        Set r6 = r5.entrySet();
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r7.next();
        Object r2 = r1.getKey();
        Pair r4 = null;
        if ((r2 instanceof String) == true) goto L8;
        r2 = null;
    L8:
        String r3 = (String) r2;
        if (r3 == null) goto L12;
        r4 = TuplesKt.to(r3, r1.getValue());
    L12:
        if (r4 == null) goto L4;
        r0.add(r4);
        goto L4
    L15:
        return MapsKt.toMap(r0);
    }

    public static ECUrlModel q1(Map r1) {
        ECUrlModel r0 = com.bytedance.android.shopping.store.slicecard.i.d(o1(r1.get("image")));
        if (r0 == null) goto L5;
        return r0;
    L5:
        return com.bytedance.android.shopping.store.slicecard.i.d(o1(r1.get("icon")));
    }

    public static List r1(Object r4) {
        if ((r4 instanceof List) == true) goto L5;
        r4 = null;
    L5:
        List r5 = (List) r4;
        if (r5 == null) goto L8;
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L20;
        Object r2 = r6.next();
        if (r2 == null) goto L17;
        String r3 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r2);
        if (r3 == null) goto L17;
        Integer r7 = Integer.valueOf(s.a(r3, 0));
    L18:
        if (r7 == null) goto L11;
        r0.add(r7);
    L17:
        r7 = null;
        goto L18
    L20:
        return r0;
    L8:
        return CollectionsKt.emptyList();
    }

    public static List s1(Object r4) {
        if ((r4 instanceof List) == true) goto L5;
        r4 = null;
    L5:
        List r5 = (List) r4;
        if (r5 == null) goto L8;
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L11:
        if (r6.hasNext() == false) goto L21;
        Object r2 = r6.next();
        if ((r2 instanceof Number) == true) goto L15;
        r2 = null;
    L15:
        Number r3 = (Number) r2;
        if (r3 == null) goto L18;
        Float r7 = Float.valueOf(r3.floatValue());
    L19:
        if (r7 == null) goto L11;
        r0.add(r7);
        goto L11
    L18:
        r7 = null;
        goto L19
    L21:
        return r0;
    L8:
        return CollectionsKt.emptyList();
    }

    public static com.bytedance.android.shopping.store.slicecard.view.i t1(Object r2) {
        List r3 = u1(r2);
        if ((!r3.isEmpty()) == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return new com.bytedance.android.shopping.store.slicecard.view.i(r3);
    }

    public static List u1(Object r26) {
        Object r0 = r26;
        if ((r0 instanceof List) == false) goto L54;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((Iterable) r0).iterator();
    L6:
        if (r2.hasNext() == false) goto L78;
        Object r5 = r2.next();
        if ((r5 instanceof Map) == false) goto L42;
        Map r6 = p1((Map) r5);
        String r7 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r6.get("text"));
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        String r8 = r7;
        ECUrlModel r10 = q1(r6);
        ECUrlModel r9 = com.bytedance.android.shopping.store.slicecard.i.d(o1(r6.get("immersive_image")));
        if (StringsKt.isBlank(r8) == false) goto L17;
        if (r10 != null) goto L17;
        if (r9 != null) goto L17;
    L50:
        com.bytedance.android.shopping.store.slicecard.view.g r11 = null;
    L51:
        if (r11 == null) goto L6;
        r1.add(r11);
    L17:
        String r12 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r6.get("text_color"));
        Integer r13 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r6.get("font_size"));
        if (r13 == null) goto L20;
        Float r14 = Float.valueOf(ExtensionsKt.b(r13));
    L21:
        Integer r15 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r6.get("font_weight"));
        String r16 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r6.get("font_family"));
        List r17 = r1(r6.get("text_colors"));
        List r18 = s1(r6.get("text_positions"));
        Float r19 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r6.get("text_orientation"));
        String r110 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r6.get("immersive_text_color"));
        List r21 = r1(r6.get("immersive_text_colors"));
        List r22 = s1(r6.get("immersive_text_positions"));
        Float r23 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r6.get("immersive_text_orientation"));
        Object r20 = r6.get("image_margin");
        if ((r20 instanceof List) == true) goto L24;
        r20 = null;
    L24:
        List r24 = (List) r20;
        if (r24 != null) goto L27;
        List r25 = CollectionsKt.emptyList();
    L40:
        r11 = new com.bytedance.android.shopping.store.slicecard.view.g(r8, r12, r10, w1(r10, r9, true), w1(r10, r9, false), r14, r15, r16, r17, r18, r19, r110, r9, r21, r22, r23, r25);
        goto L51
    L27:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r24.iterator();
    L29:
        if (r28.hasNext() == false) goto L39;
        Object r111 = r28.next();
        if ((r111 instanceof Number) == true) goto L33;
        r111 = null;
    L33:
        Number r112 = (Number) r111;
        if (r112 == null) goto L36;
        Float r113 = Float.valueOf(ExtensionsKt.b(Float.valueOf(r112.floatValue())));
    L37:
        if (r113 == null) goto L29;
        r27.add(r113);
        goto L29
    L36:
        r113 = null;
        goto L37
    L39:
        r25 = r27;
        goto L40
    L20:
        r14 = null;
        goto L21
    L42:
        if ((r5 instanceof String) == false) goto L50;
        if ((!StringsKt.isBlank((String) r5)) == true) goto L47;
        r5 = null;
    L47:
        String r29 = (String) r5;
        if (r29 == null) goto L50;
        r11 = new com.bytedance.android.shopping.store.slicecard.view.g(r29, null, null, 131070);
        goto L51
    L78:
        return r1;
    L54:
        if ((r0 instanceof String) == false) goto L65;
        if ((!StringsKt.isBlank((String) r0)) == true) goto L59;
        r0 = null;
    L59:
        String r3 = (String) r0;
        if (r3 == null) goto L77;
        List r4 = CollectionsKt.listOf(new com.bytedance.android.shopping.store.slicecard.view.g(r3, null, null, 131070));
        if (r4 == null) goto L77;
        return r4;
    L77:
        return CollectionsKt.emptyList();
    L65:
        return CollectionsKt.emptyList();
    }

    public static com.bytedance.android.shopping.store.slicecard.view.i v1(Object r2) {
        Map r3 = o1(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        List r4 = u1(r3.get("rich_texts"));
        if ((!r4.isEmpty()) == true) goto L9;
        r4 = null;
    L9:
        if (r4 != null) goto L11;
        return null;
    L11:
        return new com.bytedance.android.shopping.store.slicecard.view.i(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v25 */
    public final void H0(Map<String, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r18, "props");
        ECShopTrustFloatBarContentView r2 = (ECShopTrustFloatBarContentView) k1();
        if (r2 != null) goto L5;
        return;
    L5:
        Map<String, ? extends Object> r3 = o1(r18.get("trust_info"));
        if (r3 != null) goto L8;
        r3 = o1(r18.get("shop_trust_info"));
    L8:
        if (r3 != null) goto L10;
        r3 = r18;
    L10:
        Object r1 = r18.get("media_scroll_percent");
        if (r1 == null) goto L15;
        Float r4 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r1);
        if (r4 == null) goto L15;
        Float r5 = Float.valueOf(RangesKt.coerceIn(r4.floatValue(), 0.0f, 1.0f));
    L17:
        if ((!Intrinsics.areEqual(r3, this.H3)) == false) goto L193;
        this.H3 = r3;
        com.bytedance.android.shopping.store.slicecard.view.i r7 = v1(r3.get("leading_item"));
        if (r7 != null) goto L21;
        r7 = t1(r3.get("leading_texts"));
    L21:
        com.bytedance.android.shopping.store.slicecard.view.i r11 = r7;
        com.bytedance.android.shopping.store.slicecard.view.i r8 = v1(r3.get("trailing_item"));
        if (r8 != null) goto L24;
        r8 = t1(r3.get("benefit_texts"));
    L24:
        if (r8 != null) goto L26;
        r8 = t1(r3.get("trailing_texts"));
    L26:
        com.bytedance.android.shopping.store.slicecard.view.i r12 = r8;
        com.bytedance.android.shopping.store.slicecard.view.i r9 = v1(r3.get("brand_names"));
        if (r9 != null) goto L72;
        Object r10 = r3.get("brand_names");
        if ((r10 instanceof List) == false) goto L64;
        ?? r13 = new ArrayList();
        Iterator r14 = ((Iterable) r10).iterator();
    L32:
        if (r14.hasNext() == false) goto L65;
        Object r15 = r14.next();
        if ((r15 instanceof Map) == false) goto L52;
        Map r16 = p1((Map) r15);
        String r17 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r16.get("name"));
        if (r17 != null) goto L38;
    L42:
        r17 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r16.get("text"));
        if (r17 != null) goto L45;
    L47:
        r17 = null;
    L48:
        if (r17 == null) goto L60;
        com.bytedance.android.shopping.store.slicecard.view.g r19 = new com.bytedance.android.shopping.store.slicecard.view.g(r17, com.bytedance.android.ecom.arch.slice.render.util.b.r(r16.get("text_color")), q1(r16), 131064);
    L61:
        if (r19 == null) goto L32;
        r13.add(r19);
    L60:
        r19 = null;
        goto L61
    L45:
        if ((!StringsKt.isBlank(r17)) == false) goto L47;
    L38:
        if ((!StringsKt.isBlank(r17)) == true) goto L41;
        r17 = null;
    L41:
        if (r17 != null) goto L48;
    L52:
        if ((r15 instanceof String) == false) goto L60;
        if ((!StringsKt.isBlank((String) r15)) == true) goto L57;
        r15 = null;
    L57:
        String r110 = (String) r15;
        if (r110 == null) goto L60;
        r19 = new com.bytedance.android.shopping.store.slicecard.view.g(r110, null, null, 131070);
    L65:
        boolean r6 = !((Collection) r13).isEmpty();
        ?? r20 = r13;
        if (r6 == true) goto L69;
        r20 = 0;
    L69:
        if (r20 == 0) goto L71;
        com.bytedance.android.shopping.store.slicecard.view.i r111 = new com.bytedance.android.shopping.store.slicecard.view.i(r20);
    L73:
        Map r21 = o1(r3.get("auth_text"));
        if (r21 == null) goto L95;
        com.bytedance.android.shopping.store.slicecard.view.i r22 = v1(r21.get("normal_suffix"));
        if (r22 != null) goto L79;
        r22 = t1(r21.get("normal_suffix"));
    L79:
        com.bytedance.android.shopping.store.slicecard.view.i r23 = v1(r21.get("folded_suffix"));
        if (r23 != null) goto L82;
        r23 = t1(r21.get("folded_suffix"));
    L82:
        if (r22 != null) goto L84;
    L85:
        if (r23 == null) goto L95;
        if (r23.a() != true) goto L95;
    L90:
        if (r22 != null) goto L92;
        r22 = new com.bytedance.android.shopping.store.slicecard.view.i(CollectionsKt.listOf(new com.bytedance.android.shopping.store.slicecard.view.g("品牌授权", null, null, 131070)));
    L92:
        if (r23 != null) goto L94;
        r23 = new com.bytedance.android.shopping.store.slicecard.view.i(CollectionsKt.listOf(new com.bytedance.android.shopping.store.slicecard.view.g("等品牌授权", null, null, 131070)));
    L94:
        com.bytedance.android.shopping.store.slicecard.view.a r112 = new com.bytedance.android.shopping.store.slicecard.view.a(r22, r23);
    L96:
        if (r11 != null) goto L98;
    L99:
        if (r12 != null) goto L101;
    L102:
        if (r111 != null) goto L104;
    L105:
        if (r112 != null) goto L107;
        com.bytedance.android.shopping.store.slicecard.view.c r24 = null;
    L120:
        r2.k.clear();
        ((LinkedHashMap) r2.l).clear();
        if (r24 == null) goto L153;
        com.bytedance.android.shopping.store.slicecard.view.i r25 = r24.d;
        if (r25 == null) goto L131;
        List<com.bytedance.android.shopping.store.slicecard.view.g> r26 = r25.a;
        ArrayList r27 = new ArrayList();
        Iterator r28 = r26.iterator();
    L126:
        if (r28.hasNext() == false) goto L130;
        Object r29 = r28.next();
        if (((com.bytedance.android.shopping.store.slicecard.view.g) r29).b() == false) goto L126;
        r27.add(r29);
        goto L126
    L130:
        List r30 = CollectionsKt.take(r27, 4);
        Intrinsics.checkNotNullParameter(r30, "richTexts");
        com.bytedance.android.shopping.store.slicecard.view.i r113 = new com.bytedance.android.shopping.store.slicecard.view.i(r30);
    L132:
        com.bytedance.android.shopping.store.slicecard.view.i r31 = r24.c;
        if (r31 == null) goto L141;
        List<com.bytedance.android.shopping.store.slicecard.view.g> r32 = r31.a;
        ArrayList r33 = new ArrayList();
        Iterator r34 = r32.iterator();
    L136:
        if (r34.hasNext() == false) goto L140;
        Object r35 = r34.next();
        if (((com.bytedance.android.shopping.store.slicecard.view.g) r35).b() == false) goto L136;
        r33.add(r35);
        goto L136
    L140:
        List r36 = CollectionsKt.take(r33, 2);
        Intrinsics.checkNotNullParameter(r36, "richTexts");
        com.bytedance.android.shopping.store.slicecard.view.i r114 = new com.bytedance.android.shopping.store.slicecard.view.i(r36);
    L142:
        com.bytedance.android.shopping.store.slicecard.view.i r37 = r24.b;
        if (r37 == null) goto L151;
        List<com.bytedance.android.shopping.store.slicecard.view.g> r38 = r37.a;
        ArrayList r39 = new ArrayList();
        Iterator r40 = r38.iterator();
    L146:
        if (r40.hasNext() == false) goto L150;
        Object r41 = r40.next();
        if (((com.bytedance.android.shopping.store.slicecard.view.g) r41).b() == false) goto L146;
        r39.add(r41);
        goto L146
    L150:
        Intrinsics.checkNotNullParameter(r39, "richTexts");
        com.bytedance.android.shopping.store.slicecard.view.i r115 = new com.bytedance.android.shopping.store.slicecard.view.i(r39);
    L152:
        com.bytedance.android.shopping.store.slicecard.view.c r42 = new com.bytedance.android.shopping.store.slicecard.view.c(r24.a, r115, r114, r113, r24.e, r24.f, r24.g);
    L154:
        r2.a = r42;
        r2.b = null;
        r2.setContentDescription(null);
        com.bytedance.android.shopping.store.slicecard.view.c r43 = r2.a;
        if (r43 == null) goto L185;
        ArrayList r44 = new ArrayList();
        com.bytedance.android.shopping.store.slicecard.view.i r45 = r43.b;
        if (r45 == null) goto L161;
        List<com.bytedance.android.shopping.store.slicecard.view.g> r46 = r45.a;
        if (r46 == null) goto L161;
        r44.addAll(r46);
    L161:
        com.bytedance.android.shopping.store.slicecard.view.i r47 = r43.c;
        if (r47 == null) goto L166;
        List<com.bytedance.android.shopping.store.slicecard.view.g> r48 = r47.a;
        if (r48 == null) goto L166;
        r44.addAll(r48);
    L166:
        com.bytedance.android.shopping.store.slicecard.view.i r49 = r43.d;
        if (r49 == null) goto L171;
        List<com.bytedance.android.shopping.store.slicecard.view.g> r50 = r49.a;
        if (r50 == null) goto L171;
        r44.addAll(r50);
    L171:
        com.bytedance.android.shopping.store.slicecard.view.a r51 = r43.e;
        if (r51 == null) goto L178;
        com.bytedance.android.shopping.store.slicecard.view.i r52 = r51.a;
        if (r52 == null) goto L178;
        List<com.bytedance.android.shopping.store.slicecard.view.g> r53 = r52.a;
        if (r53 == null) goto L178;
        r44.addAll(r53);
    L178:
        com.bytedance.android.shopping.store.slicecard.view.a r54 = r43.e;
        List r55 = r44;
        if (r54 == null) goto L186;
        com.bytedance.android.shopping.store.slicecard.view.i r56 = r54.b;
        r55 = r44;
        if (r56 == null) goto L186;
        List<com.bytedance.android.shopping.store.slicecard.view.g> r57 = r56.a;
        r55 = r44;
        if (r57 == null) goto L186;
        r44.addAll(r57);
        r55 = r44;
    L186:
        if (r55 != null) goto L188;
        r55 = CollectionsKt.emptyList();
    L188:
        Iterator r58 = r55.iterator();
    L190:
        if (r58.hasNext() == false) goto L192;
        com.bytedance.android.shopping.store.slicecard.view.g r59 = (com.bytedance.android.shopping.store.slicecard.view.g) r58.next();
        r2.i(r59.c);
        r2.i(r59.m);
        goto L190
    L192:
        r2.requestLayout();
        r2.invalidate();
        goto L193
    L185:
        r55 = null;
        goto L186
    L151:
        r115 = null;
        goto L152
    L141:
        r114 = null;
        goto L142
    L131:
        r113 = null;
        goto L132
    L153:
        r42 = null;
    L107:
        Integer r60 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r3.get("identity_type"));
        if (r60 == null) goto L110;
        int r116 = r60.intValue();
    L111:
        Integer r61 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r3.get("content_height"));
        if (r61 == null) goto L114;
        Integer r117 = Integer.valueOf(ExtensionsKt.a(r61));
    L115:
        Integer r62 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r3.get("horizon_padding"));
        if (r62 == null) goto L118;
        Integer r118 = Integer.valueOf(ExtensionsKt.a(r62));
    L119:
        r24 = new com.bytedance.android.shopping.store.slicecard.view.c(r116, r11, r12, r111, r112, r117, r118);
        goto L120
    L118:
        r118 = null;
        goto L119
    L114:
        r117 = null;
        goto L115
    L110:
        r116 = 0;
        goto L111
    L104:
        if (r111.a() == true) goto L107;
    L101:
        if (r12.a() == true) goto L107;
    L98:
        if (r11.a() == true) goto L107;
    L84:
        if (r22.a() == true) goto L90;
    L95:
        r112 = null;
        goto L96
    L71:
        r111 = null;
        goto L73
    L64:
        r13 = u1(r10);
        goto L65
    L72:
        r111 = r9;
    L193:
        if (r5 == null) goto L224;
        float r63 = r5.floatValue();
        if (r63 == this.I3) goto L225;
        this.I3 = r63;
        float r64 = RangesKt.coerceIn(r63, 0.0f, 1.0f);
        if (r64 == r2.c) goto L226;
        r2.c = r64;
        int r65 = r2.d(r2.getWidth());
        if (r65 > 0) goto L202;
        r2.b = null;
    L203:
        r2.invalidate();
        return;
    L202:
        r2.b = r2.j(r2.a, r65);
        r2.m();
        goto L203
    L226:
        return;
    L225:
        return;
    L224:
        return;
    L15:
        r5 = null;
        goto L17
    }

    public final View n1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ECShopTrustFloatBarContentView r0 = new ECShopTrustFloatBarContentView(r2);
        r0.setImportantForAccessibility(1);
        return r0;
    }

    public static Float w1(ECUrlModel r1, ECUrlModel r2, boolean r3) {
        boolean r0 = false;
        if (r1 == null) goto L7;
        if (r3 == false) goto L6;
        int r4 = r1.getWidth();
    L12:
        Integer r5 = Integer.valueOf(r4);
        if (r5.intValue() <= 0) goto L16;
        r0 = true;
    L16:
        if (r0 == true) goto L19;
        r5 = null;
    L19:
        if (r5 != null) goto L21;
        return null;
    L21:
        return Float.valueOf(ExtensionsKt.b(r5));
    L6:
        r4 = r1.getHeight();
        goto L12
    L7:
        if (r2 == null) goto L11;
        if (r3 == false) goto L10;
        r4 = r2.getWidth();
        goto L12
    L10:
        r4 = r2.getHeight();
        goto L12
    L11:
        r4 = 0;
        goto L12
    }
}
