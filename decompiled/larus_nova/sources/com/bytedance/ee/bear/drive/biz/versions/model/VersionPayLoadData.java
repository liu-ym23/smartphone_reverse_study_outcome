package com.bytedance.ee.bear.drive.biz.versions.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class VersionPayLoadData implements Serializable {
    public static final int OPERATION_DELETE = 102;
    public static final int OPERATION_UPDATE = 101;
    public static final int SOURCE_WPS = 7;
    public static final int STATE_DELETE = 202;
    public static final int STATE_LATEST = 203;
    public static final int STATE_UPDATE = 201;
    private String editUserId;
    private int operation;
    private int source;
    private String token;
    private String version;

    public VersionPayLoadData() {
    }

    public String getEditUserId() {
        return this.editUserId;
    }

    public int getOperation() {
        return this.operation;
    }

    public int getSource() {
        return this.source;
    }

    public String getToken() {
        return this.token;
    }

    public String getVersion() {
        return this.version;
    }

    public void setEditUserId(String r100) {
        this.editUserId = r100;
    }

    public void setOperation(int r100) {
        this.operation = r100;
    }

    public void setSource(int r100) {
        this.source = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }
}
