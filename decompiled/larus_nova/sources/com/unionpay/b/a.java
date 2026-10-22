package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.tsmservice.mini.ITsmCallback;
import com.unionpay.tsmservice.mini.result.QueryVendorPayStatusResult;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends ITsmCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f462151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f462152b;

    public a(Handler r100) {
        this.f462151a = 4000;
        this.f462152b = r100;
    }

    @Override // com.unionpay.tsmservice.mini.ITsmCallback
    public final void onError(String r100, String r101) {
        Handler r102 = this.f462152b;
        r102.sendMessage(Message.obtain(r102, 1, this.f462151a, 0, r100 + r101));
    }

    @Override // com.unionpay.tsmservice.mini.ITsmCallback
    public final void onResult(Bundle r100) {
        if (this.f462151a != 4000) goto L7;
        r100.setClassLoader(QueryVendorPayStatusResult.class.getClassLoader());
        Bundle r101 = ((QueryVendorPayStatusResult) r100.get("result")).f462193a;
        Handler r102 = this.f462152b;
        r102.sendMessage(Message.obtain(r102, 4000, r101));
        return;
    }
}
