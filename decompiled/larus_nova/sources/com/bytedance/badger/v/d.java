package com.bytedance.badger.v;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends v {
    public static final g A = null;
    public static final g B = null;
    public static final m C = null;
    public static final g D = null;
    public static final f E = null;
    public static final j F = null;
    public static final f G = null;
    public static final g H = null;
    public static final h I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final i f199310J = null;
    public static final l K = null;
    public static final g L = null;
    public static final f M = null;
    public static final k N = null;
    public static final h O = null;
    public static final h P = null;
    public static final f Q = null;
    public static final h R = null;
    public static final k S = null;
    public static final k T = null;
    public static final m U = null;
    public static final m V = null;
    public static final f W = null;
    public static final k X = null;
    public static final m Y = null;
    public static final h Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199311a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final h f199312a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile JSONObject f199313b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final k f199314b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile y64.a f199315c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final f f199316c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f199317d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final g f199318d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f199319e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final f f199320e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g f199321f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final d f199322f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f199323g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f199324h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g f199325i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m f199326j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f199327k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f f199328l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g f199329m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final g f199330n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final g f199331o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final g f199332p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g f199333q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final f f199334r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final f f199335s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final l f199336t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final h f199337u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final h f199338v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final h f199339w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f f199340x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final h f199341y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final h f199342z = null;

    public d() {
    }

    public static w f() {
        g r100 = f199321f;
        KProperty r101 = f199311a[2];
        return (w) r100.a();
    }

    public static boolean g() {
        f r100 = f199317d;
        KProperty r101 = f199311a[0];
        return ((Boolean) r100.a()).booleanValue();
    }

    static {
        f199311a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableBadger", "getEnableBadger()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "configVersion", "getConfigVersion()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "detectorFullCollectTimeout", "getDetectorFullCollectTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "startupCompensateTimeout", "getStartupCompensateTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "compensateExpireTimeSeconds", "getCompensateExpireTimeSeconds()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "reportMinIntervalSeconds", "getReportMinIntervalSeconds()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableReportIfLoginFailed", "getEnableReportIfLoginFailed()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "devicefp1BindTimeout", "getDevicefp1BindTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "pseudoCodeTimeout", "getPseudoCodeTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "realTimeReportPaths", "getRealTimeReportPaths()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "disabledFeatures", "getDisabledFeatures()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableBadgerPreLoginReport", "getEnableBadgerPreLoginReport()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerLoginReportInterval", "getBadgerLoginReportInterval()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerNotLoginReportInterval", "getBadgerNotLoginReportInterval()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerLoginReportDelay", "getBadgerLoginReportDelay()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerNotLoginReportDelay", "getBadgerNotLoginReportDelay()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerFirstReportTimeout", "getBadgerFirstReportTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableLoginCompensate", "getEnableLoginCompensate()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerEnablePreLoginImmediateReport", "getBadgerEnablePreLoginImmediateReport()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerEnableBackgroundReport", "getBadgerEnableBackgroundReport()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "fConfig", "getFConfig()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "metricsMonitorSampleRate", "getMetricsMonitorSampleRate()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "trackMonitorSampleRate", "getTrackMonitorSampleRate()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerCollectSampleRate", "getBadgerCollectSampleRate()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableReportUploadRetry", "getEnableReportUploadRetry()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "reportUploadImmediatelyRetryCount", "getReportUploadImmediatelyRetryCount()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "reportUploadRetryCount", "getReportUploadRetryCount()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "reportUploadRetryWaitTime", "getReportUploadRetryWaitTime()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerBootReportTimeThreshold", "getBadgerBootReportTimeThreshold()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerUserActionPaths", "getBadgerUserActionPaths()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerRequestTakingTooLongThreshold", "getBadgerRequestTakingTooLongThreshold()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerEnableLocalStorage", "getBadgerEnableLocalStorage()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "disableCompensationTypes", "getDisableCompensationTypes()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "deviceFp1UseV3", "getDeviceFp1UseV3()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "deviceFp1TaskMaxTime", "getDeviceFp1TaskMaxTime()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "deviceFp1ProviderType", "getDeviceFp1ProviderType()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "deviceFp1RetryInterval", "getDeviceFp1RetryInterval()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "mobileChannelId", "getMobileChannelId()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "xiaomiTimeout", "getXiaomiTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "uuidUseFast", "getUuidUseFast()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "sensorTimeout", "getSensorTimeout()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "sensorMaxSampleSize", "getSensorMaxSampleSize()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "sensorSampleDelay", "getSensorSampleDelay()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableLoginReport", "getEnableLoginReport()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "loginGetReportTimeout", "getLoginGetReportTimeout()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "reportSizeThreshold", "getReportSizeThreshold()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "badgerLoginUpdateInterval", "getBadgerLoginUpdateInterval()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "loginUpdateReportBlackPaths", "getLoginUpdateReportBlackPaths()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "loginUpdateReportPaths", "getLoginUpdateReportPaths()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableEventReport", "getEnableEventReport()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "sensorDataInterval", "getSensorDataInterval()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "triggerReportEvents", "getTriggerReportEvents()Ljava/util/Collection;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "touchMaxCount", "getTouchMaxCount()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "eventKeyMaxCount", "getEventKeyMaxCount()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "sensorMaxGroupCount", "getSensorMaxGroupCount()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableRecordSensor", "getEnableRecordSensor()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "serviceBindTimeout", "getServiceBindTimeout()Lcom/bytedance/badger/config/SimpleDuration;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(d.class), "enableServerTimeV2", "getEnableServerTimeV2()Z"))};
        d r100 = new d();
        f199322f0 = r100;
        f199315c = new y64.a();
        f199317d = new f(r100, "enable_badger_detector", a.f199307a);
        f199319e = new l(r100, "config_version", new t("<default>"));
        TimeUnit r101 = TimeUnit.MILLISECONDS;
        f199321f = r100.b("detector_full_collect_timeout", 30000, r101);
        r100.b("startup_compensate_timeout", 10000, r101);
        TimeUnit r102 = TimeUnit.SECONDS;
        r100.b("compensate_expire_time_seconds", TimeUtils.SECONDS_PER_HOUR, r102);
        r100.b("report_main_interval_seconds", 10, r102);
        f199323g = r100.a("enable_report_if_login_failed", false);
        f199324h = r100.b("devicefp1_bind_timeout", 15000, r101);
        f199325i = r100.b("pseudo_code_timeout", 15000, r101);
        f199326j = r100.e("detector_report_paths", CollectionsKt.listOf(new String[]{"/passport/mobile/login/", "/passport/mobile/sms_login/", "/passport/auth/login/", "/passport/user/recall_login/", "/passport/password/reset_by_ticket/", "/passport/auth/one_login_with_mask_mobile/", "/passport/auth/one_login/", "/passport/auth/share_login/"}));
        f199327k = r100.e("disabled_feature_ids", CollectionsKt.emptyList());
        f199328l = new f(r100, "enable_badger_pre_login_report", b.f199308a);
        f199329m = r100.b("badger_login_report_interval", TimeUtils.SECONDS_PER_HOUR, r102);
        f199330n = r100.b("badger_not_login_report_interval", 1800, r102);
        f199331o = r100.b("badger_login_report_delay", 30, r102);
        f199332p = r100.b("badger_not_login_report_delay", 15, r102);
        f199333q = r100.b("badger_first_report_timeout", 3000, r101);
        r100.a("enable_login_compensate", false);
        f199334r = r100.a("badger_enable_pre_login_immediate_report", false);
        f199335s = r100.a("badger_enable_background_report", false);
        f199336t = new l(r100, "f_config", c.f199309a);
        f199337u = r100.c(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, 1000);
        f199338v = r100.c("track_sample_rate", 0);
        f199339w = r100.c("badger_collect_sample_rate", 0);
        f199340x = r100.a("enable_report_upload_retry", false);
        f199341y = r100.c("report_upload_immediately_retry_count", 1);
        f199342z = r100.c("report_upload_retry_count", 5);
        A = r100.b("report_upload_retry_wait_time", 30, r102);
        B = r100.b("badger_boot_report_time_threshold", 50, r102);
        C = r100.e("badger_user_action_paths", CollectionsKt.emptyList());
        D = r100.b("badger_request_taking_too_long_threshold", 15000, r101);
        E = r100.a("badger_enable_local_storage", false);
        F = new j(r100, new r(CollectionsKt.emptyList()));
        G = r100.a("devicefp1_use_v3", true);
        H = r100.b("devicefp1_task_max_time", 60000, r101);
        I = r100.c("devicefp1_provider_type", 0);
        f199310J = new i(r100, new q(CollectionsKt.listOf(new Integer[]{10, 40, 200})));
        K = new l(r100, "mobile_channel_id", new t("C10000001070"));
        L = r100.b("xiaomi_timeout", KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL, r101);
        M = r100.a("uuid_use_fast", true);
        N = r100.d("sensor_timeout", 3000);
        O = r100.c("sensor_max_sample_size", 10);
        P = r100.c("sensor_sample_delay", 200);
        Q = r100.a("enable_login_report", true);
        R = r100.c("login_get_report_timeout", 10);
        S = r100.d("report_size_threshold", 0);
        T = r100.d("badger_login_update_interval", 15000);
        U = r100.e("login_update_report_black_paths", CollectionsKt.emptyList());
        V = r100.e("login_update_report_paths", CollectionsKt.listOf(new String[]{"/passport/complex_env/one_login/", "/passport/mobile/sms_login/", "/passport/auth/one_login_with_mask_mobile/", "/passport/auth/validate_mobile_login/", "/passport/user/recall_login/", "/passport/auth/mobile_auth_login/", "/passport/user/login/", "/passport/auth/one_login/", "/passport/auth/share_login/", "/passport/mobile/check_qrconnect/", "/passport/device/one_login/", "/passport/auth/login/", "/passport/cancel/login/", "/passport/mobile/login/", "/passport/user/login_by_verify_ticket/", "/passport/auth/mask_mobile_one_login/", "/passport/safe/face_login/", "/passport/mobile/cancel_and_register/", "/passport/password/reset_by_ticket/", "/passport/upsms/login/", "/passport/email/quick_login/", "/passport/mobile/bind_login/", "/passport/web/check_qrconnect/", "/passport/mobile/bind_email_login/", "/passport/password/reset/", "/passport/staff_relation_password/reset_by_ticket/", "/passport/mobile/mobile_card_login/", "/passport/safe/unlock_login/", "/passport/password/reset_by_email_ticket/", "/passport/mobile/sms_login_continue/"}));
        W = r100.a("enable_event_report", true);
        X = r100.d("sensor_data_interval", 5000);
        Y = r100.e("trigger_report_events", CollectionsKt.listOf(new String[]{"4005", "4008", "4010"}));
        Z = r100.c("touch_max_count", 10);
        f199312a0 = r100.c("event_key_max_count", 10);
        f199314b0 = r100.d("sensor_max_group_count", 3);
        f199316c0 = r100.a("enable_record_sensor", true);
        f199318d0 = r100.b("service_bind_timeout", 10000, r101);
        f199320e0 = r100.a("enable_server_time_v2", false);
    }
}
