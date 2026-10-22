package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerCommonContextCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreTruthCollectorData;
import com.mammon.audiosdk.structures.SAMICoreWakeupUploadResult;

/* JADX INFO: loaded from: classes32.dex */
public class SpeechWakeupUploadService {
    private final SAMICoreServerCommonContextCreateParameter createParameter;
    private final SAMICore samiCore;

    public SpeechWakeupUploadService() {
        this(null);
    }

    public int createHandle() {
        return this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Speech_Wakeup_Upload_Service, this.createParameter);
    }

    public int releaseHandle() {
        return this.samiCore.SAMICoreDestroyHandle();
    }

    public SpeechWakeupUploadService(SAMICoreServerCommonContextCreateParameter r100) {
        this.samiCore = new SAMICore();
        this.createParameter = r100;
    }

    public SAMICoreWakeupUploadResult upload(SAMICoreTruthCollectorData r100) {
        SAMICoreWakeupUploadResult r101 = new SAMICoreWakeupUploadResult();
        if (r100 == null) goto L17;
        byte[] r102 = r100.audio_data;
        if (r102 == null) goto L17;
        if (r102.length == 0) goto L17;
        SAMICoreBlock r103 = new SAMICoreBlock();
        r103.dataType = SAMICoreDataType.SAMICoreDataType_Speech_Wakeup_Truth_Collector_Data;
        r103.audioData = new Object[]{r100};
        r103.numberAudioData = 1;
        SAMICoreBlock r104 = new SAMICoreBlock();
        r101.ret = this.samiCore.SAMICoreProcess(r103, r104);
        Object[] r105 = r104.audioData;
        if (r105 != null) goto L12;
    L16:
        return r101;
    L12:
        if (r105.length <= 0) goto L16;
        Object r106 = r105[0];
        if ((r106 instanceof String) == false) goto L16;
        r101.response = (String) r106;
    L17:
        r101.ret = 100001;
        return r101;
    }

    public int upload(byte[] r100, String r101) {
        if (r100 != null) goto L4;
        return 100001;
    L4:
        if (r100.length == 0) goto L10;
        SAMICoreAudioBin r102 = new SAMICoreAudioBin();
        r102.audioData = r100;
        SAMICoreBlock r103 = new SAMICoreBlock();
        r103.dataType = SAMICoreDataType.SAMICoreDataType_AudioBin;
        r103.audioData = new SAMICoreAudioBin[]{r102};
        r103.numberAudioData = 1;
        r103.userContext = r101;
        return this.samiCore.SAMICoreProcess(r103, null);
    L10:
        return 100001;
    }
}
