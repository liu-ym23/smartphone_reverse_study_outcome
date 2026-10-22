package com.bytedance.ee.bear.document;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g6 implements ValueCallback<String> {
    public final /* synthetic */ tb5.m a;

    public g6(tb5.m r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r2) {
        tb5.m r0 = this.a;
        r0.onCallBack(r2);
    }
}
