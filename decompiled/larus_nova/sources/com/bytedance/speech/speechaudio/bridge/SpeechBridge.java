package com.bytedance.speech.speechaudio.bridge;

import android.content.res.AssetManager;

/* JADX INFO: loaded from: classes22.dex */
public interface SpeechBridge {
    long createEngineToNative(SpeechBridgeCallback r100);

    void destroyEngineToNative(long r100);

    int feedAudioToNative(long r100, byte[] r101, int r102);

    int fetchResultToNative(long r100, int r101, byte[] r102);

    String fetchStringResultToNative(long r100, int r101);

    String getVersionToNative();

    int initEngineToNative(long r100, AssetManager r101);

    boolean isEngineSupportedToNative(String r100);

    int processAudioToNative(long r100, byte[] r101, int r102, boolean r103);

    int resetEngineToNative(long r100);

    int sendDirectiveToNative(long r100, int r101, String r102);

    void setOptionBooleanToNative(long r100, String r101, boolean r102);

    void setOptionDoubleToNative(long r100, String r101, double r102);

    void setOptionIntToNative(long r100, String r101, int r102);

    void setOptionStringToNative(long r100, String r101, String r102);
}
