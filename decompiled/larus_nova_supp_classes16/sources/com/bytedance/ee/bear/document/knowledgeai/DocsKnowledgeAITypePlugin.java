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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocsKnowledgeAITypePlugin extends DocumentPluginV2 {
    private static final String TAG = "DocsKnowledgeAITypePlugin";
    private DocsKnowledgeAIType pendingAIType;
    private com.bytedance.ee.bear.document.knowledgeai.a provider;
    private com.bytedance.ee.bear.document.knowledgeai.a.InterfaceC0081a providerListener;
    private final n0 renderCallback;
    private z4 renderCallbackWeb;

    public class a extends n0 {
        public final /* synthetic */ DocsKnowledgeAITypePlugin a;

        public a(DocsKnowledgeAITypePlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.n0, com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r1) {
            j.c(new w15.a(this));
        }
    }

    public class b implements com.bytedance.ee.bear.document.knowledgeai.a.InterfaceC0081a {
        public final /* synthetic */ DocsKnowledgeAITypePlugin a;

        public b(DocsKnowledgeAITypePlugin r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void start() {
        if (this.providerListener == null) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.document.knowledgeai.a r0 = getDocsKnowledgeAIProvider();
        this.provider = r0;
        if (r0 != null) goto L8;
    L10:
        DocsKnowledgeAIType r1 = DocsKnowledgeAIType.NONE;
    L11:
        this.pendingAIType = r1;
        com.bytedance.ee.bear.document.knowledgeai.a r2 = this.provider;
        if (r2 != null) goto L14;
        return;
    L14:
        b r3 = new b(this);
        this.providerListener = r3;
        r2.e(r3);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        tt5.a.e(TAG, "addListener fail", th, false);
        return;
    L8:
        if (r0.d() == null) goto L10;
        r1 = this.provider.d();
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
        z4 r0 = this.renderCallbackWeb;
        this.renderCallbackWeb = null;
        if (r0 == null) goto L6;
        r0.m(this.renderCallback);
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
        PluginHost r0 = getHost();
        if ((r0 instanceof WebPluginHost) == false) goto L5;
        vv4.k r1 = ((WebPluginHost) r0).getWeb();
    L7:
        if ((r1 instanceof z4) == false) goto L9;
        z4 r2 = (z4) r1;
        this.renderCallbackWeb = r2;
        r2.x(this.renderCallback);
        return;
    L9:
        tt5.a.k(TAG, "registerRenderCallback skip: web is not ISafeReuseDocumentWeb");
        return;
    L5:
        r1 = null;
        goto L7
    }

    private void stop() {
        unregisterRenderCallback();
        com.bytedance.ee.bear.document.knowledgeai.a r0 = this.provider;
        if (r0 == null) goto L10;
        com.bytedance.ee.bear.document.knowledgeai.a.InterfaceC0081a r1 = this.providerListener;
        if (r1 == null) goto L10;
        r0.f(r1);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        tt5.a.e(TAG, "removeListener fail", th, false);
    L10:
        this.provider = null;
        this.providerListener = null;
        this.pendingAIType = DocsKnowledgeAIType.NONE;
    }

    public static /* synthetic */ void access$000(DocsKnowledgeAITypePlugin r0) {
        r0.start();
    }

    public static /* synthetic */ void access$100(DocsKnowledgeAITypePlugin r0) {
        r0.syncKnowledgeAIStateToWeb();
    }

    public static /* synthetic */ DocsKnowledgeAIType access$200(DocsKnowledgeAITypePlugin r0) {
        return r0.pendingAIType;
    }

    private void syncFlowAIEnableToWeb(boolean r7) {
        vv4.k r1 = getWebOrNull();
        if (r1 != null) goto L11;
        tt5.a.k(TAG, "syncFlowAIEnableToWeb skip: web is null, enable=" + r7);
        return;
    L11:
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L8
        r3.put("enable", Boolean.valueOf(r7));     // Catch: Throwable -> L8
        tt5.a.h(TAG, "syncFlowAIEnableToWeb execJS: protocol=javascript:window.lark.biz.flowAI.enable, enable=" + r7);     // Catch: Throwable -> L8
        r1.j("javascript:window.lark.biz.flowAI.enable", r3);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e(TAG, "syncFlowAIEnableToWeb fail, enable=" + r7, th, false);
    }

    private void syncKnowledgeAITypeToWeb(DocsKnowledgeAIType r7) {
        vv4.k r1 = getWebOrNull();
        if (r1 != null) goto L11;
        tt5.a.k(TAG, "syncKnowledgeAITypeToWeb skip: web is null, ability=" + r7.getWireValue());
        return;
    L11:
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L8
        r3.put("ability", r7.getWireValue());     // Catch: Throwable -> L8
        tt5.a.h(TAG, "syncKnowledgeAITypeToWeb execJS: protocol=javascript:window.lark.biz.knowledgeAI.type, ability=" + r7.getWireValue());     // Catch: Throwable -> L8
        r1.j("javascript:window.lark.biz.knowledgeAI.type", r3);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.e(TAG, "syncKnowledgeAITypeToWeb fail, ability=" + r7.getWireValue(), th, false);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r1) {
        super.onAttachToHost(r1);
        start();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        stop();
        super.onDetachFromHost(r1);
    }

    public static /* synthetic */ DocsKnowledgeAIType access$202(DocsKnowledgeAITypePlugin r0, DocsKnowledgeAIType r1) {
        r0.pendingAIType = r1;
        return r1;
    }

    public static /* synthetic */ void access$300(DocsKnowledgeAITypePlugin r0, DocsKnowledgeAIType r1) {
        r0.syncKnowledgeAITypeToWeb(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        registerRenderCallback();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        unregisterRenderCallback();
        super.onDetachFromUIContainer(r1, r2);
    }
}
