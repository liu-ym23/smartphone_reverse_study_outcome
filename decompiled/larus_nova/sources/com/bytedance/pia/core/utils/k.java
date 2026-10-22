package com.bytedance.pia.core.utils;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: classes21.dex */
public final class k<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l47.a<String> f266401a;

    public k(l47.a<String> r100) {
        this.f266401a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        String r101 = (String) r100;
        l47.a<String> r102 = this.f266401a;
        if (r102 == null) goto L6;
        r102.accept(r101);
        return;
    }
}
