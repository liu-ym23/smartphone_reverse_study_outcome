package com.obric.assistant.common.utils;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.AssistAudioEventProto;
import com.obric.sva.sdk.utils.TrackerConstant;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f387888a = null;

    static {
        f387888a = LazyKt.lazy(new q());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.util.EventsUtils");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.util.EventsUtils");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.util.EventsUtils");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.util.EventsUtils");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.util.EventsUtils");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.util.EventsUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.util.EventsUtils");
    }

    public static Integer c(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Lazy r101 = f387888a;
        if (((Method) r101.getValue()) != null) goto L11;
        FLogger.f375446a.w("PbReportUtils", "report via sys pb: fail: writePbEventMethod is null");
        return null;
    L11:
        Method r102 = (Method) r101.getValue();     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L8
        return (Integer) r102.invoke(null, new Object[]{Long.valueOf(System.currentTimeMillis()), 106, r100});
    L8:
        e = move-exception;
        FLogger.f375446a.w("PbReportUtils", "report via sys pb: reportPbEvent failed: " + e);
        return null;
    }

    public static AssistAudioEventProto.AssistAudioEventDataTraceViewer.Builder b(String r100, String r101, JSONObject r102) {
        AssistAudioEventProto.AssistAudioEventDataTraceViewer.Builder r103 = AssistAudioEventProto.AssistAudioEventDataTraceViewer.newBuilder().setTraceViewerType(r101).setTraceViewerBizTag("wakeup").setTraceViewerTrack(r100).setTraceViewerVal(r100).addTraceViewerExpansionKeyList("extra");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(r101, "instant") == false) goto L7;
        Object r105 = r103.setTraceViewerEventTs(r102.optLong("timestamp"));     // Catch: Throwable -> L12
    L10:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
    L14:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        FLogger.f375446a.w("PbReportUtils", "createTraceViewerInfoBuilder failed: " + r107);
    L17:
        return r103;
    L7:
        if (Intrinsics.areEqual(r101, "slice") == false) goto L9;
        long r108 = r102.optLong(TrackerConstant.TRACKER_INTERNAL_RAW_START_TIME);     // Catch: Throwable -> L12
        r103.setTraceViewerStartTs(r108);     // Catch: Throwable -> L12
        r105 = r103.setTraceViewerEndTs(r108 + r102.optLong("wakeup_total_duration"));     // Catch: Throwable -> L12
        goto L10
    L9:
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static Integer e(String r110, String r111, boolean r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "wakeupStage");
        Intrinsics.checkNotNullParameter(r113, WsConstants.KEY_PAYLOAD);
        AssistAudioEventProto.AssistAudioEventDataTraceViewer r100 = b(r110, "instant", r113).build();
        AssistAudioEventProto.AssistAudioEventData.Builder r101 = AssistAudioEventProto.AssistAudioEventData.newBuilder();
        String r102 = r113.optString("session_type");
        AssistAudioEventProto.BreathWakeupEvent.Builder r103 = null;
        AssistAudioEventProto.VoiceWakeupEvent.Builder r104 = null;
        if (Intrinsics.areEqual(r102, "VOICE") == false) goto L28;
        AssistAudioEventProto.VoiceWakeupEvent.Builder r114 = AssistAudioEventProto.VoiceWakeupEvent.newBuilder().setEventName(r110).setEventReportSource("Assist").setWakeupStage(r111).setWakeupSuccess(r112);
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L19
        Iterator<String> r116 = r113.keys();     // Catch: Throwable -> L19
    L7:
        if (r116.hasNext() == false) goto L17;
        String r105 = r116.next();     // Catch: Throwable -> L19
        if (TextUtils.equals(r105, "reject_reason") == false) goto L11;
        r114.setRejectReason(r113.optString(r105));     // Catch: Throwable -> L19
    L11:
        Object r106 = r113.opt(r105);     // Catch: Throwable -> L19
        if (r106 == null) goto L15;
        String r107 = r106.toString();     // Catch: Throwable -> L19
        if (r107 == null) goto L15;
    L16:
        r114.putExtra(r105, r107);     // Catch: Throwable -> L19
    L15:
        r107 = "";
        goto L16
    L17:
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L24;
        FLogger.f375446a.w("PbReportUtils", "createBreathWakeupEventBuilder failed: " + r118);
    L24:
        if (r114 == null) goto L26;
        r104 = r114.addTraceViewers(r100);
    L26:
        r101.addVoiceWakeupEvent(r104);
    L52:
        AssistAudioEventProto.AssistAudioEventData r119 = r101.build();
        Integer r120 = c(r119.toByteArray());
        FLogger.f375446a.d("PbReportUtils", "reportWakeupEventViaSysPb, eventName: " + r110 + ", data = " + r119 + ", res = " + r120);
        return r120;
    L19:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L28:
        if (Intrinsics.areEqual(r102, "BREATH") == false) goto L52;
        AssistAudioEventProto.BreathWakeupEvent.Builder r122 = AssistAudioEventProto.BreathWakeupEvent.newBuilder().setEventName(r110).setEventReportSource("Assist").setWakeupStage(r111).setWakeupSuccess(r112);
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L44
        Iterator<String> r124 = r113.keys();     // Catch: Throwable -> L44
    L32:
        if (r124.hasNext() == false) goto L42;
        String r108 = r124.next();     // Catch: Throwable -> L44
        if (TextUtils.equals(r108, "reject_reason") == false) goto L36;
        r122.setRejectReason(r113.optString(r108));     // Catch: Throwable -> L44
    L36:
        Object r109 = r113.opt(r108);     // Catch: Throwable -> L44
        if (r109 == null) goto L40;
        String r125 = r109.toString();     // Catch: Throwable -> L44
        if (r125 == null) goto L40;
    L41:
        r122.putExtra(r108, r125);     // Catch: Throwable -> L44
    L40:
        r125 = "";
        goto L41
    L42:
        Object r126 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L49;
        FLogger.f375446a.w("PbReportUtils", "createBreathWakeupEventBuilder failed: " + r127);
    L49:
        if (r122 == null) goto L51;
        r103 = r122.addTraceViewers(r100);
    L51:
        r101.addBreathWakeupEvent(r103);
    L44:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    }

    public static Integer d(String r100, long r101, long r102, long r103, JSONObject r110) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r110, WsConstants.KEY_PAYLOAD);
        AssistAudioEventProto.AssistAudioEventDataTraceViewer r104 = b(r100, "slice", r110).build();
        AssistAudioEventProto.AssistAudioEventData.Builder r105 = AssistAudioEventProto.AssistAudioEventData.newBuilder();
        AssistAudioEventProto.VoiceWakeupDuration.Builder r106 = AssistAudioEventProto.VoiceWakeupDuration.newBuilder().setEventName(r100).setEventReportSource("Assist").setWakeupStage1Duration(r101).setWakeupStage2Duration(r102).setWakeupStage3Duration(r103).addTraceViewers(r104);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L14
        Iterator<String> r108 = r110.keys();     // Catch: Throwable -> L14
    L5:
        if (r108.hasNext() == false) goto L12;
        String r109 = r108.next();     // Catch: Throwable -> L14
        Object r111 = r110.opt(r109);     // Catch: Throwable -> L14
        if (r111 == null) goto L10;
        String r112 = r111.toString();     // Catch: Throwable -> L14
        if (r112 == null) goto L10;
    L11:
        r106.putExtra(r109, r112);     // Catch: Throwable -> L14
    L10:
        r112 = "";
        goto L11
    L12:
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L19;
        FLogger.f375446a.w("PbReportUtils", "reportWakeupDurationViaSysPb failed: " + r114);
    L19:
        AssistAudioEventProto.AssistAudioEventData r115 = r105.addVoiceWakeupDuration(r106).build();
        Integer r116 = c(r115.toByteArray());
        FLogger.f375446a.d("PbReportUtils", "reportWakeupDurationViaSysPb, eventName: " + r100 + ", data = " + r115 + ", res = " + r116);
        return r116;
    L14:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
