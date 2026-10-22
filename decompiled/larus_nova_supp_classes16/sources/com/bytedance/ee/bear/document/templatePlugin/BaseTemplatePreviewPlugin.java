package com.bytedance.ee.bear.document.templatePlugin;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentWebClientPriority;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import s45.p;
import sa5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/templatePlugin/BaseTemplatePreviewPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "delegateFlag", "", "<init>", "(Z)V", "webViewClient", "Lcom/bytedance/ee/bear/document/templatePlugin/BaseTemplatePreviewPlugin$TemplateWebViewClient;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "hideTemplatePreview", "showTemplatePreview", "isCustomTemplatePreview", "onDetachFromUIContainer", "TemplateWebViewClient", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseTemplatePreviewPlugin extends DocumentPlugin implements d {
    private final boolean delegateFlag;
    private final a webViewClient;

    public static final class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView r3, WebResourceRequest r4) {
            StringBuilder r5 = new StringBuilder("http://");
            String r0 = null;
            if (r4 == null) goto L7;
            Uri r1 = r4.getUrl();
            if (r1 == null) goto L7;
            String r2 = r1.getHost();
        L8:
            r5.append(r2);
            if (r4 == null) goto L13;
            Uri r6 = r4.getUrl();
            if (r6 == null) goto L13;
            r0 = r6.getPath();
        L13:
            r5.append(r0);
            return p.a().v6(r5.toString());
        L7:
            r2 = null;
            goto L8
        }
    }

    public BaseTemplatePreviewPlugin() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public abstract void hideTemplatePreview();

    public boolean isCustomTemplatePreview() {
        return false;
    }

    @Override // sa5.d
    public abstract /* synthetic */ boolean onBackPressed();

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public abstract void showTemplatePreview();

    public BaseTemplatePreviewPlugin(boolean r1) {
        this.delegateFlag = r1;
        this.webViewClient = new a();
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        if (this.delegateFlag == true) goto L6;
        getWeb().addWebViewClientDelegate(this.webViewClient, DocumentWebClientPriority.Template.ordinal());
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r3, t r4) {
        if (this.delegateFlag == true) goto L5;
        getWeb().removeWebViewClientDelegate(this.webViewClient);
    L5:
        super.onDetachFromUIContainer(r3, r4);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* synthetic */ BaseTemplatePreviewPlugin(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }
}
