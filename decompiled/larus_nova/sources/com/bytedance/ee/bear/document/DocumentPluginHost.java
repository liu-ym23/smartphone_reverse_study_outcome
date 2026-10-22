package com.bytedance.ee.bear.document;

import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;

/* JADX INFO: loaded from: classes16.dex */
public class DocumentPluginHost extends WebPluginHost implements g7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DocViewModel f218588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EditPanelsManager f218589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebViewFragment f218590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x2 f218591d;

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
        return this.f218588a;
    }

    public EditPanelsManager b() {
        return this.f218589b;
    }

    public WebFragment c() {
        return this.f218590c;
    }

    @Override // com.bytedance.ee.bear.document.e4
    public x2 getDocumentLoader() {
        return this.f218591d;
    }

    @Override // com.bytedance.ee.bear.document.e4
    public y3 getDocumentMetadata() {
        return this.f218588a;
    }

    public DocumentPluginHost(vv4.k r100) {
        super(r100);
        registerHostAbility(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost
    public final void onCreate(PluginHost.a r100) {
        this.f218589b = (EditPanelsManager) ViewModelProviders.of(r100.getActivity()).get(EditPanelsManager.class);
        super.onCreate(r100);
    }

    public DocumentPluginHost(vv4.k r100, int r101) {
        super(r100);
    }
}
