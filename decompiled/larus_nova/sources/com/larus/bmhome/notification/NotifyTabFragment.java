package com.larus.bmhome.notification;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ixigua.lib.track.TrackParams;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.chat.resp.Notice;
import com.larus.bmhome.notification.adapter.NotificationListAdapter;
import com.larus.bmhome.notification.viewmodel.BannerViewModel;
import com.larus.bmhome.notification.viewmodel.NotificationListViewModel;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.z;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.home.api.main.HomeService;
import com.larus.notify.impl.databinding.LarusPageNotificationBinding;
import com.larus.nova.R;
import com.larus.platform.api.IFlowCreationThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.o3;
import v19.y6;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001,\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001_B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010\"H\u0016J\b\u00100\u001a\u00020 H\u0002J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u00107\u001a\u00020 2\u0006\u00108\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u00010\"H\u0016J\b\u00109\u001a\u00020 H\u0002J\b\u0010:\u001a\u00020 H\u0002J\b\u0010;\u001a\u00020 H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020 H\u0016J\b\u0010@\u001a\u00020 H\u0016J\b\u0010A\u001a\u00020 H\u0016J\b\u0010B\u001a\u00020\u0019H\u0002J.\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u00142\b\b\u0002\u0010F\u001a\u00020\u00142\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u00020\u0019H\u0016J\b\u0010J\u001a\u00020\u0014H\u0016J\n\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020\u0019H\u0016J\b\u0010N\u001a\u00020OH\u0016J\u0012\u0010P\u001a\u00020 2\b\u0010Q\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010R\u001a\u00020 H\u0016J \u0010S\u001a\u00020 2\u0006\u0010T\u001a\u00020\u00142\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010VH\u0016J\b\u0010W\u001a\u00020\u0014H\u0002J,\u0010X\u001a\u00020 2\b\u0010Y\u001a\u0004\u0018\u0001022\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020]H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006`"}, d2 = {"Lcom/larus/bmhome/notification/NotifyTabFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "Lcom/larus/bmhome/ISideBarChildFragment;", "<init>", "()V", "binding", "Lcom/larus/notify/impl/databinding/LarusPageNotificationBinding;", "viewModel", "Lcom/larus/bmhome/notification/viewmodel/NotificationListViewModel;", "getViewModel", "()Lcom/larus/bmhome/notification/viewmodel/NotificationListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bannerViewModel", "Lcom/larus/bmhome/notification/viewmodel/BannerViewModel;", "getBannerViewModel", "()Lcom/larus/bmhome/notification/viewmodel/BannerViewModel;", "bannerViewModel$delegate", "clickItem", "", "isFirstCreate", "listAdapter", "Lcom/larus/bmhome/notification/adapter/NotificationListAdapter;", "enterMethod", "", "outerInputController", "Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "getOuterInputController", "()Lcom/larus/bmhome/chat/outerinput/IOuterChatInputController;", "outerInputController$delegate", "onNewIntent", "", "bundle", "Landroid/os/Bundle;", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "isSideBar", "()Z", "isSideBar$delegate", "appJustForeground", "wentBackgroundFromThisFragment", "isInTabForeground", "appBackgroundListener", "com/larus/bmhome/notification/NotifyTabFragment$appBackgroundListener$1", "Lcom/larus/bmhome/notification/NotifyTabFragment$appBackgroundListener$1;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "refreshNotificationList", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "startCreateBot", "initViewModel", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "onResume", "onPause", "onDestroyView", "getEnterMethod", "refresh", "withLoading", "showRetryPage", "fromResume", "downgradeSource", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "getCurrentPageName", "autoLogEnterPage", "parentTrackNode", "Lcom/ixigua/lib/track/ITrackNode;", "getPageName", "tabIndex", "", "onEnterTab", "previousPage", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "isNotifyActivity", "openLongClickMenu", "anchor", "notice", "Lcom/larus/bmhome/chat/resp/Notice;", "clickX", "", "clickY", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifyTabFragment extends BaseHomeTabFragment implements s19.a, z {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f313424w = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LarusPageNotificationBinding f313425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f313426k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f313427l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f313428m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f313429n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final NotificationListAdapter f313430o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f313431p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final et3.c f313432q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f313433r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f313434s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f313435t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f313436u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f313437v;

    public static final class a {
    }

    public static final class b implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NotifyTabFragment f313438a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            NotifyTabFragment r100 = this.f313438a;
            r100.f313435t = r100.f313436u;
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            if (Intrinsics.areEqual(AppHost.f326268a.a().getCurrentActivity(), this.f313438a.getActivity()) == false) goto L6;
            this.f313438a.f313434s = true;
            return;
        }

        public b(NotifyTabFragment r100) {
            this.f313438a = r100;
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f313439a;

        public c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f313439a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f313439a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f313439a.invoke(r100);
        }
    }

    static {
    }

    public NotifyTabFragment() {
        super(false);
        final Function0<Fragment> r100 = new NotifyTabFragment$special$$inlined$viewModels$default$1(this);
        this.f313426k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationListViewModel.class), new NotifyTabFragment$special$$inlined$viewModels$default$2(r100), new NotifyTabFragment$special$$inlined$viewModels$default$3(r100, this));
        final Function0<Fragment> r101 = new NotifyTabFragment$special$$inlined$viewModels$default$4(this);
        this.f313427l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BannerViewModel.class), new NotifyTabFragment$special$$inlined$viewModels$default$5(r101), new NotifyTabFragment$special$$inlined$viewModels$default$6(r101, this));
        this.f313429n = true;
        this.f313430o = new NotificationListAdapter(new FPagingAdapter.a(new e(this)), getLifecycle(), this);
        this.f313431p = LazyKt.lazy(new p(this));
        this.f313432q = new et3.c("List_NotifyTab", false, null);
        this.f313433r = LazyKt.lazy(new r(this));
        this.f313437v = new b(this);
    }

    @Override // s19.a
    public final void KC(boolean r100, Function0<Unit> r101) {
    }

    @Override // s19.a
    public final void a2(Bundle r100) {
    }

    @Override // com.larus.bmhome.z
    public final void pp(String r100) {
    }

    @Override // s19.a
    public final void t1() {
        this.f313436u = false;
    }

    public final NotificationListViewModel Y90() {
        return (NotificationListViewModel) this.f313426k.getValue();
    }

    @Override // s19.a
    public final int sb() {
        return BaseHomeTabFragment.MainTab.NOTIFY.getIndex();
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return Z90();
    }

    public final boolean Z90() {
        if ((getActivity() instanceof NotifyActivity) == false) goto L5;
    L8:
        return true;
    L5:
        if ((getActivity() instanceof AggregatedNotifyActivity) == true) goto L8;
        return false;
    }

    public final String getEnterMethod() {
        Bundle r100 = getArguments();
        String r101 = "other";
        if (r100 == null) goto L8;
        String r102 = r100.getString("enter_method", "other");
        if (r102 == null) goto L8;
        r101 = r102;
    L8:
        Bundle r103 = getArguments();
        if (r103 == null) goto L11;
        String r104 = r103.getString("is_from_push", "false");
    L13:
        if (Intrinsics.areEqual(r104, "true") == false) goto L15;
        r101 = "outer_push";
    L15:
        FLogger.f375446a.i("NotifyTabFragment", "getEnterFrom = ".concat(r101));
        return r101;
    L11:
        r104 = null;
        goto L13
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final String getPageName() {
        if (Y90().isAggNotificationPage() == false) goto L5;
        return "multi_add_notify";
    L5:
        return "notify";
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        if (Y90().isAggNotificationPage() == false) goto L5;
        return "multi_add_notify";
    L5:
        return "notify";
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f313425j = null;
        AppHost.f326268a.a().c(this.f313437v);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.f313428m == true) goto L22;
        Iterator r100 = ((ArrayList) this.f313430o.f327606b).iterator();
        int r101 = 0;
    L6:
        if (r100.hasNext() == false) goto L10;
        if (((Notice) r100.next()).getHasRead() == true) goto L6;
        r101 = r101 + 1;
        goto L6
    L10:
        NotificationListAdapter r102 = this.f313430o;
        Iterator r103 = ((ArrayList) r102.f327606b).iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        ((Notice) r103.next()).setHasRead(true);
        goto L12
    L14:
        r102.notifyDataSetChanged();
        Y90().markTotalRead(Integer.valueOf(r101));
        Y90().setLeaveNotifyTimestamp(System.currentTimeMillis());
        return;
    }

    @Override // com.larus.bmhome.BaseHomeTabFragment, com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        String r100 = getEnterMethod();
        if (this.f313428m == true) goto L11;
        boolean r101 = o3.f547886a;
        JSONObject r102 = new JSONObject();
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.put("enter_method", r100);     // Catch: JSONException -> L7
    L9:
        TrackParams r103 = new TrackParams().merge(r102);
        by7.a r104 = new by7.a("show_notification_page");
        r104.f21464b = this;
        r104.f21463a.merge(r103);
        r104.b();
    L7:
        e = move-exception;
        FLogger.f375446a.e("ShowEventHelper", "error in ShowEventHelper showNotificationPage " + e.getLocalizedMessage());
    L11:
        if (this.f313434s == true) goto L13;
    L15:
        DowngradeSource r105 = DowngradeSource.ENTER_PAGE;
    L16:
        this.f313428m = false;
        ((BannerViewModel) this.f313427l.getValue()).refreshNotificationBanner(r105);
        this.f313434s = false;
        this.f313435t = false;
        return;
    L13:
        if (this.f313435t == false) goto L15;
        r105 = DowngradeSource.HOT_LAUNCH;
        goto L16
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e
    public final by7.e parentTrackNode() {
        ActivityResultCaller r100 = getParentFragment();
        if ((r100 instanceof by7.e) == true) goto L7;
        return null;
    L7:
        return (by7.e) r100;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.trace.tracknode.a.C4500a.a(this, r100);
        r100.putIfNull("enter_method", getEnterMethod());
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Y90().init(getArguments());
        ((BannerViewModel) this.f313427l.getValue()).init(getArguments());
        if (((Boolean) this.f313433r.getValue()).booleanValue() == true) goto L5;
        NotifyRedDotLifecycleObserver r101 = new NotifyRedDotLifecycleObserver(LifecycleOwnerKt.getLifecycleScope(this));
        getLifecycle().addObserver(r101);
    L5:
        boolean r102 = HomeService.f344094a.o();
        NotificationListViewModel r103 = Y90();
        if (((Boolean) this.f313433r.getValue()).booleanValue() == false) goto L8;
        DowngradeSource r104 = DowngradeSource.ENTER_PAGE;
    L9:
        NotificationListViewModel.refreshNotificationList$default(r103, r104, false, false, 6, null);
        BannerViewModel r105 = (BannerViewModel) this.f313427l.getValue();
        if (r102 == false) goto L12;
        DowngradeSource r106 = DowngradeSource.ENTER_PAGE;
    L13:
        r105.refreshNotificationBanner(r106);
        AppHost.f326268a.a().j(this.f313437v);
        return;
    L12:
        r106 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L13
    L8:
        r104 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L9
    }

    @Override // s19.a
    public final void y2(final String r100) {
        FLogger.f375446a.i("NotifyTabFragment", "onEnterTab, previousPage:" + r100);
        this.f313436u = true;
        getViewLifecycleOwnerLiveData().observeForever(new c(new w(this, r100)));
        if (Y90().getUnreadNotificationCount() > 0) goto L5;
    L11:
        Y90().clearUnreadNotificationCount();
        return;
    L5:
        if (this.f313429n == true) goto L11;
        NotificationListViewModel r101 = Y90();
        if (((Boolean) this.f313433r.getValue()).booleanValue() == false) goto L9;
        DowngradeSource r102 = DowngradeSource.ENTER_PAGE;
    L10:
        NotificationListViewModel.refreshNotificationList$default(r101, r102, false, false, 6, null);
        goto L11
    L9:
        r102 = DowngradeSource.ENTER_CONVERSATION_LIST;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        final LarusPageNotificationBinding r112 = this.f313425j;
        if (r112 == null) goto L35;
        Bundle r113 = getArguments();
        FragmentActivity r100 = null;
        if (r113 == null) goto L7;
        String r114 = r113.getString("title");
    L9:
        if (TextUtils.isEmpty(r114) == true) goto L14;
        NovaTitleBarEx r101 = r112.f360276e;
        if (r114 != null) goto L13;
        r114 = "";
    L13:
        NovaTitleBarEx.Y5(r101, r114, null, null, 6);
    L20:
        if (Z90() == false) goto L23;
        NovaTitleBarEx.b6(r112.f360276e, R.drawable.larus_ic_left_back, false, null, null, new x(this), 14);
    L32:
        NotificationListAdapter r115 = this.f313430o;
        Function0<Unit> r102 = new f(this);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r102, "callback");
        r115.f313457q = r102;
        final RecyclerView r116 = r112.f360274c;
        r116.setLayoutManager(new LinearLayoutManager(r116.getContext()));
        r116.setHasFixedSize(true);
        NotificationListAdapter r103 = this.f313430o;
        r103.f313454n = new g(this);
        r103.f313453m = new h(this);
        r103.f313455o = new i(this);
        r103.f313456p = new j(this);
        r116.addOnScrollListener(new NotifyTabFragment$initView$1$5$5(this, r112));
        Intrinsics.checkNotNull(r116);
        y6.d(r116, null, new k(this), null, new l(this), 11);
        r116.addItemDecoration(new NotifyTabFragment$initView$1$5$8(r116));
        r116.setAdapter(this.f313430o);
        IFlowCreationThemeConfigProvider r117 = (IFlowCreationThemeConfigProvider) ServiceManager.get().getService(IFlowCreationThemeConfigProvider.class);
        if (r117 == null) goto L35;
        r117.b(r112.f360273b, new m(this, r112), AdaptThemeFeatureKey.CREATION_NOTIFY_BOT_CREATE);
        goto L35
    L23:
        if (((Boolean) this.f313433r.getValue()).booleanValue() == false) goto L32;
        NovaTitleBarEx r118 = r112.f360276e;
        ViewGroup.LayoutParams r104 = r118.getLayoutParams();
        if (r104 == null) goto L31;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        i0.f375410a.getClass();
        r105.topMargin = i0.g();
        r118.setLayoutParams(r105);
        NovaTitleBarEx.b6(r112.f360276e, R.drawable.larus_ic_side_bar, false, null, null, new y(this), 14);
        ConstraintLayout r119 = r112.f360272a;
        Context r106 = getContext();
        if ((r106 instanceof FragmentActivity) == false) goto L29;
        r100 = (FragmentActivity) r106;
    L29:
        int r107 = com.larus.utils.u.b(r100);
        int r108 = r119.getPaddingStart();
        int r109 = r119.getPaddingTop();
        int r120 = r119.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r119.getClass().getSimpleName() + ",source:,start:" + r108 + ",top:" + r109 + ",end:" + r120 + ",bottom:" + r107);
        r119.setPaddingRelative(r108, r109, r120, r107);
        Y90().clearUnreadNotificationCount();
        goto L32
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L14:
        NovaTitleBarEx r121 = r112.f360276e;
        if (Y90().isAggNotificationPage() == false) goto L17;
        String r122 = getString(R.string.larus_add_notifications);
    L18:
        Intrinsics.checkNotNull(r122);
        NovaTitleBarEx.Y5(r121, r122, null, null, 6);
        goto L20
    L17:
        r122 = getString(R.string.larus_notifications);
        goto L18
    L7:
        r114 = null;
    L35:
        Y90().getRefreshNotificationListData().observe(getViewLifecycleOwner(), new c(new s(this)));
        Y90().getLoadMoreNotificationListData().observe(getViewLifecycleOwner(), new c(new t(this)));
        Y90().getDeleteNoticeLiveData().observe(getViewLifecycleOwner(), new c(new u(this)));
        ((BannerViewModel) this.f313427l.getValue()).getRefreshBannerEvent().observe(getViewLifecycleOwner(), new c(new v(this)));
        this.f313429n = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = getLayoutInflater().inflate(R.layout.larus_page_notification, r101, false);
        int r104 = R.id.bot_create;
        CreateBotButton r105 = (CreateBotButton) ViewBindings.findChildViewById(r103, R.id.bot_create);
        if (r105 == null) goto L19;
        ConstraintLayout r106 = (ConstraintLayout) r103;
        RecyclerView r107 = (RecyclerView) ViewBindings.findChildViewById(r103, R.id.notification_list);
        if (r107 == null) goto L17;
        FrameLayout r108 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.outer_chat_input);
        if (r108 == null) goto L16;
        NovaTitleBarEx r109 = (NovaTitleBarEx) ViewBindings.findChildViewById(r103, R.id.title_bar);
        if (r109 == null) goto L15;
        this.f313425j = new LarusPageNotificationBinding(r106, r105, r107, r108, r109);
        if (r106 == null) goto L13;
        r106.setTag(R.id.lib_track_tag_parent_track_node, this);
        return r106;
    L13:
        return null;
    L15:
        r104 = R.id.title_bar;
        goto L19
    L16:
        r104 = R.id.outer_chat_input;
        goto L19
    L17:
        r104 = R.id.notification_list;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public static void aa0(NotifyTabFragment r100, boolean r101, boolean r102, DowngradeSource r103) {
        r100.getClass();
        FLogger.f375446a.i("NotifyTabFragment", "refreshing notification tab");
        if (r101 == false) goto L11;
        NotificationListAdapter r104 = r100.f313430o;
        if (r104.H2() == false) goto L10;
        ArrayList r105 = new ArrayList();
        Notice r106 = r104.A2(0);
        if (r106 == null) goto L9;
        r105.add(r106);
    L9:
        r105.addAll(r104.f313451k);
        r104.E2(r105);
        goto L11
    L10:
        r104.E2(r104.f313451k);
    L11:
        r100.Y90().refreshNotificationList(r103, r102, false);
    }
}
