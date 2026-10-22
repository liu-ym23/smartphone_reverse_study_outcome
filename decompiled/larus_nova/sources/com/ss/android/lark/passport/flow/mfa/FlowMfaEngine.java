package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.PassportApmEvent;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.idp_auth.FlowIdpLoginResult;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class FlowMfaEngine {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f437821d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f437822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowMfaRepository f437823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f437824c;

    public static final class a {
    }

    static {
    }

    public final boolean b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        this.f437824c.getClass();
        Intrinsics.checkNotNullParameter(r110, "url");
        PassportLog.d("FlowMfaFlowRegistry", "handle external browser IdP applink start");
        if (StringsKt.isBlank(r110) == false) goto L149;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: url is blank");
        return false;
    L149:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        Object r111 = Result.m9449constructorimpl(UriProtector.parse(r110));     // Catch: Throwable -> L7
    L9:
        Throwable r101 = Result.m9452exceptionOrNullimpl(r111);
        if (r101 != null) goto L145;
        Uri r112 = (Uri) r111;
        if (StringsKt.equals("doubaolarkauth", r112.getScheme(), true) == true) goto L14;
    L18:
        boolean r102 = false;
    L19:
        PassportLog.d("FlowMfaFlowRegistry", "parse external browser IdP applink success: scheme=" + r112.getScheme() + ", host=" + r112.getHost() + ", path=" + r112.getPath() + ", isTargetApplink=" + r102);
        if (r102 == true) goto L22;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: route mismatch");
        return false;
    L22:
        String r113 = i.a(r112, "token");
        if (r113 != null) goto L25;
    L28:
        boolean r103 = true;
    L29:
        if (r103 == false) goto L31;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: token is blank");
        return false;
    L31:
        FlowIdpLoginResult.Companion.getClass();
        FlowIdpLoginResult r114 = FlowIdpLoginResult.a.a(r113, "external_browser_token");
        if (r114 != null) goto L34;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: decode token failed");
        return false;
    L34:
        String r104 = r114.getState();
        Context r105 = null;
        if (r104 != null) goto L37;
    L39:
        r104 = null;
    L40:
        if (r104 != null) goto L42;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: state is blank");
        return false;
    L42:
        ConcurrentHashMap<String, FlowMfaFlowSession> r106 = o.f437909a;
        Intrinsics.checkNotNullParameter(r104, "state");
        if (StringsKt.isBlank(r104) == false) goto L45;
        PassportLog.b("FlowMfaRuntime", "find BIDP session failed: state is blank");
        FlowMfaFlowSession r107 = null;
    L69:
        if (r107 != null) goto L71;
        PassportLog.b("FlowMfaFlowRegistry", "handle external browser IdP applink failed: session not found");
        return false;
    L71:
        PassportLog.d("FlowMfaFlowRegistry", "external browser IdP session found");
    L72:
        com.ss.android.lark.passport.flow.mfa.a r108 = r107.f437851v.get();
        int r109 = FlowMfaFlowSession.b.f437853a[r108.f437883a.ordinal()];
        if (r109 != 1) goto L75;
    L86:
        boolean r115 = false;
    L88:
        if (r115 == false) goto L89;
        com.ss.android.lark.passport.flow.mfa.a r116 = com.ss.android.lark.passport.flow.mfa.a.a(r108, ExternalBidpCallbackPhase.DISPATCHING);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r117 = r107.f437851v;
    L92:
        if (r117.compareAndSet(r108, r116) == true) goto L93;
        if (r117.get() == r108) goto L92;
        boolean r118 = false;
    L97:
        if (r118 == false) goto L72;
        PassportLog.d("FlowMfaSession", "begin external BIDP dispatch success: previousPhase=" + r108.f437883a + ", attempt=" + r108.f437884b);
        boolean r119 = true;
    L99:
        if (r119 == true) goto L101;
        PassportLog.b("FlowMfaFlowRegistry", "external browser IdP callback rejected by callback state");
        return false;
    L101:
        WeakReference<Activity> r120 = r107.f437843n.get();
        if (r120 == null) goto L110;
        Activity r121 = r120.get();
        if (r121 == null) goto L110;
        if (FlowMfaFlowSession.p(r121) == false) goto L108;
        r105 = r121;
    L108:
        if (r105 == null) goto L110;
    L111:
        StringBuilder r122 = new StringBuilder("launch external browser IdP verify activity: context=");
        r122.append(r105.getClass().getSimpleName());
        r122.append(", fromActivity=");
        boolean r123 = r105 instanceof Activity;
        r122.append(r123);
        PassportLog.d("FlowMfaFlowRegistry", r122.toString());
        FlowMfaSsoVerifyActivity.a r124 = FlowMfaSsoVerifyActivity.f437862h;
        String r125 = r107.f437830a;
        r124.getClass();
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r125, "flowId");
        Intrinsics.checkNotNullParameter(r114, "loginResult");
        PassportLog.d("FlowMfaSsoVerify", "launch start: context=" + r105.getClass().getSimpleName() + ", fromActivity=" + r123);
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L117
        Intent r127 = new Intent(r105, FlowMfaSsoVerifyActivity.class);     // Catch: Throwable -> L117
        if ((r105 instanceof Activity) == true) goto L115;
        r127.addFlags(268435456);     // Catch: Throwable -> L117
    L115:
        r127.addFlags(65536);     // Catch: Throwable -> L117
        p.a(r127);     // Catch: Throwable -> L117
        r127.putExtra("flow_mfa_flow_id", r125);     // Catch: Throwable -> L117
        r127.putExtra("flow_mfa_login_result", r114);     // Catch: Throwable -> L117
        r105.startActivity(r127);     // Catch: Throwable -> L117
        Object r128 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L117
    L120:
        if (Result.m9456isSuccessimpl(r128) == false) goto L122;
        ((Boolean) r128).booleanValue();
        PassportLog.d("FlowMfaSsoVerify", "launch request accepted");
    L122:
        Throwable r129 = Result.m9452exceptionOrNullimpl(r128);
        if (r129 == null) goto L125;
        PassportLog.b("FlowMfaSsoVerify", "launch failed: ".concat(r129.getClass().getSimpleName()));
    L125:
        Boolean r130 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r128) == false) goto L128;
        r128 = r130;
    L128:
        boolean r131 = ((Boolean) r128).booleanValue();
        if (r131 == false) goto L131;
        PassportLog.d("FlowMfaFlowRegistry", "external browser IdP verify activity launched");
    L178:
        return r131;
    L131:
        com.ss.android.lark.passport.flow.mfa.a r132 = r107.f437851v.get();
        if (r132.f437883a != ExternalBidpCallbackPhase.DISPATCHING) goto L143;
        com.ss.android.lark.passport.flow.mfa.a r133 = com.ss.android.lark.passport.flow.mfa.a.a(r132, ExternalBidpCallbackPhase.WAITING_CALLBACK);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r134 = r107.f437851v;
    L136:
        if (r134.compareAndSet(r132, r133) == true) goto L137;
        if (r134.get() == r132) goto L136;
        boolean r135 = false;
    L141:
        if (r135 == false) goto L131;
        PassportLog.d("FlowMfaSession", "release external BIDP callback reservation: attempt=" + r132.f437884b);
        goto L143
    L137:
        r135 = true;
    L143:
        PassportLog.b("FlowMfaFlowRegistry", "launch external browser IdP verify activity failed");
    L117:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L110:
        r105 = LarkContext.getApplication();
        goto L111
    L93:
        r118 = true;
        goto L97
    L89:
        PassportLog.b("FlowMfaSession", "begin external BIDP dispatch failed: phase=" + r108.f437883a + ", attempt=" + r108.f437884b);
        r119 = false;
        goto L99
    L75:
        if (r109 != 2) goto L77;
    L85:
        r115 = true;
        goto L88
    L77:
        if (r109 == 3) goto L85;
        if (r109 == 4) goto L86;
        if (r109 == 5) goto L86;
        throw new NoWhenBranchMatchedException();
    L45:
        StringBuilder r137 = new StringBuilder("find BIDP session start: sessionCount=");
        ConcurrentHashMap<String, FlowMfaFlowSession> r138 = o.f437909a;
        r137.append(r138.size());
        PassportLog.d("FlowMfaRuntime", r137.toString());
        Iterator<T> r139 = r138.values().iterator();
    L47:
        if (r139.hasNext() == false) goto L64;
        Object r140 = r139.next();
        FlowMfaFlowSession r141 = (FlowMfaFlowSession) r140;
        r141.getClass();
        Intrinsics.checkNotNullParameter(r104, "state");
        String r142 = r141.f437839j.get();
        if ((!StringsKt.isBlank(r104)) == true) goto L51;
    L53:
        boolean r143 = false;
    L54:
        StringBuilder r144 = new StringBuilder("match BIDP state: hasExpectedState=");
        if (r142 != null) goto L57;
    L60:
        boolean r145 = true;
    L61:
        r144.append(!r145);
        r144.append(", matches=");
        r144.append(r143);
        PassportLog.d("FlowMfaSession", r144.toString());
        if (r143 == false) goto L47;
    L65:
        r107 = (FlowMfaFlowSession) r140;
        if (r107 == null) goto L68;
        PassportLog.d("FlowMfaRuntime", "find BIDP session success");
        goto L69
    L68:
        PassportLog.b("FlowMfaRuntime", "find BIDP session failed: no matching session");
        goto L69
    L57:
        if (StringsKt.isBlank(r142) == true) goto L60;
        r145 = false;
        goto L61
    L51:
        if (Intrinsics.areEqual(r142, r104) == false) goto L53;
        r143 = true;
        goto L54
    L64:
        r140 = null;
        goto L65
    L37:
        if ((!StringsKt.isBlank(r104)) == false) goto L39;
    L25:
        if (StringsKt.isBlank(r113) == true) goto L28;
        r103 = false;
        goto L29
    L14:
        if (StringsKt.equals(BytedCertConstant.CertKey.FLOW, r112.getHost(), true) == false) goto L18;
        if (Intrinsics.areEqual("/officesdk/passport/sso", r112.getPath()) == false) goto L18;
        r102 = true;
        goto L19
    L145:
        PassportLog.c("FlowMfaFlowRegistry", "parse external browser IdP applink failed", r101);
        return false;
    L7:
        th = move-exception;
        Result.Companion r146 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final void d(final FlowMfaError r100) {
        PassportApmEvent.f437675a.q(new FlowMfaEngine$reportRuntimeAnomaly$1(this, r100));
    }

    @Inject
    public FlowMfaEngine(String r100, FlowMfaRepository r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "repository");
        Intrinsics.checkNotNullParameter(r102, "flowRegistry");
        this.f437822a = r100;
        this.f437823b = r101;
        this.f437824c = r102;
    }

    public static void c(final boolean r100, final long r101, final String r102) {
        PassportApmEvent.f437675a.q(new FlowMfaEngine$reportMfaResult$1(r100, r101, r102));
    }

    public final Object a(String r100, String r101, Continuation<? super Result<? extends FlowMfaTokenStatus>> r102) {
        if ((r102 instanceof FlowMfaEngine$checkToken$1) == false) goto L7;
        FlowMfaEngine$checkToken$1 r103 = (FlowMfaEngine$checkToken$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        final long r108 = r103.J$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
    L32:
        Object r109 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L14
        PassportApmEvent.f437675a.q(new FlowMfaEngine$checkToken$4$1(r108));     // Catch: Throwable -> L14
        return r109;
    L14:
        Throwable th10 = th;
        final long r110 = r108;
    L37:
        PassportLog.e("FlowMfaEngine", "check MFA token failed: ".concat(th10.getClass().getSimpleName()));
        FlowMfaError r111 = g.a(th10);
        PassportApmEvent.f437675a.q(new FlowMfaEngine$checkToken$5(r110));
        d(r111);
        Result.Companion r112 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new FlowMfaException(r111)));
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        r110 = System.currentTimeMillis();
        PassportApmEvent r113 = PassportApmEvent.f437675a;
        r113.q(FlowMfaEngine$checkToken$2.INSTANCE);
        if (StringsKt.isBlank(r100) == false) goto L22;
        FlowMfaError r114 = g.c("MFA scope must not be blank");
    L25:
        if (r114 == null) goto L41;
        r113.q(new FlowMfaEngine$checkToken$3(r110));
        d(r114);
        Result.Companion r115 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new FlowMfaException(r114)));
    L41:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L35
        FlowMfaRepository r117 = this.f437823b;     // Catch: Throwable -> L35
        String r118 = this.f437822a;     // Catch: Throwable -> L35
        r103.J$0 = r110;     // Catch: Throwable -> L35
        r103.label = 1;     // Catch: Throwable -> L35
        r105 = r117.c(r118, r100, r101, r103);     // Catch: Throwable -> L35
        if (r105 != r106) goto L31;
        return r106;
    L31:
        r108 = r110;
    L35:
        th = move-exception;
        th10 = th;
        goto L37
    L22:
        if (StringsKt.isBlank(r101) == false) goto L24;
        r114 = g.c("MFA token must not be blank");
        goto L25
    L24:
        r114 = null;
    L7:
        r103 = new FlowMfaEngine$checkToken$1(this, r102);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaRepository] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v2, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v4, types: [long] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.android.lark.passport.flow.mfa.h] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.ss.android.lark.passport.flow.mfa.h] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaEngine$startFirstParty$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4, types: [long] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [long] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31, types: [long] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object e(Activity r210, String r211, JSONObject r212, Continuation<? super Result<q>> r213) {
        final ?? r100 = r211;
        if ((r213 instanceof FlowMfaEngine$startFirstParty$1) == false) goto L7;
        FlowMfaEngine$startFirstParty$1 r101 = (FlowMfaEngine$startFirstParty$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
        ?? r103 = r101;
    L8:
        Object r104 = r103.result;
        ?? r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        ?? r107 = 4;
        r107 = 4;
        ?? r108 = 1;
        ?? r110 = 2;
        if (r106 == 0) goto L41;
        if (r106 == 1) goto L36;
        if (r106 != 2) goto L134;
        int r109 = r103.I$0;
        long r111 = r103.J$0;
        FlowMfaFlowSession r112 = (FlowMfaFlowSession) r103.L$2;
        String r113 = (String) r103.L$1;
        Activity r114 = (Activity) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L33
        ?? r115 = r109;
        r110 = r113;
        long r116 = r111;
    L32:
        r107 = r112;
        j r117 = (j) r104;     // Catch: Throwable -> L101
        if (Intrinsics.areEqual(r117, j.b.f437899a) == false) goto L80;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L91
        Deferred r119 = r107.f437834e;     // Catch: Throwable -> L91
        r103.L$0 = r110;     // Catch: Throwable -> L91
        r103.L$1 = r107;     // Catch: Throwable -> L91
        r103.L$2 = null;     // Catch: Throwable -> L91
        r103.J$0 = r116;     // Catch: Throwable -> L91
        r103.I$0 = 1;     // Catch: Throwable -> L91
        r103.label = 3;     // Catch: Throwable -> L91
        r104 = r119.await(r103);     // Catch: Throwable -> L91
        if (r104 != r105) goto L74;
        return r105;
    L74:
        ?? r120 = r110;
        long r121 = r116;
        int r122 = 1;
        ?? r123 = r107;
    L75:
        Object r124 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L77
        c(true, r121, r120);     // Catch: Throwable -> L77
        r100 = r122;
        r103 = r120;
        r105 = r121;
        r107 = r123;
    L122:
    L114:
        this.f437824c.a(r107);
        return r124;
    L80:
        if ((r117 instanceof j.d) == false) goto L94;
        MainCoroutineDispatcher r125 = Dispatchers.getMain();     // Catch: Throwable -> L101
        FlowMfaEngine$startFirstParty$4 r126 = new FlowMfaEngine$startFirstParty$4(r114, r107, null);     // Catch: Throwable -> L101
        r103.L$0 = r110;     // Catch: Throwable -> L101
        r103.L$1 = r107;     // Catch: Throwable -> L101
        r103.L$2 = null;     // Catch: Throwable -> L101
        r103.J$0 = r116;     // Catch: Throwable -> L101
        r103.I$0 = r115;     // Catch: Throwable -> L101
        r103.label = 4;     // Catch: Throwable -> L101
        ?? r127 = r107;
        ?? r128 = r110;
        ?? r129 = r116;
        if (BuildersKt.withContext(r125, r126, r103) != r105) goto L84;
        return r105;
    L84:
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L91
        Deferred r131 = r127.f437834e;     // Catch: Throwable -> L91
        r103.L$0 = r128;     // Catch: Throwable -> L91
        r103.L$1 = r127;     // Catch: Throwable -> L91
        r103.J$0 = r129;     // Catch: Throwable -> L91
        r103.I$0 = 1;     // Catch: Throwable -> L91
        r103.label = 5;     // Catch: Throwable -> L91
        r104 = r131.await(r103);     // Catch: Throwable -> L91
        if (r104 != r105) goto L87;
        return r105;
    L87:
        ?? r132 = r128;
        ?? r133 = r129;
        int r134 = 1;
        ?? r135 = r127;
    L88:
        r124 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L77
        c(true, r133, r132);     // Catch: Throwable -> L77
        r100 = r134;
        r103 = r132;
        r105 = r133;
        r107 = r135;
        goto L122
    L94:
        if ((r117 instanceof j.c) == false) goto L97;
        c(false, r116, r110);     // Catch: Throwable -> L101
        d(((j.c) r117).f437900a);     // Catch: Throwable -> L101
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L101
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(new FlowMfaException(((j.c) r117).f437900a)));     // Catch: Throwable -> L101
        goto L114
    L97:
        if ((r117 instanceof j.a) == false) goto L100;
        FlowMfaError r137 = g.b("Unexpected MFA code apply result", null);     // Catch: Throwable -> L101
        c(false, r116, r110);     // Catch: Throwable -> L101
        d(r137);     // Catch: Throwable -> L101
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L101
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(new FlowMfaException(r137)));     // Catch: Throwable -> L101
        goto L114
    L100:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L101
    L101:
        th = th;
        r108 = r115;
    L103:
        ?? r139 = r107;
        ?? r140 = r108;
        ?? r141 = r110;
        long r142 = r116;
    L35:
        ?? r143 = r142;
        ?? r144 = r140;
        ?? r145 = r139;
        ?? r146 = r141;
    L104:
        r100 = r144;
    L132:
        PassportLog.e("FlowMfaEngine", "start first-party MFA failed: " + th.getClass().getSimpleName());     // Catch: Throwable -> L116
        FlowMfaError r147 = g.a(th);     // Catch: Throwable -> L116
        c(false, r143, r146);     // Catch: Throwable -> L116
        if (r100 != 0) goto L112;
        d(r147);     // Catch: Throwable -> L116
    L112:
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L116
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(new FlowMfaException(r147)));     // Catch: Throwable -> L116
        r107 = r145;
    L116:
        th = move-exception;
        this.f437824c.a(r145);
        throw th;
    L33:
        th = th;
        r140 = r109;
        r139 = r112;
        r141 = r113;
        r142 = r111;
        goto L35
    L134:
        if (r106 == 3) goto L25;
        if (r106 == 4) goto L20;
        if (r106 != 5) goto L19;
        int r149 = r103.I$0;
        long r150 = r103.J$0;
        FlowMfaFlowSession r151 = (FlowMfaFlowSession) r103.L$1;
        String r152 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L28
        r134 = r149;
        r132 = r152;
        r133 = r150;
        r135 = r151;
        goto L88
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r100 = r103.I$0;
        r143 = r103.J$0;
        r145 = (FlowMfaFlowSession) r103.L$1;
        r146 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L23
        r129 = r143;
        r127 = r145;
        r128 = r146;
    L23:
        th = th;
        goto L132
    L25:
        int r153 = r103.I$0;
        long r154 = r103.J$0;
        FlowMfaFlowSession r155 = (FlowMfaFlowSession) r103.L$1;
        String r156 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L28
        r122 = r153;
        r120 = r156;
        r121 = r154;
        r123 = r155;
    L28:
        th = th;
        r146 = r103;
        r145 = 4;
        r143 = r105;
        goto L132
    L36:
        int r157 = r103.I$0;
        long r158 = r103.J$0;
        r112 = (FlowMfaFlowSession) r103.L$2;
        String r159 = (String) r103.L$1;
        Activity r160 = (Activity) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L39
        Activity r161 = r160;
        r100 = r157;
        long r162 = r158;
        ?? r163 = r159;
    L135:
        r103.L$0 = r161;     // Catch: Throwable -> L105
        r103.L$1 = r163;     // Catch: Throwable -> L105
        r103.L$2 = r112;     // Catch: Throwable -> L105
        r103.J$0 = r162;     // Catch: Throwable -> L105
        r103.I$0 = r100;     // Catch: Throwable -> L105
        r103.label = 2;     // Catch: Throwable -> L105
        r104 = r112.o((FlowStep) r104);     // Catch: Throwable -> L105
        if (r104 != r105) goto L68;
        return r105;
    L68:
        r110 = r163;
        r114 = r161;
        r115 = r100;
        r116 = r162;
    L105:
        th = th;
        r145 = r112;
        r143 = r162;
        r146 = r163;
    L39:
        th = th;
        r144 = r157;
        r145 = r112;
        r143 = r158;
        r146 = r159;
        goto L104
    L41:
        ResultKt.throwOnFailure(r104);
        long r164 = System.currentTimeMillis();
        PassportApmEvent.f437675a.q(new FlowMfaEngine$startFirstParty$2(r100));
        if (StringsKt.isBlank(r211) == false) goto L44;
        FlowMfaError r165 = g.c("MFA scope must not be blank");
    L45:
        if (r165 == null) goto L48;
        c(false, r164, r100);
        d(r165);
        Result.Companion r166 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new FlowMfaException(r165)));
    L48:
        h r167 = this.f437824c;
        String r168 = this.f437822a;
        FlowMfaRepository r169 = this.f437823b;
        r167.getClass();
        Intrinsics.checkNotNullParameter(r168, "userId");
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r169, "repository");
        FlowMfaFlowSession r170 = new FlowMfaFlowSession(UUID.randomUUID().toString(), r168, r100, r169);
        AtomicReference<FlowMfaFlowSession> r171 = r167.f437897a;
    L50:
        if (r171.compareAndSet(null, r170) == true) goto L51;
        if (r171.get() == null) goto L50;
        boolean r172 = false;
    L55:
        if (r172 == false) goto L57;
        ConcurrentHashMap<String, FlowMfaFlowSession> r173 = o.f437909a;
        Intrinsics.checkNotNullParameter(r170, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        ConcurrentHashMap<String, FlowMfaFlowSession> r174 = o.f437909a;
        r174.put(r170.f437830a, r170);
        PassportLog.d("FlowMfaRuntime", "register session success: sessionCount=" + r174.size());
        AtomicReference<syb.b> r175 = r170.f437850u;
        AtomicReference<syb.b> r176 = com.ss.android.lark.passport.flow.core.router.a.f437790c;
        r175.set(com.ss.android.lark.passport.flow.core.router.a.f437790c.getAndSet(r170.f437852w));
    L58:
        if (r170 != null) goto L125;
        int r177 = g.f437896a;
        FlowMfaError r178 = new FlowMfaError(FlowMfaErrorCategory.BUSY, "MFA flow is already running", null, null, null, null, 60, null);
        c(false, r164, r100);
        d(r178);
        Result.Companion r179 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new FlowMfaException(r178)));
    L125:
        ?? r180 = this.f437823b;     // Catch: Throwable -> L107
        String r181 = this.f437822a;     // Catch: Throwable -> L107
        r161 = r210;
        r103.L$0 = r161;     // Catch: Throwable -> L107
        r103.L$1 = r100;     // Catch: Throwable -> L107
        r103.L$2 = r170;     // Catch: Throwable -> L107
        r103.J$0 = r164;     // Catch: Throwable -> L107
        r103.I$0 = 0;     // Catch: Throwable -> L107
        r103.label = 1;     // Catch: Throwable -> L107
        r104 = r180.b(r181, r100, r212, r103);     // Catch: Throwable -> L107
        if (r104 != r105) goto L64;
        return r105;
    L64:
        r112 = r170;
        r163 = r100;
        r100 = 0;
        r162 = r164;
    L107:
        th = th;
        r146 = r100;
        r143 = r164;
        r145 = r170;
        r100 = 0;
        goto L132
    L57:
        r170 = null;
        goto L58
    L51:
        r172 = true;
        goto L55
    L44:
        r165 = null;
    L77:
        th = th;
        r145 = r107;
        r143 = r105;
        r146 = r103;
    L91:
        th = th;
    L7:
        r103 = new FlowMfaEngine$startFirstParty$1(this, r213);
        goto L8
    }
}
