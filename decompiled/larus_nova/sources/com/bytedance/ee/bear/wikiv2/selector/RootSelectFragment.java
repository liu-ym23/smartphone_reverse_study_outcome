package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001UB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102H\u0016J$\u00103\u001a\u00020\t2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020-H\u0002J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020-H\u0016J\b\u0010@\u001a\u00020-H\u0016J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020-H\u0016J\b\u0010E\u001a\u00020-H\u0016J\b\u0010F\u001a\u00020-H\u0016J\u001a\u0010G\u001a\u00020-2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020-H\u0016J\b\u0010M\u001a\u00020-H\u0016J\b\u0010N\u001a\u00020-H\u0016J\u0010\u0010N\u001a\u00020-2\u0006\u0010B\u001a\u00020OH\u0016J\"\u0010A\u001a\u00020-2\b\u00109\u001a\u0004\u0018\u00010\t2\u0006\u0010P\u001a\u00020K2\u0006\u0010Q\u001a\u00020CH\u0016J\b\u0010R\u001a\u00020-H\u0016J\u0012\u0010G\u001a\u00020-2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010S\u001a\u00020-H\u0016J\n\u0010T\u001a\u0004\u0018\u00010/H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006V"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectPresenter$IDependence;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/makecopy/IWikiMakeCopyDependence;", "Lcom/bytedance/ee/bear/list/selector/FolderSelectDependence;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "selectorConfig", "Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "getSelectorConfig", "()Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "setSelectorConfig", "(Lcom/bytedance/ee/bear/list/selector/SelectorConfig;)V", "presenter", "Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectPresenter;", "getPresenter", "()Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectPresenter;", "setPresenter", "(Lcom/bytedance/ee/bear/wikiv2/selector/RootSelectPresenter;)V", "trigger", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "getTrigger", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "setTrigger", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;)V", "command", "Lcom/bytedance/ee/bear/list/selector/ICommand;", "getCommand", "()Lcom/bytedance/ee/bear/list/selector/ICommand;", "setCommand", "(Lcom/bytedance/ee/bear/list/selector/ICommand;)V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "getNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initMVP", "getUserComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "onDestroyView", "selectCurrent", "openFolder", "bean", "Lcom/bytedance/ee/bear/list/selector/OpenFolderBean;", "back", "openSearch", VideoEventOneOutSync.END_TYPE_FINISH, "finishWithIntent", "intent", "Landroid/content/Intent;", "resultCode", "", "openMySpace", "openSharedSpace", "openWiki", "Lcom/bytedance/ee/bear/wikiv2/selector/IRootSelectContract$SelectorWikiClickBean;", "position", "openFolderBean", "openMyLibrary", "onCancelClick", "getContext", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RootSelectFragment extends Hilt_RootSelectFragment implements u.b, sq5.a, td5.b, d0c.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f241114m = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f241115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SelectorConfig f241116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public u f241117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.ee.bear.wikiv2.searchv2.a f241118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public td5.d f241119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Inject
    public NetService f241120l;

    public static final class a {
        public static Fragment a(FragmentManager r100, Context r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r100, "fragmentManager");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Fragment r103 = r100.getFragmentFactory().instantiate(r101.getClassLoader(), RootSelectFragment.class.getName());
            r103.setArguments(r102);
            return r103;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void E5() {
        tt5.a.h("RootSelectFragment", "openMySpace()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r100 = this.f241118j;
        if (r100 == null) goto L6;
        r100.E5();
        return;
    }

    @Override // sq5.a
    public final ce5.a P50() {
        return new ce5.a(this);
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b, td5.b
    public final void Ra() {
        tt5.a.h("RootSelectFragment", "openSearch()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r100 = this.f241118j;
        if (r100 == null) goto L6;
        r100.DR();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void U5() {
        tt5.a.h("RootSelectFragment", "openMyLibrary()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r100 = this.f241118j;
        if (r100 == null) goto L6;
        r100.U5();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void V6() {
        tt5.a.h("RootSelectFragment", "openWiki()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r100 = this.f241118j;
        if (r100 == null) goto L6;
        r100.V6();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void Z3() {
        tt5.a.h("RootSelectFragment", "openSharedSpace()...");
        com.bytedance.ee.bear.wikiv2.searchv2.a r100 = this.f241118j;
        if (r100 == null) goto L6;
        r100.Z3();
        return;
    }

    @Override // td5.b
    public final void back() {
        tt5.a.h("RootSelectFragment", "back()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r100 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r100 == null) goto L11;
        r100.g(null);
        return;
    L11:
        return;
    L7:
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L13;
        r101.onBackPressed();
        return;
    }

    @Override // td5.b
    public final void finish() {
        tt5.a.h("RootSelectFragment", "finish()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r100 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r100 == null) goto L11;
        r100.g(null);
        return;
    L11:
        return;
    L7:
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L13;
        r101.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void ke() {
        tt5.a.h("RootSelectFragment", "selectCurrent()...");
        Bundle r100 = getArguments();
        SpaceSelectorBean r101 = null;
        td5.d r102 = null;
        r102 = null;
        if (r100 == null) goto L5;
        SelectorConfig r110 = (SelectorConfig) r100.getParcelable(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG);
    L6:
        if (r110 == null) goto L8;
        SelectorType r103 = r110.f229369a;
    L10:
        if (r103 != SelectorType.WIKI_MAKE_COPY_TO) goto L72;
        Bundle r111 = getArguments();
        Intrinsics.checkNotNullParameter(r110, "selectorConfig");
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(this, "dependence");
        boolean r104 = false;
        if (r111 == null) goto L14;
        boolean r105 = r111.getBoolean("src_origin_external");
    L15:
        if (r111 == null) goto L18;
        r104 = r111.getBoolean("src_is_shortcut");
    L18:
        if (r111 == null) goto L20;
        WikiSelectorBean r106 = (WikiSelectorBean) r111.getParcelable("extra_wiki_bean");
    L22:
        if (r106 != null) goto L25;
        tt5.a.d("MakeCopyToWikiWrapper", "selectorBean is null!");
    L56:
        RootSelectFragment r107 = this;
    L69:
        r107.f241119k = r102;
        if (r102 == null) goto L88;
        r102.execute();
        return;
    L88:
        return;
    L25:
        if (r105 == false) goto L51;
        if (r104 == false) goto L51;
        if (r111 == null) goto L33;
        String r108 = r111.getString("src_space_id");
        if (r108 == null) goto L33;
        String r109 = r108;
    L34:
        if (r111 == null) goto L39;
        String r112 = r111.getString("src_parent_token");
        if (r112 == null) goto L39;
        String r113 = r112;
    L40:
        if (r111 == null) goto L42;
        r111.putParcelable("extra_space_bean", sq5.n.a(r111, r106.f241134g));
    L42:
        sq5.b r114 = new sq5.b(this, r111, r109, r113, this);
        String r115 = r106.f241128a;
        String r116 = r106.f241131d;
        String r210 = sbb.e.c(r106.f241137j);
        if (r110.f229375g != 2026) goto L45;
        String r211 = "wiki_tree";
    L47:
        if (r106.f241141n == false) goto L49;
        String r310 = "my_docs";
    L50:
        gq5.d.i(new gq5.d.C6055d("make_a_copy_to", r115, r115, r116, r210, null, null, r211, "default_location", null, "space", r310));
        r102 = r114;
        goto L56
    L49:
        r310 = "wiki";
        goto L50
    L45:
        r211 = "docs_topbar";
    L39:
        r113 = "";
    L33:
        r109 = "";
    L51:
        if (r111 == null) goto L53;
        WikiSelectorBean r117 = (WikiSelectorBean) r111.getParcelable("extra_wiki_bean");
    L54:
        if (r117 != null) goto L57;
        tt5.a.d("MakeCopyToWikiWrapper", "selectorBean is null!");
        goto L56
    L57:
        String r118 = r117.f241131d;
        int r119 = r117.f241137j;
        String r120 = r117.f241128a;
        String r121 = r117.f241133f;
        SelectorConfig r212 = r110;
        WikiSelectorBean r122 = r117;
        sq5.m r123 = new sq5.m(new sq5.e(this, r111, r118, r119, r120, r121, r117.f241134g, r121, r120, r117.f241129b, r117.f241132e, r117.f241130c, r117.f241138k, r117.f241139l, this));
        String r124 = r122.f241128a;
        String r125 = r122.f241131d;
        String r126 = sbb.e.c(r122.f241137j);
        if (r212.f229375g != 2026) goto L60;
        String r127 = "wiki_tree";
    L61:
        boolean r128 = r122.f241141n;
        if (r128 == false) goto L64;
        String r129 = "my_docs";
    L65:
        if (r128 == false) goto L67;
        String r130 = "my_docs";
    L68:
        gq5.d.i(new gq5.d.C6055d("make_a_copy_to", r124, r124, r125, r126, null, null, r127, "default_location", null, r129, r130));
        r107 = this;
        r102 = r123;
        goto L69
    L67:
        r130 = "wiki";
        goto L68
    L64:
        r129 = "wiki";
        goto L65
    L60:
        r127 = "docs_topbar";
        goto L61
    L53:
        r117 = null;
        goto L54
    L20:
        r106 = null;
        goto L22
    L14:
        r105 = false;
        goto L15
    L72:
        SelectorConfig r131 = r110;
        if (r131 == null) goto L75;
        SelectorType r132 = r131.f229369a;
    L77:
        if (r132 != SelectorType.SPACE_MAKE_COPY_TO) goto L90;
        Bundle r133 = getArguments();
        if (r133 == null) goto L81;
        r101 = (SpaceSelectorBean) r133.getParcelable("extra_space_bean");
    L81:
        if (r101 != null) goto L84;
        tt5.a.d("RootSelectFragment", "spaceSelectorBean is null");
        return;
    L84:
        String r134 = r101.f229387c;
        if (r134 == null) goto L91;
        Context r135 = getContext();
        int r136 = sbb.e.f541295f.f541317b;
        FolderVersion.Companion.getClass();
        com.bytedance.ee.bear.list.folderselect.command.n r137 = new com.bytedance.ee.bear.list.folderselect.command.n(r135, r134, r136, 5, null, getArguments(), this, new ce5.a(this));
        this.f241119k = r137;
        r137.execute();
        return;
    L91:
        return;
    L90:
        return;
    L75:
        r132 = null;
        goto L77
    L8:
        r103 = null;
        goto L10
    L5:
        r110 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void onCancelClick() {
        tt5.a.h("RootSelectFragment", "onCancelClick()...");
        if (ForsetiHelper.s(this) == false) goto L7;
        com.suite.lark.component.navroute.forseti.g r100 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r100 == null) goto L11;
        r100.g(null);
        return;
    L11:
        return;
    L7:
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L13;
        r101.finish();
        return;
    }

    @Override // d0c.c
    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L6;
        KeyEventDispatcher.Component r100 = getActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.passportc.convention.view.UserScopeView");
        return ((d0c.c) r100).e9();
    L6:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.Hilt_RootSelectFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        tt5.a.h("RootSelectFragment", "onDestroyView()...");
        u r100 = this.f241117i;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        td5.d r101 = this.f241119k;
        if (r101 == null) goto L9;
        r101.destroy();
        return;
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public RootSelectFragment() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void RW(iq5.o r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        tt5.a.h("RootSelectFragment", "openWiki()...position = " + r100.f495371b);
        getContext();
        com.bytedance.ee.bear.wikiv2.searchv2.c r101 = new com.bytedance.ee.bear.wikiv2.searchv2.c(r100.f495374e, r100.f495375f, r100.f495372c);
        Bundle r102 = getArguments();
        SelectorConfig r103 = this.f241116h;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r103 = null;
    L6:
        com.bytedance.ee.bear.wikiv2.wikitreev2.j.b(r101, r102, r103.f229375g, this);
    }

    @Override // td5.b
    public final void j7(td5.e r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        tt5.a.h("RootSelectFragment", "openFolder()...folderType = " + r100.f545508a);
        r100.f545512e = FolderSource.SEARCH.getSource();
        com.bytedance.ee.bear.wikiv2.searchv2.a r101 = this.f241118j;
        if (r101 == null) goto L6;
        r101.j7(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.selector.Hilt_RootSelectFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        tt5.a.h("RootSelectFragment", "onAttach()...");
        if ((r100 instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L6;
        this.f241118j = (com.bytedance.ee.bear.wikiv2.searchv2.a) r100;
    L6:
        if (ForsetiHelper.p() == true) goto L8;
        return;
    L8:
        if (this.f241118j == null) goto L10;
        return;
    L10:
        if ((getParentFragment() instanceof com.bytedance.ee.bear.wikiv2.searchv2.a) == false) goto L15;
        ActivityResultCaller r101 = getParentFragment();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.searchv2.IOpenPageSelectTrigger");
        this.f241118j = (com.bytedance.ee.bear.wikiv2.searchv2.a) r101;
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        tt5.a.h("RootSelectFragment", "onCreate()...");
    }

    @Override // sq5.a
    public final void ww(Intent r100) {
        tt5.a.h("RootSelectFragment", "finishWithIntent()...");
        bv(r100, -1);
    }

    @Override // td5.b
    public final void bv(Intent r100, int r101) {
        tt5.a.h("RootSelectFragment", "finishWithIntent()...resultCode = " + r101);
        if (ForsetiHelper.s(this) == false) goto L11;
        com.suite.lark.component.navroute.forseti.g r102 = com.suite.lark.component.navroute.forseti.f.b(this);
        if (r102 == null) goto L18;
        if (r100 == null) goto L9;
        Bundle r103 = r100.getExtras();
        if (r103 == null) goto L9;
    L10:
        r102.c(r101, r103);
        return;
    L9:
        r103 = new Bundle();
        goto L10
    L18:
        return;
    L11:
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L14;
        r104.setResult(r101, r100);
    L14:
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L20;
        r105.finish();
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        tt5.a.h("RootSelectFragment", "initMVP()...");
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        SelectorConfig r102 = (SelectorConfig) r101.getParcelable(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG);
        if (r102 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f241116h = r102;
        ce5.a r103 = new ce5.a(this);
        View r104 = this.f241115g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r104 = null;
    L11:
        SelectorConfig r105 = this.f241116h;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r105 = null;
    L15:
        getArguments();
        w r106 = new w(r104, r105, r103);
        SelectorConfig r107 = this.f241116h;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r107 = null;
    L19:
        t r108 = new t(r107);
        SelectorConfig r109 = this.f241116h;
        if (r109 == null) goto L22;
        SelectorConfig r111 = r109;
    L23:
        u r112 = new u(r108, r106, r111, getArguments(), this, r103);
        this.f241117i = r112;
        r112.create();
        return;
    L22:
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r111 = null;
    L6:
        r102 = new SelectorConfig();
        goto L7
    }

    @Override // com.bytedance.ee.bear.wikiv2.selector.u.b
    public final void tN(int r100, td5.e r101) {
        Intrinsics.checkNotNullParameter(r101, "openFolderBean");
        tt5.a.h("RootSelectFragment", "openFolder()...position = " + r100);
        com.bytedance.ee.bear.wikiv2.searchv2.a r102 = this.f241118j;
        if (r102 == null) goto L6;
        r102.j7(r101);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.wiki_fragment_root_select, r101, false);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f241115g = r103;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L7:
        return r103;
    }
}
