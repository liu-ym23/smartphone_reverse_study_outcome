package com.bytedance.ee.bear.sheet.borderline;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeBorderLinePlugin extends DocumentPluginV3 {
    private static final String CLEAR_BORDER_LINE_PANEL = "biz.sheet.clearBorderLinePanel";
    private OfficeBorderLineViewModel borderLineViewModel;

    public class a implements tb5.i<Void> {
        public final /* synthetic */ OfficeBorderLinePlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public a(OfficeBorderLinePlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r1, m r2) {
            Void r3 = (Void) r1;
            if (OfficeBorderLinePlugin.access$100(this.a) == null) goto L6;
            OfficeBorderLinePlugin.access$100(this.a).clearBorderLinePanel();
            return;
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficeBorderLinePlugin() {
    }

    public static /* synthetic */ OfficeBorderLineViewModel access$100(OfficeBorderLinePlugin r0) {
        return r0.borderLineViewModel;
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(CLEAR_BORDER_LINE_PANEL, new a(this));
    }

    public void onAttachToHost(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r1);
        this.borderLineViewModel = (OfficeBorderLineViewModel) viewModel(OfficeBorderLineViewModel.class);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
