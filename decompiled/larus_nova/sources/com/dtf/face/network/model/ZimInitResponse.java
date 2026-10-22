package com.dtf.face.network.model;

/* JADX INFO: loaded from: classes22.dex */
public class ZimInitResponse extends ZimResponse {
    public String CertifyId;
    public String ExtParams;
    public String Message;
    public String Protocol;
    public String RetCode;
    public String RetCodeSub;
    public String RetMessageSub;
    public String backupBucketName;
    public String backupOssEndPoint;
    public String extParams;
    public String ext_params;
    public String message;
    public String ossConfigBiz;
    public String protocol;
    public String retCode;
    public String retCodeSub;
    public String retMessageSub;
    public String ret_code;
    public String ret_code_sub;
    public String ret_message_sub;
    public String wishControlBiz;
    public String zimId;
    public String zim_id;

    public void fixParams() {
        String r100 = fixParam(this.retCode, this.ret_code);
        this.retCode = r100;
        this.retCode = fixParam(r100, this.RetCode);
        String r101 = fixParam(this.zimId, this.zim_id);
        this.zimId = r101;
        this.zimId = fixParam(r101, this.CertifyId);
        String r102 = fixParam(this.extParams, this.ext_params);
        this.extParams = r102;
        this.extParams = fixParam(r102, this.ExtParams);
        this.protocol = fixParam(this.protocol, this.Protocol);
        String r103 = fixParam(this.retCodeSub, this.ret_code_sub);
        this.retCodeSub = r103;
        this.retCodeSub = fixParam(r103, this.RetCodeSub);
        String r104 = fixParam(this.retMessageSub, this.ret_message_sub);
        this.retMessageSub = r104;
        this.retMessageSub = fixParam(r104, this.RetMessageSub);
    }

    public ZimInitResponse() {
    }
}
