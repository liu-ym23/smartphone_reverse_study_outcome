package com.ss.videoarch.liveplayer;

import android.view.Surface;
import com.ss.videoarch.liveplayer.log.LiveError;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface e {

    public interface a {
        void onLoudness(float r100, float r101, float r102, boolean r103);
    }

    void onAbrSwitch(String r100, int r101);

    void onAudioFrameRenderMetaInfo(u r100);

    void onAudioRenderStall(int r100);

    void onBinarySeiUpdate(ByteBuffer r100);

    void onCacheFileCompletion();

    void onCompletion();

    void onError(LiveError r100);

    void onFirstFrame(boolean r100);

    void onHeadPoseUpdate(float r100, float r101, float r102, float r103, float r104, float r105, float r106);

    void onMonitorLog(JSONObject r100, String r101);

    String onMuteIssueWarning();

    void onNetworkQualityChanged(int r100, String r101);

    void onPrepared();

    void onReportALog(int r100, String r101);

    void onResolutionDegrade(String r100);

    void onResolutionSwitch(b0 r100, f0 r101, VeLivePlayerDef$VeLivePlayerResolutionSwitchReason r102);

    void onResponseSmoothSwitch(boolean r100, int r101);

    void onSeiUpdate(String r100);

    void onStallEnd();

    void onStallStart();

    void onTextureRenderDrawFrame(Surface r100);

    void onVideoFrameRenderMetaInfo(k0 r100);

    void onVideoRenderStall(int r100);

    void onVideoSizeChanged(int r100, int r101);
}
