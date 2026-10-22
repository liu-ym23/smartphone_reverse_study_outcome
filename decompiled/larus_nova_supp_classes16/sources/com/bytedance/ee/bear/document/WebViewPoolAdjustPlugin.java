package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.fail.DocException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WebViewPoolAdjustPlugin extends DocumentPlugin {
    private static final String TAG = "WebViewPoolAdjustPlugin";
    private final com.bytedance.ee.bear.contract.m0 renderCallback;

    public class a implements com.bytedance.ee.bear.contract.m0 {
        public final /* synthetic */ WebViewPoolAdjustPlugin a;

        @Override // com.bytedance.ee.bear.contract.m0
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void b() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void c() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void d() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void e() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void f() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void g() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void h() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void i(DocException r1, Map r2) {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void j() {
        }

        public a(WebViewPoolAdjustPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r1) {
            WebViewPoolAdjustPlugin.access$000(this.a);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void doOnRenderSuccess() {
        tt5.a.h(TAG, "doOnRenderSuccess()...");
        l7 r0 = y7.j;
        y7.a.a.a();
    }

    public WebViewPoolAdjustPlugin() {
        this.renderCallback = new a(this);
    }

    public static /* synthetic */ void access$000(WebViewPoolAdjustPlugin r0) {
        r0.doOnRenderSuccess();
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        tt5.a.h(TAG, "onAttachToHost()...");
        super.onAttachToHost(r3);
        if ((getWeb() instanceof z4) == false) goto L6;
        ((z4) getWeb()).x(this.renderCallback);
        return;
    }

    public void onDetachFromHost(DocumentPluginHost r3) {
        tt5.a.h(TAG, "onDetachFromHost()...");
        super.onDetachFromHost(r3);
        if ((getWeb() instanceof z4) == false) goto L5;
        ((z4) getWeb()).m(this.renderCallback);
    L5:
        l7 r4 = y7.j;
        y7.a.a.a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }
}
