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
import com.alibaba.gaiax.render.view.GXViewKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
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
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ttnet.org.chromium.base.BaseSwitches;
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

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 y2\u00020\u00012\u00020\u0002:\u0002yzB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00109\u001a\u00020,H\u0014J\u001a\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020\u000e2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J&\u0010>\u001a\u0004\u0018\u00010\u000e2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010,2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010E\u001a\u000202H\u0002J\u0010\u0010F\u001a\u0002022\u0006\u0010G\u001a\u00020CH\u0002J\b\u0010H\u001a\u000202H\u0002J\b\u0010I\u001a\u00020JH\u0016J\n\u0010K\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010L\u001a\u0002022\u0006\u00101\u001a\u00020\bH\u0002J\b\u0010M\u001a\u000202H\u0014J\u0010\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020,H\u0014J\u0012\u0010P\u001a\u0002022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010Q\u001a\u0002022\u0006\u0010O\u001a\u00020,2\b\b\u0002\u00108\u001a\u00020\u0006H\u0002J&\u0010R\u001a\u0002022\u0006\u0010O\u001a\u00020,2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T2\u0006\u00108\u001a\u00020\u0006H\u0002J\b\u0010V\u001a\u00020WH\u0014J\u0010\u0010X\u001a\u0002022\u0006\u0010Y\u001a\u00020\u0006H\u0014J\b\u0010Z\u001a\u000202H\u0016J\b\u0010[\u001a\u000202H\u0016J\u0010\u0010\\\u001a\u0002022\u0006\u0010]\u001a\u00020\u000eH\u0014J\b\u0010^\u001a\u000202H\u0003J\b\u0010_\u001a\u000202H\u0016J\b\u0010`\u001a\u000202H\u0002J\b\u0010a\u001a\u000202H\u0016J\u0006\u0010b\u001a\u000202J\b\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u000202H\u0016J\u0006\u0010f\u001a\u000202J\u0006\u0010g\u001a\u00020dJ\u0006\u0010h\u001a\u00020iJ\b\u0010j\u001a\u00020\u0006H\u0014J\u0010\u0010k\u001a\u0002022\u0006\u0010l\u001a\u00020\u0006H\u0016J\u0012\u0010m\u001a\u0002022\b\u0010n\u001a\u0004\u0018\u00010oH\u0014J\u0012\u0010p\u001a\u0002022\b\u0010q\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010r\u001a\u00020sH\u0014J\b\u0010t\u001a\u00020\u0006H\u0014J\b\u0010u\u001a\u00020\u0006H\u0014J\b\u0010v\u001a\u000202H\u0016J\b\u0010w\u001a\u000202H\u0002J\b\u0010x\u001a\u000202H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R7\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/bytedance/ee/bear/lark/sidebar/SidebarDocTabFragment;", "Lcom/bytedance/ee/bear/lark/DocTabFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "viewPagerHasInit", "", "mNavigationId", "", "smartRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "mHomeMenuView", "Lcom/bytedance/ee/bear/list/sidebar/tab/SidebarHomeSubMenuView;", "mNoNetworkView", "Landroid/view/View;", "mNetworkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "commonPanelModel", "Lcom/bytedance/ee/bear/content/common/morepanel/CommonMorePanelViewModel;", "navigationView", "Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationView;", "routeService", "Lcom/bytedance/ee/bear/route/RouteService;", "getRouteService", "()Lcom/bytedance/ee/bear/route/RouteService;", "setRouteService", "(Lcom/bytedance/ee/bear/route/RouteService;)V", "kvStorage", "Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "getKvStorage", "()Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;", "setKvStorage", "(Lcom/bytedance/ee/bear/diskmanager/container/ICCMUserKVStorage;)V", "listDatabaseService", "Lcom/bytedance/ee/bear/list/cache/IListDatabaseService;", "getListDatabaseService", "()Lcom/bytedance/ee/bear/list/cache/IListDatabaseService;", "setListDatabaseService", "(Lcom/bytedance/ee/bear/list/cache/IListDatabaseService;)V", "disposable", "Lio/reactivex/disposables/Disposable;", "forsetiVM", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiViewModel;", "mRootView", "Landroid/view/ViewGroup;", "onItemClickCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "navigationId", "", "getOnItemClickCallback", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "curPosition", "isPadMode", "getRootView", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "lastForsetiViewMode", "Lcom/ss/android/lark/api/bean/ForsetiViewMode;", "isViewCreated", "observeForsetiMode", "handlePadMode", "mode", "observeNetworkState", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getRefreshLayout", "setCurPosition", "beforePageSwitch", "initView", "rootView", "initRefreshListener", "initViewPager", "initHomeMenu", "tabInfoList", "", "Lcom/bytedance/ee/bear/list/homepage/tab/HomeTabInfo;", "getHomeTabConfig", "Lcom/bytedance/ee/bear/list/homepage/tab/IHomeTabConfig;", "updateHomeSubMenuFilterView", "visible", "onPageSelect", "onFirstContentDraw", "initRefreshHeader", RootDescription.ROOT_ELEMENT, "observeMoreMenu", "onDestroyView", "onClickSortAndFilterMenu", "onClickFilterMenu", "onClickOfflineFilterMenu", "getSubModule", "", "onClickSortMenu", "onClickOfflineSortMenu", "getSortStrategyToken", "getSortScene", "Lcom/bytedance/ee/bear/list/sort/SortScene;", "isDisableCreateBtn", "onSwitchGrid", GXViewKey.VIEW_TYPE_CONTAINER_GRID, "onFilterChanged", "sortStrategy", "Lcom/bytedance/ee/bear/list/cache/FolderSortStrategy;", "onMoreBtnClick", BaseSwitches.V, "getHeaderConfig", "Lcom/bytedance/ee/bear/lark/header/IHeaderConfig;", "isShowTitlebarCreateBtn", "isShowMoreBtn", "onPause", "reportAIPageView", "onResume", "Companion", "SidebarHeaderConfig", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SidebarDocTabFragment extends Hilt_SidebarDocTabFragment {
    public static final /* synthetic */ int Y = 0;
    public boolean G;
    public SmartRefreshLayout H;
    public SidebarHomeSubMenuView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public View f227517J;
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<com.bytedance.ee.bear.lark.header.i, Integer> f227518a;

        public static final class a implements yc5.b.a {
            public a() {
            }

            @Override // yc5.b.a
            public final String getModule() {
                return "home";
            }

            @Override // yc5.b.a
            public final String m6() {
                return "recent";
            }
        }

        @Override // com.bytedance.ee.bear.lark.header.h
        public final Map<com.bytedance.ee.bear.lark.header.i, Integer> getHeaders() {
            return this.f227518a;
        }

        public b(DocTabFragment r100) {
            Intrinsics.checkNotNullParameter(r100, "homePageFragment");
            LinkedHashMap r101 = new LinkedHashMap();
            this.f227518a = r101;
            r101.put(new m(true), 0);
            r101.put(new com.bytedance.ee.bear.lark.header.l(new a()), 1);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, pd5.a.InterfaceC7184a
    public final void L2() {
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void ka0(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final boolean na0() {
        return false;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, wc5.f.a
    public final void Qi() {
        ConnectionService.NetworkState r100 = this.K;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.a() != true) goto L7;
    L8:
        if (r101 == false) goto L22;
        String r102 = "manual_offline";
        if (this.f227191y != 2) goto L17;
        Bundle r103 = new Bundle();
        if (this.f227191y == 2) goto L15;
        r102 = "recent";
    L15:
        r103.putString("key_token", r102);
        r103.putParcelable("key_sort_strategy", this.f227190x);
        r103.putBoolean("key_sort_asc_enable", false);
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r103);
        return;
    L17:
        Bundle r104 = new Bundle();
        if (this.f227191y == 2) goto L21;
        r102 = "recent";
    L21:
        r104.putString("key_token", r102);
        r104.putParcelable("key_sort_strategy", this.f227189w);
        r104.putBoolean("key_sort_asc_enable", false);
        r104.putInt("key_default_sort_pos", 2);
        r104.putInt("maxWidth", n.d(450));
        ActionSheetDialogFragment.ba0(getActivity(), SortFragment.class, r104);
        return;
    L22:
        Context r105 = this.mContext;
        Toast.showFailureText(r105, r105.getString(R.string.Doc_Facade_Offline), 0);
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final com.bytedance.ee.bear.lark.header.h Z90() {
        return new b(this);
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, wc5.f.a
    public final void eF() {
        ConnectionService.NetworkState r100 = this.K;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.a() != true) goto L7;
    L8:
        if (r101 == false) goto L34;
        String r102 = "manual_offline";
        if (this.f227191y != 2) goto L26;
        Bundle r103 = getArguments();
        if (r103 == null) goto L14;
        r103.putString("key_module", m6());
    L14:
        if (r103 == null) goto L16;
        r103.putString("key_token", "manual_offline");
    L16:
        if (r103 == null) goto L18;
        r103.putParcelable("key_sort_strategy", this.f227190x);
    L18:
        if (r103 == null) goto L20;
        r103.putBoolean("key_sort_filter_enable", false);
    L20:
        if (r103 == null) goto L22;
        r103.putBoolean("key_reset_enable", false);
    L22:
        if (r103 == null) goto L24;
        r103.putBoolean("key_done_enable", false);
    L24:
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r103);
        return;
    L26:
        Bundle r104 = getArguments();
        if (r104 != null) goto L29;
        r104 = new Bundle();
    L29:
        r104.putString("key_module", "home");
        r104.putString("key_sub_module", m6());
        if (this.f227191y == 2) goto L33;
        r102 = "recent";
    L33:
        r104.putString("key_token", r102);
        r104.putBoolean("key_sort_filter_enable", false);
        r104.putBoolean("key_sort_asc_enable", false);
        r104.putBoolean("key_reset_enable", false);
        r104.putBoolean("key_done_enable", false);
        r104.putInt("key_sort_title_res", R.string.Doc_List_Filter_Recent_Activity);
        r104.putParcelable("key_sort_strategy", this.f227189w);
        r104.putInt("maxWidth", n.d(450));
        ActionSheetDialogFragment.ba0(getActivity(), SortAndFilterFragment.class, r104);
        return;
    L34:
        Toast.showFailureText(getContext(), getString(R.string.Doc_Facade_Offline), 0);
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final ad5.f ea0() {
        return new yd5.b();
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final ViewGroup getRootView() {
        ViewGroup r100 = this.S;
        if (r100 == null) goto L7;
        if (r100 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L12:
        return r100;
    L7:
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.sidebar_home_fragment, null);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r102 = (ViewGroup) r101;
        this.S = r102;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L11:
        return r102;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, wc5.c
    public final String m6() {
        int r100 = this.f227191y;
        if (r100 != 0) goto L6;
        return "recent";
    L6:
        if (r100 != 2) goto L8;
        return OperationName.OPERATION_OFFLINE_AVAILABLE;
    L8:
        return "catalogue";
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void va0() {
        Bundle r100 = new Bundle();
        ce5.a r101 = new ce5.a(this);
        Context r102 = getContext();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r101, "userComponentAbility");
        CommonMorePanelData r103 = null;
        if (r102 == null) goto L10;
        CommonMorePanelItemData r104 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("SHARE_WITH_ME", "<set-?>");
        r104.f216780a = "SHARE_WITH_ME";
        r104.f216781b = R.drawable.icon_group_outlined;
        r104.a(r102.getResources().getString(R.string.Doc_List_Share_With_Me));
        BenefitStore r105 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1();
        boolean r106 = r105.hasBenefit("ccm_create_doc");
        boolean r107 = r105.hasBenefit("ccm_create_base");
        CommonMorePanelItemData r108 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("TEMPLATE", "<set-?>");
        r108.f216780a = "TEMPLATE";
        r108.f216781b = R.drawable.ud_icon_template_outlined;
        r108.a(r102.getResources().getString(R.string.CreationMobile_Onboarding_Templates_Button));
        CommonMorePanelItemData r109 = new CommonMorePanelItemData();
        Intrinsics.checkNotNullParameter("OFFLINE", "<set-?>");
        r109.f216780a = "OFFLINE";
        r109.f216781b = R.drawable.ud_icon_offline_outlined;
        r109.a(r102.getResources().getString(R.string.Doc_List_OfflineTitle));
        ArrayList<CommonMorePanelItemData> r110 = CollectionsKt.arrayListOf(new CommonMorePanelItemData[]{r104, r108});
        qc5.b.a(r101);
        if (r106 == true) goto L9;
        if (r107 == true) goto L9;
        r110.remove(r108);
    L9:
        r103 = new CommonMorePanelData();
        String r111 = r102.getResources().getString(R.string.LarkCCM_NewCM_Mobile_MoreOptions_Title);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r103.f216773a = r111;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r103.f216775c = r110;
    L10:
        if (r103 == null) goto L12;
        r100.putParcelable("panel_data", r103);
        r100.putInt("maxWidth", n.d(450));
        ActionSheetDialogFragment.ba0(getActivity(), CommonMorePanelFragment.class, r100);
    L12:
        lc5.f.a r112 = lc5.f.f508440a;
        p r113 = new p("home", m6(), "more", "", "", "ccm_space_home_page_click");
        Intrinsics.checkNotNullParameter(r113, "param");
        r112.I(r113);
    }

    public SidebarDocTabFragment() {
        int r100 = CCMPlaceHolderFragment.f227169o;
        this.W = ForsetiViewMode.UNKNOWN;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void V90() {
        z.b().getClass();
        z.a(new String[]{"key_open_finish_content", "key_open_finish_recent"});
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return new ce5.a().f23447b;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Disposable r100 = this.Q;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.X = false;
        this.G = false;
        tt5.a.h("SidebarDocTabFragment", "onDestroyView() called");
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        SidebarNavigationView r100 = this.M;
        if (r100 == null) goto L33;
        boolean r101 = false;
        r100.f229606p = false;
        sc5.i r102 = r100.f229605o;
        if (r102 == null) goto L11;
        Dialog r103 = r102.f541350d;
        if (r103 == null) goto L11;
        if (r103.isShowing() != true) goto L11;
        r101 = true;
    L11:
        if (r101 == false) goto L37;
        tt5.a.h("SideBarNavigationView", "switch tab dismiss onboarding");
        sc5.i r104 = r100.f229605o;
        if (r104 == null) goto L38;
        Dialog r105 = r104.f541350d;
        if (r105 == null) goto L39;
        Handler r106 = DialogLancet.resolveDialogHandler(r105);
        if (r106 != null) goto L19;
    L21:
        DialogLancet.beforeDialogDismiss(r105);
        r105.dismiss();     // Catch: Throwable -> L24 Exception -> L26
    L30:
        DialogLancet.afterDialogDismiss(r105);
        return;
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L24
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L24
        if (r107 == null) goto L30;
        com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r105);
        throw th;
    L19:
        if (Looper.myLooper() == r106.getLooper()) goto L21;
        r106.post(DialogLancet.createDismissRunnable(r105));
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        SidebarNavigationView r100 = this.M;
        if (r100 == null) goto L6;
        r100.f229606p = true;
    L6:
        if (this.V == false) goto L10;
        lc5.f.f508440a.N("ccm_space_sidebar_view", "home", m6(), m6(), "", "");
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void pa0() {
        qc5.a.k();
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, wc5.c
    public final SmartRefreshLayout xZ() {
        return this.H;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void Aa0(boolean r100) {
        SidebarHomeSubMenuView r101 = this.I;
        if (r101 == null) goto L11;
        ImageView r102 = r101.f229625b;
        if (r102 == null) goto L12;
        if (r100 == false) goto L8;
        int r103 = 0;
    L9:
        r102.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, dd5.p1
    public final void Mj(boolean r100) {
        t3.f229771a = r100;
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void ma0(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        tt5.a.h("SidebarDocTabFragment", "initView() called with: rootView = " + r100);
        la0(r100);
        ha0(r100);
        ia0(r100);
        if (ForsetiHelper.n() == false) goto L5;
    L7:
        sa0();
        pd5.a.a(this);
        this.f227178l = true;
        t.a();
        if (this.A == false) goto L10;
        x.c().h("doc_tab_fragment_init");
    L10:
        t3.f229771a = LarkKVStorage.h(new com.ss.android.lark.storage.a(Biz.DOCS.getValue()), true).getBoolean("is_grid", false);
        s1.a.f468004a.a(this);
        return;
    L5:
        if (this.G == true) goto L7;
        Ca0(r100, false);
        goto L7
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment
    public final void ua0(FolderSortStrategy r100) {
        if (r100 == null) goto L4;
        String r101 = r100.f227680a;
    L6:
        if (TextUtils.equals("manual_offline", r101) == false) goto L8;
        this.f227190x = r100;
    L9:
        SidebarHomeSubMenuView r102 = this.I;
        if (r102 == null) goto L13;
        r102.a(Y90(r100));
        return;
    L13:
        return;
    L8:
        this.f227189w = r100;
        goto L9
    L4:
        r101 = null;
        goto L6
    }

    public final void Ca0(ViewGroup r100, boolean r101) {
        this.G = true;
        by4.d r102 = this.O;
        MagicIndicator r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        r102 = null;
    L6:
        int r104 = 0;
        if (r102 == null) goto L11;
        com.ss.android.lark.storage.kv.repo.a r105 = r102.b("platform");
        if (r105 == null) goto L11;
        int r106 = r105.getInt("last_select_tab", 0);
    L12:
        this.f227191y = r106;
        tt5.a.h("SidebarDocTabFragment", "initViewPager() called with: rootView = " + r100 + ", isPadMode = " + r101 + " mCurrentItem:" + this.f227191y);
        this.f227181o = (ViewPager) r100.findViewById(R.id.list_home_viewpager);
        List<ad5.e> r107 = new yd5.b().a(r101);
        Intrinsics.checkNotNull(r107);
        this.I = (SidebarHomeSubMenuView) r100.findViewById(R.id.home_sub_title_view);
        if (ForsetiHelper.n() == false) goto L18;
        if (r101 == false) goto L18;
        SidebarHomeSubMenuView r108 = this.I;
        if (r108 == null) goto L47;
        r108.setVisibility(8);
    L47:
        HomeTabAdapter r109 = this.f227182p;
        if (r109 == null) goto L51;
        r109.f228340b.clear();
        this.f227182p.f228340b.addAll(r107);
        this.f227182p.notifyDataSetChanged();
        return;
    L51:
        HomeTabAdapter r110 = new HomeTabAdapter(getChildFragmentManager(), getContext(), r107, X90());
        this.f227182p = r110;
        ViewPager r111 = this.f227181o;
        if (r111 == null) goto L54;
        r111.setAdapter(r110);
    L54:
        ViewPager r112 = this.f227181o;
        if (r112 == null) goto L57;
        r112.setCurrentItem(this.f227191y);
    L57:
        ViewPager r113 = this.f227181o;
        if (r113 == null) goto L61;
        r113.setOffscreenPageLimit(1);
        return;
    L61:
        return;
    L18:
        SidebarHomeSubMenuView r114 = this.I;
        if (r114 == null) goto L21;
        r114.setVisibility(0);
    L21:
        SidebarHomeSubMenuView r115 = this.I;
        if (r115 == null) goto L24;
        r103 = r115.getMagicIndicator();
    L24:
        wuc.a r116 = new wuc.a(getContext());
        r116.setAdapter(new j(getContext(), r103, r107, new com.bytedance.ee.bear.lark.sidebar.a(this)));
        if (r103 == null) goto L27;
        r103.setNavigator(r116);
    L27:
        if (r103 == null) goto L29;
        r103.b(this.f227191y);
    L29:
        int r117 = this.f227191y;
        if (r117 != 0) goto L32;
    L35:
        boolean r118 = true;
    L36:
        SidebarHomeSubMenuView r119 = this.I;
        if (r119 == null) goto L44;
        ImageView r120 = r119.f229625b;
        if (r120 == null) goto L44;
        if (r118 == true) goto L43;
        r104 = 8;
    L43:
        r120.setVisibility(r104);
    L44:
        SidebarHomeSubMenuView r121 = this.I;
        if (r121 == null) goto L47;
        r121.setOnSortAndFilterClickListener(new SidebarDocTabFragment$initHomeMenu$1(this));
        goto L47
    L32:
        if (r117 == 2) goto L35;
        r118 = false;
    L11:
        r106 = 0;
        goto L12
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.X = true;
        this.H = (SmartRefreshLayout) r100.findViewById(R.id.sidebar_smart_refresh_layout);
        vd5.d r102 = new vd5.d(r100.getContext());
        SmartRefreshLayout r103 = this.H;
        if (r103 == null) goto L5;
        r103.G(r102, n.d(60));
    L5:
        SmartRefreshLayout r104 = this.H;
        if (r104 == null) goto L8;
        r104.W = new com.bytedance.ee.bear.lark.sidebar.b(this, r104);
    L8:
        this.f227517J = r100.findViewById(R.id.no_net_container);
        SidebarNavigationView r105 = (SidebarNavigationView) r100.findViewById(R.id.navigation);
        this.M = r105;
        if (r105 == null) goto L11;
        r105.setOnItemClickCallback(new AnonymousClass1(this));
    L11:
        ForsetiViewModel r106 = this.R;
        if (r106 == null) goto L14;
        tua.b r107 = r106.getForsetiChainManager();
    L15:
        if (r107 != null) goto L17;
    L20:
        SidebarNavigationView r108 = this.M;
        if (r108 == null) goto L23;
        r108.v(this, new ce5.a(this), false, this.U);
    L23:
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(getViewLifecycleOwner(), new h(this));
        qa0();
        FragmentActivity r109 = getActivity();
        if (r109 == null) goto L35;
        CommonMorePanelViewModel r110 = (CommonMorePanelViewModel) new ViewModelProvider(r109).get(CommonMorePanelViewModel.class);
        this.L = r110;
        if (r110 == null) goto L30;
        MutableLiveData<CommonMorePanelItemData> r111 = r110.getSelectData();
        if (r111 == null) goto L30;
        r111.observe(getViewLifecycleOwner(), new d(this));
    L30:
        CommonMorePanelViewModel r112 = this.L;
        if (r112 == null) goto L35;
        MutableLiveData<Boolean> r113 = r112.getTriggerResetData();
        if (r113 == null) goto L35;
        r113.observe(getViewLifecycleOwner(), new g(this));
    L35:
        ra0();
        return;
    L17:
        if (ForsetiHelper.n() == false) goto L20;
        if (ForsetiHelper.s(this) == true) goto L23;
    L14:
        r107 = null;
        goto L15
    }

    @Override // com.bytedance.ee.bear.lark.DocTabFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        tt5.a.h("SidebarDocTabFragment", "onCreateView: ");
        if (ForsetiHelper.n() == false) goto L10;
        ForsetiViewModel r103 = (ForsetiViewModel) new ViewModelProvider(this, new ForsetiViewModelFactory(requireActivity())).get(ForsetiViewModel.class);
        this.R = r103;
        if (r103 == null) goto L10;
        LiveData<ForsetiViewMode> r104 = r103.getViewMode();
        if (r104 == null) goto L10;
        r104.observe(getViewLifecycleOwner(), new c(this));
    L10:
        return super.onCreateView(r100, r101, r102);
    }
}
