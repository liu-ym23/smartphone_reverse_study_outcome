package com.ss.android.lark.chameleonv2.container.webcontainer.res;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.ss.android.lark.chameleon.container.webcontainer.res.WebResourceInterceptorImpl;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.text.StringsKt;
import y0b.b;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f411269a;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.res.a$a, reason: collision with other inner class name */
    public static final class C4783a {
    }

    static {
    }

    public a() {
        this.f411269a = new CopyOnWriteArrayList();
    }

    @Override // y0b.b
    public final WebResourceResponse shouldInterceptRequest(Uri r100, String r101, Map<String, String> r102) {
        j.a(WebResourceInterceptorImpl.TAG, "shouldInterceptRequest0 url=" + r100 + ", requestMethod=" + r101 + ", headers=" + r102 + '}');
        if (StringsKt.equals("options", r101, true) == false) goto L15;
        return null;
    L15:
        Iterator<b> r103 = this.f411269a.iterator();     // Catch: Throwable -> L12
    L7:
        if (r103.hasNext() == false) goto L14;
        b r104 = r103.next();     // Catch: Throwable -> L12
        WebResourceResponse r105 = r104.shouldInterceptRequest(r100, r101, r102);     // Catch: Throwable -> L12
        if (r105 == null) goto L7;
        j.a(WebResourceInterceptorImpl.TAG, "interceptor by " + r104);     // Catch: Throwable -> L12
        return r105;
    L14:
        return null;
    L12:
        th = move-exception;
        j.d(WebResourceInterceptorImpl.TAG, th);
        goto L14
    }
}
