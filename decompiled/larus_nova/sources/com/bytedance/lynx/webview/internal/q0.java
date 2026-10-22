package com.bytedance.lynx.webview.internal;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes21.dex */
public final class q0 implements ValueCallback<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f265353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TTWebContext f265354b;

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r100) {
        String r101 = r100;
        i17.b r102 = this.f265354b.f265216b.f265149l;
        if (r102 == null) goto L6;
        r102.onRequestAdblockRuleDone(this.f265353a, r101, "");
        return;
    }

    public q0(TTWebContext r100, String r101) {
        this.f265354b = r100;
        this.f265353a = r101;
    }
}
