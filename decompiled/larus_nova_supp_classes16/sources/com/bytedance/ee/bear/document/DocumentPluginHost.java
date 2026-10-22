package com.bytedance.ee.bear.document;

import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentPluginHost extends WebPluginHost implements g7 {
    public DocViewModel a;
    public EditPanelsManager b;
    public WebViewFragment c;
    public x2 d;

    @Override // vv4.b
    public tb5.n getBridge() {
        return getWeb().getBridge();
    }

    @Override // com.bytedance.ee.bear.document.e4
    public View getContentView() {
        return super.getWeb().getWebView();
    }

    @Override // com.bytedance.ee.bear.browser.WebPluginHost, com.bytedance.ee.bear.document.g7
    public vv4.k getWeb() {
        return super.getWeb();
    }

    public DocViewModel a() {
        return this.a;
    }

    public EditPanelsManager b() {
        return this.b;
    }

    public WebFragment c() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.document.e4
    public x2 getDocumentLoader() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.document.e4
    public y3 getDocumentMetadata() {
        return this.a;
    }

    public DocumentPluginHost(vv4.k r1) {
        super(r1);
        registerHostAbility(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void onCreate(PluginHost.a r3) {
        this.b = (EditPanelsManager) ViewModelProviders.of(r3.getActivity()).get(EditPanelsManager.class);
        super.onCreate(r3);
    }

    public DocumentPluginHost(vv4.k r1, int r2) {
        super(r1);
    }
}
