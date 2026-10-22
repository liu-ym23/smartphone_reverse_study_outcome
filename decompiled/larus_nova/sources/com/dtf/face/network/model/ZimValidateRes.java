package com.dtf.face.network.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class ZimValidateRes extends ZimResBase {

    @JSONField(name = "ResultObject")
    public ResultObject ResultObject;

    public static class ResultObject {

        @JSONField(name = "ExtParams")
        public String ExtParams;

        @JSONField(name = "HasNext")
        public boolean HasNext;

        @JSONField(name = "ProductRetCode")
        public String ProductRetCode;

        @JSONField(name = "RetCodeSub")
        public String RetCodeSub;

        @JSONField(name = "RetMessageSub")
        public String RetMessageSub;

        @JSONField(name = "ValidationRetCode")
        public String ValidationRetCode;

        public ResultObject() {
        }
    }

    public String getExtParams() {
        return this.ResultObject.ExtParams;
    }

    public String getProductRetCode() {
        return this.ResultObject.ProductRetCode;
    }

    public String getRetCodeSub() {
        return this.ResultObject.RetCodeSub;
    }

    public String getRetMessageSub() {
        return this.ResultObject.RetMessageSub;
    }

    public String getValidationRetCode() {
        return this.ResultObject.ValidationRetCode;
    }

    public boolean isHasNext() {
        return this.ResultObject.HasNext;
    }

    public boolean isValid() {
        if (this.ResultObject == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return JSON.toJSONString(this.ResultObject);
    L5:
        return "";
    }

    public ZimValidateRes() {
    }
}
