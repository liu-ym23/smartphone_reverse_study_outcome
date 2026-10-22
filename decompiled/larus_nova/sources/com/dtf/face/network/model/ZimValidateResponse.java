package com.dtf.face.network.model;

/* JADX INFO: loaded from: classes22.dex */
public class ZimValidateResponse extends ZimResponse {
    private String ExtParams;
    private boolean HasNext;
    private String NextProtocol;
    private String ProductRetCode;
    private String RetCodeSub;
    private String RetMessageSub;
    private String ValidationRetCode;
    public String extParams;
    private String ext_params;
    public boolean hasNext;
    private boolean has_next;
    public String nextProtocol;
    private String next_protocol;
    public String productRetCode;
    private String product_ret_code;
    public String retCodeSub;
    public String retMessageSub;
    private String ret_code_sub;
    private String ret_message_sub;
    public String validationRetCode;
    private String validation_ret_code;

    public void fixParams() {
        String r100 = fixParam(this.validationRetCode, this.validation_ret_code);
        this.validationRetCode = r100;
        this.validationRetCode = fixParam(r100, this.ValidationRetCode);
        String r101 = fixParam(this.productRetCode, this.product_ret_code);
        this.productRetCode = r101;
        this.productRetCode = fixParam(r101, this.ProductRetCode);
        if (this.hasNext == true) goto L8;
        if (this.has_next == false) goto L8;
        this.hasNext = true;
    L8:
        if (this.hasNext == false) goto L10;
    L12:
        String r102 = fixParam(this.nextProtocol, this.next_protocol);
        this.nextProtocol = r102;
        this.nextProtocol = fixParam(r102, this.NextProtocol);
        String r103 = fixParam(this.extParams, this.ext_params);
        this.extParams = r103;
        this.extParams = fixParam(r103, this.ExtParams);
        String r104 = fixParam(this.retCodeSub, this.ret_code_sub);
        this.retCodeSub = r104;
        this.retCodeSub = fixParam(r104, this.RetCodeSub);
        String r105 = fixParam(this.retMessageSub, this.ret_message_sub);
        this.retMessageSub = r105;
        this.retMessageSub = fixParam(r105, this.RetMessageSub);
        return;
    L10:
        if (this.HasNext == false) goto L12;
        this.hasNext = true;
        goto L12
    }

    public ZimValidateResponse() {
        this.hasNext = false;
        this.has_next = false;
    }
}
