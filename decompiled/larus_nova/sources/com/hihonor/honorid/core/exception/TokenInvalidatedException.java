package com.hihonor.honorid.core.exception;

/* JADX INFO: loaded from: classes23.dex */
public class TokenInvalidatedException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f276628a;

    public String getErrorDesc() {
        return this.f276628a;
    }

    public TokenInvalidatedException(String r100) {
        super(r100);
        this.f276628a = r100;
    }

    public void setErrorDesc(String r100) {
        this.f276628a = r100;
    }
}
