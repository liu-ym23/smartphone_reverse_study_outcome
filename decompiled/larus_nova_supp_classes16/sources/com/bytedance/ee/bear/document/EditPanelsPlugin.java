package com.bytedance.ee.bear.document;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditPanelsPlugin extends DocumentPluginV2 implements com.bytedance.ee.bear.browser.plugin.a {
    private static final String TAG = "EditPanelsPlugin";
    private EditPanelsManager panelsViewModel;

    public static class MyResultReceiver extends ResultReceiver {
        public final tb5.m a;

        public MyResultReceiver(tb5.m r2) {
            super(null);
            this.a = r2;
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int r1, Bundle r2) {
            super.onReceiveResult(r1, r2);
            if (r1 != 2) goto L8;
            tb5.m r3 = this.a;
            if (r3 == null) goto L9;
            r3.b(new JSONObject());
            return;
        L9:
            return;
        }
    }

    public class a implements tb5.i<Void> {
        public final /* synthetic */ EditPanelsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(EditPanelsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            Void r5 = (Void) r3;
            tt5.a.b(EditPanelsPlugin.TAG, "js hide keyboard");
            View r6 = EditPanelsPlugin.access$300(this.a).getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L7;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r7 = ThreadMethodProxy.currentThread();
            if (r7 == com.larus.home.impl.utils.c.a) goto L7;
            com.larus.home.impl.utils.c.a(r7, "getDecorView");
        L7:
            rcb.c.d(r6);
        }
    }

    public class b implements tb5.i<Void> {
        public final /* synthetic */ EditPanelsPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(EditPanelsPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            Void r4 = (Void) r2;
            tt5.a.h(EditPanelsPlugin.TAG, "js show keyboard");
            if (com.bytedance.ee.util.ui.b.a(EditPanelsPlugin.access$200(this.a)) == true) goto L5;
            tt5.a.h(EditPanelsPlugin.TAG, "js show keyboard: activity isActive: false");
            return;
        L5:
            rcb.c.h(this.a.getEditorAbility().getContentView(), new MyResultReceiver(r3));
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.a
    public List<com.bytedance.ee.bear.browser.plugin.i> getAbilities() {
        if (this.panelsViewModel != null) goto L6;
        this.panelsViewModel = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
    L6:
        return Collections.singletonList(this.panelsViewModel);
    }

    public EditPanelsPlugin() {
    }

    public static /* synthetic */ FragmentActivity access$200(EditPanelsPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ FragmentActivity access$300(EditPanelsPlugin r0) {
        return r0.getActivity();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r2) {
        super.onAttachToHost(r2);
        this.panelsViewModel = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        tt5.a.h(TAG, "isVisibleToUser = " + r3);
        if (r3 == false) goto L5;
        this.panelsViewModel.attachBridge(getBridge());
        return;
    L5:
        this.panelsViewModel.detachBridge(getBridge());
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        this.panelsViewModel.setContentView(getEditorAbility().getContentView());
        this.panelsViewModel.attachBridge(getBridge());
        pcb.a.a.b(r2.getActivity()).c(this.panelsViewModel);
        getBridge().c("biz.util.showKeyBoard", new b(this));
        getBridge().c("biz.util.hideKeyBoard", new a(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        if (getBridge() != this.panelsViewModel.getBridge()) goto L5;
        pcb.a.a.b(r2.getActivity()).a(this.panelsViewModel);
    L5:
        this.panelsViewModel.detachBridge(getBridge());
    }
}
