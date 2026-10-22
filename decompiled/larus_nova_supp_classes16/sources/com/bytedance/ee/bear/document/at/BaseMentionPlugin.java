package com.bytedance.ee.bear.document.at;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.bear.edit.component.document.at.AtFinderHandler;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelFragment;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelViewModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseMentionPlugin extends DocumentPluginV2 {
    private static final String BIZ_COMMON_PARAMS = "bizCommonParams";
    private final AtFinderHandler atFinderHandler;
    protected AtPanelViewModel atViewModel;
    private EditPanelsManager editPanelsManager;
    private ViewTreeObserver.OnGlobalLayoutListener listener;
    private Observer<Boolean> mActiveObserver;
    private com.bytedance.ee.bear.contract.d mAnalyticService;

    public class a implements AtFinderHandler.b {
        public final /* synthetic */ BaseMentionPlugin a;

        @Override // com.bytedance.ee.bear.edit.component.document.at.AtFinderHandler.b
        public final void b() {
            BaseMentionPlugin.access$000(this.a).h("bizCommonParams");
        }

        public a(BaseMentionPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.edit.component.document.at.AtFinderHandler.b
        public final void a(String r3, String r4) {
            BaseMentionPlugin.access$000(this.a).j("bizCommonParams", r3, r4);
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ BaseMentionPlugin a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (com.bytedance.ee.util.ui.n.D(BaseMentionPlugin.access$100(this.a)) == false) goto L8;
            TitleBar r0 = BaseMentionPlugin.access$200(this.a);
            if (r0 == null) goto L9;
            BaseMentionPlugin.access$300(this.a, r0);
            return;
        L9:
            return;
        }

        public b(BaseMentionPlugin r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ void a(BaseMentionPlugin r0, Boolean r1) {
        r0.lambda$onAttachToUIContainer$0(r1);
    }

    public abstract com.bytedance.ee.bear.atfinder.e onCreateMentionDelegate();

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private com.bytedance.ee.bear.contract.d getAnalyticService() {
        if (this.mAnalyticService != null) goto L6;
        this.mAnalyticService = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
    L6:
        return this.mAnalyticService;
    }

    public BaseMentionPlugin() {
        AtFinderHandler r0 = new AtFinderHandler();
        this.atFinderHandler = r0;
        r0.b = new a(this);
        this.listener = new b(this);
    }

    private void ensureAtFragment() {
        com.bytedance.ee.bear.browser.plugin.t r0 = getUIContainer();
        if (r0.l(this) != null) goto L6;
        r0.i(this, instantiateFragment(AtPanelFragment.class, new Bundle()));
        return;
    }

    public static View INVOKEVIRTUAL_com_bytedance_ee_bear_document_at_BaseMentionPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static /* synthetic */ com.bytedance.ee.bear.contract.d access$000(BaseMentionPlugin r0) {
        return r0.getAnalyticService();
    }

    public static /* synthetic */ FragmentActivity access$100(BaseMentionPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ TitleBar access$200(BaseMentionPlugin r0) {
        return r0.getTitleBar();
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        ensureAtFragment();
        return;
    L5:
        com.bytedance.ee.bear.browser.plugin.f r3 = findPlugin(getClass());
        if (r3 == null) goto L10;
        getUIContainer().d(r3);
        return;
    }

    private void setTitleBarLocation(TitleBar r3) {
        if (r3.getTitleBarLayout() == null) goto L6;
        int[] r0 = new int[2];
        r3.getTitleBarLayout().getLocationInWindow(r0);
        this.atViewModel.setTitleBarLocation(r0[1]);
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put("biz.util.atfinder", this.atFinderHandler);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        AtPanelViewModel r4 = (AtPanelViewModel) viewModel(AtPanelViewModel.class);
        this.atViewModel = r4;
        AtFinderHandler r0 = this.atFinderHandler;
        r0.c = r4;
        r4.setDataCallback(r0.d);
        EditPanelsManager r5 = (EditPanelsManager) ViewModelProviders.of(getActivity()).get(EditPanelsManager.class);
        this.editPanelsManager = r5;
        r5.needSetPanelHeight(!"mindnote".equals(getDocumentMetadata().getDocumentType()));
        this.atViewModel.setEditPanelsManager(this.editPanelsManager);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        super.onDetachFromHost(r2);
        getAnalyticService().c("bizCommonParams");
    }

    public static /* synthetic */ void access$300(BaseMentionPlugin r0, TitleBar r1) {
        r0.setTitleBarLocation(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        super.onAttachToUIContainer(r3, r4);
        if (this.mActiveObserver != null) goto L5;
        this.mActiveObserver = new r(this);
        this.atViewModel.getActive().observe(getLifecycleOwner(), this.mActiveObserver);
    L5:
        this.editPanelsManager.registerEditPanel(getLifecycleOwner(), this.atViewModel);
        if (this.atViewModel.getMentionDelegate() != null) goto L8;
        this.atViewModel.setMentionDelegate(onCreateMentionDelegate());
    L8:
        pcb.a.a.b(r3.getActivity()).c(this.atViewModel);
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_at_BaseMentionPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r3.getActivity().getWindow()).getViewTreeObserver().removeOnGlobalLayoutListener(this.listener);
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_at_BaseMentionPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r3.getActivity().getWindow()).getViewTreeObserver().addOnGlobalLayoutListener(this.listener);
        TitleBar r5 = getTitleBar();
        if (r5 == null) goto L12;
        setTitleBarLocation(r5);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        pcb.a.a.b(r2.getActivity()).a(this.atViewModel);
        this.atViewModel.onDetachFromUI();
        this.atViewModel.setActive(false);
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_at_BaseMentionPlugin_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2.getActivity().getWindow()).getViewTreeObserver().removeOnGlobalLayoutListener(this.listener);
    }
}
