package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* JADX INFO: loaded from: classes23.dex */
public class BundleResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f277721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f277722b;

    public int getResultCode() {
        return this.f277721a;
    }

    public Bundle getRspBody() {
        return this.f277722b;
    }

    public void setResultCode(int r100) {
        this.f277721a = r100;
    }

    public void setRspBody(Bundle r100) {
        this.f277722b = r100;
    }

    public BundleResult(int r100, Bundle r101) {
        this.f277721a = r100;
        this.f277722b = r101;
    }
}
