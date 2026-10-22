package w35;

import android.os.Build;
import android.webkit.ServiceWorkerController;
import com.bytedance.ee.bear.document.DocOpenConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n25.g f558156a;

    public static final class a {
    }

    static {
    }

    public d(w35.a r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        this.f558156a = new n25.g(r100.getContext(), "SSR", false, "mobile_ssr_standalone.html");
        Intrinsics.checkNotNullParameter(r100, "webView");
        r100.setWebViewClient(new e(this));
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return;
    L5:
        if (DocOpenConfig.g() == false) goto L14;
        ServiceWorkerController.getInstance().setServiceWorkerClient(new f(this));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.d("SSR", "ServiceWorkerController()...e: " + th);
        return;
    }
}
