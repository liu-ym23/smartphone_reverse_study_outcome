package com.ss.bduploader;

import com.ss.bduploader.util.BDUrlDispatch;
import com.ss.bduploader.util.CustomVerify;

/* JADX INFO: loaded from: classes40.dex */
public class BDAbstractUpload {
    protected static boolean IsErrored = false;
    public static final int KeyIsBatchSessionKey = 420;
    public static final int KeyIsCustomHttpHeaders = 430;
    public static final int KeyIsDiskResumeDir = 303;
    public static final int KeyIsDiskResumeOption = 302;
    public static final int KeyIsDiskResumeUniqueKey = 301;
    public static final int KeyIsEnableNativeLog = 421;
    public static final int KeyIsRetryStatesDir = 433;
    public static final int KeyIsRetryStatesOption = 434;
    public static final int KeyIsSDKMaxRetryCount = 426;
    public static final int KeyIsSDKMaxRetryTimeout = 428;
    public static final int KeyIsSDKRetryPolicy = 427;
    public static final int KeyIsSocketConnectTimeout = 422;
    public static final int KeyIsSocketReadTimeout = 423;
    public static final int KeyIsSocketWriteTimeout = 424;
    public static final int KeyIsTotalRequestTimeout = 425;
    public static final int KeyIsXQuicLibAvailable = 429;
    public static final int NetworkTypeNone = -1;
    public static final int NetworkTypeOwn = 0;
    public static final int NetworkTypeProxy = 4;
    public static final int NetworkTypeTTNet = 1;
    public static final int SDKRetryPolicyMaxFailTime = 0;
    public static final int SDKRetryPolicyMaxRetryCount = 1;
    public static StringBuffer mErrorMsg;

    public String getStringFromExtern(int r100) {
        return "";
    }

    static {
        mErrorMsg = new StringBuffer("error:");
        StringBuffer r100 = new StringBuffer("error:");
        mErrorMsg = r100;
        if (BDUploadUtil.initInternal(r100) == true) goto L6;
        IsErrored = true;
        return;
    }

    public BDAbstractUpload() throws Exception {
        StringBuffer r100 = new StringBuffer("error:");
        mErrorMsg = r100;
        BDUploadUtil.initInternal(r100);
    }

    public String getDispatchByUrl(String r100, String r101) {
        if (BDUploadUtil.mEnableDisaptch.booleanValue() == true) goto L7;
        String r102 = BDUploadUtil.SpeedTestcontextDir;
        return null;
    L7:
        return BDUrlDispatch.inst().getDispatchUrl(r100, r101);
    }

    public String intelligentInterface(int r100, String r101) {
        return "testIntelligentInterface return";
    }

    public int doVerify(byte[][] r100, String r101, String r102) {
        return CustomVerify.doVerify(r100, r101, r102);
    }
}
