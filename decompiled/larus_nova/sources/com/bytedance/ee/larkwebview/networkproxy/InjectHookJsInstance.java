package com.bytedance.ee.larkwebview.networkproxy;

import android.util.LruCache;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import st5.n;

/* JADX INFO: loaded from: classes19.dex */
public final class InjectHookJsInstance implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f242893a;

    public InjectHookJsInstance() {
        this.f242893a = "";
        new LruCache(10);
    }

    @Override // st5.n
    public final WebResourceResponse o(final WebView r100, final WebResourceRequest r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "request");
        if (StringsKt.equals$default(r101.getUrl().getScheme(), "https", false, 2, null) == true) goto L9;
        if (StringsKt.equals$default(r101.getUrl().getScheme(), "http", false, 2, null) == true) goto L9;
        Log.i("InjectHookJsInstance", "interceptResource no http/https,return");
        return null;
    L9:
        if (r101.isForMainFrame() == false) goto L11;
        StringBuilder r102 = new StringBuilder();
        r102.append(r101.getUrl().getScheme());
        r102.append("://");
        r102.append(r101.getUrl().getAuthority());
    L11:
        Function0<WebResourceResponse> r103 = new InjectHookJsInstance$interceptResource$1(this, r101, r100);
        Intrinsics.checkNotNullParameter("", "mark");
        Intrinsics.checkNotNullParameter(r103, "block");
        qqb.a.h("");     // Catch: Throwable -> L15
        WebResourceResponse r104 = r103.invoke();     // Catch: Throwable -> L15
        qqb.a.a();
        return r104;
    L15:
        th = move-exception;
        qqb.a.a();
        throw th;
    }
}
