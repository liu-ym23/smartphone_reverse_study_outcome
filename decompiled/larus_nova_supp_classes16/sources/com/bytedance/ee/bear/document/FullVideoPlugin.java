package com.bytedance.ee.bear.document;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FullVideoPlugin extends DocumentPlugin {
    private static final String TAG = "FullVideoPlugin";
    private WebChromeClient webChromeClient;

    public class a implements u4.a {
        public final /* synthetic */ WebView a;
        public final /* synthetic */ DocumentPluginHost b;

        @Override // com.bytedance.ee.bear.document.u4.a
        public Context getContext() {
            FragmentActivity r0 = this.b.getActivity();
            if (r0 != null) goto L5;
        L8:
            tt5.a.k(FullVideoPlugin.TAG, "startActionMode while not active !");
            return null;
        L5:
            if (r0.isFinishing() == true) goto L8;
            return r0;
        }

        @Override // com.bytedance.ee.bear.document.u4.a
        public final ViewGroup getVideoContainer() {
            if (this.b.getUIContainer() != null) goto L5;
            return null;
        L5:
            return (ViewGroup) this.b.getUIContainer().getContentView();
        }

        @Override // com.bytedance.ee.bear.document.u4.a
        public final WebView getWebView() {
            return this.a;
        }

        public a(WebView r1, DocumentPluginHost r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public FullVideoPlugin() {
    }

    public void onAttachToHost(DocumentPluginHost r4) {
        super.onAttachToHost(r4);
        WebView r0 = getWeb().getWebView();
        if (r0 == null) goto L5;
        this.webChromeClient = new u4(new a(r0, r4));
        tt5.a.b(TAG, "add FullVideoChromeClient ");
        getWeb().addWebChromeClientDelegate(this.webChromeClient);
        return;
    L5:
        this.webChromeClient = null;
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        if (this.webChromeClient == null) goto L6;
        getWeb().removeWebChromeClientDelegate(this.webChromeClient);
        this.webChromeClient = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }
}
