package com.ss.bytertc.engine;

import com.ss.bytertc.engine.type.AudioEnhancementConfig;

/* JADX INFO: loaded from: classes40.dex */
public class InternalAudioEnhancementConfig {
    public boolean enhanceAudio;
    public boolean enhanceSignaling;

    public boolean getAudioEnhance() {
        return this.enhanceAudio;
    }

    public boolean getSignalingEnhance() {
        return this.enhanceSignaling;
    }

    public InternalAudioEnhancementConfig(AudioEnhancementConfig r100) {
        this.enhanceSignaling = false;
        this.enhanceAudio = false;
        this.enhanceSignaling = r100.enhanceSignaling;
        this.enhanceAudio = r100.enhanceAudio;
    }
}
