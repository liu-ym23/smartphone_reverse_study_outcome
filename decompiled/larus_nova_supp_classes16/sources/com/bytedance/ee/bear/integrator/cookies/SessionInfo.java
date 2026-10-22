package com.bytedance.ee.bear.integrator.cookies;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setHostUrl(String r1) {
        this.hostUrl = r1;
    }

    public void setSession(String r1) {
        this.session = r1;
    }

    public void setSessionName(String r1) {
        this.sessionName = r1;
    }

    public SessionInfo(String r1, String r2) {
        this.hostUrl = r1;
        this.session = r2;
    }

    public SessionInfo(String r1, String r2, String r3) {
        this.hostUrl = r1;
        this.sessionName = r2;
        this.session = r3;
    }
}
