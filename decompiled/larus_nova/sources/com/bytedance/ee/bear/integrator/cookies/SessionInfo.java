package com.bytedance.ee.bear.integrator.cookies;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class SessionInfo implements Serializable {
    private String hostUrl;
    private String session;
    private String sessionName;

    public SessionInfo() {
    }

    public String getHostUrl() {
        return this.hostUrl;
    }

    public String getSession() {
        return this.session;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public void setHostUrl(String r100) {
        this.hostUrl = r100;
    }

    public void setSession(String r100) {
        this.session = r100;
    }

    public void setSessionName(String r100) {
        this.sessionName = r100;
    }

    public SessionInfo(String r100, String r101) {
        this.hostUrl = r100;
        this.session = r101;
    }

    public SessionInfo(String r100, String r101, String r102) {
        this.hostUrl = r100;
        this.sessionName = r101;
        this.session = r102;
    }
}
