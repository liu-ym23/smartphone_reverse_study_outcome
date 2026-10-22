package com.bytedance.speech.speechengine.bridge;

import android.content.res.AssetManager;

/* JADX INFO: loaded from: classes22.dex */
public class SpeechEngineBridge implements SpeechBridge {
    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native long createEngineToNative(SpeechBridgeCallback r100);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native void destroyEngineToNative(long r100);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native int feedAudioToNative(long r100, byte[] r101, int r102);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native int fetchResultToNative(long r100, int r101, byte[] r102);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native String fetchStringResultToNative(long r100, int r101);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native String getVersionToNative();

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native int initEngineToNative(long r100, AssetManager r101);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native boolean isEngineSupportedToNative(String r100);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native int processAudioToNative(long r100, byte[] r101, int r102, boolean r103);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native int resetEngineToNative(long r100);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native int sendDirectiveToNative(long r100, int r101, String r102);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native void setOptionBooleanToNative(long r100, String r101, boolean r102);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native void setOptionDoubleToNative(long r100, String r101, double r102);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native void setOptionIntToNative(long r100, String r101, int r102);

    @Override // com.bytedance.speech.speechengine.bridge.SpeechBridge
    public native void setOptionStringToNative(long r100, String r101, String r102);

    public SpeechEngineBridge() {
    }
}
