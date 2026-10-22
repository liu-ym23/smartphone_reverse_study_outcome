package com.ss.ttvideoengine;

import android.os.Bundle;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.effect.EffectConfig;

/* JADX INFO: loaded from: classes34.dex */
public interface TextureRenderStrategyInterface {
    public static final String KEY_STRATEGY_HAS_FIRST_FRAME_SHOW = "HasFirstFrameShown";
    public static final String KEY_TRERENDERCONFIG_ASYNCINIT = "asyncInit";

    void didInitTextureRender(VideoSurface r100);

    boolean isInitEffect();

    boolean isNeedAsyncEffect(EffectConfig r100);

    boolean isPlaybackUse();

    void onRenderStart(float r100, VideoSurface r101, boolean r102);

    void reset(VideoSurface r100, boolean r101);

    void setEffect(Bundle r100, VideoSurface r101);

    void setIsInitEffect(boolean r100);
}
