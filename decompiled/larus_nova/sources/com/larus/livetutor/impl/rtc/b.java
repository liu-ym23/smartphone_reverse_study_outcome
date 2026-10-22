package com.larus.livetutor.impl.rtc;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.common.apphost.AppHost;
import com.larus.livetutor.impl.rtc.api.RTCErrorCode;
import com.larus.livetutor.impl.rtc.api.RTCException;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.utils.logger.FLogger;
import com.ss.bytertc.engine.RTCEngine;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.data.AudioFrameCallbackMethod;
import com.ss.bytertc.engine.data.AudioPropertiesConfig;
import com.ss.bytertc.engine.data.EngineConfig;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.type.AudioScenarioType;
import com.ss.bytertc.engine.type.MessageConfig;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RTCEngine f356277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RTCRoom f356278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.im.service.e f356279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.im.service.k f356280d;

    public static final class a {
    }

    static {
    }

    public final void b() {
        RTCEngine r100 = this.f356277a;
        if (r100 == null) goto L5;
        r100.registerAudioFrameObserver(null);
        r100.disableAudioFrameCallback(AudioFrameCallbackMethod.AUDIO_FRAME_CALLBACK_REMOTE_USER);
        r100.stopAudioCapture();
    L5:
        com.larus.im.service.k r101 = this.f356280d;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter("AIXUE_TUTOR", "bizId");
        r101.c("AIXUE_TUTOR", "AIXUE_TUTOR");
    L9:
        this.f356277a = null;
        return;
    L8:
        RTCEngine.destroyRTCEngine();
        goto L9
    }

    public final void c() {
        RTCRoom r100 = this.f356278b;
        if (r100 == null) goto L5;
        r100.leaveRoom();
    L5:
        RTCRoom r101 = this.f356278b;
        if (r101 == null) goto L8;
        r101.destroy();
    L8:
        this.f356278b = null;
    }

    public final void f() {
        RTCEngine r100 = this.f356277a;
        if (r100 == null) goto L10;
        int r101 = r100.startAudioCapture();
        if (r101 != 0) goto L8;
        return;
    L8:
        throw new RTCException(RTCErrorCode.START_AUDIO_CAPTURE, "startAudioCapture failed, ret = " + r101);
    L10:
        throw new RTCException(RTCErrorCode.START_AUDIO_CAPTURE, "startAudioCapture failed, rtcEngine is null");
    }

    public final void g() {
        RTCEngine r100 = this.f356277a;
        if (r100 == null) goto L10;
        int r101 = r100.stopAudioCapture();
        if (r101 != 0) goto L8;
        return;
    L8:
        throw new RTCException(RTCErrorCode.STOP_AUDIO_CAPTURE, "stopAudioCapture failed, ret = " + r101);
    L10:
        throw new RTCException(RTCErrorCode.STOP_AUDIO_CAPTURE, "stopAudioCapture failed, rtcEngine is null");
    }

    public b() {
        com.larus.im.service.t.f350889a.getClass();
        this.f356280d = com.larus.im.service.t.a.f350891b;
    }

    public final void e(RTCEngine r100) {
        r100.setBusinessId("live_tutor");
        r100.setAudioScenario(AudioScenarioType.GAMESTREAMING);
        r100.setCaptureVolume(StreamIndex.STREAM_INDEX_MAIN, com.larus.livetutor.impl.rtc.a.f356270b);
        r100.setAnsMode(com.larus.livetutor.impl.rtc.a.f356269a);
        r100.setPlaybackVolume(400);
        r100.enableAudioPropertiesReport(new AudioPropertiesConfig(40, true, false));
        this.f356277a = r100;
        r100.getNetworkTimeInfo();
    }

    public final long d(String r100, String r101, MessageConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "messageStr");
        Intrinsics.checkNotNullParameter(r102, "config");
        RTCRoom r103 = this.f356278b;
        if (r103 != null) goto L7;
        return -1;
    L7:
        return r103.sendUserMessage(r100, r101, r102);
    }

    public final Object a(com.larus.livetutor.impl.rtc.handler.x r100, String r101, boolean r102, Continuation r110) {
        if ((r110 instanceof RTCManager$createRTCEngine$1) == false) goto L7;
        RTCManager$createRTCEngine$1 r103 = (RTCManager$createRTCEngine$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: TimeoutCancellationException -> L30
    L32:
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        EngineConfig r112 = new EngineConfig();
        r112.appID = r101;
        r112.context = UtilsKt.c();
        JSONObject r107 = new JSONObject();
        if (r102 == false) goto L18;
        r107.put("rtc.enable_auto_test", true);
        r107.put("rtc.env", 2);
        r107.put("config_hosts", "rtc-test.bytedance.com");
        JSONArray r108 = new JSONArray();
        r108.put("rtc-newton.bytedance.com");
        r107.put("access_hosts", r108);
    L18:
        r107.put("rtc.aid", r101);
        JSONObject r109 = new JSONObject();
        AppHost.Companion r113 = AppHost.f326268a;
        r109.put("app_version", r113.getVersionName());
        r109.put("app_min_version", r113.getVersionName());
        r109.put("app_channel", r113.getBuildChannel());
        r107.put("rtc.common_extra_info", r109.toString());
        FLogger.f375446a.i("RTCManager", GsonProtectorUtils.toJson(com.larus.livetutor.impl.utils.e.f356671a, r107));
        r112.parameters = r107;
        if (this.f356280d != null) goto L25;
        RTCEngine r114 = RTCEngine.createRTCEngine(r112, r100);
        if (r114 == null) goto L24;
        e(r114);
        goto L29
    L24:
        throw new RTCException(RTCErrorCode.CREATE_ENGINE, "self createRTCEngine failed");
    L25:
        RTCManager$createRTCEngine$2 r115 = new RTCManager$createRTCEngine$2(this, r112, r100, null);     // Catch: TimeoutCancellationException -> L30
        r103.label = 1;     // Catch: TimeoutCancellationException -> L30
        if (TimeoutKt.b(10000, r115, r103) != r105) goto L32;
        return r105;
    L31:
        throw new RTCException(RTCErrorCode.CREATE_ENGINE, "createRTCEngine timeout");
    L7:
        r103 = new RTCManager$createRTCEngine$1(this, r110);
        goto L8
    }
}
