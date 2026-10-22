package com.ss.android.lark.conditional.access.traffic;

import com.bytedance.lark.pb.basic.v1.PushReqRegulateResponse;
import com.google.gson.Gson;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.passportc.api.g;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Singleton
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f418429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jdb.e f418430b;

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.traffic.a$a, reason: collision with other inner class name */
    public static final class C4920a {
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final j getPassport() {
        return this.f418429a;
    }

    @Inject
    public a(j r100, jdb.e r101) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "fgService");
        this.f418429a = r100;
        this.f418430b = r101;
    }

    public static final void a(a r110, byte[] r111) {
        r110.getClass();
        if (r111 != null) goto L5;
        ScsLogger.c("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "onPushReqRegulate: payload = null!");     // Catch: Exception -> L51
        return;
    L5:
        PushReqRegulateResponse r100 = PushReqRegulateResponse.ADAPTER.decode(r111);     // Catch: Exception -> L51
        if (r100 != null) goto L8;
        int r101 = ScsLogger.f440428a;     // Catch: Exception -> L51
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "onPushReqRegulate, response is empty, payload:" + r111);     // Catch: Exception -> L51
        return;
    L8:
        int r102 = ScsLogger.f440428a;     // Catch: Exception -> L51
        ScsLogger.d("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "[start receive push], onPushReqRegulate, x_lsc_code:" + r100.x_lsc_code + ", [logId:" + r100.x_tt_logid + "],x_lsc_bizid:" + r100.x_lsc_bizid + ", response.user_id:" + r100.x_user_id);     // Catch: Exception -> L51
        Long r103 = r100.x_user_id;     // Catch: Exception -> L51
        if (r103 == null) goto L16;
        if (r103.longValue() <= 0) goto L16;
        if (Intrinsics.areEqual(r100.x_user_id.toString(), r110.f418429a.g()) == true) goto L16;
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "response.x_user_id != passport.foregroundUid");     // Catch: Exception -> L51
        return;
    L16:
        if (r110.f418429a.d().f475024b.f475035a == UserState.ONLINE) goto L18;
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "passport.foregroundState.statePayload.state != UserState.ONLINE");     // Catch: Exception -> L51
        return;
    L18:
        Integer r104 = r100.x_lsc_code;     // Catch: Exception -> L51
        if (r104 != null) goto L22;
    L49:
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "onPushReqRegulate, response is not conditional access, x_lsc_code:" + r100.x_lsc_code);     // Catch: Exception -> L51
        return;
    L22:
        if (r104.intValue() != 100000) goto L49;
        ByteString r105 = r100.x_lsc_decision;     // Catch: Exception -> L51
        if (r105 == null) goto L29;
        String r106 = r105.utf8();     // Catch: Exception -> L51
        if (r106 == null) goto L29;
    L28:
        String r112 = r106;
        DecisionData r107 = (DecisionData) new Gson().fromJson(r112, DecisionData.class);     // Catch: Exception -> L51
        ScsLogger.d("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "[end receive push], onPushReqRegulate, decision:" + r112);     // Catch: Exception -> L51
        if (r107 == null) goto L33;
        LinkedList<DecisionData.Action> r108 = r107.getActions();     // Catch: Exception -> L51
    L34:
        int r109 = 0;
        if (r108 != null) goto L37;
    L40:
        boolean r113 = true;
    L41:
        if (r113 == true) goto L43;
        InternalSecurityAction r114 = new InternalSecurityAction(new SecurityAction(r112, null, 0, 0, 14, null), r107.getActions().get(0), r107.getActions());     // Catch: Exception -> L51
        r114.getInternalParams().put("SDK_MONITOR_TT_LOG_ID", r100.x_tt_logid);     // Catch: Exception -> L51
        RegulateDispatcher.a(r114, "RESPONSE_HEADER");     // Catch: Exception -> L51
        return;
    L43:
        StringBuilder r115 = new StringBuilder("onPushReqRegulate, action:");     // Catch: Exception -> L51
        if (r107 == null) goto L48;
        LinkedList<DecisionData.Action> r116 = r107.getActions();     // Catch: Exception -> L51
        if (r116 == null) goto L48;
        r109 = r116.size();     // Catch: Exception -> L51
    L48:
        r115.append(r109);     // Catch: Exception -> L51
        r115.append(", decision:");     // Catch: Exception -> L51
        r115.append(r112);     // Catch: Exception -> L51
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", r115.toString());     // Catch: Exception -> L51
        return;
    L37:
        if (r108.isEmpty() == true) goto L40;
        r113 = false;
        goto L41
    L33:
        r108 = null;
    L29:
        r106 = new DecisionData().toString();     // Catch: Exception -> L51
    L51:
        e = move-exception;
        int r117 = ScsLogger.f440428a;
        ScsLogger.c("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "onPushReqRegulate, encounter exception:" + e);
    }
}
