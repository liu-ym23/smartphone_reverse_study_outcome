package com.bytedance.sdk.bridge;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public class BridgeMethodInfo {
    private final String mBridgeMethodName;
    private final d[] mBridgeParamInfos;
    private final Method mMethod;

    @BridgePrivilege
    private String mMethodPrivilege;

    @BridgeSyncType
    private final String mSyncType;

    public String getBridgeMethodName() {
        return this.mBridgeMethodName;
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public String getMethodPrivilege() {
        return this.mMethodPrivilege;
    }

    public d[] getParamInfos() {
        return this.mBridgeParamInfos;
    }

    public String getSyncType() {
        return this.mSyncType;
    }

    public void setMethodPrivilege(String r100) {
        this.mMethodPrivilege = r100;
    }

    public BridgeMethodInfo(Method r100, String r101, String r102, String r103, d[] r104) {
        this.mMethod = r100;
        this.mBridgeMethodName = r101;
        this.mMethodPrivilege = r102;
        this.mSyncType = r103;
        this.mBridgeParamInfos = r104;
    }
}
