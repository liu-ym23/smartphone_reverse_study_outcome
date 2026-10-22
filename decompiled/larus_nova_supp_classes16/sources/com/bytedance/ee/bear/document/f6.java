package com.bytedance.ee.bear.document;

import android.content.Context;
import com.bytedance.ee.larkwebview.base.LarkWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f6 implements ys5.c {
    public final /* synthetic */ SafeReuseDocumentWebV2 a;

    public final st5.o getServiceManager() {
        return new st5.o();
    }

    public final LarkWebView getWebView() {
        return this.a.n;
    }

    public final Context getWebViewContext() {
        return this.a.n.getContext();
    }

    public f6(SafeReuseDocumentWebV2 r1) {
        this.a = r1;
    }
}
