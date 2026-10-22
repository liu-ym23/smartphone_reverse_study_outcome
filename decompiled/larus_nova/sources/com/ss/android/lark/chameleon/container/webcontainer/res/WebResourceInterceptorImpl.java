package com.ss.android.lark.chameleon.container.webcontainer.res;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J4\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/WebResourceInterceptorImpl;", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/IWebResourceInterceptor;", "()V", "interceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "addInterceptor", "", "interceptor", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "url", "Landroid/net/Uri;", "requestMethod", "", "headers", "", "Companion", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WebResourceInterceptorImpl implements IWebResourceInterceptor {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_WebResourceInterceptorImpl";
    private final CopyOnWriteArrayList<IWebResourceInterceptor> interceptors;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/WebResourceInterceptorImpl$Companion;", "", "()V", "TAG", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WebResourceInterceptorImpl() {
        this.interceptors = new CopyOnWriteArrayList();
    }

    public final void addInterceptor(IWebResourceInterceptor r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.interceptors.add(r100);
    }

    @Override // com.ss.android.lark.chameleon.container.webcontainer.res.IWebResourceInterceptor
    public WebResourceResponse shouldInterceptRequest(Uri r100, String r101, Map<String, String> r102) {
        Log.d(TAG, "shouldInterceptRequest0 url=" + r100 + ", requestMethod=" + r101 + ", headers=" + r102 + '}');
        if (StringsKt.equals("options", r101, true) == false) goto L15;
        return null;
    L15:
        Iterator<IWebResourceInterceptor> r103 = this.interceptors.iterator();     // Catch: Throwable -> L12
    L7:
        if (r103.hasNext() == false) goto L14;
        IWebResourceInterceptor r104 = r103.next();     // Catch: Throwable -> L12
        WebResourceResponse r105 = r104.shouldInterceptRequest(r100, r101, r102);     // Catch: Throwable -> L12
        if (r105 == null) goto L7;
        Log.d(TAG, "interceptor by " + r104);     // Catch: Throwable -> L12
        return r105;
    L14:
        return null;
    L12:
        th = move-exception;
        Log.e(TAG, th.toString());
        goto L14
    }
}
