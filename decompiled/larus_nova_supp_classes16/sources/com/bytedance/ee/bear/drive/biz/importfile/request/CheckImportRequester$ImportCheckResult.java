package com.bytedance.ee.bear.drive.biz.importfile.request;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CheckImportRequester$ImportCheckResult implements Serializable {
    private int code;
    private String status;
    private String ticket;
    private List<String> tokens;
    private String type;
    private String url;

    public CheckImportRequester$ImportCheckResult() {
    }

    public String toString() {
        return "Result{code='" + this.code + "', status=" + this.status + ", ticket=" + this.ticket + ", tokens='" + this.tokens + "', type='" + this.type + "', url='" + yu5.c.j(this.url) + "'}";
    }

    public int getCode() {
        return this.code;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTicket() {
        return this.ticket;
    }

    public List<String> getTokens() {
        return this.tokens;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setStatus(String r1) {
        this.status = r1;
    }

    public void setTicket(String r1) {
        this.ticket = r1;
    }

    public void setTokens(List<String> r1) {
        this.tokens = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
