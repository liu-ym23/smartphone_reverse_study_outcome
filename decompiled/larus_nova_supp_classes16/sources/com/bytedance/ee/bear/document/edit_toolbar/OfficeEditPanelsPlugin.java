package com.bytedance.ee.bear.document.edit_toolbar;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.List;
import tb5.i;
import tb5.m;
import tb5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeEditPanelsPlugin extends DocumentPluginV3 implements com.bytedance.ee.bear.browser.plugin.a {
    private static final String TAG = "EditPanelsPlugin";
    private EditPanelsManager panelsViewModel;

    public static class MyResultReceiver extends ResultReceiver {
        public final m a;

        public MyResultReceiver(m r2) {
            super(null);
            this.a = r2;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int r1, Bundle r2) {
            super.onReceiveResult(r1, r2);
            if (r1 != 2) goto L8;
            m r3 = this.a;
            if (r3 == null) goto L9;
            r3.b(new JSONObject());
            return;
        L9:
            return;
        }
    }

    public class a implements i<Void> {
        public final /* synthetic */ OfficeEditPanelsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(OfficeEditPanelsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            Void r5 = (Void) r3;
            tt5.a.b(OfficeEditPanelsPlugin.TAG, "js hide keyboard");
            View r6 = OfficeEditPanelsPlugin.access$400(this.a).getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r7 = ThreadMethodProxy.currentThread();
            if (r7 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r7, "getDecorView");
        L7:
            rcb.c.d(r6);
        }
    }

    public class b implements i<Void> {
        public final /* synthetic */ OfficeEditPanelsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeEditPanelsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            Void r4 = (Void) r2;
            tt5.a.h(OfficeEditPanelsPlugin.TAG, "js show keyboard");
            if (com.bytedance.ee.util.ui.b.a(OfficeEditPanelsPlugin.access$200(this.a)) == true) goto L5;
            tt5.a.h(OfficeEditPanelsPlugin.TAG, "js show keyboard: activity isActive: false");
            return;
        L5:
            rcb.c.h(OfficeEditPanelsPlugin.access$300(this.a).getContentView(), new MyResultReceiver(r3));
        }
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private e4 getEditorAbility() {
        return (e4) getHostAbility(e4.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.browser.plugin.a
    public List<com.bytedance.ee.bear.browser.plugin.i> getAbilities() {
        if (this.panelsViewModel != null) goto L6;
        this.panelsViewModel = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
    L6:
        return Collections.singletonList(this.panelsViewModel);
    }

    private n getBridge() {
        return getWeb().getBridge();
    }

    public OfficeEditPanelsPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FragmentActivity access$200(OfficeEditPanelsPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ e4 access$300(OfficeEditPanelsPlugin r0) {
        return r0.getEditorAbility();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FragmentActivity access$400(OfficeEditPanelsPlugin r0) {
        return r0.getActivity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        this.panelsViewModel = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setUserVisibleHint(boolean r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.setUserVisibleHint(r3);
        tt5.a.h(TAG, "isVisibleToUser = " + r3);
        if (r3 == false) goto L5;
        this.panelsViewModel.attachBridge(getBridge());
        return;
    L5:
        this.panelsViewModel.detachBridge(getBridge());
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        this.panelsViewModel.setContentView(getEditorAbility().getContentView());
        this.panelsViewModel.attachBridge(getBridge());
        pcb.a.a.b(r2.getActivity()).c(this.panelsViewModel);
        this.panelsViewModel.setKeyboardHeightProviderRef(pcb.a.a.b(r2.getActivity()));
        getBridge().c("biz.util.showKeyBoard", new b(this));
        getBridge().c("biz.util.hideKeyBoard", new a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        if (getBridge() != this.panelsViewModel.getBridge()) goto L5;
        pcb.a.a.b(r2.getActivity()).a(this.panelsViewModel);
    L5:
        this.panelsViewModel.detachBridge(getBridge());
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
