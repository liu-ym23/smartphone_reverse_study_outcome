package com.bytedance.ee.bear.bitable.statistic.business.openfile.main;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.common.l;
import com.bytedance.ee.bear.bitable.load.d;
import com.bytedance.ee.bear.bitable.load.webview.BitableInterceptDocumentWeb;
import com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import tu4.e;
import tu4.f;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements f {
    public c() {
    }

    @Override // tu4.f
    public final j a() {
        return new a();
    }

    public static void c(e r14, BitableReportPlugin.ReportModel r16) {
        String r17 = r14.e();
        if (r17 == null) goto L46;
        JSONObject r0 = r16.getExtra();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getString("viewType");
    L8:
        JSONObject r3 = r16.getExtra();
        if (r3 == null) goto L11;
        String r4 = r3.getString("blockType");
    L12:
        JSONObject r5 = r16.getExtra();
        if (r5 == null) goto L15;
        String r6 = r5.getString("renderType");
    L16:
        JSONObject r7 = r16.getExtra();
        if (r7 == null) goto L19;
        Boolean r8 = r7.getBoolean("isFormV2");
    L20:
        JSONObject r9 = r16.getExtra();
        if (r9 == null) goto L23;
        String r10 = r9.getString("subViewType");
    L24:
        JSONObject r11 = r16.getExtra();
        if (r11 == null) goto L27;
        String r12 = r11.getString("viewTypeV2");
    L28:
        JSONObject r13 = r16.getExtra();
        if (r13 == null) goto L31;
        String r18 = r13.getString("subViewTypeV2");
    L32:
        JSONObject r19 = r16.getExtra();
        if (r19 == null) goto L35;
        String r20 = r19.getString("renderTypeV2");
    L36:
        JSONObject r110 = r16.getExtra();
        if (r110 == null) goto L39;
        r1 = r110.getString("schema_version");
    L39:
        JSONObject r111 = r16.getExtra();
        if (r111 == null) goto L43;
        String r112 = r111.getString("is_on_demand");
        if (r112 == null) goto L43;
    L44:
        Lazy r113 = b.a;
        Intrinsics.checkNotNullParameter(r17, "traceId");
        b.a(r17, "view_type", r2);
        b.a(r17, "block_type", r4);
        b.a(r17, "isFormV2", r8);
        b.a(r17, "sub_view_type", r10);
        b.a(r17, "render_type", r6);
        b.a(r17, "view_type_v2", r12);
        b.a(r17, "sub_view_type_v2", r18);
        b.a(r17, "render_type_v2", r20);
        Intrinsics.checkNotNullParameter(r17, "traceId");
        b.a(r17, "schema_version", r1);
        Intrinsics.checkNotNullParameter(r17, "traceId");
        Intrinsics.checkNotNullParameter(r112, "isOnDemand");
        b.a(r17, "is_on_demand", r112);
        return;
    L43:
        r112 = "false";
        goto L44
    L35:
        r20 = null;
        goto L36
    L31:
        r18 = null;
        goto L32
    L27:
        r12 = null;
        goto L28
    L23:
        r10 = null;
        goto L24
    L19:
        r8 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L11:
        r4 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }

    public static void d(e r3, BitableReportPlugin.ReportModel r4) {
        JSONObject r0 = r4.getExtra();
        if (r0 == null) goto L5;
        Object r1 = r0.remove("SDK_COST");
    L7:
        if (r3.d() == false) goto L9;
        return;
    L9:
        if ((r1 instanceof JSONObject) == false) goto L15;
        String r5 = r3.e();
        if (r5 == null) goto L16;
        tu4.b.m(r5, r4.getTime(), (Map) r1);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // tu4.f
    public final void b(e r19, BitableReportPlugin.ReportModel r20) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r20, "model");
        String r3 = r20.getEvent();
        boolean r6 = false;
        String r7 = null;
        if (Intrinsics.areEqual(r3, "docs_render_end") == false) goto L31;
        d(r19, r20);
        JSONObject r4 = r20.getExtra();
        if (r4 == null) goto L7;
        String r5 = r4.getString("docs_result_key");
    L8:
        JSONObject r8 = r20.getExtra();
        if (r8 == null) goto L11;
        String r9 = r8.getString("docs_result_code");
    L12:
        JSONObject r10 = r20.getExtra();
        if (r10 == null) goto L15;
        String r14 = r10.getString("clientvar_from");
    L17:
        if (Intrinsics.areEqual(r5, "other") == true) goto L19;
    L21:
        boolean r11 = false;
    L22:
        String r12 = r19.e();
        if (r12 == null) goto L38;
        if (r11 == true) goto L27;
        tu4.b.i(r12, Long.valueOf(r20.getTime()), r20.getExtra());
        goto L38
    L27:
        if (r19.d() == false) goto L29;
        b.c(r12, r20.getTime(), r14, false, 8);
        goto L38
    L29:
        Lazy r13 = b.a;
        Intrinsics.checkNotNullParameter(r12, "traceId");
        b.a(r12, "clientvar_from", r14);
    L38:
        if (r19.d() == false) goto L40;
        return;
    L40:
        String r16 = r20.getEvent();
        switch(r16.hashCode()) {
            case -1677406581: goto L142;
            case -1262924125: goto L104;
            case -283988032: goto L98;
            case -231232228: goto L66;
            case 1221684497: goto L54;
            case 1727485535: goto L48;
            case 2048947395: goto L44;
            default: goto L170;
        };
    L170:
        return;
    L44:
        if (r16.equals("BITABLE_SDK_CURRENT_LOAD_COST") == false) goto L171;
        d(r19, r20);
        return;
    L171:
        return;
    L48:
        if (r16.equals("mobile_dashboard-ttu") == false) goto L172;
        String r1 = r19.e();
        if (r1 == null) goto L153;
        Lazy r2 = b.a;
        long r17 = r20.getTime();
        Intrinsics.checkNotNullParameter(r1, "traceId");
        tu4.b.l(r1, r17, null);
        long r18 = r20.getTime();
        final JSONObject r0 = r20.getExtra();
        Intrinsics.checkNotNullParameter(r1, "traceId");
        tu4.b.k(r1, r18, new BitableOpenFileReportMainMonitor$reportOpenDashboardTTU$1(r0));
        return;
    L153:
        return;
    L172:
        return;
    L54:
        if (r16.equals("AFTER_CLIENTVARS_LOADED_AND_SWITCH") == false) goto L173;
        String r21 = r19.e();
        if (r21 == null) goto L155;
        JSONObject r22 = r20.getExtra();
        if (r22 == null) goto L61;
        r7 = r22.getString("blockType");
    L61:
        Lazy r23 = b.a;
        Intrinsics.checkNotNullParameter(r21, "traceId");
        b.a(r21, "block_type", r7);
        if (TextUtils.equals(r7, "BITABLE_TABLE") == true) goto L174;
        b.d(r21, r20.getTime());
        return;
    L174:
        return;
    L155:
        return;
    L173:
        return;
    L66:
        if (r16.equals("BITABLE_SDK_FIRST_SCREEN_SUCCESS") == false) goto L175;
        d(r19, r20);
        c(r19, r20);
        String r24 = r19.e();
        if (r24 == null) goto L71;
        long r110 = r20.getTime();
        Lazy r26 = b.a;
        Intrinsics.checkNotNullParameter(r24, "traceId");
        b.b().addNormalPoint(r24, BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_SDK_FIRST_PAINT", r110, false, 12));
    L71:
        JSONObject r27 = r20.getExtra();
        if (r27 == null) goto L74;
        String r28 = r27.getString("viewType");
    L75:
        JSONObject r29 = r20.getExtra();
        if (r29 == null) goto L78;
        String r30 = r29.getString("blockType");
    L79:
        JSONObject r31 = r20.getExtra();
        if (r31 == null) goto L82;
        String r32 = r31.getString("renderType");
    L84:
        if (TextUtils.equals(r30, "BITABLE_TABLE") == false) goto L157;
        if (r28 != null) goto L87;
        return;
    L87:
        if (l.a(r28) == false) goto L89;
        return;
    L89:
        if (TextUtils.equals(r28, "customized_view") == false) goto L91;
        return;
    L91:
        if (TextUtils.equals(r28, "card_view") == true) goto L93;
    L94:
        String r33 = r19.e();
        if (r33 == null) goto L162;
        long r34 = r20.getTime();
        Lazy r36 = b.a;
        Intrinsics.checkNotNullParameter(r33, "traceId");
        tu4.b.l(r33, r34, null);
        return;
    L162:
        return;
    L93:
        if (TextUtils.equals(r32, "native_render") == false) goto L94;
        return;
    L157:
        return;
    L82:
        r32 = null;
        goto L84
    L78:
        r30 = null;
        goto L79
    L74:
        r28 = null;
        goto L75
    L175:
        return;
    L98:
        if (r16.equals("bitable_view_or_block_switch") == false) goto L176;
        String r37 = r19.e();
        if (r37 == null) goto L164;
        long r38 = r20.getTime();
        Map<String, ? extends Object> r39 = r20.getExtra();
        Lazy r40 = b.a;
        Intrinsics.checkNotNullParameter(r37, "traceId");
        BitableStatisticEventModel$NormalPointModel r41 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "POINT_VIEW_OR_BLOCK_SWITCH", r38, false, 12);
        r41.addExtras(r39);
        b.b().addNormalPoint(r37, r41);
        return;
    L164:
        return;
    L176:
        return;
    L104:
        if (r16.equals("BITABLE_SDK_BITABLE_IS_READY") == false) goto L177;
        d(r19, r20);
        c(r19, r20);
        String r42 = r19.e();
        if (r42 == null) goto L166;
        d r43 = r19.f();
        if ((r43 instanceof d) == false) goto L126;
        d r44 = r43;
        DocumentPluginHost r46 = r44.a;
        if (r46 == null) goto L113;
        k r47 = r46.getWeb();
    L115:
        if ((r47 instanceof BitableInterceptDocumentWeb) == false) goto L117;
        ((BitableInterceptDocumentWeb) r47).r = true;
    L117:
        Lazy r48 = b.a;
        DocumentPluginHost r49 = r44.a;
        if (r49 == null) goto L120;
        k r50 = r49.getWeb();
    L122:
        if ((r50 instanceof BitableInterceptDocumentWeb) == false) goto L124;
        HashMap r51 = ((BitableInterceptDocumentWeb) r50).p;
    L125:
        Intrinsics.checkNotNullParameter(r42, "traceId");
        Intrinsics.checkNotNullParameter(r51, "handlerTimeMap");
        b.a(r42, "js_bridge_method_native_cost_json", new MapJSONObjectAdapter(r51));
        goto L126
    L124:
        r51 = new HashMap();
        goto L125
    L120:
        r50 = null;
        goto L122
    L113:
        r47 = null;
    L126:
        long r111 = r20.getTime();
        Lazy r52 = b.a;
        Intrinsics.checkNotNullParameter(r42, "traceId");
        b.b().addNormalPoint(r42, BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "BITABLE_SDK_BITABLE_IS_READY", r111, false, 12));
        Intrinsics.checkNotNullParameter(r42, "traceId");
        Intrinsics.checkNotNullParameter(r20, "model");
        JSONObject r53 = r20.getExtra();
        if (r53 == null) goto L129;
        Object r54 = r53.remove("passThroughData");
    L131:
        if ((r54 instanceof JSONObject) == false) goto L136;
        JSONObject r56 = (JSONObject) r54;
        Iterator r57 = r56.keySet().iterator();
    L134:
        if (r57.hasNext() == false) goto L136;
        String r58 = (String) r57.next();
        Lazy r59 = b.a;
        Intrinsics.checkNotNull(r58);
        b.a(r42, r58, new JSONObjectAdapter(r56.getJSONObject(r58)));
    L136:
        JSONObject r60 = r20.getExtra();
        if (r60 == null) goto L139;
        r6 = Intrinsics.areEqual(r60.getBoolean("isReportTTU"), Boolean.TRUE);
    L139:
        if (r6 == false) goto L167;
        long r61 = r20.getTime();
        Intrinsics.checkNotNullParameter(r42, "traceId");
        tu4.b.k(r42, r61, null);
        return;
    L167:
        return;
    L129:
        r54 = null;
        goto L131
    L166:
        return;
    L177:
        return;
    L142:
        if (r16.equals("ON_TABLE_LOADED_SET_VIEW") == false) goto L178;
        String r62 = r19.e();
        if (r62 == null) goto L169;
        JSONObject r63 = r20.getExtra();
        if (r63 == null) goto L149;
        r7 = r63.getString("viewType");
    L149:
        Lazy r64 = b.a;
        Intrinsics.checkNotNullParameter(r62, "traceId");
        b.a(r62, "view_type", r7);
        b.d(r62, r20.getTime());
        return;
    L169:
        return;
    L178:
        return;
    L19:
        if (Intrinsics.areEqual(r9, DiagramData$RESULT.FAIL) == false) goto L21;
        r11 = true;
        goto L22
    L15:
        r14 = null;
        goto L17
    L11:
        r9 = null;
        goto L12
    L7:
        r5 = null;
        goto L8
    L31:
        if (Intrinsics.areEqual(r3, "docs_edit_doc") == false) goto L38;
        if (r19.d() == false) goto L38;
        String r66 = r19.e();
        if (r66 == null) goto L38;
        long r67 = r20.getTime();
        Lazy r68 = b.a;
        Intrinsics.checkNotNullParameter(r66, "traceId");
        tu4.b.k(r66, r67, null);
        goto L38
    }
}
