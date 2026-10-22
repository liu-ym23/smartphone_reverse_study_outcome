package com.ss.android.lark.passport.flow.mfa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.ss.android.lark.passport.flow.core.network.FlowPassportAccountsHttpClient;
import com.ss.android.lark.passport.flow.core.network.PassportHttpMethod;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class FlowMfaRepository {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<FlowVerifyFactor> f437859b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f437860c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowPassportAccountsHttpClient f437861a;

    public static final class a {
    }

    static {
        f437859b = SetsKt.setOf(new FlowVerifyFactor[]{FlowVerifyFactor.PHONE, FlowVerifyFactor.EMAIL});
        f437860c = CollectionsKt.listOf(new String[]{"auth_url", "url", "web_url", ITiktokService.ResponseConstants.REDIRECT_URL});
    }

    @Inject
    public FlowMfaRepository(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f437861a = new FlowPassportAccountsHttpClient(r100);
    }

    public static String f(JSONObject r100) {
        Iterator<T> r101 = f437860c.iterator();
    L3:
        String r102 = null;
        if (r101.hasNext() == false) goto L11;
        String r103 = r100.getString((String) r101.next());
        if (r103 == null) goto L10;
        if ((!StringsKt.isBlank(r103)) == false) goto L10;
        r102 = r103;
    L10:
        if (r102 == null) goto L3;
    L11:
        return r102;
    }

    public static JSONObject h(JSONObject r100) {
        Object r101 = r100.get("data");
        if ((r101 instanceof JSONObject) == true) goto L20;
        Object r102 = null;
        if ((r101 instanceof String) == false) goto L17;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(JSON.parseObject((String) r101));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == true) goto L21;
        r102 = r104;
    L21:
        return (JSONObject) r102;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L17:
        return null;
    L20:
        return (JSONObject) r101;
    }

    public final FlowStep j(com.ss.android.lark.passport.flow.core.network.f r100) {
        JSONObject r101 = h(i(r100, SetsKt.setOf(0)));
        if (r101 == null) goto L22;
        JSONObject r102 = r101.getJSONObject("step_info");
        if (r102 != null) goto L7;
    L8:
        r102 = r101;
    L9:
        String r103 = r101.getString("next_step");
        if (r103 != null) goto L20;
        if (f(r101) == null) goto L14;
    L18:
        r103 = "web_url";
        goto L20
    L14:
        if (f(r102) != null) goto L18;
        throw new IllegalStateException("MFA response missing next_step");
    L20:
        return new FlowStep(r103, r102, r100.b(NetResponse.HEADER_KEY_LOG_ID));
    L7:
        if (r102.isEmpty() == false) goto L9;
    L22:
        throw new IllegalStateException("MFA response missing data");
    }

    public static JSONObject i(com.ss.android.lark.passport.flow.core.network.f r110, Set r111) {
        JSONObject r100 = JSON.parseObject(com.ss.android.lark.passport.flow.core.network.f.a(r110));
        if (r100 == null) goto L17;
        Integer r101 = r100.getInteger("code");
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L9:
        if (r111.contains(Integer.valueOf(r102)) == true) goto L15;
        FlowMfaErrorCategory r103 = FlowMfaErrorCategory.SERVER;
        String r104 = r100.getString("message");
        if (r104 != null) goto L14;
        r104 = "Passport MFA server error";
    L14:
        throw new FlowMfaException(new FlowMfaError(r103, r104, null, null, Integer.valueOf(r102), r110.b(NetResponse.HEADER_KEY_LOG_ID), 12, null));
    L15:
        return r100;
    L7:
        r102 = 0;
        goto L9
    L17:
        throw new IllegalStateException("MFA response body is empty");
    }

    public final Object d(String r100, Continuation r101) {
        if ((r101 instanceof FlowMfaRepository$chooseOptIn$1) == false) goto L7;
        FlowMfaRepository$chooseOptIn$1 r102 = (FlowMfaRepository$chooseOptIn$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r104);
        com.ss.android.lark.passport.flow.core.network.f r106 = (com.ss.android.lark.passport.flow.core.network.f) r104;
        r106.c();
        return j(r106);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r107 = com.ss.android.lark.passport.flow.core.network.b.f437752a;
        throw null;
    L7:
        r102 = new FlowMfaRepository$chooseOptIn$1(this, r101);
        goto L8
    }

    public final Object a(String r110, y r111, Continuation<? super b> r112) {
        if ((r112 instanceof FlowMfaRepository$applyCode$1) == false) goto L7;
        FlowMfaRepository$applyCode$1 r100 = (FlowMfaRepository$applyCode$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$applyCode$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        boolean r105 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L22:
        com.ss.android.lark.passport.flow.core.network.f r114 = (com.ss.android.lark.passport.flow.core.network.f) r113;
        r114.c();
        JSONObject r115 = i(r114, SetsKt.setOf(new Integer[]{Boxing.boxInt(0), Boxing.boxInt(4206)}));
        JSONObject r116 = h(r115);
        Integer r106 = r115.getInteger("code");
        if (r106 == null) goto L25;
        int r107 = r106.intValue();
    L27:
        if (r116 == null) goto L29;
        Integer r117 = r116.getInteger("expire");
    L30:
        String r118 = r115.getString("message");
        if (r107 != 4206) goto L34;
        r105 = true;
    L34:
        return new b(r117, r118, r105);
    L29:
        r117 = null;
        goto L30
    L25:
        r107 = 0;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        FlowVerifyFactor r119 = r111.f437927a;
        if (f437859b.contains(r119) == false) goto L35;
        FlowPassportAccountsHttpClient r108 = this.f437861a;
        String r120 = r111.f437930d;
        if (StringsKt.isBlank(r120) == false) goto L19;
        r120 = "login";
    L19:
        r102.label = 1;
        r113 = com.ss.android.lark.passport.flow.core.network.b.c(com.ss.android.lark.passport.flow.core.network.b.f437752a, r108, r110, "/accounts/auth/code/apply", MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("code_type", Boxing.boxInt(0)), TuplesKt.to("flow_type", r120)}), r102);
        if (r113 != r103) goto L22;
        return r103;
    L35:
        int r121 = g.f437896a;
        throw new FlowMfaException(g.e(r119.getWireKey()));
    L7:
        r100 = new FlowMfaRepository$applyCode$1(this, r112);
        goto L8
    }

    public final Object b(String r100, String r101, JSONObject r110, Continuation<? super FlowStep> r111) {
        if ((r111 instanceof FlowMfaRepository$applyFirstParty$1) == false) goto L7;
        FlowMfaRepository$applyFirstParty$1 r102 = (FlowMfaRepository$applyFirstParty$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$applyFirstParty$1 r104 = r102;
        Object r112 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L22:
        com.ss.android.lark.passport.flow.core.network.f r113 = (com.ss.android.lark.passport.flow.core.network.f) r112;
        r113.c();
        return j(r113);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        FlowPassportAccountsHttpClient r114 = this.f437861a;
        r104.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r107 = com.ss.android.lark.passport.flow.core.network.b.f437752a;
        LinkedHashMap r108 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("scope", r101), TuplesKt.to("support_qr_code", Boxing.boxBoolean(true)), TuplesKt.to("support_verify_list", Boxing.boxBoolean(true))});
        if (r110 != null) goto L17;
    L19:
        r112 = com.ss.android.lark.passport.flow.core.network.b.c(com.ss.android.lark.passport.flow.core.network.b.f437752a, r114, r100, "/accounts/mfa_token/apply", r108, r104);
        if (r112 != r105) goto L22;
        return r105;
    L17:
        if ((!r110.isEmpty()) == false) goto L19;
        r108.put("custom_params", r110);
    L7:
        r102 = new FlowMfaRepository$applyFirstParty$1(this, r111);
        goto L8
    }

    public final Object c(String r100, String r110, String r111, Continuation<? super FlowMfaTokenStatus> r112) {
        if ((r112 instanceof FlowMfaRepository$checkToken$1) == false) goto L7;
        FlowMfaRepository$checkToken$1 r101 = (FlowMfaRepository$checkToken$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$checkToken$1 r103 = r101;
        Object r113 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        com.ss.android.lark.passport.flow.core.network.f r114 = (com.ss.android.lark.passport.flow.core.network.f) r113;
        r114.c();
        JSONObject r106 = h(i(r114, SetsKt.setOf(0)));
        if (r106 == null) goto L20;
        Integer r107 = r106.getInteger("token_status");
    L21:
        if (r107 != null) goto L24;
    L26:
        if (r107 == null) goto L32;
        if (r107.intValue() != 2) goto L32;
        return FlowMfaTokenStatus.INVALID;
    L32:
        return FlowMfaTokenStatus.UNKNOWN;
    L24:
        if (r107.intValue() != 1) goto L26;
        return FlowMfaTokenStatus.VALID;
    L20:
        r107 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        FlowPassportAccountsHttpClient r108 = this.f437861a;
        r103.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r115 = com.ss.android.lark.passport.flow.core.network.b.f437752a;
        r113 = com.ss.android.lark.passport.flow.core.network.b.b(r108, r100, "/accounts/mfa_token/validate", MapsKt.mapOf(TuplesKt.to("x-mfa-token", r111)), MapsKt.mapOf(TuplesKt.to("scope", r110)), r103);
        if (r113 != r104) goto L17;
        return r104;
    L7:
        r101 = new FlowMfaRepository$checkToken$1(this, r112);
        goto L8
    }

    public final Object e(String r100, String r101, String r110, Continuation<? super FlowStep> r111) {
        if ((r111 instanceof FlowMfaRepository$dispatchBidp$1) == false) goto L7;
        FlowMfaRepository$dispatchBidp$1 r102 = (FlowMfaRepository$dispatchBidp$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$dispatchBidp$1 r104 = r102;
        Object r112 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L25:
        com.ss.android.lark.passport.flow.core.network.f r113 = (com.ss.android.lark.passport.flow.core.network.f) r112;
        r113.c();
        return j(r113);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        FlowPassportAccountsHttpClient r114 = this.f437861a;
        r104.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r108 = com.ss.android.lark.passport.flow.core.network.b.f437752a;
        LinkedHashMap r109 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("state", r101)});
        if (r110 != null) goto L17;
    L20:
        if (r107 == true) goto L22;
        r109.put(ITiktokService.ResponseConstants.CODE_VERIFIER, r110);
    L22:
        r112 = com.ss.android.lark.passport.flow.core.network.b.c(com.ss.android.lark.passport.flow.core.network.b.f437752a, r114, r100, "/accounts/idp/dispatch", r109, r104);
        if (r112 != r105) goto L25;
        return r105;
    L17:
        if (StringsKt.isBlank(r110) == true) goto L20;
        r107 = false;
    L7:
        r102 = new FlowMfaRepository$dispatchBidp$1(this, r111);
        goto L8
    }

    public final Object g(String r110, JSONObject r111, String r112, Continuation<? super FlowStep> r113) {
        if ((r113 instanceof FlowMfaRepository$fetchBidpAuthUrl$1) == false) goto L7;
        FlowMfaRepository$fetchBidpAuthUrl$1 r100 = (FlowMfaRepository$fetchBidpAuthUrl$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$fetchBidpAuthUrl$1 r102 = r100;
        Object r114 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        boolean r105 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L27:
        com.ss.android.lark.passport.flow.core.network.f r115 = (com.ss.android.lark.passport.flow.core.network.f) r114;
        r115.c();
        return j(r115);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        String r106 = r111.getString("channel");
        Set<String> r107 = wyb.a.f561896b;
        if (wyb.a.C8175a.b(r106) == false) goto L30;
        FlowPassportAccountsHttpClient r108 = this.f437861a;
        r102.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r109 = com.ss.android.lark.passport.flow.core.network.b.f437752a;
        LinkedHashMap r116 = new LinkedHashMap();
        com.ss.android.lark.passport.flow.core.network.b r117 = com.ss.android.lark.passport.flow.core.network.b.f437752a;
        com.ss.android.lark.passport.flow.core.network.b.a(r111, r116, "flow_type");
        com.ss.android.lark.passport.flow.core.network.b.a(r111, r116, "channel");
        com.ss.android.lark.passport.flow.core.network.b.a(r111, r116, "tenant_domain");
        com.ss.android.lark.passport.flow.core.network.b.a(r111, r116, "user_id");
        com.ss.android.lark.passport.flow.core.network.b.a(r111, r116, "target_session_key");
        com.ss.android.lark.passport.flow.core.network.b.a(r111, r116, "login_type");
        r116.put("client_schema", "doubaolarkauth");
        r116.put("use_package_domain", String.valueOf(Intrinsics.areEqual(r111.getBoolean("use_package_domain"), Boxing.boxBoolean(true))));
        if (r112 != null) goto L19;
    L22:
        if (r105 == true) goto L24;
        r116.put("code_challenge", r112);
        r116.put("code_challenge_method", "S256");
    L24:
        r114 = FlowPassportAccountsHttpClient.c(r108, r110, "/accounts/idp/auth_url", PassportHttpMethod.GET, r116, null, null, r102, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT);
        if (r114 != r103) goto L27;
        return r103;
    L19:
        if (StringsKt.isBlank(r112) == true) goto L22;
        r105 = false;
        goto L22
    L30:
        throw new FlowMfaException(g.d());
    L7:
        r100 = new FlowMfaRepository$fetchBidpAuthUrl$1(this, r113);
        goto L8
    }

    public final Object k(String r100, String r101, y r110, Continuation<? super FlowStep> r111) {
        if ((r111 instanceof FlowMfaRepository$verifyCode$1) == false) goto L7;
        FlowMfaRepository$verifyCode$1 r102 = (FlowMfaRepository$verifyCode$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$verifyCode$1 r104 = r102;
        Object r112 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L24:
        com.ss.android.lark.passport.flow.core.network.f r113 = (com.ss.android.lark.passport.flow.core.network.f) r112;
        r113.c();
        return j(r113);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        FlowVerifyFactor r114 = r110.f437927a;
        if (f437859b.contains(r114) == true) goto L17;
        int r107 = g.f437896a;
        throw new FlowMfaException(g.e(r114.getWireKey()));
    L17:
        if (StringsKt.isBlank(r101) == true) goto L27;
        FlowPassportAccountsHttpClient r115 = this.f437861a;
        String r116 = r110.f437930d;
        if (StringsKt.isBlank(r116) == false) goto L21;
        r116 = "login";
    L21:
        r104.label = 1;
        r112 = com.ss.android.lark.passport.flow.core.network.b.c(com.ss.android.lark.passport.flow.core.network.b.f437752a, r115, r100, "/accounts/auth/code/verify", MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("code", r101), TuplesKt.to("flow_type", r116)}), r104);
        if (r112 != r105) goto L24;
        return r105;
    L27:
        throw new FlowMfaException(g.c("MFA verify code must not be blank"));
    L7:
        r102 = new FlowMfaRepository$verifyCode$1(this, r111);
        goto L8
    }
}
