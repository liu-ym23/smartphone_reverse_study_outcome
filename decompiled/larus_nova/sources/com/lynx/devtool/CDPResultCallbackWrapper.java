package com.lynx.devtool;

import com.lynx.devtoolwrapper.CDPResultCallback;

/* JADX INFO: loaded from: classes32.dex */
public class CDPResultCallbackWrapper {
    private CDPResultCallback callback;

    public CDPResultCallbackWrapper(CDPResultCallback r100) {
        this.callback = r100;
    }

    public void onResult(String r100) {
        this.callback.onResult(r100);
    }
}
