package com.ss.bytertc.engine;

import com.ss.bytertc.engine.type.MediaTypeEnhancementConfig;

/* JADX INFO: loaded from: classes40.dex */
public class InternalMediaTypeEnhancementConfig {
    public boolean adaptiveEnhance;
    public boolean enhanceAudio;
    public boolean enhanceScreenAudio;
    public boolean enhanceScreenVideo;
    public boolean enhanceSignaling;
    public boolean enhanceVideo;

    public boolean getAdaptiveEnhance() {
        return this.adaptiveEnhance;
    }

    public boolean getAudioEnhance() {
        return this.enhanceAudio;
    }

    public boolean getScreenAudioEnhance() {
        return this.enhanceScreenAudio;
    }

    public boolean getScreenVideoEnhance() {
        return this.enhanceScreenVideo;
    }

    public boolean getSignalingEnhance() {
        return this.enhanceSignaling;
    }

    public boolean getVideoEnhance() {
        return this.enhanceVideo;
    }

    public InternalMediaTypeEnhancementConfig(MediaTypeEnhancementConfig r100) {
        this.enhanceSignaling = false;
        this.enhanceAudio = false;
        this.enhanceVideo = false;
        this.enhanceScreenAudio = false;
        this.enhanceScreenVideo = false;
        this.adaptiveEnhance = false;
        this.enhanceSignaling = r100.enhanceSignaling;
        this.enhanceAudio = r100.enhanceAudio;
        this.enhanceVideo = r100.enhanceVideo;
        this.enhanceScreenAudio = r100.enhanceScreenAudio;
        this.enhanceScreenVideo = r100.enhanceScreenVideo;
        this.adaptiveEnhance = r100.adaptiveEnhance;
    }
}
