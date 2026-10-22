package com.mammon.audiosdk.bridge;

import com.mammon.audiosdk.SAMICoreCallBackListener;
import com.mammon.audiosdk.SAMICoreHostCallBackListener;
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
public interface SAMICoreBridge {
    int AudioChecker_native_checkAudioQuality(long r100, byte[] r101, int r102, String r103, int[] r104);

    long AudioChecker_native_createEngine();

    void AudioChecker_native_destroyEngine(long r100);

    int AudioChecker_native_init(long r100, SAMICoreVopAudioCheckerConfig r101);

    int AudioChecker_native_setAudioMetricParameter(long r100, SAMICoreVopAudioCheckerAudioMetricParameter r101);

    int AudioChecker_native_setOnlineAsrParameter(long r100, SAMICoreVopAudioCheckerOnlineAsrParameter r101);

    long Native_SAMICoreCreateHandleByIdentify(int r100, Object r101, int[] r102);

    int Native_SAMICoreDestroyHandle(long r100);

    int Native_SAMICoreGetPropertyById(long r100, int r101, SAMICoreProperty r102);

    long Native_SAMICoreInitContext(int r100, Object r101);

    int Native_SAMICoreInitDebugConfig(long r100, SAMICoreDebugConfig r101);

    int Native_SAMICoreProcess(long r100, int r101, SAMICoreBlock r102, SAMICoreBlock r103);

    int Native_SAMICoreProcessAsync(long r100, int r101, SAMICoreBlock r102);

    long Native_SAMICoreRegisterLogger(Object r100);

    long Native_SAMICoreRegisterServerParamRequestCallback(Object r100);

    long Native_SAMICoreRegisterSpeechWakeupParamRequestCallback(Object r100);

    long Native_SAMICoreRegisterTraceSpanCallback(Object r100);

    long Native_SAMICoreRegisterWakeupParamRequestCallback(Object r100);

    int Native_SAMICoreReleaseContext(int r100);

    int Native_SAMICoreReleaseDebugConfig(long r100);

    int Native_SAMICoreSetProperty(long r100, int r101, SAMICoreProperty r102);

    long Native_SAMICoreUnregisterLogger(Object r100);

    long VopEngine_native_createEngine();

    void VopEngine_native_destroyEngine(long r100);

    float VopEngine_native_getCurrentPositionMs(long r100);

    int VopEngine_native_getCurrentState(long r100, int[] r101);

    int VopEngine_native_getNextTextInfo(long r100, Object[] r101, int[] r102);

    int VopEngine_native_getRecordingStatus(long r100, SAMICoreVopRecordingStatus r101);

    int VopEngine_native_getSpeakerInfo(long r100, SAMICoreVopSpeakerInfo r101);

    float VopEngine_native_getTotalDurationMs(long r100);

    int VopEngine_native_init(long r100, SAMICoreVopInitContext r101);

    int VopEngine_native_manageSpeakerInfo(long r100, SAMICoreVopSpeakerInfoCommand r101);

    int VopEngine_native_play(long r100);

    int VopEngine_native_preparePlayer(long r100);

    int VopEngine_native_processRecordAudio(long r100, byte[] r101, int r102, int[] r103);

    int VopEngine_native_stop(long r100);

    long VopInstantEngine_native_createEngine();

    void VopInstantEngine_native_destroyEngine(long r100);

    int VopInstantEngine_native_getCurrentState(long r100, int[] r101);

    int VopInstantEngine_native_getNextTextInfo(long r100, Object[] r101, int[] r102);

    int VopInstantEngine_native_getSpeakerInfo(long r100, SAMICoreVopSpeakerInfo r101);

    int VopInstantEngine_native_init(long r100, SAMICoreVopInitContext r101);

    int VopInstantEngine_native_manageSpeakerInfo(long r100, SAMICoreVopSpeakerInfoCommand r101);

    int VopInstantEngine_native_play(long r100);

    int VopInstantEngine_native_preparePlayer(long r100, String r101);

    int VopInstantEngine_native_processRecordAudio(long r100, byte[] r101, int r102, int[] r103);

    int VopInstantEngine_native_stop(long r100);

    void onMessageReceived(int r100, SAMICoreBlock r101);

    void onSendToHost(int r100, SAMICoreBlock r101);

    void setHostCallBackListener(SAMICoreHostCallBackListener r100);

    void setListener(SAMICoreCallBackListener r100);
}
