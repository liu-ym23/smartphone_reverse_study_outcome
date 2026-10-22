package com.mammon.audiosdk.bridge;

import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.SAMICoreHostCallBackListener;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreVopSpeakerInfoCommand;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreDebugConfig;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerAudioMetricParameter;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerConfig;
import com.mammon.audiosdk.structures.SAMICoreVopAudioCheckerOnlineAsrParameter;
import com.mammon.audiosdk.structures.SAMICoreVopInitContext;
import com.mammon.audiosdk.structures.SAMICoreVopRecordingStatus;
import com.mammon.audiosdk.structures.SAMICoreVopSpeakerInfo;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreHostBridge implements SAMICoreBridge {
    private SAMICoreHostCallBackListener hostCallBackListener;
    private SAMICoreCallBackListener listener;

    public SAMICoreHostBridge() {
    }

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int AudioChecker_native_checkAudioQuality(long r100, byte[] r101, int r102, String r103, int[] r104);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long AudioChecker_native_createEngine();

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native void AudioChecker_native_destroyEngine(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int AudioChecker_native_init(long r100, SAMICoreVopAudioCheckerConfig r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int AudioChecker_native_setAudioMetricParameter(long r100, SAMICoreVopAudioCheckerAudioMetricParameter r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int AudioChecker_native_setOnlineAsrParameter(long r100, SAMICoreVopAudioCheckerOnlineAsrParameter r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long Native_SAMICoreCreateHandleByIdentify(int r100, Object r101, int[] r102);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int Native_SAMICoreDestroyHandle(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int Native_SAMICoreGetPropertyById(long r100, int r101, SAMICoreProperty r102);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long Native_SAMICoreInitContext(int r100, Object r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int Native_SAMICoreInitDebugConfig(long r100, SAMICoreDebugConfig r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int Native_SAMICoreProcess(long r100, int r101, SAMICoreBlock r102, SAMICoreBlock r103);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int Native_SAMICoreProcessAsync(long r100, int r101, SAMICoreBlock r102);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long Native_SAMICoreRegisterLogger(Object r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long Native_SAMICoreRegisterServerParamRequestCallback(Object r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long Native_SAMICoreRegisterSpeechWakeupParamRequestCallback(Object r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long Native_SAMICoreRegisterTraceSpanCallback(Object r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long Native_SAMICoreRegisterWakeupParamRequestCallback(Object r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int Native_SAMICoreReleaseContext(int r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int Native_SAMICoreReleaseDebugConfig(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int Native_SAMICoreSetProperty(long r100, int r101, SAMICoreProperty r102);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long Native_SAMICoreUnregisterLogger(Object r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long VopEngine_native_createEngine();

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native void VopEngine_native_destroyEngine(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native float VopEngine_native_getCurrentPositionMs(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_getCurrentState(long r100, int[] r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_getNextTextInfo(long r100, Object[] r101, int[] r102);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_getRecordingStatus(long r100, SAMICoreVopRecordingStatus r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_getSpeakerInfo(long r100, SAMICoreVopSpeakerInfo r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native float VopEngine_native_getTotalDurationMs(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_init(long r100, SAMICoreVopInitContext r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_manageSpeakerInfo(long r100, SAMICoreVopSpeakerInfoCommand r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_play(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_preparePlayer(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_processRecordAudio(long r100, byte[] r101, int r102, int[] r103);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopEngine_native_stop(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native long VopInstantEngine_native_createEngine();

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native void VopInstantEngine_native_destroyEngine(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_getCurrentState(long r100, int[] r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_getNextTextInfo(long r100, Object[] r101, int[] r102);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_getSpeakerInfo(long r100, SAMICoreVopSpeakerInfo r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_init(long r100, SAMICoreVopInitContext r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_manageSpeakerInfo(long r100, SAMICoreVopSpeakerInfoCommand r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_play(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_preparePlayer(long r100, String r101);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_processRecordAudio(long r100, byte[] r101, int r102, int[] r103);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public native int VopInstantEngine_native_stop(long r100);

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public void setHostCallBackListener(SAMICoreHostCallBackListener r100) {
        this.hostCallBackListener = r100;
    }

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public void setListener(SAMICoreCallBackListener r100) {
        this.listener = r100;
    }

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public void onMessageReceived(int r100, SAMICoreBlock r101) {
        SAMICoreCallBackListener r102 = this.listener;
        if (r102 == null) goto L6;
        r102.onMessageReceived(SAMICoreCallBackEventType.fromInt(r100), r101);
        return;
    }

    @Override // com.mammon.audiosdk.bridge.SAMICoreBridge
    public void onSendToHost(int r100, SAMICoreBlock r101) {
        SAMICoreHostCallBackListener r102 = this.hostCallBackListener;
        if (r102 == null) goto L6;
        r102.onSendToHost(SAMICoreCallBackEventType.fromInt(r100), r101);
        return;
    }
}
