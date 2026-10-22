package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

/* JADX INFO: loaded from: classes23.dex */
public class BaseException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f277552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ErrorEnum f277553b;

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f277553b.getMessage();
    }

    public int getErrorCode() {
        return this.f277552a;
    }

    public BaseException(int r100) {
        ErrorEnum r101 = ErrorEnum.fromCode(r100);
        this.f277553b = r101;
        this.f277552a = r101.getExternalCode();
    }
}
