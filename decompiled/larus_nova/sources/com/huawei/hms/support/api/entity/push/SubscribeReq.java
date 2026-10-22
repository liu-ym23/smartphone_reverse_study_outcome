package com.huawei.hms.support.api.entity.push;

import android.content.Context;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.push.d;
import com.huawei.hms.utils.Util;

/* JADX INFO: loaded from: classes23.dex */
public class SubscribeReq implements IMessageEntity {

    @Packed
    private String appId;

    @Packed
    private boolean isFastApp;

    @Packed
    private String operation;

    @Packed
    private String packageName;

    @Packed
    private String projectId;

    @Packed
    private String subjectId;

    @Packed
    private String token;

    @Packed
    private String topic;

    public String toString() {
        return "SubscribeReq{packageName='" + this.packageName + "', operation='" + this.operation + "'}";
    }

    public SubscribeReq() {
        this.isFastApp = false;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public String getToken() {
        return this.token;
    }

    public String getTopic() {
        return this.topic;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setFastApp(boolean r100) {
        this.isFastApp = r100;
    }

    public void setOperation(String r100) {
        this.operation = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setProjectId(String r100) {
        this.projectId = r100;
    }

    public void setSubjectId(String r100) {
        this.subjectId = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setTopic(String r100) {
        this.topic = r100;
    }

    public SubscribeReq(Context r100, String r101, String r102) {
        this.isFastApp = false;
        this.packageName = r100.getPackageName();
        this.operation = r101;
        this.topic = r102;
        this.appId = Util.getAppId(r100);
        this.projectId = d.c(r100);
    }
}
