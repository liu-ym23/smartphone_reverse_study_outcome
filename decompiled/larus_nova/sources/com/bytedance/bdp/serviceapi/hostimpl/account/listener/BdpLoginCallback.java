package com.bytedance.bdp.serviceapi.hostimpl.account.listener;

import com.bytedance.bdp.serviceapi.hostimpl.account.model.BdpUserInfo;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpLoginCallback {
    void onCancel(String r100, String r101);

    void onFail(String r100, String r101);

    void onSuccess(BdpUserInfo r100);
}
