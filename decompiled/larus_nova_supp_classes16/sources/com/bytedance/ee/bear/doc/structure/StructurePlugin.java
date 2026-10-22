package com.bytedance.ee.bear.doc.structure;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.bizwidget.CatalogHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.doc.structure.pad.container.PadCatalogController;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogMode;
import com.bytedance.ee.bear.doc.structure.pad.viewmodel.CatalogViewModel;
import com.bytedance.ee.bear.doc.toolbar2.DocToolbarV2Plugin;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mz4.a0;
import mz4.b0;
import mz4.c0;
import mz4.y;
import mz4.z;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class StructurePlugin extends DocumentPlugin implements IFloatingStructurePlugin<DocumentPluginHost> {
    public static final String ENABLE_FONT_SCALE = "enableFontScale";
    private static final String SET_ACTIVE_CATALOGUE_ITEM = "biz.catalog.setActiveCatalogueItem";
    private static final String SET_DOCUMENT_STRUCTURE = "biz.navigation.setDocumentStructure";
    private static final String TAG = "StructurePlugin";
    private PadCatalogController catalogController;
    private CatalogViewModel catalogViewModel;
    private final WebViewClient clientDelegate;
    private boolean closeCatalogBySelf;
    private IFloatingStructurePlugin.a floatingStructureDelegate;
    private boolean inHistoryMode;
    private boolean isFloatingStructureShowing;
    private StructureViewModel structureViewModel;

    public class a extends WebViewClient {
        public final /* synthetic */ StructurePlugin a;

        public a(StructurePlugin r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r2, String r3) {
            StructurePlugin r4 = this.a;
            if (r3 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            StructurePlugin.access$002(r4, r5);
            tt5.a.h(StructurePlugin.TAG, "Page finished inHistoryMode? " + StructurePlugin.access$000(this.a));
            if (StructurePlugin.access$000(this.a) == false) goto L12;
            StructurePlugin.access$100(this.a).setStructure(null);
            return;
        L12:
            return;
        L5:
            if (r3.endsWith("#history") == false) goto L7;
            r5 = true;
            goto L8
        }
    }

    public class b implements LifecycleEventObserver {
        public final /* synthetic */ StructurePlugin a;

        public b(StructurePlugin r1) {
            this.a = r1;
        }

        public final void onStateChanged(LifecycleOwner r4, Lifecycle.Event r5) {
            Lifecycle.Event r0 = Lifecycle.Event.ON_RESUME;
            if (r5 == r0) goto L5;
        L9:
            if (r5 != r0) goto L11;
        L12:
            r4.getLifecycle().removeObserver(this);
            return;
        L11:
            if (r5 == Lifecycle.Event.ON_DESTROY) goto L12;
            return;
        L5:
            if (StructurePlugin.access$400(this.a) == null) goto L9;
            if (Boolean.TRUE.equals(StructurePlugin.access$400(this.a).isModeChangedToPadLiveData().getValue()) == false) goto L9;
            StructurePlugin.access$500(this.a, Boolean.FALSE);
            goto L9
        }
    }

    public class c implements LifecycleEventObserver {
        public final /* synthetic */ StructurePlugin a;

        public c(StructurePlugin r1) {
            this.a = r1;
        }

        public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
            if (r3.equals(Lifecycle.Event.ON_DESTROY) == false) goto L9;
            StringBuilder r4 = new StringBuilder("catalog dialog destroyed, close by user is ");
            r4.append(!StructurePlugin.access$600(this.a));
            tt5.a.h(StructurePlugin.TAG, r4.toString());
            if (StructurePlugin.access$600(this.a) == true) goto L7;
            StructurePlugin.access$400(this.a).openOrCloseCatalogView(false);
        L7:
            StructurePlugin.access$602(this.a, false);
            r2.getLifecycle().removeObserver(this);
            return;
        }
    }

    public class d implements i<Structure.Paragraph> {
        public final /* synthetic */ StructurePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(StructurePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            Structure.Paragraph r4 = (Structure.Paragraph) r2;
            if (r4 == null) goto L7;
            tt5.a.h(StructurePlugin.TAG, StructurePlugin.SET_ACTIVE_CATALOGUE_ITEM);
            String r5 = r4.getHash();
            StructurePlugin.access$100(this.a).setActive(r5);
            StructurePlugin.access$400(this.a).setActiveCatalogItem(r5);
            return;
        }
    }

    public class e implements i<Structure> {
        public final /* synthetic */ StructurePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(StructurePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r6, m r7) {
            Structure r8 = (Structure) r6;
            if (StructurePlugin.access$000(this.a) == false) goto L6;
            tt5.a.k(StructurePlugin.TAG, "update structure while in history mode");
            return;
        L6:
            if (r8 != null) goto L8;
            int r1 = 0;
        L9:
            tt5.a.h(StructurePlugin.TAG, "Structure:" + r1);
            if (r8 == null) goto L12;
            r8.transformDip2Px();
            r8.trimAllTitle();
        L12:
            Structure r0 = new Structure();
            ArrayList r2 = new ArrayList();
            int r3 = 0;
        L13:
            Structure.Paragraph[] r4 = r8.paragraphs;
            if (r3 >= r4.length) goto L19;
            Structure.Paragraph r5 = r4[r3];
            if (r5.showParagraph == false) goto L18;
            r2.add(r5);
        L18:
            r3 = r3 + 1;
            goto L13
        L19:
            r0.paragraphs = (Structure.Paragraph[]) r2.toArray(new Structure.Paragraph[0]);
            StructurePlugin.access$100(this.a).setStructure(r0);
            return;
        L8:
            r1 = r8.getParagraphCount();
            goto L9
        }
    }

    public static /* synthetic */ void c(StructurePlugin r0, Boolean r1) {
        r0.lambda$setupPadCatalog$4(r1);
    }

    public static /* synthetic */ void d(StructurePlugin r0, Structure r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void e(StructurePlugin r0, Boolean r1) {
        r0.lambda$setupPadCatalog$3(r1);
    }

    public static /* synthetic */ void f(StructurePlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public static /* synthetic */ void g(StructurePlugin r0, Boolean r1) {
        r0.lambda$setupPadCatalog$2(r1);
    }

    @Override // com.bytedance.ee.bear.doc.structure.IFloatingStructurePlugin
    public IFloatingStructurePlugin.a getFloatingStructureDelegate() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public StructurePlugin() {
        this.clientDelegate = new a(this);
    }

    private void closeCatalogDialogFragment() {
        DialogFragment r0 = getFragmentManager().findFragmentByTag("FixedStructureFragment");
        if ((r0 instanceof DialogFragment) == false) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_structure_StructurePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        this.closeCatalogBySelf = true;
        return;
    }

    private void ensureStructureFragment() {
        t r0 = getUIContainer();
        if (r0.l(this) != null) goto L17;
        Bundle r1 = new Bundle();
        if ("doc".equals(getDocViewModel().getBearUrl().a) == false) goto L7;
    L12:
        boolean r2 = true;
    L13:
        r1.putBoolean(ENABLE_FONT_SCALE, r2);
        FloatingStructureFragment r3 = (FloatingStructureFragment) instantiateFragment(FloatingStructureFragment.class, r1);
        r0.i(this, r3);
        if (isEnablePadCatalog() == false) goto L18;
        r3.getLifecycle().addObserver(new b(this));
        return;
    L18:
        return;
    L7:
        if ("docx".equals(getDocViewModel().getBearUrl().a) == true) goto L9;
    L11:
        r2 = false;
        goto L13
    L9:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.doc.fontsize") == false) goto L11;
    }

    private boolean isEnablePadCatalog() {
        if (getDocViewModel().getOpenSource() != DocsOpenSource.base_instruction_docx) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        if (((Boolean) CatalogHelper.a.getValue()).booleanValue() == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    private void setupPadCatalog() {
        if (isEnablePadCatalog() == true) goto L5;
        return;
    L5:
        PadCatalogController r0 = new PadCatalogController(new WeakReference(getHost()));
        this.catalogController = r0;
        r0.g();
        CatalogViewModel r1 = (CatalogViewModel) viewModel(CatalogViewModel.class);
        this.catalogViewModel = r1;
        r1.isModeChangedToPadLiveData().observe(getLifecycleOwner(), new y(this));
        this.catalogViewModel.isCatalogOpenLiveData().observe(getLifecycleOwner(), new z(this));
        getDocViewModel().isShowingHistory().observe(getLifecycleOwner(), new a0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showDialogStructure() {
        if (isUIContainerDetached() == false) goto L6;
        tt5.a.k(TAG, "showFixedStructure while ui detached");
        return;
    L6:
        Bundle r0 = new Bundle();
        if ("doc".equals(getDocViewModel().getBearUrl().a) == false) goto L9;
    L14:
        boolean r1 = true;
    L15:
        r0.putBoolean(ENABLE_FONT_SCALE, r1);
        FixedStructureFragment r2 = instantiateFragment(FixedStructureFragment.class, r0);
        if (isEnablePadCatalog() == false) goto L18;
        r2.getLifecycle().addObserver(new c(this));
    L18:
        FragmentTransaction r3 = getFragmentManager().beginTransaction();
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).c()) == false) goto L28;
        ViewGroup r4 = getUIContainer().c(this);
        int r5 = r4.getId();
        if (r5 == (-1)) goto L23;
        if (r5 == 0) goto L23;
    L24:
        Bundle r6 = r2.getArguments();
        if (r6 != null) goto L27;
        r6 = new Bundle();
    L27:
        r2.setArguments(r6);
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_structure_StructurePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r3, r5, r2, r2.getClass().getSimpleName());
    L29:
        r3.commitAllowingStateLoss();
        this.structureViewModel.getStructureAnalytic().c(false);
        return;
    L23:
        r5 = View.generateViewId();
        r4.setId(r5);
        goto L24
    L28:
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_structure_StructurePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r3, r2, r2.getClass().getSimpleName());
        goto L29
    L9:
        if ("docx".equals(getDocViewModel().getBearUrl().a) == true) goto L11;
    L13:
        r1 = false;
        goto L15
    L11:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.doc.fontsize") == false) goto L13;
        goto L13
    }

    public void showFixedStructure() {
        if (isEnablePadCatalog() == false) goto L5;
        tt5.a.h(TAG, "openOrCloseCatalogView by more item");
        this.catalogViewModel.openOrCloseCatalogView();
        return;
    L5:
        showDialogStructure();
    }

    public StructureViewModel getStructureViewModel() {
        return this.structureViewModel;
    }

    @Override // com.bytedance.ee.bear.doc.structure.IFloatingStructurePlugin
    public boolean isFloatingStructureShowing() {
        return this.isFloatingStructureShowing;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_structure_StructurePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static /* synthetic */ boolean access$000(StructurePlugin r0) {
        return r0.inHistoryMode;
    }

    public static /* synthetic */ StructureViewModel access$100(StructurePlugin r0) {
        return r0.structureViewModel;
    }

    public static /* synthetic */ CatalogViewModel access$400(StructurePlugin r0) {
        return r0.catalogViewModel;
    }

    public static /* synthetic */ boolean access$600(StructurePlugin r0) {
        return r0.closeCatalogBySelf;
    }

    public static /* synthetic */ k access$700(StructurePlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ Context access$800(StructurePlugin r0) {
        return r0.getContext();
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Structure r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (n.C(getActivity()) == true) goto L6;
    L7:
        ensureStructureFragment();
        return;
    L6:
        if (ku5.c.k(getActivity()) == true) goto L7;
    }

    private /* synthetic */ void lambda$onAttachToHost$1(Boolean r2) {
        DocToolbarV2Plugin r0 = (DocToolbarV2Plugin) findPlugin(DocToolbarV2Plugin.class);
        if (r0 == null) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.booleanValue() == false) goto L8;
        r0.close();
        return;
    L8:
        r0.resetToolbar();
        return;
    }

    private /* synthetic */ void lambda$setupPadCatalog$2(Boolean r3) {
        showOrHideFloatingStructure(Boolean.valueOf(!r3.booleanValue()));
        if (this.catalogViewModel.isCatalogOpen() == true) goto L5;
        return;
    L5:
        tt5.a.h(TAG, "isModeChangedToPadLiveData isPad=" + r3);
        if (r3.booleanValue() == false) goto L8;
        closeCatalogDialogFragment();
        return;
    L8:
        showDialogStructure();
    }

    private /* synthetic */ void lambda$setupPadCatalog$3(Boolean r3) {
        if (this.catalogViewModel.getCatalogMode() == CatalogMode.DIALOG) goto L5;
        return;
    L5:
        tt5.a.h(TAG, "isCatalogOpenLiveData isOpen=" + r3);
        if (r3.booleanValue() == true) goto L8;
        closeCatalogDialogFragment();
        return;
    L8:
        showDialogStructure();
    }

    private /* synthetic */ void lambda$setupPadCatalog$4(Boolean r3) {
        tt5.a.h(TAG, "isShowingHistory: " + r3);
        this.catalogViewModel.closeCatalogOnInvalidPage();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showOrHideFloatingStructure(Boolean r4) {
        if (isEnablePadCatalog() == true) goto L5;
        return;
    L5:
        if (((DocumentPluginHost) getHost()).getUIContainer() == null) goto L21;
        tt5.a.h(TAG, "showOrHideFloatingStructure: show=" + r4);
        Fragment r0 = getUIContainer().l(this);
        if (r0 != null) goto L10;
    L17:
        tt5.a.k(TAG, "can not find floatingStructureFragment");
        return;
    L10:
        if (r0.isAdded() == false) goto L17;
        FragmentTransaction r1 = getFragmentManager().beginTransaction();
        if (r4.booleanValue() == false) goto L15;
        r1.show(r0).commitAllowingStateLoss();
        return;
    L15:
        r1.hide(r0).commitAllowingStateLoss();
        return;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(SET_DOCUMENT_STRUCTURE, new e(this));
        if (isEnablePadCatalog() == false) goto L6;
        r3.put(SET_ACTIVE_CATALOGUE_ITEM, new d(this));
        return;
    }

    public void notifyFloatingStructureVisibilityChanged(boolean r4) {
        if (this.isFloatingStructureShowing != r4) goto L6;
        tt5.a.h(TAG, "notifyFloatingStructureVisibilityChanged ignore, show=" + r4 + ", state unchanged");
        return;
    L6:
        this.isFloatingStructureShowing = r4;
        tt5.a.h(TAG, "notifyFloatingStructureVisibilityChanged, show=" + r4 + ", delegate is null");
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        setupPadCatalog();
        StructureViewModel r4 = (StructureViewModel) viewModel(StructureViewModel.class);
        this.structureViewModel = r4;
        r4.resetAnalytic(getDocViewModel(), (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
        this.structureViewModel.getContent().observe(getLifecycleOwner(), new b0(this));
        this.structureViewModel.floatingBottomPanelVisible().observe(getLifecycleOwner(), new c0(this));
        getWeb().addWebViewClientDelegate(this.clientDelegate);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        if (ku5.c.k(getContext()) == true) goto L10;
        if (r3.orientation != 2) goto L10;
        t r4 = getUIContainer();
        if (r4.l(this) == null) goto L13;
        r4.d(this);
        return;
    L13:
        return;
    L10:
        if (r3.orientation != 1) goto L15;
        ensureStructureFragment();
        return;
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        getWeb().removeWebViewClientDelegate(this.clientDelegate);
        PadCatalogController r3 = this.catalogController;
        if (r3 == null) goto L8;
        Function0<Unit> r4 = r3.h;
        if (r4 == null) goto L9;
        r4.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.doc.structure.IFloatingStructurePlugin
    public void setFloatingStructureDelegate(IFloatingStructurePlugin.a r3) {
        tt5.a.h(TAG, "setFloatingStructureDelegate, delegate=" + r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ boolean access$002(StructurePlugin r0, boolean r1) {
        r0.inHistoryMode = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(StructurePlugin r0, Boolean r1) {
        r0.showOrHideFloatingStructure(r1);
    }

    public static /* synthetic */ boolean access$602(StructurePlugin r0, boolean r1) {
        r0.closeCatalogBySelf = r1;
        return r1;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        this.structureViewModel.setWeb(getWeb());
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        this.structureViewModel.onDetach();
        removeFragment();
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

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_doc_structure_StructurePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_doc_structure_StructurePlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.add(r2, r3, r4);
    }
}
