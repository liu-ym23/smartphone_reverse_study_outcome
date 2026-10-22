package com.miui.easygo.sdk.module;

import android.os.Bundle;

/* JADX INFO: loaded from: classes32.dex */
public class EasyGoRet {
    public int code;
    public Bundle result;

    public EasyGoRet() {
        this.code = 0;
        this.result = new Bundle();
    }

    public EasyGoRet(int r100, Bundle r101) {
        this.code = 0;
        new Bundle();
        this.code = r100;
        this.result = r101;
    }
}
