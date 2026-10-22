package com.larus.common.account.platform.larkauth;

import com.bytedance.sdk.account.impl.d0;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.common.account.platform.larkauth.model.AuthorizationModel;
import com.larus.common.account.platform.larkauth.model.LarkAuthAccountKind;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class LarkAuthTokenFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LarkAuthTokenFetcher f326121a = null;

    /* JADX INFO: loaded from: classes27.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f326122a = null;

        static {
            int[] r100 = new int[LarkAuthAccountKind.values().length];
            r100[LarkAuthAccountKind.LOGIN_B.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LarkAuthAccountKind.LOGIN_C.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LarkAuthAccountKind.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f326122a = r100;
        }
    }

    static {
        f326121a = new LarkAuthTokenFetcher();
    }

    public LarkAuthTokenFetcher() {
    }

    public static com.larus.common.account.platform.larkauth.model.a a() {
        int r100 = com.larus.common.account.platform.larkauth.model.a.f326140d;
        boolean r101 = AccountService.f365697a.isLogin().booleanValue();
        if (r101 == false) goto L5;
        boolean r102 = ILoginService.f286097a.getAccountInfo().f531534g;
    L6:
        if (r101 == false) goto L9;
        if (r102 == false) goto L9;
        LarkAuthAccountKind r103 = LarkAuthAccountKind.LOGIN_B;
    L13:
        return new com.larus.common.account.platform.larkauth.model.a(r101, r102, r103);
    L9:
        if (r101 == false) goto L11;
        r103 = LarkAuthAccountKind.LOGIN_C;
        goto L13
    L11:
        r103 = LarkAuthAccountKind.UNKNOWN;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    public static boolean d() {
        zz8.c r100 = zz8.d.a();
        LarkAuthAccountKind r101 = a().f326143c;
        Intrinsics.checkNotNullParameter(r101, "accountKind");
        int r102 = zz8.c.b.f574108a[r101.ordinal()];
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L12;
        if (r102 != 3) goto L10;
    L17:
        return false;
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        if (r100.f574102a == null) goto L17;
        return true;
    L15:
        if (r100.f574103b == null) goto L17;
        return true;
    }

    public final Object b(zz8.a r110, String r111, Continuation<? super a09.a> r112) {
        if ((r112 instanceof LarkAuthTokenFetcher$fetchBizAuthToken$1) == false) goto L7;
        LarkAuthTokenFetcher$fetchBizAuthToken$1 r100 = (LarkAuthTokenFetcher$fetchBizAuthToken$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        int r104 = 0;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L22:
        String r114 = (String) r113;
        a09.a r115 = new a09.a(null, null, null, null, null, 63);
        if (r114 != null) goto L25;
    L28:
        boolean r116 = true;
    L30:
        if (r116 == true) goto L65;
        a09.c r117 = a09.f.a(r114);     // Catch: Exception -> L62
        if (r117.f1327a != true) goto L35;
        boolean r118 = true;
    L37:
        if (r118 == false) goto L52;
        IApplog.Companion r119 = IApplog.f287053a;     // Catch: Exception -> L62
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L62
        r105.put("success", 1);     // Catch: Exception -> L62
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L62
        r119.reportEvent("lark_auth_act_result", r105);     // Catch: Exception -> L62
        JSONObject r120 = r117.f1328b;     // Catch: Exception -> L62
        if (r120 == null) goto L65;
        String r121 = r120.optString("access_token");     // Catch: Exception -> L62
        if (r121 == null) goto L43;
        r115.e(r121);     // Catch: Exception -> L62
    L43:
        JSONObject r122 = r117.f1328b;     // Catch: Exception -> L62
        if (r122 == null) goto L48;
        String r123 = r122.optString("auth_scheme");     // Catch: Exception -> L62
        if (r123 == null) goto L48;
        r115.h(r123);     // Catch: Exception -> L62
    L48:
        JSONObject r124 = r117.f1328b;     // Catch: Exception -> L62
        if (r124 == null) goto L51;
        r115.f(Long.valueOf(r124.optLong("expires_in")));     // Catch: Exception -> L62
    L51:
        r115.g(Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L62
        return r115;
    L52:
        JSONObject r125 = r117.f1328b;     // Catch: Exception -> L62
        if (r125 == null) goto L56;
        Integer r126 = Integer.valueOf(r125.optInt("error_code"));     // Catch: Exception -> L62
    L57:
        IApplog.Companion r127 = IApplog.f287053a;     // Catch: Exception -> L62
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L62
        r107.put("success", 0);     // Catch: Exception -> L62
        if (r126 == null) goto L60;
        r104 = r126.intValue();     // Catch: Exception -> L62
    L60:
        r107.put("error_code", r104);     // Catch: Exception -> L62
        Unit r128 = Unit.INSTANCE;     // Catch: Exception -> L62
        r127.reportEvent("lark_auth_act_result", r107);     // Catch: Exception -> L62
        goto L65
    L56:
        r126 = null;
        goto L57
    L35:
        r118 = false;
    L62:
        e = move-exception;
        FLogger.f375446a.e("parseAccessTokenFromJson", "parseAccessTokenFromJson error e=" + e.getMessage());
    L65:
        return null;
    L25:
        if (r114.length() == 0) goto L28;
        r116 = false;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        Map<String, String> r129 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("client_id", r110.f574098a), TuplesKt.to("scope", r110.f574099b), TuplesKt.to("client_type", r110.f574100c)});
        if (o0.d(r111) == false) goto L19;
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r129.put("d_pop", r111);
    L19:
        AuthorizationModel r130 = AuthorizationModel.f326136a;
        r100.label = 1;
        r113 = r130.a(r129, r100);
        if (r113 != r102) goto L22;
        return r102;
    L7:
        r100 = new LarkAuthTokenFetcher$fetchBizAuthToken$1(this, r112);
        goto L8
    }

    public static Object c(String r100, String r101, String r102, Continuation r103) {
        com.larus.common.account.platform.larkauth.model.a r104 = a();
        zz8.c r105 = zz8.d.a();
        FLogger.f375446a.i("LarkAuthTokenFetcher", "fetch token kind=" + r104.f326143c);
        int r106 = a.f326122a[r104.f326143c.ordinal()];
        boolean r107 = true;
        if (r106 == 1) goto L16;
        if (r106 != 2) goto L6;
        zz8.a r108 = r105.f574102a;
        if (r108 == null) goto L41;
        Object r109 = f326121a.b(r108, r100, r103);
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        return r109;
    L42:
        return (a09.a) r109;
    L41:
        return null;
    L6:
        if (r106 != 3) goto L9;
        return null;
    L9:
        throw new NoWhenBranchMatchedException();
    L16:
        zz8.b r110 = r105.f574103b;
        if (r110 == null) goto L43;
        j r111 = new j(IntrinsicsKt.intercepted(r103), 1);
        r111.C();
        int r112 = com.larus.common.account.platform.larkauth.model.c.f326150a;
        String r113 = r110.f574101a;
        Intrinsics.checkNotNullParameter(r113, "platformAppId");
        Map<String, String> r114 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("platform_app_id", r113), TuplesKt.to("d_pop", r100)});
        if (r101 != null) goto L21;
    L24:
        boolean r115 = true;
    L25:
        if (r115 == true) goto L33;
        if (r102 != null) goto L28;
    L31:
        if (r107 == true) goto L33;
        r114.put("os_type", r101);
        r114.put("terminal_type", r102);
        goto L33
    L28:
        if (r102.length() == 0) goto L31;
        r107 = false;
    L33:
        ((d0) d0.c()).b("/passport/doubao/get_oauth_token/", null, r114, new c(r111));
        Object r116 = r111.B();
        if (r116 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        DebugProbesKt.probeCoroutineSuspended(r103);
    L37:
        if (r116 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        return r116;
    L40:
        return (a09.a) r116;
    L21:
        if (r101.length() == 0) goto L24;
        r115 = false;
        goto L25
    L43:
        return null;
    }
}
