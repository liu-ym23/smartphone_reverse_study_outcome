package com.ss.bytertc.engine.type;

/* JADX INFO: loaded from: classes40.dex */
public class AudioEnhancementConfig {
    public boolean enhanceAudio;
    public boolean enhanceSignaling;

    public AudioEnhancementConfig() {
        this.enhanceSignaling = false;
        this.enhanceAudio = false;
    }

    public AudioEnhancementConfig(boolean r100, boolean r101) {
        this.enhanceSignaling = r100;
        this.enhanceAudio = r101;
    }
}
