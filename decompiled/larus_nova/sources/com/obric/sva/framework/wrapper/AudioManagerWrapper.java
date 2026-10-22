package com.obric.sva.framework.wrapper;

import android.media.AudioManager;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class AudioManagerWrapper {

    /* JADX INFO: loaded from: classes6.dex */
    public static class AudioServerStateCallbackWrapper {
        public AudioManager.AudioServerStateCallback mAudioServerStateCallback;

        public void onAudioServerDownExt() {
        }

        public void onAudioServerUpExt() {
        }

        public AudioServerStateCallbackWrapper() {
            this.mAudioServerStateCallback = new AnonymousClass1(this);
        }

        @JvmStatic
        public static Class<?> getWrapperClazz() {
            return AudioManager.AudioServerStateCallback.class;
        }
    }

    public AudioManagerWrapper() {
    }
}
