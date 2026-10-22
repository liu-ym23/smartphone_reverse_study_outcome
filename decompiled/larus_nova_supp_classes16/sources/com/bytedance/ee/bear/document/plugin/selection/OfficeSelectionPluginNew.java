package com.bytedance.ee.bear.document.plugin.selection;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeSelectionPluginNew extends OfficeSelectionPlugin {
    private static final String TAG = "SelectionPluginNew";
    private v newWebSelection;

    public class a implements tb5.i<String> {
        public final /* synthetic */ OfficeSelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeSelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            v r4 = OfficeSelectionPluginNew.access$100(this.a);
            OfficeSelectionPluginNew r0 = this.a;
            r4.onSelectionChanged(OfficeSelectionPluginNew.access$000(r0, (String) r2));
        }
    }

    public class b implements tb5.i<String> {
        public final /* synthetic */ OfficeSelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeSelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            v r3 = OfficeSelectionPluginNew.access$100(this.a);
            r3.showActionMode((String) r1);
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ OfficeSelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficeSelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            OfficeSelectionPluginNew.access$100(this.a).closeActionMode();
        }
    }

    public class d implements tb5.i<String> {
        public final /* synthetic */ OfficeSelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(OfficeSelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            tt5.a.h(OfficeSelectionPluginNew.TAG, " BIZ_SELECT_HIDE_HANDLER: " + ((String) r2));
            OfficeSelectionPluginNew.access$100(this.a).w = false;
        }
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void setEnableTextIntentItems() {
        v r0 = this.newWebSelection;
        r0.s = shouldEnableTextIntentItems();
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void clearSelection() {
        v r0 = this.newWebSelection;
        r0.getClass();
        tt5.a.h("SelectionNewBase", "jsClearSelectionExcludeCursor");
        r0.c("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, vz4.d, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void closeActionMode() {
        this.newWebSelection.closeActionMode();
    }

    public String getShareTitle() {
        return this.newWebSelection.G;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public boolean isShowingActionMode() {
        if (this.newWebSelection.e == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void jsClearDocxSelection() {
        v r0 = this.newWebSelection;
        r0.getClass();
        tt5.a.h("SelectionNewBase", "jsClearDocxSelection");
        r0.c("javascript:window.lark.biz.selection.clearDocxSelection", null, null);
    }

    public OfficeSelectionPluginNew() {
    }

    public static /* synthetic */ v access$100(OfficeSelectionPluginNew r0) {
        return r0.newWebSelection;
    }

    private boolean parseSelectionChangeData(String r4) {
        if (r4 != null) goto L10;
        return false;
    L10:
        return new JSONObject(r4).optBoolean("hasRange", false);
    L7:
        th = move-exception;
        tt5.a.e(TAG, "parseSelectionChangeData", th, false);
        return false;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        super.getBridgeHandlers(r3);
        r3.put("biz.selection.onSelectionChangedV2", new a(this));
        r3.put("biz.navigation.showCustomContextMenu", new b(this));
        r3.put("biz.navigation.closeCustomContextMenu", new c(this));
        r3.put("biz.selection.hideSelectionHandler", new d(this));
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin
    public void setSelectionScrollEndRate(float r2) {
        this.newWebSelection.b = r2;
    }

    public static /* synthetic */ boolean access$000(OfficeSelectionPluginNew r0, String r1) {
        return r0.parseSelectionChangeData(r1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin
    public void onAttachToUIContainer(ChameleonPluginHost r4, com.bytedance.ee.bear.browser.plugin.t r5) {
        super.onAttachToUIContainer(r4, r5);
        vv4.k r6 = r4.getWeb();
        ChameleonWebView r0 = r6.getWebView();
        if (r0.hasWindowFocus() == false) goto L10;
        if (getDocumentMetadata().isSyncBlock() == false) goto L10;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.synced_block.separate_page_mobile") == false) goto L10;
        tt5.a.h(TAG, "notify webview focus change");
        r0.onWindowFocusChanged(true);
    L10:
        if (com.larksuite.framework.utils.x.a() == false) goto L12;
        v r1 = new z((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r4);
    L13:
        this.newWebSelection = r1;
        r1.g = getActionModeDelegate();
        v r2 = this.newWebSelection;
        r2.x = getMenuItemClickListener();
        pcb.a.a.b(r4.getActivity()).c(this.newWebSelection);
        this.newWebSelection.b(r0);
        r6.addOnTouchListener(this.newWebSelection);
        setEnableTextIntentItems();
        r0.e(this.newWebSelection);
        return;
    L12:
        r1 = new a0(r4, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin
    public void onDetachFromUIContainer(ChameleonPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        pcb.a.a.b(r2.getActivity()).a(this.newWebSelection);
        this.newWebSelection.e();
        vv4.k r4 = r2.getWeb();
        ChameleonWebView r5 = r4.getWebView();
        r4.removeOnTouchListener(this.newWebSelection);
        r5.f(this.newWebSelection);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.OfficeSelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
