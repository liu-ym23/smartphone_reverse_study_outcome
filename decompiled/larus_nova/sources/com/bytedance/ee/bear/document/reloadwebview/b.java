package com.bytedance.ee.bear.document.reloadwebview;

import android.webkit.ValueCallback;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f221277a = null;

    static {
        f221277a = new b();
    }

    public b() {
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r100) {
        tt5.a.h("JsThreadChecker", (String) r100);
        j.e(a.f221271h);
        a.e();
        a.f();
    }
}
