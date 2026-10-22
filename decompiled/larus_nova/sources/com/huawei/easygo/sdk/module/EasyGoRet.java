package com.huawei.easygo.sdk.module;

import android.os.Bundle;

/* JADX INFO: loaded from: classes23.dex */
public class EasyGoRet {
    public int code;
    public Bundle result;

    public EasyGoRet(com.huawei.easygo.module.EasyGoRet r100) {
        this.code = 0;
        this.result = new Bundle();
        if (r100 == null) goto L6;
        this.code = r100.code;
        this.result = r100.result;
        return;
    }

    public EasyGoRet(int r100, Bundle r101) {
        this.code = 0;
        new Bundle();
        this.code = r100;
        this.result = r101;
    }
}
