package com.relax.embedding.module.gen;

import com.relax.embedding.module.NativeModuleCallback;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public class RequestCallbackAndroid {
    NativeModuleCallback mCallback;

    public RequestCallbackAndroid(NativeModuleCallback r100) {
        this.mCallback = r100;
    }

    public void onSucceeded(a r100) {
        new HashMap();
        throw null;
    }

    public void onFailed(int r100, String r101) {
        this.mCallback.onFailed(r100, r101);
    }
}
