package com.larus.suggest.impl.popup.model;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.suggest.api.NexPulseDialogRequestScene;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class PopWindowRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PopWindowRepo f369887a = null;

    static {
        f369887a = new PopWindowRepo();
    }

    public PopWindowRepo() {
    }

    public static Object c(PopWindowCommonBizRequest r110, Continuation r111) {
        FLogger.f375446a.i("NexPulsePopWindowRepo", "sendCommonRequest bizReqId=" + r110.getBizReqId());
        PopWindowApi.a r100 = PopWindowApi.f369885a;
        PopWindowRepo$sendCommonRequest$2 r101 = new PopWindowRepo$sendCommonRequest$2(r110, null);
        r100.getClass();
        FlowHttpConnection r112 = FlowHttpConnection.f359975a;
        return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, PopWindowApi.class, r101, true, null, null, null, r111, 240);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(NexPulseDialogRequestScene r110, Continuation<? super GetPopWindowListData> r111) {
        if ((r111 instanceof PopWindowRepo$getPopWindow$1) == false) goto L7;
        PopWindowRepo$getPopWindow$1 r100 = (PopWindowRepo$getPopWindow$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PopWindowRepo$getPopWindow$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (NexPulseDialogRequestScene) r112.L$0;
        ResultKt.throwOnFailure(r113);
    L20:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;
        if ((r114 instanceof y) == false) goto L29;
        y r104 = (y) r114;
        Long r105 = r104.f360205g;
        if (r105 == null) goto L29;
        if (r105.longValue() != 0) goto L29;
        GetPopWindowListData r115 = (GetPopWindowListData) r104.f360135b;
        FLogger.f375446a.i("NexPulsePopWindowRepo", "getPopWindow success requestScene=" + r110 + ' ' + r115);
        return r115;
    L29:
        FLogger.f375446a.e("NexPulsePopWindowRepo", "getPopWindow failed requestScene=" + r110 + ' ' + r114);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        FLogger.f375446a.i("NexPulsePopWindowRepo", "getPopWindow requestScene=" + r110);
        PopWindowApi.a r116 = PopWindowApi.f369885a;
        r112.L$0 = r110;
        r112.label = 1;
        r116.getClass();
        JSONObject r106 = new JSONObject();
        if (r110 != NexPulseDialogRequestScene.PC_GUIDE_SCHEMA) goto L17;
        r106.put("scene", 3);
        r106.put("ug_campaign_info", new JSONObject().put("campaign_type", 1).put("campaign_source", "pc_guide_activity"));
    L17:
        r113 = IFlowDowngradeService.a.b(FlowDowngradeServiceDelegate.INSTANCE, ServiceType.UGC, GetPopWindowListData.class, "/biz/activity/get_pop_window", r106, null, false, null, MapsKt.mapOf(TuplesKt.to("source", DowngradeSource.COLD_LAUNCH.getValue())), r112, 1008);
        if (r113 != r102) goto L20;
        return r102;
    L7:
        r100 = new PopWindowRepo$getPopWindow$1(this, r111);
        goto L8
    }

    public final Object b(b r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof PopWindowRepo$reportShow$1) == false) goto L7;
        PopWindowRepo$reportShow$1 r100 = (PopWindowRepo$reportShow$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PopWindowRepo$reportShow$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L17:
        dm9.a r113 = (dm9.a) r112;
        if ((r113 instanceof dm9.a.b) == false) goto L24;
        dm9.a.b r114 = (dm9.a.b) r113;
        if (r114.f469231a.isSuccess() == false) goto L22;
        FLogger.f375446a.i("NexPulsePopWindowRepo", "report show success " + r114.f469231a.getData());
    L27:
        return Unit.INSTANCE;
    L22:
        FLogger.f375446a.e("NexPulsePopWindowRepo", "report show failed, code " + r114.f469231a.getCode() + " message " + r114.f469231a.getMsg());
        goto L27
    L24:
        if ((r113 instanceof dm9.a.C5690a) == false) goto L27;
        FLogger.f375446a.e("NexPulsePopWindowRepo", "report show failed " + r113);
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        FLogger.f375446a.i("NexPulsePopWindowRepo", "reportShow " + r110);
        PopWindowApi.a r115 = PopWindowApi.f369885a;
        PopWindowRepo$reportShow$result$1 r105 = new PopWindowRepo$reportShow$result$1(r110, null);
        r102.label = 1;
        r115.getClass();
        FlowHttpConnection r116 = FlowHttpConnection.f359975a;
        r112 = FlowHttpConnection.g(ServiceType.IM, PopWindowApi.class, r105, false, null, null, null, r102, 248);
        if (r112 != r103) goto L17;
        return r103;
    L7:
        r100 = new PopWindowRepo$reportShow$1(this, r111);
        goto L8
    }
}
