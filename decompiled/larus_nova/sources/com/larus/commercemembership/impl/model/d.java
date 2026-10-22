package com.larus.commercemembership.impl.model;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.http.ServiceType;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f325881a = 0;

    static {
    }

    public static Object a(String r110, Continuation r111) {
        FlowDowngradeServiceDelegate r100 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r101 = new JSONObject().put("scene", 1);
        if (r110 == null) goto L5;
        r101.put("campaign_source", r110);
    L5:
        Unit r112 = Unit.INSTANCE;
        return IFlowDowngradeService.a.b(r100, ServiceType.UGC, GetPushBannerListData.class, "/biz/activity/get_push_banner", r101, null, false, null, MapsKt.mapOf(TuplesKt.to("source", DowngradeSource.COLD_LAUNCH.getValue())), r111, 1008);
    }
}
