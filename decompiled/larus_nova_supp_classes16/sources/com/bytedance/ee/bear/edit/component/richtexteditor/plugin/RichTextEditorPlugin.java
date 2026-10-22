package com.bytedance.ee.bear.edit.component.richtexteditor.plugin;

import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.edit.component.RichTextEditorViewModel;
import com.bytedance.ee.bear.edit.component.richtexteditor.data.RichTextData;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Locale;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RichTextEditorPlugin extends BasePlugin<WebPluginHost> {
    private static final String BIZ_NOTIFY_READY = "biz.notify.ready";
    private static final String TAG = "RichTextEditorPlugin";
    private m mSubmitCallBack;
    private RichTextEditorViewModel viewModel;

    public class a implements i<String> {
        public final /* synthetic */ RichTextEditorPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(RichTextEditorPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            MutableLiveData<String> r3 = RichTextEditorPlugin.access$600(this.a).getContentChanged();
            r3.setValue((String) r1);
        }
    }

    public static class b implements i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            tt5.a.h(RichTextEditorPlugin.TAG, "bridge ready!");
        }
    }

    public class c implements i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c() {
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            String r3 = (String) r1;
        }
    }

    public class d implements i<String> {
        public final /* synthetic */ RichTextEditorPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(RichTextEditorPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            String r6 = (String) r4;
            String r7 = Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
            RichTextData r0 = new RichTextData();
            RichTextData.a r1 = new RichTextData.a();
            r1.a = "read";
            r1.b = r7;
            r0.setContent(RichTextEditorPlugin.access$600(this.a).getRichTextContent());
            r0.setConfig(r1);
            r5.a(r0);
        }
    }

    public class e implements i<String> {
        public final /* synthetic */ RichTextEditorPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(RichTextEditorPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, m r2) {
            String r3 = (String) r1;
            RichTextEditorPlugin.access$702(this.a, r2);
        }
    }

    public static class f implements i<String> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f() {
        }

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            String r3 = (String) r1;
        }
    }

    public static /* synthetic */ void a(RichTextEditorPlugin r0) {
        r0.lambda$onAttachToHost$0();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private /* synthetic */ void lambda$onAttachToHost$0() {
        this.mSubmitCallBack.b(new JSONObject());
    }

    public RichTextEditorPlugin() {
    }

    public static /* synthetic */ RichTextEditorViewModel access$600(RichTextEditorPlugin r0) {
        return r0.viewModel;
    }

    public void onAttachToHost(WebPluginHost r4) {
        super.onAttachToHost(r4);
        RichTextEditorViewModel r0 = (RichTextEditorViewModel) q.c(r4, RichTextEditorViewModel.class, null);
        this.viewModel = r0;
        r0.setSubmitDelegate(new pa5.a(this));
        r4.getWeb().h(BIZ_NOTIFY_READY, new b());
        r4.getWeb().h("biz.richText.setContent", new d(this));
        r4.getWeb().h("biz.richText.submit", new e(this));
        r4.getWeb().h("biz.richText.contentToSubmit", new a(this));
        r4.getWeb().h("biz.richText.updateTheme", new f());
        r4.getWeb().h("biz.richText.rendered", new c());
    }

    public void onDetachFromHost(WebPluginHost r3) {
        super.onDetachFromHost(r3);
        r3.getWeb().unbindJSHandler("biz.richText.setContent");
        r3.getWeb().unbindJSHandler(BIZ_NOTIFY_READY);
        r3.getWeb().unbindJSHandler("biz.richText.submit");
        r3.getWeb().unbindJSHandler("biz.richText.contentToSubmit");
        r3.getWeb().unbindJSHandler("biz.richText.updateTheme");
        r3.getWeb().unbindJSHandler("biz.richText.rendered");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((WebPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((WebPluginHost) r1);
    }

    public static /* synthetic */ m access$702(RichTextEditorPlugin r0, m r1) {
        r0.mSubmitCallBack = r1;
        return r1;
    }
}
