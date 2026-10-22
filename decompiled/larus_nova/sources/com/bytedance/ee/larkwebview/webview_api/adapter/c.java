package com.bytedance.ee.larkwebview.webview_api.adapter;

import android.webkit.ValueCallback;
import com.bytedance.ee.lark.component.AbstractNativeComponent;

/* JADX INFO: loaded from: classes19.dex */
public final class c<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueCallback<String> f243002a;

    public c(AbstractNativeComponent.a.C3474a r100) {
        this.f243002a = r100;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        ValueCallback<String> r101 = this.f243002a;
        r101.onReceiveValue((String) r100);
    }
}
