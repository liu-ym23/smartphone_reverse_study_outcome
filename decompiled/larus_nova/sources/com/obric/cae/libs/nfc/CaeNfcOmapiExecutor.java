package com.obric.cae.libs.nfc;

import com.obric.cae.libs.utils.LogUtil;

/* JADX INFO: loaded from: classes33.dex */
public class CaeNfcOmapiExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICaeNfcOmapiExecutor f395913a;

    public String getEseId() {
        ICaeNfcOmapiExecutor r100 = this.f395913a;
        if (r100 != null) goto L11;
        LogUtil.e("NFC:CaeNfcOmapiExecutor", "getEseId: service is null");
        return null;
    L11:
        return r100.getEseId();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcOmapiExecutor");
        return null;
    }

    public CaeNfcOmapiExecutor(ICaeNfcOmapiExecutor r100) {
        this.f395913a = r100;
    }
}
