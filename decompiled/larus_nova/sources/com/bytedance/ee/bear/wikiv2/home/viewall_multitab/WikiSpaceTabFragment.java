package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.searchv2.enh.WikiSearchbar;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.utils.ContextsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020!2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0003J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020,H\u0016J\"\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u00020,H\u0002J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000208H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "searchBarFromXml", "Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar;", "getSearchBarFromXml", "()Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar;", "setSearchBarFromXml", "(Lcom/bytedance/ee/bear/wikiv2/searchv2/enh/WikiSearchbar;)V", "viewPagerFromXml", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewPager;", "getViewPagerFromXml", "()Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewPager;", "setViewPagerFromXml", "(Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewPager;)V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceTabViewModel;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "args", "Lcom/bytedance/ee/bear/wikiv2/home/viewall_multitab/WikiSpaceListArgs;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "bindView", "bindListener", "onBackPressed", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "titleBarHeight", "setTitleBarVisible", "visible", "commitFragment", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceTabFragment extends BaseFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f240764j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WikiSearchbar f240765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WikiSpaceTabViewPager f240766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BaseTitleBar f240767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WikiSpaceTabViewModel f240768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f240769i;

    public static final class a {
    }

    static {
    }

    public final WikiSearchbar U90() {
        View r100 = this.f240765e;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.search_bar);
    L8:
        this.f240765e = (WikiSearchbar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (WikiSearchbar) r100;
    }

    public final BaseTitleBar V90() {
        View r100 = this.f240767g;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.title_bar);
    L8:
        this.f240767g = (BaseTitleBar) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (BaseTitleBar) r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        WikiSearchbar r100 = U90();
        if (r100.f241069d == false) goto L5;
        r100.a();
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return true;
    L8:
        if (super.onBackPressed() == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f240765e = null;
        this.f240766f = null;
        this.f240767g = null;
    }

    public WikiSpaceTabFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r210) {
        super.onCreate(r210);
        Bundle r100 = getArguments();
        if (r100 == null) goto L56;
        String r101 = WikiSpaceListArgs.class.getName();
        Bundle r102 = getArguments();
        if (r102 == null) goto L7;
        int r103 = r102.getInt("EXTRA_PAGE_MODE", 0);
    L8:
        Bundle r104 = getArguments();
        if (r104 == null) goto L11;
        int r105 = r104.getInt("createDocumentType", sbb.e.f541296g.f541317b);
    L12:
        int r106 = r105;
        Bundle r107 = getArguments();
        if (r107 == null) goto L15;
        String r108 = r107.getString("src_token");
    L16:
        Bundle r109 = getArguments();
        if (r109 == null) goto L19;
        int r110 = r109.getInt("src_obj_type", -1);
    L20:
        Bundle r111 = getArguments();
        if (r111 == null) goto L23;
        String r112 = r111.getString("src_parent_token");
    L24:
        Bundle r113 = getArguments();
        if (r113 == null) goto L27;
        int r114 = r113.getInt("srcIsLock", -1);
    L28:
        Bundle r115 = getArguments();
        if (r115 == null) goto L31;
        String r116 = r115.getString("src_space_id");
    L32:
        Bundle r117 = getArguments();
        if (r117 == null) goto L35;
        String r118 = r117.getString("title");
    L36:
        Bundle r119 = getArguments();
        if (r119 == null) goto L39;
        String r120 = r119.getString("trigger_location");
    L40:
        Bundle r121 = getArguments();
        if (r121 == null) goto L43;
        boolean r122 = r121.getBoolean("src_is_shortcut", false);
    L44:
        Bundle r123 = getArguments();
        if (r123 == null) goto L47;
        String r124 = r123.getString("src_origin_token");
    L48:
        Bundle r125 = getArguments();
        if (r125 == null) goto L51;
        String r126 = r125.getString("src_origin_space_id");
    L52:
        Bundle r127 = getArguments();
        long r128 = 0;
        if (r127 == null) goto L55;
        r128 = r127.getLong("src_file_size", 0);
    L55:
        r100.putParcelable(r101, new WikiSpaceListArgs(r103, r106, r108, r110, r112, r114, r116, r118, r120, r122, r124, r126, r128));
        goto L56
    L51:
        r126 = null;
        goto L52
    L47:
        r124 = null;
        goto L48
    L43:
        r122 = false;
        goto L44
    L39:
        r120 = null;
        goto L40
    L35:
        r118 = null;
        goto L36
    L31:
        r116 = null;
        goto L32
    L27:
        r114 = -1;
        goto L28
    L23:
        r112 = null;
        goto L24
    L19:
        r110 = -1;
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        r105 = sbb.e.f541296g.f541317b;
        goto L12
    L7:
        r103 = 0;
    L56:
        WikiSpaceTabViewModel.Companion.getClass();
        WikiSpaceTabViewModel r129 = WikiSpaceTabViewModel.a.a(this);
        this.f240768h = r129;
        if (r129 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r129 = null;
    L59:
        WikiSpaceListArgs r130 = r129.getArgs();
        if (r130 != null) goto L62;
    L64:
        boolean r131 = false;
    L65:
        if (r131 == false) goto L68;
        gq5.d.g(null);
        return;
    L68:
        return;
    L62:
        if (r130.getPageMode() != 0) goto L64;
        r131 = true;
        goto L65
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        WikiSearchbar r102 = U90();
        Activity r103 = ContextsKt.findActivity(r102.getContext());
        WikiSpaceTabViewModel r104 = null;
        if ((r103 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r105 = (FragmentActivity) r103;
    L6:
        if (r105 == null) goto L9;
        pcb.a r106 = pcb.a.AbstractC7181a.b(r105);
        r102.f241072g = r106;
        r102.f241073h = new WikiSearchbar.b(r102);
        Intrinsics.checkNotNull(r106);
        r106.c(r102.f241073h);
    L9:
        r102.getClearFromXml().setOnClickListener(new hq5.a(r102));
        r102.getCancelFromXml().setOnClickListener(new hq5.b(r102));
        r102.getInputFromXml().setOnEditorActionListener(new hq5.c(r102));
        r102.getInputFromXml().setOnFocusChangeListener(new hq5.d(r102));
        U90().setInputHint(R.string.Doc_Wiki_SearchWorkspace);
        if (yp5.c.c() == false) goto L19;
        View r107 = this.f240766f;
        if (r107 != null) goto L18;
        View r108 = getView();
        if (r108 == null) goto L16;
        r107 = r108.findViewById(R.id.view_pager);
    L17:
        this.f240766f = (WikiSpaceTabViewPager) r107;
        goto L18
    L16:
        r107 = null;
    L18:
        FragmentManager r109 = getChildFragmentManager();
        Bundle r110 = getArguments();
        TabEnum r111 = TabEnum.ALL;
        r111.getSpaceType();
        int r112 = WikiSpaceListFragment.f240725m;
        TabEnum r113 = TabEnum.TEAM;
        r113.getSpaceType();
        TabEnum r114 = TabEnum.PERSONAL;
        r114.getSpaceType();
        ((WikiSpaceTabViewPager) r107).a(r109, CollectionsKt.listOf(new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a[]{new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a(R.string.CreationMobile_Wiki_All, WikiSpaceListFragment.a.a(r111.getSpaceType(), r110)), new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a(R.string.CreationMobile_Wiki_Team, WikiSpaceListFragment.a.a(r113.getSpaceType(), r110)), new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a(R.string.CreationMobile_Wiki_Personal, WikiSpaceListFragment.a.a(r114.getSpaceType(), r110))}));
    L27:
        V90().setLeftClickListener(new n(this));
        View r115 = getView();
        if (r115 == null) goto L30;
        r115.setOnClickListener(o.f240793a);
    L30:
        WikiSpaceTabViewModel r116 = this.f240768h;
        if (r116 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        r104.getTitle().observe(getViewLifecycleOwner(), new m(this));
        U90().setViewDelegate(new l(this));
        return;
    L33:
        r104 = r116;
        goto L34
    L19:
        View r117 = this.f240766f;
        if (r117 != null) goto L26;
        View r118 = getView();
        if (r118 == null) goto L24;
        r117 = r118.findViewById(R.id.view_pager);
    L25:
        this.f240766f = (WikiSpaceTabViewPager) r117;
        goto L26
    L24:
        r117 = null;
    L26:
        WikiSpaceTabViewPager r119 = (WikiSpaceTabViewPager) r117;
        FragmentManager r120 = getChildFragmentManager();
        Bundle r121 = getArguments();
        TabEnum r122 = TabEnum.ALL;
        r122.getSpaceType();
        int r123 = WikiSpaceListFragment.f240725m;
        com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a r124 = new com.bytedance.ee.bear.wikiv2.home.viewall_multitab.a(R.string.CreationMobile_Wiki_All, WikiSpaceListFragment.a.a(r122.getSpaceType(), r121));
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "fm");
        Intrinsics.checkNotNullParameter(r124, "tab");
        r119.a(r120, CollectionsKt.listOf(r124));
        r119.getTabLayoutFromXml().setVisibility(8);
        r119.getTabDividerFromXml().setVisibility(8);
        goto L27
    L5:
        r105 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r101 != (-1)) goto L5;
    L7:
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L11;
        r103.setResult(r101, r102);
        r103.finish();
        return;
    L11:
        return;
    L5:
        if (r101 == 100) goto L7;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.wiki_space_tab_fragment, r101, false);
    }
}
