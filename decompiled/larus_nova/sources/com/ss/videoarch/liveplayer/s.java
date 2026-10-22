package com.ss.videoarch.liveplayer;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.ss.videoarch.liveplayer.log.VeLivePlayerLogConfig;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public abstract class s {
    public s() {
    }

    public static String getVersion() {
        return "1.10.260.2-aweme";
    }

    public abstract void destroy();

    public abstract void enableAudioFrameObserver(boolean r100, boolean r101, VeLivePlayerDef$VeLivePlayerAudioBufferType r102);

    public abstract void enableVideoFrameObserver(boolean r100, VeLivePlayerDef$VeLivePlayerPixelFormat r101, VeLivePlayerDef$VeLivePlayerVideoBufferType r102);

    public abstract boolean isMute();

    public abstract boolean isPlaying();

    public abstract int isSupportResolutionSwitch(b0 r100);

    public abstract void pause();

    public abstract void play();

    public abstract void setAesBoostConfig(y r100);

    public abstract void setConfig(w r100);

    public abstract void setEnableSuperResolution(boolean r100);

    public abstract void setIAppInfoFetcher(b r100);

    public abstract void setLiveEnsuer(d r100);

    public abstract void setMute(boolean r100);

    public abstract void setNetworkClient(h r100);

    public abstract void setObserver(g0 r100);

    public abstract void setPlayStreamData(i0 r100);

    public abstract void setPlayUrl(String r100);

    public abstract void setPlayerVolume(float r100);

    public abstract void setProperty(String r100, Object r101);

    public abstract void setRenderFillMode(VeLivePlayerDef$VeLivePlayerFillMode r100);

    public abstract void setRenderMirror(VeLivePlayerDef$VeLivePlayerMirror r100);

    public abstract void setRenderRotation(VeLivePlayerDef$VeLivePlayerRotation r100);

    public abstract void setSdkParamsJson(String r100, String r101, JSONObject r102);

    public abstract void setSettingsBundle(g r100);

    public abstract void setSharpenConfig(c0 r100);

    public abstract void setSrConfig(d0 r100);

    public abstract void setStreamInfoAndSdkParams(JSONObject r100, String r101, String r102, JSONObject r103);

    public abstract void setSurface(Surface r100);

    public abstract void setSurfaceHolder(SurfaceHolder r100);

    public abstract void setUrlHostIP(Map<String, List<String>> r100);

    public abstract int snapshot();

    public abstract void stop();

    public abstract boolean switchResolution(b0 r100);

    public static void setLogConfig(VeLivePlayerLogConfig r100) {
        com.ss.videoarch.liveplayer.log.e.setLogConfig(r100);
    }

    public static void setLogLevel(VeLivePlayerLogConfig.VeLivePlayerLogLevel r100) {
        com.ss.videoarch.liveplayer.log.c.setLogLevel(r100);
    }
}
