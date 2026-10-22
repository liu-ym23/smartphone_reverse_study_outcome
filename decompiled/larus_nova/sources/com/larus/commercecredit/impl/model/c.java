package com.larus.commercecredit.impl.model;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;
import qz8.d;
import qz8.f;
import qz8.g;
import qz8.i;
import qz8.j;
import qz8.k;
import qz8.l;
import qz8.q;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f325721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f325722b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StateFlowImpl f325723c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b1 f325724d = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/commercecredit/impl/model/CommerceCreditRepo$getAllCreditInfoFromLocal$creditTasks$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/commercecredit/impl/entity/CreditTask;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends j>> {
        public a() {
        }
    }

    public c() {
    }

    static {
        f325721a = new c();
        f325722b = LazyKt.lazy(new b());
        Long r100 = null;
        StateFlowImpl r101 = j1.a(null);
        f325723c = r101;
        f325724d = e.b(r101);
        g r102 = a();
        if (r102 == null) goto L7;
        f r103 = r102.a();
        if (r103 == null) goto L7;
        r100 = r103.f();
    L7:
        r101.setValue(r100);
    }

    public static g a() {
        FLogger.f375446a.i("CommerceCreditRepo", "getCreditInfoFromLocal start");
        Keva r100 = c();
        Gson r101 = b();
        if (r100 == null) goto L5;
        String r102 = r100.getString("credit_info", "");
    L6:
        f r103 = (f) GsonProtectorUtils.fromJson(r101, r102, f.class);
        Gson r104 = b();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L13
        if (r100 == null) goto L10;
        String r106 = r100.getString("credit_tasks", "");     // Catch: Throwable -> L13
    L11:
        Object r107 = Result.m9449constructorimpl((List) r104.fromJson(r106, new a().getType()));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r107) == false) goto L18;
        r107 = null;
    L18:
        List r108 = (List) r107;
        Gson r109 = b();
        if (r100 == null) goto L21;
        String r110 = r100.getString("credit_rule", "");
    L22:
        i r111 = (i) GsonProtectorUtils.fromJson(r109, r110, i.class);
        FLogger.f375446a.i("CommerceCreditRepo", "getCreditInfoFromLocal end");
        if (r103 != null) goto L25;
        return null;
    L25:
        return new g(r103, r108, r111);
    L21:
        r110 = null;
        goto L22
    L10:
        r106 = null;
    L13:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        r102 = null;
        goto L6
    }

    public static Gson b() {
        return (Gson) f325722b.getValue();
    }

    public static Keva c() {
        return Keva.getRepo("local_commerce_credit".concat(AccountService.f365697a.getUserId()), 0);
    }

    public static void j(long r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("CommerceCreditRepo", "updateTotalCreditNum: totalCreditNum=" + r100);
        g r102 = a();
        if (r102 == null) goto L6;
        f r103 = r102.a();
        if (r103 == null) goto L6;
    L7:
        f r104 = f.a(r103, Long.valueOf(r100));
        Keva r105 = c();
        if (r105 == null) goto L10;
        r105.storeString("credit_info", GsonProtectorUtils.toJson(b(), r104));
    L10:
        f325723c.setValue(Long.valueOf(r100));
        r101.i("CommerceCreditRepo", "updateTotalCreditNum: updated successfully");
        return;
    L6:
        r103 = new f(0);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object e(boolean r110, com.larus.commercecredit.impl.utils.a r210, Continuation r211) {
        if ((r211 instanceof CommerceCreditRepo$requestAllCreditInfo$1) == false) goto L7;
        CommerceCreditRepo$requestAllCreditInfo$1 r100 = (CommerceCreditRepo$requestAllCreditInfo$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$requestAllCreditInfo$1 r111 = r100;
        Object r102 = r111.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r111.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        boolean r105 = r111.Z$0;
        Keva r106 = (Keva) r111.L$1;
        Function1 r107 = (Function1) r111.L$0;
        ResultKt.throwOnFailure(r102);
        Keva r108 = r106;
        Object r109 = r102;
        boolean r112 = r105;
    L18:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r109;
        r107.invoke(r113);
        g r114 = (g) r113.f360135b;
        if (r114 == null) goto L36;
        if (r108 == null) goto L22;
        r108.storeString("credit_info", GsonProtectorUtils.toJson(b(), r114.a()));
    L22:
        Long r115 = null;
        if (r112 == false) goto L32;
        if (r108 == null) goto L26;
        r108.storeString("credit_rule", GsonProtectorUtils.toJson(b(), r114.b()));
    L26:
        if (r108 == null) goto L32;
        Gson r116 = b();
        List<j> r117 = r114.c();
        if (r117 == null) goto L30;
        List r118 = CollectionsKt.filterNotNull(r117);
    L31:
        r108.storeString("credit_tasks", GsonProtectorUtils.toJson(r116, r118));
        goto L32
    L30:
        r118 = null;
    L32:
        StateFlowImpl r119 = f325723c;
        f r120 = r114.a();
        if (r120 == null) goto L35;
        r115 = r120.f();
    L35:
        r119.setValue(r115);
    L36:
        FLogger.f375446a.i("CommerceCreditRepo", "requestCreditInfoAndTasks end");
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceCreditRepo", "requestCreditInfoAndTasks start");
        Keva r121 = c();
        com.larus.commercecredit.impl.model.a.f325719a.a();
        r111.L$0 = r210;
        r111.L$1 = r121;
        r111.Z$0 = r110;
        r111.label = 1;
        JSONObject r122 = new JSONObject();
        r122.put("need_tasks", r110);
        Unit r123 = Unit.INSTANCE;
        Object r124 = HttpExtKt.k(ServiceType.BASIC_SERVICE, g.class, "/commerce/benefit_supply/credit/get_credit_num_optional_tasks", r122, null, null, true, null, null, null, r111, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r124 != r103) goto L17;
        return r103;
    L17:
        r108 = r121;
        r109 = r124;
        r112 = r110;
        r107 = r210;
    L7:
        r100 = new CommerceCreditRepo$requestAllCreditInfo$1(this, r211);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(DowngradeSource r110, com.larus.commercecredit.impl.utils.e r111, Continuation r112) {
        if ((r112 instanceof CommerceCreditRepo$requestCreditTip$1) == false) goto L7;
        CommerceCreditRepo$requestCreditTip$1 r100 = (CommerceCreditRepo$requestCreditTip$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$requestCreditTip$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Function1 r105 = (Function1) r113.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = r102;
        Function1 r107 = r105;
    L17:
        com.larus.network.http.a r108 = (com.larus.network.http.a) r106;
        r107.invoke(r108);
        k r109 = (k) r108.f360135b;
        FLogger.f375446a.i("CommerceCreditRepo", "requestCreditTip end");
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceCreditRepo", "requestCreditTip start");
        com.larus.commercecredit.impl.model.a.f325719a.a();
        r107 = r111;
        r113.L$0 = r107;
        r113.label = 1;
        r106 = IFlowDowngradeService.a.b(FlowDowngradeServiceDelegate.INSTANCE, ServiceType.BASIC_SERVICE, k.class, "/commerce/benefit_supply/credit/get_credit_tip", new JSONObject(), null, true, null, MapsKt.mapOf(TuplesKt.to("source", r110.getValue())), r113, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r106 != r103) goto L17;
        return r103;
    L7:
        r100 = new CommerceCreditRepo$requestCreditTip$1(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object g(String r110, com.larus.commercecredit.impl.utils.b r111, Continuation r210) {
        if ((r210 instanceof CommerceCreditRepo$requestGroupInfo$1) == false) goto L7;
        CommerceCreditRepo$requestGroupInfo$1 r100 = (CommerceCreditRepo$requestGroupInfo$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$requestGroupInfo$1 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Function1 r105 = (Function1) r112.L$1;
        String r106 = (String) r112.L$0;
        ResultKt.throwOnFailure(r102);
        Object r107 = r102;
        Function1 r108 = r105;
    L18:
        com.larus.network.http.a r109 = (com.larus.network.http.a) r107;
        r108.invoke(r109);
        d r113 = (d) r109.f360135b;
        if (r113 == null) goto L23;
        Keva r114 = c();
        if (r114 == null) goto L23;
        r114.storeString("group_info_" + r106, GsonProtectorUtils.toJson(b(), r113));
    L23:
        FLogger.f375446a.i("CommerceCreditRepo", "requestGroupInfo end");
        return r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceCreditRepo", "requestGroupInfo start, campaignKey: " + r110);
        com.larus.commercecredit.impl.model.a.f325719a.a();
        r112.L$0 = r110;
        r108 = r111;
        r112.L$1 = r108;
        r112.label = 1;
        JSONObject r115 = new JSONObject();
        r115.put("campaign_key", r110);
        Unit r116 = Unit.INSTANCE;
        r107 = HttpExtKt.k(ServiceType.BASIC_SERVICE, d.class, "/commerce/benefit_supply/fission/get_campaign_info", r115, null, null, true, null, null, null, r112, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r107 != r103) goto L17;
        return r103;
    L17:
        r106 = r110;
    L7:
        r100 = new CommerceCreditRepo$requestGroupInfo$1(this, r210);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object h(String r110, com.larus.commercecredit.impl.utils.c r111, Continuation r112) {
        if ((r112 instanceof CommerceCreditRepo$requestGroupInvitation$1) == false) goto L7;
        CommerceCreditRepo$requestGroupInvitation$1 r100 = (CommerceCreditRepo$requestGroupInvitation$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$requestGroupInvitation$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Function1 r105 = (Function1) r113.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = r102;
    L18:
        com.larus.network.http.a r107 = (com.larus.network.http.a) r106;
        r105.invoke(r107);
        l r108 = (l) r107.f360135b;
        FLogger.f375446a.i("CommerceCreditRepo", "requestGroupInvitation end");
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceCreditRepo", "requestGroupInvitation start, campaignKey: " + r110);
        com.larus.commercecredit.impl.model.a.f325719a.a();
        r113.L$0 = r111;
        r113.label = 1;
        JSONObject r109 = new JSONObject();
        r109.put("campaign_key", r110);
        Unit r114 = Unit.INSTANCE;
        Object r115 = HttpExtKt.k(ServiceType.BASIC_SERVICE, l.class, "/commerce/benefit_supply/fission/get_group_invitation", r109, null, null, true, null, null, null, r113, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r115 != r103) goto L17;
        return r103;
    L17:
        r106 = r115;
        r105 = r111;
    L7:
        r100 = new CommerceCreditRepo$requestGroupInvitation$1(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object i(DowngradeSource r110, com.larus.commercecredit.impl.utils.f r111, Continuation r112) {
        if ((r112 instanceof CommerceCreditRepo$sendUserActivity$1) == false) goto L7;
        CommerceCreditRepo$sendUserActivity$1 r100 = (CommerceCreditRepo$sendUserActivity$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$sendUserActivity$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Function1 r105 = (Function1) r113.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = r102;
        Function1 r107 = r105;
    L17:
        com.larus.network.http.a r108 = (com.larus.network.http.a) r106;
        r107.invoke(r108);
        q r109 = (q) r108.f360135b;
        if (r109 == null) goto L22;
        long r114 = r109.a();
        Keva r115 = c();
        if (r115 == null) goto L22;
        r115.storeLong("user_activity_timestamp", r114);
    L22:
        FLogger.f375446a.i("CommerceCreditRepo", "sendUserActivity end");
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceCreditRepo", "sendUserActivity start");
        com.larus.commercecredit.impl.model.a.f325719a.a();
        r107 = r111;
        r113.L$0 = r107;
        r113.label = 1;
        r106 = IFlowDowngradeService.a.b(FlowDowngradeServiceDelegate.INSTANCE, ServiceType.BASIC_SERVICE, q.class, "/commerce/benefit_supply/credit/user_activity", new JSONObject(), null, true, null, MapsKt.mapOf(TuplesKt.to("source", r110.getValue())), r113, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r106 != r103) goto L17;
        return r103;
    L7:
        r100 = new CommerceCreditRepo$sendUserActivity$1(this, r112);
        goto L8
    }

    public final Object d(String r110, String r210, com.larus.commercecredit.impl.utils.d r211, Continuation r212) {
        if ((r212 instanceof CommerceCreditRepo$joinGroup$1) == false) goto L7;
        CommerceCreditRepo$joinGroup$1 r100 = (CommerceCreditRepo$joinGroup$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$joinGroup$1 r111 = r100;
        Object r102 = r111.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r111.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Function1 r105 = (Function1) r111.L$0;
        ResultKt.throwOnFailure(r102);
    L18:
        com.larus.network.http.a r106 = (com.larus.network.http.a) r102;
        r105.invoke(r106);
        FLogger.f375446a.i("CommerceCreditRepo", "joinGroup end");
        return r106.f360135b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceCreditRepo", "joinGroup start, inviteCode: " + r110 + ", campaignKey: " + r210);
        com.larus.commercecredit.impl.model.a.f325719a.a();
        r111.L$0 = r211;
        r111.label = 1;
        JSONObject r107 = new JSONObject();
        r107.put("invite_code", r110);
        r107.put("campaign_key", r210);
        Unit r108 = Unit.INSTANCE;
        Object r109 = HttpExtKt.k(ServiceType.BASIC_SERVICE, String.class, "/commerce/benefit_supply/fission/join_group", r107, null, null, true, null, null, null, r111, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r109 != r103) goto L17;
        return r103;
    L17:
        r102 = r109;
        r105 = r211;
    L7:
        r100 = new CommerceCreditRepo$joinGroup$1(this, r212);
        goto L8
    }
}
