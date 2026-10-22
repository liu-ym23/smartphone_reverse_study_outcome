package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.CornerType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public final Set<String> a;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a b;

    public h(com.bytedance.android.shopping.mall.homepage.card.headercard.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mallContext");
        this.b = r2;
        this.a = Collections.synchronizedSet(new LinkedHashSet());
    }

    public static final void a(h r5, int r6, ToolVO r7, Map r8) {
        r5.getClass();
        Pair[] r0 = new Pair[12];
        String r1 = null;
        if (r7 == null) goto L5;
        String r2 = r7.getTitle();
    L6:
        r0[0] = TuplesKt.to("module_name", r2);
        r0[1] = TuplesKt.to("module_type", "icon");
        if (r7 == null) goto L9;
        ToolVO.Corner r3 = r7.getCorner();
    L10:
        if (r3 == null) goto L15;
        ToolVO.Corner r4 = r7.getCorner();
        if (r4 == null) goto L14;
        String r9 = r4.getText();
    L19:
        r0[2] = TuplesKt.to("notice_name", r9);
        r0[3] = TuplesKt.to("position", "top");
        r0[4] = TuplesKt.to("btm_index", Integer.valueOf(r6));
        if (r7 == null) goto L22;
        String r10 = r7.getTitle();
    L23:
        r0[5] = TuplesKt.to("btm_desc", r10);
        if (r7 == null) goto L26;
        String r11 = r7.getTitle();
    L27:
        r0[6] = TuplesKt.to("btm_module_name", r11);
        if (r7 == null) goto L30;
        String r12 = r7.getComponentId();
    L31:
        r0[7] = TuplesKt.to("component_id", r12);
        if (r7 == null) goto L36;
        ToolVO.Corner r13 = r7.getCorner();
        if (r13 == null) goto L36;
        r1 = r13.getType();
    L36:
        r0[8] = TuplesKt.to("has_red_dot", Integer.valueOf(Intrinsics.areEqual(r1, CornerType.DOT.getValue()) ? 1 : 0));
        r0[9] = TuplesKt.to("is_new_layout", 0);
        r0[10] = TuplesKt.to("is_more_tool", 0);
        r0[11] = TuplesKt.to("relative_index", -1);
        b(r5, false, MapsKt.mutableMapOf(r0), r6, r8);
        return;
    L30:
        r12 = null;
        goto L31
    L26:
        r11 = null;
        goto L27
    L22:
        r10 = null;
        goto L23
    L14:
        r9 = null;
        goto L19
    L15:
        if (r7 == null) goto L18;
        r9 = r7.getBadge();
        if (r9 != null) goto L19;
    L18:
        r9 = "";
        goto L19
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static void b(h r7, boolean r8, Map r9, int r10, Map r11) {
        r7.getClass();
        Object r1 = r11.get(SimilarProductParam.ENTER_FROM);
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        Object r4 = r11.get(PdpOpenThirdParam.KEY_PAGE_NAME);
        if (r4 == null) goto L9;
        String r5 = r4.toString();
    L10:
        Object r6 = r11.get("previous_page");
        if (r6 == null) goto L16;
        String r12 = r6.toString();
        if (r12 == null) goto L16;
        r2 = r12;
    L16:
        Object r13 = r9.get("component_id");
        if (r13 == null) goto L20;
        String r14 = r13.toString();
        if (r14 == null) goto L20;
    L21:
        r9.put(SimilarProductParam.ENTER_FROM, r2);
        r9.put(PdpOpenThirdParam.KEY_PAGE_NAME, r5);
        r9.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r9.put("previous_page", r2);
        r9.put("module_id", "tool_list");
        String r15 = com.bytedance.android.shopping.mall.homepage.card.headercard.util.b.b(r10, r14, null);
        if (r8 == false) goto L24;
        String r16 = "click_order_homepage_module_entrance";
    L25:
        com.bytedance.android.shopping.mall.homepage.card.headercard.util.e.b(r7.b, r16, r15, r9, r11);
        return;
    L24:
        r16 = "show_order_homepage_module_entrance";
    L20:
        r14 = "";
        goto L21
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
