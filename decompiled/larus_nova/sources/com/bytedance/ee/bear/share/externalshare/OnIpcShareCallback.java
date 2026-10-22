package com.bytedance.ee.bear.share.externalshare;

import com.ss.android.lark.thirdshare.base.export.OnShareCallback;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
public class OnIpcShareCallback extends OnShareCallback {
    public OnIpcShareCallback() {
    }

    @Override // com.ss.android.lark.thirdshare.base.export.OnShareCallback
    public void onSuccess(ShareActionType r100) {
        a.h("ExternalShareHelper_OnIpcShareCallback", "onSuccess: shareActionType = " + r100.name());
    }

    @Override // com.ss.android.lark.thirdshare.base.export.OnShareCallback
    public void onFailed(ShareActionType r100, OnShareCallback.ShareError r101) {
        a.k("OnIpcShareCallback", "onFailed: shareActionType = " + r100.name() + ", errorCode = " + r101.getCode() + ", errorMsg = " + r101.getMsg());
    }
}
