package org.chromium.support_lib_boundary;

import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: classes42.dex */
public interface WebkitToCompatConverterBoundaryInterface {
    Object convertSafeBrowsingResponse(InvocationHandler r100);

    InvocationHandler convertSafeBrowsingResponse(Object r100);

    Object convertServiceWorkerSettings(InvocationHandler r100);

    InvocationHandler convertServiceWorkerSettings(Object r100);

    InvocationHandler convertSettings(WebSettings r100);

    Object convertWebMessagePort(InvocationHandler r100);

    InvocationHandler convertWebMessagePort(Object r100);

    Object convertWebResourceError(InvocationHandler r100);

    InvocationHandler convertWebResourceError(Object r100);

    InvocationHandler convertWebResourceRequest(WebResourceRequest r100);
}
