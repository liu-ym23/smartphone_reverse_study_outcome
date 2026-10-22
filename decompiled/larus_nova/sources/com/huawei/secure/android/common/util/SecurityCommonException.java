package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: classes23.dex */
public class SecurityCommonException extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f278227c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f278228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f278229b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f278229b;
    }

    public String getRetCd() {
        return this.f278228a;
    }

    public SecurityCommonException(String r100) {
        super(r100);
        this.f278229b = r100;
    }

    public SecurityCommonException(Throwable r100) {
        super(r100);
    }

    public SecurityCommonException(String r100, String r101) {
        this.f278228a = r100;
        this.f278229b = r101;
    }

    public SecurityCommonException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
