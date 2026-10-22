package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkNotAvailabeException extends TTNetExceptionStorage {
    private static final long serialVersionUID = -7281385706782665299L;

    public int getCronetInternalErrorCode() {
        return -106;
    }

    public NetworkNotAvailabeException() {
    }

    public NetworkNotAvailabeException(Throwable r100) {
        initCause(r100);
    }

    public NetworkNotAvailabeException(String r100) {
        super(r100);
    }

    public NetworkNotAvailabeException(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
    }

    @Override // com.bytedance.retrofit2.ttnet.TTNetExceptionStorage
    public void setInfo(boolean r100, boolean r101, String r102, String r103, Object r104) {
        super.setInfo(r100, r101, r102, r103, r104);
    }
}
