package com.ss.videoarch.strategy.network.model;

import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public class HttpResponseException extends IOException {
    public final int statusCode;

    public HttpResponseException(int r100) {
        this.statusCode = r100;
    }
}
