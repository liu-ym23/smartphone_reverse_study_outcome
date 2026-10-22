package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.tracker.OrderListTracker;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderListTabLayoutViewManager extends BaseSlcViewManager<OrderListTabLayout> {
    public final Function0<OrderListFragment> H3;

    public final View A0(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new OrderListTabLayout(r5, null, 6, 0);
    }

    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (((OrderListTabLayout) getView()).dispatchHoverEvent(r2) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    public final void H0(Map<String, ? extends Object> r32) {
        Intrinsics.checkNotNullParameter(r32, "props");
        Object r2 = r32.get("uiConfig");
        if ((r2 instanceof String) == true) goto L5;
        r2 = null;
    L5:
        String r3 = (String) r2;
        if (r3 == null) goto L8;
        JSONObject r4 = z1.f(r3);
    L9:
        if (r4 == null) goto L11;
        JSONObject r5 = r4.optJSONObject("badge");
    L12:
        final l r6 = k1(r5);
        if (r4 == null) goto L15;
        JSONObject r7 = r4.optJSONObject("normal_button");
    L16:
        final l r11 = k1(r7);
        if (r4 == null) goto L19;
        JSONObject r8 = r4.optJSONObject("selected_button");
    L20:
        final l r12 = k1(r8);
        if (r4 == null) goto L23;
        JSONObject r9 = r4.optJSONObject("indicator");
    L25:
        if (r9 == null) goto L29;
        String r10 = r9.optString("bg_color");
        if (r10 == null) goto L29;
        Integer r13 = com.bytedance.android.ecom.arch.slice.render.util.b.g(r10);
    L30:
        if (r9 == null) goto L32;
        Object r14 = r9.opt("width");
    L34:
        if ((r14 instanceof Number) == true) goto L36;
        r14 = null;
    L36:
        Number r15 = (Number) r14;
        if (r15 == null) goto L39;
        Integer r16 = Integer.valueOf(r15.intValue());
    L40:
        if (r9 == null) goto L42;
        Object r17 = r9.opt("height");
    L44:
        if ((r17 instanceof Number) == true) goto L46;
        r17 = null;
    L46:
        Number r18 = (Number) r17;
        if (r18 == null) goto L49;
        Integer r19 = Integer.valueOf(r18.intValue());
    L50:
        if (r9 == null) goto L52;
        Object r20 = r9.opt("bottom");
    L54:
        if ((r20 instanceof Number) == true) goto L56;
        r20 = null;
    L56:
        Number r21 = (Number) r20;
        if (r21 == null) goto L59;
        Integer r22 = Integer.valueOf(r21.intValue());
    L60:
        final k r110 = new k(r16, r19, r13, r22);
        if (r4 == null) goto L63;
        int r111 = r4.optInt("space_width");
    L64:
        if (r4 == null) goto L66;
        JSONObject r23 = r4.optJSONObject("adaptive_gap");
    L67:
        if (r23 != null) goto L69;
        a r24 = null;
    L97:
        Object r25 = r32.get("selectedTabId");
        if ((r25 instanceof Number) == true) goto L100;
        r25 = null;
    L100:
        Number r26 = (Number) r25;
        if (r26 != null) goto L103;
        r26 = 0;
    L103:
        final int r27 = r26.intValue();
        Lazy r28 = OrderCommonLog.a;
        String r112 = "OrderListTabLayoutViewManager";
        OrderCommonLog.a("OrderListTabLayoutViewManager", new OrderListTabLayoutViewManager$getTabList$1(r27));
        final ArrayList r29 = new ArrayList();
        Object r1 = r32.get("tabs");
        if ((r1 instanceof List) == true) goto L106;
        r1 = null;
    L106:
        List r30 = (List) r1;
        if (r30 == null) goto L186;
        Iterator r31 = r30.iterator();
        int r33 = 0;
    L110:
        if (r31.hasNext() == false) goto L186;
        Object r113 = r31.next();
        int r34 = r33 + 1;
        if (r33 >= 0) goto L114;
        CollectionsKt.throwIndexOverflow();
    L114:
        Map r35 = (Map) r113;
        Object r114 = r35.get("tab_name");
        Iterator r210 = r31;
        if ((r114 instanceof String) == true) goto L117;
        r114 = null;
    L117:
        String r115 = (String) r114;
        if (r115 != null) goto L120;
        String r116 = "";
    L121:
        Object r117 = r35.get("count");
        String r36 = r112;
        if ((r117 instanceof Number) == true) goto L124;
        r117 = null;
    L124:
        Number r118 = (Number) r117;
        if (r118 == null) goto L130;
        String r119 = String.valueOf(r118.intValue());
        if (r119 == null) goto L130;
        String r120 = r119;
    L134:
        Object r121 = r35.get("tab_id");
        if ((r121 instanceof Number) == true) goto L137;
        r121 = null;
    L137:
        Number r122 = (Number) r121;
        if (r122 != null) goto L140;
        r122 = 0;
    L140:
        int r123 = r122.intValue();
        Map r124 = (Map) CollectionsKt.getOrNull(r30, r33 - 1);
        if (r124 == null) goto L149;
        Object r125 = r124.get("tab_id");
        if ((r125 instanceof Number) == true) goto L145;
        r125 = null;
    L145:
        Number r126 = (Number) r125;
        if (r126 != null) goto L148;
        r126 = Integer.valueOf(r123);
    L148:
        int r211 = r126.intValue();
    L150:
        Map r0 = (Map) CollectionsKt.getOrNull(r30, r34);
        if (r0 == null) goto L159;
        Object r37 = r0.get("tab_id");
        if ((r37 instanceof Number) == true) goto L155;
        r37 = null;
    L155:
        Number r38 = (Number) r37;
        if (r38 != null) goto L158;
        r38 = Integer.valueOf(r123);
    L158:
        int r212 = r38.intValue();
    L161:
        if (r27 != r123) goto L163;
        boolean r213 = true;
    L164:
        if (r33 != 0) goto L166;
        boolean r214 = true;
    L168:
        if (r33 != CollectionsKt.getLastIndex(r30)) goto L170;
        boolean r215 = true;
    L171:
        if (r33 == 0) goto L178;
        if (r24 == null) goto L176;
        int r127 = 1;
        if (r24.a == 1) goto L179;
    L177:
        boolean r216 = false;
    L180:
        if (r24 != null) goto L182;
    L184:
        boolean r217 = false;
    L185:
        r29.add(new g(r116, r120, r211, r123, r212, r213, r214, r215, r216, r217, r35));
        r33 = r34;
        r31 = r210;
        r112 = r36;
        goto L110
    L182:
        if (r24.a != r127) goto L184;
        r217 = true;
    L179:
        r216 = true;
        goto L180
    L176:
        r127 = 1;
        goto L177
    L178:
        r127 = 1;
        goto L179
    L170:
        r215 = false;
        goto L171
    L166:
        r214 = false;
        goto L168
    L163:
        r213 = false;
        goto L164
    L159:
        r212 = r123;
        goto L161
    L149:
        r211 = r123;
    L130:
        Object r39 = r35.get("count");
        if ((r39 instanceof String) == true) goto L133;
        r39 = null;
    L133:
        r120 = (String) r39;
        goto L134
    L120:
        r116 = r115;
    L186:
        Lazy r40 = OrderCommonLog.a;
        OrderCommonLog.c(r112, new OrderListTabLayoutViewManager$onUpdateProp$1(r6, r11, r12, r110, r29));
        f r41 = new f(r6, r11, r12, r110, r29, r111, r24);
        if (r29.size() == ((OrderListTabLayout) getView()).getTabSize()) goto L189;
        OrderListTabLayoutViewManager r42 = this;
        ((OrderListTabLayout) getView()).c(((BaseSlcViewManager) r42).a.m(), r42.H3, r41, OrderListTabLayout.BindType.FULL_INIT);
    L190:
        OrderListFragment r43 = (OrderListFragment) r42.H3.invoke();
        if (r43 == null) goto L201;
        OrderListViewModel r44 = r43.Y90();
        if (r44 == null) goto L202;
        OrderListTracker r45 = r44.getTracker();
        if (r45 == null) goto L203;
        r45.b("ecom_module_view", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("btm", "a1.b6871.c706088.d0")}));
        return;
    L203:
        return;
    L202:
        return;
    L201:
        return;
    L189:
        r42 = this;
        ((OrderListTabLayout) getView()).c(((BaseSlcViewManager) r42).a.m(), r42.H3, r41, OrderListTabLayout.BindType.DIFF_UPDATE);
        goto L190
    L69:
        Object r46 = r23.opt("enable");
        if ((r46 instanceof Number) == true) goto L72;
        r46 = null;
    L72:
        Number r47 = (Number) r46;
        if (r47 == null) goto L75;
        int r48 = r47.intValue();
    L76:
        Object r49 = r23.opt("min_gap");
        if ((r49 instanceof Number) == true) goto L79;
        r49 = null;
    L79:
        Number r50 = (Number) r49;
        if (r50 == null) goto L82;
        int r51 = r50.intValue();
    L83:
        Object r52 = r23.opt("left_padding");
        if ((r52 instanceof Number) == true) goto L86;
        r52 = null;
    L86:
        Number r53 = (Number) r52;
        int r54 = 16;
        if (r53 == null) goto L89;
        int r55 = r53.intValue();
    L90:
        Object r56 = r23.opt("right_padding");
        if ((r56 instanceof Number) == true) goto L93;
        r56 = null;
    L93:
        Number r57 = (Number) r56;
        if (r57 == null) goto L96;
        r54 = r57.intValue();
    L96:
        r24 = new a(r48, r51, r55, r54);
        goto L97
    L89:
        r55 = 16;
        goto L90
    L82:
        r51 = 18;
        goto L83
    L75:
        r48 = 0;
        goto L76
    L66:
        r23 = null;
        goto L67
    L63:
        r111 = 0;
        goto L64
    L59:
        r22 = null;
        goto L60
    L52:
        r20 = null;
        goto L54
    L49:
        r19 = null;
        goto L50
    L42:
        r17 = null;
        goto L44
    L39:
        r16 = null;
        goto L40
    L32:
        r14 = null;
    L29:
        r13 = null;
        goto L30
    L23:
        r9 = null;
        goto L25
    L19:
        r8 = null;
        goto L20
    L15:
        r7 = null;
        goto L16
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    }

    public final l k1(JSONObject r9) {
        if (r9 == null) goto L7;
        String r1 = r9.optString("bg_color");
        if (r1 == null) goto L7;
        Integer r2 = com.bytedance.android.ecom.arch.slice.render.util.b.g(r1);
    L8:
        if (r9 == null) goto L12;
        String r3 = r9.optString("font_color");
        if (r3 == null) goto L12;
        Integer r4 = com.bytedance.android.ecom.arch.slice.render.util.b.g(r3);
    L13:
        if (r9 == null) goto L15;
        Object r5 = r9.opt("font_size");
    L17:
        if ((r5 instanceof Number) == true) goto L19;
        r5 = null;
    L19:
        Number r6 = (Number) r5;
        if (r6 == null) goto L22;
        Integer r7 = Integer.valueOf(r6.intValue());
    L23:
        if (r9 == null) goto L25;
        Object r8 = r9.opt("margin_vertical");
    L27:
        if ((r8 instanceof Number) == true) goto L29;
        r8 = null;
    L29:
        Number r10 = (Number) r8;
        if (r10 == null) goto L32;
        Integer r11 = Integer.valueOf(r10.intValue());
    L33:
        if (r9 == null) goto L35;
        Object r12 = r9.opt("border_width");
    L37:
        if ((r12 instanceof Number) == true) goto L39;
        r12 = null;
    L39:
        Number r13 = (Number) r12;
        if (r13 == null) goto L42;
        Float r14 = Float.valueOf(r13.floatValue());
    L43:
        if (r9 == null) goto L47;
        String r15 = r9.optString("border_color");
        if (r15 == null) goto L47;
        Integer r16 = com.bytedance.android.ecom.arch.slice.render.util.b.g(r15);
    L49:
        return new l(r2, r7, r4, r11, r16, r14);
    L47:
        r16 = null;
        goto L49
    L42:
        r14 = null;
        goto L43
    L35:
        r12 = null;
        goto L37
    L32:
        r11 = null;
        goto L33
    L25:
        r8 = null;
        goto L27
    L22:
        r7 = null;
        goto L23
    L15:
        r5 = null;
    L12:
        r4 = null;
    L7:
        r2 = null;
        goto L8
    }

    public OrderListTabLayoutViewManager(SlcTemplateContext r2, Function0<OrderListFragment> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragmentProvider");
        super(r2);
        this.H3 = r3;
    }
}
