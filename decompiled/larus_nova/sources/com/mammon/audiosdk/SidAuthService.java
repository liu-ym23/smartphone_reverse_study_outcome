package com.mammon.audiosdk;

import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreSidAuthCreateParameter;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRegisterResult;
import com.mammon.audiosdk.structures.SAMICoreSidAuthRequest;
import com.mammon.audiosdk.structures.SAMICoreSidAuthResult;

/* JADX INFO: loaded from: classes32.dex */
public class SidAuthService {
    private final SAMICore samiCore;

    public int releaseHandle() {
        return this.samiCore.SAMICoreDestroyHandle();
    }

    public SidAuthService() {
        this.samiCore = new SAMICore();
    }

    public int createHandle(SAMICoreSidAuthCreateParameter r100) {
        return this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_Sid_Auth_Service, r100);
    }

    public int register(SAMICoreSidAuthRegisterResult r100) {
        if (r100 != null) goto L5;
        return 100001;
    L5:
        SAMICoreBlock r101 = new SAMICoreBlock();
        r101.dataType = SAMICoreDataType.SAMICoreDataType_Sid_Auth_Register_Request;
        r101.audioData = null;
        r101.numberAudioData = 0;
        SAMICoreBlock r102 = new SAMICoreBlock();
        int r103 = this.samiCore.SAMICoreProcess(r101, r102);
        if (r103 == 0) goto L8;
        return r103;
    L8:
        Object[] r104 = r102.audioData;
        if (r104 != null) goto L11;
        return 100004;
    L11:
        if (r104.length == 0) goto L19;
        Object r105 = r104[0];
        if ((r105 instanceof SAMICoreSidAuthRegisterResult) == false) goto L20;
        SAMICoreSidAuthRegisterResult r106 = (SAMICoreSidAuthRegisterResult) r105;
        r100.embedJson = r106.embedJson;
        r100.voiceFingerId = r106.voiceFingerId;
        r100.sidId = r106.sidId;
        return r103;
    L20:
        return 100004;
    L19:
        return 100004;
    }

    public int auth(SAMICoreSidAuthRequest r100, SAMICoreSidAuthResult r101) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L23;
        SAMICoreBlock r102 = new SAMICoreBlock();
        r102.dataType = SAMICoreDataType.SAMICoreDataType_Sid_Auth_Request;
        r102.audioData = new SAMICoreSidAuthRequest[]{r100};
        r102.numberAudioData = 1;
        SAMICoreBlock r103 = new SAMICoreBlock();
        int r104 = this.samiCore.SAMICoreProcess(r102, r103);
        if (r104 == 0) goto L8;
        return r104;
    L8:
        Object[] r105 = r103.audioData;
        if (r105 != null) goto L11;
        return 100004;
    L11:
        if (r105.length == 0) goto L21;
        Object r106 = r105[0];
        if ((r106 instanceof SAMICoreSidAuthResult) == false) goto L22;
        SAMICoreSidAuthResult r107 = (SAMICoreSidAuthResult) r106;
        r101.embedJson = r107.embedJson;
        r101.score = r107.score;
        r101.f384360sv = r107.f384360sv;
        return r104;
    L22:
        return 100004;
    L21:
        return 100004;
    L23:
        return 100001;
    L19:
        return 100001;
    }

    public int createHandle(String r110, String r111, String r112, String r113, String r114, String r115) {
        return createHandle(r110, r111, r112, r113, r114, r115, null, null);
    }

    public int createHandle(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L10;
        if (r102 == null) goto L11;
        SAMICoreSidAuthCreateParameter r108 = new SAMICoreSidAuthCreateParameter();
        r108.modelPath = r100;
        r108.dbPath = r101;
        r108.uid = r102;
        r108.sidModelMd5 = r103;
        r108.appId = r104;
        r108.sidAuthEncKeyInfo = r105;
        r108.appKey = r106;
        r108.businessType = r107;
        return createHandle(r108);
    L11:
        return 100001;
    L10:
        return 100001;
    L8:
        return 100001;
    }
}
