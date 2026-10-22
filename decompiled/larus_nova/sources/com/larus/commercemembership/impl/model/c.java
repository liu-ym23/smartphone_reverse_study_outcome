package com.larus.commercemembership.impl.model;

import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;
import uz8.f;
import uz8.g;
import uz8.h;
import uz8.i;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f325877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f325878b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StateFlowImpl f325879c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b1 f325880d = null;

    public c() {
    }

    static {
        f325877a = new c();
        Lazy r100 = LazyKt.lazy(new b());
        f325878b = r100;
        Object r101 = null;
        StateFlowImpl r102 = j1.a(null);
        f325879c = r102;
        f325880d = e.b(r102);
        FLogger.f375446a.i("CommerceMembershipRepo", "getSubscriptionEntryConfigFromLocal start");
        Keva r103 = a();
        if (r103 == null) goto L5;
        String r104 = r103.getString("subscription_entry_config", "");
    L30:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        Object r106 = Result.m9449constructorimpl((f) ((Gson) r100.getValue()).fromJson(r104, f.class));     // Catch: Throwable -> L8
    L10:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 != null) goto L13;
        r101 = r106;
    L23:
        f r108 = (f) r101;
        FLogger.f375446a.i("CommerceMembershipRepo", "getSubscriptionEntryConfigFromLocal end");
        if (r108 == null) goto L26;
        f325877a.getClass();
        d(r108);
    L26:
        r102.setValue(r108);
        return;
    L13:
        FLogger.f375446a.e("CommerceMembershipRepo", "getSubscriptionEntryConfigFromLocal parse failed, clear corrupted cache", r107);
        f325877a.getClass();     // Catch: Throwable -> L17
        Keva r109 = a();     // Catch: Throwable -> L17
        if (r109 == null) goto L19;
        r109.erase("subscription_entry_config");     // Catch: Throwable -> L17
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L20:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L17
        goto L23
    L19:
        r110 = null;
    L17:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L5:
        r104 = null;
        goto L30
    }

    public static Keva a() {
        return Keva.getRepo("local_commerce_membership_".concat(AccountService.f365697a.getUserId()), 0);
    }

    public static void d(f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.subsStatus;
        String r102 = "";
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        g r103 = r100.subscription;
        String r104 = null;
        if (r103 == null) goto L10;
        String r105 = r103.skuKey;
    L11:
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        if (r103 == null) goto L17;
        Integer r106 = r103.periodType;
        if (r106 == null) goto L17;
        r104 = r106.toString();
    L17:
        if (r104 != null) goto L19;
        r104 = "";
    L19:
        g r107 = r100.subscription;
        if (r107 == null) goto L27;
        Integer r108 = r107.subscriptionType;
        if (r108 == null) goto L27;
        int r109 = 1;
        if (r108.intValue() != 1) goto L27;
    L28:
        String r110 = r100.countryCode;
        if (r110 == null) goto L32;
        r102 = r110;
    L32:
        o r111 = o.f365780a;
        r111.a("subs_status", r101);
        r111.a("subs_sku_key", r105);
        r111.a("subs_period_type", r104);
        r111.a("subs_is_auto_renew", Integer.valueOf(r109));
        r111.a(DistrictSearchQuery.KEYWORDS_COUNTRY, r102);
        return;
    L27:
        r109 = 0;
        goto L28
    L10:
        r105 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(String r210, com.larus.commercemembership.impl.utils.a r211, Continuation r212) {
        if ((r212 instanceof CommerceMembershipRepo$requestSubscriptionEntryConfig$1) == false) goto L7;
        CommerceMembershipRepo$requestSubscriptionEntryConfig$1 r100 = (CommerceMembershipRepo$requestSubscriptionEntryConfig$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CommerceMembershipRepo$requestSubscriptionEntryConfig$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Function1 r105 = (Function1) r110.L$1;
        String r106 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Object r107 = r102;
        Function1 r108 = r105;
    L18:
        com.larus.network.http.a r109 = (com.larus.network.http.a) r107;
        r108.invoke(r109);
        f r111 = (f) r109.f360135b;
        String r112 = null;
        if (r111 == null) goto L21;
        uz8.e r113 = r111.actionBar;
    L22:
        if (r113 != null) goto L35;
        if (r111 == null) goto L25;
        h r114 = r111.settingsPage;
    L26:
        if (r114 != null) goto L35;
        if (r111 == null) goto L29;
        h r115 = r111.settingsUpgradePage;
    L30:
        if (r115 != null) goto L35;
        if (r111 == null) goto L33;
        h r116 = r111.settingsManagementPage;
    L34:
        if (r116 != null) goto L35;
    L86:
        FLogger.f375446a.i("CommerceMembershipRepo", "requestSubscriptionEntryConfig end from=" + r106);
        return r109;
    L33:
        r116 = null;
        goto L34
    L29:
        r115 = null;
        goto L30
    L25:
        r114 = null;
    L35:
        StateFlowImpl r117 = f325879c;
        f r118 = (f) r117.getValue();
        uz8.e r119 = r111.actionBar;
        if (r119 != null) goto L40;
        if (r118 == null) goto L39;
        r119 = r118.actionBar;
        goto L40
    L39:
        uz8.e r120 = null;
    L41:
        h r121 = r111.settingsPage;
        if (r121 != null) goto L46;
        if (r118 == null) goto L45;
        r121 = r118.settingsPage;
        goto L46
    L45:
        h r122 = null;
    L47:
        h r123 = r111.settingsUpgradePage;
        h r124 = r111.settingsManagementPage;
        Boolean r125 = r111.hasActiveSubscription;
        if (r125 != null) goto L52;
        if (r118 == null) goto L51;
        r125 = r118.hasActiveSubscription;
        goto L52
    L51:
        Boolean r126 = null;
    L53:
        String r127 = r111.subsStatus;
        if (r127 != null) goto L58;
        if (r118 == null) goto L57;
        r127 = r118.subsStatus;
        goto L58
    L57:
        String r128 = null;
    L59:
        Boolean r129 = r111.showMembershipName;
        if (r129 != null) goto L64;
        if (r118 == null) goto L63;
        r129 = r118.showMembershipName;
        goto L64
    L63:
        Boolean r130 = null;
    L65:
        String r131 = r111.membershipDisplayName;
        if (r131 != null) goto L70;
        if (r118 == null) goto L69;
        r131 = r118.membershipDisplayName;
        goto L70
    L69:
        String r132 = null;
    L71:
        g r133 = r111.subscription;
        if (r133 != null) goto L76;
        if (r118 == null) goto L75;
        r133 = r118.subscription;
        goto L76
    L75:
        g r134 = null;
    L77:
        String r135 = r111.countryCode;
        if (r135 != null) goto L81;
        if (r118 == null) goto L82;
        r112 = r118.countryCode;
    L82:
        f r136 = new f(r120, r122, r123, r124, r126, r128, r130, r132, r134, r112);
        Keva r137 = a();
        if (r137 == null) goto L85;
        r137.storeString("subscription_entry_config", GsonProtectorUtils.toJson((Gson) f325878b.getValue(), r136));
    L85:
        r117.setValue(r136);
        d(r136);
        goto L86
    L81:
        r112 = r135;
    L76:
        r134 = r133;
    L70:
        r132 = r131;
    L64:
        r130 = r129;
    L58:
        r128 = r127;
    L52:
        r126 = r125;
    L46:
        r122 = r121;
    L40:
        r120 = r119;
        goto L41
    L21:
        r113 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceMembershipRepo", "requestSubscriptionEntryConfig start from=" + r210);
        a.f325875a.a();
        r110.L$0 = r210;
        r108 = r211;
        r110.L$1 = r108;
        r110.label = 1;
        r107 = HttpExtKt.k(ServiceType.BASIC_SERVICE, f.class, "/alice/commerce/sale/subscription/entry/config/", new JSONObject(), null, null, true, null, null, null, r110, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r107 != r103) goto L17;
        return r103;
    L17:
        r106 = r210;
    L7:
        r100 = new CommerceMembershipRepo$requestSubscriptionEntryConfig$1(this, r212);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(String r310, String r311, com.larus.commercemembership.impl.utils.c r312, Continuation r313) {
        if ((r313 instanceof CommerceMembershipRepo$requestUserEntitlement$1) == false) goto L7;
        CommerceMembershipRepo$requestUserEntitlement$1 r100 = (CommerceMembershipRepo$requestUserEntitlement$1) r313;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        String r111 = " from=";
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        i r104 = (i) r100.L$3;
        com.larus.network.http.a r105 = (com.larus.network.http.a) r100.L$2;
        String r106 = (String) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r210 = "CommerceMembershipRepo";
        r111 = " from=";
        String r211 = "user_entitlement";
    L60:
        Keva r108 = a();
        if (r108 == null) goto L63;
        r108.storeString(r211, GsonProtectorUtils.toJson((Gson) f325878b.getValue(), r104));
    L63:
        com.larus.network.http.a r112 = r105;
        String r109 = r107;
        String r113 = r106;
    L67:
        FLogger.f375446a.i(r210, "requestUserEntitlement end scene=" + r109 + r111 + r113);
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function1 r114 = (Function1) r100.L$2;
        String r115 = (String) r100.L$1;
        String r116 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r113 = r115;
        r109 = r116;
        Object r117 = r102;
    L20:
        com.larus.network.http.a r118 = (com.larus.network.http.a) r117;
        r114.invoke(r118);
        i r119 = (i) r118.f360135b;
        String r120 = null;
        if (r119 == null) goto L23;
        String r121 = r119.fingerprint;
    L24:
        if (r121 == null) goto L65;
        Keva r122 = a();
        if (r122 == null) goto L28;
        String r123 = "user_entitlement";
        String r124 = r122.getString(r123, "");
    L71:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L31
        Object r126 = Result.m9449constructorimpl((i) ((Gson) f325878b.getValue()).fromJson(r124, i.class));     // Catch: Throwable -> L31
    L33:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 != null) goto L36;
        String r128 = "CommerceMembershipRepo";
    L47:
        i r129 = (i) r126;
        if (r129 == null) goto L50;
        r120 = r129.fingerprint;
    L50:
        FLogger.f375446a.i(r128, "requestUserEntitlement scene=" + r109 + " remoteFingerprint=" + r121 + " localFingerprint=" + r120);
        if (Intrinsics.areEqual(r121, r120) == false) goto L53;
        r210 = r128;
    L66:
        r112 = r118;
        goto L67
    L53:
        if (com.larus.platform.service.i.f365746a.a() == false) goto L55;
        int r130 = 1;
    L56:
        a.f325875a.a();
        r100.L$0 = r109;
        r100.L$1 = r113;
        r100.L$2 = r118;
        r100.L$3 = r119;
        r100.label = 2;
        r210 = r128;
        r211 = r123;
        Object r212 = r110;
        if (HttpExtKt.k(ServiceType.BASIC_SERVICE, Object.class, "/alice/commerce/intake/entitlement/changed_callback/", new JSONObject().put("callback_scene", r130), null, null, true, null, null, null, r100, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS) != r212) goto L59;
        return r212;
    L59:
        r107 = r109;
        r106 = r113;
        r105 = r118;
        r104 = r119;
        goto L60
    L55:
        r130 = 2;
        goto L56
    L36:
        r128 = r10;
        FLogger.f375446a.e(r128, "getUserEntitlementFromLocal parse failed, clear corrupted cache", r127);
        f325877a.getClass();     // Catch: Throwable -> L40
        Keva r131 = a();     // Catch: Throwable -> L40
        if (r131 == null) goto L42;
        r131.erase(r123);     // Catch: Throwable -> L40
        Unit r132 = Unit.INSTANCE;     // Catch: Throwable -> L40
    L43:
        Result.m9449constructorimpl(r132);     // Catch: Throwable -> L40
    L46:
        r126 = null;
        goto L47
    L42:
        r132 = null;
    L40:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L31:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L28:
        r123 = r12;
        r124 = null;
        goto L71
    L65:
        r210 = r10;
        goto L66
    L23:
        r121 = null;
        goto L24
    L16:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("CommerceMembershipRepo", "requestUserEntitlement start scene=" + r310 + " from=" + r311);
        a.f325875a.a();
        r100.L$0 = r310;
        r100.L$1 = r311;
        r100.L$2 = r312;
        r100.label = 1;
        r117 = HttpExtKt.k(ServiceType.BASIC_SERVICE, i.class, "/alice/commerce/intake/entitlement/query", new JSONObject().put("scene", 1), null, null, true, null, null, null, r100, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        r110 = r110;
        if (r117 != r110) goto L19;
        return r110;
    L19:
        r109 = r310;
        r114 = r312;
        r113 = r311;
    L7:
        r100 = new CommerceMembershipRepo$requestUserEntitlement$1(this, r313);
        goto L8
    }
}
