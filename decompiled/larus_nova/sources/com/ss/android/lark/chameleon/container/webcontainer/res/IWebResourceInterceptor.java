package com.ss.android.lark.chameleon.container.webcontainer.res;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH'¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/IWebResourceInterceptor;", "", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "uri", "Landroid/net/Uri;", "requestMethod", "", "headers", "", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IWebResourceInterceptor {
    WebResourceResponse shouldInterceptRequest(Uri r100, String r101, Map<String, String> r102);
}
