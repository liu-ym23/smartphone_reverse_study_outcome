package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements ValueCallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tb5.m f411163a;

    public g(tb5.m r100) {
        this.f411163a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r100) {
        tb5.m r101 = this.f411163a;
        r101.onCallBack(r100);
    }
}
