package com.bytedance.ee.bear.bitable.filtersortviewsetting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.cardview.viewsetting.CardViewSettingFragment;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.filter.view.BitableFilterPanelFragment;
import com.bytedance.ee.bear.bitable.sort.BitableSortPanelFragment;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.bitable.toolbox.viewmodel.BitableToolboxViewModel;
import com.bytedance.ee.bear.bitable.utils.g;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001c\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020#H\u0002J\b\u00101\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020\u001fH\u0016J\"\u00103\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u0001052\u000e\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u000107H\u0002J\u001f\u00108\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u0001052\b\u0010:\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010;J\u0012\u0010<\u001a\u00020\u001f2\b\u00109\u001a\u0004\u0018\u000105H\u0002J\n\u0010=\u001a\u0004\u0018\u00010>H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006A"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/BitableFilterSortViewSettingPanel;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "<init>", "()V", "isFragmentInForseti", "", "mTabLayout", "Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "mTabVP", "Landroidx/viewpager/widget/ViewPager;", "mFilterFragment", "Lcom/bytedance/ee/bear/bitable/filter/view/BitableFilterPanelFragment;", "mSortFragment", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortPanelFragment;", "mRootViewWidth", "", "mFilterSortViewSettingViewModel", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/FilterSortViewSettingViewModel;", "getMFilterSortViewSettingViewModel", "()Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/FilterSortViewSettingViewModel;", "mFilterSortViewSettingViewModel$delegate", "Lkotlin/Lazy;", "mAllTabInfoList", "", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/FilterSortViewSettingViewModel$TabInfo;", "mVPAdapter", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/BitableFilterSortViewSettingPanel$FilterSortViewSettingFragmentAdapter;", "mOnPageChangeListener", "com/bytedance/ee/bear/bitable/filtersortviewsetting/BitableFilterSortViewSettingPanel$mOnPageChangeListener$1", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/BitableFilterSortViewSettingPanel$mOnPageChangeListener$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onCreateContentView", "onViewCreated", "view", "initPanelStyle", "initTopBar", "setTopBarRightButton", "it", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData$TopBarButton;", "initVP", "initBottomFix", "onResume", "setCurrentTab", "currTab", "", "allTabs", "", "setBottomView", "tabId", "isAutoSort", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "setViewTreeObserver", "getSrcObjInfo", "Lcom/bytedance/ee/bear/bitable/common/perm/SrcObjInfo;", "Companion", "FilterSortViewSettingFragmentAdapter", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFilterSortViewSettingPanel extends BaseActionPanelFragment {
    public static final /* synthetic */ int P = 0;
    public boolean G;
    public UDTabLayout H;
    public ViewPager I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public BitableFilterPanelFragment f212124J;
    public BitableSortPanelFragment K;
    public int L;
    public final Lazy M;
    public final List<FilterSortViewSettingViewModel.b> N;
    public final BitableFilterSortViewSettingPanel$mOnPageChangeListener$1 O;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/BitableFilterSortViewSettingPanel$FilterSortViewSettingFragmentAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "tabs", "", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/FilterSortViewSettingViewModel$TabInfo;", "<init>", "(Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/BitableFilterSortViewSettingPanel;Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "getTabs", "()Ljava/util/List;", "getTabId", "", "position", "", "getCount", "getItem", "Landroidx/fragment/app/Fragment;", "getPageTitle", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FilterSortViewSettingFragmentAdapter extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<FilterSortViewSettingViewModel.b> f212125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableFilterSortViewSettingPanel f212126b;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f212125a.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public final Fragment getItem(int r100) {
            Bundle r101 = new Bundle();
            PluginHost.writePluginHostToBundle(this.f212126b, r101);
            String r102 = ((FilterSortViewSettingViewModel.b) ListProtector.get(this.f212125a, r100)).f212130a;
            if (Intrinsics.areEqual(r102, "filter") == false) goto L6;
            BitableFilterPanelFragment r103 = new BitableFilterPanelFragment();
            r103.setArguments(r101);
            this.f212126b.f212124J = r103;
            return r103;
        L6:
            if (Intrinsics.areEqual(r102, "sort") == false) goto L8;
            BitableSortPanelFragment r104 = new BitableSortPanelFragment();
            r104.setArguments(r101);
            this.f212126b.K = r104;
            return r104;
        L8:
            CardViewSettingFragment r105 = new CardViewSettingFragment();
            BitableFilterSortViewSettingPanel r106 = this.f212126b;
            r101.putBoolean("force_nested_scroll", true);
            if (com.bytedance.ee.bear.bitable.c.h() == false) goto L13;
            int r107 = r106.L;
            if (r107 <= 0) goto L13;
            r101.putInt("root_view_width", r107);
        L13:
            r105.setArguments(r101);
            return r105;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            return ((FilterSortViewSettingViewModel.b) ListProtector.get(this.f212125a, r100)).f212131b;
        }

        public FilterSortViewSettingFragmentAdapter(BitableFilterSortViewSettingPanel r100, FragmentManager r101, List<FilterSortViewSettingViewModel.b> r102) {
            Intrinsics.checkNotNullParameter(r101, "fm");
            Intrinsics.checkNotNullParameter(r102, "tabs");
            this.f212126b = r100;
            super(r101);
            this.f212125a = r102;
        }
    }

    public static final class a {
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableFilterSortViewSettingPanel f212127c;

        public b(BitableFilterSortViewSettingPanel r100) {
            this.f212127c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            BitableSortPanelFragment r101 = this.f212127c.K;
            if (r101 == null) goto L6;
            r101.Z90();
            return;
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableFilterSortViewSettingPanel f212128c;

        public c(BitableFilterSortViewSettingPanel r100) {
            this.f212128c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            BitableSortPanelFragment r101 = this.f212128c.K;
            if (r101 == null) goto L7;
            r101.V90();
            BitableToolboxAnalytic r102 = r101.X90();
            if (r102 == null) goto L7;
            BitableToolboxAnalytic.O(r102, "confirm", null, null, null, 14);
        L7:
            UDToast.show(this.f212128c.requireContext(), R.string.Bitable_Mobile_Applied_Toast);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final mr4.a o() {
        BitableFilterPanelFragment r100 = this.f212124J;
        Integer r101 = null;
        if (r100 == null) goto L13;
        BitableToolboxViewModel r102 = (BitableToolboxViewModel) q.a(r100, BitableToolboxViewModel.class);
        int r103 = g.f216277a;
        PanelData r104 = r102.getPanelData().getValue();
        if (r104 == null) goto L7;
        String r105 = r104.getSrcObjToken();
    L8:
        PanelData r106 = r102.getPanelData().getValue();
        if (r106 == null) goto L12;
        r101 = r106.getSrcObjType();
    L12:
        return g.a(r105, r101);
    L7:
        r105 = null;
        goto L8
    L13:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        tt5.a.h("FilterSortViewSettingPanel", "onResume");
        super.onResume();
    }

    public final FilterSortViewSettingViewModel za0() {
        return (FilterSortViewSettingViewModel) this.M.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ee.bear.bitable.filtersortviewsetting.BitableFilterSortViewSettingPanel$mOnPageChangeListener$1] */
    public BitableFilterSortViewSettingPanel() {
        this.M = LazyKt.lazy(new BitableFilterSortViewSettingPanel$mFilterSortViewSettingViewModel$2(this));
        this.N = new ArrayList();
        this.O = new BitableFilterSortViewSettingPanel$mOnPageChangeListener$1(this);
    }

    public final void Ca0(PanelData.TopBarButton r100) {
        if (TextUtils.isEmpty(r100.getText()) == false) goto L5;
    L18:
        ia0().setRightButtonVisible(false);
        return;
    L5:
        if (TextUtils.isEmpty(r100.getState()) == true) goto L18;
        String r101 = r100.getState();
        if (Intrinsics.areEqual(r101, PanelData.TopBarButtonStatus.STATUS_SHOW.getStatus()) == false) goto L10;
        ia0().g(r100.getText(), null);
        ia0().setRightButtonVisible(true);
        return;
    L10:
        if (Intrinsics.areEqual(r101, PanelData.TopBarButtonStatus.STATUS_LOADING.getStatus()) == false) goto L13;
        ia0().g(r100.getText(), Boolean.TRUE);
        ia0().setRightButtonVisible(true);
        return;
    L13:
        if (Intrinsics.areEqual(r101, PanelData.TopBarButtonStatus.STATUS_FINISH.getStatus()) == false) goto L16;
        ia0().g(r100.getText(), Boolean.FALSE);
        ia0().setRightButtonVisible(true);
        return;
    L16:
        if (Intrinsics.areEqual(r101, PanelData.TopBarButtonStatus.STATUS_HIDE.getStatus()) == false) goto L23;
        ia0().g(null, null);
        ia0().setRightButtonVisible(false);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final View la0(CommonActionPanelLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return LayoutInflater.from(requireContext()).inflate(R.layout.bitable_filter_sort_viewsetting_panel, r100, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        if (com.bytedance.ee.bear.bitable.c.h() == false) goto L9;
        Bundle r101 = getArguments();
        if (r101 == null) goto L7;
        int r102 = r101.getInt("root_view_width");
    L8:
        this.L = r102;
        goto L9
    L7:
        r102 = 0;
    L9:
        super.onCreate(r100);
    }

    public static final void ya0(BitableFilterSortViewSettingPanel r100, String r101) {
        r100.getClass();
        if (r101 == null) goto L56;
        int r102 = r101.hashCode();
        SpaceEmptyState r103 = null;
        if (r102 == (-1274492040)) goto L39;
        if (r102 == (-311985482)) goto L30;
        if (r102 != 3536286) goto L56;
        if (r101.equals("sort") == false) goto L56;
        BitableFilterPanelFragment r104 = r100.f212124J;
        if (r104 == null) goto L17;
        r104.W90();
    L17:
        BitableSortPanelFragment r105 = r100.K;
        if (r105 == null) goto L58;
        NestedScrollView r106 = r105.f215553e;
        if (r106 == null) goto L65;
        r106.getViewTreeObserver().addOnDrawListener(r105);
        if (r105.f215568t == false) goto L59;
        SpaceEmptyState r107 = r105.f215560l;
        if (r107 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
    L28:
        r103.post(new com.bytedance.ee.bear.bitable.sort.g(r105));
        return;
    L27:
        r103 = r107;
        goto L28
    L59:
        return;
    L65:
        return;
    L58:
        return;
    L30:
        if (r101.equals(PanelData.TAB_VIEW_SETTING) == false) goto L56;
        BitableFilterPanelFragment r108 = r100.f212124J;
        if (r108 == null) goto L35;
        r108.W90();
    L35:
        BitableSortPanelFragment r109 = r100.K;
        if (r109 == null) goto L61;
        r109.U90();
        return;
    L61:
        return;
    L39:
        if (r101.equals("filter") == false) goto L56;
        BitableFilterPanelFragment r110 = r100.f212124J;
        if (r110 == null) goto L53;
        NestedScrollView r111 = r110.f212030f;
        if (r111 == null) goto L53;
        r111.getViewTreeObserver().addOnDrawListener(r110);
        if (r110.f212038n == false) goto L53;
        SpaceEmptyState r112 = r110.f212032h;
        if (r112 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
    L52:
        r103.post(new com.bytedance.ee.bear.bitable.filter.view.c(r110));
        goto L53
    L51:
        r103 = r112;
    L53:
        BitableSortPanelFragment r113 = r100.K;
        if (r113 == null) goto L63;
        r113.U90();
        return;
    L63:
        return;
    L56:
        tt5.a.d("FilterSortViewSettingPanel", "setViewTreeObserver failed due to unknown tab=" + r101);
    }

    public final void Aa0(String r100, Boolean r101) {
        if (r100 == null) goto L50;
        int r102 = r100.hashCode();
        if (r102 == (-1274492040)) goto L45;
        if (r102 == (-311985482)) goto L41;
        if (r102 != 3536286) goto L50;
        if (r100.equals("sort") == false) goto L50;
        na0(true);
        if (Intrinsics.areEqual(r101, Boolean.FALSE) == false) goto L36;
        ma0(false);
        LinearLayout r103 = this.B;
        if (r103 == null) goto L18;
        r103.setVisibility(0);
    L18:
        int r104 = n.h(getContext(), R.color.primary_content_default);
        AppCompatImageView r105 = this.E;
        if (r105 == null) goto L21;
        r105.setImageResource(R.drawable.ud_icon_done_outlined);
        r105.setImageTintList(AppCompatResources.getColorStateList(r105.getContext(), R.color.primary_content_default));
    L21:
        TextView r106 = this.F;
        if (r106 == null) goto L24;
        r106.setText(R.string.Bitable_Common_Apply_Button);
        r106.setTextColor(r104);
    L24:
        View r107 = this.C;
        if (r107 == null) goto L27;
        r107.setOnClickListener(new b(this));
    L27:
        View r108 = this.D;
        if (r108 != null) goto L30;
    L39:
        ka0();
        return;
    L30:
        if ((r108 instanceof LKUIRoundableLayout) == false) goto L32;
        LKUIRoundableLayout r109 = (LKUIRoundableLayout) r108;
    L33:
        if (r109 == null) goto L35;
        r109.setBorderColor(r104);
    L35:
        r108.setOnClickListener(new c(this));
        goto L39
    L32:
        r109 = null;
        goto L33
    L36:
        ma0(true);
        LinearLayout r110 = this.B;
        if (r110 == null) goto L39;
        r110.setVisibility(8);
        goto L39
    L41:
        if (r100.equals(PanelData.TAB_VIEW_SETTING) == false) goto L50;
        na0(false);
        return;
    L45:
        if (r100.equals("filter") == false) goto L50;
        na0(true);
        ma0(true);
        LinearLayout r111 = this.B;
        if (r111 == null) goto L54;
        r111.setVisibility(8);
        return;
    L54:
        return;
    L50:
        tt5.a.d("FilterSortViewSettingPanel", "setBottomViewVisible failed due to unknown tab=" + r100);
    }

    public final void Ba0(String r100, List<String> r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
        int r102 = r101.indexOf(r100);
        StringBuilder r103 = new StringBuilder("setCurrentTab dstIdx=");
        r103.append(r102);
        r103.append(" currIdx=");
        ViewPager r104 = this.I;
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.getCurrentItem());
    L10:
        r103.append(r105);
        tt5.a.b("FilterSortViewSettingPanel", r103.toString());
        ViewPager r106 = this.I;
        if (r106 == null) goto L16;
        r106.setCurrentItem(r102);
        return;
    L16:
        return;
    L9:
        r105 = null;
    L14:
        tt5.a.h("FilterSortViewSettingPanel", "setCurrentTab return");
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        int r102 = 0;
        this.f209815p = 0;
        View r103 = null;
        com.bytedance.ee.bear.bitable.common.fragment.b.c(this, Float.valueOf(0.5f), null, null, 6);
        if (this.G == false) goto L8;
        UDShadowLayout r104 = (UDShadowLayout) ia0().findViewById(R.id.shadowLayout);
        if (r104 == null) goto L7;
        r104.setShadowSize(UDShadowLayout.Size.NONE);
    L7:
        oa0(Boolean.FALSE, null);
    L9:
        pa0(R.color.bg_float_base);
        ia0().setTitleBarVisible(false);
        ia0().setTitleBarV2Visible(true);
        ia0().setTitleV2(n.x(getContext(), R.string.Bitable_Mobile_ConfigureView_Title));
        ia0().setRightButtonVisible(false);
        ia0().getRightButton().setOnClickListener(new com.bytedance.ee.bear.bitable.filtersortviewsetting.b(this));
        za0().getTopBarButton().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.filtersortviewsetting.c(this));
        PanelData.TopBarButton r105 = za0().getTopBarButton().getValue();
        if (r105 == null) goto L12;
        Ca0(r105);
    L12:
        this.H = (UDTabLayout) r100.findViewById(R.id.viewSettingTabLayout);
        ViewPager r106 = (ViewPager) r100.findViewById(R.id.viewSettingTabVP);
        this.I = r106;
        UDTabLayout r107 = this.H;
        String r108 = za0().getCurrentTab().getValue();
        List<String> r109 = za0().getAllTabs().getValue();
        if (r107 == null) goto L20;
        if (r106 == null) goto L20;
        if (r109 == null) goto L17;
        r102 = r109.size();
    L17:
        if (r102 <= 1) goto L19;
        new UDTabLayoutCoordinator(r107, r106).attach();
        goto L20
    L19:
        r107.setVisibility(8);
    L20:
        List<FilterSortViewSettingViewModel.b> r110 = za0().getTabInfoList(r109);
        if (r110 == null) goto L23;
        ((ArrayList) this.N).clear();
        ArrayList r111 = (ArrayList) this.N;
        r111.addAll(r110);
    L23:
        FragmentManager r112 = getChildFragmentManager();
        Intrinsics.checkNotNull(r112);
        FilterSortViewSettingFragmentAdapter r113 = new FilterSortViewSettingFragmentAdapter(this, r112, this.N);
        ViewPager r114 = this.I;
        if (r114 == null) goto L26;
        r114.setAdapter(r113);
    L26:
        ViewPager r115 = this.I;
        if (r115 == null) goto L29;
        r115.setOffscreenPageLimit(r113.getCount());
    L29:
        ViewPager r116 = this.I;
        if (r116 == null) goto L32;
        r116.addOnPageChangeListener(this.O);
    L32:
        Ba0(r108, r109);
        za0().getCurrentTab().observe(getViewLifecycleOwner(), new d(this));
        ViewPager r117 = this.I;
        if (r117 == null) goto L36;
        r117.post(new e(this, r108));
    L36:
        if (this.f209825z == null) goto L39;
        r103 = ja0();
    L39:
        if (r103 == null) goto L42;
        r103.setOnClickListener(new com.bytedance.ee.bear.bitable.filtersortviewsetting.a(this));
        return;
    L42:
        return;
    L8:
        qa0(true);
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.view_setting_panel_forseti_enable") == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        this.G = r104;
        if (r104 == false) goto L12;
        this.f209813n = true;
        this.f209814o = true;
    L12:
        return super.onCreateView(r100, r101, r102);
    L5:
        if (ForsetiHelper.r(this) == false) goto L7;
        r104 = true;
        goto L8
    }
}
