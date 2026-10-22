package com.bytedance.ee.bear.doc.toolbar2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin;
import com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2Plugin;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.toolbar.NavBarBottomInsetCompatEntity;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar.n;
import com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.DocToolbarV2Compat;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolBarV2Type;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import javax.annotation.Nullable;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbarV2Plugin extends BaseToolbarV2Plugin<DocToolbarV2> implements c0<DocToolbarV2>, BaseDocToolbarV2Plugin<PluginHost> {
    private m callBackFunction;
    private EditPanelsManager editPanelsManager;

    public class a implements BaseToolbarV2PanelViewModel.a {
        public final /* synthetic */ DocToolbarV2Plugin a;

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel.a
        public final boolean a() {
            DocViewModel r0 = DocToolbarV2Plugin.access$100(this.a);
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.getOpenSource() != DocsOpenSource.vc) goto L7;
            return true;
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel.a
        public final void b() {
            DocToolbarV2Plugin.access$000(this.a).requestUpdateWebContentHeight();
        }

        public a(DocToolbarV2Plugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel.a
        public final void c(LifecycleOwner r2, Observer r3) {
            DocToolbarV2Plugin.access$000(this.a).getActiveEditPanel().observe(r2, r3);
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel.a
        public final <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
            this.a.onToolbarItemClick(r2, r3, r4);
        }
    }

    public class b implements a0.a {
        public final /* synthetic */ DocToolbarV2Plugin a;

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final boolean a() {
            if (TextUtils.equals(DocToolbarV2Plugin.access$600(this.a).getShowingItemId(), "insertImage") == false) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final boolean b() {
            return DocToolbarV2Plugin.access$200(this.a).hasToolbarV2();
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final void c() {
            if (DocToolbarV2Plugin.access$400(this.a).hasToolbarV2() == false) goto L6;
            DocToolbarV2Plugin.access$000(this.a).forceCloseToolbarV2();
            return;
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final boolean d() {
            return DocToolbarV2Plugin.access$500(this.a).isLastShowingId("insertImage");
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final void e() {
            DocToolbarV2Plugin.access$000(this.a).requestUpdateWebContentHeight();
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final void hideAllToolbar() {
            DocToolbarV2Plugin.access$300(this.a).hideToolbar();
        }

        public b(DocToolbarV2Plugin r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2Plugin
    public void close() {
        updateToolbar(null);
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin, com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public int getType() {
        return ToolBarV2Type.Doc.getValue();
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2Plugin
    public void resetToolbar() {
        ViewModel r0 = this.toolbarViewModel;
        if ((r0 instanceof ToolbarV2PanelViewModel) == false) goto L6;
        ((ToolbarV2PanelViewModel) r0).resetToolbar();
        return;
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin
    public BaseToolbarV2PanelViewModel<DocToolbarV2> getToolbarViewModel() {
        return (BaseToolbarV2PanelViewModel) q.c(getHost(), ToolbarV2PanelViewModel.class, null);
    }

    public DocToolbarV2Plugin() {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public g45.a getEditPanel() {
        return this.toolbarViewModel;
    }

    public static /* synthetic */ EditPanelsManager access$000(DocToolbarV2Plugin r0) {
        return r0.editPanelsManager;
    }

    public static /* synthetic */ DocViewModel access$100(DocToolbarV2Plugin r0) {
        return r0.getDocViewModel();
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$200(DocToolbarV2Plugin r0) {
        return r0.toolbarViewModel;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$300(DocToolbarV2Plugin r0) {
        return r0.toolbarViewModel;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$400(DocToolbarV2Plugin r0) {
        return r0.toolbarViewModel;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$500(DocToolbarV2Plugin r0) {
        return r0.toolbarViewModel;
    }

    public static /* synthetic */ BaseToolbarV2PanelViewModel access$600(DocToolbarV2Plugin r0) {
        return r0.toolbarViewModel;
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r4) {
        super.onAttachToHost(r4);
        NavBarBottomInsetCompatEntity r5 = (NavBarBottomInsetCompatEntity) c.a.a.c("doc_toolbar_android_compat", NavBarBottomInsetCompatEntity.class, new NavBarBottomInsetCompatEntity());
        n.b.a.c(getActivity(), r5);
        EditPanelsManager r6 = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        this.editPanelsManager = r6;
        r6.registerEditPanel(getLifecycleOwner(), this.toolbarViewModel);
        BaseDocToolbarV2JsHandlerPlugin r7 = (BaseDocToolbarV2JsHandlerPlugin) findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r7 == null) goto L5;
        r7.registerHandler(this);
    L5:
        this.toolbarViewModel.setDelegate(new a(this));
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        BaseDocToolbarV2JsHandlerPlugin r2 = (BaseDocToolbarV2JsHandlerPlugin) findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r2 == null) goto L6;
        r2.unRegisterHandler(this);
        return;
    }

    public void handle(DocToolbarV2 r3, m r4) {
        tt5.a.b("ToolbarV2", "Js update toolbar:" + r3);
        if (r3 == null) goto L5;
        r3.initFromJsBridge(ToolbarPrimaryItemId.values());
    L5:
        this.callBackFunction = r4;
        if (r3 != null) goto L8;
    L13:
        DocToolbarV2 r5 = null;
    L14:
        updateToolbar(r5);
        ViewModel r6 = this.toolbarViewModel;
        if ((r6 instanceof ToolbarV2PanelViewModel) == false) goto L18;
        ((ToolbarV2PanelViewModel) r6).setCurrToolbarV2(r3);
        return;
    L18:
        return;
    L8:
        if (r3.getItems() == null) goto L13;
        if (r3.getItems().length == 0) goto L13;
        r5 = r3;
        goto L14
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        a0 r4 = ViewModelProviders.of(getActivity()).get(DocToolbarV2Compat.class);
        r4.attach(r2, new b(this));
        this.editPanelsManager.setDocToolbarV2Compat(r4);
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin
    public Fragment onCreateToolbarFragment(Context r2, String r3) {
        Bundle r4 = new Bundle();
        r4.putString("url", r3);
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L6;
        r4.putBoolean("isInForseti", true);
    L6:
        return instantiateFragment(DocToolbarV2PanelFragment.class, r4);
    }

    @Override // com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        DocToolbarV2Compat.of(getActivity()).detach(r1);
        this.editPanelsManager.setDocToolbarV2Compat(null);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0, tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((DocToolbarV2) r1, r2);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
        callBackFunction(this.callBackFunction, r2.name(), r3, r4);
    }
}
