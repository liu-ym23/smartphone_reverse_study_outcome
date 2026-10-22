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
public final class a implements com.bytedance.android.bst.api.g {
    public final /* synthetic */ AnchorV4GuessProductVH a;

    public a(AnchorV4GuessProductVH r1) {
        this.a = r1;
    }

    public final void a(String r17, Map<Object, ? extends Object> r18) {
        Intrinsics.checkNotNullParameter(r17, "eventName");
        Intrinsics.checkNotNullParameter(r18, "params");
        int r2 = ECSdk.a;
        IEntranceInfoService r3 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r3 == null) goto L12;
        EntranceInfoScene r6 = new EntranceInfoScene("productDetail", "enterGoodsRecommendTrackShow");
        LinkedTreeMap<String, Object> r7 = this.a.p.b();
        if (r7 == null) goto L7;
        Object r8 = r7.get("entrance_info");
    L9:
        if ((r8 instanceof String) == true) goto L11;
        r8 = null;
    L11:
        gl.a r4 = r3.initEntranceInfo(r6, (String) r8);
    L13:
        if (r4 == null) goto L15;
        r4.delete(new String[]{"creative_id", "is_other_channel", "log_extra"});
    L15:
        AnchorV4GuessProductVH r9 = this.a;
        h r10 = r9.p;
        int r11 = AnchorV4GuessProductVH.z;
        ItemCardProductStruct r12 = ((j63.c) r9.getItem()).d();
        if (r12 == null) goto L18;
        String r13 = r12.getProductId();
    L19:
        Pair[] r14 = new Pair[11];
        int r15 = 0;
        r14[0] = TuplesKt.to("module_label", "guess_you_like_product");
        ItemCardProductStruct r16 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r16 == null) goto L22;
        String r19 = r16.getRecommendInfo();
    L23:
        r14[1] = TuplesKt.to("recommend_info", r19);
        r14[2] = TuplesKt.to("request_id", AnchorV4GuessProductVH.g4(this.a).getRequestId());
        ItemCardProductStruct r110 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r110 == null) goto L28;
        ItemCardProductStruct.ProductExtra r111 = r110.getExtra();
        if (r111 == null) goto L28;
        Integer r112 = Integer.valueOf(r111.getInsurance_commodity_flag());
    L29:
        r14[3] = TuplesKt.to("insurance_commodity_flag", r112);
        ItemCardProductStruct r113 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r113 == null) goto L34;
        ItemCardProductStruct.ProductExtra r114 = r113.getExtra();
        if (r114 == null) goto L34;
        Integer r115 = r114.isWhiteBase();
    L35:
        r14[4] = TuplesKt.to("is_white_base", r115);
        ItemCardProductStruct r116 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r116 == null) goto L38;
        String r117 = r116.getProductId();
    L39:
        r14[5] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r117);
        r14[6] = TuplesKt.to("ecom_entrance_form", "guess_you_like");
        ItemCardProductStruct r5 = AnchorV4GuessProductVH.g4(this.a).d();
        if (r5 == null) goto L44;
        ItemCardRecommendReasonStruct r20 = r5.getRecommendReason();
        if (r20 == null) goto L44;
        Integer r21 = r20.getReasonType();
    L45:
        if (r21 != null) goto L48;
    L50:
        String r22 = null;
    L51:
        r14[7] = TuplesKt.to("reason_type", r22);
        CommonMeta r23 = this.a.p.a();
        if (r23 != null) goto L54;
    L56:
        r14[8] = TuplesKt.to("show_type", Integer.valueOf(r15));
        ECUrlModel r24 = AnchorV4GuessProductVH.g4(this.a).f();
        if (r24 == null) goto L59;
        String r25 = r24.getUri();
    L60:
        r14[9] = TuplesKt.to("uri", r25);
        r14[10] = TuplesKt.to("is_smart_pic", AnchorV4GuessProductVH.g4(this.a).h());
        Map r26 = MapsKt.mutableMapOf(r14);
        if (r4 == null) goto L63;
        String r27 = r4.h();
    L65:
        if (com.bytedance.android.shopping.anchorv3.a.b(r27) == false) goto L70;
        if (r4 == null) goto L68;
        String r28 = r4.h();
    L69:
        r26.put("entrance_info", r28);
        goto L70
    L68:
        r28 = null;
    L70:
        AnchorV4GuessBaseVH.d4(AnchorV4GuessProductVH.g4(this.a).a(), Integer.valueOf(AnchorV4GuessProductVH.g4(this.a).b), r26);
        ArrayList r29 = new ArrayList(r18.size());
        Iterator r1 = ((LinkedHashMap) r18).entrySet().iterator();
    L72:
        if (r1.hasNext() == false) goto L74;
        Map.Entry r30 = (Map.Entry) r1.next();
        r29.add(TuplesKt.to(r30.getKey().toString(), r30.getValue()));
        goto L72
    L74:
        MapsKt.putAll(r26, r29);
        Unit r31 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r10, r17, r26, true, null, null, r13, null, 180);
        return;
    L63:
        r27 = null;
        goto L65
    L59:
        r25 = null;
        goto L60
    L54:
        if (r23.isHeadViewScrollToGUL() != true) goto L56;
        r15 = 1;
        goto L56
    L48:
        if (r21.intValue() != 4) goto L50;
        r22 = "product_ranking";
    L44:
        r21 = null;
        goto L45
    L38:
        r117 = null;
    L34:
        r115 = null;
    L28:
        r112 = null;
        goto L29
    L22:
        r19 = null;
        goto L23
    L18:
        r13 = null;
        goto L19
    L7:
        r8 = null;
        goto L9
    L12:
        r4 = null;
        goto L13
    }
}
