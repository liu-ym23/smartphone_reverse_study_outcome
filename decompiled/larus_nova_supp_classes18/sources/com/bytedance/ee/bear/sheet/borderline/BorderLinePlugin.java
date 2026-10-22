package com.bytedance.ee.bear.sheet.borderline;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BorderLinePlugin extends DocumentPlugin {
    private static final String CLEAR_BORDER_LINE_PANEL = "biz.sheet.clearBorderLinePanel";
    private BorderLineViewModel borderLineViewModel;

    public class a implements tb5.i<Void> {
        public final /* synthetic */ BorderLinePlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public a(BorderLinePlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            if (BorderLinePlugin.access$100(this.a) == null) goto L6;
            BorderLinePlugin.access$100(this.a).clearBorderLinePanel();
            return;
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BorderLinePlugin() {
    }

    public static /* synthetic */ BorderLineViewModel access$100(BorderLinePlugin r0) {
        return r0.borderLineViewModel;
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(CLEAR_BORDER_LINE_PANEL, new a(this));
    }

    public void onAttachToHost(DocumentPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        this.borderLineViewModel = (BorderLineViewModel) viewModel(BorderLineViewModel.class);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }
}
