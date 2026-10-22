package fe4;

import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;

/* JADX INFO: loaded from: classes15.dex */
public interface b {
    WebChromeClient getWebChromeClient(ContainerContext r100);

    WebViewClient getWebViewClient(ContainerContext r100);

    c getWebViewLoadUrlInterceptor(ContainerContext r100);
}
