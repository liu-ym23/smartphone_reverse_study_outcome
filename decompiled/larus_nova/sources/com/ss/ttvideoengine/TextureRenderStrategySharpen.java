package com.ss.ttvideoengine;

import android.os.Bundle;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* JADX INFO: loaded from: classes34.dex */
public class TextureRenderStrategySharpen implements TextureRenderStrategyInterface {
    private boolean mAsyncInit;
    private Bundle mInitBundle;
    private boolean mIsInitSharpen;
    private boolean mOpensharpen;
    private boolean mPlaybackUseSharpen;

    public TextureRenderStrategySharpen() {
        this.mIsInitSharpen = false;
        this.mOpensharpen = false;
        this.mPlaybackUseSharpen = false;
        this.mAsyncInit = false;
        this.mInitBundle = null;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public boolean isInitEffect() {
        return this.mIsInitSharpen;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public boolean isPlaybackUse() {
        return this.mPlaybackUseSharpen;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void didInitTextureRender(VideoSurface r100) {
        this.mInitBundle.putInt(TextureRenderKeys.KEY_IS_ENABLE_BMF, EngineGlobalConfig.getInstance().getEnableBmf());
        this.mInitBundle.putString(TextureRenderKeys.KEY_MODULE_NAME, FeatureManager.getModuleName());
        r100.setEffect(this.mInitBundle);
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public boolean isNeedAsyncEffect(EffectConfig r100) {
        this.mPlaybackUseSharpen = this.mIsInitSharpen;
        if (this.mAsyncInit == false) goto L6;
        r100.setEffectOpen(1, 1);
    L6:
        return this.mAsyncInit;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void setIsInitEffect(boolean r100) {
        this.mIsInitSharpen = r100;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void reset(VideoSurface r100, boolean r101) {
        openSharpen(false, r100, r101);
        this.mIsInitSharpen = false;
        this.mOpensharpen = false;
        this.mPlaybackUseSharpen = false;
        this.mAsyncInit = false;
        this.mInitBundle = null;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void setEffect(Bundle r100, VideoSurface r101) {
        if (r100.getInt("action") != 21) goto L6;
        this.mIsInitSharpen = true;
        this.mOpensharpen = r100.getBoolean(TextureRenderKeys.KEY_IS_USE_EFFECT);
        this.mAsyncInit = r100.getBoolean(TextureRenderStrategyInterface.KEY_TRERENDERCONFIG_ASYNCINIT);
        this.mInitBundle = r100;
        return;
    L6:
        if (r100.getInt("action") != 19) goto L10;
        this.mOpensharpen = r100.getBoolean(TextureRenderKeys.KEY_IS_USE_EFFECT);
        boolean r102 = r100.getBoolean(TextureRenderStrategyInterface.KEY_STRATEGY_HAS_FIRST_FRAME_SHOW);
        openSharpen(this.mOpensharpen, r101, r102);
        return;
    }

    private void openSharpen(boolean r100, VideoSurface r101, boolean r102) {
        this.mOpensharpen = r100;
        if (r101 == null) goto L16;
        if (r102 == false) goto L17;
        Bundle r103 = new Bundle();     // Catch: Exception -> L11
        r103.putInt("action", 19);     // Catch: Exception -> L11
        int r104 = 1;
        r103.putInt("effect_type", 1);     // Catch: Exception -> L11
        if (this.mOpensharpen == true) goto L9;
        r104 = 0;
    L9:
        r103.putInt(TextureRenderKeys.KEY_IS_INT_VALUE, r104);     // Catch: Exception -> L11
        r101.setEffect(r103);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        TTVideoEngineLog.i("[SALog]", "[SALog]doOpenSharpen catch exception e=" + e);
        return;
    L17:
        return;
    }

    @Override // com.ss.ttvideoengine.TextureRenderStrategyInterface
    public void onRenderStart(float r100, VideoSurface r101, boolean r102) {
        boolean r103 = this.mOpensharpen;
        if (r100 < 31.0f) goto L5;
    L6:
        r103 = false;
    L7:
        this.mOpensharpen = r103;
        openSharpen(r103, r101, r102);
        return;
    L5:
        if (r100 > 0.0f) goto L7;
        goto L6
    }
}
