package com.ss.videoarch.liveplayer2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.Surface;
import com.ss.ttm.player.TTPlayer;
import com.ss.vcbkit.VCBaseKitLoader;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class VeLivePlayer {
    private native void cpp_addExtraHttpRequestHeadersByUser(int r100, String r101);

    private native void cpp_addExtraSurface(int r100, Surface r101, VeLivePlayerExtraRenderParams r102, boolean r103);

    private native void cpp_destroy(int r100);

    private native void cpp_enableAudioFrameObserver(int r100, boolean r101, boolean r102, VeLivePlayerAudioBufferType r103);

    private native void cpp_enableVideoEffect(int r100, VeLivePlayerVideoEffectType r101, boolean r102, String r103);

    private native void cpp_enableVideoFrameObserver(int r100, boolean r101, VeLivePlayerPixelFormat r102, VeLivePlayerVideoBufferType r103);

    private native void cpp_enableVideoRender(int r100, boolean r101);

    private native String cpp_executeVePlayerCommand(int r100, int r101, int r102, int r103);

    private native VeLivePlayerVideoEffectManager cpp_getEffectManager(int r100);

    private native float cpp_getFloatProperty(int r100, String r101, float r102);

    private native int cpp_getIntProperty(int r100, String r101, int r102);

    private native float cpp_getPlayerVolume(int r100);

    private native List<Object> cpp_getStreamList(int r100);

    private native String cpp_getStringProperty(int r100, String r101, String r102);

    private native VeLivePlayerStatus cpp_getVeLivePlayerStatus(int r100);

    private static native String cpp_getVersion();

    private native VeLivePlayerVideoStreamInfo cpp_getVideoStreamInfo(int r100);

    private native void cpp_initVideoEffect(int r100, VeLivePlayerVideoEffectType r101, VeLivePlayerEffectParams r102);

    private native int cpp_initWithContext(int r100, Context r101);

    private native boolean cpp_isMute(int r100);

    private native boolean cpp_isPlaying(int r100);

    private native int cpp_isSupportResolutionSwitch(int r100, VeLivePlayerResolution r101);

    private native boolean cpp_isVideoEffectUsed(int r100, VeLivePlayerVideoEffectType r101);

    private native void cpp_onTouchEvent(int r100, MotionEvent r101);

    private native void cpp_pause(int r100);

    private native void cpp_play(int r100);

    private native void cpp_prePlaySwitchRes(int r100);

    private native void cpp_prePrepare(int r100, String r101, VeLivePlayerResolution r102);

    private native void cpp_preProcessor(int r100, String r101, VeLivePlayerResolution r102, String r103);

    private native void cpp_removeExtraSurface(int r100, Surface r101, boolean r102);

    private native void cpp_resetSurfaceExtraToMain(int r100, Surface r101, boolean r102);

    private native void cpp_setAesBoostConfig(int r100, VeLivePlayerAesBoostConfig r101);

    private static native void cpp_setAppChannel(String r100);

    private native void cpp_setAppInfoFetcher(int r100, IAppInfoFetcher r101);

    private native boolean cpp_setConfig(int r100, VeLivePlayerConfiguration r101);

    private native void cpp_setEnableSuperResolution(int r100, boolean r101);

    private native void cpp_setFloatProperty(int r100, String r101, float r102);

    private static native void cpp_setGlobalObserver(VeLivePlayerGlobalObserver r100);

    private native void cpp_setIntProperty(int r100, String r101, int r102);

    private native void cpp_setLiveEnsure(int r100, ILiveEnsurerListener r101);

    private static native void cpp_setLogConfig(VeLivePlayerLogConfig r100);

    private static native void cpp_setLogLevel(VeLivePlayerLogLevel r100);

    private native void cpp_setLongProperty(int r100, String r101, long r102);

    private native void cpp_setMute(int r100, boolean r101);

    private native void cpp_setNetworkClient(int r100, INetworkClient r101);

    private native void cpp_setObserver(int r100, VeLivePlayerObserver r101);

    private native void cpp_setPlayStreamData(int r100, VeLivePlayerStreamData r101);

    private native void cpp_setPlayUrl(int r100, String r101);

    private native void cpp_setPlayerVolume(int r100, float r101);

    private native boolean cpp_setPullControlMessageInfo(int r100, String r101);

    private native void cpp_setRenderFillMode(int r100, VeLivePlayerFillMode r101);

    private native void cpp_setRenderMirror(int r100, VeLivePlayerMirror r101);

    private native void cpp_setRenderRotation(int r100, VeLivePlayerRotation r101);

    private native void cpp_setSRConfig(int r100, VeLivePlayerSRConfig r101);

    private native void cpp_setSettingsBundle(int r100, ILiveSettingBundle r101);

    private native void cpp_setSharpenConfig(int r100, VeLivePlayerSharpenConfig r101);

    private native void cpp_setStartPlayResolution(int r100, VeLivePlayerResolution r101);

    private native void cpp_setStreamDataInfo(int r100, String r101);

    private native void cpp_setStringProperty(int r100, String r101, String r102);

    private native void cpp_setSurface(int r100, Surface r101, boolean r102);

    private native void cpp_setSwitchTimeShift(int r100, int r101);

    private native void cpp_setUrlHostIP(int r100, String r101);

    private native void cpp_setUsingCellularNetwork(int r100, boolean r101);

    private native void cpp_setVideoCropArea(int r100, VeLivePlayerVideoArea r101, boolean r102);

    private native Bitmap cpp_snapshot(int r100, VeLivePlayerVideoArea r101, boolean r102);

    private static native int cpp_startLiveIO();

    private native void cpp_startMuteIssueMonitoring(int r100, int r101);

    private static native void cpp_startNodeOptimize(INetworkClient r100, boolean r101);

    private native void cpp_stop(int r100);

    private static native void cpp_stopLiveIO();

    private native void cpp_stopMuteIssueMonitoring(int r100);

    private static native void cpp_stopNodeOptimize();

    private native VeLivePlayerSupportResolutionSwitchError cpp_switchResolution(int r100, VeLivePlayerResolution r101, VeLivePlayerResolutionSwitchMethod r102);

    private native int cpp_switchToCellularNetwork(int r100, int r101, String r102);

    private native int cpp_switchToDefaultNetwork(int r100, int r101, String r102);

    private static native boolean cpp_updateGlobalConfig(VeLivePlayerGlobalConfigType r100, String r101);

    private native void cpp_updateSVCParams(int r100, boolean r101, int r102, int r103);

    private native void cpp_updateVideoEffect(int r100, VeLivePlayerVideoEffectType r101, VeLivePlayerEffectParams r102);

    private native void cpp_updateVideoStreamTransmissionStateIfPossible(int r100, boolean r101);

    static {
        VCBaseKitLoader.loadLibrary();
        TTPlayer.getAppPath();
    }
}
