package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.event.ECEventUtilsV2;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ListHeaderJumpDispatcher$dispatchShopInfoDetail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.bytedance.android.btm.api.model.d $btmModel;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $jumpUrl;
    final /* synthetic */ List $liveParamsType;
    final /* synthetic */ Map $params;

    public ListHeaderJumpDispatcher$dispatchShopInfoDetail$1(String r1, Map r2, Context r3, com.bytedance.android.btm.api.model.d r4, List r5) {
        this.$jumpUrl = r1;
        this.$params = r2;
        this.$context = r3;
        this.$btmModel = r4;
        this.$liveParamsType = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m782invoke() {
        int r1 = ECSdk.a;
        IECUserTrackerService r2 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r2 == null) goto L7;
        of.a r3 = r2.getMarketingService();
        if (r3 == null) goto L7;
        r3.a("live_click_flagship_shop_entrance", PostActionType.DO, "live");
    L7:
        String r4 = this.$jumpUrl;
        if (r4 == null) goto L14;
        m0 r5 = new m0(r4);
        HashMap<String, String> r6 = l0.g();
        String r7 = l0.d();
        r5.b("store_source_page", r7);
        r5.b("store_source_method", l0.e());
        r5.b("pre_room_id", r6.get("room_id"));
        JSONObject r8 = new JSONObject();
        String r9 = l0.l();
        if (r9 == null) goto L12;
        r8.put("request_id", r9);
    L12:
        r8.put("chnid", r7);
        ECEventUtilsV2 r10 = ECEventUtilsV2.b;
        Map<String, String> r11 = ControllerExtensionsKt.c(null, (String) this.$params.get("room_id")).K();
        r10.getClass();
        r8.put("live_guide_store", ECEventUtilsV2.d(r11));
        Unit r12 = Unit.INSTANCE;
        r5.b("entrance_info", r8.toString());
        ECSdk.b(IAdapterService.class, new ListHeaderJumpDispatcher$dispatchShopInfoDetail$1$$special$$inlined$let$lambda$1(this));
        com.bytedance.android.livesdk.livecommerce.params.a.b(this.$context, ControllerExtensionsKt.c(null, (String) this.$params.get("room_id")).B(), ControllerExtensionsKt.c(null, (String) this.$params.get("room_id")).D(), BtmUtilsKt.b(r5.c(), this.$btmModel), null, false, this.$liveParamsType, null, null, null, 896);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m782invoke();
        return Unit.INSTANCE;
    }
}
