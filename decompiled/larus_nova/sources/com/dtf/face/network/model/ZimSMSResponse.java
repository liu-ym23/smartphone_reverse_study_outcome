package com.dtf.face.network.model;

/* JADX INFO: loaded from: classes22.dex */
public class ZimSMSResponse extends ZimResponse {
    public String extParams;
    public String ext_params;
    public int retCode;
    public String retCodeSub;
    public String retMessageSub;
    public int ret_code;
    public String ret_code_sub;
    public String ret_message_sub;

    public void fixParams() {
        int r100 = this.ret_code;
        if (r100 == 0) goto L5;
        this.retCode = r100;
    L5:
        this.extParams = fixParam(this.extParams, this.ext_params);
        this.retCodeSub = fixParam(this.retCodeSub, this.ret_code_sub);
        this.retMessageSub = fixParam(this.retMessageSub, this.ret_message_sub);
    }

    public ZimSMSResponse() {
        this.retCode = 0;
        this.ret_code = 0;
    }
}
