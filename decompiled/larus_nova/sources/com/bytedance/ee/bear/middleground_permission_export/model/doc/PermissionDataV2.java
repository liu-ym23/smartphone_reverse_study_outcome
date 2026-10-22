package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public class PermissionDataV2 implements Serializable {
    private int code;
    private String message;
    private int permission;
    private int permission_v2;
    private boolean readAble;
    private String token;

    public PermissionDataV2() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPermission() {
        return this.permission;
    }

    public int getPermission_v2() {
        return this.permission_v2;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isReadAble() {
        return this.readAble;
    }

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setPermission(int r100) {
        this.permission = r100;
    }

    public void setPermission_v2(int r100) {
        this.permission_v2 = r100;
    }

    public void setReadAble(boolean r100) {
        this.readAble = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
