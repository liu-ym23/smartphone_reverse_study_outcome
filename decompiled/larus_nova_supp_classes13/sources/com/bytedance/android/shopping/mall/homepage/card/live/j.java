package com.bytedance.android.shopping.mall.homepage.card.live;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.hybrid.tools.MallFeedAndLiveAnimExtension;
import com.bytedance.android.ec.hybrid.tools.TransitionAnimationHelper;
import com.bytedance.android.ec.hybrid.ui.ECMediaType;
import com.bytedance.android.ec.hybrid.ui.IHybridLiveBoxView;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.android.shopping.mall.homepage.jsb.q;
import com.bytedance.android.shopping.mall.homepage.tools.LastActionRecorderKt;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ NativeLiveCard a;
    public final /* synthetic */ View b;
    public final /* synthetic */ String c;

    public j(NativeLiveCard r1, View r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        int r12 = q.a;
        NativeLiveCard r13 = this.a;
        String r0 = r13.r;
        LiveCardData r14 = r13.u;
        if (r14 == null) goto L7;
        LiveCardData.Live r15 = r14.getLive();
        if (r15 == null) goto L7;
        String r16 = r15.getRoomId();
    L8:
        ECHybridListItemVO r2 = ((BaseViewHolder) this.a).c;
        if (r2 == null) goto L11;
        String r3 = r2.d;
    L12:
        q.a(r0, r16, r3);
        a.e(this.a, false, System.currentTimeMillis() - this.a.V1);
        LiveCardData r17 = this.a.u;
        if (r17 == null) goto L16;
        String r18 = r17.getBtmCD();
        if (r18 == null) goto L16;
    L17:
        String r19 = r18 + "_i" + (ToolsKt.g(this.a) + 1);
        o.d(this.a, false, r19);
        NativeLiveCard r4 = this.a;
        if (r4.P1 == false) goto L20;
        o.a(r4, r4.u, null, 6);
    L20:
        NativeLiveCard r5 = this.a;
        LiveCardData r6 = r5.u;
        if (r6 == null) goto L25;
        CommonData.Extra r7 = r6.getExtra();
        if (r7 == null) goto L25;
        Map<String, Object> r8 = r7.getBcm();
    L26:
        Intrinsics.checkNotNullParameter(r5, "$this$reportMarketingClick");
        if (r8 == null) goto L29;
        Object r9 = r8.get("bcm_em_id");
    L31:
        if ((r9 instanceof String) == true) goto L33;
        r9 = null;
    L33:
        String r10 = (String) r9;
        if (r10 != null) goto L36;
    L39:
        boolean r20 = true;
    L40:
        if (r20 == true) goto L43;
        LinkedHashMap r21 = new LinkedHashMap();
        r21.putAll(r8);
        r21.put("card_type", "直播间");
        ToolsKt.x(r5, "marketing_click", r19, r21, com.bytedance.android.ec.hybrid.list.util.k.b(r8));
    L43:
        String r22 = this.a.Q4();
        JsonObject r23 = new JsonObject();
        Lazy r24 = HybridAppInfoService.a;
        if (HybridAppInfoService.n() == false) goto L46;
    L49:
        String r25 = "order_center";
    L50:
        r23.addProperty(SimilarProductParam.ENTER_FROM, r25);
        r23.toString();
        com.bytedance.android.shopping.api.mall.common.tools.h.b.getIHybridHostECSchemaMonitorService();
        if (BtmSDK.INSTANCE.useV2Api() == false) goto L115;
        Map r26 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "live")});
        LiveCardData r27 = this.a.u;
        if (r27 == null) goto L59;
        CommonData.Extra r28 = r27.getExtra();
        if (r28 == null) goto L59;
        Map<String, Object> r29 = r28.getBcm();
        if (r29 == null) goto L59;
        Object r30 = r29.get("bcm_em_id");
    L61:
        if ((r30 instanceof String) == true) goto L63;
        r30 = null;
    L63:
        String r31 = (String) r30;
        if (r31 != null) goto L66;
    L69:
        boolean r32 = true;
    L70:
        if (r32 == true) goto L72;
        r26.put("bcm_em_id", r31);
    L72:
        LiveCardData r33 = this.a.u;
        if (r33 == null) goto L79;
        CommonData.Extra r34 = r33.getExtra();
        if (r34 == null) goto L79;
        Map<String, Object> r35 = r34.getBcm();
        if (r35 == null) goto L79;
        Object r36 = r35.get("bcm_em");
    L81:
        if ((r36 instanceof String) == true) goto L83;
        r36 = null;
    L83:
        String r37 = (String) r36;
        if (r37 != null) goto L86;
    L89:
        boolean r38 = true;
    L90:
        if (r38 == true) goto L92;
        r26.put("bcm_em", r37);
    L92:
        LiveCardData r39 = this.a.u;
        if (r39 == null) goto L97;
        LiveCardData.Live r40 = r39.getLive();
        if (r40 == null) goto L97;
        String r41 = r40.getRoomId();
    L99:
        if (TextUtils.isEmpty(r41) == true) goto L107;
        LiveCardData r42 = this.a.u;
        if (r42 == null) goto L105;
        LiveCardData.Live r43 = r42.getLive();
        if (r43 == null) goto L105;
        String r44 = r43.getRoomId();
    L106:
        r26.put("room_id", r44);
    L105:
        r44 = null;
    L107:
        ECHybridListItemVO r45 = ((BaseViewHolder) this.a).c;
        if (r45 == null) goto L114;
        ECNAMallCardExtra r46 = r45.c();
        if (r46 == null) goto L114;
        Map r47 = r46.getBcmData();
        if (r47 == null) goto L114;
        r26.putAll(r47);
    L114:
        int r48 = com.bytedance.android.shopping.api.mall.common.tools.b.a;
        r22 = com.bytedance.android.shopping.api.mall.common.tools.b.a(r22, MapsKt.mapOf(new Pair[]{TuplesKt.to("btm", r19), TuplesKt.to("bcm", r26)}), PageFinder.via(this.b), this.b.getContext(), false);
    L116:
        final NativeLiveCard r110 = this.a;
        Pair[] r49 = new Pair[3];
        LiveCardData r50 = r110.u;
        if (r50 == null) goto L119;
        Object r51 = r50.carryRCInfoWindVaneParams();
    L120:
        r49[0] = TuplesKt.to("wind_vane_params", r51);
        r49[1] = TuplesKt.to("index", Integer.valueOf(ToolsKt.g(r110)));
        r49[2] = TuplesKt.to("section_index", Integer.valueOf(ToolsKt.q(r110)));
        final Map r52 = MapsKt.mutableMapOf(r49);
        LiveCardData r53 = r110.u;
        if (r53 == null) goto L133;
        CommonData.WindVaneEventData r54 = r53.getWindVaneData();
        if (r54 == null) goto L133;
        String r55 = r54.getWindVaneSchema();
        if (r55 == null) goto L133;
        if (com.bytedance.forest.utils.h.a(r55) != true) goto L133;
        Gson r56 = p.a;
        LiveCardData r57 = r110.u;
        if (r57 == null) goto L131;
        CommonData.WindVaneEventData r58 = r57.getWindVaneData();
    L132:
        r52.put("wind_vane_data", p.c(r58));
        goto L133
    L131:
        r58 = null;
    L133:
        LiveCardData r59 = r110.u;
        if (r59 == null) goto L136;
        Boolean r60 = r59.getDisableVane();
    L138:
        if ((!Intrinsics.areEqual(r60, Boolean.TRUE)) == false) goto L140;
        LastActionRecorderKt.a(r110, true, new NativeLiveCard$recordActionAndSendQueryRecommend$1(r110, r52));
    L141:
        Lazy r111 = MallFeedAndLiveAnimExtension.a;
        NativeLiveCard r112 = this.a;
        if (r112.Q1 != null) goto L144;
    L146:
        Function0<Boolean> r113 = r112.X2;
        if (r113 != null) goto L149;
    L151:
        boolean r114 = false;
    L153:
        if (((Number) this.a.M2.getValue()).intValue() > 0) goto L155;
    L213:
        ((Number) this.a.M2.getValue()).intValue();
        NativeLiveCard r115 = this.a;
        IHybridLiveBoxView r61 = r115.Q1;
        if (r61 != null) goto L216;
    L218:
        ((Number) r115.M2.getValue()).intValue();
        com.bytedance.android.shopping.api.mall.common.tools.k.b.d(this.b.getContext(), r22, null);
    L219:
        ToolsKt.v(this.a, r22, "go_live_inner");
        String r116 = this.c;
        if (r116 == null) goto L223;
        Intrinsics.checkNotNullParameter(this.a, "$this$onPageOpenSchema");
        Intrinsics.checkNotNullParameter(r116, "pageName");
        Intrinsics.checkNotNullParameter("go_live_inner", "scene");
        return;
    L223:
        return;
    L216:
        if (r115.Q2 == false) goto L218;
        r61.enterDetail(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("schema", r22)}));
        goto L219
    L155:
        if (((String) this.a.O2.getValue()).length() <= 0) goto L157;
        boolean r62 = true;
    L158:
        if (r62 == false) goto L213;
        String r63 = this.c;
        if (r63 != null) goto L162;
    L165:
        boolean r64 = true;
    L166:
        if (r64 == true) goto L213;
        if (StringsKt.contains$default((String) this.a.O2.getValue(), this.c, false, 2, null) == false) goto L213;
        if (r114 == true) goto L213;
        Lazy r117 = TransitionAnimationHelper.a;
        TransitionAnimationHelper.d(this.a.P4(), "live");
        TransitionAnimationHelper.b(ECMediaType.LIVE.getType(), false);
        LiveCardModel r118 = this.a.T1;
        if (r118 == null) goto L175;
        LiveCardModel.Live r119 = r118.getLive();
        if (r119 == null) goto L175;
        String r120 = r119.getCover();
    L176:
        LiveCardData r65 = this.a.u;
        if (r65 == null) goto L185;
        LiveCardData.Live r66 = r65.getLive();
        if (r66 == null) goto L185;
        LiveCardData.Live.Cover r67 = r66.getCover();
        if (r67 == null) goto L185;
        Integer r68 = r67.getWidth();
        if (r68 == null) goto L185;
        r68.intValue();
    L185:
        LiveCardData r69 = this.a.u;
        if (r69 == null) goto L195;
        LiveCardData.Live r70 = r69.getLive();
        if (r70 == null) goto L195;
        LiveCardData.Live.Cover r71 = r70.getCover();
        if (r71 == null) goto L195;
        Integer r72 = r71.getHeight();
        if (r72 == null) goto L195;
        r72.intValue();
    L195:
        if (this.a.H4() == false) goto L207;
        LiveCardData r121 = this.a.u;
        if (r121 == null) goto L205;
        CommonData.Product r122 = r121.getProduct();
        if (r122 == null) goto L205;
        CommonData.UrlStruct r123 = r122.getCover();
        if (r123 == null) goto L205;
        List<String> r124 = r123.getUrlList();
        if (r124 == null) goto L205;
        r120 = (String) CollectionsKt.getOrNull(r124, 0);
    L206:
        float r73 = this.a.I2;
    L205:
        r120 = null;
    L207:
        ConstraintLayout r74 = this.a.P4();
        if (r120 != null) goto L210;
        r120 = "";
    L210:
        Intrinsics.checkNotNullParameter(r74, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r120, "coverUrl");
        Rect r125 = new Rect();
        if (r74.getGlobalVisibleRect(r125) == false) goto L213;
        r125.width();
        r125.height();
    L175:
        r120 = null;
        goto L176
    L162:
        if (r63.length() == 0) goto L165;
        r64 = false;
        goto L166
    L157:
        r62 = false;
        goto L158
    L149:
        if (((Boolean) r113.invoke()).booleanValue() != true) goto L151;
        r114 = true;
        goto L153
    L144:
        if (r112.Q2 == false) goto L146;
        r112.E2 = true;
        goto L146
    L140:
        LastActionRecorderKt.a(r110, false, null);
        goto L141
    L136:
        r60 = null;
        goto L138
    L119:
        r51 = null;
    L97:
        r41 = null;
        goto L99
    L86:
        if (r37.length() == 0) goto L89;
        r38 = false;
    L79:
        r36 = null;
        goto L81
    L66:
        if (r31.length() == 0) goto L69;
        r32 = false;
    L59:
        r30 = null;
        goto L61
    L115:
        ToolsKt.z(this.a, this.b, r19, new JSONObject().put("type", "live"));
        goto L116
    L46:
        if (Intrinsics.areEqual(ToolsKt.k(this.a).get(PdpOpenThirdParam.KEY_PAGE_NAME), "order_homepage") == true) goto L49;
        r25 = MallPageName.X_TAB_MALL;
        goto L50
    L36:
        if (r10.length() == 0) goto L39;
        r20 = false;
        goto L40
    L29:
        r9 = null;
    L25:
        r8 = null;
    L16:
        r18 = "c9582.d6936";
        goto L17
    L11:
        r3 = null;
    L7:
        r16 = null;
        goto L8
    }
}
