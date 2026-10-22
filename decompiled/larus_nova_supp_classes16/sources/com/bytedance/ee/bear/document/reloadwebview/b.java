package com.bytedance.ee.bear.document.reloadwebview;

import android.webkit.ValueCallback;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements ValueCallback {
    public static final b<T> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r2) {
        tt5.a.h("JsThreadChecker", (String) r2);
        j.e(a.h);
        a.e();
        a.f();
    }
}
