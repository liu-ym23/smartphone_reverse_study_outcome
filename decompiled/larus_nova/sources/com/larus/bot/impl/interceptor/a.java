package com.larus.bot.impl.interceptor;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bot.impl.feature.discover.MultiBotsDowngradeData;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.login.api.ITouristApi;
import com.larus.login.api.TouristManager;
import com.larus.network.http.HttpExtKt;
import com.larus.nova.R;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;
import tx9.x0;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements q97.a {

    /* JADX INFO: renamed from: com.larus.bot.impl.interceptor.a$a, reason: collision with other inner class name */
    public static final class C4135a {
    }

    static {
    }

    public a() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r110) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("Router matchInterceptRules -> ");
        String r102 = null;
        if (r110 == null) goto L7;
        Uri r103 = r110.f267530d;
        if (r103 == null) goto L7;
        String r104 = r103.getAuthority();
    L8:
        r101.append(r104);
        r100.d("BotCreateRouterInterceptor", r101.toString());
        if (r110 == null) goto L11;
        Uri r111 = r110.f267530d;
    L12:
        String r105 = UriProtector.parse(String.valueOf(r111)).getSchemeSpecificPart();
        Intrinsics.checkNotNull(r105);
        String r112 = (String) CollectionsKt.first(StringsKt.split$default(r105, new String[]{"?"}, false, 0, 6, null));
        if (StringsKt.startsWith$default(r112, "//", false, 2, null) == false) goto L16;
        r102 = r112;
    L16:
        return Intrinsics.areEqual(r102, "//flow/create_bot");
    L11:
        r111 = null;
    L7:
        r104 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r110) {
        if (r100 == null) goto L54;
        if (r110 == null) goto L54;
        String r101 = UUID.randomUUID().toString();
        String r111 = qu8.b.f534849a;
        Intrinsics.checkNotNullParameter(r101, "traceId");
        qu8.b.f534849a = r101;
        qu8.b.e("bot_create", "bot_create", false);
        qu8.b.e("bot_create_first_frame", "bot_create", true);
        TouristManager r102 = TouristManager.f357001a;
        if (r102.u() == false) goto L10;
        qu8.b.c(4001, new String[]{"bot_create", "bot_create_step", "bot_create_first_frame", "bot_create_step_first_frame"});
        ITouristApi.a.a(r102, TriggerLoginScene.TRIGGER_LOGIN_CREATE_BOT, false, 2);
        return true;
    L10:
        String r112 = null;
        if (z2.f365865a.x3().getDisableBotCreateEntry() == true) goto L34;
        String r103 = PollingConfigService.f326423a.f("multi_bots_dg");
        if (r103 != null) goto L55;
        MultiBotsDowngradeData r104 = null;
    L23:
        if (r104 == null) goto L30;
        Integer r105 = r104.getBotCreateDowngrade();
        if (r105 == null) goto L30;
        if (r105.intValue() != 1) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == true) goto L34;
        boolean r107 = false;
    L52:
        if (r107 == false) goto L54;
        return true;
    L30:
        r106 = false;
        goto L31
    L55:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L16
        Object r109 = Result.m9449constructorimpl((MultiBotsDowngradeData) HttpExtKt.f360123f.fromJson(r103, MultiBotsDowngradeData.class));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r109) == false) goto L21;
        r109 = null;
    L21:
        r104 = (MultiBotsDowngradeData) r109;
    L16:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L34:
        s r114 = s.f544207a;
        AppHost.Companion r115 = AppHost.f326268a;
        Application r116 = r115.getApplication();
        z2 r117 = z2.f365865a;
        FlowDowngradeToastConfig r118 = r117.getFlowDowngradeToastConfig();
        if (r118 == null) goto L37;
        String r119 = r118.getTrafficDegradationFeatureDisableCn();
    L38:
        if (r119 != null) goto L40;
    L43:
        boolean r120 = true;
    L44:
        if (r120 == false) goto L47;
        String r121 = r115.getApplication().getString(R.string.larus_trafficDegradation_featureDisable_cn);
    L46:
        String r122 = r121;
        Intrinsics.checkNotNull(r122);
        s.j(r114, r116, r122, null, false, 28);
        x0.a("multi_bots_dg_bot_create_dg");
        r107 = true;
        goto L52
    L47:
        FlowDowngradeToastConfig r123 = r117.getFlowDowngradeToastConfig();
        if (r123 == null) goto L50;
        r112 = r123.getTrafficDegradationFeatureDisableCn();
    L50:
        r121 = String.valueOf(r112);
        goto L46
    L40:
        if (r119.length() == 0) goto L43;
        r120 = false;
        goto L44
    L37:
        r119 = null;
    L54:
        return false;
    }
}
