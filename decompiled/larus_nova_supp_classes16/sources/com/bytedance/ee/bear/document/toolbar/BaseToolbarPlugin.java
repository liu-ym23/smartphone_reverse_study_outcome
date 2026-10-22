package com.bytedance.ee.bear.document.toolbar;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.toolbar.Toolbar;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseToolbarPlugin<T extends Toolbar> extends DocumentPlugin {
    private static final String TAG = "BaseToolbarPlugin";
    private Observer<Boolean> activeObserver;
    private int toolbarHideAnimation;
    private b<T> toolbarJSHandler;
    private int toolbarShowAnimation;
    protected BaseToolbarPanelViewModel<T> toolbarViewModel;

    public class a implements BaseToolbarPanelViewModel.a {
        public final /* synthetic */ BaseToolbarPlugin a;

        @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel.a
        public final boolean a() {
            DocViewModel r0 = BaseToolbarPlugin.access$100(this.a);
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.getOpenSource() != DocsOpenSource.vc) goto L7;
            return true;
        }

        public a(BaseToolbarPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel.a
        public final void b(ItemId r2, String r3) {
            BaseToolbarPlugin.access$000(this.a).b(r2, r3);
        }
    }

    public interface b<T> extends tb5.i<T> {
        @Override // tb5.i, tb5.o
        @Nullable
        /* bridge */ /* synthetic */ BridgeAuthType authType();

        void b(ItemId r1, String r2);

        @Override // tb5.i, tb5.o
        /* synthetic */ void handle(T r1, tb5.m r2);
    }

    public static /* synthetic */ void c(BaseToolbarPlugin r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    public abstract String getToolbarJSBinderName();

    public abstract BaseToolbarPanelViewModel<T> getToolbarViewModel(FragmentActivity r1);

    public abstract Fragment onCreateToolbarFragment(Context r1, String r2);

    public abstract b<T> onCreateToolbarJSHandler();

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BaseToolbarPlugin() {
        this.activeObserver = new k(this);
    }

    public static /* synthetic */ b access$000(BaseToolbarPlugin r0) {
        return r0.toolbarJSHandler;
    }

    public static /* synthetic */ DocViewModel access$100(BaseToolbarPlugin r0) {
        return r0.getDocViewModel();
    }

    private /* synthetic */ void lambda$new$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        ensureToolbarFragment(false);
        return;
    L5:
        tt5.a.h(TAG, "removeFragment");
        getUIContainer().d(this);
    }

    public void ensureToolbarFragment(boolean r6) {
        t r0 = getUIContainer();
        Fragment r1 = getUIContainer().l(this);
        tt5.a.h(TAG, "ensureToolbarFragment force:" + r6 + ",current:" + r1);
        if (r1 == null) goto L5;
        if (r6 == true) goto L5;
        return;
    L5:
        Fragment r7 = onCreateToolbarFragment(getContext(), getUrl());
        Bundle r2 = r7.getArguments();
        if (r2 != null) goto L9;
        r2 = new Bundle();
    L9:
        if (getDocViewModel() != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        r2.putBoolean("EnableExternalSelect", r3);
        r7.setArguments(r2);
        int r4 = this.toolbarShowAnimation;
        if (r4 == 0) goto L18;
    L21:
        s r5 = s.a(r4, this.toolbarHideAnimation, 0, 0);
    L22:
        r0.e(this, r7, r5);
        return;
    L18:
        if (this.toolbarHideAnimation != 0) goto L21;
        r5 = null;
        goto L22
    L11:
        if (getDocViewModel().getOpenSource() != DocsOpenSource.vc) goto L14;
        r3 = false;
        goto L15
    }

    public void onAttachToHost(DocumentPluginHost r1) {
        super.onAttachToHost(r1);
        this.toolbarViewModel = getToolbarViewModel(getActivity());
    }

    public final void updateToolbar(T r2) {
        this.toolbarViewModel.updateToolbar(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        this.toolbarJSHandler = onCreateToolbarJSHandler();
        bindBridgeHandlerAutoUnbind(getToolbarJSBinderName(), this.toolbarJSHandler);
        this.toolbarViewModel.setDelegate(new a(this));
        this.toolbarViewModel.getActive().observe(getLifecycleOwner(), this.activeObserver);
        r3.b().registerEditPanel(getLifecycleOwner(), this.toolbarViewModel);
        this.toolbarViewModel.onAttachToUI(r3, getWeb());
        pcb.a.a.b(r3.getActivity()).c(this.toolbarViewModel);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        pcb.a.a.b(r1.getActivity()).a(this.toolbarViewModel);
        this.toolbarViewModel.onDetachFromUI();
    }

    public void setToolbarAnimation(int r1, int r2) {
        this.toolbarShowAnimation = r1;
        this.toolbarHideAnimation = r2;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
