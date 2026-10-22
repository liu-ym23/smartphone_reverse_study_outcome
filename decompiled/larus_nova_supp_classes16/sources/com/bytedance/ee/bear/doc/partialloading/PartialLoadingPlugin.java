package com.bytedance.ee.bear.doc.partialloading;

import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PartialLoadingPlugin extends DocumentPlugin {
    private bz4.a mLoadingObsuration;

    public class a implements i<Void> {
        public final /* synthetic */ PartialLoadingPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(PartialLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            PartialLoadingPlugin.access$200(this.a, false);
        }
    }

    public class b implements i<Void> {
        public final /* synthetic */ PartialLoadingPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(PartialLoadingPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            PartialLoadingPlugin.access$200(this.a, true);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public PartialLoadingPlugin() {
    }

    private void updatePartialLoading(boolean r3) {
        bz4.a r0 = this.mLoadingObsuration;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L9;
        r0.a.setVisibility(0);
        BearLottieView r4 = r0.b;
        if (r4 == null) goto L14;
        r4.playAnimation();
        return;
    L14:
        return;
    L9:
        BearLottieView r5 = r0.b;
        if (r5 == null) goto L12;
        r5.cancelAnimation();
    L12:
        r0.a.setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put("biz.util.showPartialLoading", new b(this));
        r3.put("biz.util.hidePartialLoading", new a(this));
    }

    public static /* synthetic */ void access$200(PartialLoadingPlugin r0, boolean r1) {
        r0.updatePartialLoading(r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        this.mLoadingObsuration = new bz4.a(r2.b(this, 2131560099));
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        bz4.a r3 = this.mLoadingObsuration;
        if (r3 == null) goto L9;
        BearLottieView r4 = r3.b;
        if (r4 == null) goto L7;
        r4.cancelAnimation();
    L7:
        r3.a.setVisibility(8);
        return;
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
}
