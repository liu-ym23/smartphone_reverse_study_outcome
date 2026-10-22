package com.bytedance.ee.bear.document.selection;

import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectionPluginNew extends SelectionPlugin {
    private static final String TAG = "SelectionPluginNew";
    private sy4.d followStateObserver;
    private p newWebSelection;

    public class a implements sy4.d {
        public final /* synthetic */ SelectionPluginNew a;

        public a(SelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // sy4.d
        public final void a(sy4.b r2) {
            if ((r2 instanceof sy4.e) == true) goto L5;
            return;
        L5:
            if (((sy4.e) r2).b == true) goto L7;
            return;
        L7:
            if (SelectionPluginNew.access$000(this.a) != null) goto L9;
            return;
        L9:
            if (SelectionPluginNew.access$000(this.a).x == false) goto L15;
            SelectionPluginNew.access$000(this.a).closeActionMode();
            return;
        }
    }

    public class b implements tb5.i<String> {
        public final /* synthetic */ SelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            p r4 = SelectionPluginNew.access$000(this.a);
            SelectionPluginNew r0 = this.a;
            r4.onSelectionChanged(SelectionPluginNew.access$100(r0, (String) r2));
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ SelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(SelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            String r4 = (String) r2;
            SelectionPluginNew.access$200(this.a);
            tt5.a.h(SelectionPluginNew.TAG, " BIZ_SELECT_SHOW_ACTION_MODE: " + r4);
            SelectionPluginNew.access$000(this.a).showActionMode(r4);
        }
    }

    public class d implements tb5.i<String> {
        public final /* synthetic */ SelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(SelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            SelectionPluginNew.access$300(this.a);
            SelectionPluginNew.access$000(this.a).closeActionMode();
        }
    }

    public class e implements tb5.i<String> {
        public final /* synthetic */ SelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(SelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            tt5.a.h(SelectionPluginNew.TAG, " BIZ_SELECT_HIDE_HANDLER: " + ((String) r2));
            SelectionPluginNew.access$000(this.a).x = false;
        }
    }

    public class f implements tb5.i<String> {
        public final /* synthetic */ SelectionPluginNew a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(SelectionPluginNew r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            String r5 = (String) r3;
            tt5.a.b(SelectionPluginNew.TAG, "full screen: " + r5);
            SelectionPluginNew.access$000(this.a).y = JSONObjectProtectorUtils.getBoolean(new JSONObject(r5), "isFullScreen");     // Catch: Exception -> L7
            if (rcb.b.a(SelectionPluginNew.access$400(this.a)) == false) goto L12;
            ((EditPanelsManager) ViewModelProviders.of(SelectionPluginNew.access$500(this.a)).get(EditPanelsManager.class)).forceCloseToolbarV2();     // Catch: Exception -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            tt5.a.e(SelectionPluginNew.TAG, "mindnote full screen exception ", e, false);
        }
    }

    public static /* synthetic */ void f(SelectionPluginNew r0, Boolean r1) {
        r0.lambda$onAttachToUIContainer$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void registerFollowStateObserver() {
        FollowPlugin r0 = (FollowPlugin) findPlugin(FollowPlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getDocumentFollow() == null) goto L10;
        unregisterFollowStateObserver();
        r0.getDocumentFollow().registerDocFollowStateObserver(this.followStateObserver);
        return;
    }

    private void setEnableTextIntentItems() {
        p r0 = this.newWebSelection;
        r0.t = shouldEnableTextIntentItems();
    }

    private void unregisterFollowStateObserver() {
        FollowPlugin r0 = (FollowPlugin) findPlugin(FollowPlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getDocumentFollow() == null) goto L10;
        r0.getDocumentFollow().unregisterDocFollowStateObserver(this.followStateObserver);
        return;
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void clearSelection() {
        p r0 = this.newWebSelection;
        r0.getClass();
        tt5.a.h("SelectionNewBase", "jsClearSelectionExcludeCursor");
        r0.c("javascript:window.lark.biz.selection.clearSelectionExcludeCursor", null, null);
    }

    public String getShareTitle() {
        return this.newWebSelection.J;
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public boolean isShowingActionMode() {
        if (this.newWebSelection.e == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void jsClearDocxSelection() {
        p r0 = this.newWebSelection;
        r0.getClass();
        tt5.a.h("SelectionNewBase", "jsClearDocxSelection");
        r0.c("javascript:window.lark.biz.selection.clearDocxSelection", null, null);
    }

    public SelectionPluginNew() {
        this.followStateObserver = new a(this);
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, vz4.d, com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin
    public void closeActionMode() {
        unregisterFollowStateObserver();
        this.newWebSelection.closeActionMode();
    }

    public static /* synthetic */ p access$000(SelectionPluginNew r0) {
        return r0.newWebSelection;
    }

    public static /* synthetic */ void access$200(SelectionPluginNew r0) {
        r0.registerFollowStateObserver();
    }

    public static /* synthetic */ void access$300(SelectionPluginNew r0) {
        r0.unregisterFollowStateObserver();
    }

    public static /* synthetic */ Context access$400(SelectionPluginNew r0) {
        return r0.getContext();
    }

    public static /* synthetic */ FragmentActivity access$500(SelectionPluginNew r0) {
        return r0.getActivity();
    }

    private void lambda$onAttachToUIContainer$0(Boolean r2) {
        p r0 = this.newWebSelection;
        r0.z = r2.booleanValue();
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

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin
    public void setSelectionScrollEndRate(float r2) {
        this.newWebSelection.b = r2;
    }

    public static /* synthetic */ boolean access$100(SelectionPluginNew r0, String r1) {
        return r0.parseSelectionChangeData(r1);
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin
    public void onAttachToUIContainer(DocumentPluginHost r4, com.bytedance.ee.bear.browser.plugin.t r5) {
        super.onAttachToUIContainer(r4, r5);
        vv4.k r6 = r4.getWeb();
        WebView r0 = r6.getWebView();
        if (r0 == null) goto L12;
        if (r0.hasWindowFocus() == false) goto L12;
        if (getDocViewModel().isSyncBlock() == false) goto L12;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.synced_block.separate_page_mobile") == false) goto L12;
        tt5.a.h(TAG, "notify webview focus change");
        r0.onWindowFocusChanged(true);
    L12:
        if (com.larksuite.framework.utils.x.a() == false) goto L14;
        p r1 = new t((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r4);
    L15:
        this.newWebSelection = r1;
        r1.g = getActionModeDelegate();
        p r2 = this.newWebSelection;
        r2.C = getMenuItemClickListener();
        pcb.a.a.b(r4.getActivity()).c(this.newWebSelection);
        this.newWebSelection.b((z4) r6);
        r6.addOnTouchListener(this.newWebSelection);
        setEnableTextIntentItems();
        if (getDocViewModel() == null) goto L25;
        if (getDocViewModel().isShowingHistory() == null) goto L25;
        Boolean r7 = (Boolean) getDocViewModel().isShowingHistory().getValue();
        if (r7 != null) goto L22;
        this.newWebSelection.z = false;
    L23:
        getDocViewModel().isShowingHistory().observe(getLifecycleOwner(), new k0(this));
        goto L25
    L22:
        p r3 = this.newWebSelection;
        r3.z = r7.booleanValue();
    L25:
        if ((r6.getWebView() instanceof zv4.b) == false) goto L27;
        ((zv4.b) r6.getWebView()).e(this.newWebSelection);
    L27:
        bindBridgeHandler("biz.selection.onSelectionChangedV2", new b(this));
        bindBridgeHandler("biz.navigation.showCustomContextMenu", new c(this));
        bindBridgeHandler("biz.navigation.closeCustomContextMenu", new d(this));
        bindJSHandler("biz.selection.hideSelectionHandler", new e(this));
        bindJSHandler("biz.mindnote.fullScreen", new f(this));
        return;
    L14:
        r1 = new u(r4, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
        goto L15
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin
    public void onDetachFromUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        pcb.a.a.b(r2.getActivity()).a(this.newWebSelection);
        this.newWebSelection.e();
        vv4.k r4 = r2.getWeb();
        r4.removeOnTouchListener(this.newWebSelection);
        if ((r4.getWebView() instanceof zv4.b) == false) goto L5;
        ((zv4.b) r4.getWebView()).f(this.newWebSelection);
    L5:
        unregisterFollowStateObserver();
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.selection.SelectionPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
