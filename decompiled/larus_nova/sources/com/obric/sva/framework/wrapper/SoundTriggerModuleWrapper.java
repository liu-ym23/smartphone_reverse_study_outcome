package com.obric.sva.framework.wrapper;

import android.hardware.soundtrigger.SoundTriggerModule;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes6.dex */
public class SoundTriggerModuleWrapper {
    private SoundTriggerModule soundTriggerModule;

    public void detach() {
        SoundTriggerModule r100 = this.soundTriggerModule;
        if (r100 == null) goto L6;
        r100.detach();
        return;
    }

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return SoundTriggerModule.class;
    }

    public SoundTriggerModuleWrapper(SoundTriggerModule r100) {
        this.soundTriggerModule = r100;
    }

    public int stopRecognition(int r100) {
        SoundTriggerModule r101 = this.soundTriggerModule;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.stopRecognition(r100);
    }

    public int unloadSoundModel(int r100) {
        SoundTriggerModule r101 = this.soundTriggerModule;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.unloadSoundModel(r100);
    }

    public int loadSoundModel(SoundTriggerWrapper.KeyphraseSoundModelWrapper r100, int[] r101) {
        SoundTriggerModule r102 = this.soundTriggerModule;
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.loadSoundModel(r100.getSoundModel(), r101);
    }

    public int startRecognition(int r100, SoundTriggerWrapper.RecognitionConfigWrapper r101) {
        SoundTriggerModule r102 = this.soundTriggerModule;
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.startRecognition(r100, r101.getConfig());
    }
}
