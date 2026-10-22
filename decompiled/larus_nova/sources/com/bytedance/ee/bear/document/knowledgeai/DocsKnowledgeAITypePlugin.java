package com.bytedance.ee.bear.document.knowledgeai;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.n0;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class DocsKnowledgeAITypePlugin extends DocumentPluginV2 {
    private static final String TAG = "DocsKnowledgeAITypePlugin";
    private DocsKnowledgeAIType pendingAIType;
    private com.bytedance.ee.bear.document.knowledgeai.a provider;
    private com.bytedance.ee.bear.document.knowledgeai.a.InterfaceC3137a providerListener;
    private final n0 renderCallback;
    private z4 renderCallbackWeb;

    public class a extends n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocsKnowledgeAITypePlugin f220146a;

        public a(DocsKnowledgeAITypePlugin r100) {
            this.f220146a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.n0, com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r100) {
            j.c(new w15.a(this));
        }
    }

    public class b implements com.bytedance.ee.bear.document.knowledgeai.a.InterfaceC3137a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocsKnowledgeAITypePlugin f220147a;

        public b(DocsKnowledgeAITypePlugin r100) {
            this.f220147a = r100;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private void start() {
        if (this.providerListener == null) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.document.knowledgeai.a r100 = getDocsKnowledgeAIProvider();
        this.provider = r100;
        if (r100 != null) goto L8;
    L10:
        DocsKnowledgeAIType r101 = DocsKnowledgeAIType.NONE;
    L11:
        this.pendingAIType = r101;
        com.bytedance.ee.bear.document.knowledgeai.a r102 = this.provider;
        if (r102 != null) goto L14;
        return;
    L14:
        b r103 = new b(this);
        this.providerListener = r103;
        r102.e(r103);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        tt5.a.e(TAG, "addListener fail", th, false);
        return;
    L8:
        if (r100.d() == null) goto L10;
        r101 = this.provider.d();
        goto L11
    }

    private void syncKnowledgeAIStateToWeb() {
        syncKnowledgeAITypeToWeb(this.pendingAIType);
        yz4.b.a(getHost()).h(getHost());     // Catch: Throwable -> L5
        syncFlowAIEnableToWeb(false);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e(TAG, "resolveDocAIEnable fail", th, false);
        syncFlowAIEnableToWeb(false);
    }

    private void unregisterRenderCallback() {
        z4 r100 = this.renderCallbackWeb;
        this.renderCallbackWeb = null;
        if (r100 == null) goto L6;
        r100.m(this.renderCallback);
        return;
    }

    public DocsKnowledgeAITypePlugin() {
        this.pendingAIType = DocsKnowledgeAIType.NONE;
        this.renderCallback = new a(this);
    }

    private com.bytedance.ee.bear.document.knowledgeai.a getDocsKnowledgeAIProvider() {
        return (com.bytedance.ee.bear.document.knowledgeai.a) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);
    L4:
        th = move-exception;
        tt5.a.e(TAG, "getDocsKnowledgeAIProvider fail", th, false);
        return null;
    }

    private void registerRenderCallback() {
        unregisterRenderCallback();
        PluginHost r100 = getHost();
        if ((r100 instanceof WebPluginHost) == false) goto L5;
        vv4.k r101 = ((WebPluginHost) r100).getWeb();
    L7:
        if ((r101 instanceof z4) == false) goto L9;
        z4 r102 = (z4) r101;
        this.renderCallbackWeb = r102;
        r102.x(this.renderCallback);
        return;
    L9:
        tt5.a.k(TAG, "registerRenderCallback skip: web is not ISafeReuseDocumentWeb");
        return;
    L5:
        r101 = null;
        goto L7
    }

    private void stop() {
        unregisterRenderCallback();
        com.bytedance.ee.bear.document.knowledgeai.a r100 = this.provider;
        if (r100 == null) goto L10;
        com.bytedance.ee.bear.document.knowledgeai.a.InterfaceC3137a r101 = this.providerListener;
        if (r101 == null) goto L10;
        r100.f(r101);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        tt5.a.e(TAG, "removeListener fail", th, false);
    L10:
        this.provider = null;
        this.providerListener = null;
        this.pendingAIType = DocsKnowledgeAIType.NONE;
    }

    public static /* synthetic */ void access$000(DocsKnowledgeAITypePlugin r100) {
        r100.start();
    }

    public static /* synthetic */ void access$100(DocsKnowledgeAITypePlugin r100) {
        r100.syncKnowledgeAIStateToWeb();
    }

    public static /* synthetic */ DocsKnowledgeAIType access$200(DocsKnowledgeAITypePlugin r100) {
        return r100.pendingAIType;
    }

    private void syncFlowAIEnableToWeb(boolean r100) {
        vv4.k r101 = getWebOrNull();
        if (r101 != null) goto L11;
        tt5.a.k(TAG, "syncFlowAIEnableToWeb skip: web is null, enable=" + r100);
        return;
    L11:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L8
        r102.put2("enable", Boolean.valueOf(r100));     // Catch: Throwable -> L8
        tt5.a.h(TAG, "syncFlowAIEnableToWeb execJS: protocol=javascript:window.lark.biz.flowAI.enable, enable=" + r100);     // Catch: Throwable -> L8
        r101.j("javascript:window.lark.biz.flowAI.enable", r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e(TAG, "syncFlowAIEnableToWeb fail, enable=" + r100, th, false);
    }

    private void syncKnowledgeAITypeToWeb(DocsKnowledgeAIType r100) {
        vv4.k r101 = getWebOrNull();
        if (r101 != null) goto L11;
        tt5.a.k(TAG, "syncKnowledgeAITypeToWeb skip: web is null, ability=" + r100.getWireValue());
        return;
    L11:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L8
        r102.put2("ability", r100.getWireValue());     // Catch: Throwable -> L8
        tt5.a.h(TAG, "syncKnowledgeAITypeToWeb execJS: protocol=javascript:window.lark.biz.knowledgeAI.type, ability=" + r100.getWireValue());     // Catch: Throwable -> L8
        r101.j("javascript:window.lark.biz.knowledgeAI.type", r102);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e(TAG, "syncKnowledgeAITypeToWeb fail, ability=" + r100.getWireValue(), th, false);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        super.onAttachToHost(r100);
        start();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r100) {
        stop();
        super.onDetachFromHost(r100);
    }

    public static /* synthetic */ DocsKnowledgeAIType access$202(DocsKnowledgeAITypePlugin r100, DocsKnowledgeAIType r101) {
        r100.pendingAIType = r101;
        return r101;
    }

    public static /* synthetic */ void access$300(DocsKnowledgeAITypePlugin r100, DocsKnowledgeAIType r101) {
        r100.syncKnowledgeAITypeToWeb(r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        registerRenderCallback();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r100, t r101) {
        unregisterRenderCallback();
        super.onDetachFromUIContainer(r100, r101);
    }
}
