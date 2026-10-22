package com.bytedance.ee.bear.document.selection;

import android.view.ViewParent;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ShowHideMenuPlugin extends DocumentPlugin {
    private static final String BIZ_UTIL_HIDE_CONTEXT_MENU = "biz.util.hideContextMenu";
    private static final String BIZ_UTIL_SHOW_CONTEXT_MENU = "biz.util.showContextMenu";
    private static final String TAG = "ShowHideMenuPlugin";

    public class a implements tb5.i<Void> {
        public final /* synthetic */ ShowHideMenuPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(ShowHideMenuPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            tt5.a.h(ShowHideMenuPlugin.TAG, "HideMenuHandler: " + ((Void) r2));
            ViewParent r4 = ShowHideMenuPlugin.access$200(this.a).getWebView();
            if ((r4 instanceof zv4.b) == false) goto L6;
            ((zv4.b) r4).c();
            return;
        }
    }

    public class b implements tb5.i<Void> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            tt5.a.h(ShowHideMenuPlugin.TAG, "ShowMenuHandler: " + ((Void) r2));
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ShowHideMenuPlugin() {
    }

    public static /* synthetic */ vv4.k access$200(ShowHideMenuPlugin r0) {
        return r0.getWeb();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(BIZ_UTIL_HIDE_CONTEXT_MENU, new a(this));
        r3.put(BIZ_UTIL_SHOW_CONTEXT_MENU, new b());
    }
}
