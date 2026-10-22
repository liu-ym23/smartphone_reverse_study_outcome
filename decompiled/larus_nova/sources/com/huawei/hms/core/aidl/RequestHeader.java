package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class RequestHeader implements IMessageEntity {

    @Packed
    private int apiLevel;

    @Packed
    private List<String> apiNameList;

    @Packed
    private String appId;

    @Packed
    private String packageName;

    @Packed
    private int sdkVersion;

    @Packed
    private String sessionId;

    public RequestHeader() {
    }

    public List<String> getApiNameList() {
        return this.apiNameList;
    }

    public String getAppID() {
        return this.appId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setApiLevel(int r100) {
        this.apiLevel = r100;
    }

    public void setApiNameList(List<String> r100) {
        this.apiNameList = r100;
    }

    public void setAppID(String r100) {
        this.appId = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setSdkVersion(int r100) {
        this.sdkVersion = r100;
    }

    public void setSessionId(String r100) {
        this.sessionId = r100;
    }

    public RequestHeader(String r100, String r101, int r102, String r103) {
        this.appId = r100;
        this.packageName = r101;
        this.sdkVersion = r102;
        this.sessionId = r103;
    }
}
