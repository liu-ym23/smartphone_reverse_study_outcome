package com.ss.videoarch.liveplayer;

import android.graphics.Bitmap;
import android.view.Surface;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface g0 extends IABRObserver {
    @Override // com.ss.videoarch.liveplayer.IABRObserver
    /* synthetic */ void didAutomaticallySwitch(s r100, b0 r101, b0 r102, JSONObject r103);

    void onAudioDeviceClose(s r100);

    void onAudioDeviceOpen(s r100, int r101, int r102, int r103);

    void onAudioDeviceRelease(s r100);

    void onAudioFrameRenderMetaInfo(s r100, u r101);

    void onAudioRenderStall(s r100, long r101);

    void onAudioVolume(s r100, v r101);

    void onBinarySeiUpdate(s r100, ByteBuffer r101);

    void onError(s r100, f0 r101);

    void onFirstAudioFrameRender(s r100, boolean r101);

    void onFirstVideoFrameRender(s r100, boolean r101);

    void onHeadPoseUpdate(s r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107);

    void onLoudness(s r100, r r101);

    void onMainBackupSwitch(s r100, VeLivePlayerDef$VeLivePlayerStreamType r101, f0 r102);

    void onMonitorLog(s r100, JSONObject r101, String r102);

    String onMuteIssueWarning();

    void onNetworkQualityChanged(s r100, int r101, String r102);

    void onPlayerStatusUpdate(s r100, VeLivePlayerDef$VeLivePlayerStatus r101);

    void onReceiveSeiMessage(s r100, String r101);

    void onRenderAudioFrame(s r100, t r101);

    void onRenderVideoFrame(s r100, j0 r101);

    void onReportALog(s r100, int r101, String r102);

    void onResolutionDegrade(s r100, b0 r101);

    void onResolutionSwitch(s r100, b0 r101, f0 r102, VeLivePlayerDef$VeLivePlayerResolutionSwitchReason r103);

    void onResponseSmoothSwitch(s r100, boolean r101, int r102);

    void onSnapshotComplete(s r100, Bitmap r101);

    void onStallEnd(s r100);

    void onStallStart(s r100);

    void onStatistics(s r100, h0 r101);

    void onStreamFailedOpenSuperResolution(s r100, f0 r101);

    void onTextureRenderDrawFrame(s r100, Surface r101);

    void onVideoFrameRenderMetaInfo(s r100, k0 r101);

    void onVideoRenderStall(s r100, long r101);

    void onVideoSizeChanged(s r100, int r101, int r102);

    @Override // com.ss.videoarch.liveplayer.IABRObserver
    /* synthetic */ IABRObserver.SwitchPermissionRequestResult shouldAutomaticallySwitch(s r100, b0 r101, b0 r102, JSONObject r103);
}
