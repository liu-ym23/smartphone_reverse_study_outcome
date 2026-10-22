package com.unionpay;

import android.os.Bundle;
import android.os.Handler;
import com.huawei.nfc.sdk.service.HwOpenPayTask;

/* JADX INFO: loaded from: classes41.dex */
public final class i implements HwOpenPayTask.IHwResultCallBack {
    public i() {
    }

    @Override // com.huawei.nfc.sdk.service.HwOpenPayTask.IHwResultCallBack
    public final void onResult(int r100, Bundle r101) {
        if (a.f462144s != null) goto L5;
        a.f462144s = new Handler(a.f462149x);
    L5:
        Handler r102 = a.f462144s;
        r102.sendMessage(r102.obtainMessage(1003, Integer.valueOf(r100)));
    }
}
