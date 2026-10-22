package com.ccit.tiktok;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum ResultCodeConstant extends Enum<ResultCodeConstant> {
    private static final /* synthetic */ ResultCodeConstant[] $VALUES = null;
    public static final ResultCodeConstant APPNAME_ERROR = null;
    public static final ResultCodeConstant APPPATH_ERROR = null;
    public static final ResultCodeConstant CERTFILE_ERROR = null;
    public static final ResultCodeConstant CERTSERVICE_ERROR = null;
    public static final ResultCodeConstant CERTTIME_ERROR = null;
    public static final ResultCodeConstant CERT_ERROR = null;
    public static final ResultCodeConstant COMMUNICATION_STRUCTURE_ERROR = null;
    public static final ResultCodeConstant CONTEXT_ERROR = null;
    public static final ResultCodeConstant ENCDATA_ERROR = null;
    public static final ResultCodeConstant INIT_ERROR = null;
    public static final ResultCodeConstant JSONRET_ERROR = null;
    public static final ResultCodeConstant PIN_ERROR = null;
    public static final ResultCodeConstant Q1IDFILE_ERROR = null;
    public static final ResultCodeConstant Q1ID_ERROR = null;
    public static final ResultCodeConstant SAR_OK = null;
    public static final ResultCodeConstant SERVERCERT_ERROR = null;
    public static final ResultCodeConstant SIGNDATA_ERROR = null;
    public static final ResultCodeConstant USERIDFILE_ERROR = null;
    public static final ResultCodeConstant USERID_ERROR = null;
    private int resultCode;
    private String resultDesc;

    private static /* synthetic */ ResultCodeConstant[] $values() {
        return new ResultCodeConstant[]{SAR_OK, CONTEXT_ERROR, APPNAME_ERROR, USERID_ERROR, PIN_ERROR, COMMUNICATION_STRUCTURE_ERROR, CERT_ERROR, SIGNDATA_ERROR, CERTSERVICE_ERROR, ENCDATA_ERROR, Q1ID_ERROR, INIT_ERROR, CERTFILE_ERROR, USERIDFILE_ERROR, Q1IDFILE_ERROR, SERVERCERT_ERROR, CERTTIME_ERROR, APPPATH_ERROR, JSONRET_ERROR};
    }

    static {
        SAR_OK = new ResultCodeConstant("SAR_OK", 0, 0, "成功");
        CONTEXT_ERROR = new ResultCodeConstant("CONTEXT_ERROR", 1, 1001, "上下文为空");
        APPNAME_ERROR = new ResultCodeConstant("APPNAME_ERROR", 2, 1002, "应用标识为空");
        USERID_ERROR = new ResultCodeConstant("USERID_ERROR", 3, 1003, "用户标识为空");
        PIN_ERROR = new ResultCodeConstant("PIN_ERROR", 4, 1004, "用户pin为空");
        COMMUNICATION_STRUCTURE_ERROR = new ResultCodeConstant("COMMUNICATION_STRUCTURE_ERROR", 5, 1005, "安全通讯结构为空");
        CERT_ERROR = new ResultCodeConstant("CERT_ERROR", 6, 1006, "证书为空");
        SIGNDATA_ERROR = new ResultCodeConstant("SIGNDATA_ERROR", 7, 1007, "签名原文为空");
        CERTSERVICE_ERROR = new ResultCodeConstant("CERTSERVICE_ERROR", 8, 1008, "服务端证书为空");
        ENCDATA_ERROR = new ResultCodeConstant("ENCDATA_ERROR", 9, 1009, "加密原文为空");
        Q1ID_ERROR = new ResultCodeConstant("Q1ID_ERROR", 10, 1010, "签名因子为空");
        INIT_ERROR = new ResultCodeConstant("INIT_ERROR", 11, 1100, "未初始化");
        CERTFILE_ERROR = new ResultCodeConstant("CERTFILE_ERROR", 12, 1101, "证书不存在");
        USERIDFILE_ERROR = new ResultCodeConstant("USERIDFILE_ERROR", 13, 1102, "用户不存在");
        Q1IDFILE_ERROR = new ResultCodeConstant("Q1IDFILE_ERROR", 14, 1103, "签名因子不存在");
        SERVERCERT_ERROR = new ResultCodeConstant("SERVERCERT_ERROR", 15, 1104, "服务端证书不存在");
        CERTTIME_ERROR = new ResultCodeConstant("CERTTIME_ERROR", 16, 1105, "证书已失效（证书超过了有效期）");
        APPPATH_ERROR = new ResultCodeConstant("APPPATH_ERROR", 17, 1106, "路径创建失败");
        JSONRET_ERROR = new ResultCodeConstant("JSONRET_ERROR", 18, 1107, "JSON返回异常");
        $VALUES = $values();
    }

    public static ResultCodeConstant[] values() {
        return (ResultCodeConstant[]) $VALUES.clone();
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public static ResultCodeConstant valueOf(String r100) {
        return (ResultCodeConstant) a.a(ResultCodeConstant.class, r100);
    }

    public void setResultCode(int r100) {
        this.resultCode = r100;
    }

    public void setResultDesc(String r100) {
        this.resultDesc = r100;
    }

    private ResultCodeConstant(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.resultCode = r102;
        this.resultDesc = r103;
    }
}
