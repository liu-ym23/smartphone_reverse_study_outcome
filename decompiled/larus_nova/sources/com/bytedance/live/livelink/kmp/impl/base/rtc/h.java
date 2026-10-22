package com.bytedance.live.livelink.kmp.impl.base.rtc;

import android.content.Context;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.ILiveWrappedRtcService;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.LiveWrappedVideoEncoderConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioAlignmentMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioFrameCallbackMethod;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRenderType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRoute;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioSourceType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamSycnInfoConfig;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoDenoiseMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSourceType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoSuperResolutionMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushTargetType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedAudioScenarioType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.video.ILiveWrappedVideoSink;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusVideoSinkManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zf2.k0;
import zf2.q;
import zf2.r0;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements mi6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f255317a;

    public static final class a {
    }

    public static final class b implements ag2.b {
        public b() {
        }
    }

    public static final class c extends ag2.a {
        public c() {
        }
    }

    static {
        f255317a = true;
    }

    @Override // mi6.a
    public final void G() {
        ej6.a.c("RTCEngineWrapper", "startNetworkDetection");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void H() {
        ej6.a.c("RTCEngineWrapper", "stopChorusCacheSync");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void I() {
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void J() {
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void K() {
        ej6.a.c("RTCEngineWrapper", "startAudioCapture");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void b() {
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void destroy() {
        if (f255317a == true) goto L5;
        return;
    L5:
        ILiveWrappedRtcService.Companion.getClass();
        ILiveWrappedRtcService.a.a().destroyRTCEngineEx();
    }

    @Override // mi6.a
    public final void f() {
        ej6.a.c("RTCEngineWrapper", "stopAudioCapture");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void i() {
        ej6.a.c("RTCEngineWrapper", "stopNetworkDetection");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void logout() {
        if (f255317a == true) goto L5;
        return;
    L5:
        ej6.a.c("RTCEngineWrapper", "logout");
        throw null;
    }

    @Override // mi6.a
    public final void v() {
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final yf2.c S() {
        throw null;
    }

    @Override // mi6.a
    public final void D(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void E(int r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setPlayBackVolume volume " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void N(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void O(zf2.j r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "enableAudioPropertiesReport config " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final int P(eg2.a r100) {
        if (f255317a == true) goto L7;
        return -2;
    L7:
        throw null;
    }

    @Override // mi6.a
    public final void Q(LiveWrappedAudioRoute r100) {
        Intrinsics.checkNotNullParameter(r100, "audioRoute");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setAudioRoute audioRoute " + r100 + ' ');
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void V(LiveWrappedAudioFrameCallbackMethod r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "disableAudioFrameCallback method " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void W(LiveWrappedVideoDenoiseMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setVideoDenoiser mode" + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void Z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setRuntimeParams params " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void e(int r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "enableAudioAEDReport interval " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "businessId");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setBusinessId " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void h(int r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "enableAudioVADReport interval " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void l(dg2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setCellularEnhancement config " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void o(LiveWrappedAudioSourceType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setAudioSourceType type " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void q(com.bytedance.live.livelink.kmp.impl.base.rtc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setClientMixedStreamObserver observer " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void r(LiveWrappedAudioRenderType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setAudioRenderType type " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "stopClientMixedStream taskId " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final int u(Function0 r100) {
        Integer r101 = (Integer) r100.invoke();
        if (r101 != null) goto L7;
        return -2;
    L7:
        return r101.intValue();
    }

    @Override // mi6.a
    public final void x(com.bytedance.live.livelink.kmp.impl.core.audio.b r100) {
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "registerAudioFrameObserver observer " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void y(LiveWrappedAudioScenarioType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setAudioScenario type " + r100);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void A(LiveWrappedStreamIndex r100, zf2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "streamIndex");
        Intrinsics.checkNotNullParameter(r101, "config");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setAudioContentType streamIndex " + r100 + " config" + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void B(LiveWrappedStreamIndex r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "streamIndex");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "muteAudioCapture streamIndex " + r100 + " mute " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void C(k0 r100, LiveWrappedVideoSuperResolutionMode r101) {
        Intrinsics.checkNotNullParameter(r100, "streamKey");
        Intrinsics.checkNotNullParameter(r101, "mode");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setRemoteVideoSuperResolution streamKey " + r100 + " mode " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void F(k0 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "streamKey");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setRemoteAudioPlaybackVolume streamKey" + r100 + " volume " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void L(LiveWrappedStreamIndex r100, LiveWrappedVideoSourceType r101) {
        Intrinsics.checkNotNullParameter(r100, "streamIndex");
        Intrinsics.checkNotNullParameter(r101, "videoSourceType");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setVideoSource streamIndex " + r100 + " videoSourceType " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void M(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "message");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void T(byte[] r100, LiveWrappedStreamSycnInfoConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void X(LiveWrappedAudioFrameCallbackMethod r100, zf2.f r101) {
        Intrinsics.checkNotNullParameter(r101, "audioFormat");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "enableAudioFrameCallBack method " + r100 + " audioFormat " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void j(k0 r100, LiveWrappedAudioAlignmentMode r101) {
        Intrinsics.checkNotNullParameter(r100, "streamKey");
        Intrinsics.checkNotNullParameter(r101, "mode");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setAudioAlignmentProperty streamKey " + r100 + " mode" + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void k(LiveWrappedStreamIndex r100, zf2.e r101) {
        Intrinsics.checkNotNullParameter(r100, "streamIndex");
        Intrinsics.checkNotNullParameter(r101, "audioConfig");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setAudioEncodeConfig streamIndex " + r100 + " audioConfig" + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void m(LiveWrappedVideoEncoderConfig r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "encoderConfig");
        Intrinsics.checkNotNullParameter(r101, "source");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setVideoEncoderConfig config " + r100 + " source " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void n(bg2.a r100, ChorusVideoSinkManager r101) {
        Intrinsics.checkNotNullParameter(r100, "chorusCacheSyncConfig");
        Intrinsics.checkNotNullParameter(r101, "observer");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "startChorusCacheSync chorusCacheSyncConfig " + r100 + " observer" + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void p(String r100, LiveWrappedMixedStreamPushTargetType r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "targetType");
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "stopPushMixedStream taskId " + r100 + " targetType " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void s(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "userId");
        if (f255317a == true) goto L5;
        return;
    L5:
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "token " + r100 + " uid " + r101);
        throw null;
    }

    @Override // mi6.a
    public final void w(String r100, bg2.i r101) {
        int r102 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "updatePushMixedStream taskId " + r100 + " pushTargetConfig " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void R(String r100, bg2.e r101, bg2.b r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "mixedConfig");
        Intrinsics.checkNotNullParameter(r102, "extraConfig");
        int r103 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "updateClientMixedStream taskId " + r100 + " mixedConfig " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void U(String r100, bg2.i r101, bg2.e r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "pushTargetConfig");
        Intrinsics.checkNotNullParameter(r102, "config");
        int r103 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "startPushMixedStream taskId " + r100 + " pushTargetConfig " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void Y(String r100, bg2.e r101, bg2.b r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "mixedConfig");
        Intrinsics.checkNotNullParameter(r102, "extraConfig");
        int r103 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "startClientMixedStream taskId " + r100 + " mixedConfig " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    @Override // mi6.a
    public final void z(k0 r100, ILiveWrappedVideoSink r101, fg2.b r102) {
        Intrinsics.checkNotNullParameter(r100, "streamKey");
        Intrinsics.checkNotNullParameter(r102, "config");
        int r103 = ej6.a.f472874a;
        ej6.a.c("RTCEngineWrapper", "setRemoteVideoSink streamKey " + r100 + " videoSink " + r101);
        if (f255317a == true) goto L6;
        return;
    L6:
        throw null;
    }

    public h(Context r100, String r101, c r102, b r103, Object r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r104, "eglContext");
        Intrinsics.checkNotNullParameter(r105, "parameters");
        f255317a = true;
        ILiveWrappedRtcService.Companion.getClass();
        ILiveWrappedRtcService r106 = ILiveWrappedRtcService.a.a();
        q r107 = new q();
        r107.f571740a = r100;
        r107.f571741b = r104;
        Unit r108 = Unit.INSTANCE;
        r106.createRTCEngineEx(r107, r102, r103);
        Intrinsics.checkNotNull(null);
    }
}
