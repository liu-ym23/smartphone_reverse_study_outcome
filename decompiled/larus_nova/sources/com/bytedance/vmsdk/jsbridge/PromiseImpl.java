package com.bytedance.vmsdk.jsbridge;

import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;

/* JADX INFO: loaded from: classes3.dex */
public class PromiseImpl implements Promise {
    private static final String DEFAULT_ERROR = "EUNSPECIFIED";
    private Callback mReject;
    private Callback mResolve;

    @Override // com.bytedance.vmsdk.jsbridge.Promise
    public void reject(String r100) {
        reject(DEFAULT_ERROR, r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.Promise
    public void resolve(Object r100) {
        Callback r101 = this.mResolve;
        if (r101 == null) goto L6;
        r101.invoke(new Object[]{r100});
        return;
    }

    public PromiseImpl(Callback r100, Callback r101) {
        this.mResolve = r100;
        this.mReject = r101;
    }

    @Override // com.bytedance.vmsdk.jsbridge.Promise
    public void reject(String r100, String r101) {
        if (this.mReject == null) goto L8;
        if (r100 != null) goto L6;
        r100 = DEFAULT_ERROR;
    L6:
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.putString("code", r100);
        r102.putString("message", r101);
        this.mReject.invoke(new Object[]{r102});
        return;
    }
}
