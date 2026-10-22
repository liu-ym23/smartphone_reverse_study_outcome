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

/* JADX INFO: loaded from: classes16.dex */
public abstract class BaseToolbarPlugin<T extends Toolbar> extends DocumentPlugin {
    private static final String TAG = "BaseToolbarPlugin";
    private Observer<Boolean> activeObserver;
    private int toolbarHideAnimation;
    private b<T> toolbarJSHandler;
    private int toolbarShowAnimation;
    protected BaseToolbarPanelViewModel<T> toolbarViewModel;

    public class a implements BaseToolbarPanelViewModel.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseToolbarPlugin f222304a;

        @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel.a
        public final boolean a() {
            DocViewModel r100 = BaseToolbarPlugin.access$100(this.f222304a);
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.getOpenSource() != DocsOpenSource.f216966vc) goto L7;
            return true;
        }

        public a(BaseToolbarPlugin r100) {
            this.f222304a = r100;
        }

        @Override // com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel.a
        public final void b(ItemId r100, String r101) {
            BaseToolbarPlugin.access$000(this.f222304a).b(r100, r101);
        }
    }

    public interface b<T> extends tb5.i<T> {
        @Override // tb5.i, tb5.o
        @Nullable
        /* bridge */ /* synthetic */ BridgeAuthType authType();

        void b(ItemId r100, String r101);

        @Override // tb5.i, tb5.o
        /* synthetic */ void handle(T r100, tb5.m r101);
    }

    public static /* synthetic */ void c(BaseToolbarPlugin r100, Boolean r101) {
        r100.lambda$new$0(r101);
    }

    public abstract String getToolbarJSBinderName();

    public abstract BaseToolbarPanelViewModel<T> getToolbarViewModel(FragmentActivity r100);

    public abstract Fragment onCreateToolbarFragment(Context r100, String r101);

    public abstract b<T> onCreateToolbarJSHandler();

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public BaseToolbarPlugin() {
        this.activeObserver = new k(this);
    }

    public static /* synthetic */ b access$000(BaseToolbarPlugin r100) {
        return r100.toolbarJSHandler;
    }

    public static /* synthetic */ DocViewModel access$100(BaseToolbarPlugin r100) {
        return r100.getDocViewModel();
    }

    private /* synthetic */ void lambda$new$0(Boolean r100) {
        if (Boolean.TRUE.equals(r100) == false) goto L5;
        ensureToolbarFragment(false);
        return;
    L5:
        tt5.a.h(TAG, "removeFragment");
        getUIContainer().d(this);
    }

    public void ensureToolbarFragment(boolean r100) {
        t r101 = getUIContainer();
        Fragment r102 = getUIContainer().l(this);
        tt5.a.h(TAG, "ensureToolbarFragment force:" + r100 + ",current:" + r102);
        if (r102 == null) goto L5;
        if (r100 == true) goto L5;
        return;
    L5:
        Fragment r103 = onCreateToolbarFragment(getContext(), getUrl());
        Bundle r104 = r103.getArguments();
        if (r104 != null) goto L9;
        r104 = new Bundle();
    L9:
        if (getDocViewModel() != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        r104.putBoolean("EnableExternalSelect", r105);
        r103.setArguments(r104);
        int r106 = this.toolbarShowAnimation;
        if (r106 == 0) goto L18;
    L21:
        s r107 = s.a(r106, this.toolbarHideAnimation, 0, 0);
    L22:
        r101.e(this, r103, r107);
        return;
    L18:
        if (this.toolbarHideAnimation != 0) goto L21;
        r107 = null;
        goto L22
    L11:
        if (getDocViewModel().getOpenSource() != DocsOpenSource.f216966vc) goto L14;
        r105 = false;
        goto L15
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        this.toolbarViewModel = getToolbarViewModel(getActivity());
    }

    public final void updateToolbar(T r100) {
        this.toolbarViewModel.updateToolbar(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    public void onAttachToUIContainer(DocumentPluginHost r100, t r101) {
        super.onAttachToUIContainer(r100, r101);
        this.toolbarJSHandler = onCreateToolbarJSHandler();
        bindBridgeHandlerAutoUnbind(getToolbarJSBinderName(), this.toolbarJSHandler);
        this.toolbarViewModel.setDelegate(new a(this));
        this.toolbarViewModel.getActive().observe(getLifecycleOwner(), this.activeObserver);
        r100.b().registerEditPanel(getLifecycleOwner(), this.toolbarViewModel);
        this.toolbarViewModel.onAttachToUI(r100, getWeb());
        pcb.a.AbstractC7181a.b(r100.getActivity()).c(this.toolbarViewModel);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        pcb.a.AbstractC7181a.b(r100.getActivity()).a(this.toolbarViewModel);
        this.toolbarViewModel.onDetachFromUI();
    }

    public void setToolbarAnimation(int r100, int r101) {
        this.toolbarShowAnimation = r100;
        this.toolbarHideAnimation = r101;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DocumentPluginHost) r100, r101);
    }
}
