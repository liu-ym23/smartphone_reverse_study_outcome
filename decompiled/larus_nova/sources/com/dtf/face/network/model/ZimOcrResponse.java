package com.dtf.face.network.model;

/* JADX INFO: loaded from: classes22.dex */
public class ZimOcrResponse extends ZimResponse {
    public String CertifyId;
    private String ExtParams;
    private String ExternInfo;
    private String OcrInfo;
    private String RetCode;
    private String RetCodeSub;
    private String RetMessageSub;
    public String extParams;
    private String ext_params;
    public String externInfo;
    private String extern_info;
    public String ocrInfo;
    private String ocr_info;
    public String retCode;
    public String retCodeSub;
    public String retMessageSub;
    private String ret_code;
    private String ret_code_sub;
    private String ret_message_sub;
    public String side;
    public String zimId;
    private String zim_id;

    public void fixParams() {
        String r100 = fixParam(this.retCodeSub, this.ret_code_sub);
        this.retCodeSub = r100;
        this.retCodeSub = fixParam(r100, this.RetCodeSub);
        String r101 = fixParam(this.retMessageSub, this.ret_message_sub);
        this.retMessageSub = r101;
        this.retMessageSub = fixParam(r101, this.RetMessageSub);
        String r102 = fixParam(this.retCode, this.ret_code);
        this.retCode = r102;
        this.retCode = fixParam(r102, this.RetCode);
        String r103 = fixParam(this.ocrInfo, this.ocr_info);
        this.ocrInfo = r103;
        this.ocrInfo = fixParam(r103, this.OcrInfo);
        String r104 = fixParam(this.zimId, this.zim_id);
        this.zimId = r104;
        this.zimId = fixParam(r104, this.CertifyId);
        String r105 = fixParam(this.externInfo, this.extern_info);
        this.externInfo = r105;
        this.externInfo = fixParam(r105, this.ExternInfo);
        String r106 = fixParam(this.extParams, this.ext_params);
        this.extParams = r106;
        this.extParams = fixParam(r106, this.ExtParams);
    }

    public ZimOcrResponse() {
    }
}
