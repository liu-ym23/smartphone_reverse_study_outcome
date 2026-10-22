package com.ss.ttvideoengine;

import android.os.Bundle;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.effect.EffectConfig;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public class TextureRenderStrategy {
    private HashMap<Integer, TextureRenderStrategyInterface> strategyMap;

    public TextureRenderStrategy() {
        this.strategyMap = new HashMap();
    }

    public void didInitTextureRender(VideoSurface r100) {
        Iterator<TextureRenderStrategyInterface> r101 = this.strategyMap.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().didInitTextureRender(r100);
        goto L4
    }

    public boolean getAsyncEffect(EffectConfig r100) {
        Iterator<TextureRenderStrategyInterface> r101 = this.strategyMap.values().iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L8;
        boolean r103 = r101.next().isNeedAsyncEffect(r100);
        if (r103 == false) goto L4;
        r102 = r103;
        goto L4
    L8:
        return r102;
    }

    public boolean isInitForEffect(int r100) {
        TextureRenderStrategyInterface r101 = this.strategyMap.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.isInitEffect();
    }

    public boolean isPlaybackUseForEffect(int r100) {
        TextureRenderStrategyInterface r101 = this.strategyMap.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.isPlaybackUse();
    }

    public void reset(VideoSurface r100, boolean r101) {
        Iterator<TextureRenderStrategyInterface> r102 = this.strategyMap.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().reset(r100, r101);
        goto L4
    }

    public void setEffect(Bundle r100, VideoSurface r101) {
        int r102 = r100.getInt("effect_type");
        TextureRenderStrategyInterface r103 = this.strategyMap.get(Integer.valueOf(r102));
        if (r103 == null) goto L5;
    L10:
        if (r103 == null) goto L13;
        r103.setEffect(r100, r101);
        return;
    L13:
        return;
    L5:
        if (r100.getInt("action") != 21) goto L10;
        if (r102 != 1) goto L10;
        r103 = new TextureRenderStrategySharpen();
        this.strategyMap.put(1, r103);
        goto L10
    }

    public void setIsInitForEffect(int r100, boolean r101) {
        TextureRenderStrategyInterface r102 = this.strategyMap.get(Integer.valueOf(r100));
        if (r102 == null) goto L6;
        r102.setIsInitEffect(r101);
        return;
    }

    public void onRenderStart(float r100, VideoSurface r101, boolean r102) {
        Iterator<TextureRenderStrategyInterface> r103 = this.strategyMap.values().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onRenderStart(r100, r101, r102);
        goto L4
    }
}
