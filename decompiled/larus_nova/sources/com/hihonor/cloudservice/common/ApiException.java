package com.hihonor.cloudservice.common;

import com.hihonor.cloudservice.support.api.clients.Status;

/* JADX INFO: loaded from: classes23.dex */
public class ApiException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Status f276473a;

    public int getStatusCode() {
        return this.f276473a.f276497a;
    }

    public String getStatusMessage() {
        return this.f276473a.f276498b;
    }

    public ApiException(Status r100) {
        super(r100.f276498b);
        this.f276473a = r100;
    }
}
