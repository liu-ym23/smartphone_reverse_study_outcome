package com.bytedance.ee.bear.browser.demo;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.BaseWebPlugin;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;
import xv4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class XXMVVMPlugin extends BaseWebPlugin<WebPluginHost> {
    private XXViewModel xxViewModel;

    public class a implements i<WebData> {
        public final /* synthetic */ XXMVVMPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(XXMVVMPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            XXViewModel r3 = XXMVVMPlugin.access$100(this.a);
            r3.updateWebData((WebData) r1);
        }
    }

    public static /* synthetic */ void a(XXMVVMPlugin r0, WebData r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void ensureXXFragment() {
        if (getUIContainer().l(this) == null) goto L5;
        return;
    L5:
        Fragment r0 = instantiateFragment(XXFragment.class);
        getUIContainer().i(this, r0);
    }

    private void ensureXXView() {
        t r0 = getUIContainer();
        if (r0.findView(2131382751) != null) goto L6;
        r0.b(this, 2131559204);
        return;
    }

    public XXMVVMPlugin() {
    }

    public static /* synthetic */ XXViewModel access$100(XXMVVMPlugin r0) {
        return r0.xxViewModel;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(WebData r1) {
        if (WebData.validate(r1) == false) goto L6;
        ensureXXView();
        ensureXXFragment();
        return;
    }

    public void onAttachToHost(WebPluginHost r3) {
        super.onAttachToHost(r3);
        XXViewModel r4 = (XXViewModel) viewModel(XXViewModel.class);
        this.xxViewModel = r4;
        r4.getWebData().observe(getLifecycleOwner(), new b(this));
        bindBridgeHandler("xxJS", new a(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((WebPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((WebPluginHost) r1, r2);
    }

    public void onAttachToUIContainer(WebPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
    }
}
