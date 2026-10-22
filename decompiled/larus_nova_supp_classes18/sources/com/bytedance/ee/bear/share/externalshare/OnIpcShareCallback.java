package com.bytedance.ee.bear.share.externalshare;

import com.ss.android.lark.thirdshare.base.export.OnShareCallback;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OnIpcShareCallback extends OnShareCallback {
    public OnIpcShareCallback() {
    }

    public void onSuccess(ShareActionType r3) {
        a.h("ExternalShareHelper_OnIpcShareCallback", "onSuccess: shareActionType = " + r3.name());
    }

    public void onFailed(ShareActionType r3, OnShareCallback.ShareError r4) {
        a.k("OnIpcShareCallback", "onFailed: shareActionType = " + r3.name() + ", errorCode = " + r4.getCode() + ", errorMsg = " + r4.getMsg());
    }
}
