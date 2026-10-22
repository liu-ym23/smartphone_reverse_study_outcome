package com.bytedance.ee.bear.document.edit_toolbar;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.api.toolbar.NavBarBottomInsetCompatEntity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarPrimaryItemId;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolBarV2Type;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.u;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import javax.annotation.Nullable;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeDocToolbarV2Plugin extends BaseToolbarV2Plugin<DocToolbarV2> implements c0<DocToolbarV2>, BaseDocToolbarV2Plugin<ChameleonPluginHost> {
    private m callBackFunction;
    private EditPanelsManager editPanelsManager;
    private final u toolbarCallback;
    public an4.a toolbarConfig;

    public class a implements u {
        public final /* synthetic */ OfficeDocToolbarV2Plugin a;

        public a(OfficeDocToolbarV2Plugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.u
        public final void a(ItemIdV2 r3, Object r4) {
            this.a.onToolbarItemClick(r3, r4, 3);
        }
    }

    public class b implements BaseToolbarV2PanelViewModel.a {
        public final /* synthetic */ OfficeDocToolbarV2Plugin a;

        @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel.a
        public final boolean a() {
            y3 r0 = this.a.getDocumentMetadata();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.getOpenSource() != DocsOpenSource.vc) goto L7;
            return true;
        }

        @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel.a
        public final void b() {
            OfficeDocToolbarV2Plugin.access$100(this.a).requestUpdateWebContentHeight();
        }

        public b(OfficeDocToolbarV2Plugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel.a
        public final void c(LifecycleOwner r2, Observer r3) {
            OfficeDocToolbarV2Plugin.access$100(this.a).getActiveEditPanel().observe(r2, r3);
        }

        @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel.a
        public final <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
            this.a.onToolbarItemClick(r2, r3, r4);
        }
    }

    public class c implements a0.a {
        public final /* synthetic */ OfficeDocToolbarV2Plugin a;

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final boolean a() {
            if (TextUtils.equals(this.a.toolbarViewModel.getShowingItemId(), "insertImage") == false) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final boolean b() {
            return this.a.toolbarViewModel.hasToolbarV2();
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final void c() {
            if (this.a.toolbarViewModel.hasToolbarV2() == false) goto L6;
            OfficeDocToolbarV2Plugin.access$100(this.a).forceCloseToolbarV2();
            return;
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final boolean d() {
            return this.a.toolbarViewModel.isLastShowingId("insertImage");
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final void e() {
            OfficeDocToolbarV2Plugin.access$100(this.a).requestUpdateWebContentHeight();
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0.a
        public final void hideAllToolbar() {
            this.a.toolbarViewModel.hideToolbar();
        }

        public c(OfficeDocToolbarV2Plugin r1) {
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

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
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

    public OfficeDocToolbarV2Plugin() {
        this.toolbarCallback = new a(this);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin
    public BaseToolbarV2PanelViewModel<DocToolbarV2> getToolbarViewModel() {
        return (BaseToolbarV2PanelViewModel) q.c(getHost(), ToolbarV2PanelViewModel.class, null);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public g45.a getEditPanel() {
        return this.toolbarViewModel;
    }

    public static /* synthetic */ EditPanelsManager access$100(OfficeDocToolbarV2Plugin r0) {
        return r0.editPanelsManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin
    public void onAttachToHost(ChameleonPluginHost r5) {
        super.onAttachToHost(r5);
        if (this.toolbarConfig != null) goto L5;
        this.toolbarConfig = (an4.a) r5.getUserComponent().a(an4.a.class);
    L5:
        NavBarBottomInsetCompatEntity r6 = com.bytedance.ee.bear.appsetting.c.a.a.c("doc_toolbar_android_compat", NavBarBottomInsetCompatEntity.class, new NavBarBottomInsetCompatEntity());
        gx4.c r0 = gx4.c.b.a;
        final FragmentActivity r1 = getActivity();
        r0.a = r6;
        if (r6 != null) goto L8;
    L16:
        EditPanelsManager r7 = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        this.editPanelsManager = r7;
        r7.registerEditPanel(getLifecycleOwner(), this.toolbarViewModel);
        BaseDocToolbarV2JsHandlerPlugin r8 = (BaseDocToolbarV2JsHandlerPlugin) findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r8 == null) goto L19;
        r8.registerHandler(this);
    L19:
        this.toolbarViewModel.setDelegate(new b(this));
        return;
    L8:
        if (r6.isEnable() == false) goto L16;
        if (r1 == null) goto L16;
        View r9 = r1.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L15;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L15;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L15:
        r9.post(new gx4.b(r1));
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin
    public void onDetachFromHost(ChameleonPluginHost r1) {
        super.onDetachFromHost(r1);
        BaseDocToolbarV2JsHandlerPlugin r2 = (BaseDocToolbarV2JsHandlerPlugin) findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r2 == null) goto L6;
        r2.unRegisterHandler(this);
        return;
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin, com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2Plugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin, com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2Plugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$000(OfficeDocToolbarV2Plugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public void handle(DocToolbarV2 r5, m r6) {
        tt5.a.b("ToolbarV2", "Js update toolbar:" + r5);
        if (r5 == null) goto L13;
        HashSet r0 = new HashSet(Arrays.asList(ToolbarPrimaryItemId.values()));
        an4.a r1 = this.toolbarConfig;
        if (r1 == null) goto L12;
        Iterator r2 = r1.getItemFactorySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        ItemIdV2 r3 = ((an4.e) r2.next()).getItemId();
        if ((r3 instanceof ToolbarPrimaryItemId) == false) goto L8;
        r0.add((ToolbarPrimaryItemId) r3);
    L12:
        r5.initFromJsBridge((ItemIdV2.a[]) r0.toArray(new ItemIdV2.a[0]));
    L13:
        this.callBackFunction = r6;
        if (r5 != null) goto L16;
    L21:
        DocToolbarV2 r7 = null;
    L22:
        updateToolbar(r7);
        ViewModel r8 = this.toolbarViewModel;
        if ((r8 instanceof ToolbarV2PanelViewModel) == false) goto L25;
        ((ToolbarV2PanelViewModel) r8).setCurrToolbarV2(r5);
    L25:
        an4.a r9 = this.toolbarConfig;
        if (r9 == null) goto L34;
        r9.getOnUpdateToolBarCallBack().invoke(r5);
        return;
    L34:
        return;
    L16:
        if (r5.getItems() == null) goto L21;
        if (r5.getItems().length == 0) goto L21;
        r7 = r5;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin
    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        super.onAttachToUIContainer(r2, r3);
        a0 r4 = ViewModelProviders.of(getActivity()).get(DocToolbarV2Compat.class);
        r4.attach(r2, new c(this));
        this.editPanelsManager.setDocToolbarV2Compat(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin
    public Fragment onCreateToolbarFragment(Context r2, String r3) {
        Bundle r4 = new Bundle();
        r4.putString("url", r3);
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L5;
        r4.putBoolean("isInForseti", true);
    L5:
        OfficeDocToolbarV2PanelFragment r5 = (OfficeDocToolbarV2PanelFragment) instantiateFragment(OfficeDocToolbarV2PanelFragment.class, r4);
        u r6 = this.toolbarCallback;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "callback");
        r5.E = new WeakReference(r6);
        r5.F = this.toolbarConfig;
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        DocToolbarV2Compat.of(getActivity()).detach(r1);
        this.editPanelsManager.setDocToolbarV2Compat(null);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0, tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((DocToolbarV2) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin, com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2Plugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.edit_toolbar.BaseToolbarV2Plugin, com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2Plugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public <V> void onToolbarItemClick(ItemIdV2 r2, V r3, int r4) {
        callBackFunction(this.callBackFunction, r2.name(), r3, r4);
    }
}
