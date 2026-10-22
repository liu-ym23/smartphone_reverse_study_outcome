package com.mammon.audiosdk;

import com.bytedance.speech.speechaudio.SpeechAudioLoader;
import com.mammon.audiosdk.bridge.SAMICoreBridge;
import com.mammon.audiosdk.enums.SAMICoreVopAudioCheckerResult;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerAudioMetricParameter;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerConfig;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerOnlineAsrParameter;

/* JADX INFO: loaded from: classes32.dex */
public final class SAMICoreVopAudioChecker {
    private static SAMICoreBridge bridge;
    private volatile long engine;

    public void destroyEngine() {
        bridge.AudioChecker_native_destroyEngine(this.engine);
    }

    static {
        SpeechAudioLoader.getInstance().load();
        bridge = SpeechAudioLoader.getInstance().createSAMICoreBridge();
    }

    public SAMICoreVopAudioChecker() {
        this.engine = bridge.AudioChecker_native_createEngine();
    }

    public int init(SAMICoreVopAudioCheckerConfig r100) {
        return bridge.AudioChecker_native_init(this.engine, r100);
    }

    public int setAudioMetricParameter(SAMICoreVopAudioCheckerAudioMetricParameter r100) {
        return bridge.AudioChecker_native_setAudioMetricParameter(this.engine, r100);
    }

    public int setOnlineAsrParameter(SAMICoreVopAudioCheckerOnlineAsrParameter r100) {
        return bridge.AudioChecker_native_setOnlineAsrParameter(this.engine, r100);
    }

    public int checkAudioQuality(byte[] r100, int r110, String r111, SAMICoreVopAudioCheckerResult[] r112) {
        int[] r101 = new int[1];
        int r102 = bridge.AudioChecker_native_checkAudioQuality(this.engine, r100, r110, r111, r101);
        r112[0] = SAMICoreVopAudioCheckerResult.values()[r101[0]];
        return r102;
    }
}
