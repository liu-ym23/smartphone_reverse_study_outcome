package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ \u0010\u001f\u001a\u00020 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0\"H\u0016J(\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0007J\n\u0010*\u001a\u0004\u0018\u00010+H\u0014J*\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010/H\u0014J\b\u00100\u001a\u00020\u0018H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "Lcom/bytedance/ee/bear/browser/plugin/lazy/BridgeInteractivePlugin;", "<init>", "()V", "TAG", "", "editorAbility", "Lcom/bytedance/ee/bear/document/EditorAbility;", "getEditorAbility", "()Lcom/bytedance/ee/bear/document/EditorAbility;", "bridge", "Lcom/bytedance/ee/bear/jsbridge/IBridge;", "getBridge", "()Lcom/bytedance/ee/bear/jsbridge/IBridge;", "webEditorAbility", "Lcom/bytedance/ee/bear/document/WebEditorAbility;", "getWebEditorAbility", "()Lcom/bytedance/ee/bear/document/WebEditorAbility;", "webOrNull", "Lcom/bytedance/ee/bear/browser/Web;", "getWebOrNull", "()Lcom/bytedance/ee/bear/browser/Web;", "runInWeb", "", "getRunInWeb", "()Z", "runInNative", "getRunInNative", "getDocumentMetadata", "Lcom/bytedance/ee/bear/document/DocumentMetadata;", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "dispatchBridgeMsg", "handlerName", "data", "", "callBack", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getDocViewModel", "Lcom/bytedance/ee/bear/document/DocViewModel;", "reloadDocumentFragment", "url", "extra", "", "shouldDisableLandscape", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocumentPluginV2 extends BasePluginV2 implements yv4.a {
    private final String TAG;

    public final void dispatchBridgeMsg(String r8) {
        Intrinsics.checkNotNullParameter(r8, "handlerName");
        dispatchBridgeMsg$default(this, r8, null, null, 6, null);
    }

    public final void dispatchBridgeMsg(String r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "handlerName");
        dispatchBridgeMsg$default(this, r8, r9, null, 4, null);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    public final e4 getEditorAbility() {
        int r0 = com.bytedance.ee.bear.browser.plugin.j.a;
        return (e4) getHost().getHostAbility(e4.class);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    public final g7 getWebEditorAbility() {
        int r0 = com.bytedance.ee.bear.browser.plugin.j.a;
        return (g7) getHost().getHostAbilityOrNull(g7.class);
    }

    public DocumentPluginV2() {
        this.TAG = "DocumentPluginV2";
    }

    public final tb5.n getBridge() {
        return getEditorAbility().getBridge();
    }

    public DocViewModel getDocViewModel() {
        PluginHost r0 = getHost();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((DocumentPluginHost) r0).a();
    }

    public final y3 getDocumentMetadata() {
        return getEditorAbility().getDocumentMetadata();
    }

    public final boolean getRunInNative() {
        return !getRunInWeb();
    }

    public final boolean getRunInWeb() {
        if (getWebEditorAbility() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final vv4.k getWebOrNull() {
        g7 r0 = getWebEditorAbility();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWeb();
    }

    public boolean shouldDisableLandscape() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L7;
        tt5.a.k(this.TAG, "getUrl: docViewModel is null");
        return true;
    L7:
        if (TextUtils.equals(r0.getDocumentType(), sbb.e.o.getType()) == false) goto L10;
    L8:
        return false;
    L10:
        if (ku5.c.k(getContext()) == true) goto L8;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    public void reloadDocumentFragment(String r3, Map<String, String> r4) {
        int r0 = com.bytedance.ee.bear.browser.plugin.j.a;
        z5 r1 = (z5) getHost().getHostAbilityOrNull(z5.class);
        if (r1 == null) goto L6;
        r1.reloadDocumentFragment(r3, r4);
        return;
    }

    public final void dispatchBridgeMsg(String r2, Object r3, tb5.m r4) {
        Intrinsics.checkNotNullParameter(r2, "handlerName");
        getBridge().a(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reloadDocumentFragment$default(DocumentPluginV2 r0, String r1, Map r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.reloadDocumentFragment(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reloadDocumentFragment");
    }

    public static /* synthetic */ void dispatchBridgeMsg$default(DocumentPluginV2 r1, String r2, Object r3, tb5.m r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.dispatchBridgeMsg(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchBridgeMsg");
    }
}
