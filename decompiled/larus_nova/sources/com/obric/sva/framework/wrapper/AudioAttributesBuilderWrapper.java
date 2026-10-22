package com.obric.sva.framework.wrapper;

import android.media.AudioAttributes;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class AudioAttributesBuilderWrapper {
    private AudioAttributes.Builder mAudioAttBuilder;

    public AudioAttributes build() {
        return this.mAudioAttBuilder.build();
    }

    public AudioAttributesBuilderWrapper() {
        this.mAudioAttBuilder = new AudioAttributes.Builder();
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return AudioAttributes.Builder.class;
    }

    public AudioAttributes.Builder getAudioAttributesBuilder() {
        return this.mAudioAttBuilder;
    }

    public AudioAttributes.Builder setContentType(int r100) {
        return this.mAudioAttBuilder.setContentType(r100);
    }

    public AudioAttributes.Builder setInternalCapturePreset(int r100) {
        return this.mAudioAttBuilder.setInternalCapturePreset(r100);
    }

    public AudioAttributes.Builder setUsage(int r100) {
        return this.mAudioAttBuilder.setUsage(r100);
    }
}
