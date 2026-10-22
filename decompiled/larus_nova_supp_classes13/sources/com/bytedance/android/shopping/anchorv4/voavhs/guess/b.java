package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardRecommendReasonStruct;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ AnchorV4GuessProductVH a;

    public b(AnchorV4GuessProductVH r1) {
        this.a = r1;
    }

    public final void a(String r14, Map<Object, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r14, "eventName");
        Intrinsics.checkNotNullParameter(r15, "params");
        int r0 = ECSdk.a;
        IEntranceInfoService r1 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        String r2 = null;
        if (r1 == null) goto L12;
        EntranceInfoScene r3 = new EntranceInfoScene("productDetail", "enterGoodsRecommendTrackClick");
        LinkedTreeMap<String, Object> r4 = this.a.p.b();
        if (r4 == null) goto L7;
        Object r5 = r4.get("entrance_info");
    L9:
        if ((r5 instanceof String) == true) goto L11;
        r5 = null;
    L11:
        gl.a r6 = r1.initEntranceInfo(r3, (String) r5);
    L13:
        if (r6 == null) goto L15;
        r6.delete(new String[]{"creative_id", "is_other_channel", "log_extra"});
    L15:
        h r7 = this.a.p;
        Pair[] r8 = new Pair[12];
        int r9 = 0;
        r8[0] = TuplesKt.to("module_label", "guess_you_like_product");
        ItemCardProductStruct r10 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r10 == null) goto L18;
        String r11 = r10.getRecommendInfo();
    L19:
        r8[1] = TuplesKt.to("recommend_info", r11);
        r8[2] = TuplesKt.to("request_id", AnchorV4GuessProductVH.g4(this.a).getRequestId());
        ItemCardProductStruct r12 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r12 == null) goto L24;
        ItemCardProductStruct.ProductExtra r13 = r12.getExtra();
        if (r13 == null) goto L24;
        Integer r16 = Integer.valueOf(r13.getInsurance_commodity_flag());
    L25:
        r8[3] = TuplesKt.to("insurance_commodity_flag", r16);
        ItemCardProductStruct r17 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r17 == null) goto L30;
        ItemCardProductStruct.ProductExtra r18 = r17.getExtra();
        if (r18 == null) goto L30;
        Integer r19 = r18.isWhiteBase();
    L31:
        r8[4] = TuplesKt.to("is_white_base", r19);
        ItemCardProductStruct r20 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r20 == null) goto L34;
        String r21 = r20.getProductId();
    L35:
        r8[5] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r21);
        r8[6] = TuplesKt.to("ecom_entrance_form", "guess_you_like");
        CommonMeta r22 = this.a.p.a();
        if (r22 == null) goto L38;
        String r23 = r22.getButtonStatus();
    L39:
        r8[7] = TuplesKt.to("pd_button_status", r23);
        ItemCardProductStruct r24 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r24 == null) goto L44;
        ItemCardRecommendReasonStruct r25 = r24.getRecommendReason();
        if (r25 == null) goto L44;
        Integer r26 = r25.getReasonType();
    L45:
        if (r26 != null) goto L48;
    L50:
        String r27 = null;
    L51:
        r8[8] = TuplesKt.to("reason_type", r27);
        CommonMeta r28 = this.a.p.a();
        if (r28 != null) goto L54;
    L56:
        r8[9] = TuplesKt.to("show_type", Integer.valueOf(r9));
        ECUrlModel r29 = AnchorV4GuessProductVH.g4(this.a).f();
        if (r29 == null) goto L59;
        String r30 = r29.getUri();
    L60:
        r8[10] = TuplesKt.to("uri", r30);
        r8[11] = TuplesKt.to("is_smart_pic", AnchorV4GuessProductVH.g4(this.a).h());
        Map r31 = MapsKt.mutableMapOf(r8);
        if (r6 == null) goto L63;
        String r32 = r6.h();
    L65:
        if (com.bytedance.android.shopping.anchorv3.a.b(r32) == false) goto L69;
        if (r6 == null) goto L68;
        r2 = r6.h();
    L68:
        r31.put("entrance_info", r2);
    L69:
        AnchorV4GuessBaseVH.d4(AnchorV4GuessProductVH.g4(this.a).a(), Integer.valueOf(AnchorV4GuessProductVH.g4(this.a).b), r31);
        ArrayList r33 = new ArrayList(r15.size());
        Iterator r110 = ((LinkedHashMap) r15).entrySet().iterator();
    L71:
        if (r110.hasNext() == false) goto L73;
        Map.Entry r34 = (Map.Entry) r110.next();
        r33.add(TuplesKt.to(r34.getKey().toString(), r34.getValue()));
        goto L71
    L73:
        MapsKt.putAll(r31, r33);
        Unit r111 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r7, r14, r31, false, null, null, null, null, 252);
        return;
    L63:
        r32 = null;
        goto L65
    L59:
        r30 = null;
        goto L60
    L54:
        if (r28.isHeadViewScrollToGUL() != true) goto L56;
        r9 = 1;
        goto L56
    L48:
        if (r26.intValue() != 4) goto L50;
        r27 = "product_ranking";
    L44:
        r26 = null;
        goto L45
    L38:
        r23 = null;
        goto L39
    L34:
        r21 = null;
    L30:
        r19 = null;
    L24:
        r16 = null;
        goto L25
    L18:
        r11 = null;
        goto L19
    L7:
        r5 = null;
        goto L9
    L12:
        r6 = null;
        goto L13
    }
}
