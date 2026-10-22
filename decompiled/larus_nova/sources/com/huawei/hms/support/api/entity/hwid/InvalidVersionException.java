package com.huawei.hms.support.api.entity.hwid;

import com.huawei.hms.support.api.client.Status;

/* JADX INFO: loaded from: classes23.dex */
public class InvalidVersionException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Status f277735a;

    public Status getError() {
        return this.f277735a;
    }

    public InvalidVersionException(Status r100) {
        this.f277735a = r100;
    }
}
