package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q extends b {
    public q(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r22, View r23) {
        Intrinsics.checkNotNullParameter(r22, "action");
        Intrinsics.checkNotNullParameter(r23, "targetView");
        Map r1 = r22.getParams();
        String r7 = null;
        if (r1 == null) goto L5;
        Object r2 = r1.get("useDeviceParams");
    L7:
        if ((r2 instanceof Boolean) == true) goto L9;
        r2 = null;
    L9:
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L12;
        boolean r8 = r3.booleanValue();
    L13:
        Map r4 = r22.getParams();
        if (r4 == null) goto L16;
        Object r5 = r4.get("btmAppendIndex");
    L18:
        if ((r5 instanceof Boolean) == true) goto L20;
        r5 = null;
    L20:
        Boolean r6 = (Boolean) r5;
        if (r6 == null) goto L23;
        boolean r9 = r6.booleanValue();
    L24:
        Map r10 = r22.getParams();
        if (r10 == null) goto L27;
        Object r11 = r10.get("btm");
    L29:
        if ((r11 instanceof String) == true) goto L31;
        r11 = null;
    L31:
        String r12 = (String) r11;
        if (r12 != null) goto L34;
        String r13 = "";
    L35:
        Map r14 = r22.getParams();
        if (r14 == null) goto L38;
        Object r15 = r14.get("sameAsEventName");
    L40:
        if ((r15 instanceof String) == true) goto L42;
        r15 = null;
    L42:
        String r16 = (String) r15;
        if (r16 != null) goto L45;
        String r17 = "";
    L46:
        Map r18 = r22.getParams();
        if (r18 == null) goto L49;
        Object r19 = r18.get("eventName");
    L51:
        if ((r19 instanceof String) == true) goto L53;
        r19 = null;
    L53:
        String r20 = (String) r19;
        if (r20 != null) goto L56;
        return false;
    L56:
        Map r21 = r22.getParams();
        if (r21 == null) goto L59;
        Object r24 = r21.get("params");
    L61:
        if (TypeIntrinsics.isMutableMap(r24) == true) goto L63;
        r24 = null;
    L63:
        Map<? extends String, ? extends Object> r110 = (Map) r24;
        if (r110 == null) goto L66;
        Object r25 = r110.get("area");
    L68:
        if ((r25 instanceof String) == true) goto L70;
        r25 = null;
    L70:
        String r26 = (String) r25;
        if (r26 != null) goto L73;
        String r111 = "";
    L74:
        vc3.a r27 = this.c.n(r20, r111, r13, r9, r23);
        if (r110 == null) goto L79;
        Map<String, Object> r28 = r27.a;
        if (r28 == null) goto L79;
        r28.putAll(r110);
    L79:
        DeepFeedProductEventTracker r29 = this.c.A();
        if (r8 == true) goto L82;
        DeepFeedProductEventTracker r112 = r29;
        vc3.a r113 = r27;
        String r30 = r20;
    L197:
        LinkedHashMap r31 = new LinkedHashMap();
        Map<String, Object> r32 = r113.a;
        if (r32 == null) goto L200;
        r31.putAll(r32);
    L200:
        if (r110 == null) goto L202;
        r31.putAll(r110);
    L202:
        r31.put("inflow_order", Integer.valueOf(r113.c));
        if (r112 == null) goto L207;
        r112.s(r30, r113.d, r113.c, r31, r17, r113.e, r113.b, r23);
        return false;
    L207:
        return false;
    L82:
        if (r17.length() <= 0) goto L84;
        boolean r33 = true;
    L85:
        if (r33 == false) goto L87;
        String r34 = r17;
    L89:
        switch(r34.hashCode()) {
            case -2095593002: goto L187;
            case -2005823868: goto L183;
            case -1696497107: goto L176;
            case -1599680109: goto L172;
            case -1066466216: goto L165;
            case -701428098: goto L159;
            case -523626517: goto L155;
            case 77684616: goto L151;
            case 252775821: goto L147;
            case 545056365: goto L143;
            case 611778703: goto L139;
            case 633336627: goto L135;
            case 680133787: goto L129;
            case 752856610: goto L125;
            case 858366741: goto L122;
            case 1499265855: goto L115;
            case 1713752472: goto L109;
            case 1822574574: goto L106;
            case 1873151442: goto L97;
            case 2022256952: goto L92;
            default: goto L90;
        };
    L90:
        r112 = r29;
        r113 = r27;
    L134:
        r30 = r20;
    L192:
        boolean r210 = false;
    L193:
        if (r210 == false) goto L197;
        return false;
    L97:
        DeepFeedProductEventTracker r114 = r29;
        r113 = r27;
        if (r34.equals("product_tag_show") == false) goto L105;
        if (r114 == null) goto L104;
        Integer r35 = Integer.valueOf(r113.c);
        InFeedProductV2 r36 = r113.d;
        List<String> r37 = r113.e;
        if (r37 == null) goto L103;
        r7 = (String) CollectionsKt.firstOrNull(r37);
    L103:
        DeepFeedProductEventTracker r38 = r114;
        Map<? extends String, ? extends Object> r39 = r110;
        r114.u(r35, r36, r7, r113.a, r20);
    L113:
        r110 = r39;
    L119:
        r112 = r38;
    L120:
        r30 = r20;
    L191:
        r210 = true;
    L104:
        r110 = r110;
        r112 = r114;
    L133:
        r30 = r20;
        goto L191
    L105:
        r30 = r20;
        r112 = r114;
        goto L192
    L106:
        r38 = r29;
        r113 = r27;
        r39 = r110;
        if (r34.equals("click_content_desc") == false) goto L114;
        r110 = r39;
        r112 = r38;
    L131:
        if (r112 == null) goto L133;
        String r211 = r20;
        r112.h(r20, r113.c, r113.d, r111, r113.b, r23, r113.e, r113.a);
    L163:
        r30 = r211;
    L114:
        r110 = r39;
    L121:
        r112 = r38;
        r30 = r20;
        goto L192
    L109:
        r38 = r29;
        r113 = r27;
        r39 = r110;
        if (r34.equals("show_comment_entrance") == false) goto L114;
        if (r38 == null) goto L113;
        r110 = r39;
        r38.y(r113.c, r113.d, r113.b, r23, r113.a, r20);
        goto L119
    L115:
        r38 = r29;
        r113 = r27;
        if (r34.equals("livesdk_live_show") == false) goto L121;
        if (r38 == null) goto L119;
        InFeedProductV2 r40 = r113.d;
        int r41 = r113.c;
        r112 = r38;
        r38.s(r20, r40, r41, DeepFeedProductEventTracker.d(r41, r40, r113.a), "", r113.e, r113.b, r23);
        goto L120
    L122:
        r112 = r29;
        r113 = r27;
        if (r34.equals("click_content_small_pic") == false) goto L134;
    L125:
        r112 = r29;
        r113 = r27;
        if (r34.equals("click_buy_button") == false) goto L134;
        if (r112 == null) goto L133;
        r30 = r20;
        r112.k(r113.c, r113.d, r113.b, r23, r113.g, r113.a, r30);
        goto L191
    L129:
        r112 = r29;
        r113 = r27;
        if (r34.equals("click_content_title") == false) goto L134;
    L135:
        r112 = r29;
        r113 = r27;
        r211 = r20;
        if (r34.equals("show_cart_entrance") == false) goto L164;
        if (r112 == null) goto L163;
        r112.x("c958668.d226180", r23, r113.d, r113.a, r211);
    L164:
        r30 = r211;
        goto L192
    L139:
        r112 = r29;
        r113 = r27;
        r211 = r20;
        if (r34.equals("click_add_to_cart") == false) goto L164;
        if (r112 == null) goto L163;
        r30 = r211;
        r112.j(r113.c, r113.d, r113.b, r23, r113.g, r113.a, r30);
        goto L191
    L143:
        r112 = r29;
        r113 = r27;
        r211 = r20;
        if (r34.equals("click_comment_entrance") == false) goto L164;
        if (r112 == null) goto L163;
        r112.m(r113.c, r113.d, r113.b, r23, r113.a, r211);
        goto L163
    L147:
        r112 = r29;
        r113 = r27;
        r211 = r20;
        if (r34.equals("show_buy_button") == false) goto L164;
        if (r112 == null) goto L163;
        r112.w(r113.c, r113.d, r113.b, r23, r113.a, r211);
        goto L163
    L151:
        r112 = r29;
        r113 = r27;
        r211 = r20;
        if (r34.equals("show_wish_button") == false) goto L164;
        if (r112 == null) goto L163;
        r112.B(r113.c, r113.d, r113.b, r23, r113.a, r211);
        goto L163
    L155:
        r112 = r29;
        r113 = r27;
        r211 = r20;
        if (r34.equals("click_store_entrance") == false) goto L164;
        if (r112 == null) goto L163;
        r112.p(r113.c, r113.d, r113.b, r23, r113.a, r211);
        goto L163
    L159:
        r112 = r29;
        r113 = r27;
        r211 = r20;
        if (r34.equals("click_cart_entrance") == false) goto L164;
        if (r112 == null) goto L163;
        r30 = r211;
        r112.l(r113.b, r23, r113.d, r30);
        goto L191
    L165:
        r112 = r29;
        r113 = r27;
        r30 = r20;
        if (r34.equals("trending_words_click") == false) goto L192;
        if (r112 == null) goto L191;
        int r42 = r113.c;
        InFeedProductV2 r43 = r113.d;
        String r44 = r113.b;
        DeepFeedQueryParam r45 = r113.f;
        Map<String, Object> r46 = r113.a;
        Intrinsics.checkNotNullParameter(r23, FreqActions.ACTION_VIEW);
        Map<String, ? extends Object> r47 = DeepFeedProductEventTracker.e(r42, r43, r45);
        if (r47 == null) goto L191;
        DeepFeedProductEventTracker.c(r47, r46);
        le3.b.a(r47, r44, r23);
        r112.doEventAction(r30, r47);
        goto L191
    L172:
        r112 = r29;
        r113 = r27;
        r30 = r20;
        if (r34.equals("click_wish_button") == false) goto L192;
        if (r112 == null) goto L191;
        r112.r(r113.c, r113.d, r113.b, r23, r113.a, r30);
        goto L191
    L176:
        r112 = r29;
        r113 = r27;
        r30 = r20;
        if (r34.equals("trending_words_show") == false) goto L192;
        if (r112 == null) goto L191;
        int r48 = r113.c;
        InFeedProductV2 r49 = r113.d;
        String r50 = r113.b;
        DeepFeedQueryParam r51 = r113.f;
        Map<String, Object> r52 = r113.a;
        Intrinsics.checkNotNullParameter(r23, FreqActions.ACTION_VIEW);
        Map<String, ? extends Object> r53 = DeepFeedProductEventTracker.e(r48, r49, r51);
        if (r53 == null) goto L191;
        DeepFeedProductEventTracker.c(r53, r52);
        le3.b.a(r53, r50, r23);
        r112.doEventAction(r30, r53);
        goto L191
    L183:
        r112 = r29;
        r113 = r27;
        r30 = r20;
        if (r34.equals("show_add_to_cart") == false) goto L192;
        if (r112 == null) goto L191;
        r112.v(r113.c, r113.d, r113.b, r23, r113.a, r30);
        goto L191
    L187:
        r112 = r29;
        r113 = r27;
        r30 = r20;
        if (r34.equals("show_store_entrance") == false) goto L192;
        if (r112 == null) goto L191;
        r112.A(r113.c, r113.d, r113.b, r23, r113.a, r30);
        goto L191
    L92:
        if (r34.equals("click_product") == false) goto L96;
        if (r29 == null) goto L95;
        String r54 = r111;
        r114 = r29;
        r113 = r27;
        r29.n(r27.c, r27.d, r54, r27.b, r23, r27.e, r27.a);
        goto L104
    L95:
        r113 = r27;
        r112 = r29;
        goto L133
    L96:
        r113 = r27;
        r112 = r29;
        goto L134
    L87:
        r34 = r20;
        goto L89
    L84:
        r33 = false;
        goto L85
    L73:
        r111 = r26;
        goto L74
    L66:
        r25 = null;
        goto L68
    L59:
        r24 = null;
        goto L61
    L49:
        r19 = null;
        goto L51
    L45:
        r17 = r16;
        goto L46
    L38:
        r15 = null;
        goto L40
    L34:
        r13 = r12;
        goto L35
    L27:
        r11 = null;
        goto L29
    L23:
        r9 = true;
        goto L24
    L16:
        r5 = null;
        goto L18
    L12:
        r8 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }
}
