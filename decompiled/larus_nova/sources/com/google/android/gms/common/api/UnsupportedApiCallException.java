package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes23.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final Feature f274470zza;

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f274470zza));
    }

    public UnsupportedApiCallException(Feature r100) {
        this.f274470zza = r100;
    }
}
