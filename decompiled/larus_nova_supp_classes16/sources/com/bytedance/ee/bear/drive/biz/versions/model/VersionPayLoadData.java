package com.bytedance.ee.bear.drive.biz.versions.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setEditUserId(String r1) {
        this.editUserId = r1;
    }

    public void setOperation(int r1) {
        this.operation = r1;
    }

    public void setSource(int r1) {
        this.source = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setVersion(String r1) {
        this.version = r1;
    }
}
