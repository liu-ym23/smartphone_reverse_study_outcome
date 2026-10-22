package com.bytedance.ee.bear.document.base;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.document.z5;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0004J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0004J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00192\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0004J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0004J*\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001eH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "docViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "getDocumentMetadata", "Lcom/bytedance/ee/bear/document/DocumentMetadata;", "getDocumentLoader", "Lcom/bytedance/ee/bear/document/DocumentLoader;", "getWeb", "Lcom/bytedance/ee/bear/browser/Web;", "getUrl", "", "getDocViewModel", "isVCFollow", "", "execJS", "", "funcName", "funcParam", "Lcom/alibaba/fastjson/JSONObject;", "resultCallback", "Landroid/webkit/ValueCallback;", "functionParam", "Lcom/bytedance/ee/util/io/NonProguard;", "Lorg/json/JSONObject;", "reloadDocumentFragment", "url", "extra", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DocumentPluginV3 extends AbsChameleonPlugin {
    private DocViewModel docViewModel;

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public DocViewModel getDocViewModel() {
        if (this.docViewModel != null) goto L10;
        ChameleonPluginHost r100 = getHost();
        if (r100 == null) goto L7;
        DocViewModel r101 = (DocViewModel) r100.getHostAbilityOrNull(DocViewModel.class);
    L8:
        this.docViewModel = r101;
        goto L10
    L7:
        r101 = null;
    L10:
        return this.docViewModel;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonPlugin
    public String getUrl() {
        DocViewModel r100 = this.docViewModel;
        if (r100 == null) goto L6;
        String r101 = r100.getOriginUrl();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final x2 getDocumentLoader() {
        ChameleonPluginHost r100 = getHost();
        if (r100 == null) goto L7;
        e4 r101 = (e4) r100.getHostAbility(e4.class);
        if (r101 == null) goto L7;
        return r101.getDocumentLoader();
    L7:
        return null;
    }

    public final y3 getDocumentMetadata() {
        ChameleonPluginHost r100 = getHost();
        if (r100 == null) goto L10;
        e4 r101 = (e4) r100.getHostAbility(e4.class);
        if (r101 == null) goto L10;
        y3 r102 = r101.getDocumentMetadata();
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw new IllegalArgumentException("DocumentMetadata is null");
    }

    public final k getWeb() {
        ChameleonPluginHost r100 = getHost();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getWeb();
    }

    public final boolean isVCFollow() {
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.f216966vc) goto L5;
        return true;
    L5:
        return false;
    }

    public DocumentPluginV3() {
    }

    public final void execJS(String r100) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        execJS(r100, null);
    }

    public final void execJS(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        execJS(r100, r101, null);
    }

    public void reloadDocumentFragment(String r100, Map<String, String> r101) {
        ChameleonPluginHost r102 = getHost();
        if (r102 == null) goto L7;
        z5 r103 = (z5) r102.getHostAbilityOrNull(z5.class);
        if (r103 == null) goto L7;
        r103.reloadDocumentFragment(r100, r101);
        return;
    L7:
        a.k("CML_TAG_AbsChameleonPlugin", "reloadDocumentFragment failed, ReloadAbility is null");
    }

    public final void execJS(String r100, NonProguard r101) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        execJS(r100, r101, null);
    }

    public final void execJS(String r100, JSONObject r101, ValueCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        k r103 = getWeb();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    public final void execJS(String r100, NonProguard r101, ValueCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        k r103 = getWeb();
        if (r103 == null) goto L6;
        r103.k(r100, r101, r102);
        return;
    }

    public final void execJS(String r100, org.json.JSONObject r101, ValueCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        k r103 = getWeb();
        if (r103 == null) goto L6;
        r103.l(r100, r101, r102);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reloadDocumentFragment$default(DocumentPluginV3 r100, String r101, Map r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.reloadDocumentFragment(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadDocumentFragment");
    }
}
