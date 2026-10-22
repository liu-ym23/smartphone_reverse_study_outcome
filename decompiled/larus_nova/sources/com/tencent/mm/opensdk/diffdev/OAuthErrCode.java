package com.tencent.mm.opensdk.diffdev;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum OAuthErrCode extends Enum<OAuthErrCode> {
    private static final /* synthetic */ OAuthErrCode[] $VALUES = null;
    public static final OAuthErrCode WechatAuth_Err_Auth_Stopped = null;
    public static final OAuthErrCode WechatAuth_Err_Cancel = null;
    public static final OAuthErrCode WechatAuth_Err_JsonDecodeErr = null;
    public static final OAuthErrCode WechatAuth_Err_NetworkErr = null;
    public static final OAuthErrCode WechatAuth_Err_NormalErr = null;
    public static final OAuthErrCode WechatAuth_Err_OK = null;
    public static final OAuthErrCode WechatAuth_Err_Timeout = null;
    private int code;

    static {
        OAuthErrCode r100 = new OAuthErrCode("WechatAuth_Err_OK", 0, 0);
        WechatAuth_Err_OK = r100;
        OAuthErrCode r101 = new OAuthErrCode("WechatAuth_Err_NormalErr", 1, -1);
        WechatAuth_Err_NormalErr = r101;
        OAuthErrCode r102 = new OAuthErrCode("WechatAuth_Err_NetworkErr", 2, -2);
        WechatAuth_Err_NetworkErr = r102;
        OAuthErrCode r103 = new OAuthErrCode("WechatAuth_Err_JsonDecodeErr", 3, -3);
        WechatAuth_Err_JsonDecodeErr = r103;
        OAuthErrCode r104 = new OAuthErrCode("WechatAuth_Err_Cancel", 4, -4);
        WechatAuth_Err_Cancel = r104;
        OAuthErrCode r105 = new OAuthErrCode("WechatAuth_Err_Timeout", 5, -5);
        WechatAuth_Err_Timeout = r105;
        OAuthErrCode r110 = new OAuthErrCode("WechatAuth_Err_Auth_Stopped", 6, -6);
        WechatAuth_Err_Auth_Stopped = r110;
        $VALUES = new OAuthErrCode[]{r100, r101, r102, r103, r104, r105, r110};
    }

    private OAuthErrCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }

    public static OAuthErrCode valueOf(String r100) {
        return (OAuthErrCode) a.a(OAuthErrCode.class, r100);
    }

    public static OAuthErrCode[] values() {
        return (OAuthErrCode[]) $VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "OAuthErrCode:" + this.code;
    }
}
