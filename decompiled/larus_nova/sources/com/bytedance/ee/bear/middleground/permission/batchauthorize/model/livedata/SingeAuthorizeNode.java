package com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata;

import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.BatchAuthorizeResult;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class SingeAuthorizeNode implements Serializable {
    public int authDataCode;
    private int cancelTotalNum;
    private int errorCode;
    private boolean hasPermission;
    private boolean isAuthorizing;
    private BatchAuthorizeResult.BatchAuthorizeNode nodeInfo;
    private boolean success;
    private String token;

    public int getAuthDataCode() {
        return this.authDataCode;
    }

    public int getCancelTotalNum() {
        return this.cancelTotalNum;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public BatchAuthorizeResult.BatchAuthorizeNode getNodeInfo() {
        return this.nodeInfo;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isAuthorizing() {
        return this.isAuthorizing;
    }

    public boolean isHasPermission() {
        return this.hasPermission;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAuthDataCode(int r100) {
        this.authDataCode = r100;
    }

    public void setAuthorizing(boolean r100) {
        this.isAuthorizing = r100;
    }

    public void setCancelTotalNum(int r100) {
        this.cancelTotalNum = r100;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setHasPermission(boolean r100) {
        this.hasPermission = r100;
    }

    public void setNodeInfo(BatchAuthorizeResult.BatchAuthorizeNode r100) {
        this.nodeInfo = r100;
    }

    public void setSuccess(boolean r100) {
        this.success = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public SingeAuthorizeNode(boolean r100, int r101, boolean r102) {
        this.authDataCode = 0;
        this.cancelTotalNum = 0;
        this.success = r100;
        this.errorCode = r101;
        this.isAuthorizing = r102;
    }
}
