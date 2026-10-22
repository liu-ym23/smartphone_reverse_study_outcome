package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes22.dex */
public class ZimOcrIdentifyRes extends ZimResBase {
    public ResultObjectInfo ResultObject;

    public static class ResultObjectInfo {

        @JSONField(name = "OcrInfo")
        public OCRInfo OcrInfo;

        @JSONField(name = "RetCode")
        public String RetCode;

        @JSONField(name = "RetCodeSub")
        public String RetCodeSub;

        @JSONField(name = "RetMessageSub")
        public String RetMessageSub;

        public ResultObjectInfo() {
        }
    }

    public boolean isValid() {
        ResultObjectInfo r100 = this.ResultObject;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.OcrInfo == null) goto L10;
        return true;
    L10:
        return false;
    }

    public ZimOcrIdentifyRes() {
    }
}
