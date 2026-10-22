package com.ss.optimizer.live.sdk.base.model;

import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public class HttpResponseException extends IOException {
    public final int statusCode;

    public HttpResponseException(int r100) {
        this.statusCode = r100;
    }
}
