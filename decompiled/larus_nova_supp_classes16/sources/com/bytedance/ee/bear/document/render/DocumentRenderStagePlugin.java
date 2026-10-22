package com.bytedance.ee.bear.document.render;

import android.content.Intent;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.RectColorView;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.f;
import com.bytedance.ee.bear.document.render.preload.WebViewLoadStateWebService;
import com.bytedance.ee.bear.document.render.preload.e;
import com.bytedance.ee.bear.document.x2;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sa5.d;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/render/DocumentRenderStagePlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "TAG", "", "webViewStatusAbility", "Lcom/bytedance/ee/bear/document/render/preload/WebViewStatusAbility;", "getWebViewStatusAbility", "()Lcom/bytedance/ee/bear/document/render/preload/WebViewStatusAbility;", "mDocumentLoader", "Lcom/bytedance/ee/bear/document/render/loader/DocumentLoaderV3;", "getMDocumentLoader", "()Lcom/bytedance/ee/bear/document/render/loader/DocumentLoaderV3;", "mDocReport", "Lcom/bytedance/ee/bear/document/render/node/IDocReport;", "getMDocReport", "()Lcom/bytedance/ee/bear/document/render/node/IDocReport;", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "clearRes", "", "onBackPressed", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentRenderStagePlugin extends DocumentPluginV3 implements d {
    private final String TAG;

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocumentRenderStagePlugin() {
        this.TAG = "RenderStagePlugin" + hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean clearRes() {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L5;
        FragmentActivity r1 = r0.getActivity();
    L7:
        if (r1 == null) goto L12;
        Intent r2 = r1.getIntent();
        if (r2 == null) goto L12;
        return r2.getBooleanExtra("clear_res", true);
    L12:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    private final f getMDocReport() {
        DocumentLoaderV3 r0 = getMDocumentLoader();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DocumentLoaderV3 getMDocumentLoader() {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L5;
        x2 r1 = (x2) r0.getHostAbilityOrNull(x2.class);
    L7:
        if ((r1 instanceof DocumentLoaderV3) == true) goto L9;
        return null;
    L9:
        return (DocumentLoaderV3) r1;
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final e getWebViewStatusAbility() {
        ChameleonPluginHost r0 = getHost();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (WebViewLoadStateWebService) r0.getWebService(WebViewLoadStateWebService.class);
    }

    @Override // sa5.d
    public boolean onBackPressed() {
        DocumentLoaderV3 r0 = getMDocumentLoader();
        if (r0 == null) goto L7;
        r0.bi(true);
        return false;
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        a.h(this.TAG, "==openDocs==render== onAttachToHost");
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r3, t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        a.h(this.TAG, "==openDocs==render== onAttachToUIContainer, mDocumentLoader = " + getMDocumentLoader() + ", webviewId = " + r3.getWeb().getWebView().hashCode());
        f r5 = getMDocReport();
        if (r5 == null) goto L5;
        r5.e();
    L5:
        DocumentLoaderV3 r6 = getMDocumentLoader();
        if (r6 == null) goto L9;
        r6.load();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r5, t r6) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r5, r6);
        e r7 = getWebViewStatusAbility();
        boolean r0 = false;
        if (r7 == null) goto L10;
        String r1 = getDocumentMetadata().getDocumentType();
        if (r1 != null) goto L7;
        r1 = sbb.e.e.getType();
    L7:
        Intrinsics.checkNotNull(r1);
        if (r7.c(r1) != true) goto L10;
        r0 = true;
    L10:
        boolean r8 = clearRes();
        a.h(this.TAG, "==openDocs==render== onDetachedFromWindow()... isReay = " + r0);
        WebView r2 = r5.getWeb().getWebView();
        if (r0 == false) goto L15;
        if (r8 == false) goto L16;
        a.h(this.TAG, "==openDocs==render== recycle()... clear, webviewId = " + r5.getWeb().getWebView().hashCode());
        r2.clearHistory();
        ap5.a.a(r2, RectColorView.RectColorType.TYPE_CLEAR, null, null);
        r2.evaluateJavascript("ttwebview:/*cleanupGPUResource*/;", null);
        return;
    L16:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
