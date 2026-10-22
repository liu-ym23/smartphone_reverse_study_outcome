package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreAsrContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantPropertyParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintDumpAudioDataParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintEnrollParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintEnrollRequest;
import com.mammon.audiosdk.structures.SpeechFingerprintLegacyEnrollMigrationParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintResult;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechFingerPrintEnrollService {
    private String TAG;
    private SpeechFingerprintEnrollParameter parameter;
    private SAMICore samiCore;

    public int deleteEnrollResult() {
        SAMICoreProperty r100 = new SAMICoreProperty();
        SAMICorePropertyId r101 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_DeleteEnrollResult;
        r100.f384359id = r101;
        r100.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r101, r100);
    }

    public int forceReEnrollWakeupSid() {
        SAMICoreProperty r100 = new SAMICoreProperty();
        SAMICorePropertyId r101 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_ForceReEnrollWakeupSid;
        r100.f384359id = r101;
        r100.type = SAMICoreDataType.SAMICoreDataType_Null;
        return this.samiCore.SAMICoreSetProperty(r101, r100);
    }

    public SpeechFingerprintResult getAudioFeatureOnline() {
        SAMICoreProperty r100 = new SAMICoreProperty();
        SAMICorePropertyId r101 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_AudioFeatureOnlineByUid;
        r100.f384359id = r101;
        r100.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Enroll_Result;
        this.samiCore.SAMICoreGetPropertyById(r101, r100);
        return (SpeechFingerprintResult) r100.dataObjectArray[0];
    }

    public int releaseHandle() {
        return this.samiCore.SAMICoreDestroyHandle();
    }

    public SpeechFingerPrintEnrollService() {
        this.TAG = "SpeechFingerPrintEnrollService";
        this.samiCore = new SAMICore();
    }

    public int checkAndEnrollASRSID(SpeechFingerprintEnrollRequest r100) {
        if (r100 != null) goto L5;
        return 100001;
    L5:
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_CheckAndEnrollASRSID;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Enroll_Request;
        r101.dataObjectArray = new SpeechFingerprintEnrollRequest[]{r100};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public int checkSNR(String r100) {
        SAMICoreVoiceAssistantPropertyParameter r101 = new SAMICoreVoiceAssistantPropertyParameter();
        r101.taskId = r100;
        SAMICoreProperty r102 = new SAMICoreProperty();
        SAMICorePropertyId r103 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_CheckSNR;
        r102.f384359id = r103;
        r102.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r102.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r101};
        r102.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r103, r102);
    }

    public int createASR(SAMICoreVoiceAssistantContextCreateParameter r100) {
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_CreateASR;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Context_Param;
        r101.dataObjectArray = new SAMICoreVoiceAssistantContextCreateParameter[]{r100};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public int createHandle(SpeechFingerprintEnrollParameter r100) {
        this.parameter = r100;
        return this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Speech_Fingerprint_Enroll, r100);
    }

    public int dumpAudioData2File(SpeechFingerprintDumpAudioDataParameter r100) {
        if (r100 != null) goto L5;
        return 100001;
    L5:
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_DumpAudioData2File;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Dump_Audio_Data_Param;
        r101.dataObjectArray = new SpeechFingerprintDumpAudioDataParameter[]{r100};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public int migrateLegacyEnrollToDb(SpeechFingerprintLegacyEnrollMigrationParameter r100) {
        if (r100 != null) goto L5;
        return 100001;
    L5:
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_MigrateLegacyEnrollToDb;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Legacy_Migration_Param;
        r101.dataObjectArray = new SpeechFingerprintLegacyEnrollMigrationParameter[]{r100};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public int removeAudioFeatureOnline(String r100) {
        SpeechFingerprintEnrollParameter r101 = new SpeechFingerprintEnrollParameter();
        r101.f384363sn = r100;
        SAMICoreProperty r102 = new SAMICoreProperty();
        SAMICorePropertyId r103 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_DelAudioFeature_Online;
        r102.f384359id = r103;
        r102.type = SAMICoreDataType.SAMICoreDataType_Speech_Fingerprint_Enroll_Property_Param;
        r102.dataObjectArray = new SpeechFingerprintEnrollParameter[]{r101};
        r102.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r103, r102);
    }

    public int saveSessionAudio(String r100) {
        SAMICoreVoiceAssistantPropertyParameter r101 = new SAMICoreVoiceAssistantPropertyParameter();
        r101.taskId = r100;
        SAMICoreProperty r102 = new SAMICoreProperty();
        SAMICorePropertyId r103 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_SaveSessionAudio;
        r102.f384359id = r103;
        r102.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r102.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r101};
        r102.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r103, r102);
    }

    public int setAsrParam(SAMICoreAsrContextCreateParameter r100) {
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_Set_Asr_Param;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_WebSocket_Asr_Context_Param;
        r101.dataObjectArray = new SAMICoreAsrContextCreateParameter[]{r100};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public void setListener(SAMICoreCallBackListener r100) {
        this.samiCore.setListener(r100);
    }

    public int start(SAMICoreVoiceAssistantPropertyParameter r100) {
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_Start;
        r101.f384359id = r102;
        r101.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r101.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r100};
        r101.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r102, r101);
    }

    public int stop(String r100) {
        SAMICoreVoiceAssistantPropertyParameter r101 = new SAMICoreVoiceAssistantPropertyParameter();
        r101.taskId = r100;
        SAMICoreProperty r102 = new SAMICoreProperty();
        SAMICorePropertyId r103 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_Enroll_Stop;
        r102.f384359id = r103;
        r102.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r102.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r101};
        r102.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r103, r102);
    }

    public int uploadStoredAudio(String r100) {
        SAMICoreVoiceAssistantPropertyParameter r101 = new SAMICoreVoiceAssistantPropertyParameter();
        r101.taskId = r100;
        SAMICoreProperty r102 = new SAMICoreProperty();
        SAMICorePropertyId r103 = SAMICorePropertyId.SAMICorePropertyId_Speech_Fingerprint_UploadStoredAudio;
        r102.f384359id = r103;
        r102.type = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Property_Param;
        r102.dataObjectArray = new SAMICoreVoiceAssistantPropertyParameter[]{r101};
        r102.dataArrayLen = 1;
        return this.samiCore.SAMICoreSetProperty(r103, r102);
    }

    public int checkAndEnrollASRSID(String r100) {
        SpeechFingerprintEnrollRequest r101 = new SpeechFingerprintEnrollRequest();
        r101.taskId = r100;
        r101.bypassEnrollSid = 0;
        r101.bypassOnlineRegister = 0;
        return checkAndEnrollASRSID(r101);
    }

    public int dumpAudioData2File(String r100, String r101) {
        SpeechFingerprintDumpAudioDataParameter r102 = new SpeechFingerprintDumpAudioDataParameter();
        r102.outputDir = r100;
        r102.uid = r101;
        return dumpAudioData2File(r102);
    }

    public int checkAndEnrollASRSID(String r100, boolean r101, boolean r102) {
        SpeechFingerprintEnrollRequest r103 = new SpeechFingerprintEnrollRequest();
        r103.taskId = r100;
        r103.bypassEnrollSid = r101 ? 1 : 0;
        r103.bypassOnlineRegister = r102 ? 1 : 0;
        return checkAndEnrollASRSID(r103);
    }

    public int sendAudioData(byte[] r100, String r101, String r102) {
        SAMICoreVoiceAssistantAudioData r103 = new SAMICoreVoiceAssistantAudioData();
        r103.taskId = r101;
        r103.data = r100;
        r103.extra = r102;
        SAMICoreBlock r104 = new SAMICoreBlock();
        r104.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        r104.audioData = new SAMICoreVoiceAssistantAudioData[]{r103};
        r104.numberAudioData = 1;
        int r105 = this.samiCore.SAMICoreProcess(r104, null);
        if (r105 != 0) goto L5;
    L5:
        return r105;
    }
}
