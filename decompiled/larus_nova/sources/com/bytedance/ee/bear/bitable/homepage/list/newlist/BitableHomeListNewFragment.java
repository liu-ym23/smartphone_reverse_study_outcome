package com.bytedance.ee.bear.bitable.homepage.list.newlist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.homepage.j0;
import com.bytedance.ee.bear.bitable.homepage.k0;
import com.bytedance.ee.bear.bitable.homepage.l0;
import com.bytedance.ee.bear.bitable.homepage.list.BitablePinFragmentV4;
import com.bytedance.ee.bear.bitable.homepage.list.BitableRecentFragmentV4;
import com.bytedance.ee.bear.bitable.homepage.list.a1;
import com.bytedance.ee.bear.bitable.homepage.list.workspace.BitableWorkSpaceFragment;
import com.bytedance.ee.bear.bitable.homepage.list.z0;
import com.bytedance.ee.bear.bitable.homepage.n0;
import com.bytedance.ee.bear.bitable.homepage.recommend.widget.BitableRecommendHeaderView;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.workspace.HomepageListType;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import cqa.h;
import dd5.p1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import sa5.t;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 w2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001wB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020@H\u0002J$\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020FH\u0002J\b\u0010I\u001a\u00020>H\u0002J\b\u0010J\u001a\u00020>H\u0002J\u0010\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u000207H\u0002J\u0010\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020\u0011H\u0016J\n\u0010O\u001a\u0004\u0018\u00010/H\u0002J\b\u0010P\u001a\u00020>H\u0016J\b\u0010Q\u001a\u00020>H\u0016J\b\u0010R\u001a\u00020>H\u0016J\b\u0010S\u001a\u00020>H\u0016J\b\u0010T\u001a\u00020\u000bH\u0016J\b\u0010U\u001a\u00020\u000bH\u0016J\b\u0010V\u001a\u00020>H\u0016J\u0018\u0010W\u001a\u00020>2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020YH\u0016J\b\u0010[\u001a\u00020\u0017H\u0016J\u0010\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020\u0011H\u0016J\b\u0010^\u001a\u00020>H\u0016J\b\u0010_\u001a\u00020>H\u0002J\b\u0010`\u001a\u00020>H\u0002J\u0010\u0010e\u001a\u00020>2\u0006\u0010f\u001a\u00020\u000bH\u0016J\b\u0010g\u001a\u00020\u0011H\u0016J\b\u0010h\u001a\u00020\u000bH\u0016J\b\u0010i\u001a\u00020\u000bH\u0016J\b\u0010j\u001a\u00020>H\u0016J\b\u0010k\u001a\u00020\u0011H\u0016J\u0010\u0010l\u001a\u00020>2\u0006\u0010m\u001a\u00020%H\u0016J\u0010\u0010n\u001a\u00020>2\b\b\u0002\u0010o\u001a\u00020\u0011J\n\u0010p\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010q\u001a\u0004\u0018\u00010rH\u0016J\b\u0010s\u001a\u00020>H\u0016J\u0010\u0010t\u001a\u00020>2\u0006\u0010u\u001a\u00020\u0011H\u0016J\b\u0010v\u001a\u00020>H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u000e\u0010#\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020<0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\rR\u0014\u0010c\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010\r¨\u0006x"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/list/newlist/BitableHomeListNewFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/list/homepage/IHomeFragment;", "Lcom/bytedance/ee/bear/list/preload/FirstContentDrawDispatcher$OnFirstContentDrawListener;", "Lcom/bytedance/ee/bear/bitable/homepage/IListContainer;", "Lcom/bytedance/ee/bear/list/list/SpaceNotificationService$OnSwitchGridListener;", "Lcom/bytedance/ee/bear/list/homepage/IDocTabFragment;", "Lcom/bytedance/ee/bear/bitable/homepage/list/HomeListView;", "<init>", "()V", "hpFrom", "", "getHpFrom", "()Ljava/lang/String;", "setHpFrom", "(Ljava/lang/String;)V", "isFromWorkbench", "", "()Z", "setFromWorkbench", "(Z)V", "hasInit", "refreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "networkState", "Lcom/bytedance/ee/bear/contract/ConnectionService$NetworkState;", "homeViewContainer", "Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;", "getHomeViewContainer", "()Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;", "setHomeViewContainer", "(Lcom/bytedance/ee/bear/bitable/homepage/IHomeViewContainer;)V", "fullScreen", "getFullScreen", "setFullScreen", "isUserVisibleHintInternal", "refreshListener", "Lcom/bytedance/ee/bear/bitable/homepage/IRefreshListener;", "tvCurrentTabTitle", "Landroid/widget/TextView;", "topBar", "Landroid/view/View;", "fragmentContainer", "Landroid/widget/FrameLayout;", "childFragments", "", "Lcom/bytedance/ee/bear/workspace/HomepageListType;", "Landroidx/fragment/app/Fragment;", "sharedViewModel", "Lcom/bytedance/ee/bear/bitable/homepage/list/newlist/SharedBitableHomeListNewViewModel;", "getSharedViewModel", "()Lcom/bytedance/ee/bear/bitable/homepage/list/newlist/SharedBitableHomeListNewViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "selectedInfo", "Lcom/bytedance/ee/bear/workspace/SelectedListInfo;", "homepageContainer", "Lcom/bytedance/lark/lark_bitable_android/HomepageContainer;", "subFragmentMetas", "", "Lcom/bytedance/ee/bear/bitable/homepage/list/newlist/FragmentMeta;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "getArgumentsWithUserSession", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "initView", "rootView", "initRefreshLayoutInternal", "showSelectionPopup", "switchFragment", "info", "setUserVisibleHint", "isVisibleToUser", "getActiveFragment", "onResume", "onPause", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "getModule", "getSubModule", "refreshHeader", "onViewScrollBy", "dx", "", "dy", "getRefreshLayout", "onSwitchGrid", GXViewKey.VIEW_TYPE_CONTAINER_GRID, "onFirstContentDraw", "observeNetwork", "reportHomePageView", "containerEnv", "getContainerEnv", "homePageFromForReport", "getHomePageFromForReport", "onMenuCreateClick", "clickFrom", "isWorkBench", "getContainerScene", "getFrom", "onCoverViewClick", "isFullScreen", "setOnRefreshListener", "listener", "finishRefresh", "success", "getTraceId", "getHomePageDelegate", "Lcom/bytedance/ee/bear/bitable/homepage/IBitableHomeV4Delegate;", "scrollToTop", "notifyVisibleHintChange", "visible", "refreshData", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableHomeListNewFragment extends BaseFragment implements wc5.d, pd5.a.InterfaceC7184a, l0, p1, wc5.c, z0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f212814t = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f212815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f212816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f212817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SmartRefreshLayout f212818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k0 f212819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f212820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f212821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public n0 f212822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f212823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f212824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f212825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<HomepageListType, Fragment> f212826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f212827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public er5.g f212828r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<HomepageListType, e> f212829s;

    public static final class a {
        public static BitableHomeListNewFragment a(String r100, boolean r101, boolean r102) {
            BitableHomeListNewFragment r103 = new BitableHomeListNewFragment();
            Bundle r104 = new Bundle();
            r104.putString("hp_from", r100);
            r104.putBoolean("is_from_workbench", r101);
            r104.putBoolean("full_screen", r102);
            PassportcConvention.h(r104, com.bytedance.ee.bear.bitable.core.usercomponent.b.a().z4());
            r103.setArguments(r104);
            return r103;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f212830a = null;

        static {
            int[] r100 = new int[HomepageListType.values().length];
            r100[HomepageListType.PINNED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[HomepageListType.RECENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[HomepageListType.WORK_SPACE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f212830a = r100;
        }
    }

    public static final class c implements gqa.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableHomeListNewFragment f212831a;

        public c(BitableHomeListNewFragment r100) {
            this.f212831a = r100;
        }

        @Override // gqa.d
        public final void d2(h r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            n0 r101 = this.f212831a.f212822l;
            if (r101 == null) goto L6;
            r101.onRefresh();
            return;
        }
    }

    static {
    }

    @Override // wc5.d
    public final void Cu() {
    }

    @Override // wc5.d
    public final void t(int r100, int r101) {
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final j0 F2() {
        k0 r100 = this.f212819i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.F2();
    }

    @Override // pd5.a.InterfaceC7184a
    public final void L2() {
        tt5.a.h("BitableHomeListNewFragment", "onFirstContentDraw");
        j r100 = j.a.f217090a;
        if (r100 == null) goto L8;
        LiveData<ConnectionService.NetworkState> r101 = r100.a();
        if (r101 == null) goto L9;
        r101.observe(getViewLifecycleOwner(), new d(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final String Sv() {
        if (this.f212816f == false) goto L5;
        return "workbench";
    L5:
        return "larktab_bitable";
    }

    public final Fragment U90() {
        er5.g r100 = this.f212828r;
        if (r100 == null) goto L7;
        HomepageListType r101 = r100.getType();
        if (r101 == null) goto L7;
        return (Fragment) ((LinkedHashMap) this.f212826p).get(r101);
    L7:
        return null;
    }

    public final void V90() {
        if (this.f212821k == true) goto L5;
        return;
    L5:
        if (this.f212817g == false) goto L25;
        tt5.a.h("BitableHomeListNewFragment", "reportHomePageView: isFullScreen=" + this.f212820j);
        er5.g r100 = this.f212828r;
        if (r100 == null) goto L9;
        HomepageListType r101 = r100.getType();
    L11:
        if (r101 != HomepageListType.WORK_SPACE) goto L13;
        return;
    L13:
        lc5.f.a r102 = lc5.f.f508440a;
        String r103 = m6();
        boolean r104 = this.f212816f;
        if (r104 == false) goto L16;
        String r105 = "workbench";
    L17:
        if (r104 == false) goto L21;
        String r106 = this.f212815e;
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        lc5.f.a.F(r103, r105, r106, Boolean.valueOf(this.f212820j));
        return;
    L21:
        r106 = "lark_tab";
        goto L22
    L16:
        r105 = "larktab_bitable";
        goto L17
    L9:
        r101 = null;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final String getFrom() {
        if (this.f212816f == false) goto L7;
        String r100 = this.f212815e;
        if (r100 != null) goto L9;
        return "";
    L9:
        return r100;
    L7:
        return "lark_tab";
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final String getTraceId() {
        k0 r100 = this.f212819i;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTraceId();
    }

    @Override // wc5.c
    public final String m6() {
        er5.g r100 = this.f212828r;
        if (r100 == null) goto L5;
        HomepageListType r101 = r100.getType();
    L6:
        if (r101 != null) goto L8;
        int r102 = -1;
    L10:
        if (r102 != 1) goto L12;
        return "quick_access";
    L12:
        if (r102 != 2) goto L14;
        return "recent";
    L14:
        if (r102 != 3) goto L21;
        return "workspace";
    L21:
        return "recent";
    L8:
        r102 = b.f212830a[r101.ordinal()];
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final void o00() {
        k0 r100 = this.f212819i;
        if (r100 == null) goto L6;
        r100.AJ();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        tt5.a.h("BitableHomeListNewFragment", "onDestroyView()...");
        this.f212817g = false;
        this.f212823m = null;
        this.f212824n = null;
        pd5.a.c(this);
        super.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.z0
    public final void refreshData() {
        n0 r100 = this.f212822l;
        if (r100 == null) goto L6;
        r100.onRefresh();
        return;
    }

    @Override // wc5.c
    public final SmartRefreshLayout xZ() {
        SmartRefreshLayout r100 = this.f212818h;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        return null;
    L6:
        return r100;
    }

    public BitableHomeListNewFragment() {
        this.f212820j = true;
        this.f212826p = new LinkedHashMap();
        this.f212827q = LazyKt.lazy(new BitableHomeListNewFragment$sharedViewModel$2(this));
        HomepageListType r100 = HomepageListType.RECENT;
        HomepageListType r101 = HomepageListType.PINNED;
        HomepageListType r102 = HomepageListType.WORK_SPACE;
        this.f212829s = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, new e(r100, BitableRecentFragmentV4.class.getName(), Integer.valueOf(R.string.Bitable_GroupChat_Recents_Title))), TuplesKt.to(r101, new e(r101, BitablePinFragmentV4.class.getName(), Integer.valueOf(R.string.Bitable_Homepage_Pins_Tab))), TuplesKt.to(r102, new e(r102, BitableWorkSpaceFragment.class.getName(), null))});
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("BitableHomeListNewFragment", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        tt5.a.h("BitableHomeListNewFragment", "onPause");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        tt5.a.h("BitableHomeListNewFragment", "onResume, isUserVisibleHintInternal: " + this.f212821k);
        if (this.f212821k == false) goto L6;
        V90();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.a1
    public final void t0() {
        ActivityResultCaller r100 = U90();
        if ((r100 instanceof a1) == false) goto L6;
        ((a1) r100).t0();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final boolean isFullScreen() {
        return this.f212820j;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final boolean rl() {
        return this.f212816f;
    }

    @Override // dd5.p1
    public final void Mj(boolean r100) {
        t3.f229771a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final void Sz(String r100) {
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        k0 r101 = this.f212819i;
        if (r101 == null) goto L6;
        r101.WD(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.list.z0
    public final void UG(boolean r100) {
        tt5.a.h("BitableHomeListNewFragment", "notifyVisibleHintChange: " + r100);
        setUserVisibleHint(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        this.f212815e = r101.getString("hp_from");
        this.f212816f = r101.getBoolean("is_from_workbench", false);
        this.f212820j = r101.getBoolean("full_screen", true);
    L5:
        tt5.a.h("BitableHomeListNewFragment", "onCreate: hpFrom=" + this.f212815e + ", isFromWorkbench=" + this.f212816f + ", fullScreen=" + this.f212820j);
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.l0
    public final void pB(n0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f212822l = r100;
        SmartRefreshLayout r101 = this.f212818h;
        if (r101 == null) goto L8;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r101 = null;
    L6:
        r101.W = new c(this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        this.f212821k = r100;
        tt5.a.h("BitableHomeListNewFragment", "setUserVisibleHint: " + r100 + ", hasInit: " + this.f212817g);
        if (this.f212817g == true) goto L5;
        return;
    L5:
        Fragment r101 = U90();
        if (r101 == null) goto L8;
        r101.setUserVisibleHint(r100);
    L8:
        if (r100 == false) goto L11;
        V90();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        tt5.a.h("BitableHomeListNewFragment", "onCreateView");
        int r103 = 0;
        View r104 = r100.inflate(R.layout.fragment_bitable_home_list_new, r101, false);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r105 = (ViewGroup) r104;
        tt5.a.h("BitableHomeListNewFragment", "initView()...rootView = " + r105);
        this.f212818h = (SmartRefreshLayout) r105.findViewById(R.id.list_refresh_layout_alt);
        tt5.a.h("BitableHomeListNewFragment", "initRefreshLayoutInternal()...");
        SmartRefreshLayout r106 = this.f212818h;
        SmartRefreshLayout r107 = null;
        Object[] r108 = 0;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r106 = null;
    L5:
        r106.G(new BitableRecommendHeaderView(requireContext(), r108 == true ? 1 : 0, 6, r103), -2);
        SmartRefreshLayout r109 = this.f212818h;
        if (r109 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r109 = null;
    L8:
        r109.g(false);
        SmartRefreshLayout r110 = this.f212818h;
        if (r110 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r110 = null;
    L11:
        r110.I = false;
        SmartRefreshLayout r111 = this.f212818h;
        if (r111 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r111 = null;
    L14:
        r111.f405859J = false;
        SmartRefreshLayout r112 = this.f212818h;
        if (r112 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        r112 = null;
    L17:
        r112.A = true;
        SmartRefreshLayout r113 = this.f212818h;
        if (r113 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
    L21:
        r107.W = new com.bytedance.ee.bear.bitable.homepage.list.newlist.a(this);
        this.f212823m = (TextView) r105.findViewById(R.id.tv_current_tab_title);
        this.f212824n = r105.findViewById(R.id.top_bar);
        this.f212825o = (FrameLayout) r105.findViewById(R.id.fragment_container);
        View r114 = this.f212824n;
        if (r114 == null) goto L24;
        r114.setOnClickListener(new com.bytedance.ee.bear.bitable.homepage.list.newlist.b(this));
    L24:
        ImageView r115 = (ImageView) r105.findViewById(R.id.iv_dropdown_arrow_alt);
        Context r116 = getContext();
        if (r116 == null) goto L27;
        r115.setImageDrawable(UDIconUtils.getIconDrawable(r116, R.drawable.ud_icon_down_small_ccm_outlined, r116.getResources().getColor(R.color.icon_n1)));
    L27:
        pd5.a.a(this);
        this.f212817g = true;
        ((SharedBitableHomeListNewViewModel) this.f212827q.getValue()).getSelectedInfoData().observe(this, new com.bytedance.ee.bear.bitable.homepage.list.newlist.c(this));
        t.a();
        return r104;
    L20:
        r107 = r113;
        goto L21
    }
}
