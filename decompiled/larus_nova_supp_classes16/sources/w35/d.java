package w35;

import android.os.Build;
import android.webkit.ServiceWorkerController;
import com.bytedance.ee.bear.document.DocOpenConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final n25.g a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(w35.a r7) {
        Intrinsics.checkNotNullParameter(r7, "webView");
        this.a = new n25.g(r7.getContext(), "SSR", false, "mobile_ssr_standalone.html");
        Intrinsics.checkNotNullParameter(r7, "webView");
        r7.setWebViewClient(new e(this));
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
