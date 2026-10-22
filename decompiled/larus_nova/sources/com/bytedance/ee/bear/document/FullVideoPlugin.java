package com.bytedance.ee.bear.document;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: classes16.dex */
public class FullVideoPlugin extends DocumentPlugin {
    private static final String TAG = "FullVideoPlugin";
    private WebChromeClient webChromeClient;

    public class a implements u4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f218606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DocumentPluginHost f218607b;

        @Override // com.bytedance.ee.bear.document.u4.a
        public Context getContext() {
            FragmentActivity r100 = this.f218607b.getActivity();
            if (r100 != null) goto L5;
        L8:
            tt5.a.k(FullVideoPlugin.TAG, "startActionMode while not active !");
            return null;
        L5:
            if (r100.isFinishing() == true) goto L8;
            return r100;
        }

        @Override // com.bytedance.ee.bear.document.u4.a
        public final ViewGroup getVideoContainer() {
            if (this.f218607b.getUIContainer() != null) goto L5;
            return null;
        L5:
            return (ViewGroup) this.f218607b.getUIContainer().getContentView();
        }

        @Override // com.bytedance.ee.bear.document.u4.a
        public final WebView getWebView() {
            return this.f218606a;
        }

        public a(WebView r100, DocumentPluginHost r101) {
            this.f218606a = r100;
            this.f218607b = r101;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public FullVideoPlugin() {
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        WebView r101 = getWeb().getWebView();
        if (r101 == null) goto L5;
        this.webChromeClient = new u4(new a(r101, r100));
        tt5.a.b(TAG, "add FullVideoChromeClient ");
        getWeb().addWebChromeClientDelegate(this.webChromeClient);
        return;
    L5:
        this.webChromeClient = null;
    }

    public void onDetachFromHost(DocumentPluginHost r100) {
        super.onDetachFromHost(r100);
        if (this.webChromeClient == null) goto L6;
        getWeb().removeWebChromeClientDelegate(this.webChromeClient);
        this.webChromeClient = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DocumentPluginHost) r100);
    }
}
