package com.ss.android.lark.passport.flow.core.network;

import android.content.Context;
import android.os.Build;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.HttpHeader;
import com.bytedance.lark.pb.tool.v1.HttpHeaderMap;
import com.bytedance.lark.pb.tool.v1.HttpMethod;
import com.bytedance.lark.pb.tool.v1.UserSendHttpRequest;
import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.http.okhttp.BaseOkHttpRequest;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import io.reactivex.disposables.Disposable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class FlowPassportAccountsHttpClient {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f437745d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f437746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f437747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f437748c;

    public static final class a {
    }

    static {
        Locale r100 = Locale.US;
        f437745d = SetsKt.setOf(new String[]{"X-App-Id".toLowerCase(r100), "X-Device-Info".toLowerCase(r100), "Authorization".toLowerCase(r100), "DPoP".toLowerCase(r100), BaseHttpRequestInfo.KEY_COOKIE.toLowerCase(r100), BaseOkHttpRequest.HEADER_LOG_TAG.toLowerCase(r100), "x-tt-env".toLowerCase(r100), "X-Front-Uuid".toLowerCase(r100), "X-Terminal-Type".toLowerCase(r100), "X-Locale".toLowerCase(r100), "X-Flow-Key".toLowerCase(r100), "X-Verify-Token".toLowerCase(r100), "X-Proxy-Unit".toLowerCase(r100), "Suite-Session-Key".toLowerCase(r100), "X-Passport-Session-Keys".toLowerCase(r100), "X-Passport-Unit".toLowerCase(r100), "X-Passport-Uni-Did".toLowerCase(r100), "X-Passport-Device-IDs".toLowerCase(r100), "x-passport-single-product".toLowerCase(r100), "x-passport-from-source".toLowerCase(r100), "X-Api-Version".toLowerCase(r100)});
    }

    public FlowPassportAccountsHttpClient(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f437746a = r100;
        this.f437747b = new ConcurrentHashMap();
        this.f437748c = UUID.randomUUID().toString();
    }

    public final void a(String r100, Map<String, String> r101, String r102) {
        ConcurrentHashMap<String, String> r103 = this.f437747b.get(r100);
        if (r103 == null) goto L13;
        String r104 = r103.get(r102);
        if (r104 != null) goto L7;
        return;
    L7:
        if ((!StringsKt.isBlank(r104)) == true) goto L10;
        r104 = null;
    L10:
        if (r104 == null) goto L15;
        r101.put(r102, r104);
        return;
    L15:
        return;
    }

    public final void d(f r100, String r101, String r102) {
        String r103 = r100.b(r102);
        if (r103 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r103)) == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L18;
        ConcurrentHashMap<String, ConcurrentHashMap<String, String>> r104 = this.f437747b;
        ConcurrentHashMap<String, String> r105 = r104.get(r101);
        if (r105 != null) goto L15;
        r105 = new ConcurrentHashMap();
        ConcurrentHashMap<String, String> r106 = r104.putIfAbsent(r101, r105);
        if (r106 == null) goto L15;
        r105 = r106;
    L15:
        r105.put(r102, r103);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object c(FlowPassportAccountsHttpClient r110, String r111, String r112, PassportHttpMethod r113, Map r114, Map r115, byte[] r210, ContinuationImpl r211, int r212) {
        if ((r212 & 8) == 0) goto L5;
        Map r100 = MapsKt.emptyMap();
    L7:
        if ((r212 & 16) == 0) goto L9;
        Map r101 = MapsKt.emptyMap();
    L11:
        if ((r212 & 32) == 0) goto L13;
        byte[] r102 = null;
    L15:
        if ((r212 & 64) == 0) goto L17;
        String r103 = UUID.randomUUID().toString();
    L19:
        if ((r212 & 128) == 0) goto L21;
        int r116 = 30;
    L23:
        if ((r212 & 256) == 0) goto L25;
        boolean r117 = true;
    L27:
        if ((r212 & 512) == 0) goto L29;
        boolean r118 = false;
    L31:
        return r110.b(r111, r112, r113, r100, r101, r102, r103, r116, r117, r118, r211);
    L29:
        r118 = true;
        goto L31
    L25:
        r117 = false;
        goto L27
    L21:
        r116 = 0;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }

    public final Object b(String r310, String r311, PassportHttpMethod r312, Map<String, String> r313, Map<String, String> r314, byte[] r315, String r316, int r410, boolean r411, boolean r412, Continuation<? super f> r413) {
        if ((r413 instanceof FlowPassportAccountsHttpClient$executeAccounts$1) == false) goto L7;
        FlowPassportAccountsHttpClient$executeAccounts$1 r100 = (FlowPassportAccountsHttpClient$executeAccounts$1) r413;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = null;
    L358:
        f r107 = (f) r102;
        d(r107, r105, "X-Flow-Key");
        d(r107, r105, "X-Verify-Token");
        d(r107, r105, "X-Proxy-Unit");
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L361
        Object r109 = Result.m9449constructorimpl(JSON.parseObject(f.a(r107)));     // Catch: Throwable -> L361
    L364:
        if (Result.m9455isFailureimpl(r109) == false) goto L366;
        Object r110 = r106;
    L367:
        JSONObject r111 = (JSONObject) r110;
        if (r111 == null) goto L421;
        Integer r112 = r111.getInteger("code");
        if (r112 == null) goto L373;
        int r113 = r112.intValue();
    L374:
        String r114 = r111.getString("message");
        Integer r115 = r111.getInteger(UniContext.KEY_OF_BIZ_CODE);
        JSONObject r116 = r111.getJSONObject("data");
        if (r116 == null) goto L380;
        String r117 = r116.getString("next_step");
        if (r117 == null) goto L380;
        String r118 = r117;
    L382:
        if (r113 != 4233) goto L420;
        tyb.a r119 = tyb.a.f548019a;
        if (r116 == null) goto L413;
        boolean r120 = r116.containsKey("type");
        int r121 = r116.getIntValue("type");
        String r122 = r116.getString("decision");
        if (r122 != null) goto L388;
    L391:
        boolean r123 = true;
    L392:
        if (r123 == true) goto L410;
        StringBuilder r124 = new StringBuilder("show turing dialog by decision, is risk info empty? ");
        if (r122 != null) goto L396;
    L399:
        boolean r125 = true;
    L400:
        r124.append(r125);
        PassportLog.d("n_action_bdturing", r124.toString());
        if (r122 != null) goto L403;
    L406:
        boolean r126 = true;
    L407:
        if (r126 == false) goto L409;
        PassportLog.b("n_action_bdturing", "show turing dialog get empty risk info");
    L414:
        String r127 = r107.b(NetResponse.HEADER_KEY_LOG_ID);
        if (r114 != null) goto L418;
        r114 = "BDTuring verification is required";
    L418:
        throw new PassportHttpBusinessException(r113, r115, r118, r127, r114);
    L409:
        tyb.a r128 = tyb.a.f548019a;
        tyb.a.b.C7807b r129 = new tyb.a.b.C7807b(r122);
        r128.getClass();
        UICallbackExecutor.execute(new tyb.c(r129));
        goto L414
    L403:
        if (StringsKt.isBlank(r122) == true) goto L406;
        r126 = false;
        goto L407
    L396:
        if (r122.length() == 0) goto L399;
        r125 = false;
        goto L400
    L410:
        if (r120 == false) goto L412;
        PassportLog.d("n_action_bdturing", "show turing dialog by challenge id, challengeId: " + r121);
        tyb.a r130 = tyb.a.f548019a;
        tyb.a.b.C7806a r131 = new tyb.a.b.C7806a(r121);
        r130.getClass();
        UICallbackExecutor.execute(new tyb.c(r131));
        goto L414
    L412:
        PassportLog.b("n_action_bdturing", "decision is empty and no challenge code, data keys: " + r116.keySet());
        goto L414
    L388:
        if (StringsKt.isBlank(r122) == true) goto L391;
        r123 = false;
        goto L392
    L413:
        PassportLog.b("n_action_bdturing", "bdturing resp data is null");
        goto L414
    L420:
        if (Intrinsics.areEqual(r118, "change_geo") == false) goto L421;
        throw new PassportHttpBusinessException(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, r115, r118, r107.b(NetResponse.HEADER_KEY_LOG_ID), "next step is change_geo");
    L380:
        r118 = r111.getString("next_step");
        goto L382
    L373:
        r113 = 0;
    L421:
        return r107;
    L366:
        r110 = r109;
    L361:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L364
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r133 = r100.Z$1;
        boolean r134 = r100.Z$0;
        int r135 = r100.I$0;
        gpb.a r136 = (gpb.a) r100.L$7;
        String r137 = (String) r100.L$6;
        byte[] r138 = (byte[]) r100.L$5;
        Map<String, String> r139 = (Map) r100.L$4;
        Map<String, String> r140 = (Map) r100.L$3;
        PassportHttpMethod r141 = (PassportHttpMethod) r100.L$2;
        String r142 = (String) r100.L$1;
        String r143 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        boolean r144 = r133;
        Object r145 = r102;
        gpb.a r210 = r136;
        String r146 = r142;
        boolean r147 = r134;
        int r148 = r135;
        String r149 = r137;
        PassportHttpMethod r150 = r141;
    L84:
        String r151 = (String) r145;
        FlowPassportAccountsHttpClient$executeAccounts$1 r152 = r100;
        PassportHttpMethod r317 = r150;
        int r318 = r148;
        boolean r414 = r147;
        if (StringsKt.startsWith$default(r146, HTTP.URL_DEFAULT, false, 2, null) == false) goto L437;
        StringBuilder r153 = new StringBuilder();
        r153.append(com.ss.android.lark.passport.flow.core.network.a.a(r210));
        r153.append(r146);
        if (r140.isEmpty() == false) goto L89;
        String r154 = "";
    L90:
        r153.append(r154);
        String r155 = r153.toString();
        if (r138 == null) goto L93;
        boolean r156 = true;
    L95:
        if ((!StringsKt.isBlank(r143)) == false) goto L435;
        Set<String> r157 = r139.keySet();
        if ((r157 instanceof Collection) == true) goto L99;
    L101:
        Iterator r158 = r157.iterator();
    L103:
        if (r158.hasNext() == false) goto L108;
        Iterator r319 = r158;
        if (f437745d.contains(((String) r158.next()).toLowerCase(Locale.US)) == true) goto L106;
        r158 = r319;
        goto L103
    L106:
        boolean r159 = false;
    L109:
        if (r159 == false) goto L433;
        Pair[] r160 = new Pair[7];
        r160[0] = TuplesKt.to("Accept", "application/json; charset=utf-8");
        r160[1] = TuplesKt.to(BaseOkHttpRequest.HEADER_LOG_TAG, r149);
        r160[2] = TuplesKt.to("X-App-Id", "12");
        String r211 = r149;
        r160[3] = TuplesKt.to("X-Api-Version", "1.0.30");
        r160[4] = TuplesKt.to("X-Front-Uuid", this.f437748c);
        r160[5] = TuplesKt.to("X-Terminal-Type", "3");
        Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L113
        Object r162 = Result.m9449constructorimpl(LarkContext.getApplication().getApplicationContext());     // Catch: Throwable -> L113
    L116:
        if (Result.m9455isFailureimpl(r162) == false) goto L118;
        r162 = null;
    L118:
        Context r163 = (Context) r162;
        LinkedHashMap r164 = new LinkedHashMap();
        byte[] r320 = r138;
        r164.put("device_id", r151);
        String r165 = Build.MODEL;
        if (r165 == null) goto L127;
        if ((!StringsKt.isBlank(r165)) == true) goto L124;
        r165 = null;
    L124:
        if (r165 == null) goto L127;
        r164.put(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME, r165);
        r164.put("device_model", r165);
    L127:
        String r166 = Build.VERSION.RELEASE;
        if (r166 != null) goto L130;
        r166 = "";
    L130:
        String r167 = StringsKt.trim("Android ".concat(r166)).toString();
        if ((!StringsKt.isBlank(r167)) == false) goto L133;
        r164.put("device_os", r167);
    L133:
        if (r163 == null) goto L143;
        String r168 = r163.getPackageName();
        if (r168 == null) goto L143;
        if ((!StringsKt.isBlank(r168)) == true) goto L140;
        r168 = null;
    L140:
        if (r168 == null) goto L143;
        r164.put("package_name", r168);
    L143:
        if (r210.isFeishuBrand() == false) goto L145;
        String r169 = "feishu";
    L146:
        r164.put("package_brand", r169);
        if (r163 != null) goto L450;
    L160:
        String r170 = null;
    L161:
        if (r170 == null) goto L163;
        r164.put("lark_version", r170);
    L163:
        r164.put("tt_app_id", "12");
        r160[6] = TuplesKt.to("X-Device-Info", CollectionsKt.joinToString$default(r164.entrySet(), com.alipay.sdk.m.u.i.f25853b, null, com.alipay.sdk.m.u.i.f25853b, 0, null, FlowPassportAccountsHttpClient$buildDeviceInfo$6.INSTANCE, 26, null));
        LinkedHashMap r171 = MapsKt.linkedMapOf(r160);
        Locale r172 = Locale.getDefault();
        String r173 = r172.getLanguage();
        Intrinsics.checkNotNull(r173);
        if ((!StringsKt.isBlank(r173)) == true) goto L167;
        r173 = null;
    L167:
        if (r173 == null) goto L174;
        String r174 = r172.getCountry();
        Intrinsics.checkNotNull(r174);
        if ((!StringsKt.isBlank(r174)) == true) goto L173;
        r174 = null;
    L173:
        if (r174 == null) goto L174;
        String r175 = r173 + '_' + r174;
        if (Intrinsics.areEqual(r175, "in_ID") == false) goto L178;
        r175 = "id_ID";
    L178:
        if (r175 == null) goto L180;
        r171.put("X-Locale", r175);
    L180:
        String r176 = r210.getUserUnit();
        if ((!StringsKt.isBlank(r176)) == true) goto L184;
        r176 = null;
    L184:
        if (r176 == null) goto L186;
        r171.put("X-Passport-Unit", r176);
        r171.put("X-Passport-Device-IDs", r176 + ':' + r151);
    L186:
        r171.put("X-Passport-Uni-Did", r151);
        if (com.ss.android.lark.passport.a.b() == false) goto L190;
        r171.put("x-passport-single-product", "7");
        r171.put("x-passport-from-source", "11");
    L190:
        if (com.ss.android.lark.passport.a.a() == true) goto L460;
    L207:
        a(r143, r171, "X-Flow-Key");
        a(r143, r171, "X-Verify-Token");
        a(r143, r171, "X-Proxy-Unit");
        if (r144 == true) goto L440;
    L254:
        r171.putAll(r139);
        if (r156 == false) goto L270;
        Set r177 = r171.keySet();
        if ((r177 instanceof Collection) == true) goto L259;
    L261:
        Iterator r178 = r177.iterator();
    L263:
        if (r178.hasNext() == false) goto L267;
        if (StringsKt.equals((String) r178.next(), "Content-Type", true) == false) goto L263;
        boolean r179 = false;
    L268:
        if (r179 == false) goto L270;
        r171.put("Content-Type", "application/json");
    L267:
        r179 = true;
        goto L268
    L259:
        if (r177.isEmpty() == false) goto L261;
    L270:
        final g r180 = new g(this.f437746a);
        final e r181 = new e(r155, r317, r171, r320, r211, r318, r414);
        r152.L$0 = r143;
        r152.L$1 = null;
        r152.L$2 = null;
        r152.L$3 = null;
        r152.L$4 = null;
        r152.L$5 = null;
        r152.L$6 = null;
        r152.L$7 = null;
        r152.label = 2;
        if ((!StringsKt.isBlank(r181.f437758c)) == false) goto L431;
        if (r181.f437759d <= 0) goto L275;
        boolean r182 = true;
    L276:
        if (r182 == false) goto L429;
        Result.Companion r183 = Result.Companion;     // Catch: Throwable -> L279
        Object r184 = Result.m9449constructorimpl(new URI(r181.f437756a));     // Catch: Throwable -> L279
    L282:
        if (Result.m9455isFailureimpl(r184) == false) goto L284;
        r184 = null;
    L284:
        URI r185 = (URI) r184;
        if (r185 != null) goto L287;
    L297:
        boolean r186 = false;
    L298:
        if (r186 == false) goto L427;
        if (StringsKt.equals(r185.getScheme(), "https", true) == false) goto L302;
    L305:
        boolean r187 = true;
    L306:
        if (r187 == false) goto L425;
        Iterator r188 = ((LinkedHashMap) r181.f437762g).entrySet().iterator();
    L309:
        if (r188.hasNext() == false) goto L324;
        Map.Entry r189 = (Map.Entry) r188.next();
        String r190 = (String) r189.getKey();
        String r191 = (String) r189.getValue();
        if (g.f437768b.matches(r190) == false) goto L323;
        if (StringsKt.contains$default(r191, '\r', false, 2, null) == false) goto L315;
    L317:
        boolean r192 = false;
    L318:
        if (r192 == true) goto L309;
        throw new IllegalArgumentException("Invalid HTTP header value".toString());
    L315:
        if (StringsKt.contains$default(r191, '\n', false, 2, null) == true) goto L317;
        r192 = true;
        goto L318
    L323:
        throw new IllegalArgumentException("Invalid HTTP header name".toString());
    L324:
        kotlinx.coroutines.j r193 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r152), 1);
        r193.C();
        final AtomicBoolean r194 = new AtomicBoolean(false);
        final AtomicReference r195 = new AtomicReference();
        UserSendHttpRequest.Builder r196 = new UserSendHttpRequest.Builder().url(r181.f437756a);
        switch(g.b.f437770a[r181.f437757b.ordinal()]) {
            case 1: goto L334;
            case 2: goto L333;
            case 3: goto L332;
            case 4: goto L331;
            case 5: goto L330;
            case 6: goto L329;
            case 7: goto L328;
            default: goto L327;
        };
    L328:
        HttpMethod r197 = HttpMethod.OPTIONS;
    L335:
        UserSendHttpRequest.Builder r198 = r196.method(r197);
        Map<String, String> r199 = r181.f437762g;
        ArrayList r1100 = new ArrayList(r199.size());
        Iterator r1101 = ((LinkedHashMap) r199).entrySet().iterator();
    L337:
        if (r1101.hasNext() == false) goto L339;
        Map.Entry r1102 = (Map.Entry) r1101.next();
        r1100.add(new HttpHeader((String) r1102.getKey(), (String) r1102.getValue()));
        r143 = r143;
        goto L337
    L339:
        String r321 = r143;
        UserSendHttpRequest.Builder r200 = r198.headers(new HttpHeaderMap(r1100)).request_id(r181.f437758c).timeout_s(Boxing.boxInt(r181.f437759d)).no_follow_redirection(Boxing.boxBoolean(!r181.f437760e)).disable_cookie(Boxing.boxBoolean(false));
        byte[] r1103 = r181.f437763h;
        if (r1103 == null) goto L342;
        r200.body(ByteString.a.e(ByteString.Companion, r1103));
    L342:
        l r1104 = r180.f437769a;
        Intrinsics.checkNotNull(r200);
        Disposable r201 = r1104.h(new com.bytedance.lark.rustclient.api.d(r200, UserSendHttpResponse.ADAPTER, Command.USER_SEND_HTTP, r181.f437758c, null, null, Boxing.boxBoolean(r181.f437761f), 112)).a().subscribe(new j(r194, r195, r193, r180, r181), new k(r194, r195, r193, r181));
        if (r194.get() == false) goto L345;
        r201.dispose();
    L350:
        r106 = null;
    L351:
        r193.i(new PassportRustHttpClient$execute$2$2(r194, r195, r180, r181));
        r102 = r193.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L355;
        DebugProbesKt.probeCoroutineSuspended(r152);
    L355:
        if (r102 != r103) goto L357;
        return r103;
    L357:
        r105 = r321;
        goto L358
    L345:
        r195.set(r201);
        if (r194.get() == false) goto L350;
        r106 = null;
        Disposable r202 = (Disposable) r195.getAndSet(null);
        if (r202 == null) goto L351;
        r202.dispose();
        goto L351
    L329:
        r197 = HttpMethod.HEAD;
        goto L335
    L330:
        r197 = HttpMethod.PATCH;
        goto L335
    L331:
        r197 = HttpMethod.PUT;
        goto L335
    L332:
        r197 = HttpMethod.DELETE;
        goto L335
    L333:
        r197 = HttpMethod.POST;
        goto L335
    L334:
        r197 = HttpMethod.GET;
        goto L335
    L327:
        throw new NoWhenBranchMatchedException();
    L425:
        throw new IllegalArgumentException("Passport HTTP URL must use HTTP or HTTPS".toString());
    L302:
        if (StringsKt.equals(r185.getScheme(), "http", true) == true) goto L305;
        r187 = false;
        goto L306
    L427:
        throw new IllegalArgumentException("Passport HTTP URL must be absolute".toString());
    L287:
        if (r185.isAbsolute() == false) goto L297;
        String r203 = r185.getHost();
        if (r203 != null) goto L291;
    L294:
        boolean r204 = true;
    L295:
        if (r204 == true) goto L297;
        r186 = true;
        goto L298
    L291:
        if (StringsKt.isBlank(r203) == true) goto L294;
        r204 = false;
    L279:
        th = move-exception;
        Result.Companion r205 = Result.Companion;
        r184 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L282
    L429:
        throw new IllegalArgumentException("timeoutSeconds must be greater than zero".toString());
    L275:
        r182 = false;
        goto L276
    L431:
        throw new IllegalArgumentException("requestId must not be blank".toString());
    L440:
        Object r206 = Result.m9449constructorimpl((IUserListService) e0c.k.a(LarkContext.getApplication(), IUserListService.class));     // Catch: Throwable -> L211
    L214:
        if (Result.m9455isFailureimpl(r206) == false) goto L216;
        r206 = null;
    L216:
        IUserListService r207 = (IUserListService) r206;
        if (r207 == null) goto L254;
        Object r208 = Result.m9449constructorimpl(r207.r());     // Catch: Throwable -> L221
    L224:
        if (Result.m9455isFailureimpl(r208) == false) goto L226;
        r208 = null;
    L226:
        List r209 = (List) r208;
        if (r209 != null) goto L229;
        r209 = CollectionsKt.emptyList();
    L229:
        ArrayList r212 = new ArrayList();
        Iterator r213 = r209.iterator();
    L231:
        if (r213.hasNext() == false) goto L238;
        String r214 = (String) r213.next();
        Intrinsics.checkNotNull(r214);
        if ((!StringsKt.isBlank(r214)) == true) goto L236;
        r214 = null;
    L236:
        if (r214 == null) goto L231;
        r212.add(r214);
        goto L231
    L238:
        List r215 = CollectionsKt.distinct(r212);
        if ((!r215.isEmpty()) == false) goto L254;
        Set r216 = r171.keySet();
        if ((r216 instanceof Collection) == true) goto L243;
    L245:
        Iterator r217 = r216.iterator();
    L247:
        if (r217.hasNext() == false) goto L251;
        if (StringsKt.equals((String) r217.next(), BaseHttpRequestInfo.KEY_COOKIE, true) == false) goto L247;
        boolean r218 = false;
    L252:
        if (r218 == false) goto L254;
        r171.put(BaseHttpRequestInfo.KEY_COOKIE, "session_list=" + CollectionsKt.joinToString$default(r215, "_", null, null, 0, null, null, 62, null) + ';');
    L251:
        r218 = true;
        goto L252
    L243:
        if (r216.isEmpty() == false) goto L245;
    L221:
        th = move-exception;
        Result.Companion r219 = Result.Companion;
        r208 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L211:
        th = move-exception;
        Result.Companion r220 = Result.Companion;
        r206 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L214
    L460:
        Object r221 = Result.m9449constructorimpl(LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getString("tt_env", ""));     // Catch: Throwable -> L194
    L197:
        if (Result.m9455isFailureimpl(r221) == false) goto L199;
        r221 = null;
    L199:
        String r222 = (String) r221;
        if (r222 == null) goto L207;
        if ((!StringsKt.isBlank(r222)) == true) goto L205;
        r222 = null;
    L205:
        if (r222 == null) goto L207;
        r171.put("x-tt-env", r222);
    L194:
        th = move-exception;
        Result.Companion r223 = Result.Companion;
        r221 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L174:
        r175 = null;
        goto L178
    L450:
        Object r224 = Result.m9449constructorimpl(r163.getPackageManager().getPackageInfo(r163.getPackageName(), 0).versionName);     // Catch: Throwable -> L150
    L153:
        if (Result.m9455isFailureimpl(r224) == false) goto L155;
        r224 = null;
    L155:
        r170 = (String) r224;
        if (r170 == null) goto L160;
        if ((!StringsKt.isBlank(r170)) == false) goto L160;
    L150:
        th = move-exception;
        Result.Companion r225 = Result.Companion;
        r224 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L153
    L145:
        r169 = "lark";
    L113:
        th = move-exception;
        Result.Companion r1105 = Result.Companion;
        r162 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L116
    L433:
        throw new IllegalArgumentException("Rust-managed auth and Passport common headers cannot be overridden".toString());
    L108:
        r159 = true;
        goto L109
    L99:
        if (r157.isEmpty() == false) goto L101;
    L435:
        throw new IllegalArgumentException("Passport request userId must not be blank".toString());
    L93:
        r156 = false;
        goto L95
    L89:
        r154 = CollectionsKt.joinToString$default(r140.entrySet(), "&", "?", null, 0, null, new FlowPassportAccountsHttpClient$toQueryString$1(this), 28, null);
        goto L90
    L437:
        throw new IllegalArgumentException("Passport accounts path must start with '/'".toString());
    L16:
        ResultKt.throwOnFailure(r102);
        gpb.a r226 = (gpb.a) ApiUtils.getApi(gpb.a.class);
        if (com.ss.android.lark.passport.a.a() == true) goto L442;
        Integer r227 = null;
    L34:
        if (r227 == null) goto L36;
        int r228 = r227.intValue();
        Intrinsics.checkNotNull(r226);
        gpb.a r1106 = new c(r226, r228);
    L37:
        r100.L$0 = r310;
        r100.L$1 = r311;
        r100.L$2 = r312;
        r100.L$3 = r313;
        r100.L$4 = r314;
        r100.L$5 = r315;
        r149 = r316;
        r100.L$6 = r149;
        r100.L$7 = r1106;
        r100.I$0 = r410;
        r100.Z$0 = r411;
        r100.Z$1 = r412;
        r100.label = 1;
        Result.Companion r229 = Result.Companion;     // Catch: Throwable -> L40
        Object r230 = Result.m9449constructorimpl((epb.a) ApiUtils.getApi(epb.a.class));     // Catch: Throwable -> L40
    L43:
        if (Result.m9455isFailureimpl(r230) == false) goto L45;
        r230 = null;
    L45:
        epb.a r231 = (epb.a) r230;
        if (r231 == null) goto L439;
        Object r232 = Result.m9449constructorimpl(r231.getDeviceIdFromLocal());     // Catch: Throwable -> L49
    L52:
        if (Result.m9455isFailureimpl(r232) == false) goto L54;
        r232 = null;
    L54:
        String r233 = (String) r232;
        if (r233 == null) goto L59;
        boolean r1107 = !StringsKt.isBlank(r233);
        Object r234 = r233;
        if (r1107 == false) goto L59;
    L60:
        if (r234 == null) goto L448;
    L81:
        if (r234 != r103) goto L83;
        return r103;
    L83:
        r143 = r310;
        r150 = r312;
        r140 = r313;
        r139 = r314;
        r144 = r412;
        r145 = r234;
        r138 = r315;
        r210 = r1106;
        r146 = r311;
        r148 = r410;
        r147 = r411;
        goto L84
    L448:
        Object r235 = Result.m9449constructorimpl(r231.getDeviceId());     // Catch: Throwable -> L64
    L67:
        if (Result.m9455isFailureimpl(r235) == false) goto L69;
        r235 = null;
    L69:
        String r236 = (String) r235;
        if (r236 == null) goto L74;
        int r237 = 1;
        boolean r1108 = !StringsKt.isBlank(r236);
        r234 = r236;
        if (r1108 == true) goto L76;
    L75:
        r234 = null;
    L76:
        if (r234 != null) goto L81;
        final kotlinx.coroutines.j r238 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), r237);
        r238.C();
        r231.getDeviceIdWithTimeout(LarkContext.getApplication(), new FlowPassportAccountsHttpClient$resolvePassportDeviceId$2$1(r238), 5000);
        r234 = r238.B();
        if (r234 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L81;
        DebugProbesKt.probeCoroutineSuspended(r100);
        goto L81
    L74:
        r237 = 1;
    L64:
        th = move-exception;
        Result.Companion r1109 = Result.Companion;
        r235 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L59:
        r234 = null;
    L49:
        th = move-exception;
        Result.Companion r1110 = Result.Companion;
        r232 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L439:
        throw new PassportHttpDeviceIdException("Passport device id service is unavailable");
    L40:
        th = move-exception;
        Result.Companion r239 = Result.Companion;
        r230 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L36:
        Intrinsics.checkNotNull(r226);
        r1106 = r226;
        goto L37
    L442:
        Result.Companion r240 = Result.Companion;     // Catch: Throwable -> L28
        Integer r241 = Integer.valueOf(LarkContext.getApplication().getSharedPreferences("office_sdk_env_prefs", 0).getInt("custom_env_value", -1));     // Catch: Throwable -> L28
        if (r241.intValue() == (-1)) goto L22;
        boolean r242 = true;
    L23:
        if (r242 == true) goto L26;
        r241 = null;
    L26:
        Object r243 = Result.m9449constructorimpl(r241);     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r243) == false) goto L33;
        r243 = null;
    L33:
        r227 = (Integer) r243;
        goto L34
    L22:
        r242 = false;
    L28:
        th = move-exception;
        Result.Companion r244 = Result.Companion;
        r243 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new FlowPassportAccountsHttpClient$executeAccounts$1(this, r413);
        goto L8
    }
}
