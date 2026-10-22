package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larus.network.http.ServiceType;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes22.dex */
public class ZimInitRes extends ZimResBase {

    @JSONField(name = "resultObject")
    public ResultObject resultObject;

    public static class ResultObject {

        @JSONField(name = TTVideoEngineInterface.AUTH_AK)
        public String AccessKeyId;

        @JSONField(name = "AccessKeySecret")
        public String AccessKeySecret;

        @JSONField(name = "BucketName")
        public String BucketName;

        @JSONField(name = "CertifyId")
        public String CertifyId;

        @JSONField(name = "ControlConfig")
        public String ControlConfig;

        @JSONField(name = "ExtParams")
        public String ExtParams;

        @JSONField(name = "FileNamePrefix")
        public String FileNamePrefix;

        @JSONField(name = ServiceType.IM)
        public String Message;

        @JSONField(name = "OssEndPoint")
        public String OssEndPoint;

        @JSONField(name = "Protocol")
        public String Protocol;

        @JSONField(name = "RetCode")
        public String RetCode;

        @JSONField(name = "RetCodeSub")
        public String RetCodeSub;

        @JSONField(name = "RetMessageSub")
        public String RetMessageSub;

        @JSONField(name = "SecurityToken")
        public String SecurityToken;

        @JSONField(name = "WishContent")
        public String WishContent;

        @JSONField(name = "backupBucketName")
        public String backupBucketName;

        @JSONField(name = "backupOssEndPoint")
        public String backupOssEndPoint;

        @JSONField(name = "ossConfigBiz")
        public String ossConfigBiz;

        @JSONField(name = "wishControlBiz")
        public String wishControlBiz;

        public ResultObject() {
        }
    }

    public String getAccessKeyId() {
        return this.resultObject.AccessKeyId;
    }

    public String getAccessKeySecret() {
        return this.resultObject.AccessKeySecret;
    }

    public String getBackupBucketName() {
        return this.resultObject.backupBucketName;
    }

    public String getBackupOssEndPoint() {
        return this.resultObject.backupOssEndPoint;
    }

    public String getBucketName() {
        return this.resultObject.BucketName;
    }

    public String getCertifyId() {
        return this.resultObject.CertifyId;
    }

    public String getControlConfig() {
        return this.resultObject.ControlConfig;
    }

    public String getExtParams() {
        return this.resultObject.ExtParams;
    }

    public String getFileName() {
        return this.resultObject.FileNamePrefix;
    }

    public String getMessage() {
        return this.resultObject.Message;
    }

    public String getOssEndPoint() {
        return this.resultObject.OssEndPoint;
    }

    public String getProtocol() {
        return this.resultObject.Protocol;
    }

    public String getRetCode() {
        return this.resultObject.RetCode;
    }

    public String getRetCodeSub() {
        return this.resultObject.RetCodeSub;
    }

    public String getRetMessageSub() {
        return this.resultObject.RetMessageSub;
    }

    public String getSecurityToken() {
        return this.resultObject.SecurityToken;
    }

    public String getWishContent() {
        return this.resultObject.WishContent;
    }

    public boolean isValid() {
        if (this.resultObject == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ZimInitRes() {
    }
}
