package com.obric.sva.sdk.ahm;

import by7.a;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ixigua.lib.track.TrackParams;
import com.obric.assistant.t1;
import com.obric.sva.sdk.apm.InteractorApmHelper;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import t9a.b;
import yna.g;
import yna.h;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/obric/sva/sdk/ahm/AhmSlardarLogger;", "", "<init>", "()V", "TAG", "", "EVENT_SOUND_TRIGGER", "EVENT_BACK_TRACE", "AAD_DETECTION_EVENT_NAME", "OTHER_REC_EVENT_NAME", "EVENT_OBRIC_AHM_COMMON", "EVENT_TYPE", "HEADER", "HEADER_LEVEL", "HEADER_FAULT_ID", "singleExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getSingleExecutor$libs_mainlandRelease", "()Ljava/util/concurrent/ExecutorService;", "singleExecutor$delegate", "Lkotlin/Lazy;", "monitorEventForTeaAndSlardar", "", "data", "monitorEventForFaultTree", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AhmSlardarLogger {
    private static final String AAD_DETECTION_EVENT_NAME = "aad_detection_event";
    private static final String EVENT_BACK_TRACE = "multi_channel_backtrace_event";
    private static final String EVENT_OBRIC_AHM_COMMON = "obric_ahm_common_event";
    private static final String EVENT_SOUND_TRIGGER = "sound_trigger_error_event";
    private static final String EVENT_TYPE = "event_type";
    private static final String HEADER = "header";
    private static final String HEADER_FAULT_ID = "faultID";
    private static final String HEADER_LEVEL = "level";
    public static final AhmSlardarLogger INSTANCE = null;
    private static final String OTHER_REC_EVENT_NAME = "other_rec_event";
    private static final String TAG = "AhmSlardarLogger";
    private static final Lazy singleExecutor$delegate = null;

    private AhmSlardarLogger() {
    }

    public static /* synthetic */ Thread a(Runnable r100) {
        return singleExecutor_delegate$lambda$2$lambda$1(r100);
    }

    public static /* synthetic */ ExecutorService b() {
        return singleExecutor_delegate$lambda$2();
    }

    static {
        INSTANCE = new AhmSlardarLogger();
        singleExecutor$delegate = LazyKt.lazy(new g());
    }

    private static final ExecutorService singleExecutor_delegate$lambda$2() {
        return PThreadExecutorsUtils.newSingleThreadExecutor(new h());
    }

    public final ExecutorService getSingleExecutor$libs_mainlandRelease() {
        return (ExecutorService) singleExecutor$delegate.getValue();
    }

    private static final Thread singleExecutor_delegate$lambda$2$lambda$1(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "sva#AhmSlardarLogger");
        r101.setDaemon(true);
        return r101;
    }

    public final void monitorEventForFaultTree(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        LogUtils.i(TAG, "monitorEventForFaultTree", new Object[0]);
        if (StringsKt.isBlank(r100) == false) goto L21;
        LogUtils.e(TAG, "monitorEventForFaultTree: data is empty", new Object[0]);
        return;
    L21:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L15
        JSONObject r103 = r102.optJSONObject("header");     // Catch: Throwable -> L15
        if (r103 != null) goto L9;
        return;
    L9:
        String r104 = r103.optString("level");     // Catch: Throwable -> L15
        int r105 = r103.optInt(HEADER_FAULT_ID, -1);     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r104, SpeechEngineDefines.LOG_LEVEL_FATAL) == false) goto L13;
        if (r105 <= 0) goto L13;
        FaultTree.INSTANCE.reportAdspError(r105);     // Catch: Throwable -> L15
    L13:
        LogUtils.i(TAG, "monitorEventForFaultTree level " + r104 + " with id " + r105 + ' ', new Object[0]);     // Catch: Throwable -> L15
        Object r106 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L23;
        LogUtils.e(TAG, "monitorEventForFaultTree error: " + r107.getMessage(), new Object[0]);
        return;
    L23:
        return;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final void monitorEventForTeaAndSlardar(String r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        LogUtils.i(TAG, "monitorEventForSlardar", new Object[0]);
        if (StringsKt.isBlank(r110) == false) goto L51;
        LogUtils.e(TAG, "monitorEventForSlardar: data is empty", new Object[0]);
        return;
    L51:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L41
        JSONObject r101 = new JSONObject(r110);     // Catch: Throwable -> L41
        int r102 = r101.optInt("event_type", -1);     // Catch: Throwable -> L41
        if (r102 != AhmEventType.SOUND_TRIGGER.getEventType()) goto L10;
        String r103 = EVENT_SOUND_TRIGGER;
    L49:
        String r104 = b.b().b().a();     // Catch: Throwable -> L24
        if (r104 != null) goto L22;
        r104 = "";
    L22:
        Result.m9449constructorimpl(r101.put("os_device_id", r104));     // Catch: Throwable -> L24
    L26:
        TrackParams r105 = new TrackParams().merge(r110);     // Catch: Throwable -> L41
        a r106 = new a(r103);     // Catch: Throwable -> L41
        r106.f21463a.merge(r105);     // Catch: Throwable -> L41
        r106.b();     // Catch: Throwable -> L41
        Thread.sleep(3000);     // Catch: InterruptedException -> L30 Throwable -> L41
    L33:
        if (InteractorReportInitializer.INSTANCE.isApmReady() == true) goto L36;
        LogUtils.i(TAG, "monitorEventForSlardar skipped before APM ready event=".concat(r103), new Object[0]);     // Catch: Throwable -> L41
    L39:
        Object r111 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L41
    L43:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L53;
        LogUtils.e(TAG, "monitorEventForSlardar error: " + r112.getMessage(), new Object[0]);
        return;
    L53:
        return;
    L36:
        if (t1.f393353a.o0() == false) goto L38;
        InteractorApmHelper.INSTANCE.monitorEventForSlardar(r103, r101, null, null);     // Catch: Throwable -> L41
    L38:
        LogUtils.i(TAG, "monitorEventForSlardar event=" + r103 + " payload=" + r110, new Object[0]);     // Catch: Throwable -> L41
    L30:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L41
        LogUtils.e(TAG, "monitorEventForSlardar interrupted before report: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L41
        goto L33
    L24:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L41
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L41
        goto L26
    L10:
        if (r102 != AhmEventType.BACK_TRACE.getEventType()) goto L13;
        r103 = EVENT_BACK_TRACE;
        goto L49
    L13:
        if (r102 != AhmEventType.AAD_DETECTION.getEventType()) goto L16;
        r103 = AAD_DETECTION_EVENT_NAME;
        goto L49
    L16:
        if (r102 != AhmEventType.OTHER_REC.getEventType()) goto L18;
        r103 = OTHER_REC_EVENT_NAME;
        goto L49
    L18:
        r103 = EVENT_OBRIC_AHM_COMMON;
    L41:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    }
}
