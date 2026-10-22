package com.dtf.face.config;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes22.dex */
public class RecordBase {
    public String abTestId;
    public String actionId;
    public String actionName;
    public String appId;
    public String baseExt;
    public String bizType;
    public String channel;
    public String clientId;
    public String clientVersion;
    public String coreNum;
    public String curAToken;
    public String curAid;
    public String deviceId;
    public String enableSPM;
    public String entityId;
    public String extParam1;
    public String extParam3;
    public String extParam4;
    public String extParma2;
    public String hotPatchVersion;
    public String internalVersion;
    public String language;
    public String logLevel;
    public String logTime;
    public String logType;
    public String logVersion;
    public String magic;
    public String maxFreq;
    public String netType;
    public String osVersion;
    public String pageId;
    public String pageStartTime;
    public String phoneType;
    public String prevViewId;
    public String refer;
    public String sampleRatio;
    public String screenMetrix;
    public String sessionId;
    public String totalMem;
    public String userId;
    public String viewId;
    public String xPath;

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        String[] r101 = {"magic", "logTime", "clientId", "clientVersion", "logVersion", "deviceId", "sessionId", "userId", "actionId", "abTestId", "refer", "appId", "pageStartTime", "xPath", "entityId", "actionName", "logLevel", "bizType", "logType", "extParam1", "extParma2", "extParam3", "extParam4", "pageId", "prevViewId", "viewId", "curAid", "curAToken", "sampleRatio", HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, "osVersion", OnekeyLoginConstants.NET_TYPE, "internalVersion", "channel", "language", "hotPatchVersion", "coreNum", "maxFreq", "totalMem", "baseExt", "enableSPM", "screenMetrix"};
        int r102 = 0;
    L4:
        if (r102 >= 42) goto L18;
        Field r103 = RecordBase.class.getDeclaredField(r101[r102]);     // Catch: Exception -> L11
        r103.setAccessible(true);     // Catch: Exception -> L11
        String r104 = (String) r103.get(this);     // Catch: Exception -> L9
    L14:
        r100.append(r104);
        if (r102 == 41) goto L17;
        r100.append(",");
    L17:
        r102 = r102 + 1;
    L9:
        e = e;
    L13:
        e.printStackTrace();
        r104 = "-";
    L11:
        e = e;
        goto L13
    L18:
        r100.append("$$");
        return r100.toString();
    }

    public RecordBase() {
        this.magic = "-";
        this.logTime = "-";
        this.clientId = "-";
        this.clientVersion = "-";
        this.logVersion = "-";
        this.deviceId = "-";
        this.sessionId = "-";
        this.userId = "-";
        this.actionId = "-";
        this.abTestId = "-";
        this.refer = "-";
        this.appId = "-";
        this.pageStartTime = "-";
        this.xPath = "-";
        this.entityId = "-";
        this.actionName = "-";
        this.logLevel = "-";
        this.bizType = "-";
        this.logType = "-";
        this.extParam1 = "-";
        this.extParma2 = "-";
        this.extParam3 = "-";
        this.extParam4 = "-";
        this.pageId = "-";
        this.prevViewId = "-";
        this.viewId = "-";
        this.curAid = "-";
        this.curAToken = "-";
        this.sampleRatio = "-";
        this.phoneType = "-";
        this.osVersion = "-";
        this.netType = "-";
        this.internalVersion = "-";
        this.channel = "-";
        this.language = "-";
        this.hotPatchVersion = "-";
        this.coreNum = "-";
        this.maxFreq = "-";
        this.totalMem = "-";
        this.baseExt = "-";
        this.enableSPM = "-";
        this.screenMetrix = "-";
    }

    public String getAbTestId() {
        return this.abTestId;
    }

    public String getActionId() {
        return this.actionId;
    }

    public String getActionName() {
        return this.actionName;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getBaseExt() {
        return this.baseExt;
    }

    public String getBizType() {
        return this.bizType;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public String getCoreNum() {
        return this.coreNum;
    }

    public String getCurAToken() {
        return this.curAToken;
    }

    public String getCurAid() {
        return this.curAid;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getEnableSPM() {
        return this.enableSPM;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getExtParam1() {
        return this.extParam1;
    }

    public String getExtParam3() {
        return this.extParam3;
    }

    public String getExtParam4() {
        return this.extParam4;
    }

    public String getExtParma2() {
        return this.extParma2;
    }

    public String getHotPatchVersion() {
        return this.hotPatchVersion;
    }

    public String getInternalVersion() {
        return this.internalVersion;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLogLevel() {
        return this.logLevel;
    }

    public String getLogTime() {
        return this.logTime;
    }

    public String getLogType() {
        return this.logType;
    }

    public String getLogVersion() {
        return this.logVersion;
    }

    public String getMagic() {
        return this.magic;
    }

    public String getMaxFreq() {
        return this.maxFreq;
    }

    public String getNetType() {
        return this.netType;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getPageId() {
        return this.pageId;
    }

    public String getPageStartTime() {
        return this.pageStartTime;
    }

    public String getPhoneType() {
        return this.phoneType;
    }

    public String getPrevViewId() {
        return this.prevViewId;
    }

    public String getRefer() {
        return this.refer;
    }

    public String getSampleRatio() {
        return this.sampleRatio;
    }

    public String getScreenMetrix() {
        return this.screenMetrix;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getTotalMem() {
        return this.totalMem;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getViewId() {
        return this.viewId;
    }

    public String getxPath() {
        return this.xPath;
    }

    public void setAbTestId(String r100) {
        this.abTestId = r100;
    }

    public void setActionId(String r100) {
        this.actionId = r100;
    }

    public void setActionName(String r100) {
        this.actionName = r100;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setBaseExt(String r100) {
        this.baseExt = r100;
    }

    public void setBizType(String r100) {
        this.bizType = r100;
    }

    public void setChannel(String r100) {
        this.channel = r100;
    }

    public void setClientId(String r100) {
        this.clientId = r100;
    }

    public void setClientVersion(String r100) {
        this.clientVersion = r100;
    }

    public void setCoreNum(String r100) {
        this.coreNum = r100;
    }

    public void setCurAToken(String r100) {
        this.curAToken = r100;
    }

    public void setCurAid(String r100) {
        this.curAid = r100;
    }

    public void setDeviceId(String r100) {
        this.deviceId = r100;
    }

    public void setEnableSPM(String r100) {
        this.enableSPM = r100;
    }

    public void setEntityId(String r100) {
        this.entityId = r100;
    }

    public void setExtParam1(String r100) {
        this.extParam1 = r100;
    }

    public void setExtParam3(String r100) {
        this.extParam3 = r100;
    }

    public void setExtParam4(String r100) {
        this.extParam4 = r100;
    }

    public void setExtParma2(String r100) {
        this.extParma2 = r100;
    }

    public void setHotPatchVersion(String r100) {
        this.hotPatchVersion = r100;
    }

    public void setInternalVersion(String r100) {
        this.internalVersion = r100;
    }

    public void setLanguage(String r100) {
        this.language = r100;
    }

    public void setLogLevel(String r100) {
        this.logLevel = r100;
    }

    public void setLogTime(String r100) {
        this.logTime = r100;
    }

    public void setLogType(String r100) {
        this.logType = r100;
    }

    public void setLogVersion(String r100) {
        this.logVersion = r100;
    }

    public void setMagic(String r100) {
        this.magic = r100;
    }

    public void setMaxFreq(String r100) {
        this.maxFreq = r100;
    }

    public void setNetType(String r100) {
        this.netType = r100;
    }

    public void setOsVersion(String r100) {
        this.osVersion = r100;
    }

    public void setPageId(String r100) {
        this.pageId = r100;
    }

    public void setPageStartTime(String r100) {
        this.pageStartTime = r100;
    }

    public void setPhoneType(String r100) {
        this.phoneType = r100;
    }

    public void setPrevViewId(String r100) {
        this.prevViewId = r100;
    }

    public void setRefer(String r100) {
        this.refer = r100;
    }

    public void setSampleRatio(String r100) {
        this.sampleRatio = r100;
    }

    public void setScreenMetrix(String r100) {
        this.screenMetrix = r100;
    }

    public void setSessionId(String r100) {
        this.sessionId = r100;
    }

    public void setTotalMem(String r100) {
        this.totalMem = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setViewId(String r100) {
        this.viewId = r100;
    }

    public void setxPath(String r100) {
        this.xPath = r100;
    }
}
