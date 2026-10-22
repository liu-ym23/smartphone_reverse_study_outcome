package com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar2;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.DocToolbarV2Compat;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolbarV2JsHandler;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.middleground.docsdk.v2.core.EditorSdkPluginHost;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SDKToolbarV2PanelPlugin extends BasePlugin<EditorSdkPluginHost> {
    private static final String TAG = "SDKToolbarV2PanelPlugin";
    private Observer<Boolean> activeObserver;
    private m callBackFunction;
    private EditPanelsManager editPanelsManager;
    private c handler;
    private int toolbarHideAnimation;
    private int toolbarShowAnimation;
    protected BaseToolbarV2PanelViewModel<DocToolbarV2> toolbarViewModel;

    public class a implements BaseToolbarV2PanelViewModel.a {
        public final /* synthetic */ SDKToolbarV2PanelPlugin a;

        public final /* synthetic */ boolean a() {
            return false;
        }

        public final void b() {
            SDKToolbarV2PanelPlugin.access$200(this.a).requestUpdateWebContentHeight();
        }

        public a(SDKToolbarV2PanelPlugin r1) {
            this.a = r1;
        }

        public final void c(LifecycleOwner r2, Observer r3) {
            SDKToolbarV2PanelPlugin.access$200(this.a).getActiveEditPanel().observe(r2, r3);
        }

        public final <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
            SDKToolbarV2PanelPlugin.access$100(this.a).onToolbarItemClick(r2, r3, r4);
        }
    }

    public class b implements a0.a {
        public final /* synthetic */ SDKToolbarV2PanelPlugin a;

        public final boolean a() {
            if (TextUtils.equals(this.a.toolbarViewModel.getShowingItemId(), "insertImage") == false) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean b() {
            return this.a.toolbarViewModel.hasToolbarV2();
        }

        public final void c() {
            if (this.a.toolbarViewModel.hasToolbarV2() == false) goto L6;
            SDKToolbarV2PanelPlugin.access$200(this.a).forceCloseToolbarV2();
            return;
        }

        public final boolean d() {
            return this.a.toolbarViewModel.isLastShowingId("insertImage");
        }

        public final void e() {
            SDKToolbarV2PanelPlugin.access$200(this.a).requestUpdateWebContentHeight();
        }

        public final void hideAllToolbar() {
            this.a.toolbarViewModel.hideToolbar();
        }

        public b(SDKToolbarV2PanelPlugin r1) {
            this.a = r1;
        }
    }

    public class c implements c0<DocToolbarV2> {
        public final /* synthetic */ SDKToolbarV2PanelPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return ToolbarV2JsHandler.-CC.$default$authType(this);
        }

        public int getType() {
            return 0;
        }

        public final g45.a getEditPanel() {
            return this.a.toolbarViewModel;
        }

        public c(SDKToolbarV2PanelPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r3, m r4) {
            ToolbarV2 r5 = (DocToolbarV2) r3;
            tt5.a.b(SDKToolbarV2PanelPlugin.TAG, "Js update toolbar:" + r5);
            if (r5 == null) goto L5;
            r5.initFromJsBridge(ToolbarPrimaryItemId.values());
        L5:
            SDKToolbarV2PanelPlugin.access$302(this.a, r4);
            BaseToolbarV2PanelViewModel<DocToolbarV2> r6 = this.a.toolbarViewModel;
            if (r6 == null) goto L15;
            if (r5 != null) goto L9;
        L12:
            r5 = null;
        L13:
            r6.updateToolbar(r5);
            return;
        L9:
            if (r5.getItems() == null) goto L12;
            if (r5.getItems().length != 0) goto L13;
        }

        public final <V> void onToolbarItemClick(ItemIdV2 r3, V r4, int r5) {
            JSONObject r0 = new JSONObject();
            r0.put(ResourceData.KEY_ID, r3);
            r0.put("value", r4);
            r0.put("level", Integer.valueOf(r5));
            tt5.a.h(SDKToolbarV2PanelPlugin.TAG, r0.toString());
            if (SDKToolbarV2PanelPlugin.access$300(this.a) == null) goto L6;
            SDKToolbarV2PanelPlugin.access$300(this.a).b(r0);
            return;
        }
    }

    public static /* synthetic */ void a(SDKToolbarV2PanelPlugin r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SDKToolbarV2PanelPlugin() {
        this.activeObserver = new com.bytedance.ee.bear.middleground.docsdk.plugins.toolbar2.a(this);
        setToolbarAnimation(2130772208, 2130772209);
    }

    private void ensureToolbarFragment() {
        t r0 = getUIContainer();
        if (r0.l(this) != null) goto L13;
        Bundle r1 = new Bundle();
        Fragment r2 = instantiateFragment(SDKToolbarV2PanelFragment.class, r1);
        r2.setArguments(r1);
        int r3 = this.toolbarShowAnimation;
        if (r3 == 0) goto L7;
    L10:
        s r4 = s.a(r3, this.toolbarHideAnimation, 0, 0);
    L11:
        r0.e(this, r2, r4);
        return;
    L7:
        if (this.toolbarHideAnimation != 0) goto L10;
        r4 = null;
        goto L11
    }

    public static /* synthetic */ c access$100(SDKToolbarV2PanelPlugin r0) {
        return r0.handler;
    }

    public static /* synthetic */ EditPanelsManager access$200(SDKToolbarV2PanelPlugin r0) {
        return r0.editPanelsManager;
    }

    public static /* synthetic */ m access$300(SDKToolbarV2PanelPlugin r0) {
        return r0.callBackFunction;
    }

    private /* synthetic */ void lambda$new$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        tt5.a.h(TAG, "ensureToolbarFragment");
        ensureToolbarFragment();
        return;
    L5:
        tt5.a.h(TAG, "removeToolbarFragment");
        getUIContainer().d(this);
    }

    public void onAttachToHost(EditorSdkPluginHost r4) {
        super.onAttachToHost(r4);
        this.handler = new c(this);
        getHost().getWeb().h(JsBridgeConstants.BIZ_SET_DOC_TOOLBAR_V2, this.handler);
        this.toolbarViewModel = q.c(r4, ToolbarV2PanelViewModel.class, null);
        this.editPanelsManager = r4.a;
    }

    public void onDetachFromHost(EditorSdkPluginHost r1) {
        super.onDetachFromHost(r1);
        this.toolbarViewModel.onDetachFromHost();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((EditorSdkPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((EditorSdkPluginHost) r1);
    }

    public static /* synthetic */ m access$302(SDKToolbarV2PanelPlugin r0, m r1) {
        r0.callBackFunction = r1;
        return r1;
    }

    public void onAttachToUIContainer(EditorSdkPluginHost r4, t r5) {
        super.onAttachToUIContainer(r4, r5);
        this.toolbarViewModel.setDelegate(new a(this));
        pcb.a r6 = pcb.a.a.b(r4.getActivity());
        r6.c(this.toolbarViewModel);
        this.toolbarViewModel.onKeyboardHeightChanged(r6, r6.getVisibleKeyboardHeight(), getResources().getConfiguration().orientation);
        this.toolbarViewModel.getActive().observe(getLifecycleOwner(), this.activeObserver);
        this.editPanelsManager.registerEditPanel(getLifecycleOwner(), this.toolbarViewModel);
        this.toolbarViewModel.onAttachToUI(getActivity(), r4.getWeb().getBridge());
        a0 r7 = DocToolbarV2Compat.of(getActivity());
        r7.attach(r4, new b(this));
        this.editPanelsManager.setDocToolbarV2Compat(r7);
    }

    public void onDetachFromUIContainer(EditorSdkPluginHost r2, t r3) {
        super.onDetachFromUIContainer(r2, r3);
        pcb.a.a.b(r2.getActivity()).a(this.toolbarViewModel);
        this.toolbarViewModel.onDetachFromUI();
        DocToolbarV2Compat.of(getActivity()).detach(r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.d(TAG, "DocToolbarV2Compat detach: " + e.getMessage());
    }

    public void setToolbarAnimation(int r1, int r2) {
        this.toolbarShowAnimation = r1;
        this.toolbarHideAnimation = r2;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((EditorSdkPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((EditorSdkPluginHost) r1, r2);
    }
}
