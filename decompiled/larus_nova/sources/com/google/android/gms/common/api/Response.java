package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes23.dex */
public class Response<T extends Result> {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private Result f274465zza;

    public Response() {
    }

    public Response(T r100) {
        this.f274465zza = r100;
    }

    public T getResult() {
        return (T) this.f274465zza;
    }

    public void setResult(T r100) {
        this.f274465zza = r100;
    }
}
