package com.larus.audio.controller;

import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import e78.a;
import e78.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u001a\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0014H\u0016J \u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020#H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u00061"}, d2 = {"Lcom/larus/audio/controller/GlobalAudioController;", "Lcom/larus/audio/controller/IGlobalAudioController;", "<init>", "()V", "mGlobalAudioControllerImpl", "getMGlobalAudioControllerImpl", "()Lcom/larus/audio/controller/IGlobalAudioController;", "mGlobalAudioControllerImpl$delegate", "Lkotlin/Lazy;", "participate", "", "participant", "Lcom/larus/audio/controller/IGlobalAudioParticipant;", "abstain", "getCurrentScene", "", "getCurrentBizScene", "getCurrentState", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "play", "", "scene", "doraScene", "pause", "stop", "playPrevious", "playNext", "increaseSystemVolume", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "decreaseSystemVolume", "setSystemVolume", "getSystemVolumeRatio", "onVolumeChanged", ITTVideoEngineEventSource.KEY_VOLUME, "", "prevVolume", "releaseMediaSession", "notifySystemFocusGrabbed", "registerVolumeChangedListener", "listener", "Lcom/larus/audio/controller/IAudioVolumeChangedListener;", "unregisterVolumeChangedListener", "setDoraCallStatus", "isInCall", "onDoraBudsEvent", "type", "key", "event", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlobalAudioController implements IGlobalAudioController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GlobalAudioController f289658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f289659b = null;

    private GlobalAudioController() {
    }

    static {
        f289658a = new GlobalAudioController();
        f289659b = LazyKt.lazy(new a());
    }

    public static IGlobalAudioController o() {
        return (IGlobalAudioController) f289659b.getValue();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final double e() {
        IGlobalAudioController r100 = o();
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.e();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final String g() {
        IGlobalAudioController r100 = o();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.g();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final String getCurrentScene() {
        IGlobalAudioController r100 = o();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentScene();
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final GlobalAudioStateEnum getCurrentState() {
        IGlobalAudioController r100 = o();
        if (r100 == null) goto L7;
        GlobalAudioStateEnum r101 = r100.getCurrentState();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return GlobalAudioStateEnum.NONE;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void i() {
        IGlobalAudioController r100 = o();
        if (r100 == null) goto L6;
        r100.i();
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r101 = o();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.a(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean b(double r100) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r101 = o();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.b(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean c(double r100) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r101 = o();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.c(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "participant");
        IGlobalAudioController r101 = o();
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean f(String r100) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r101 = o();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.f(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void h(c r100) {
        Intrinsics.checkNotNullParameter(r100, "participant");
        IGlobalAudioController r101 = o();
        if (r101 == null) goto L6;
        r101.h(r100);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean j(String r100) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r101 = o();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.j(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void k(CommonAppletPlugin.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IGlobalAudioController r101 = o();
        if (r101 == null) goto L6;
        r101.k(r100);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean m(double r100) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r101 = o();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.m(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void n(CommonAppletPlugin.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IGlobalAudioController r101 = o();
        if (r101 == null) goto L6;
        r101.n(r100);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean pause(String r100) {
        Intrinsics.checkNotNullParameter("cmd", "scene");
        IGlobalAudioController r101 = o();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.pause(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final boolean stop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IGlobalAudioController r101 = o();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.stop(r100) != true) goto L7;
        return true;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void onVolumeChanged(int r100, int r101) {
        IGlobalAudioController r102 = o();
        if (r102 == null) goto L6;
        r102.onVolumeChanged(r100, r101);
        return;
    }

    @Override // com.larus.audio.controller.IGlobalAudioController
    public final void l(int r100, int r101, int r102) {
        IGlobalAudioController r103 = o();
        if (r103 == null) goto L6;
        r103.l(r100, r101, r102);
        return;
    }
}
