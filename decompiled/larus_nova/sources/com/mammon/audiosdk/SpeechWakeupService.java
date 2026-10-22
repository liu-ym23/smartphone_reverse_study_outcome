package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreFirstWakeupProperty;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreSpeechWakeupServiceCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreWakeupAdaptiveEmbeddingSaveParameter;
import com.mammon.audiosdk.structures.SAMICoreWakeupAudioConfig;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechWakeupService {
    private SAMICoreSpeechWakeupServiceCreateParameter parameter;
    private final SAMICore samiCore;

    public int createSidExecutor() {
        SAMICoreProperty r100 = new SAMICoreProperty();
        SAMICorePropertyId r101 = SAMICorePropertyId.SAMICorePropertyId_WFP_Create_Sid_Executor;
        r100.f384359id = r101;
        r100.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r101, r100);
    }

    public String getResult() {
        SAMICoreProperty r100 = new SAMICoreProperty();
        SAMICorePropertyId r101 = SAMICorePropertyId.SAMICorePropertyId_LP_KWS_Result;
        r100.f384359id = r101;
        r100.type = SAMICoreDataType.SAMICoreDataType_String;
        if (this.samiCore.SAMICoreGetPropertyById(r101, r100) != 0) goto L11;
        Object[] r102 = r100.dataObjectArray;
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.length != 0) goto L10;
        return null;
    L10:
        return (String) r102[0];
    L11:
        return null;
    }

    public int releaseHandle() {
        return this.samiCore.SAMICoreDestroyHandle();
    }

    public int releaseSidExecutor() {
        SAMICoreProperty r100 = new SAMICoreProperty();
        SAMICorePropertyId r101 = SAMICorePropertyId.SAMICorePropertyId_WFP_Release_Sid_Executor;
        r100.f384359id = r101;
        r100.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r101, r100);
    }

    public SpeechWakeupService() {
        this.samiCore = new SAMICore();
    }

    public int createHandle(SAMICoreSpeechWakeupServiceCreateParameter r100) {
        this.parameter = r100;
        return this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Speech_Wakeup_Service, r100);
    }

    public int init(SAMICoreWakeupAudioConfig r100) {
        return init(r100, null, true);
    }

    public int registerWakeupParamRequestCallback(SAMICoreWakeupParamRequestCallback r100) {
        SAMICoreNativeWakeupParamRequestCallback.setWakeupParamRequestCallback(r100);
        if (r100 != null) goto L6;
        return 0;
    L6:
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Wakeup_Param_Request_Callback;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public int registerWakeupUploadTaskCallback(SAMICoreWakeupUploadTaskCallback r100) {
        SAMICoreNativeWakeupUploadTaskCallback.setWakeupUploadTaskCallback(r100);
        if (r100 != null) goto L6;
        return 0;
    L6:
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Wakeup_Upload_Task_Callback;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Null;
        int r103 = this.samiCore.SAMICoreSetProperty(r102, r101);
        if (r103 == 0) goto L9;
        SAMICoreNativeWakeupUploadTaskCallback.setWakeupUploadTaskCallback(null);
    L9:
        return r103;
    }

    public int saveAdaptiveEmbedding(SAMICoreWakeupAdaptiveEmbeddingSaveParameter r100) {
        if (r100 != null) goto L5;
        return 100001;
    L5:
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Wakeup_Save_Adaptive_Embedding;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Speech_Wakeup_Adaptive_Embedding_Save_Param;
        r101.dataObjectArray = new SAMICoreWakeupAdaptiveEmbeddingSaveParameter[]{r100};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public int sendAudioData(byte[] r100) {
        SAMICoreAudioBin r101 = new SAMICoreAudioBin();
        r101.audioData = r100;
        SAMICoreBlock r102 = new SAMICoreBlock();
        r102.dataType = SAMICoreDataType.SAMICoreDataType_AudioBin;
        r102.audioData = new SAMICoreAudioBin[]{r101};
        r102.numberAudioData = 1;
        return this.samiCore.SAMICoreProcess(r102, null);
    }

    public int setFirstWakeupInfo(SAMICoreFirstWakeupProperty r100) {
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_First_Wakeup_Info;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_AudioBin;
        r101.dataObjectArray = new SAMICoreFirstWakeupProperty[]{r100};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public void setListener(SAMICoreCallBackListener r100) {
        this.samiCore.setListener(r100);
    }

    public int setRetrying(boolean r100) {
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_LP_KWS_RETRYING;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Int;
        r101.dataObjectArray = new Integer[]{Integer.valueOf(r100 ? 1 : 0)};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public int saveAdaptiveEmbedding(long r100) {
        return saveAdaptiveEmbedding(new SAMICoreWakeupAdaptiveEmbeddingSaveParameter(r100, 1));
    }

    public int saveAdaptiveEmbedding(String r100) {
        return saveAdaptiveEmbedding(new SAMICoreWakeupAdaptiveEmbeddingSaveParameter(r100, 1));
    }

    public int createHandle(String r100, String r101) {
        return createHandle(new SAMICoreSpeechWakeupServiceCreateParameter(r100, r101));
    }

    public int saveAdaptiveEmbedding(long r100, int r101) {
        return saveAdaptiveEmbedding(new SAMICoreWakeupAdaptiveEmbeddingSaveParameter(r100, r101));
    }

    public int saveAdaptiveEmbedding(String r100, int r101) {
        return saveAdaptiveEmbedding(new SAMICoreWakeupAdaptiveEmbeddingSaveParameter(r100, r101));
    }

    public int init(SAMICoreWakeupAudioConfig r100, String r101, boolean r102) {
        SAMICoreProperty r103 = new SAMICoreProperty();
        SAMICorePropertyId r104 = SAMICorePropertyId.SAMICorePropertyId_WFP_Init;
        r103.f384359id = r104;
        r103.type = SAMICoreDataType.SAMICoreDataType_AudioBin;
        r103.dataObjectArray = new SAMICoreWakeupAudioConfig[]{r100};
        r103.dataArrayLen = 1;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r103.extraInfo = r101;
        r103.userContext = Boolean.valueOf(r102);
        return this.samiCore.SAMICoreSetProperty(r104, r103);
    }
}
