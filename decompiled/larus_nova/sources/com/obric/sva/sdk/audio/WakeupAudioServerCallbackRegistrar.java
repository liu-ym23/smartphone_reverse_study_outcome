package com.obric.sva.sdk.audio;

import android.media.AudioManager;
import com.obric.sva.framework.api.ISvaFrameworkKt;
import com.obric.sva.framework.wrapper.AudioManagerWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
public final class WakeupAudioServerCallbackRegistrar {
    private WakeupAudioServerCallbackRegistrar() {
    }

    public static void clear(AudioManager r100) {
        ISvaFrameworkKt.getSvaFrameworkDelegate().clearAudioServerStateCallback(r100);
    }

    public static void register(AudioManager r100, Executor r101, AudioManagerWrapper.AudioServerStateCallbackWrapper r102) {
        ISvaFrameworkKt.getSvaFrameworkDelegate().setAudioServerStateCallback(r100, r101, r102);
    }
}
