package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes22.dex */
public class BisBehavCommon {

    @JSONField(name = "invtp")
    public String invtp;

    @JSONField(name = EventConstant.Value.RETRY)
    public String retry;

    /* JADX INFO: renamed from: tm, reason: collision with root package name */
    @JSONField(name = "tm")
    public String f273639tm;

    public BisBehavCommon() {
    }

    public String getInvtp() {
        return this.invtp;
    }

    public String getRetry() {
        return this.retry;
    }

    public String getTm() {
        return this.f273639tm;
    }

    public void setInvtp(String r100) {
        this.invtp = r100;
    }

    public void setRetry(String r100) {
        this.retry = r100;
    }

    public void setTm(String r100) {
        this.f273639tm = r100;
    }
}
