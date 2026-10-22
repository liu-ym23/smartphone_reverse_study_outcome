package com.bytedance.ee.bear.document.plugin.offline;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/document/plugin/offline/OfflineImageResourceInterceptorPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "<init>", "()V", "webViewClient", "Landroid/webkit/WebViewClient;", "getWebViewClient", "()Landroid/webkit/WebViewClient;", "webViewClient$delegate", "Lkotlin/Lazy;", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "DelegateWebViewClient", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineImageResourceInterceptorPlugin extends DocumentPluginV3 {
    private final Lazy webViewClient$delegate;

    public static final class a extends WebViewClient {
        public final List<com.bytedance.ee.bear.document.plugin.offline.a> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends com.bytedance.ee.bear.document.plugin.offline.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "resourceInterceptor");
            this.a = r2;
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView r5, WebResourceRequest r6) {
            Intrinsics.checkNotNullParameter(r6, "request");
            Iterator<com.bytedance.ee.bear.document.plugin.offline.a> r7 = this.a.iterator();
        L4:
            if (r7.hasNext() == false) goto L8;
            WebResourceResponse r0 = r7.next().a(r6.getUrl().toString(), r6.getMethod(), r6.getRequestHeaders());
            if (r0 == null) goto L4;
            return r0;
        L8:
            return null;
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final WebViewClient getWebViewClient() {
        return (WebViewClient) this.webViewClient$delegate.getValue();
    }

    public OfflineImageResourceInterceptorPlugin() {
        this.webViewClient$delegate = LazyKt.lazy(new OfflineImageResourceInterceptorPlugin$webViewClient$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ Context access$getContext(OfflineImageResourceInterceptorPlugin r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        if (r2 == null) goto L8;
        k r3 = r2.getChameleonWeb();
        if (r3 == null) goto L9;
        r3.addWebViewClientDelegate(getWebViewClient());
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
