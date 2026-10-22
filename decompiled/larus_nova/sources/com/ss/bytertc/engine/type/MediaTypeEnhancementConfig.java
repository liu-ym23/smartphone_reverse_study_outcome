package com.ss.bytertc.engine.type;

/* JADX INFO: loaded from: classes40.dex */
public class MediaTypeEnhancementConfig {
    public boolean adaptiveEnhance;
    public boolean enhanceAudio;
    public boolean enhanceScreenAudio;
    public boolean enhanceScreenVideo;
    public boolean enhanceSignaling;
    public boolean enhanceVideo;

    public MediaTypeEnhancementConfig() {
        this.enhanceSignaling = false;
        this.enhanceAudio = false;
        this.enhanceVideo = false;
        this.enhanceScreenAudio = false;
        this.enhanceScreenVideo = false;
        this.adaptiveEnhance = true;
    }

    public MediaTypeEnhancementConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.adaptiveEnhance = true;
        this.enhanceSignaling = r100;
        this.enhanceAudio = r101;
        this.enhanceVideo = r102;
        this.enhanceScreenAudio = r103;
        this.enhanceScreenVideo = r104;
    }

    public MediaTypeEnhancementConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.enhanceSignaling = r100;
        this.enhanceAudio = r101;
        this.enhanceVideo = r102;
        this.enhanceScreenAudio = r103;
        this.enhanceScreenVideo = r104;
        this.adaptiveEnhance = r105;
    }
}
