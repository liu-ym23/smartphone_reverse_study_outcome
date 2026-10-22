package com.bytedance.ee.bear.drive.biz.preview.more.download.im;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImFileSave2SpacePushInfo implements NonProguard {

    @JSONField(name = "app_file_id")
    private String appFileId;

    @JSONField(name = "app_id")
    private String appId;

    @JSONField(name = "file_token")
    private String fileToken;
    private String operation;

    public ImFileSave2SpacePushInfo() {
    }

    public String toString() {
        return "SdkFilePushInfo{operation='" + this.operation + "', appId='" + this.appId + "', appFileId='" + b.i(this.appFileId) + "', fileToken='" + c.j(this.fileToken) + "'}";
    }

    public String getAppFileId() {
        return this.appFileId;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setAppFileId(String r1) {
        this.appFileId = r1;
    }

    public void setAppId(String r1) {
        this.appId = r1;
    }

    public void setFileToken(String r1) {
        this.fileToken = r1;
    }

    public void setOperation(String r1) {
        this.operation = r1;
    }
}
