package com.ss.android.lark.passport;

import com.bytedance.apm.ApmAgent;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class PassportApmEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PassportApmEvent f437675a = null;

    static {
        f437675a = new PassportApmEvent();
    }

    public PassportApmEvent() {
    }

    public static com.bytedance.apm.config.d h(final String r100) {
        return A("office_sdk.passport.flow_runtime", 10000, "model_transform_start", new PassportApmEvent$flowRuntimeModelTransformStartEvent$1(r100));
    }

    public static com.bytedance.apm.config.d p(final String r100) {
        final String r101 = "first_party";
        Intrinsics.checkNotNullParameter("first_party", "type");
        return A("office_sdk.passport.mfa", 10000, "mfa_start", new PassportApmEvent$mfaStartEvent$1(r101, r100));
    }

    public static com.bytedance.apm.config.d y(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        com.bytedance.apm.config.d.a r101 = new com.bytedance.apm.config.d.a();
        r101.f190465a = "passport_office_event";
        JSONObject r102 = new JSONObject();
        r102.put(ReportCardMonitorPlugin.MONITOR_MESSAGE, "office_sdk_passport_net_start");
        r102.put("path", r100);
        r101.f190467c = r102;
        return new com.bytedance.apm.config.d(r101);
    }

    public final void q(Function1<? super PassportApmEvent, ? extends com.bytedance.apm.config.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        ApmAgent.monitorEvent(r100.invoke(this));
    }

    public static com.bytedance.apm.config.d B(final Object r100, final String r101) {
        return A("office_sdk.passport.common", 10000, "runtime_anomaly", new PassportApmEvent$runtimeAnomalyEvent$1(r100, r101));
    }

    public static com.bytedance.apm.config.d d(boolean r100, long r101) {
        com.bytedance.apm.config.d.a r102 = new com.bytedance.apm.config.d.a();
        r102.f190465a = "passport_office_event";
        JSONObject r103 = new JSONObject();
        r103.put(ReportCardMonitorPlugin.MONITOR_MESSAGE, "flow_passport_check_mfa_result");
        if (r100 == false) goto L5;
        String r104 = "success";
    L6:
        r103.put("result_type", r104);
        r103.put("duration", r101);
        r102.f190467c = r103;
        return new com.bytedance.apm.config.d(r102);
    L5:
        r104 = "fail";
        goto L6
    }

    public static com.bytedance.apm.config.d f(final String r100, final String r101) {
        return A("office_sdk.passport.flow_runtime", 10002, "event_handle_start", new PassportApmEvent$flowRuntimeEventHandleStartEvent$1(r100, r101));
    }

    public static com.bytedance.apm.config.d j(final String r100, final Boolean r101) {
        return A("office_sdk.passport.idp", 10004, "idp_dispatch_start", new PassportApmEvent$idpDispatchStartEvent$1(r100, r101));
    }

    public static com.bytedance.apm.config.d l(final String r100, final Boolean r101) {
        return A("office_sdk.passport.idp", 10000, "idp_prepare_start", new PassportApmEvent$idpPrepareStartEvent$1(r100, r101));
    }

    public static com.bytedance.apm.config.d n(final String r100, final Boolean r101) {
        return A("office_sdk.passport.idp", 10002, "idp_verify_start", new PassportApmEvent$idpVerifyStartEvent$1(r100, r101));
    }

    public static final void c(PassportApmEvent r100, JSONObject r101, boolean r102) {
        r100.getClass();
        if (r102 == false) goto L5;
        String r103 = "success";
    L6:
        r101.put("result_type", r103);
        return;
    L5:
        r103 = "fail";
        goto L6
    }

    public static com.bytedance.apm.config.d g(final boolean r100, final long r101, final String r102) {
        return A("office_sdk.passport.flow_runtime", 10001, "model_transform_result", new PassportApmEvent$flowRuntimeModelTransformResultEvent$1(r100, r101, r102));
    }

    public static com.bytedance.apm.config.d o(final boolean r100, final long r101, final String r110) {
        final String r102 = "first_party";
        Intrinsics.checkNotNullParameter("first_party", "type");
        return A("office_sdk.passport.mfa", 10001, "mfa_result", new PassportApmEvent$mfaResultEvent$1(r100, r101, r102, r110));
    }

    public static com.bytedance.apm.config.d z(String r100, boolean r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        com.bytedance.apm.config.d.a r103 = new com.bytedance.apm.config.d.a();
        r103.f190465a = "passport_office_event";
        JSONObject r104 = new JSONObject();
        r104.put(ReportCardMonitorPlugin.MONITOR_MESSAGE, "office_sdk_passport_online_result");
        if (r101 == false) goto L5;
        String r105 = "success";
    L6:
        r104.put("result_type", r105);
        r104.put("duration", r102);
        r104.put("lark_uid", r100);
        r103.f190467c = r104;
        return new com.bytedance.apm.config.d(r103);
    L5:
        r105 = "fail";
        goto L6
    }

    public static com.bytedance.apm.config.d A(String r100, int r101, String r102, Function1 r103) {
        com.bytedance.apm.config.d.a r104 = new com.bytedance.apm.config.d.a();
        r104.f190465a = "passport_office_event";
        JSONObject r105 = new JSONObject();
        r105.put(ReportCardMonitorPlugin.MONITOR_DOMAIN, r100);
        r105.put(ReportCardMonitorPlugin.MONITOR_CODE, r101);
        r105.put(ReportCardMonitorPlugin.MONITOR_MESSAGE, r102);
        r103.invoke(r105);
        r104.f190467c = r105;
        return new com.bytedance.apm.config.d(r104);
    }

    public static final void a(PassportApmEvent r100, JSONObject r101, String r102, String r103) {
        r100.getClass();
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        r101.put(r102, r103);
        return;
    L12:
        return;
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r104 = false;
        goto L9
    }

    public static final void b(PassportApmEvent r100, JSONObject r101, String r102, Object r103) {
        r100.getClass();
        if (r103 == null) goto L6;
        r101.put(r102, r103);
        return;
    }

    public static com.bytedance.apm.config.d e(final boolean r100, final long r101, final String r110, final String r111) {
        return A("office_sdk.passport.flow_runtime", 10003, "event_handle_result", new PassportApmEvent$flowRuntimeEventHandleResultEvent$1(r100, r101, r110, r111));
    }

    public static com.bytedance.apm.config.d i(final String r100, final Boolean r101, final boolean r102, final long r110) {
        return A("office_sdk.passport.idp", 10005, "idp_dispatch_result", new PassportApmEvent$idpDispatchResultEvent$1(r102, r110, r100, r101));
    }

    public static com.bytedance.apm.config.d k(final String r100, final Boolean r101, final boolean r102, final long r110) {
        return A("office_sdk.passport.idp", 10001, "idp_prepare_result", new PassportApmEvent$idpPrepareResultEvent$1(r102, r110, r100, r101));
    }

    public static com.bytedance.apm.config.d m(final String r100, final Boolean r101, final boolean r102, final long r110) {
        return A("office_sdk.passport.idp", 10003, "idp_verify_result", new PassportApmEvent$idpVerifyResultEvent$1(r102, r110, r100, r101));
    }

    public static com.bytedance.apm.config.d s(final String r100, final String r101, final String r102, final String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r100, "factorType");
        return A("office_sdk.passport.multi_verify", 10002, "challenge_start", new PassportApmEvent$multiVerifyChallengeStartEvent$1(r100, r101, r102, r110, r111));
    }

    public static com.bytedance.apm.config.d t(final String r100, final String r101, final String r102, final String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r100, "factorType");
        return A("office_sdk.passport.multi_verify", 10001, "factor_cancel", new PassportApmEvent$multiVerifyFactorCancelEvent$1(r100, r101, r102, r110, r111));
    }

    public static com.bytedance.apm.config.d u(final String r100, final String r101, final String r102, final String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r100, "factorType");
        return A("office_sdk.passport.multi_verify", 10000, "factor_enter", new PassportApmEvent$multiVerifyFactorEnterEvent$1(r100, r101, r102, r110, r111));
    }

    public static com.bytedance.apm.config.d w(final String r100, final String r101, final String r102, final String r110, final String r111) {
        Intrinsics.checkNotNullParameter(r100, "factorType");
        return A("office_sdk.passport.multi_verify", 10004, "verify_start", new PassportApmEvent$multiVerifyVerifyStartEvent$1(r100, r101, r102, r110, r111));
    }

    public static com.bytedance.apm.config.d x(String r100, boolean r101, long r102, Integer r103, String r110) {
        Intrinsics.checkNotNullParameter(r100, "path");
        com.bytedance.apm.config.d.a r104 = new com.bytedance.apm.config.d.a();
        r104.f190465a = "passport_office_event";
        JSONObject r105 = new JSONObject();
        r105.put(ReportCardMonitorPlugin.MONITOR_MESSAGE, "office_sdk_passport_net_result");
        if (r101 == false) goto L5;
        String r106 = "success";
    L6:
        r105.put("result_type", r106);
        r105.put("duration", r102);
        r105.put("http_code", r103);
        r105.put(CronetDataStorageAccess.LOGID, r110);
        r105.put("path", r100);
        r104.f190467c = r105;
        return new com.bytedance.apm.config.d(r104);
    L5:
        r106 = "fail";
        goto L6
    }

    public static com.bytedance.apm.config.d r(final String r110, final String r111, final String r112, final String r113, final String r114, final boolean r115, final long r116) {
        Intrinsics.checkNotNullParameter(r110, "factorType");
        return A("office_sdk.passport.multi_verify", 10003, "challenge_result", new PassportApmEvent$multiVerifyChallengeResultEvent$1(r115, r116, r110, r111, r112, r113, r114));
    }

    public static com.bytedance.apm.config.d v(final String r110, final String r111, final String r112, final String r113, final String r114, final boolean r115, final long r116) {
        Intrinsics.checkNotNullParameter(r110, "factorType");
        return A("office_sdk.passport.multi_verify", 10005, "verify_result", new PassportApmEvent$multiVerifyVerifyResultEvent$1(r115, r116, r110, r111, r112, r113, r114));
    }
}
