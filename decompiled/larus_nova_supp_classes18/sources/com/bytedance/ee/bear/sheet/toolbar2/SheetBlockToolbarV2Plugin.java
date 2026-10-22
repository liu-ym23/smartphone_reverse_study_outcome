package com.bytedance.ee.bear.sheet.toolbar2;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolBarV2Type;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import javax.annotation.Nullable;
import nn5.l;
import s45.p;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockToolbarV2Plugin extends BaseToolbarV2Plugin<SheetBlockToolbarV2> implements c0<SheetBlockToolbarV2> {
    private static final String TAG = "SheetBlockToolbarV2Plugin";
    private m callBackFunction;
    private EditPanelsManager editPanelsManager;

    public class a implements BaseToolbarV2PanelViewModel.a {
        public final /* synthetic */ SheetBlockToolbarV2Plugin a;

        public final boolean a() {
            DocViewModel r0 = SheetBlockToolbarV2Plugin.access$100(this.a);
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.getOpenSource() != DocsOpenSource.vc) goto L7;
            return true;
        }

        public final void b() {
            SheetBlockToolbarV2Plugin.access$000(this.a).requestUpdateWebContentHeight();
        }

        public a(SheetBlockToolbarV2Plugin r1) {
            this.a = r1;
        }

        public final void c(LifecycleOwner r2, Observer r3) {
            SheetBlockToolbarV2Plugin.access$000(this.a).getActiveEditPanel().observe(r2, r3);
        }

        public final <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
            this.a.onToolbarItemClick(r2, r3, r4);
        }
    }

    public static /* synthetic */ int c(int r0) {
        return lambda$onAttachToUIContainer$0(r0);
    }

    private static /* synthetic */ int lambda$onAttachToUIContainer$0(int r0) {
        return r0;
    }

    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BaseToolbarV2PanelViewModel<SheetBlockToolbarV2> getToolbarViewModel() {
        return q.c(getHost(), SheetBlockToolbarV2PanelViewModel.class, null);
    }

    public int getType() {
        return ToolBarV2Type.Sheet.getValue();
    }

    private boolean isAtVc() {
        DocViewModel r0 = getDocViewModel();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getOpenSource() != DocsOpenSource.vc) goto L9;
        return true;
    L9:
        return false;
    }

    public SheetBlockToolbarV2Plugin() {
    }

    public g45.a getEditPanel() {
        return ((BaseToolbarV2Plugin) this).toolbarViewModel;
    }

    public static /* synthetic */ EditPanelsManager access$000(SheetBlockToolbarV2Plugin r0) {
        return r0.editPanelsManager;
    }

    public static /* synthetic */ DocViewModel access$100(SheetBlockToolbarV2Plugin r0) {
        return r0.getDocViewModel();
    }

    public int getBottomHeight(int r4) {
        if (isAtVc() == true) goto L6;
        tt5.a.h(TAG, "not at vc getBottomHeight 0");
        return 0;
    L6:
        int r5 = r4 * 2;
        tt5.a.h(TAG, "at vc getBottomHeight : " + r5);
        return r5;
    }

    public void onAttachToHost(PluginHost r2) {
        super.onAttachToHost(r2);
        BaseDocToolbarV2JsHandlerPlugin r3 = findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r3 == null) goto L5;
        r3.registerHandler(this);
    L5:
        ((BaseToolbarV2Plugin) this).toolbarViewModel.setDelegate(new a(this));
    }

    public void onDetachFromHost(PluginHost r1) {
        super.onDetachFromHost(r1);
        BaseDocToolbarV2JsHandlerPlugin r2 = findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r2 == null) goto L6;
        r2.unRegisterHandler(this);
        return;
    }

    public void handle(SheetBlockToolbarV2 r3, m r4) {
        tt5.a.b(TAG, "sheet Js update toolbar:" + r3);
        if (r3 == null) goto L7;
        r3.initFromJsBridge(SheetBlockPrimaryItemId.values());
        r3.setUrl(p.a().Z(getEditorAbility().getDocumentMetadata().getUrl()));
        r3.parseSegments();
        if (r3.getInput() == null) goto L7;
        ((SheetBlockToolbarV2PanelViewModel) getToolbarViewModel()).setSegment(r3.getInput().getSegments());
    L7:
        this.callBackFunction = r4;
        if (r3 != null) goto L10;
    L13:
        r3 = null;
    L14:
        updateToolbar(r3);
        return;
    L10:
        if (r3.getItems() == null) goto L13;
        if (r3.getItems().length != 0) goto L14;
        goto L13
    }

    public void onAttachToUIContainer(PluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        EditPanelsManager r4 = ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        this.editPanelsManager = r4;
        r4.registerEditPanel(getLifecycleOwner(), ((BaseToolbarV2Plugin) this).toolbarViewModel);
        SheetBlockToolbarV2PanelViewModel r5 = (SheetBlockToolbarV2PanelViewModel) getToolbarViewModel();
        FragmentActivity r6 = getActivity();
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isFinishing() == false) goto L7;
        return;
    L7:
        if (r6.isDestroyed() == true) goto L12;
        r5.setViewDelegate(new l(r5.getPanelHeight(r6)));
        return;
    }

    public Fragment onCreateToolbarFragment(Context r2, String r3) {
        Bundle r4 = new Bundle();
        r4.putString(ResourceData.KEY_URL, r3);
        return instantiateFragment(SheetBlockToolbarV2PanelFragment.class, r4);
    }

    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((SheetBlockToolbarV2) r1, r2);
    }

    public <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
        callBackFunction(this.callBackFunction, r2.name(), r3, r4);
    }
}
