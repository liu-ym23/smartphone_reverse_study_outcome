package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import io.reactivex.Flowable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class WikiTreeMenuPlugin extends BasePluginV2 implements sa5.a {
    public static final String MENU_ID_WIKI_TREE_ACTION = "wiki_tree_action";
    private static final String TAG = "WikiTreeMenuPlugin";
    private final MutableLiveData<Boolean> cached;
    private final MutableLiveData<Boolean> docComponentLiveData;
    private final MutableLiveData<Boolean> enable;
    private PluginHost host;
    private final com.bytedance.ee.bear.contract.q0 listRenameHandler;
    private final MutableLiveData<Integer> loadState;
    private LiveData<ConnectionService.NetworkState> networkState;
    private Runnable onBoardingTask;
    private final MutableLiveData<Boolean> showingHistory;
    private View treeItemView;
    private MutableLiveData<String> wikiTokenLiveData;
    private fq5.g wikiTreeMenuOnBoarding;
    private WikiTreePanelDialog wikiTreePanel;

    public class a extends com.bytedance.ee.bear.contract.q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiTreeMenuPlugin f240516a;

        public a(WikiTreeMenuPlugin r100) {
            this.f240516a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
        public final void b(String r100, String r101) {
            WikiViewModel r102 = g1.a(this.f240516a.getHost());
            if (r102.isShortcut() == false) goto L5;
            return;
        L5:
            if (TextUtils.equals(r100, r102.getObjToken()) == false) goto L9;
            tt5.a.h(WikiTreeMenuPlugin.TAG, "List rename found");
            WikiTreeMenuPlugin.access$000(this.f240516a, r102, r101);
            return;
        }
    }

    public static /* synthetic */ void a(WikiTreeMenuPlugin r100, Integer r101) {
        r100.lambda$observerTreeMenuEnable$4(r101);
    }

    public static /* synthetic */ void c(WikiTreeMenuPlugin r100, Boolean r101) {
        r100.lambda$observerTreeMenuEnable$3(r101);
    }

    public static /* synthetic */ void d(WikiTreeMenuPlugin r100, MenuItem r101, View r102) {
        r100.lambda$setupTreeMenu$8(r101, r102);
    }

    public static /* synthetic */ void e(WikiTreeMenuPlugin r100, String r101) {
        r100.lambda$observerTreeMenuEnable$7(r101);
    }

    public static /* synthetic */ void f(WikiTreeMenuPlugin r100, Boolean r101) {
        r100.lambda$observerTreeMenuEnable$5(r101);
    }

    public static /* synthetic */ Boolean g(String r100, String r101) {
        return lambda$init$0(r100, r101);
    }

    public static /* synthetic */ void h(Throwable r100) {
        lambda$init$1(r100);
    }

    public static /* synthetic */ void i(WikiTreeMenuPlugin r100, ConnectionService.NetworkState r101) {
        r100.lambda$observerTreeMenuEnable$2(r101);
    }

    public static /* synthetic */ void j(WikiTreeMenuPlugin r100, Boolean r101) {
        r100.lambda$observerTreeMenuEnable$6(r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private void init() {
        this.networkState = com.bytedance.ee.bear.contract.j.a.f217090a.a();
        this.showingHistory.setValue(Boolean.FALSE);
        this.loadState.setValue(-1);
        this.enable.setValue(Boolean.TRUE);
        this.wikiTokenLiveData = g1.a(getHost()).getWikiTokenLiveData();
        WikiViewModel r100 = g1.a(getHost());
        final String r101 = r100.getSpaceId();
        final String r102 = r100.getWikiToken();
        Flowable r103 = Flowable.fromCallable(new d1(r101, r102)).subscribeOn(fo5.d.c()).observeOn(fo5.d.d());
        final MutableLiveData<Boolean> r104 = this.cached;
        Objects.requireNonNull(r104);
        r103.subscribe(new e1(r104), new f1());
    }

    private void observerTreeMenuEnable() {
        this.networkState.observe(getLifecycleOwner(), new x0(this));
        this.showingHistory.observe(getLifecycleOwner(), new y0(this));
        this.loadState.observe(getLifecycleOwner(), new z0(this));
        this.enable.observe(getLifecycleOwner(), new a1(this));
        this.cached.observe(getLifecycleOwner(), new b1(this));
        this.wikiTokenLiveData.observe(getLifecycleOwner(), new c1(this));
    }

    private View setupTreeMenu() {
        MenuItem r100 = new MenuItem();
        r100.setClickListener(new w0(this));
        r100.setEnable(com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a());
        r100.setId(MENU_ID_WIKI_TREE_ACTION);
        r100.setIcon(com.bytedance.ee.util.ui.l.a(getContext(), R.drawable.ud_icon_treelist_outlined, R.color.facade_selector_icon_n1));
        if (getTitleBar() == null) goto L6;
        getTitleBar().j(Collections.singletonList(r100), TitleBar.MenuType.Left);
    L6:
        return getTitleBar().findMenuView(MENU_ID_WIKI_TREE_ACTION);
    }

    private void updateTreeMenu() {
        if (this.treeItemView != null) goto L5;
        return;
    L5:
        Boolean r100 = Boolean.TRUE;
        boolean r101 = r100.equals(this.showingHistory.getValue());
        boolean r102 = false;
        if (this.loadState.getValue() != null) goto L8;
    L12:
        boolean r103 = false;
    L14:
        if (this.networkState.getValue() != null) goto L16;
    L18:
        boolean r104 = false;
    L20:
        if (this.wikiTokenLiveData.getValue() != null) goto L22;
    L24:
        boolean r105 = false;
    L26:
        if (this.loadState.getValue() != null) goto L28;
    L32:
        boolean r106 = false;
    L33:
        boolean r107 = r100.equals(this.enable.getValue());
        boolean r108 = r100.equals(this.cached.getValue());
        boolean r109 = r100.equals(this.docComponentLiveData.getValue());
        tt5.a.h(TAG, String.format("updateEnableTreeMenu (history:%b, fatalErr:%b, network:%b, loadState:%b, enable:%b, fakeTokenChecker:%b)", new Object[]{Boolean.valueOf(r101), Boolean.valueOf(r103), Boolean.valueOf(r104), Boolean.valueOf(r106), Boolean.valueOf(r107), Boolean.valueOf(r105)}));
        if (r101 == true) goto L40;
        if (r103 == true) goto L40;
        if (r109 == true) goto L40;
        if (AppInfoUtils.e().booleanValue() == true) goto L40;
        boolean r110 = true;
    L41:
        if (r106 == false) goto L47;
        if (r107 == false) goto L47;
        if (r104 == true) goto L45;
        if (r108 == false) goto L47;
    L45:
        if (r105 == true) goto L47;
        boolean r111 = true;
    L48:
        if (r110 == false) goto L54;
        this.treeItemView.setVisibility(0);
        this.treeItemView.setEnabled(r111);
        View r112 = this.treeItemView;
        if (r111 == false) goto L52;
        float r113 = 1.0f;
    L53:
        r112.setAlpha(r113);
    L55:
        if (r110 == false) goto L74;
        if (r111 == true) goto L58;
        return;
    L58:
        if (((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f("mobile_wiki_newbie_pageTree") == false) goto L60;
        return;
    L60:
        if (g1.a(getHost()).getWikiInfo().getValue().getObjType() != sbb.e.f541298i.f541317b) goto L62;
        r102 = true;
    L62:
        if (r102 == false) goto L64;
        return;
    L64:
        fq5.g r114 = this.wikiTreeMenuOnBoarding;
        com.bytedance.ee.bear.browser.plugin.t r115 = getUIContainer();
        FragmentActivity r116 = getActivity();
        r114.getClass();
        tt5.a.h("WikiTreeMenuOnBoarding", "start onBoarding Mission");
        if (r114.f478427b == false) goto L67;
        tt5.a.h("WikiTreeMenuOnBoarding", "has show onBoarding in this page" + r114);
    L70:
        fq5.d r117 = null;
    L72:
        this.onBoardingTask = r117;
        return;
    L67:
        r114.f478427b = true;
        if (((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f("mobile_wiki_newbie_pageTree") == false) goto L71;
        tt5.a.h("WikiTreeMenuOnBoarding", "wiki tree onboarding has already shown, return");
        goto L70
    L71:
        fq5.d r118 = new fq5.d(r114, r116, r115);
        com.bytedance.ee.util.ui.j.d(r118, 500);
        r117 = r118;
        goto L72
    L74:
        return;
    L52:
        r113 = 0.3f;
        goto L53
    L54:
        this.treeItemView.setVisibility(8);
    L47:
        r111 = false;
    L40:
        r110 = false;
        goto L41
    L28:
        if (this.loadState.getValue().intValue() != (-1)) goto L30;
    L31:
        r106 = true;
        goto L33
    L30:
        if (this.loadState.getValue().intValue() != 0) goto L32;
    L22:
        if (bx4.b.b(this.wikiTokenLiveData.getValue()) == false) goto L24;
        r105 = true;
        goto L26
    L16:
        if (this.networkState.getValue().a() == false) goto L18;
        r104 = true;
        goto L20
    L8:
        if (tp5.b.c(this.loadState.getValue().intValue()) == false) goto L10;
    L11:
        r103 = true;
        goto L14
    L10:
        if (this.loadState.getValue().intValue() != (-55)) goto L12;
        goto L11
    }

    public int getLoadState() {
        if (this.loadState.getValue() != null) goto L6;
        return -1;
    L6:
        return this.loadState.getValue().intValue();
    }

    public void showWikiTree() {
        tt5.a.h(TAG, "showWikiTree. ");
        WikiViewModel r100 = g1.a(getHost());
        TreeNode r101 = r100.getWikiMeta();
        int r102 = gq5.d.f482186a;
        com.bytedance.ee.bear.contract.d r103 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap r104 = new HashMap();
        r104.putAll(r103.m("docCommonParams"));
        r104.put("click", "wiki_tree");
        r104.put(PickerReporterConstants.KEY.TARGET, "ccm_wiki_tree_view");
        int r105 = gq5.d.f482186a;
        if (r101 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == false) goto L10;
        String r107 = "space";
    L11:
        r104.put("original_docs_container", r107);
        if (r101 != null) goto L14;
    L16:
        boolean r108 = false;
    L17:
        if (r108 == false) goto L19;
        String r109 = "true";
    L20:
        r104.put("is_shortcut", r109);
        r103.n("ccm_space_docs_topbar_click", r104);
        tt5.a.b("WikiReportV2", "reportTopBarClickWikiTreeEvent, params = " + r104);
        String r110 = r100.getSpaceId();
        if (TextUtils.isEmpty(r110) == false) goto L24;
        tt5.a.h(TAG, "showWikiTree, empty spaceId. return. ");
        return;
    L24:
        tt5.a.h(TAG, "showWikiTree, needOnBoarding= false");
        ar5.a r111 = r100.consumePathResolveContext();
        if (r111 == null) goto L27;
    L29:
        boolean r112 = false;
    L30:
        if (r112 == false) goto L32;
        r111 = r100.retryPathResolveContext();
    L32:
        FragmentActivity r113 = getActivity();
        String r114 = r100.getSpaceName();
        String r115 = r100.getWikiToken();
        String r116 = r100.getUniqueUiId();
        FragmentActivity r117 = getActivity();
        int r118 = lw4.a.f511011g;
        uq5.f r119 = new uq5.f(r113, r114, r110, r115, r116, com.bytedance.ee.util.ui.a.a(r117), r111, r112);
        PluginHost r120 = this.host;
        int r121 = WikiTreePanelDialog.f241630w;
        Intrinsics.checkNotNullParameter(r119, "params");
        Intrinsics.checkNotNullParameter(r120, "pluginHost");
        if (ForsetiHelper.s(r120.getHostFragment()) == false) goto L35;
        WikiTreePanelDialog._ViewModel r122 = (WikiTreePanelDialog._ViewModel) new ViewModelProvider(r120).get(WikiTreePanelDialog._ViewModel.class);
    L36:
        String r123 = r119.f551308b;
        String r124 = "";
        if (r123 != null) goto L39;
        r123 = "";
    L39:
        r122.setTitle(r123);
        r122.setSpaceId(r119.f551309c);
        String r125 = r119.f551310d;
        if (r125 != null) goto L42;
        r125 = "";
    L42:
        r122.setWikiToken(r125);
        r122.setNeedOnBoarding(false);
        String r126 = r119.f551311e;
        if (r126 == null) goto L46;
        r124 = r126;
    L46:
        r122.setUniqueUiId(r124);
        r122.setNeedExpandWindow(r119.f551313g);
        r122.setPathResolveContext(r119.f551314h);
        r122.setReusePathResolveTree(r119.f551315i);
        boolean r127 = ForsetiHelper.s(r120.getHostFragment());
        Fragment r128 = Fragment.instantiate(r119.getContext(), WikiTreePanelDialog.class.getName());
        Intrinsics.checkNotNull(r128, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog");
        WikiTreePanelDialog r129 = (WikiTreePanelDialog) r128;
        Bundle r130 = new Bundle();
        PluginHost.writePluginHostToBundle(r130, r120);
        r129.setArguments(r130);
        if (r127 == true) goto L61;
    L50:
        FragmentManager r131 = r119.getContext().getSupportFragmentManager();     // Catch: Exception -> L56
        String r132 = WikiTreePanelDialog.class.getName();     // Catch: Exception -> L56
        LandscapeRestrictionOperation r133 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L56
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r129, r132, r133);     // Catch: Exception -> L56
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r131, r129, r133) == false) goto L63;
    L58:
        this.wikiTreePanel = r129;
        return;
    L63:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L60
    L54:
        r129.show(r131, r132);     // Catch: Exception -> L56
    L56:
        e = move-exception;
        tt5.a.d("Wiki_WikiTreePanelDialog", "show panel dialog error " + e.getMessage());
        goto L58
    L61:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r129, r120.getHostFragment(), ForsetiNavOptions.DestinationStyle.FLOAT, false, 0, false, 60) == true) goto L58;
    L35:
        r122 = (WikiTreePanelDialog._ViewModel) new ViewModelProvider(r119.getContext()).get(WikiTreePanelDialog._ViewModel.class);
        goto L36
    L27:
        if (r100.isPathResolveContextConsumed() == false) goto L29;
        r112 = true;
        goto L30
    L19:
        r109 = "false";
        goto L20
    L14:
        if (r101.isShortcut() != true) goto L16;
        r108 = true;
        goto L17
    L10:
        r107 = "wiki";
        goto L11
    L5:
        if (r101.origin_is_external != true) goto L7;
        r106 = true;
        goto L8
    }

    public WikiTreeMenuPlugin() {
        this.showingHistory = new MutableLiveData();
        this.cached = new MutableLiveData();
        this.enable = new MutableLiveData();
        this.loadState = new MutableLiveData();
        this.docComponentLiveData = new MutableLiveData();
        this.listRenameHandler = new a(this);
    }

    private static void lambda$init$1(Throwable r100) throws Exception {
        tt5.a.e(TAG, "checkRelationCached err. ", r100, false);
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$2(ConnectionService.NetworkState r100) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$3(Boolean r100) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$4(Integer r100) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$5(Boolean r100) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$6(Boolean r100) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$7(String r100) {
        updateTreeMenu();
    }

    private void registerTreeMenuExt(WikiViewModel r100) {
        Fragment r101 = this.host.getHostFragment();
        if (r101 != null) goto L5;
    L21:
        Activity r102 = ContextsKt.findActivity(getActivity());
        if ((r102 instanceof BaseActivity) == false) goto L31;
        BaseActivity r103 = (BaseActivity) r102;
        ce5.a r104 = new ce5.a(this.host.getUserComponent());
        int r105 = u0.f240623b;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "userComponentAbility");
        u0 r106 = (u0) r103.vb(u0.class);
        if (r106 != null) goto L26;
        r106 = new u0(r103, r104);
        r103.Xi(r106);
    L26:
        r106.f240624a = r100;
        return;
    L31:
        return;
    L5:
        if (ForsetiHelper.s(this.host.getHostFragment()) == true) goto L8;
        if (AppInfoUtils.f().booleanValue() == false) goto L21;
    L8:
        if (r101 == null) goto L13;
        if ((r101 instanceof com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.n) == true) goto L15;
        r101 = r101.getParentFragment();
    L15:
        if ((r101 instanceof sa5.o) == false) goto L21;
        sa5.o r107 = (sa5.o) r101;
        ce5.a r108 = new ce5.a(this.host.getUserComponent());
        int r109 = v0.f240629b;
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r107, "extensionHost");
        Intrinsics.checkNotNullParameter(r108, "userComponentAbility");
        v0 r110 = (v0) r107.vb(v0.class);
        if (r110 != null) goto L19;
        r110 = new v0(r101, r101, r108);
        r107.Xi(r110);
    L19:
        r110.f240630a = r100;
        return;
    L13:
        r101 = null;
        goto L15
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        super.onAttachToHost(r100);
        tt5.a.h(TAG, "onAttachToHost. ");
        this.wikiTreeMenuOnBoarding = new fq5.g(this);
        init();
        observerTreeMenuEnable();
        this.host = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r100) {
        super.onDetachFromHost(r100);
        tt5.a.h(TAG, "onDetachFromHost. ");
    }

    public void setDocComponent(boolean r100) {
        this.docComponentLiveData.setValue(Boolean.valueOf(r100));
    }

    public void setEnable(boolean r100) {
        this.enable.setValue(Boolean.valueOf(r100));
    }

    public void setLoadState(int r100) {
        this.loadState.setValue(Integer.valueOf(r100));
    }

    public void setShowingHistory(boolean r100) {
        this.showingHistory.setValue(Boolean.valueOf(r100));
    }

    private static Boolean lambda$init$0(String r100, String r101) throws Exception {
        yq5.q r102 = (yq5.q) WikiDatabase.c().d();
        r102.f568835a.beginTransaction();
    L15:
        th = move-exception;
        r102.f568835a.endTransaction();
        throw th;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        if (r102.j(r100) != null) goto L10;
    L11:
        boolean r103 = false;
    L12:
        r102.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L15
        r102.f568835a.endTransaction();
        return Boolean.valueOf(r103);
    L10:
        r103 = true;
        goto L12
    L9:
        if (r102.s(r100, r101) == null) goto L11;
        goto L10
    }

    private void lambda$setupTreeMenu$8(MenuItem r100, View r101) {
        if (com.bytedance.ee.util.ui.h.a(500) == false) goto L6;
        showWikiTree();
        return;
    }

    private void updateWikiTitle(WikiViewModel r100, String r101) {
        if (r101 != null) goto L6;
        tt5.a.k(TAG, "updateWikiTitle, wiki title is null");
        return;
    L6:
        tt5.a.b(TAG, "updateWikiTitle, title= " + yu5.c.j(r101));
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r102 = WikiTreeObserver.f241338a;
        WikiTreeObserver.f241342e.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.g(r100.getSpaceId(), r100.getWikiToken(), r101));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onAttachToUIContainer(r100, r101);
        WikiViewModel r102 = g1.a(getHost());
        FragmentActivity r103 = getActivity();
        int r104 = WikiTreePanelDialog.f241630w;
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Fragment r105 = r103.getSupportFragmentManager().findFragmentByTag(WikiTreePanelDialog.class.getName());
        if ((r105 instanceof WikiTreePanelDialog) == false) goto L5;
        WikiTreePanelDialog r106 = (WikiTreePanelDialog) r105;
    L6:
        StringBuilder r107 = new StringBuilder("find dialog, dialog is null: ");
        if (r106 != null) goto L9;
        boolean r108 = true;
    L10:
        r107.append(r108);
        tt5.a.b("Wiki_WikiTreePanelDialog", r107.toString());
        this.wikiTreePanel = r106;
        this.treeItemView = setupTreeMenu();
        registerTreeMenuExt(r102);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).w(this.listRenameHandler);
        return;
    L9:
        r108 = false;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r100, com.bytedance.ee.bear.browser.plugin.t r101) {
        super.onDetachFromUIContainer(r100, r101);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).q(this.listRenameHandler);
        Runnable r102 = this.onBoardingTask;
        if (r102 == null) goto L6;
        com.bytedance.ee.util.ui.j.e(r102);
        return;
    }

    public static /* synthetic */ void access$000(WikiTreeMenuPlugin r100, WikiViewModel r101, String r102) {
        r100.updateWikiTitle(r101, r102);
    }

    @Override // sa5.a
    public void onActivityResult(int r100, int r101, Intent r102) {
        tt5.a.h(TAG, "onActivityResult. requestCode: " + r100 + ", resultCode: " + r101);
        WikiTreePanelDialog r103 = this.wikiTreePanel;
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }
}
