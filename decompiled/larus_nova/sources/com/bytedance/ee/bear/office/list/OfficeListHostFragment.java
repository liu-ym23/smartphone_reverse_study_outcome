package com.bytedance.ee.bear.office.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.office.common.upload.d0;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceSelectionState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.adapter.OfficeSpaceHeaderMoreMenuController;
import com.bytedance.ee.bear.office.list.selectpanel.OfficeSelectPanelHostDelegate;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import dd5.c1;
import dd5.d1;
import dd5.f1;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001_B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001e2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00109\u001a\u000207H\u0002J\u0006\u0010:\u001a\u000207J\u0018\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>H\u0016J \u0010?\u001a\u0002072\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020\u001cH\u0002J\n\u0010A\u001a\u0004\u0018\u00010BH\u0002J\b\u0010C\u001a\u00020\u0012H\u0002J\b\u0010D\u001a\u000207H\u0016J\b\u0010E\u001a\u000207H\u0016J\b\u0010F\u001a\u00020\"H\u0016J\b\u0010G\u001a\u000207H\u0016J\b\u0010H\u001a\u000207H\u0016J\u0006\u0010I\u001a\u000207J\u0006\u0010J\u001a\u000207J\u0010\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020\u0012H\u0002J\u0006\u0010M\u001a\u00020\"J\"\u0010N\u001a\u0002072\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020\"H\u0002J\b\u0010T\u001a\u000207H\u0002J\b\u0010U\u001a\u000207H\u0002J\b\u0010V\u001a\u000207H\u0016J\b\u0010W\u001a\u000207H\u0016J\u0010\u0010X\u001a\u0002072\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u000207H\u0002J\u000e\u0010\\\u001a\u00020\u0012*\u0004\u0018\u00010\u0012H\u0002J\f\u0010]\u001a\u00020\u0012*\u00020\u001eH\u0002J\b\u0010^\u001a\u00020\u0012H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-¨\u0006`"}, d2 = {"Lcom/bytedance/ee/bear/office/list/OfficeListHostFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionStateListener;", "Lcom/bytedance/ee/bear/office/list/OfficeSpacePageMenuHost;", "<init>", "()V", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "tab$delegate", "Lkotlin/Lazy;", "listConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "getListConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "listConfig$delegate", "runtimeId", "", "getRuntimeId", "()Ljava/lang/String;", "runtimeId$delegate", "enterContext", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "getEnterContext", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "enterContext$delegate", "containerId", "", "refreshHost", "Landroid/view/View;", "headerMoreMenuController", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeSpaceHeaderMoreMenuController;", "pendingHeaderMoreCapabilityRetry", "", "lastTabReselectedTime", "", "refreshRecentAfterCreateOnResume", "recentCreateActionDispatched", "recentCreateActionPaused", "rootMineRefreshCallback", "Lkotlin/Function0;", "selectPanelHostDelegate", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelHostDelegate;", "getSelectPanelHostDelegate", "()Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelHostDelegate;", "selectPanelHostDelegate$delegate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "attachListFragment", "onOfficePageSelected", "showHeaderMoreMenu", "anchor", "dispatcher", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderActionDispatcher;", "scheduleHeaderMoreCapabilityRetry", MapMonitorConst.ATTEMPT, "buildRootFallbackCapability", "Lcom/bytedance/ee/bear/office/list/OfficeListPageMenuCapability;", "rootFallbackModule", "closeHeaderMoreMenu", "requestExitSelectionFromHeader", "onTabReselected", "onResume", "onPause", "markRecentCreateActionDispatched", "markRefreshRecentAfterCreateOnResume", "tryRefreshRecentAfterCreate", "reason", "refreshCurrentListAfterCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "refreshCurrentListAfterSelectorResult", "bindRefreshLayoutToChild", "clearRefreshLayoutFromChild", "onDestroyView", "onDetach", "onSelectionStateChanged", "state", "Lcom/bytedance/ee/bear/list/list/multiselect/BaseListMultiSelectState;", "requestExitSelectionFromChild", "toLogKey", "hostHeaderMoreAnchorState", "currentChildState", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeListHostFragment extends Fragment implements ed5.f, p {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f235527r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f235528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f235529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f235530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f235531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f235532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SmartRefreshLayout f235533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OfficeSpaceHeaderMoreMenuController f235534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f235535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f235536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f235537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f235538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f235539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<Boolean> f235540p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f235541q;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235542a = null;

        static {
            int[] r100 = new int[OfficeSpaceTab.values().length];
            r100[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f235542a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeListHostFragment f235543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f235544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f235545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.office.export.space.i f235546d;

        public c(OfficeListHostFragment r100, View r101, int r102, com.bytedance.ee.bear.office.export.space.i r103) {
            this.f235543a = r100;
            this.f235544b = r101;
            this.f235545c = r102;
            this.f235546d = r103;
        }

        public final void a() {
            OfficeListHostFragment r100 = this.f235543a;
            boolean r101 = false;
            r100.f235535k = false;
            if (r100.isAdded() == true) goto L5;
        L25:
            StringBuilder r102 = new StringBuilder("abort header more capability retry, host not ready, runtime=");
            OfficeListHostFragment r103 = this.f235543a;
            r102.append(r103.ba0(r103.V90()));
            r102.append(", tab=");
            r102.append(this.f235543a.W90());
            r102.append(", attempt=");
            r102.append(this.f235545c);
            r102.append(", hostAdded=");
            r102.append(this.f235543a.isAdded());
            r102.append(", hasView=");
            if (this.f235543a.getView() == null) goto L28;
            r101 = true;
        L28:
            r102.append(r101);
            r102.append(", hostState=");
            r102.append(this.f235543a.getLifecycle().getCurrentState());
            r102.append(", anchor=");
            OfficeListHostFragment r104 = this.f235543a;
            View r105 = this.f235544b;
            r104.getClass();
            r102.append(OfficeListHostFragment.X90(r105));
            r102.append(", child=");
            r102.append(this.f235543a.U90());
            tt5.a.h("OfficeListHostFragment", r102.toString());
            return;
        L5:
            if (this.f235543a.getView() == null) goto L25;
            if (this.f235544b.isAttachedToWindow() == false) goto L25;
            if (this.f235543a.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L25;
            OfficeListPageMenuCapabilityRegistry r106 = OfficeListPageMenuCapabilityRegistry.f235547a;
            String r107 = this.f235543a.V90();
            OfficeSpaceTab r108 = this.f235543a.W90();
            r106.getClass();
            i r109 = OfficeListPageMenuCapabilityRegistry.a(r107, r108);
            if (r109 != null) goto L15;
            r109 = this.f235543a.T90();
        L15:
            if (r109 == null) goto L21;
            if (this.f235543a.y50(this.f235544b, this.f235546d) == true) goto L30;
            UDToast.a r110 = UDToast.build(this.f235544b.getContext());
            r110.f285429b.e(R.string.Bitable_Common_UnableToPerformAction_Common);
            r110.f285429b.f417630d = -1;
            r110.h();
            return;
        L30:
            return;
        L21:
            if (this.f235545c >= 5) goto L23;
            StringBuilder r111 = new StringBuilder("retry header more menu, capability still missing, runtime=");
            OfficeListHostFragment r112 = this.f235543a;
            r111.append(r112.ba0(r112.V90()));
            r111.append(", tab=");
            r111.append(this.f235543a.W90());
            r111.append(", attempt=");
            r111.append(this.f235545c);
            tt5.a.h("OfficeListHostFragment", r111.toString());
            this.f235543a.aa0(this.f235544b, this.f235546d, this.f235545c + 1);
            return;
        L23:
            StringBuilder r113 = new StringBuilder("header more capability missing after retry, runtime=");
            OfficeListHostFragment r114 = this.f235543a;
            r113.append(r114.ba0(r114.V90()));
            r113.append(", tab=");
            r113.append(this.f235543a.W90());
            r113.append(", anchor=");
            OfficeListHostFragment r115 = this.f235543a;
            View r116 = this.f235544b;
            r115.getClass();
            r113.append(OfficeListHostFragment.X90(r116));
            r113.append(", child=");
            r113.append(this.f235543a.U90());
            tt5.a.h("OfficeListHostFragment", r113.toString());
            UDToast.a r117 = UDToast.build(this.f235544b.getContext());
            r117.f285429b.e(R.string.Bitable_Common_UnableToPerformAction_Common);
            r117.f285429b.f417630d = -1;
            r117.h();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.office.list.p
    public final void Su() {
        OfficeSpaceHeaderMoreMenuController r100 = this.f235534j;
        if (r100 == null) goto L8;
        r100.k();
        com.bytedance.ee.bear.office.common.screenmenu.j r101 = r100.f235703c;
        if (r101 == null) goto L9;
        int r102 = com.bytedance.ee.bear.office.common.screenmenu.j.f235227h;
        r101.f("unknown");
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i T90() {
        Fragment r100 = getChildFragmentManager().findFragmentById(this.f235532h);
        WeakReference r101 = null;
        if (r100 != 0) goto L6;
        tt5.a.h("OfficeListHostFragment", "skip root fallback header more capability, child missing, runtime=" + ba0(V90()) + ", tab=" + W90() + ", childCount=" + getChildFragmentManager().getFragments().size());
        return null;
    L6:
        boolean r102 = false;
        if (r100.isAdded() == true) goto L9;
    L50:
        StringBuilder r103 = new StringBuilder("skip root fallback header more capability, runtime=");
        r103.append(ba0(V90()));
        r103.append(", tab=");
        r103.append(W90());
        r103.append(", owner=");
        r103.append(r100.getClass().getSimpleName());
        r103.append(", added=");
        r103.append(r100.isAdded());
        r103.append(", hasView=");
        if (r100.getView() == null) goto L53;
        r102 = true;
    L53:
        r103.append(r102);
        r103.append(", state=");
        r103.append(r100.getLifecycle().getCurrentState());
        tt5.a.h("OfficeListHostFragment", r103.toString());
        return null;
    L9:
        if (r100.getView() == null) goto L50;
        if (r100.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L50;
        int r104 = b.f235542a[W90().ordinal()];
        if (r104 != 1) goto L16;
        String r105 = "recent";
    L27:
        final String r110 = r105;
        final WeakReference r111 = new WeakReference(r100);
        if ((r100 instanceof ed5.d) == false) goto L30;
        ed5.d r106 = (ed5.d) r100;
    L32:
        if ((r100 instanceof d0c.c) == false) goto L34;
        ce5.a r112 = new ce5.a((d0c.c) r100);
    L35:
        ce5.a r113 = r112;
        StringBuilder r114 = new StringBuilder("use root fallback header more capability, runtime=");
        r114.append(ba0(V90()));
        r114.append(", tab=");
        r114.append(W90());
        r114.append(", module=");
        r114.append(r110);
        r114.append(", owner=");
        r114.append(r100.getClass().getSimpleName());
        r114.append(", state=");
        r114.append(r100.getLifecycle().getCurrentState());
        r114.append(", selectionHost=");
        if (r106 == null) goto L38;
        String r107 = r106.getClass().getSimpleName();
    L39:
        r114.append(r107);
        tt5.a.h("OfficeListHostFragment", r114.toString());
        if (r106 == null) goto L42;
        r101 = new WeakReference(r106);
    L42:
        WeakReference r115 = r101;
        if (((OfficeListConfig) this.f235529e.getValue()).getEnableMultiSelect() == true) goto L45;
    L47:
        boolean r116 = false;
    L49:
        return new i(r110, r111, r113, r115, r116, new OfficeListHostFragment$buildRootFallbackCapability$2(r110), new m(OfficeListHostFragment$buildRootFallbackCapability$3.INSTANCE, OfficeListHostFragment$buildRootFallbackCapability$4.INSTANCE, new OfficeListHostFragment$buildRootFallbackCapability$5(r111), OfficeListHostFragment$buildRootFallbackCapability$6.INSTANCE, OfficeListHostFragment$buildRootFallbackCapability$7.INSTANCE, OfficeListHostFragment$buildRootFallbackCapability$8.INSTANCE, OfficeListHostFragment$buildRootFallbackCapability$9.INSTANCE));
    L45:
        if (((OfficeListConfig) this.f235529e.getValue()).getMultiSelectEnabledTabs().contains(W90()) == false) goto L47;
        r116 = true;
        goto L49
    L38:
        r107 = null;
        goto L39
    L34:
        r112 = new ce5.a();
        goto L35
    L30:
        r106 = null;
        goto L32
    L16:
        if (r104 != 2) goto L18;
        r105 = "my_root_folder";
        goto L27
    L18:
        if (r104 != 3) goto L20;
        r105 = "shared";
        goto L27
    L20:
        if (r104 != 4) goto L23;
        r105 = "favorites";
        goto L27
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public final String V90() {
        return (String) this.f235530f.getValue();
    }

    public final OfficeSpaceTab W90() {
        return (OfficeSpaceTab) this.f235528d.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        ConcurrentHashMap<h.a, WeakReference<p>> r100 = h.f235894a;
        h.m(V90(), W90(), this);
        super.onDetach();
    }

    public OfficeListHostFragment() {
        this.f235528d = LazyKt.lazy(new OfficeListHostFragment$tab$2(this));
        this.f235529e = LazyKt.lazy(new OfficeListHostFragment$listConfig$2(this));
        this.f235530f = LazyKt.lazy(new OfficeListHostFragment$runtimeId$2(this));
        this.f235531g = LazyKt.lazy(new OfficeListHostFragment$enterContext$2(this));
        this.f235532h = -1;
        this.f235540p = new OfficeListHostFragment$rootMineRefreshCallback$1(this);
        this.f235541q = LazyKt.lazy(new OfficeListHostFragment$selectPanelHostDelegate$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S90() {
        Fragment r100 = getChildFragmentManager().findFragmentById(this.f235532h);
        if (r100 != 0) goto L5;
        return;
    L5:
        SmartRefreshLayout r101 = this.f235533i;
        StringBuilder r102 = new StringBuilder("bind refresh host to child, tab=");
        r102.append(W90());
        r102.append(", child=");
        r102.append(r100.getClass().getSimpleName());
        r102.append(", hasRefreshHost=");
        if (r101 == null) goto L8;
        boolean r103 = true;
    L9:
        r102.append(r103);
        tt5.a.h("OfficeListHostFragment", r102.toString());
        if ((r100 instanceof k) == false) goto L12;
        ((k) r100).cd(r101);
        return;
    L12:
        f1.a(r100, r101);
        return;
    L8:
        r103 = false;
        goto L9
    }

    public final String U90() {
        Fragment r100 = getChildFragmentManager().findFragmentById(this.f235532h);
        if (r100 == null) goto L11;
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getClass().getSimpleName());
        r101.append(",added=");
        r101.append(r100.isAdded());
        r101.append(",hasView=");
        if (r100.getView() == null) goto L8;
        boolean r102 = true;
    L9:
        r101.append(r102);
        r101.append(",state=");
        r101.append(r100.getLifecycle().getCurrentState());
        return r101.toString();
    L8:
        r102 = false;
        goto L9
    L11:
        return "null,count=" + getChildFragmentManager().getFragments().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.office.list.p
    public final boolean V() {
        long r100 = SystemClock.elapsedRealtime();
        if ((r100 - this.f235536l) >= 1000) goto L6;
        tt5.a.h("OfficeListHostFragment", "ignore frequent tab reselect, tab=" + W90());
        return true;
    L6:
        this.f235536l = r100;
        Fragment r101 = getChildFragmentManager().findFragmentById(this.f235532h);
        StringBuilder r102 = new StringBuilder("onTabReselected, tab=");
        r102.append(W90());
        r102.append(", child=");
        if (r101 == 0) goto L9;
        String r103 = r101.getClass().getSimpleName();
    L10:
        r102.append(r103);
        tt5.a.h("OfficeListHostFragment", r102.toString());
        if ((r101 instanceof k) == true) goto L15;
        int r104 = f1.f467960a;
        return f1.d(r101, this.f235533i);
    L15:
        return ((k) r101).xn();
    L9:
        r103 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean Y90() {
        Fragment r100 = getChildFragmentManager().findFragmentById(this.f235532h);
        if ((r100 instanceof k) == true) goto L7;
        int r101 = f1.f467960a;
        return f1.d(r100, this.f235533i);
    L7:
        return ((k) r100).xn();
    }

    public final void Z90() {
        ActivityResultCaller r100 = getChildFragmentManager().findFragmentById(this.f235532h);
        if ((r100 instanceof ed5.d) == false) goto L5;
        ed5.d r101 = (ed5.d) r100;
    L6:
        if (r101 == null) goto L8;
        r101.xk();
    L8:
        ((OfficeSelectPanelHostDelegate) this.f235541q.getValue()).d();
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r102 = com.bytedance.ee.bear.office.export.space.m.f235477a;
        com.bytedance.ee.bear.office.export.space.h r103 = com.bytedance.ee.bear.office.export.space.m.a(V90());
        if (r103 == null) goto L11;
        r103.YJ(new OfficeSpaceSelectionState(W90(), CollectionsKt.emptyList(), false));
    L11:
        ConcurrentHashMap<h.a, WeakReference<p>> r104 = h.f235894a;
        h.i(V90(), false, 0);
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void gM() {
        Fragment r100 = getChildFragmentManager().findFragmentById(this.f235532h);
        StringBuilder r101 = new StringBuilder("onOfficePageSelected, tab=");
        r101.append(W90());
        r101.append(", child=");
        if (r100 == 0) goto L5;
        String r102 = r100.getClass().getSimpleName();
    L6:
        r101.append(r102);
        tt5.a.h("OfficeListHostFragment", r101.toString());
        if ((r100 instanceof k) == false) goto L9;
        ((k) r100).gM();
    L11:
        if (W90() != OfficeSpaceTab.MINE) goto L16;
        boolean r103 = d0.f235354a;
        d0.f235354a = false;
        if (r103 == false) goto L17;
        tt5.a.h("OfficeListHostFragment", "refresh MINE after upload success");
        Y90();
        return;
    L17:
        return;
    L16:
        return;
    L9:
        f1.c(r100);
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Fragment r100 = getChildFragmentManager().findFragmentById(this.f235532h);
        if (r100 == 0) goto L9;
        tt5.a.h("OfficeListHostFragment", "clear refresh host from child, tab=" + W90() + ", child=" + r100.getClass().getSimpleName());
        if ((r100 instanceof k) == false) goto L8;
        ((k) r100).cd(null);
        goto L9
    L8:
        f1.a(r100, null);
    L9:
        ((OfficeSelectPanelHostDelegate) this.f235541q.getValue()).e();
        this.f235533i = null;
        this.f235532h = -1;
        Su();
        OfficeSpaceHeaderMoreMenuController r101 = this.f235534j;
        if (r101 == null) goto L15;
        r101.k();
        com.bytedance.ee.bear.office.common.screenmenu.j r102 = r101.f235703c;
        if (r102 == null) goto L14;
        r102.o();
    L14:
        r101.f235703c = null;
    L15:
        this.f235534j = null;
        this.f235535k = false;
        if (W90() != OfficeSpaceTab.MINE) goto L18;
        boolean r103 = d0.f235354a;
        Function0<Boolean> r104 = this.f235540p;
        Intrinsics.checkNotNullParameter(r104, "refresh");
        d0.f235357d.remove(r104);
    L18:
        OfficeListPageMenuCapabilityRegistry r105 = OfficeListPageMenuCapabilityRegistry.f235547a;
        String r106 = V90();
        OfficeSpaceTab r107 = W90();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r107, "tab");
        OfficeListPageMenuCapabilityRegistry.a r108 = new OfficeListPageMenuCapabilityRegistry.a(OfficeListPageMenuCapabilityRegistry.e(r106), r107);
        OfficeListPageMenuCapabilityRegistry.f235548b.remove(r108);
        OfficeListPageMenuCapabilityRegistry.f235549c.remove(r108);
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", "unregister page menu capabilities, runtime=" + OfficeListPageMenuCapabilityRegistry.g(r108.f235550a) + ", tab=" + r107);
        ConcurrentHashMap<h.a, WeakReference<p>> r109 = h.f235894a;
        h.m(V90(), W90(), this);
        tt5.a.h("OfficeListHostFragment", "destroy view and unregister host, tab=" + W90());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        if (W90() == OfficeSpaceTab.RECENT) goto L5;
    L7:
        super.onPause();
        return;
    L5:
        if (this.f235538n == false) goto L7;
        this.f235539o = true;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (W90() == OfficeSpaceTab.RECENT) goto L5;
        return;
    L5:
        if (this.f235537m == false) goto L13;
        View r100 = getView();
        if (r100 == null) goto L12;
        r100.post(new g(this, "onResume"));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.office.list.p
    public final void xT() {
        Z90();
    }

    public static String X90(View r100) {
        return "attached=" + r100.isAttachedToWindow() + ",size=" + r100.getWidth() + Permission.EXECUTE + r100.getHeight() + ",shown=" + r100.isShown() + ",windowFocus=" + r100.hasWindowFocus();
    }

    @Override // ed5.f
    public final void It(ed5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r101 = com.bytedance.ee.bear.office.export.space.m.f235477a;
        com.bytedance.ee.bear.office.export.space.h r102 = com.bytedance.ee.bear.office.export.space.m.a(V90());
        OfficeSpaceSelectionState r103 = new OfficeSpaceSelectionState(W90(), o.b(r100), r100.f472208a);
        if (r102 == null) goto L5;
        r102.YJ(r103);
    L5:
        ConcurrentHashMap<h.a, WeakReference<p>> r104 = h.f235894a;
        h.i(V90(), r100.f472208a, r100.f472209b.size());
        ((OfficeSelectPanelHostDelegate) this.f235541q.getValue()).g(r100, getChildFragmentManager().findFragmentById(this.f235532h));
    }

    public final String ba0(String r100) {
        if (r100 != null) goto L4;
    L10:
        return "default";
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L10;
        String r101 = Integer.valueOf(r100.hashCode()).toString();
        if (r101 == null) goto L10;
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        int r101 = com.bytedance.ee.bear.office.list.adapter.f.f235760b;
        com.bytedance.ee.bear.office.list.adapter.f.a.a((OfficeListConfig) this.f235529e.getValue());
        com.bytedance.ee.bear.office.list.adapter.l.a r102 = com.bytedance.ee.bear.office.list.adapter.l.f235799a;
        c1 r103 = d1.f467949a;
        com.bytedance.ee.bear.office.list.adapter.l.a r111 = com.bytedance.ee.bear.office.list.adapter.l.f235799a;
        if (r103 == r111) goto L6;
        d1.f467949a = r111;
    L6:
        if (getChildFragmentManager().findFragmentById(this.f235532h) == null) goto L71;
        S90();
    L40:
        ConcurrentHashMap<h.a, WeakReference<p>> r104 = h.f235894a;
        String r105 = V90();
        OfficeSpaceTab r106 = W90();
        Intrinsics.checkNotNullParameter(r106, "tab");
        Intrinsics.checkNotNullParameter(this, "host");
        String r107 = h.g(r105);
        tt5.a.h("OfficeListHostRegistry", "register host, runtime=" + h.l(r107) + ", tab=" + r106);
        h.f235894a.put(new h.a(r107, r106), new WeakReference(this));
        h.b(r107, r106);
        OfficeSpaceTab r108 = OfficeSpaceTab.RECENT;
        if (r106 != r108) goto L57;
        if (Intrinsics.areEqual(h.f235897d.remove(r107), Boolean.TRUE) == false) goto L57;
        tt5.a.h("OfficeListHostRegistry", "consume pending recent create refresh, runtime=" + h.l(r107));
        this.f235537m = true;
        tt5.a.h("OfficeListHostFragment", "mark RECENT refresh after office document created");
        if (isResumed() == false) goto L57;
        if (this.f235539o == false) goto L57;
        if (W90() != r108) goto L57;
        if (this.f235537m == false) goto L57;
        View r109 = getView();
        if (r109 == null) goto L57;
        r109.post(new g(this, "lateCreateResultAfterResume"));
    L57:
        if (W90() != OfficeSpaceTab.MINE) goto L59;
        boolean r112 = d0.f235354a;
        Function0<Boolean> r113 = this.f235540p;
        Intrinsics.checkNotNullParameter(r113, "refresh");
        d0.f235357d.add(r113);
        d0.c();
    L59:
        String r114 = V90();
        OfficeSpaceTab r115 = W90();
        Intrinsics.checkNotNullParameter(r115, "tab");
        String r116 = h.g(r114);
        boolean r117 = h.f235895b.remove(r116, r115);
        if (r117 == false) goto L62;
        tt5.a.h("OfficeListHostRegistry", "consume pending page selected, runtime=" + h.l(r116) + ", tab=" + r115);
    L62:
        String r118 = V90();
        OfficeSpaceTab r119 = W90();
        Intrinsics.checkNotNullParameter(r119, "tab");
        String r120 = h.g(r118);
        boolean r121 = h.f235896c.remove(r120, r119);
        if (r121 == false) goto L65;
        tt5.a.h("OfficeListHostRegistry", "consume pending tab reselected, runtime=" + h.l(r120) + ", tab=" + r119);
    L65:
        if (r117 == false) goto L67;
        tt5.a.h("OfficeListHostFragment", "dispatch pending page selected after host ready, tab=" + W90());
        gM();
    L67:
        if (r121 == false) goto L75;
        if (r117 == true) goto L76;
        tt5.a.h("OfficeListHostFragment", "dispatch pending tab reselected after host ready, tab=" + W90());
        V();
        return;
    L76:
        return;
    L75:
        return;
    L71:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L9
        int r123 = f.f235890a;     // Catch: Throwable -> L9
        Object r124 = Result.m9449constructorimpl(f.a(W90(), (OfficeListConfig) this.f235529e.getValue(), V90(), (OfficeSpaceEnterContext) this.f235531g.getValue()));     // Catch: Throwable -> L9
    L11:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r124);
        if (r125 == null) goto L22;
        StringBuilder r126 = new StringBuilder("create office list fragment failed, use fallback. tab=");
        r126.append(W90());
        r126.append(", hasRuntimeId=");
        String r127 = V90();
        if (r127 != null) goto L17;
    L20:
        boolean r128 = true;
    L21:
        r126.append(!r128);
        tt5.a.e("OfficeListHostFragment", r126.toString(), r125, false);
        r124 = new OfficeListLoadFailedFragment();
        goto L22
    L17:
        if (StringsKt.isBlank(r127) == true) goto L20;
        r128 = false;
    L22:
        Fragment r129 = (Fragment) r124;
        FragmentTransaction r130 = getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L29
        int r131 = this.f235532h;     // Catch: Throwable -> L29
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r130, r129, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r131) == true) goto L27;
        r130.replace(r131, r129);     // Catch: Throwable -> L29
    L27:
        r130.commitNow();     // Catch: Throwable -> L29
        Object r132 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r133 = Result.m9452exceptionOrNullimpl(r132);
        if (r133 == null) goto L38;
        tt5.a.e("OfficeListHostFragment", "attach office list fragment failed, use fallback. tab=" + W90() + ", containerId=" + this.f235532h, r133, false);
        FragmentTransaction r134 = getChildFragmentManager().beginTransaction();
        int r135 = this.f235532h;
        OfficeListLoadFailedFragment r136 = new OfficeListLoadFailedFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r134, r136, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r135) == true) goto L37;
        r134.replace(r135, r136);
    L37:
        r134.commitNowAllowingStateLoss();
    L38:
        S90();
    L29:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.bytedance.ee.bear.office.list.p
    public final boolean y50(View r110, com.bytedance.ee.bear.office.export.space.i r111) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        Intrinsics.checkNotNullParameter(r111, "dispatcher");
        OfficeListPageMenuCapabilityRegistry r100 = OfficeListPageMenuCapabilityRegistry.f235547a;
        String r101 = V90();
        OfficeSpaceTab r102 = W90();
        r100.getClass();
        i r103 = OfficeListPageMenuCapabilityRegistry.a(r101, r102);
        if (r103 != null) goto L5;
        r103 = T90();
    L5:
        i r104 = r103;
        boolean r105 = false;
        if (r104 != null) goto L14;
        StringBuilder r106 = new StringBuilder("skip header more menu, capability missing, runtime=");
        r106.append(ba0(V90()));
        r106.append(", tab=");
        r106.append(W90());
        r106.append(", hostAdded=");
        r106.append(isAdded());
        r106.append(", hostState=");
        r106.append(getLifecycle().getCurrentState());
        r106.append(", viewAttached=");
        View r107 = getView();
        if (r107 != null) goto L10;
    L12:
        r106.append(r105);
        r106.append(", childCount=");
        r106.append(getChildFragmentManager().getFragments().size());
        tt5.a.h("OfficeListHostFragment", r106.toString());
        aa0(r110, r111, 1);
        return true;
    L10:
        if (r107.isAttachedToWindow() != true) goto L12;
        r105 = true;
        goto L12
    L14:
        Context r108 = getContext();
        if (r108 != null) goto L18;
        tt5.a.h("OfficeListHostFragment", "skip header more menu, context missing, runtime=" + ba0(V90()) + ", tab=" + W90() + ", hostAdded=" + isAdded() + ", hostState=" + getLifecycle().getCurrentState());
        return false;
    L18:
        OfficeSpaceHeaderMoreMenuController r109 = this.f235534j;
        if (r109 != null) goto L21;
        r109 = new OfficeSpaceHeaderMoreMenuController(r108, new OfficeListHostFragment$showHeaderMoreMenu$controller$1(this));
        this.f235534j = r109;
    L21:
        boolean r112 = r109.n(r110, W90(), r104, r111, V90());
        if (r112 == true) goto L24;
        tt5.a.h("OfficeListHostFragment", "skip header more menu, controller rejected, runtime=" + ba0(V90()) + ", tab=" + W90() + ", hostAdded=" + isAdded() + ", hostState=" + getLifecycle().getCurrentState() + ", anchorAttached=" + r110.isAttachedToWindow() + ", anchorSize=" + r110.getWidth() + Permission.EXECUTE + r110.getHeight());
    L24:
        return r112;
    }

    public final void aa0(View r100, com.bytedance.ee.bear.office.export.space.i r101, int r102) {
        if (this.f235535k == false) goto L6;
        tt5.a.h("OfficeListHostFragment", "skip header more capability retry, retry already pending, runtime=" + ba0(V90()) + ", tab=" + W90() + ", attempt=" + r102 + ", anchor=" + X90(r100) + ", child=" + U90());
        return;
    L6:
        this.f235535k = true;
        r100.postDelayed(new c(this, r100, r102, r101), 100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (n.a(r100, r101) == false) goto L6;
        tt5.a.h("OfficeListHostFragment", "refresh after selector result, tab=" + W90() + ", requestCode=" + r100);
        Y90();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f235532h = View.generateViewId();
        tt5.a.h("OfficeListHostFragment", "create refresh host, tab=" + W90() + ", containerId=" + this.f235532h);
        int r103 = l.f235917a;
        Context r104 = requireContext();
        int r105 = this.f235532h;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        SmartRefreshLayout r106 = f1.b(r104, r105);
        l.a(r106);
        this.f235533i = r106;
        return r106;
    }
}
