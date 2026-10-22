package com.bytedance.ee.bear.lark.sidebar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelFactory;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelData;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelFragment;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelViewModel;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.lark.CCMPlaceHolderFragment;
import com.bytedance.ee.bear.lark.DocTabFragment;
import com.bytedance.ee.bear.lark.header.m;
import com.bytedance.ee.bear.lark.z;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.tab.HomeTabAdapter;
import com.bytedance.ee.bear.list.sidebar.navigation.SidebarNavigationView;
import com.bytedance.ee.bear.list.sidebar.tab.SidebarHomeSubMenuView;
import com.bytedance.ee.bear.list.sort.SortAndFilterFragment;
import com.bytedance.ee.bear.list.sort.SortFragment;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.storage.LarkKVStorage;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import dd5.s1;
import e0c.l;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;
import lc5.x;
import net.lucode.hackware.magicindicator.MagicIndicator;
import sa5.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 y2\u00020\u00012\u00020\u0002:\u0002yzB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00109\u001a\u00020,H\u0014J\u001a\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J&\u0010>\u001a\u0004\u0018\u00010\u000e2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010,2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010E\u001a\u000202H\u0002J\u0010\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020CH\u0002J\b\u0010H\u001a\u000202H\u0002J\b\u0010I\u001a\u00020JH\u0016J\n\u0010K\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010L\u001a\u0002022\u0006\u00101\u001a\u00020\bH\u0002J\b\u0010M\u001a\u000202H\u0014J\u0010\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020,H\u0014J\u0012\u0010P\u001a\u0002022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010Q\u001a\u0002022\u0006\u0010O\u001a\u00020,2\b\b\u0002\u00108\u001a\u00020\u0006H\u0002J&\u0010R\u001a\u0002022\u0006\u0010O\u001a\u00020,2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T2\u0006\u00108\u001a\u00020\u0006H\u0002J\b\u0010V\u001a\u00020WH\u0014J\u0010\u0010X\u001a\u0002022\u0006\u0010Y\u001a\u00020\u0006H\u0014J\b\u0010Z\u001a\u000202H\u0016J\b\u0010[\u001a\u000202H\u0016J\u0010\u0010\\\u001a\u0002022\u0006\u0010]\u001a\u00020\u000eH\u0014J\b\u0010^\u001a\u000202H\u0003J\b\u0010_\u001a\u000202H\u0016J\b\u0010`\u001a\u000202H\u0002J\b\u0010a\u001a\u000202H\u0016J\u0006\u0010b\u001a\u000202J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u000202H\u0016J\u0006\u0010f\u001a\u000202J\u0006\u0010g\u001a\u00020dJ\u0006\u0010h\u001a\u00020iJ\b\u0010j\u001a\u00020\u0006H\u0014J\u0010\u0010k\u001a\u0002022\u0006\u0010l\u001a\u00020\u0006H\u0016J\u0012\u0010m\u001a\u0002022\b\u0010n\u001a\u0004\u0018\u00010oH\u0014J\u0012\u0010p\u001a\u0002022\b\u0010q\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010r\u001a\u00020sH\u0014J\b\u0010t\u001a\u00020\u0006H\u0014J\b\u0010u\u001a\u00020\u0006H\u0014J\b\u0010v\u001a\u000202H\u0016J\b\u0010w\u001a\u000202H\u0002J\b\u0010x\u001a\u000202H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R7\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/bytedance/ee/bear/lark/sidebar/SidebarDocTabFragment;", "Lcom/bytedance/ee/bear/lark/DocTabFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "viewPagerHasInit", "", "mNavigationId", "", "smartRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "mHomeMenuView", "Lcom/bytedance/ee/bear/list/sidebar/tab/SidebarHomeSubMenuView;", "mNoNetworkView", "Landroid/view/View;", "mNetworkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "commonPanelModel", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelViewModel;", "navigationView", "Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationView;", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "getRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "setRouteService", "(Lcom/bytedance/ee/bear/route/RouteService;)V", "kvStorage", "Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "getKvStorage", "()Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "setKvStorage", "(Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;)V", "listDatabaseService", "Lcom/bytedance/ee/bear/list/cache/IListDatabaseService;", "getListDatabaseService", "()Lcom/bytedance/ee/bear/list/cache/IListDatabaseService;", "setListDatabaseService", "(Lcom/bytedance/ee/bear/list/cache/IListDatabaseService;)V", "disposable", "Lio/reactivex/disposables/Disposable;", "forsetiVM", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModel;", "mRootView", "Landroid/view/ViewGroup;", "onItemClickCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "navigationId", "", "getOnItemClickCallback", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "curPosition", "isPadMode", "getRootView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "lastForsetiViewMode", "Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "isViewCreated", "observeForsetiMode", "handlePadMode", "mode", "observeNetworkState", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getRefreshLayout", "setCurPosition", "beforePageSwitch", "initView", "rootView", "initRefreshListener", "initViewPager", "initHomeMenu", "tabInfoList", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "getHomeTabConfig", "Lcom/bytedance/ee/bear/list/homepage/tab/IHomeTabConfig;", "updateHomeSubMenuFilterView", "visible", "onPageSelect", "onFirstContentDraw", "initRefreshHeader", "root", "observeMoreMenu", "onDestroyView", "onClickSortAndFilterMenu", "onClickFilterMenu", "onClickOfflineFilterMenu", "getSubModule", "", "onClickSortMenu", "onClickOfflineSortMenu", "getSortStrategyToken", "getSortScene", "Lcom/bytedance/ee/bear/list/sort/SortScene;", "isDisableCreateBtn", "onSwitchGrid", "grid", "onFilterChanged", "sortStrategy", "Lcom/bytedance/ee/bear/list/cache/FolderSortStrategy;", "onMoreBtnClick", "v", "getHeaderConfig", "Lcom/bytedance/ee/bear/lark/header/IHeaderConfig;", "isShowTitlebarCreateBtn", "isShowMoreBtn", "onPause", "reportAIPageView", "onResume", "Companion", "SidebarHeaderConfig", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SidebarDocTabFragment extends Hilt_SidebarDocTabFragment {
    public static final /* synthetic */ int Y = 0;
    public boolean G;
    public SmartRefreshLayout H;
    public SidebarHomeSubMenuView I;
    public View J;
    public ConnectionService.NetworkState K;
    public CommonMorePanelViewModel L;
    public SidebarNavigationView M;

    @Inject
    public com.bytedance.ee.bear.route.h N;

    @Inject
    public by4.d O;

    @Inject
    public mc5.j P;
    public Disposable Q;
    public ForsetiViewModel R;
    public ViewGroup S;
    public Function1<? super Integer, Unit> T;
    public int U;
    public boolean V;
    public ForsetiViewMode W;
    public boolean X;

    public static final class a {
    }

    public static final class b implements com.bytedance.ee.bear.lark.header.h {
        public final HashMap<com.bytedance.ee.bear.lark.header.i, Integer> a;

        public static final class a implements yc5.b.a {
            public a() {
            }

            public final String getModule() {
                return "home";
            }

            public final String m6() {
                return "recent";
            }
        }

        @Override // com.bytedance.ee.bear.lark.header.h
        public final Map<com.bytedance.ee.bear.lark.header.i, Integer> getHeaders() {
            return this.a;
        }

        public b(DocTabFragment r4) {
            Intrinsics.checkNotNullParameter(r4, "homePageFragment");
            LinkedHashMap r5 = new LinkedHashMap();
            this.a = r5;
            r5.put(new m(true), 0);
            r5.put(new com.bytedance.ee.bear.lark.header.l(new a()), 1);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void L2() {
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void ka0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final boolean na0() {
        return false;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void Qi() {
        ConnectionService.NetworkState r0 = this.K;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.a() != true) goto L7;
    L8:
        if (r2 == false) goto L22;
        String r3 = "manual_offline";
        if (this.y != 2) goto L17;
        Bundle r1 = new Bundle();
        if (this.y == 2) goto L15;
        r3 = "recent";
    L15:
        r1.putString("key_token", r3);
        r1.putParcelable("key_sort_strategy", this.x);
        r1.putBoolean("key_sort_asc_enable", false);
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r1);
        return;
    L17:
        Bundle r4 = new Bundle();
        if (this.y == 2) goto L21;
        r3 = "recent";
    L21:
        r4.putString("key_token", r3);
        r4.putParcelable("key_sort_strategy", this.w);
        r4.putBoolean("key_sort_asc_enable", false);
        r4.putInt("key_default_sort_pos", 2);
        r4.putInt("maxWidth", n.d(450));
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r4);
        return;
    L22:
        Context r5 = ((BaseFragment) this).mContext;
        Toast.showFailureText(r5, r5.getString(2131887789), 0);
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final com.bytedance.ee.bear.lark.header.h Z90() {
        return new b(this);
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void eF() {
        ConnectionService.NetworkState r0 = this.K;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.a() != true) goto L7;
    L8:
        if (r2 == false) goto L34;
        String r3 = "manual_offline";
        if (this.y != 2) goto L26;
        Bundle r1 = getArguments();
        if (r1 == null) goto L14;
        r1.putString("key_module", m6());
    L14:
        if (r1 == null) goto L16;
        r1.putString("key_token", "manual_offline");
    L16:
        if (r1 == null) goto L18;
        r1.putParcelable("key_sort_strategy", this.x);
    L18:
        if (r1 == null) goto L20;
        r1.putBoolean("key_sort_filter_enable", false);
    L20:
        if (r1 == null) goto L22;
        r1.putBoolean("key_reset_enable", false);
    L22:
        if (r1 == null) goto L24;
        r1.putBoolean("key_done_enable", false);
    L24:
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r1);
        return;
    L26:
        Bundle r4 = getArguments();
        if (r4 != null) goto L29;
        r4 = new Bundle();
    L29:
        r4.putString("key_module", "home");
        r4.putString("key_sub_module", m6());
        if (this.y == 2) goto L33;
        r3 = "recent";
    L33:
        r4.putString("key_token", r3);
        r4.putBoolean("key_sort_filter_enable", false);
        r4.putBoolean("key_sort_asc_enable", false);
        r4.putBoolean("key_reset_enable", false);
        r4.putBoolean("key_done_enable", false);
        r4.putInt("key_sort_title_res", 2131887915);
        r4.putParcelable("key_sort_strategy", this.w);
        r4.putInt("maxWidth", n.d(450));
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r4);
        return;
    L34:
        Toast.showFailureText(getContext(), getString(2131887789), 0);
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final ad5.f ea0() {
        return new yd5.b();
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final ViewGroup getRootView() {
        ViewGroup r0 = this.S;
        if (r0 == null) goto L7;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L12:
        return r0;
    L7:
        View r1 = LayoutInflater.from(getContext()).inflate(2131564861, null);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r2 = (ViewGroup) r1;
        this.S = r2;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L11:
        return r2;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final String m6() {
        int r0 = this.y;
        if (r0 != 0) goto L6;
        return "recent";
    L6:
        if (r0 != 2) goto L8;
        return "offline";
    L8:
        return "catalogue";
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void va0() {
        Bundle r0 = new Bundle();
        ce5.a r1 = new ce5.a(this);
        Context r2 = getContext();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r1, "userComponentAbility");
        CommonMorePanelData r3 = null;
        if (r2 == null) goto L10;
        CommonMorePanelItemData r4 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("SHARE_WITH_ME", "<set-?>");
        r4.a = "SHARE_WITH_ME";
        r4.b = 2131237961;
        r4.a(r2.getResources().getString(2131887980));
        BenefitStore r5 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1();
        boolean r6 = r5.hasBenefit("ccm_create_doc");
        boolean r7 = r5.hasBenefit("ccm_create_base");
        CommonMorePanelItemData r8 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("TEMPLATE", "<set-?>");
        r8.a = "TEMPLATE";
        r8.b = 2131255983;
        r8.a(r2.getResources().getString(2131887346));
        CommonMorePanelItemData r9 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("OFFLINE", "<set-?>");
        r9.a = "OFFLINE";
        r9.b = 2131255245;
        r9.a(r2.getResources().getString(2131887949));
        ArrayList<CommonMorePanelItemData> r10 = CollectionsKt.arrayListOf(new CommonMorePanelItemData[]{r4, r8});
        qc5.b.a(r1);
        if (r6 == true) goto L9;
        if (r7 == true) goto L9;
        r10.remove(r8);
    L9:
        r3 = new CommonMorePanelData();
        String r11 = r2.getResources().getString(2131889611);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r3.a = r11;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r3.c = r10;
    L10:
        if (r3 == null) goto L12;
        r0.putParcelable("panel_data", r3);
        r0.putInt("maxWidth", n.d(450));
        ActionSheetDialogFragment.ba0(getActivity(), CommonMorePanelFragment.class, r0);
    L12:
        lc5.f.a r12 = lc5.f.a;
        p r13 = new p("home", m6(), "more", "", "", "ccm_space_home_page_click");
        Intrinsics.checkNotNullParameter(r13, "param");
        r12.I(r13);
    }

    public SidebarDocTabFragment() {
        int r0 = CCMPlaceHolderFragment.o;
        this.W = ForsetiViewMode.UNKNOWN;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void V90() {
        z.b().getClass();
        z.a(new String[]{"key_open_finish_content", "key_open_finish_recent"});
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void onDestroyView() {
        super.onDestroyView();
        Disposable r0 = this.Q;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.X = false;
        this.G = false;
        tt5.a.h("SidebarDocTabFragment", "onDestroyView() called");
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void onPause() {
        super.onPause();
        SidebarNavigationView r0 = this.M;
        if (r0 == null) goto L33;
        boolean r1 = false;
        r0.p = false;
        sc5.i r2 = r0.o;
        if (r2 == null) goto L11;
        Dialog r3 = ((sc5.c) r2).d;
        if (r3 == null) goto L11;
        if (r3.isShowing() != true) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L37;
        tt5.a.h("SideBarNavigationView", "switch tab dismiss onboarding");
        sc5.i r4 = r0.o;
        if (r4 == null) goto L38;
        Dialog r5 = ((sc5.c) r4).d;
        if (r5 == null) goto L39;
        Handler r6 = DialogLancet.resolveDialogHandler(r5);
        if (r6 != null) goto L19;
    L21:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L24 Exception -> L26
    L30:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
        Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
        if (r7 == null) goto L30;
        com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L19:
        if (Looper.myLooper() == r6.getLooper()) goto L21;
        r6.post(DialogLancet.createDismissRunnable(r5));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void onResume() {
        super.onResume();
        SidebarNavigationView r0 = this.M;
        if (r0 == null) goto L6;
        r0.p = true;
    L6:
        if (this.V == false) goto L10;
        lc5.f.a.N("ccm_space_sidebar_view", "home", m6(), m6(), "", "");
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void pa0() {
        qc5.a.k();
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final SmartRefreshLayout xZ() {
        return this.H;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void Aa0(boolean r2) {
        SidebarHomeSubMenuView r0 = this.I;
        if (r0 == null) goto L11;
        ImageView r1 = r0.b;
        if (r1 == null) goto L12;
        if (r2 == false) goto L8;
        int r3 = 0;
    L9:
        r1.setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void Mj(boolean r1) {
        t3.a = r1;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void ma0(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        tt5.a.h("SidebarDocTabFragment", "initView() called with: rootView = " + r4);
        la0(r4);
        ha0(r4);
        ia0(r4);
        if (ForsetiHelper.n() == false) goto L5;
    L7:
        sa0();
        pd5.a.a(this);
        this.l = true;
        t.a();
        if (this.A == false) goto L10;
        x.c().h("doc_tab_fragment_init");
    L10:
        t3.a = LarkKVStorage.h(new com.ss.android.lark.storage.a(Biz.DOCS.getValue()), true).getBoolean("is_grid", false);
        s1.a.a.a(this);
        return;
    L5:
        if (this.G == true) goto L7;
        Ca0(r4, false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void ua0(FolderSortStrategy r3) {
        if (r3 == null) goto L4;
        String r0 = r3.a;
    L6:
        if (TextUtils.equals("manual_offline", r0) == false) goto L8;
        this.x = r3;
    L9:
        SidebarHomeSubMenuView r1 = this.I;
        if (r1 == null) goto L13;
        r1.a(Y90(r3));
        return;
    L13:
        return;
    L8:
        this.w = r3;
        goto L9
    L4:
        r0 = null;
        goto L6
    }

    public final void Ca0(ViewGroup r8, boolean r9) {
        this.G = true;
        by4.d r1 = this.O;
        MagicIndicator r2 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        r1 = null;
    L6:
        int r3 = 0;
        if (r1 == null) goto L11;
        com.ss.android.lark.storage.kv.repo.a r4 = r1.b("platform");
        if (r4 == null) goto L11;
        int r5 = r4.getInt("last_select_tab", 0);
    L12:
        this.y = r5;
        tt5.a.h("SidebarDocTabFragment", "initViewPager() called with: rootView = " + r8 + ", isPadMode = " + r9 + " mCurrentItem:" + this.y);
        this.o = r8.findViewById(2131378123);
        List r6 = new yd5.b().a(r9);
        Intrinsics.checkNotNull(r6);
        this.I = r8.findViewById(2131374462);
        if (ForsetiHelper.n() == false) goto L18;
        if (r9 == false) goto L18;
        SidebarHomeSubMenuView r10 = this.I;
        if (r10 == null) goto L47;
        r10.setVisibility(8);
    L47:
        HomeTabAdapter r11 = this.p;
        if (r11 == null) goto L51;
        r11.b.clear();
        this.p.b.addAll(r6);
        this.p.notifyDataSetChanged();
        return;
    L51:
        HomeTabAdapter r12 = new HomeTabAdapter(getChildFragmentManager(), getContext(), r6, X90());
        this.p = r12;
        ViewPager r13 = this.o;
        if (r13 == null) goto L54;
        r13.setAdapter(r12);
    L54:
        ViewPager r14 = this.o;
        if (r14 == null) goto L57;
        r14.setCurrentItem(this.y);
    L57:
        ViewPager r16 = this.o;
        if (r16 == null) goto L61;
        r16.setOffscreenPageLimit(1);
        return;
    L61:
        return;
    L18:
        SidebarHomeSubMenuView r17 = this.I;
        if (r17 == null) goto L21;
        r17.setVisibility(0);
    L21:
        SidebarHomeSubMenuView r18 = this.I;
        if (r18 == null) goto L24;
        r2 = r18.getMagicIndicator();
    L24:
        wuc.a r19 = new wuc.a(getContext());
        r19.setAdapter(new j(getContext(), r2, r6, new com.bytedance.ee.bear.lark.sidebar.a(this)));
        if (r2 == null) goto L27;
        r2.setNavigator(r19);
    L27:
        if (r2 == null) goto L29;
        r2.b(this.y);
    L29:
        int r20 = this.y;
        if (r20 != 0) goto L32;
    L35:
        boolean r21 = true;
    L36:
        SidebarHomeSubMenuView r22 = this.I;
        if (r22 == null) goto L44;
        ImageView r23 = r22.b;
        if (r23 == null) goto L44;
        if (r21 == true) goto L43;
        r3 = 8;
    L43:
        r23.setVisibility(r3);
    L44:
        SidebarHomeSubMenuView r24 = this.I;
        if (r24 == null) goto L47;
        r24.setOnSortAndFilterClickListener(new SidebarDocTabFragment$initHomeMenu$1(this));
        goto L47
    L32:
        if (r20 == 2) goto L35;
        r21 = false;
    L11:
        r5 = 0;
        goto L12
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        this.X = true;
        this.H = r3.findViewById(2131386421);
        vd5.d r5 = new vd5.d(r3.getContext());
        SmartRefreshLayout r0 = this.H;
        if (r0 == null) goto L5;
        r0.G(r5, n.d(60));
    L5:
        SmartRefreshLayout r6 = this.H;
        if (r6 == null) goto L8;
        r6.W = new com.bytedance.ee.bear.lark.sidebar.b(this, r6);
    L8:
        this.J = r3.findViewById(2131380933);
        SidebarNavigationView r7 = r3.findViewById(2131380635);
        this.M = r7;
        if (r7 == null) goto L11;
        r7.setOnItemClickCallback(new AnonymousClass1(this));
    L11:
        ForsetiViewModel r8 = this.R;
        if (r8 == null) goto L14;
        tua.b r9 = r8.getForsetiChainManager();
    L15:
        if (r9 != null) goto L17;
    L20:
        SidebarNavigationView r10 = this.M;
        if (r10 == null) goto L23;
        r10.v(this, new ce5.a(this), false, this.U);
    L23:
        com.bytedance.ee.bear.contract.j.a.a.a().observe(getViewLifecycleOwner(), new h(this));
        qa0();
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L35;
        CommonMorePanelViewModel r12 = (CommonMorePanelViewModel) new ViewModelProvider(r11).get(CommonMorePanelViewModel.class);
        this.L = r12;
        if (r12 == null) goto L30;
        MutableLiveData<CommonMorePanelItemData> r13 = r12.getSelectData();
        if (r13 == null) goto L30;
        r13.observe(getViewLifecycleOwner(), new d(this));
    L30:
        CommonMorePanelViewModel r14 = this.L;
        if (r14 == null) goto L35;
        MutableLiveData<Boolean> r16 = r14.getTriggerResetData();
        if (r16 == null) goto L35;
        r16.observe(getViewLifecycleOwner(), new g(this));
    L35:
        ra0();
        return;
    L17:
        if (ForsetiHelper.n() == false) goto L20;
        if (ForsetiHelper.s(this) == true) goto L23;
    L14:
        r9 = null;
        goto L15
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        tt5.a.h("SidebarDocTabFragment", "onCreateView: ");
        if (ForsetiHelper.n() == false) goto L10;
        ForsetiViewModel r0 = (ForsetiViewModel) new ViewModelProvider(this, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class);
        this.R = r0;
        if (r0 == null) goto L10;
        LiveData<ForsetiViewMode> r1 = r0.getViewMode();
        if (r1 == null) goto L10;
        r1.observe(getViewLifecycleOwner(), new c(this));
    L10:
        return super.onCreateView(r4, r5, r6);
    }
}
