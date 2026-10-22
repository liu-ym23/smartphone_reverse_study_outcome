package com.bytedance.android.shopping.mall.homepage.jsb;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendant;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendantManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends qf3.e {
    public final String d;
    public final List<String> e;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public b(qf3.d r4) {
        Intrinsics.checkNotNullParameter(r4, "mallJsbContext");
        super(r4);
        this.d = "ec.mall.anchor_pendant_show";
        this.e = CollectionsKt.listOf(new String[]{"margin_left", "margin_top", "margin_right", "margin_bottom"});
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r24, IBDXBridgeContext r25, Map<String, ? extends Object> r26, Map<String, Object> r27) {
        Intrinsics.checkNotNullParameter(r24, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r25, "bridgeContext");
        Intrinsics.checkNotNullParameter(r26, "params");
        Intrinsics.checkNotNullParameter(r27, "result");
        Object r5 = r26.get("data");
        if ((r5 instanceof String) == true) goto L5;
        r5 = null;
    L5:
        String r6 = (String) r5;
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        Object r9 = r26.get("container_id");
        if ((r9 instanceof String) == true) goto L11;
        r9 = null;
    L11:
        String r10 = (String) r9;
        if (r10 != null) goto L14;
        r10 = "";
    L14:
        AnchorPendantManager r11 = r24.b.A1.Pt();
        if (r11 == null) goto L17;
        boolean r13 = false;
        if (r10.length() <= 0) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == false) goto L38;
        Intrinsics.checkNotNullParameter(r10, "containerID");
        Intrinsics.checkNotNullParameter(r6, "data");
        AnchorPendant r14 = r11.f(r10);
        if (r14 == null) goto L32;
        com.bytedance.android.shopping.mall.homepage.pendant.anchor.b r15 = r14.r;
        if (r15 == null) goto L32;
        of3.a r16 = r15.b;
        if (r16 == null) goto L32;
        com.bytedance.android.ec.hybrid.card.api.e r17 = r16.b;
        if (r17 == null) goto L32;
        int r18 = com.bytedance.android.ec.hybrid.card.api.d.e;
        r17.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(r6), true);
    L32:
        if (r14 == null) goto L34;
        boolean r7 = true;
    L35:
        if (r7 == false) goto L38;
        r27.put("container_id", r10);
        return TuplesKt.to(Boolean.TRUE, null);
    L34:
        r7 = false;
    L38:
        View r4 = r25.getEngineView();
        Object r8 = r26.get("schema");
        if ((r8 instanceof String) == true) goto L41;
        r8 = null;
    L41:
        String r19 = (String) r8;
        if (r4 == null) goto L189;
        if (r19 == null) goto L189;
        Object r20 = r26.get("targetSectionId");
        if ((r20 instanceof String) == true) goto L48;
        r20 = null;
    L48:
        String r21 = (String) r20;
        Object r22 = r26.get("targetItemId");
        if ((r22 instanceof String) == true) goto L51;
        r22 = null;
    L51:
        String r23 = (String) r22;
        Object r110 = r26.get("anchor_id");
        if ((r110 instanceof String) == true) goto L54;
        r110 = null;
    L54:
        String r111 = (String) r110;
        if (r111 != null) goto L57;
        r111 = "";
    L57:
        if (r21 != null) goto L59;
    L62:
        boolean r112 = true;
    L63:
        if (r112 == true) goto L77;
        if (r23 != null) goto L66;
    L69:
        boolean r113 = true;
    L70:
        if (r113 == true) goto L77;
        ECHybridListEngine r0 = r24.b.J;
        if (r0 == null) goto L83;
        BaseViewHolder r1 = r0.e(r21, r23);
        if (r1 == null) goto L83;
        View r2 = r1.k4(r111);
    L84:
        if (r2 != null) goto L86;
        r2 = r4;
    L86:
        Object r28 = r26.get("width");
        if ((r28 instanceof Number) == true) goto L89;
        r28 = null;
    L89:
        Number r29 = (Number) r28;
        if (r29 != null) goto L92;
        r29 = -2;
    L92:
        Number r114 = r29;
        Object r30 = r26.get("height");
        if ((r30 instanceof Number) == true) goto L95;
        r30 = null;
    L95:
        Number r31 = (Number) r30;
        if (r31 != null) goto L98;
        r31 = -2;
    L98:
        Number r115 = r31;
        Object r32 = r26.get("show_at");
        if ((r32 instanceof String) == true) goto L101;
        r32 = null;
    L101:
        String r33 = (String) r32;
        if (r33 != null) goto L104;
        r33 = "bottom";
    L104:
        String r116 = r33;
        Object r34 = r26.get("gravity");
        if ((r34 instanceof String) == true) goto L107;
        r34 = null;
    L107:
        String r35 = (String) r34;
        if (r35 != null) goto L110;
        r35 = "center";
    L110:
        String r117 = r35;
        List<String> r36 = this.e;
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r36, 10));
        Iterator<T> r38 = r36.iterator();
    L112:
        if (r38.hasNext() == false) goto L120;
        Object r118 = r26.get((String) r38.next());
        if ((r118 instanceof Number) == true) goto L116;
        r118 = null;
    L116:
        Object r119 = (Number) r118;
        if (r119 != null) goto L119;
        r119 = Float.valueOf(0.0f);
    L119:
        r37.add(r119);
        goto L112
    L120:
        Object[] r39 = r37.toArray(new Number[0]);
        if (r39 == null) goto L187;
        com.bytedance.android.shopping.mall.homepage.pendant.anchor.c r40 = new com.bytedance.android.shopping.mall.homepage.pendant.anchor.c(r114, r115, r116, r117, (Number[]) r39);
        Object r41 = r26.get("gray_enable");
        if ((r41 instanceof Boolean) == true) goto L125;
        r41 = null;
    L125:
        Boolean r120 = Boolean.TRUE;
        boolean r121 = Intrinsics.areEqual((Boolean) r41, r120);
        Object r42 = r26.get("absolute");
        if ((r42 instanceof Boolean) == true) goto L128;
        r42 = null;
    L128:
        boolean r122 = Intrinsics.areEqual((Boolean) r42, r120);
        Object r43 = r26.get("avoid");
        if ((r43 instanceof Number) == true) goto L131;
        r43 = null;
    L131:
        Number r44 = (Number) r43;
        if (r44 == null) goto L134;
        int r45 = r44.intValue();
    L135:
        Object r123 = r26.get("estimateWidth");
        if ((r123 instanceof Number) == true) goto L138;
        r123 = null;
    L138:
        Number r124 = (Number) r123;
        if (r124 == null) goto L146;
        Integer r46 = Integer.valueOf(r124.intValue());
        if (r46.intValue() <= 0) goto L143;
        boolean r125 = true;
    L144:
        if (r125 == false) goto L146;
    L147:
        Object r126 = r26.get("estimateHeight");
        if ((r126 instanceof Number) == true) goto L150;
        r126 = null;
    L150:
        Number r127 = (Number) r126;
        if (r127 == null) goto L157;
        Integer r128 = Integer.valueOf(r127.intValue());
        if (r128.intValue() <= 0) goto L155;
        r13 = true;
    L155:
        if (r13 == false) goto L157;
    L158:
        if (r46 == null) goto L161;
        if (r128 == null) goto L161;
        Pair<Integer, Integer> r129 = new Pair(r46, r128);
    L162:
        if (r129 == null) goto L164;
    L167:
        Object r47 = r26.get("is_sticky");
        if ((r47 instanceof Boolean) == true) goto L170;
        r47 = null;
    L170:
        boolean r210 = Intrinsics.areEqual((Boolean) r47, r120);
        Object r48 = r26.get("recycleAfterDismiss");
        if ((r48 instanceof Boolean) == true) goto L173;
        r48 = null;
    L173:
        boolean r211 = Intrinsics.areEqual((Boolean) r48, r120);
        Object r49 = r26.get("scene_type");
        if ((r49 instanceof Integer) == true) goto L176;
        r49 = null;
    L176:
        Integer r212 = (Integer) r49;
        Object r3 = r26.get("data");
        if ((r3 instanceof String) == true) goto L179;
        Object r50 = null;
    L180:
        String r51 = (String) r50;
        if (r51 != null) goto L183;
        String r130 = "";
    L184:
        Pair<String, String> r52 = r11.h(r2, r40, r19, r130, r121, r122, r45, r129, r210, r211, r212);
        Object r53 = (String) r52.component1();
        String r54 = (String) r52.component2();
        r27.put("container_id", r53);
        return TuplesKt.to(r120, r54);
    L183:
        r130 = r51;
        goto L184
    L179:
        r50 = r3;
        goto L180
    L164:
        if (r45 != 3) goto L167;
        return TuplesKt.to(Boolean.FALSE, "estimateWidth and estimateHeight can not be null");
    L161:
        r129 = null;
    L157:
        r128 = null;
        goto L158
    L143:
        r125 = false;
    L146:
        r46 = null;
        goto L147
    L134:
        r45 = 0;
        goto L135
    L187:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L83:
        r2 = null;
        goto L84
    L66:
        if (r23.length() == 0) goto L69;
        r113 = false;
    L77:
        if ((r4 instanceof LynxView) == true) goto L79;
        View r55 = null;
    L80:
        LynxView r56 = (LynxView) r55;
        if (r56 == null) goto L83;
        r2 = r56.findViewByName(r111);
        goto L84
    L79:
        r55 = r4;
        goto L80
    L59:
        if (r21.length() == 0) goto L62;
        r112 = false;
    L189:
        return TuplesKt.to(Boolean.FALSE, "lynxView or schema is null");
    L21:
        r12 = false;
        goto L22
    L17:
        return TuplesKt.to(Boolean.FALSE, "anchorPendantManager is null");
    }
}
