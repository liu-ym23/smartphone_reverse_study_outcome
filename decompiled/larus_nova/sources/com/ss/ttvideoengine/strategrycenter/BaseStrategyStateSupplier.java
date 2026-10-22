package com.ss.ttvideoengine.strategrycenter;

import androidx.camera.video.AudioStats;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class BaseStrategyStateSupplier implements IStrategyStateSupplier {
    public BaseStrategyStateSupplier() {
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public double getNetworkSpeed() {
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Object> mediaInfo(String r100) {
        return null;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Integer> selectBitrate(StrategyMediaParam r100) {
        return null;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Integer> selectBitrate(String r100, int r101) {
        return null;
    }
}
