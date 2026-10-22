package w35;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends ServiceWorkerClient {
    public final /* synthetic */ d a;

    public f(d r1) {
        this.a = r1;
    }

    @Override // android.webkit.ServiceWorkerClient
    public final WebResourceResponse shouldInterceptRequest(WebResourceRequest r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        return this.a.a.t(r4.getUrl().toString(), r4.getMethod(), r4.getRequestHeaders());
    }
}
