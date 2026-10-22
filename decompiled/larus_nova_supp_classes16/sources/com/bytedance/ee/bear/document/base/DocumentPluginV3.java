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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0004J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0004J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00192\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0004J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0004J*\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001eH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "<init>", "()V", "docViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "getDocumentMetadata", "Lcom/bytedance/ee/bear/document/DocumentMetadata;", "getDocumentLoader", "Lcom/bytedance/ee/bear/document/DocumentLoader;", "getWeb", "Lcom/bytedance/ee/bear/browser/Web;", "getUrl", "", "getDocViewModel", "isVCFollow", "", "execJS", "", "funcName", "funcParam", "Lcom/alibaba/fastjson/JSONObject;", "resultCallback", "Landroid/webkit/ValueCallback;", "functionParam", "Lcom/bytedance/ee/util/io/NonProguard;", "Lorg/json/JSONObject;", "reloadDocumentFragment", "url", "extra", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DocumentPluginV3 extends AbsChameleonPlugin {
    private DocViewModel docViewModel;

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocViewModel getDocViewModel() {
        if (this.docViewModel != null) goto L10;
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L7;
        DocViewModel r1 = (DocViewModel) r0.getHostAbilityOrNull(DocViewModel.class);
    L8:
        this.docViewModel = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.docViewModel;
    }

    public String getUrl() {
        DocViewModel r0 = this.docViewModel;
        if (r0 == null) goto L6;
        String r1 = r0.getOriginUrl();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final x2 getDocumentLoader() {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L7;
        e4 r1 = (e4) r0.getHostAbility(e4.class);
        if (r1 == null) goto L7;
        return r1.getDocumentLoader();
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final y3 getDocumentMetadata() {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L10;
        e4 r1 = (e4) r0.getHostAbility(e4.class);
        if (r1 == null) goto L10;
        y3 r2 = r1.getDocumentMetadata();
        if (r2 == null) goto L10;
        return r2;
    L10:
        throw new IllegalArgumentException("DocumentMetadata is null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k getWeb() {
        ChameleonPluginHost r0 = getHost();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWeb();
    }

    public final boolean isVCFollow() {
        if (getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L5;
        return true;
    L5:
        return false;
    }

    public DocumentPluginV3() {
    }

    public final void execJS(String r2) {
        Intrinsics.checkNotNullParameter(r2, "funcName");
        execJS(r2, null);
    }

    public final void execJS(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "funcName");
        execJS(r2, r3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reloadDocumentFragment(String r3, Map<String, String> r4) {
        ChameleonPluginHost r0 = getHost();
        if (r0 == null) goto L7;
        z5 r1 = (z5) r0.getHostAbilityOrNull(z5.class);
        if (r1 == null) goto L7;
        r1.reloadDocumentFragment(r3, r4);
        return;
    L7:
        a.k("CML_TAG_AbsChameleonPlugin", "reloadDocumentFragment failed, ReloadAbility is null");
    }

    public final void execJS(String r2, NonProguard r3) {
        Intrinsics.checkNotNullParameter(r2, "funcName");
        execJS(r2, r3, null);
    }

    public final void execJS(String r2, JSONObject r3, ValueCallback<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "funcName");
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4);
        return;
    }

    public final void execJS(String r2, NonProguard r3, ValueCallback<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "funcName");
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.k(r2, r3, r4);
        return;
    }

    public final void execJS(String r2, org.json.JSONObject r3, ValueCallback<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "funcName");
        k r0 = getWeb();
        if (r0 == null) goto L6;
        r0.l(r2, r3, r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reloadDocumentFragment$default(DocumentPluginV3 r0, String r1, Map r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.reloadDocumentFragment(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadDocumentFragment");
    }
}
