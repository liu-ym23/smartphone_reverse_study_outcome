package com.bytedance.ee.bear.edit.component.richtexteditor.plugin;

import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.edit.component.RichTextEditorViewModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RichTextEditModePlugin extends BasePlugin<WebPluginHost> {
    private static final String TAG = "RichTextEditModePlugin";
    private m mCancelEditCallBack;
    private m mSwitchToEditCallBack;
    private RichTextEditorViewModel viewModel;

    public class a implements RichTextEditorViewModel.b {
        public final /* synthetic */ RichTextEditModePlugin a;

        public a(RichTextEditModePlugin r1) {
            this.a = r1;
        }
    }

    public class b implements i<String> {
        public final /* synthetic */ RichTextEditModePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(RichTextEditModePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            RichTextEditModePlugin.access$102(this.a, r2);
        }
    }

    public class c implements i<String> {
        public final /* synthetic */ RichTextEditModePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(RichTextEditModePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            RichTextEditModePlugin.access$500(this.a).onDoubleClick();
        }
    }

    public class d implements i<String> {
        public final /* synthetic */ RichTextEditModePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(RichTextEditModePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            RichTextEditModePlugin.access$002(this.a, r2);
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public RichTextEditModePlugin() {
    }

    public static /* synthetic */ m access$000(RichTextEditModePlugin r0) {
        return r0.mSwitchToEditCallBack;
    }

    public static /* synthetic */ m access$100(RichTextEditModePlugin r0) {
        return r0.mCancelEditCallBack;
    }

    public static /* synthetic */ RichTextEditorViewModel access$500(RichTextEditModePlugin r0) {
        return r0.viewModel;
    }

    public void onAttachToHost(WebPluginHost r4) {
        super.onAttachToHost(r4);
        RichTextEditorViewModel r0 = (RichTextEditorViewModel) q.c(r4, RichTextEditorViewModel.class, null);
        this.viewModel = r0;
        r0.setEditModeDelegate(new a(this));
        r4.getWeb().h("biz.richText.switchToEdit", new d(this));
        r4.getWeb().h("biz.richText.doubleClick", new c(this));
        r4.getWeb().h("biz.richText.cancelEdit", new b(this));
    }

    public void onDetachFromHost(WebPluginHost r3) {
        super.onDetachFromHost(r3);
        r3.getWeb().unbindJSHandler("biz.richText.switchToEdit");
        r3.getWeb().unbindJSHandler("biz.richText.doubleClick");
        r3.getWeb().unbindJSHandler("biz.richText.cancelEdit");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((WebPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((WebPluginHost) r1);
    }

    public static /* synthetic */ m access$002(RichTextEditModePlugin r0, m r1) {
        r0.mSwitchToEditCallBack = r1;
        return r1;
    }

    public static /* synthetic */ m access$102(RichTextEditModePlugin r0, m r1) {
        r0.mCancelEditCallBack = r1;
        return r1;
    }
}
