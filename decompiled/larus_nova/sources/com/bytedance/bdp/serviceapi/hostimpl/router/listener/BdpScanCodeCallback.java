package com.bytedance.bdp.serviceapi.hostimpl.router.listener;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpScanCodeCallback {
    void isSupport(boolean r100);

    void onFail(String r100);

    void onSuccess(String r100, String r101);
}
