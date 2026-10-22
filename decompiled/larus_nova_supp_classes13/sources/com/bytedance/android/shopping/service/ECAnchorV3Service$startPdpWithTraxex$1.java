package com.bytedance.android.shopping.service;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.anchorv3.utils.x;
import com.bytedance.android.shopping.anchorv4.containers.j;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4Repository;
import com.bytedance.android.shopping.anchorv4.data.j0;
import com.bytedance.android.shopping.anchorv4.data.k;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.helper.t;
import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "activity", "Landroid/app/Activity;", "extraMessage", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECAnchorV3Service$startPdpWithTraxex$1 extends Lambda implements Function2<Activity, String, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $fullMode;
    final /* synthetic */ List $respList;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ JSONObject $uiParamJson;

    public ECAnchorV3Service$startPdpWithTraxex$1(String r1, List r2, Context r3, JSONObject r4, boolean r5) {
        this.$sessionId = r1;
        this.$respList = r2;
        this.$context = r3;
        this.$uiParamJson = r4;
        this.$fullMode = r5;
        super(2);
    }

    public final void invoke(Activity r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "activity");
        Intrinsics.checkNotNullParameter(r112, "extraMessage");
        k r0 = AnchorV4DataManager.a;
        String r1 = this.$sessionId;
        List r3 = this.$respList;
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        AnchorV4DataManager.d = r1;
        AnchorV4Repository r2 = AnchorV4DataManager.m(r1);
        int r6 = 0;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L37
        if (r3 == null) goto L34;
        List r4 = r3;     // Catch: Throwable -> L37
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Throwable -> L37
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L37
    L7:
        if (r5.hasNext() == false) goto L9;
        r9.add((PackResponseDTO) u0.b((String) r5.next(), PackResponseDTO.class));     // Catch: Throwable -> L37
        goto L7
    L9:
        List r7 = CollectionsKt.sortedWith(r9, j0.a);     // Catch: Throwable -> L37
        if (r7 == null) goto L34;
        PackResponseDTO r10 = (PackResponseDTO) CollectionsKt.getOrNull(r7, 0);     // Catch: Throwable -> L37
        if (r10 == null) goto L32;
        PackResponseDTO r11 = (PackResponseDTO) CollectionsKt.getOrNull(r7, 1);     // Catch: Throwable -> L37
        if (r11 == null) goto L31;
        PackParsedDTO r12 = r10.getParsedDTO();     // Catch: Throwable -> L37
        if (r12 == null) goto L18;
        List r13 = r12.getComponents();     // Catch: Throwable -> L37
    L19:
        PackParsedDTO r14 = r11.getParsedDTO();     // Catch: Throwable -> L37
        if (r14 == null) goto L31;
        List r15 = r14.getComponents();     // Catch: Throwable -> L37
        if (r15 == null) goto L31;
        PackParsedDTO r16 = r10.getParsedDTO();     // Catch: Throwable -> L37
        if (r16 == null) goto L31;
        if (r13 == null) goto L29;
        List r17 = CollectionsKt.toMutableList(r13);     // Catch: Throwable -> L37
        if (r17 == null) goto L29;
        r17.addAll(r15);     // Catch: Throwable -> L37
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L30:
        r16.setComponents(r17);     // Catch: Throwable -> L37
    L29:
        r17 = null;
        goto L30
    L18:
        r13 = null;
    L31:
        r10.markAsTraxex();     // Catch: Throwable -> L37
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L33:
        r2.b = r10;     // Catch: Throwable -> L37
    L35:
        Object r20 = Result.constructor-impl(r7);     // Catch: Throwable -> L37
    L39:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L42;
        ECExceptionMonitor.e(r21);
    L42:
        u r22 = new u(0);
        Map r23 = com.bytedance.android.ec.core.monitor.k.a;
        com.bytedance.android.ec.monitor.duration.d r24 = com.bytedance.android.ec.core.monitor.k.a();
        if (r24 == null) goto L45;
        r22.d = new com.bytedance.android.shopping.anchorv4.perf.monitor.c(r24);
    L45:
        LinkedHashMap r25 = t.a;
        String r26 = this.$sessionId;
        Intrinsics.checkNotNullParameter(r26, "sessionId");
        Intrinsics.checkNotNullParameter(r22, "dataHolder");
        t.a.put(r26, r22);
        CopyOnWriteArrayList<Function2<String, Float, Unit>> r27 = ECAnchorV3Service.a;
        Context r28 = this.$context;
        JSONObject r29 = this.$uiParamJson;
        if (r29 != null) goto L48;
        V4NativeParams r30 = new V4NativeParams(true, false, false, null, null, null, null, null, null, false, null, null, null, null, null, null, null, x.a(r28), x.c(r28), false, null, null, false, null, null, null, false, 0, null, null, null, null, null, null, r.a.getCurrentUserId(), null, 0, null, null, null, null, null, null, null, null, null, false, -393218, 32763, null);
    L88:
        if (this.$fullMode == false) goto L90;
        int r31 = j.a;
        AnchorV4Param.a r32 = AnchorV4Param.Companion;
        String r33 = this.$sessionId;
        r32.getClass();
        j.a(r111, AnchorV4Param.a.a(r33, r30));
        return;
    L90:
        int r34 = j.a;
        AnchorV4Param.a r35 = AnchorV4Param.Companion;
        String r36 = this.$sessionId;
        r35.getClass();
        j.b(r111, AnchorV4Param.a.a(r36, r30), null, null);
        return;
    L48:
        boolean r60 = r29.optBoolean("full_mode", true);
        boolean r61 = r29.optBoolean("from_live", false);
        boolean r37 = r29.optBoolean("from_live", false);
        String r110 = r29.optString("ecom_entrance_form");
        JSONObject r113 = z1.g(r29.optString("entrance_info"));
        if (r37 == true) goto L51;
    L58:
        boolean r62 = false;
    L59:
        String r63 = r29.optString(PdpOpenThirdParam.KEY_PRODUCT_ID);
        String r72 = r29.optString("live_hot_sale_component");
        String r67 = r29.optString("live_room_id");
        String r68 = r29.optString("v3_events_additions");
        String r80 = r29.optString("cover_img");
        JSONObject r38 = z1.g(r29.optString("entrance_info"));
        if (r38 == null) goto L62;
        String r39 = r38.optString("module_label");
    L63:
        String r114 = r29.optString(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        if (Intrinsics.areEqual(r39, "guess_you_like_product") == true) goto L66;
    L68:
        String r70 = r114;
    L69:
        String r71 = r29.optString("ecom_entrance_form");
        WireFrameSchemaInfo r85 = (WireFrameSchemaInfo) p83.a.a(r29.optString("product_pre_info"), WireFrameSchemaInfo.class);
        int r87 = r29.optInt("show_sku_panel", 0);
        JSONObject r40 = z1.g(r29.optString("entrance_info"));
        if (r40 == null) goto L72;
        String r41 = r40.optString("module_label");
    L73:
        String r42 = r29.optString(PdpOpenThirdParam.KEY_SOURCE_PAGE);
        if (Intrinsics.areEqual(r41, "guess_you_like_product") == true) goto L76;
    L78:
        boolean r79 = false;
    L79:
        Map r77 = x.a(r28);
        Map r78 = x.c(r28);
        String r94 = r.a.getCurrentUserId();
        Integer r102 = Integer.valueOf(r29.optInt("height_percent"));
        String r98 = r29.optString("source_btm_token");
        JSONObject r43 = z1.g(r29.optString("request_additions"));
        if (r43 == null) goto L82;
        String r105 = r43.optString("pdp_event_transparent_id", "");
    L83:
        JSONObject r44 = z1.g(r29.optString("request_additions"));
        if (r44 == null) goto L86;
        r6 = r44.optInt("toutiao_app_id", 0);
    L86:
        r30 = new V4NativeParams(r60, r61, r62, r63, null, null, null, r67, r68, false, r70, r71, r72, null, null, null, null, r77, r78, r79, r80, null, false, null, null, r85, false, r87, null, null, null, null, null, null, r94, null, 0, null, r98, null, null, null, r102, null, Integer.valueOf(r6), r105, false, 73424896, 16640, null);
        goto L88
    L82:
        r105 = null;
        goto L83
    L76:
        if (Intrinsics.areEqual(r42, "product_flow_page") == false) goto L78;
        r79 = true;
        goto L79
    L72:
        r41 = null;
        goto L73
    L66:
        if (Intrinsics.areEqual(r114, "product_flow_page") == false) goto L68;
        r70 = "from_internal_feed";
        goto L69
    L62:
        r39 = null;
        goto L63
    L51:
        if (Intrinsics.areEqual(r110, "live_list_card") == false) goto L58;
        if (r113 == null) goto L54;
        String r45 = r113.optString("live_list_channel");
    L56:
        if ((!Intrinsics.areEqual(r45, "ecom_coupon_use")) == false) goto L58;
        r62 = true;
        goto L59
    L54:
        r45 = null;
        goto L56
    L32:
        r10 = null;
    L34:
        i.a.e(ECAppInfoService.e.getCurrentActivity(), "未查询到快照，请在Traxex平台选取网络请求！", true, false);     // Catch: Throwable -> L37
        r7 = Unit.INSTANCE;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Activity) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
