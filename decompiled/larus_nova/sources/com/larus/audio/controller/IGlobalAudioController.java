package com.larus.audio.controller;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import e78.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 *2\u00020\u0001:\u0001*J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\n\u001a\u00020\u000bH&J\u001e\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\bH&J\u001e\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bH&J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000e\u001a\u00020\bH&J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000e\u001a\u00020\bH&J\u001a\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u000e\u001a\u00020\bH&J\b\u0010\u0019\u001a\u00020\u0016H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\rH&J \u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001cH&¨\u0006+"}, d2 = {"Lcom/larus/audio/controller/IGlobalAudioController;", "", "participate", "", "participant", "Lcom/larus/audio/controller/IGlobalAudioParticipant;", "abstain", "getCurrentScene", "", "getCurrentBizScene", "getCurrentState", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "play", "", "scene", "doraScene", "pause", "stop", "playPrevious", "playNext", "increaseSystemVolume", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "decreaseSystemVolume", "setSystemVolume", "getSystemVolumeRatio", "onVolumeChanged", ITTVideoEngineEventSource.KEY_VOLUME, "", "prevVolume", "releaseMediaSession", "notifySystemFocusGrabbed", "registerVolumeChangedListener", "listener", "Lcom/larus/audio/controller/IAudioVolumeChangedListener;", "unregisterVolumeChangedListener", "setDoraCallStatus", "isInCall", "onDoraBudsEvent", "type", "key", "event", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGlobalAudioController {
    boolean a(String r100);

    boolean b(double r100);

    boolean c(double r100);

    void d(c r100);

    double e();

    boolean f(String r100);

    String g();

    String getCurrentScene();

    GlobalAudioStateEnum getCurrentState();

    void h(c r100);

    void i();

    boolean j(String r100);

    void k(CommonAppletPlugin.b r100);

    void l(int r100, int r101, int r102);

    boolean m(double r100);

    void n(CommonAppletPlugin.b r100);

    void onVolumeChanged(int r100, int r101);

    boolean pause(String r100);

    boolean stop(String r100);
}
