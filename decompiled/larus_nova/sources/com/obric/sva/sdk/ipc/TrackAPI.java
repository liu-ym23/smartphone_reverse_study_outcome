package com.obric.sva.sdk.ipc;

import android.os.Bundle;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.obric.sva.sdk.BuildConfig;
import com.obric.sva.sdk.config.ConfigManager;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.effectplatform.UpdateTrackerType;
import com.obric.sva.sdk.session.OpaqueDataHelper;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.utils.InteractConst;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J.\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ*\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00132\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010!2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'J\u001a\u0010(\u001a\u00020\u00052\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000f0*J.\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005H\u0007J0\u0010+\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007JE\u00101\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u00105J\u001c\u00106\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0005H\u0007J$\u00109\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010;\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u00052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u0005H\u0007J\b\u0010>\u001a\u00020'H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006?"}, d2 = {"Lcom/obric/sva/sdk/ipc/TrackAPI;", "", "<init>", "()V", "KEY_SESSION_TYPE", "", "KEY_STAGE", "KEY_ERROR_MESSAGE", "yMdHmsSdf", "Ljava/text/SimpleDateFormat;", "getYMdHmsSdf", "()Ljava/text/SimpleDateFormat;", "yMdHmsSdf$delegate", "Lkotlin/Lazy;", "trackVoicePrintEnroll", "", "success", "", "statusCode", "", "trackVoicePrintSentence", "errorCode", "index", "sentence", "asr", "trackStage1", InteractConst.WAKEUP_SESSION_TYPE, "Lcom/obric/sva/sdk/session/SessionType;", "breathArgs", "Lcom/obric/sva/sdk/session/OpaqueDataHelper$BreathStatistics;", "trackStage2", "status", "args", "", "trackerStage3", "trackerModelUpdate", "type", "Lcom/obric/sva/sdk/effectplatform/UpdateTrackerType;", "jsonObject", "Lorg/json/JSONObject;", "fillJson", "block", "Lkotlin/Function1;", "trackWakeupInterrupted", "bundle", "Landroid/os/Bundle;", "stage", "errorMessage", "extra", "trackWakeupInterruptedInternal", "startupAttemptId", "startupStartWallTimeMs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "trackBreathScore", "trackBackTraceRecorderStart", "scene", "trackBackTraceRecorderStartResult", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "trackBackTraceRecordError", "trackBackTraceDuration", "payloadJson", "json", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TrackAPI {
    public static final TrackAPI INSTANCE = null;
    private static final String KEY_ERROR_MESSAGE = "error_message";
    private static final String KEY_SESSION_TYPE = "session_type";
    private static final String KEY_STAGE = "event_stage";
    private static final Lazy yMdHmsSdf$delegate = null;

    private TrackAPI() {
    }

    public static /* synthetic */ Unit a(JSONObject r100) {
        return trackVoicePrintEnroll$lambda$1(r100);
    }

    public static /* synthetic */ Unit b(int r100, JSONObject r101) {
        return trackVoicePrintEnroll$lambda$2(r100, r101);
    }

    public static /* synthetic */ SimpleDateFormat c() {
        return yMdHmsSdf_delegate$lambda$0();
    }

    @JvmStatic
    public static final void trackBackTraceRecordError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        trackBackTraceRecordError$default(r100, null, 2, null);
    }

    @JvmStatic
    public static final void trackBackTraceRecorderStartResult(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        trackBackTraceRecorderStartResult$default(r100, r101, null, 4, null);
    }

    @JvmStatic
    public static final void trackBreathScore(SessionType r100) {
        Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
        trackBreathScore$default(r100, null, 2, null);
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        trackWakeupInterrupted$default(r100, r101, r102, null, 8, null);
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        trackWakeupInterrupted$default(r100, r101, null, null, 12, null);
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        trackWakeupInterrupted$default(r100, r101, r102, null, 8, null);
    }

    static {
        INSTANCE = new TrackAPI();
        yMdHmsSdf$delegate = LazyKt.lazy(new s());
    }

    private final SimpleDateFormat getYMdHmsSdf() {
        return (SimpleDateFormat) yMdHmsSdf$delegate.getValue();
    }

    @JvmStatic
    private static final JSONObject json() {
        JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        String r102 = t9a.b.b().b().a();     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        Result.m9449constructorimpl(r100.put("os_device_id", r102));     // Catch: Throwable -> L8
    L10:
        return r100;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final SimpleDateFormat yMdHmsSdf_delegate$lambda$0() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault());
    }

    @JvmStatic
    public static final void trackBackTraceDuration(String r100) {
        Intrinsics.checkNotNullParameter(r100, "payloadJson");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        TrackerManager.INSTANCE.onTrackEvent(502, r100);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        r103.printStackTrace();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void trackBackTraceRecorderStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r102 = json();     // Catch: Throwable -> L5
        r102.put("scene", r100);     // Catch: Throwable -> L5
        TrackerManager.INSTANCE.onTrackEvent(500, r102.toString());     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        r104.printStackTrace();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Unit trackVoicePrintEnroll$lambda$1(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Unit.INSTANCE;
    }

    public final String fillJson(Function1<? super JSONObject, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        JSONObject r101 = json();
        r101.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L5
        r100.invoke(r101);     // Catch: JSONException -> L5
    L8:
        return r101.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public final void trackerStage3(SessionType r100) {
        Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
        JSONObject r101 = json();
        r101.put("timestamp", System.currentTimeMillis());
        r101.put(KEY_SESSION_TYPE, r100.getTag());
        TrackerManager.INSTANCE.onTrackEvent(300, r101.toString());
    }

    @JvmStatic
    public static final void trackBackTraceRecordError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r103 = json();     // Catch: Throwable -> L8
        r103.put("scene", r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r103.put("error_reason", r101);     // Catch: Throwable -> L8
        TrackerManager.INSTANCE.onTrackEvent(503, r103.toString());     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L16;
        r105.printStackTrace();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @JvmStatic
    public static final void trackBreathScore(SessionType r100, OpaqueDataHelper.BreathStatistics r101) {
        Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
        JSONObject r102 = json();
        r102.put("timestamp", System.currentTimeMillis());
        r102.put(KEY_SESSION_TYPE, r100.getTag());
        if (r100 != SessionType.BREATH) goto L12;
        if (r101 == null) goto L12;
        if (r101.valid() == false) goto L12;
        float[] r103 = OpaqueDataHelper.calculateAverageScores(r101.payload);
        r102.put("trace_back", r101.traceBack);
        r102.put("credibility", r101.credibility);
        r102.put("engine_version", r101.engineVersion);
        if (r103 == null) goto L12;
        if (r103.length < 3) goto L12;
        r102.put("imu_score", Float.valueOf(r103[0]));
        r102.put("near_score", Float.valueOf(r103[1]));
        r102.put("vad_score", Float.valueOf(r103[2]));
    L12:
        TrackerManager.INSTANCE.onTrackEvent(104, r102.toString());
    }

    private static final Unit trackVoicePrintEnroll$lambda$2(int r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        r101.put("code", r100);
        return Unit.INSTANCE;
    }

    public final void trackStage1(SessionType r100, OpaqueDataHelper.BreathStatistics r101) {
        Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
        JSONObject r102 = json();
        r102.put("timestamp", System.currentTimeMillis());
        r102.put(KEY_SESSION_TYPE, r100.getTag());
        if (r100 != SessionType.BREATH) goto L15;
        if (r101 == null) goto L15;
        if (r101.valid() == false) goto L15;
        r102.put("trace_back", r101.traceBack);
        r102.put("cur_time", r101.curTime);
        r102.put("imu_start_time", r101.imuStartTime);
        r102.put("vad_start_time", r101.vadStartTime);
        r102.put("near_start_time", r101.nearStartTime);
        r102.put("credibility", r101.credibility);
        r102.put("millis_to_read", r101.millisToRead);
        r102.put("engine_version", r101.engineVersion);
        r102.put("upload_algo_info_size", r101.uploadAlgoInfoSize);
        r102.put("upload_algo_result_num", r101.uploadAlgoResultNum);
        r102.put("user_flag", r101.userFlag);
        r102.put("born", r101.born);
        int[] r103 = r101.payload;
        if (r103 == null) goto L10;
        Integer r104 = Integer.valueOf(r103.length);
    L11:
        r102.put("payload_size", r104);
        Iterator<Map.Entry<String, Object>> r105 = r101.userData.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        Map.Entry<String, Object> r106 = r105.next();
        r102.put(r106.getKey(), r106.getValue());
        goto L13
    L10:
        r104 = null;
    L15:
        TrackerManager.INSTANCE.onTrackEvent(100, r102.toString());
    }

    public final void trackVoicePrintEnroll(boolean r100, final int r101) {
        if (r100 == false) goto L4;
        TrackerManager.INSTANCE.onTrackEvent(11, fillJson(new q()));
        return;
    L4:
        TrackerManager.INSTANCE.onTrackEvent(12, fillJson(new r(r101)));
    }

    public final void trackerModelUpdate(UpdateTrackerType r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r101 != null) goto L5;
        r101 = json();
    L5:
        r101.put("timestamp", System.currentTimeMillis());
        r101.put("date", INSTANCE.getYMdHmsSdf().format(new Date()));
        ConfigManager r102 = ConfigManager.INSTANCE;
        String r103 = r102.getModelConfig().getOwner();
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r101.put("model_config_owner", r103);
        r101.put("model_config_version", r102.getStage2Config().getVersion());
        r101.put("voiceprint_model_version", r102.getStage2Config().getVoiceprint_modelVersion());
        r101.put("kws_model_version", r102.getStage2Config().getKwsmodelVersion());
        TrackerManager.INSTANCE.onTrackEvent(r100.getI(), r101.toString());
    }

    @JvmStatic
    public static final void trackBackTraceRecorderStartResult(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r104 = json();     // Catch: Throwable -> L8
        r104.put("scene", r100);     // Catch: Throwable -> L8
        r104.put("success", r101);     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        r104.put("error_reason", r102);     // Catch: Throwable -> L8
        TrackerManager.INSTANCE.onTrackEvent(501, r104.toString());     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L16;
        r106.printStackTrace();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void trackStage2(int r110, Map<String, ? extends Object> r210, SessionType r211) {
        Intrinsics.checkNotNullParameter(r210, "args");
        Intrinsics.checkNotNullParameter(r211, InteractConst.WAKEUP_SESSION_TYPE);
        JSONObject r111 = json();
        r111.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L15
        r111.put(KEY_SESSION_TYPE, r211.getTag());     // Catch: JSONException -> L15
        if (r211 != SessionType.VOICE) goto L7;
        r111.put("dump_audio_file_id", r210.get("fileId"));     // Catch: JSONException -> L15
        r111.put("rejectType", r210.get("rejectType"));     // Catch: JSONException -> L15
        r111.put("stage1_kw_confidence_level", "" + r210.get("stage1_kw_confidence_level"));     // Catch: JSONException -> L15
        r111.put("stage1_usr_confidence_level", "" + r210.get("stage1_usr_confidence_level"));     // Catch: JSONException -> L15
        r111.put("kws_score", r210.get("kws_score"));     // Catch: JSONException -> L15
        r111.put("kws_frame", "" + r210.get("kws_frame"));     // Catch: JSONException -> L15
        r111.put("kws_word", "" + r210.get("kws_word"));     // Catch: JSONException -> L15
        r111.put("kws_threshold", r210.get("kws_threshold"));     // Catch: JSONException -> L15
        r111.put("kws_result", "" + r210.get("kws_result"));     // Catch: JSONException -> L15
        r111.put("sid_threshold", r210.get("sid_threshold"));     // Catch: JSONException -> L15
        r111.put("sid_score", r210.get("sid_score"));     // Catch: JSONException -> L15
        r111.put("sid_result", "" + r210.get("sid_result"));     // Catch: JSONException -> L15
        r111.put("sid_error", "" + r210.get("sid_error"));     // Catch: JSONException -> L15
    L7:
        r111.put("sid_switch", "" + Global.sWakeupSid);     // Catch: JSONException -> L15
        r111.put("wakeup_switch", "" + Global.sWakeupStatus);     // Catch: JSONException -> L15
        r111.put("breath_switch", "" + Global.getBreathStatus());     // Catch: JSONException -> L15
        r111.put("sva_framework_version", BuildConfig.sva_framework_version);     // Catch: JSONException -> L15
        r111.put("audio_sdk_version", BuildConfig.audio_sdk_version);     // Catch: JSONException -> L15
        ConfigManager r100 = ConfigManager.INSTANCE;     // Catch: JSONException -> L15
        r111.put("model_config_version", r100.getStage2Config().getVersion());     // Catch: JSONException -> L15
        r111.put("voiceprint_model_version", r100.getStage2Config().getVoiceprint_modelVersion());     // Catch: JSONException -> L15
        r111.put("kws_model_version", r100.getStage2Config().getKwsmodelVersion());     // Catch: JSONException -> L15
        r111.put("manifest_content", r100.getModelConfig().toString());     // Catch: JSONException -> L15
        r111.put("model_config_content", r100.getStage2Config().toString());     // Catch: JSONException -> L15
        if (r110 != 0) goto L11;
    L13:
        TrackerManager.INSTANCE.onTrackEvent(200, r111.toString());
        return;
    L11:
        if (r110 == 1) goto L13;
        TrackerManager.INSTANCE.onTrackEvent(201, r111.toString());
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ void trackBackTraceRecordError$default(String r100, String r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        trackBackTraceRecordError(r100, r101);
    }

    public static /* synthetic */ void trackBreathScore$default(SessionType r100, OpaqueDataHelper.BreathStatistics r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = new OpaqueDataHelper.BreathStatistics();
    L5:
        trackBreathScore(r100, r101);
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(Bundle r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "stage");
        Intrinsics.checkNotNullParameter(r112, "errorMessage");
        if (r110 == null) goto L5;
        String r100 = r110.getString(InteractConst.WAKEUP_SESSION_NAME, "");
    L6:
        TrackAPI r101 = INSTANCE;
        boolean r102 = true;
        if (r110 == null) goto L13;
        String r103 = r110.getString("obric_startup_attempt_id");
        if (r103 == null) goto L13;
        if ((!StringsKt.isBlank(r103)) == false) goto L13;
        String r104 = r103;
    L14:
        if (r110 == null) goto L21;
        Long r114 = Long.valueOf(r110.getLong(InteractConst.WAKEUP_REQUEST_TIME, 0));
        if (r114.longValue() > 0) goto L19;
        r102 = false;
    L19:
        if (r102 == false) goto L21;
        Long r105 = r114;
    L22:
        r101.trackWakeupInterruptedInternal(r111, r112, r113, r100, r104, r105);
        return;
    L21:
        r105 = null;
    L13:
        r104 = null;
        goto L14
    L5:
        r100 = null;
        goto L6
    }

    @JvmStatic
    public static final void trackWakeupInterrupted(String r100, String r101, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        INSTANCE.trackWakeupInterruptedInternal(r100, r101, r110, r111, null, null);
    }

    public static /* synthetic */ void trackBackTraceRecorderStartResult$default(String r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        trackBackTraceRecorderStartResult(r100, r101, r102);
    }

    public static /* synthetic */ void trackStage1$default(TrackAPI r100, SessionType r101, OpaqueDataHelper.BreathStatistics r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = new OpaqueDataHelper.BreathStatistics();
    L5:
        r100.trackStage1(r101, r102);
    }

    public static /* synthetic */ void trackerModelUpdate$default(TrackAPI r100, UpdateTrackerType r101, JSONObject r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.trackerModelUpdate(r101, r102);
    }

    public final void trackVoicePrintSentence(boolean r100, int r101, int r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r103, "sentence");
        Intrinsics.checkNotNullParameter(r104, "asr");
        JSONObject r105 = json();
        r105.put("success", r100);     // Catch: Exception -> L6
        r105.put("error", r101);     // Catch: Exception -> L6
        r105.put("index", r102);     // Catch: Exception -> L6
        r105.put("sentence", r103);     // Catch: Exception -> L6
        r105.put("asr", r104);     // Catch: Exception -> L6
    L4:
        TrackerManager.INSTANCE.onTrackEvent(13, r105.toString());
    }

    public static /* synthetic */ void trackWakeupInterrupted$default(String r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = SessionType.VOICE.getTag();
    L8:
        trackWakeupInterrupted(r100, r101, r102, r103);
    }

    private final void trackWakeupInterruptedInternal(String r100, String r101, String r102, String r103, String r104, Long r105) {
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        JSONObject r107 = json();     // Catch: Throwable -> L12
        r107.put(KEY_STAGE, r100);     // Catch: Throwable -> L12
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r107.put(KEY_SESSION_TYPE, r103);     // Catch: Throwable -> L12
        r107.put("error_message", r101);     // Catch: Throwable -> L12
        r107.put("extra", r102);     // Catch: Throwable -> L12
        r107.put("obric_startup_failure_wall_ms", System.currentTimeMillis());     // Catch: Throwable -> L12
        if (r104 == null) goto L8;
        r107.put("obric_startup_attempt_id", r104);     // Catch: Throwable -> L12
    L8:
        if (r105 == null) goto L10;
        r107.put(InteractConst.WAKEUP_REQUEST_TIME, r105.longValue());     // Catch: Throwable -> L12
    L10:
        TrackerManager.INSTANCE.onTrackEvent(400, r107.toString());     // Catch: Throwable -> L12
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L20;
        r109.printStackTrace();
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static /* synthetic */ void trackWakeupInterrupted$default(Bundle r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = "";
    L5:
        trackWakeupInterrupted(r100, r101, r102, r103);
    }
}
