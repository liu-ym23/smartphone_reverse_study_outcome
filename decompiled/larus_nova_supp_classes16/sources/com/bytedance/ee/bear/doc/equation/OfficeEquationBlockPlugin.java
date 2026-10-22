package com.bytedance.ee.bear.doc.equation;

import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.edit.component.toolbar2.ToolBarV2Type;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import javax.annotation.Nullable;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeEquationBlockPlugin extends DocumentPluginV3 implements c0<EquationToolbar> {
    private static final String TAG = "EquationBlockPlugin";

    public class a implements Runnable {
        public final /* synthetic */ OfficeEquationBlockPlugin a;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h(OfficeEquationBlockPlugin.TAG, "requestUpdateWebContentHeight....");     // Catch: Throwable -> L4
            ((EditPanelsManager) ViewModelProviders.of(this.a.getHost().getActivity()).get(EditPanelsManager.class)).requestUpdateWebContentHeight();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(OfficeEquationBlockPlugin r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0, tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public <V> void onToolbarItemClick(ItemIdV2 r1, V r2, int r3) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EquationViewModel getEquationViewModel() {
        return (EquationViewModel) viewModel(EquationViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public int getType() {
        return ToolBarV2Type.EQUATION.getValue();
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0
    public g45.a getEditPanel() {
        return getEquationViewModel();
    }

    public OfficeEquationBlockPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        EquationViewModel r0 = getEquationViewModel();
        ((EditPanelsManager) ViewModelProviders.of(r4.getActivity()).get(EditPanelsManager.class)).registerEditPanel(r4.getLifecycleOwner(), r0);
        pcb.a.a.b(r4.getActivity()).c(r0);
        BaseDocToolbarV2JsHandlerPlugin r5 = (BaseDocToolbarV2JsHandlerPlugin) findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r5 == null) goto L6;
        r5.registerHandler(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        pcb.a.a.b(r2.getActivity()).a(getEquationViewModel());
        BaseDocToolbarV2JsHandlerPlugin r3 = (BaseDocToolbarV2JsHandlerPlugin) findPlugin(BaseDocToolbarV2JsHandlerPlugin.class);
        if (r3 == null) goto L6;
        r3.unRegisterHandler(this);
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }

    public void handle(EquationToolbar r3, m r4) {
        tt5.a.h(TAG, "EquationBlockPlugin data " + r3);
        EquationViewModel r5 = getEquationViewModel();
        if (r3 == null) goto L5;
        boolean r6 = true;
    L6:
        r5.setActive(r6);
        if (getEquationViewModel().getActive().getValue() != Boolean.TRUE) goto L10;
        j.d(new a(this), 20);
        return;
    L10:
        return;
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.c0, tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((EquationToolbar) r1, r2);
    }
}
