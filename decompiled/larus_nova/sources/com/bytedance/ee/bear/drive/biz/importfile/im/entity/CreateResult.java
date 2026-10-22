package com.bytedance.ee.bear.drive.biz.importfile.im.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class CreateResult implements Serializable {
    private long job_timeout;
    private String ticket;

    public CreateResult() {
    }

    public long getJob_timeout() {
        return this.job_timeout;
    }

    public String getTicket() {
        return this.ticket;
    }

    public void setJob_timeout(long r100) {
        this.job_timeout = r100;
    }

    public void setTicket(String r100) {
        this.ticket = r100;
    }
}
