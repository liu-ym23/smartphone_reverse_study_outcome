package com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata;

import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.BatchAuthorizeResult;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setAuthDataCode(int r1) {
        this.authDataCode = r1;
    }

    public void setAuthorizing(boolean r1) {
        this.isAuthorizing = r1;
    }

    public void setCancelTotalNum(int r1) {
        this.cancelTotalNum = r1;
    }

    public void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public void setHasPermission(boolean r1) {
        this.hasPermission = r1;
    }

    public void setNodeInfo(BatchAuthorizeResult.BatchAuthorizeNode r1) {
        this.nodeInfo = r1;
    }

    public void setSuccess(boolean r1) {
        this.success = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public SingeAuthorizeNode(boolean r2, int r3, boolean r4) {
        this.authDataCode = 0;
        this.cancelTotalNum = 0;
        this.success = r2;
        this.errorCode = r3;
        this.isAuthorizing = r4;
    }
}
