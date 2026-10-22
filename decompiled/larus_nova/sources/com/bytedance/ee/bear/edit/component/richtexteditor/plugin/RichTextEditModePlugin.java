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

/* JADX INFO: loaded from: classes16.dex */
public class RichTextEditModePlugin extends BasePlugin<WebPluginHost> {
    private static final String TAG = "RichTextEditModePlugin";
    private m mCancelEditCallBack;
    private m mSwitchToEditCallBack;
    private RichTextEditorViewModel viewModel;

    public class a implements RichTextEditorViewModel.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichTextEditModePlugin f226041a;

        public a(RichTextEditModePlugin r100) {
            this.f226041a = r100;
        }
    }

    public class b implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichTextEditModePlugin f226042a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(RichTextEditModePlugin r100) {
            this.f226042a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            RichTextEditModePlugin.access$102(this.f226042a, r101);
        }
    }

    public class c implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichTextEditModePlugin f226043a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(RichTextEditModePlugin r100) {
            this.f226043a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            RichTextEditModePlugin.access$500(this.f226043a).onDoubleClick();
        }
    }

    public class d implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RichTextEditModePlugin f226044a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(RichTextEditModePlugin r100) {
            this.f226044a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            RichTextEditModePlugin.access$002(this.f226044a, r101);
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public RichTextEditModePlugin() {
    }

    public static /* synthetic */ m access$000(RichTextEditModePlugin r100) {
        return r100.mSwitchToEditCallBack;
    }

    public static /* synthetic */ m access$100(RichTextEditModePlugin r100) {
        return r100.mCancelEditCallBack;
    }

    public static /* synthetic */ RichTextEditorViewModel access$500(RichTextEditModePlugin r100) {
        return r100.viewModel;
    }

    public void onAttachToHost(WebPluginHost r100) {
        super.onAttachToHost(r100);
        RichTextEditorViewModel r101 = (RichTextEditorViewModel) q.c(r100, RichTextEditorViewModel.class, null);
        this.viewModel = r101;
        r101.setEditModeDelegate(new a(this));
        r100.getWeb().h("biz.richText.switchToEdit", new d(this));
        r100.getWeb().h("biz.richText.doubleClick", new c(this));
        r100.getWeb().h("biz.richText.cancelEdit", new b(this));
    }

    public void onDetachFromHost(WebPluginHost r100) {
        super.onDetachFromHost(r100);
        r100.getWeb().unbindJSHandler("biz.richText.switchToEdit");
        r100.getWeb().unbindJSHandler("biz.richText.doubleClick");
        r100.getWeb().unbindJSHandler("biz.richText.cancelEdit");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((WebPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((WebPluginHost) r100);
    }

    public static /* synthetic */ m access$002(RichTextEditModePlugin r100, m r101) {
        r100.mSwitchToEditCallBack = r101;
        return r101;
    }

    public static /* synthetic */ m access$102(RichTextEditModePlugin r100, m r101) {
        r100.mCancelEditCallBack = r101;
        return r101;
    }
}
