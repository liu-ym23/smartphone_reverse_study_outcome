package w35;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends ServiceWorkerClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f558158a;

    public f(d r100) {
        this.f558158a = r100;
    }

    @Override // android.webkit.ServiceWorkerClient
    public final WebResourceResponse shouldInterceptRequest(WebResourceRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return this.f558158a.f558156a.t(r100.getUrl().toString(), r100.getMethod(), r100.getRequestHeaders());
    }
}
