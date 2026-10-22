package com.bytedance.android.shopping.yata.init;

import com.bytedance.kmp.ec.yata.common.init.c;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r7, c r8, Map r9, boolean r10, boolean r11) {
        Object r0 = r9.get("force_log_in_bg_thread_3740");
        Object r2 = null;
        if ((r0 instanceof Boolean) == true) goto L5;
        r0 = null;
    L5:
        Boolean r1 = (Boolean) r0;
        if (r1 == null) goto L8;
        r1.booleanValue();
    L8:
        Object r3 = r9.get("enable_assert_3380");
        if ((r3 instanceof Boolean) == true) goto L11;
        r3 = null;
    L11:
        Boolean r4 = (Boolean) r3;
        boolean r5 = true;
        if (r4 == null) goto L14;
        boolean r6 = r4.booleanValue();
    L15:
        Object r12 = r9.get("enable_warning_3460");
        if ((r12 instanceof Boolean) == true) goto L18;
        r12 = null;
    L18:
        Boolean r13 = (Boolean) r12;
        if (r13 == null) goto L21;
        boolean r14 = r13.booleanValue();
    L22:
        Object r15 = r9.get("enable_node_service_report_error_3460");
        if ((r15 instanceof Boolean) == true) goto L25;
        r15 = null;
    L25:
        Boolean r16 = (Boolean) r15;
        if (r16 == null) goto L28;
        boolean r17 = r16.booleanValue();
    L29:
        Object r18 = r9.get("enable_ensure_not_reach_here_3490");
        if ((r18 instanceof Boolean) == true) goto L32;
        r18 = null;
    L32:
        Boolean r19 = (Boolean) r18;
        if (r19 == null) goto L35;
        boolean r20 = r19.booleanValue();
    L36:
        YaTaLog.b = r6;
        YaTaLog.c = r14;
        YaTaLog.d = r17;
        YaTaLog.e = r20;
        Object r21 = r9.get(r7);
        if ((r21 instanceof Map) == true) goto L39;
        r21 = null;
    L39:
        Map r22 = (Map) r21;
        if (r22 == null) goto L42;
        Object r23 = r22.get("enable_passive_change");
    L44:
        if ((r23 instanceof Boolean) == true) goto L46;
        r23 = null;
    L46:
        Boolean r24 = (Boolean) r23;
        if (r24 == null) goto L49;
        r10 = r24.booleanValue();
    L49:
        r8.a = r10;
        Object r110 = r9.get(r7);
        if ((r110 instanceof Map) == true) goto L52;
        r110 = null;
    L52:
        Map r111 = (Map) r110;
        if (r111 == null) goto L55;
        Object r112 = r111.get("enable_item_anim_3510");
    L57:
        if ((r112 instanceof Boolean) == true) goto L59;
        r112 = null;
    L59:
        Boolean r113 = (Boolean) r112;
        if (r113 == null) goto L62;
        r11 = r113.booleanValue();
    L62:
        r8.b = r11;
        Object r114 = r9.get(r7);
        if ((r114 instanceof Map) == true) goto L65;
        r114 = null;
    L65:
        Map r115 = (Map) r114;
        if (r115 == null) goto L68;
        Object r116 = r115.get("use_biz_tracker");
    L70:
        if ((r116 instanceof Boolean) == true) goto L72;
        r116 = null;
    L72:
        Boolean r117 = (Boolean) r116;
        if (r117 == null) goto L75;
        boolean r118 = r117.booleanValue();
    L76:
        r8.c = r118;
        boolean r119 = false;
        if (r8.e == false) goto L94;
        Object r120 = r9.get(r7);
        if ((r120 instanceof Map) == true) goto L81;
        r120 = null;
    L81:
        Map r121 = (Map) r120;
        if (r121 == null) goto L84;
        Object r122 = r121.get("use_hidden_container_perf_opt_3760");
    L86:
        if ((r122 instanceof Boolean) == true) goto L88;
        r122 = null;
    L88:
        Boolean r123 = (Boolean) r122;
        if (r123 == null) goto L91;
        boolean r124 = r123.booleanValue();
    L92:
        if (r124 == false) goto L94;
        boolean r125 = true;
    L95:
        r8.e = r125;
        Object r126 = r9.get(r7);
        if ((r126 instanceof Map) == true) goto L98;
        r126 = null;
    L98:
        Map r127 = (Map) r126;
        if (r127 == null) goto L101;
        Object r128 = r127.get("use_view_zero_size_invisible_3440");
    L103:
        if ((r128 instanceof Boolean) == true) goto L105;
        r128 = null;
    L105:
        Boolean r129 = (Boolean) r128;
        if (r129 == null) goto L108;
        boolean r130 = r129.booleanValue();
    L109:
        r8.f = r130;
        Object r131 = r9.get(r7);
        if ((r131 instanceof Map) == true) goto L112;
        r131 = null;
    L112:
        Map r132 = (Map) r131;
        if (r132 == null) goto L115;
        Object r133 = r132.get("use_make_up_auto_exposure_3440");
    L117:
        if ((r133 instanceof Boolean) == true) goto L119;
        r133 = null;
    L119:
        Boolean r134 = (Boolean) r133;
        if (r134 == null) goto L122;
        boolean r135 = r134.booleanValue();
    L123:
        r8.g = r135;
        Object r136 = r9.get(r7);
        if ((r136 instanceof Map) == true) goto L126;
        r136 = null;
    L126:
        Map r137 = (Map) r136;
        if (r137 == null) goto L129;
        Object r138 = r137.get("use_group_exposure_3440");
    L131:
        if ((r138 instanceof Boolean) == true) goto L133;
        r138 = null;
    L133:
        Boolean r139 = (Boolean) r138;
        if (r139 == null) goto L136;
        r119 = r139.booleanValue();
    L136:
        r8.h = r119;
        Object r140 = r9.get(r7);
        if ((r140 instanceof Map) == true) goto L139;
        r140 = null;
    L139:
        Map r141 = (Map) r140;
        if (r141 == null) goto L142;
        Object r142 = r141.get("use_collect_dispatch_chain_3740");
    L144:
        if ((r142 instanceof Boolean) == true) goto L146;
        r142 = null;
    L146:
        Boolean r143 = (Boolean) r142;
        if (r143 == null) goto L149;
        r143.booleanValue();
    L149:
        Object r144 = r9.get(r7);
        if ((r144 instanceof Map) == true) goto L152;
        r144 = null;
    L152:
        Map r145 = (Map) r144;
        if (r145 == null) goto L155;
        Object r146 = r145.get("enable_kmp_slice_expr_3850");
    L157:
        if ((r146 instanceof Boolean) == true) goto L159;
        r146 = null;
    L159:
        Boolean r147 = (Boolean) r146;
        if (r147 == null) goto L162;
        boolean r148 = r147.booleanValue();
    L163:
        r8.j = r148;
        Object r25 = r9.get(r7);
        if ((r25 instanceof Map) == true) goto L166;
        r25 = null;
    L166:
        Map r26 = (Map) r25;
        if (r26 == null) goto L169;
        Object r27 = r26.get("fix_recycler_view_render_callback_3860");
    L171:
        if ((r27 instanceof Boolean) == true) goto L173;
        r27 = null;
    L173:
        Boolean r28 = (Boolean) r27;
        if (r28 == null) goto L176;
        boolean r29 = r28.booleanValue();
    L177:
        r8.k = r29;
        Object r30 = r9.get("sdk");
        if ((r30 instanceof Map) == true) goto L180;
        r30 = null;
    L180:
        Map r31 = (Map) r30;
        if (r31 == null) goto L183;
        Object r32 = r31.get("use_deep_event_fields_expr");
    L185:
        if ((r32 instanceof Boolean) == false) goto L188;
        r2 = r32;
    L188:
        Boolean r33 = (Boolean) r2;
        if (r33 == null) goto L191;
        r5 = r33.booleanValue();
    L191:
        r8.i = r5;
        return;
    L183:
        r32 = null;
        goto L185
    L176:
        r29 = true;
        goto L177
    L169:
        r27 = null;
        goto L171
    L162:
        r148 = true;
        goto L163
    L155:
        r146 = null;
        goto L157
    L142:
        r142 = null;
        goto L144
    L129:
        r138 = null;
        goto L131
    L122:
        r135 = true;
        goto L123
    L115:
        r133 = null;
        goto L117
    L108:
        r130 = false;
        goto L109
    L101:
        r128 = null;
        goto L103
    L91:
        r124 = true;
        goto L92
    L84:
        r122 = null;
    L94:
        r125 = false;
        goto L95
    L75:
        r118 = true;
        goto L76
    L68:
        r116 = null;
        goto L70
    L55:
        r112 = null;
        goto L57
    L42:
        r23 = null;
        goto L44
    L35:
        r20 = true;
        goto L36
    L28:
        r17 = true;
        goto L29
    L21:
        r14 = true;
        goto L22
    L14:
        r6 = true;
        goto L15
    }
}
