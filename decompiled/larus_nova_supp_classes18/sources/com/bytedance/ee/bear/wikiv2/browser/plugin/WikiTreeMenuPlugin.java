package com.bytedance.ee.bear.wikiv2.browser.plugin;

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
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.ContextsKt;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import io.reactivex.Flowable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        public final /* synthetic */ WikiTreeMenuPlugin a;

        public a(WikiTreeMenuPlugin r1) {
            this.a = r1;
        }

        public final void b(String r3, String r4) {
            WikiViewModel r0 = g1.a(this.a.getHost());
            if (r0.isShortcut() == false) goto L5;
            return;
        L5:
            if (TextUtils.equals(r3, r0.getObjToken()) == false) goto L9;
            tt5.a.h(WikiTreeMenuPlugin.TAG, "List rename found");
            WikiTreeMenuPlugin.access$000(this.a, r0, r4);
            return;
        }
    }

    public static /* synthetic */ void a(WikiTreeMenuPlugin r0, Integer r1) {
        r0.lambda$observerTreeMenuEnable$4(r1);
    }

    public static /* synthetic */ void c(WikiTreeMenuPlugin r0, Boolean r1) {
        r0.lambda$observerTreeMenuEnable$3(r1);
    }

    public static /* synthetic */ void d(WikiTreeMenuPlugin r0, MenuItem r1, View r2) {
        r0.lambda$setupTreeMenu$8(r1, r2);
    }

    public static /* synthetic */ void e(WikiTreeMenuPlugin r0, String r1) {
        r0.lambda$observerTreeMenuEnable$7(r1);
    }

    public static /* synthetic */ void f(WikiTreeMenuPlugin r0, Boolean r1) {
        r0.lambda$observerTreeMenuEnable$5(r1);
    }

    public static /* synthetic */ Boolean g(String r0, String r1) {
        return lambda$init$0(r0, r1);
    }

    public static /* synthetic */ void h(Throwable r0) {
        lambda$init$1(r0);
    }

    public static /* synthetic */ void i(WikiTreeMenuPlugin r0, ConnectionService.NetworkState r1) {
        r0.lambda$observerTreeMenuEnable$2(r1);
    }

    public static /* synthetic */ void j(WikiTreeMenuPlugin r0, Boolean r1) {
        r0.lambda$observerTreeMenuEnable$6(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void init() {
        this.networkState = com.bytedance.ee.bear.contract.j.a.a.a();
        this.showingHistory.setValue(Boolean.FALSE);
        this.loadState.setValue(-1);
        this.enable.setValue(Boolean.TRUE);
        this.wikiTokenLiveData = g1.a(getHost()).getWikiTokenLiveData();
        WikiViewModel r0 = g1.a(getHost());
        final String r1 = r0.getSpaceId();
        final String r2 = r0.getWikiToken();
        Flowable r3 = Flowable.fromCallable(new d1(r1, r2)).subscribeOn(fo5.d.c()).observeOn(fo5.d.d());
        final MutableLiveData<Boolean> r4 = this.cached;
        Objects.requireNonNull(r4);
        r3.subscribe(new e1(r4), new f1());
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
        MenuItem r0 = new MenuItem();
        r0.setClickListener(new w0(this));
        r0.setEnable(com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a());
        r0.setId(MENU_ID_WIKI_TREE_ACTION);
        r0.setIcon(com.bytedance.ee.util.ui.l.a(getContext(), 2131256050, 2131101926));
        if (getTitleBar() == null) goto L6;
        getTitleBar().j(Collections.singletonList(r0), TitleBar.MenuType.Left);
    L6:
        return getTitleBar().findMenuView(MENU_ID_WIKI_TREE_ACTION);
    }

    private void updateTreeMenu() {
        if (this.treeItemView != null) goto L5;
        return;
    L5:
        Boolean r0 = Boolean.TRUE;
        boolean r1 = r0.equals(this.showingHistory.getValue());
        boolean r3 = false;
        if (this.loadState.getValue() != null) goto L8;
    L12:
        boolean r2 = false;
    L14:
        if (this.networkState.getValue() != null) goto L16;
    L18:
        boolean r5 = false;
    L20:
        if (this.wikiTokenLiveData.getValue() != null) goto L22;
    L24:
        boolean r6 = false;
    L26:
        if (this.loadState.getValue() != null) goto L28;
    L32:
        boolean r7 = false;
    L33:
        boolean r8 = r0.equals(this.enable.getValue());
        boolean r9 = r0.equals(this.cached.getValue());
        boolean r4 = r0.equals(this.docComponentLiveData.getValue());
        tt5.a.h(TAG, String.format("updateEnableTreeMenu (history:%b, fatalErr:%b, network:%b, loadState:%b, enable:%b, fakeTokenChecker:%b)", new Object[]{Boolean.valueOf(r1), Boolean.valueOf(r2), Boolean.valueOf(r5), Boolean.valueOf(r7), Boolean.valueOf(r8), Boolean.valueOf(r6)}));
        if (r1 == true) goto L40;
        if (r2 == true) goto L40;
        if (r4 == true) goto L40;
        if (AppInfoUtils.e().booleanValue() == true) goto L40;
        boolean r10 = true;
    L41:
        if (r7 == false) goto L47;
        if (r8 == false) goto L47;
        if (r5 == true) goto L45;
        if (r9 == false) goto L47;
    L45:
        if (r6 == true) goto L47;
        boolean r11 = true;
    L48:
        if (r10 == false) goto L54;
        this.treeItemView.setVisibility(0);
        this.treeItemView.setEnabled(r11);
        View r12 = this.treeItemView;
        if (r11 == false) goto L52;
        float r13 = 1.0f;
    L53:
        r12.setAlpha(r13);
    L55:
        if (r10 == false) goto L74;
        if (r11 == true) goto L58;
        return;
    L58:
        if (((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f("mobile_wiki_newbie_pageTree") == false) goto L60;
        return;
    L60:
        if (((WikiInfo) g1.a(getHost()).getWikiInfo().getValue()).getObjType() != sbb.e.i.b) goto L62;
        r3 = true;
    L62:
        if (r3 == false) goto L64;
        return;
    L64:
        fq5.g r14 = this.wikiTreeMenuOnBoarding;
        com.bytedance.ee.bear.browser.plugin.t r15 = getUIContainer();
        FragmentActivity r16 = getActivity();
        r14.getClass();
        tt5.a.h("WikiTreeMenuOnBoarding", "start onBoarding Mission");
        if (r14.b == false) goto L67;
        tt5.a.h("WikiTreeMenuOnBoarding", "has show onBoarding in this page" + r14);
    L70:
        fq5.d r17 = null;
    L72:
        this.onBoardingTask = r17;
        return;
    L67:
        r14.b = true;
        if (((sk5.b) org.koin.java.a.a(sk5.b.class)).b().f("mobile_wiki_newbie_pageTree") == false) goto L71;
        tt5.a.h("WikiTreeMenuOnBoarding", "wiki tree onboarding has already shown, return");
        goto L70
    L71:
        fq5.d r18 = new fq5.d(r14, r16, r15);
        com.bytedance.ee.util.ui.j.d(r18, 500);
        r17 = r18;
        goto L72
    L74:
        return;
    L52:
        r13 = 0.3f;
        goto L53
    L54:
        this.treeItemView.setVisibility(8);
    L47:
        r11 = false;
    L40:
        r10 = false;
        goto L41
    L28:
        if (((Integer) this.loadState.getValue()).intValue() != (-1)) goto L30;
    L31:
        r7 = true;
        goto L33
    L30:
        if (((Integer) this.loadState.getValue()).intValue() != 0) goto L32;
    L22:
        if (bx4.b.b((String) this.wikiTokenLiveData.getValue()) == false) goto L24;
        r6 = true;
        goto L26
    L16:
        if (((ConnectionService.NetworkState) this.networkState.getValue()).a() == false) goto L18;
        r5 = true;
        goto L20
    L8:
        if (tp5.b.c(((Integer) this.loadState.getValue()).intValue()) == false) goto L10;
    L11:
        r2 = true;
        goto L14
    L10:
        if (((Integer) this.loadState.getValue()).intValue() != (-55)) goto L12;
        goto L11
    }

    public int getLoadState() {
        if (this.loadState.getValue() != null) goto L6;
        return -1;
    L6:
        return ((Integer) this.loadState.getValue()).intValue();
    }

    public void showWikiTree() {
        tt5.a.h(TAG, "showWikiTree. ");
        WikiViewModel r2 = g1.a(getHost());
        TreeNode r3 = r2.getWikiMeta();
        int r4 = gq5.d.a;
        com.bytedance.ee.bear.contract.d r5 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap r6 = new HashMap();
        r6.putAll(r5.m("docCommonParams"));
        r6.put("click", "wiki_tree");
        r6.put("target", "ccm_wiki_tree_view");
        int r7 = gq5.d.a;
        if (r3 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L10;
        String r9 = "space";
    L11:
        r6.put("original_docs_container", r9);
        if (r3 != null) goto L14;
    L16:
        boolean r10 = false;
    L17:
        if (r10 == false) goto L19;
        String r11 = "true";
    L20:
        r6.put("is_shortcut", r11);
        r5.n("ccm_space_docs_topbar_click", r6);
        tt5.a.b("WikiReportV2", "reportTopBarClickWikiTreeEvent, params = " + r6);
        String r12 = r2.getSpaceId();
        if (TextUtils.isEmpty(r12) == false) goto L24;
        tt5.a.h(TAG, "showWikiTree, empty spaceId. return. ");
        return;
    L24:
        tt5.a.h(TAG, "showWikiTree, needOnBoarding= false");
        ar5.a r0 = r2.consumePathResolveContext();
        if (r0 == null) goto L27;
    L29:
        boolean r16 = false;
    L30:
        if (r16 == false) goto L32;
        r0 = r2.retryPathResolveContext();
    L32:
        FragmentActivity r13 = getActivity();
        String r14 = r2.getSpaceName();
        String r15 = r2.getWikiToken();
        String r17 = r2.getUniqueUiId();
        FragmentActivity r18 = getActivity();
        int r19 = lw4.a.g;
        uq5.f r1 = new uq5.f(r13, r14, r12, r15, r17, com.bytedance.ee.util.ui.a.a(r18), r0, r16);
        PluginHost r20 = this.host;
        int r21 = WikiTreePanelDialog.w;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r20, "pluginHost");
        if (ForsetiHelper.s(r20.getHostFragment()) == false) goto L35;
        WikiTreePanelDialog._ViewModel r22 = (WikiTreePanelDialog._ViewModel) new ViewModelProvider(r20).get(WikiTreePanelDialog._ViewModel.class);
    L36:
        String r23 = r1.b;
        String r24 = "";
        if (r23 != null) goto L39;
        r23 = "";
    L39:
        r22.setTitle(r23);
        r22.setSpaceId(r1.c);
        String r25 = r1.d;
        if (r25 != null) goto L42;
        r25 = "";
    L42:
        r22.setWikiToken(r25);
        r22.setNeedOnBoarding(false);
        String r26 = r1.e;
        if (r26 == null) goto L46;
        r24 = r26;
    L46:
        r22.setUniqueUiId(r24);
        r22.setNeedExpandWindow(r1.g);
        r22.setPathResolveContext(r1.h);
        r22.setReusePathResolveTree(r1.i);
        boolean r27 = ForsetiHelper.s(r20.getHostFragment());
        WikiTreePanelDialog r28 = Fragment.instantiate(r1.getContext(), WikiTreePanelDialog.class.getName());
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.wikitreev2.panel.WikiTreePanelDialog");
        WikiTreePanelDialog r29 = r28;
        Bundle r30 = new Bundle();
        PluginHost.writePluginHostToBundle(r30, r20);
        r29.setArguments(r30);
        if (r27 == true) goto L61;
    L50:
        FragmentManager r31 = r1.getContext().getSupportFragmentManager();     // Catch: Exception -> L56
        String r32 = WikiTreePanelDialog.class.getName();     // Catch: Exception -> L56
        LandscapeRestrictionOperation r33 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L56
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r29, r32, r33);     // Catch: Exception -> L56
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r31, r29, r33) == false) goto L63;
    L58:
        this.wikiTreePanel = r29;
        return;
    L63:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L60
    L54:
        r29.show(r31, r32);     // Catch: Exception -> L56
    L56:
        e = move-exception;
        tt5.a.d("Wiki_WikiTreePanelDialog", "show panel dialog error " + e.getMessage());
        goto L58
    L61:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r29, r20.getHostFragment(), ForsetiNavOptions.DestinationStyle.FLOAT, false, 0, false, 60) == true) goto L58;
    L35:
        r22 = (WikiTreePanelDialog._ViewModel) new ViewModelProvider(r1.getContext()).get(WikiTreePanelDialog._ViewModel.class);
        goto L36
    L27:
        if (r2.isPathResolveContextConsumed() == false) goto L29;
        r16 = true;
        goto L30
    L19:
        r11 = "false";
        goto L20
    L14:
        if (r3.isShortcut() != true) goto L16;
        r10 = true;
        goto L17
    L10:
        r9 = DocumentType.WIKI_NAME;
        goto L11
    L5:
        if (r3.origin_is_external != true) goto L7;
        r8 = true;
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

    private static void lambda$init$1(Throwable r3) throws Exception {
        tt5.a.e(TAG, "checkRelationCached err. ", r3, false);
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$2(ConnectionService.NetworkState r1) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$3(Boolean r1) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$4(Integer r1) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$5(Boolean r1) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$6(Boolean r1) {
        updateTreeMenu();
    }

    private /* synthetic */ void lambda$observerTreeMenuEnable$7(String r1) {
        updateTreeMenu();
    }

    private void registerTreeMenuExt(WikiViewModel r6) {
        Fragment r0 = this.host.getHostFragment();
        if (r0 != null) goto L5;
    L21:
        BaseActivity r1 = ContextsKt.findActivity(getActivity());
        if ((r1 instanceof BaseActivity) == false) goto L31;
        BaseActivity r2 = r1;
        ce5.a r3 = new ce5.a(this.host.getUserComponent());
        int r4 = u0.b;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        u0 r5 = (u0) r2.vb(u0.class);
        if (r5 != null) goto L26;
        r5 = new u0(r2, r3);
        r2.Xi(r5);
    L26:
        r5.a = r6;
        return;
    L31:
        return;
    L5:
        if (ForsetiHelper.s(this.host.getHostFragment()) == true) goto L8;
        if (AppInfoUtils.f().booleanValue() == false) goto L21;
    L8:
        if (r0 == null) goto L13;
        if ((r0 instanceof com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.n) == true) goto L15;
        r0 = r0.getParentFragment();
    L15:
        if ((r0 instanceof sa5.o) == false) goto L21;
        sa5.o r7 = (sa5.o) r0;
        ce5.a r8 = new ce5.a(this.host.getUserComponent());
        int r9 = v0.b;
        Intrinsics.checkNotNullParameter(r0, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r7, "extensionHost");
        Intrinsics.checkNotNullParameter(r8, "userComponentAbility");
        v0 r10 = (v0) r7.vb(v0.class);
        if (r10 != null) goto L19;
        r10 = new v0(r0, r0, r8);
        r7.Xi(r10);
    L19:
        r10.a = r6;
        return;
    L13:
        r0 = null;
        goto L15
    }

    public void onAttachToHost(PluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        tt5.a.h(TAG, "onAttachToHost. ");
        this.wikiTreeMenuOnBoarding = new fq5.g(this);
        init();
        observerTreeMenuEnable();
        this.host = r3;
    }

    public void onDetachFromHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r2);
        tt5.a.h(TAG, "onDetachFromHost. ");
    }

    public void setDocComponent(boolean r2) {
        this.docComponentLiveData.setValue(Boolean.valueOf(r2));
    }

    public void setEnable(boolean r2) {
        this.enable.setValue(Boolean.valueOf(r2));
    }

    public void setLoadState(int r2) {
        this.loadState.setValue(Integer.valueOf(r2));
    }

    public void setShowingHistory(boolean r2) {
        this.showingHistory.setValue(Boolean.valueOf(r2));
    }

    private static Boolean lambda$init$0(String r2, String r3) throws Exception {
        yq5.q r0 = (yq5.q) WikiDatabase.c().d();
        r0.a.beginTransaction();
    L15:
        th = move-exception;
        r0.a.endTransaction();
        throw th;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        if (r0.j(r2) != null) goto L10;
    L11:
        boolean r4 = false;
    L12:
        r0.a.setTransactionSuccessful();     // Catch: Throwable -> L15
        r0.a.endTransaction();
        return Boolean.valueOf(r4);
    L10:
        r4 = true;
        goto L12
    L9:
        if (r0.s(r2, r3) == null) goto L11;
        goto L10
    }

    private void lambda$setupTreeMenu$8(MenuItem r1, View r2) {
        if (com.bytedance.ee.util.ui.h.a(500) == false) goto L6;
        showWikiTree();
        return;
    }

    private void updateWikiTitle(WikiViewModel r4, String r5) {
        if (r5 != null) goto L6;
        tt5.a.k(TAG, "updateWikiTitle, wiki title is null");
        return;
    L6:
        tt5.a.b(TAG, "updateWikiTitle, title= " + yu5.c.j(r5));
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r0 = WikiTreeObserver.a;
        WikiTreeObserver.e.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.g(r4.getSpaceId(), r4.getWikiToken(), r5));
    }

    public void onAttachToUIContainer(PluginHost r3, com.bytedance.ee.bear.browser.plugin.t r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        WikiViewModel r5 = g1.a(getHost());
        FragmentActivity r6 = getActivity();
        int r0 = WikiTreePanelDialog.w;
        Intrinsics.checkNotNullParameter(r6, "context");
        WikiTreePanelDialog r7 = r6.getSupportFragmentManager().findFragmentByTag(WikiTreePanelDialog.class.getName());
        if ((r7 instanceof WikiTreePanelDialog) == false) goto L5;
        WikiTreePanelDialog r8 = r7;
    L6:
        StringBuilder r1 = new StringBuilder("find dialog, dialog is null: ");
        if (r8 != null) goto L9;
        boolean r2 = true;
    L10:
        r1.append(r2);
        tt5.a.b("Wiki_WikiTreePanelDialog", r1.toString());
        this.wikiTreePanel = r8;
        this.treeItemView = setupTreeMenu();
        registerTreeMenuExt(r5);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).w(this.listRenameHandler);
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r8 = null;
        goto L6
    }

    public void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).q(this.listRenameHandler);
        Runnable r3 = this.onBoardingTask;
        if (r3 == null) goto L6;
        com.bytedance.ee.util.ui.j.e(r3);
        return;
    }

    public static /* synthetic */ void access$000(WikiTreeMenuPlugin r0, WikiViewModel r1, String r2) {
        r0.updateWikiTitle(r1, r2);
    }

    public void onActivityResult(int r3, int r4, Intent r5) {
        tt5.a.h(TAG, "onActivityResult. requestCode: " + r3 + ", resultCode: " + r4);
        WikiTreePanelDialog r0 = this.wikiTreePanel;
        if (r0 == null) goto L6;
        r0.onActivityResult(r3, r4, r5);
        return;
    }
}
