package com.bytedance.ee.bear.document;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes16.dex */
public final class g6 implements ValueCallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb5.m f219942a;

    public g6(tb5.m r100) {
        this.f219942a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r100) {
        tb5.m r101 = this.f219942a;
        r101.onCallBack(r100);
    }
}
