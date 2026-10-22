package com.bytedance.ee.bear.office.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.office.common.upload.d0;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceSelectionState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.adapter.OfficeSpaceHeaderMoreMenuController;
import com.bytedance.ee.bear.office.list.selectpanel.OfficeSelectPanelHostDelegate;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001_B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001e2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00109\u001a\u000207H\u0002J\u0006\u0010:\u001a\u000207J\u0018\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>H\u0016J \u0010?\u001a\u0002072\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>2\u0006\u0010@\u001a\u00020\u001cH\u0002J\n\u0010A\u001a\u0004\u0018\u00010BH\u0002J\b\u0010C\u001a\u00020\u0012H\u0002J\b\u0010D\u001a\u000207H\u0016J\b\u0010E\u001a\u000207H\u0016J\b\u0010F\u001a\u00020\"H\u0016J\b\u0010G\u001a\u000207H\u0016J\b\u0010H\u001a\u000207H\u0016J\u0006\u0010I\u001a\u000207J\u0006\u0010J\u001a\u000207J\u0010\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020\u0012H\u0002J\u0006\u0010M\u001a\u00020\"J\"\u0010N\u001a\u0002072\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020\"H\u0002J\b\u0010T\u001a\u000207H\u0002J\b\u0010U\u001a\u000207H\u0002J\b\u0010V\u001a\u000207H\u0016J\b\u0010W\u001a\u000207H\u0016J\u0010\u0010X\u001a\u0002072\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u000207H\u0002J\u000e\u0010\\\u001a\u00020\u0012*\u0004\u0018\u00010\u0012H\u0002J\f\u0010]\u001a\u00020\u0012*\u00020\u001eH\u0002J\b\u0010^\u001a\u00020\u0012H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-¨\u0006`"}, d2 = {"Lcom/bytedance/ee/bear/office/list/OfficeListHostFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionStateListener;", "Lcom/bytedance/ee/bear/office/list/OfficeSpacePageMenuHost;", "<init>", "()V", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "tab$delegate", "Lkotlin/Lazy;", "listConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "getListConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "listConfig$delegate", "runtimeId", "", "getRuntimeId", "()Ljava/lang/String;", "runtimeId$delegate", "enterContext", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "getEnterContext", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "enterContext$delegate", "containerId", "", "refreshHost", "Landroid/view/View;", "headerMoreMenuController", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeSpaceHeaderMoreMenuController;", "pendingHeaderMoreCapabilityRetry", "", "lastTabReselectedTime", "", "refreshRecentAfterCreateOnResume", "recentCreateActionDispatched", "recentCreateActionPaused", "rootMineRefreshCallback", "Lkotlin/Function0;", "selectPanelHostDelegate", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelHostDelegate;", "getSelectPanelHostDelegate", "()Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelHostDelegate;", "selectPanelHostDelegate$delegate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "attachListFragment", "onOfficePageSelected", "showHeaderMoreMenu", "anchor", "dispatcher", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderActionDispatcher;", "scheduleHeaderMoreCapabilityRetry", "attempt", "buildRootFallbackCapability", "Lcom/bytedance/ee/bear/office/list/OfficeListPageMenuCapability;", "rootFallbackModule", "closeHeaderMoreMenu", "requestExitSelectionFromHeader", "onTabReselected", "onResume", "onPause", "markRecentCreateActionDispatched", "markRefreshRecentAfterCreateOnResume", "tryRefreshRecentAfterCreate", "reason", "refreshCurrentListAfterCreate", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "refreshCurrentListAfterSelectorResult", "bindRefreshLayoutToChild", "clearRefreshLayoutFromChild", "onDestroyView", "onDetach", "onSelectionStateChanged", "state", "Lcom/bytedance/ee/bear/list/list/multiselect/BaseListMultiSelectState;", "requestExitSelectionFromChild", "toLogKey", "hostHeaderMoreAnchorState", "currentChildState", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeListHostFragment extends Fragment implements ed5.f, p {
    public static final /* synthetic */ int r = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public int h;
    public SmartRefreshLayout i;
    public OfficeSpaceHeaderMoreMenuController j;
    public boolean k;
    public long l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final Function0<Boolean> p;
    public final Lazy q;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceTab.values().length];
            r0[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ OfficeListHostFragment a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ com.bytedance.ee.bear.office.export.space.i d;

        public c(OfficeListHostFragment r1, View r2, int r3, com.bytedance.ee.bear.office.export.space.i r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            OfficeListHostFragment r0 = this.a;
            boolean r1 = false;
            r0.k = false;
            if (r0.isAdded() == true) goto L5;
        L25:
            StringBuilder r2 = new StringBuilder("abort header more capability retry, host not ready, runtime=");
            OfficeListHostFragment r8 = this.a;
            r2.append(r8.ba0(r8.V90()));
            r2.append(", tab=");
            r2.append(this.a.W90());
            r2.append(", attempt=");
            r2.append(this.c);
            r2.append(", hostAdded=");
            r2.append(this.a.isAdded());
            r2.append(", hasView=");
            if (this.a.getView() == null) goto L28;
            r1 = true;
        L28:
            r2.append(r1);
            r2.append(", hostState=");
            r2.append(this.a.getLifecycle().getCurrentState());
            r2.append(", anchor=");
            OfficeListHostFragment r3 = this.a;
            View r4 = this.b;
            r3.getClass();
            r2.append(OfficeListHostFragment.X90(r4));
            r2.append(", child=");
            r2.append(this.a.U90());
            tt5.a.h("OfficeListHostFragment", r2.toString());
            return;
        L5:
            if (this.a.getView() == null) goto L25;
            if (this.b.isAttachedToWindow() == false) goto L25;
            if (this.a.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L25;
            OfficeListPageMenuCapabilityRegistry r5 = OfficeListPageMenuCapabilityRegistry.a;
            String r6 = this.a.V90();
            OfficeSpaceTab r9 = this.a.W90();
            r5.getClass();
            i r7 = OfficeListPageMenuCapabilityRegistry.a(r6, r9);
            if (r7 != null) goto L15;
            r7 = this.a.T90();
        L15:
            if (r7 == null) goto L21;
            if (this.a.y50(this.b, this.d) == true) goto L30;
            UDToast.a r10 = UDToast.build(this.b.getContext());
            r10.b.e(2131886372);
            r10.b.d = -1;
            r10.h();
            return;
        L30:
            return;
        L21:
            if (this.c >= 5) goto L23;
            StringBuilder r11 = new StringBuilder("retry header more menu, capability still missing, runtime=");
            OfficeListHostFragment r12 = this.a;
            r11.append(r12.ba0(r12.V90()));
            r11.append(", tab=");
            r11.append(this.a.W90());
            r11.append(", attempt=");
            r11.append(this.c);
            tt5.a.h("OfficeListHostFragment", r11.toString());
            this.a.aa0(this.b, this.d, this.c + 1);
            return;
        L23:
            StringBuilder r13 = new StringBuilder("header more capability missing after retry, runtime=");
            OfficeListHostFragment r14 = this.a;
            r13.append(r14.ba0(r14.V90()));
            r13.append(", tab=");
            r13.append(this.a.W90());
            r13.append(", anchor=");
            OfficeListHostFragment r15 = this.a;
            View r16 = this.b;
            r15.getClass();
            r13.append(OfficeListHostFragment.X90(r16));
            r13.append(", child=");
            r13.append(this.a.U90());
            tt5.a.h("OfficeListHostFragment", r13.toString());
            UDToast.a r17 = UDToast.build(this.b.getContext());
            r17.b.e(2131886372);
            r17.b.d = -1;
            r17.h();
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
        OfficeSpaceHeaderMoreMenuController r0 = this.j;
        if (r0 == null) goto L8;
        r0.k();
        com.bytedance.ee.bear.office.common.screenmenu.j r1 = r0.c;
        if (r1 == null) goto L9;
        int r2 = com.bytedance.ee.bear.office.common.screenmenu.j.h;
        r1.f("unknown");
        return;
    L9:
        return;
    }

    public final i T90() {
        d0c.c r1 = getChildFragmentManager().findFragmentById(this.h);
        WeakReference r4 = null;
        if (r1 != null) goto L6;
        tt5.a.h("OfficeListHostFragment", "skip root fallback header more capability, child missing, runtime=" + ba0(V90()) + ", tab=" + W90() + ", childCount=" + getChildFragmentManager().getFragments().size());
        return null;
    L6:
        boolean r6 = false;
        if (r1.isAdded() == true) goto L9;
    L50:
        StringBuilder r5 = new StringBuilder("skip root fallback header more capability, runtime=");
        r5.append(ba0(V90()));
        r5.append(", tab=");
        r5.append(W90());
        r5.append(", owner=");
        r5.append(r1.getClass().getSimpleName());
        r5.append(", added=");
        r5.append(r1.isAdded());
        r5.append(", hasView=");
        if (r1.getView() == null) goto L53;
        r6 = true;
    L53:
        r5.append(r6);
        r5.append(", state=");
        r5.append(r1.getLifecycle().getCurrentState());
        tt5.a.h("OfficeListHostFragment", r5.toString());
        return null;
    L9:
        if (r1.getView() == null) goto L50;
        if (r1.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L50;
        int r7 = b.a[W90().ordinal()];
        if (r7 != 1) goto L16;
        String r8 = "recent";
    L27:
        final String r11 = r8;
        final WeakReference r12 = new WeakReference(r1);
        if ((r1 instanceof ed5.d) == false) goto L30;
        ed5.d r9 = (ed5.d) r1;
    L32:
        if ((r1 instanceof d0c.c) == false) goto L34;
        ce5.a r10 = new ce5.a(r1);
    L35:
        ce5.a r13 = r10;
        StringBuilder r14 = new StringBuilder("use root fallback header more capability, runtime=");
        r14.append(ba0(V90()));
        r14.append(", tab=");
        r14.append(W90());
        r14.append(", module=");
        r14.append(r11);
        r14.append(", owner=");
        r14.append(r1.getClass().getSimpleName());
        r14.append(", state=");
        r14.append(r1.getLifecycle().getCurrentState());
        r14.append(", selectionHost=");
        if (r9 == null) goto L38;
        String r2 = r9.getClass().getSimpleName();
    L39:
        r14.append(r2);
        tt5.a.h("OfficeListHostFragment", r14.toString());
        if (r9 == null) goto L42;
        r4 = new WeakReference(r9);
    L42:
        WeakReference r15 = r4;
        if (((OfficeListConfig) this.e.getValue()).getEnableMultiSelect() == true) goto L45;
    L47:
        boolean r16 = false;
    L49:
        return new i(r11, r12, r13, r15, r16, new OfficeListHostFragment$buildRootFallbackCapability$2(r11), new m(OfficeListHostFragment$buildRootFallbackCapability$3.INSTANCE, OfficeListHostFragment$buildRootFallbackCapability$4.INSTANCE, new OfficeListHostFragment$buildRootFallbackCapability$5(r12), OfficeListHostFragment$buildRootFallbackCapability$6.INSTANCE, OfficeListHostFragment$buildRootFallbackCapability$7.INSTANCE, OfficeListHostFragment$buildRootFallbackCapability$8.INSTANCE, OfficeListHostFragment$buildRootFallbackCapability$9.INSTANCE));
    L45:
        if (((OfficeListConfig) this.e.getValue()).getMultiSelectEnabledTabs().contains(W90()) == false) goto L47;
        r16 = true;
        goto L49
    L38:
        r2 = null;
        goto L39
    L34:
        r10 = new ce5.a();
        goto L35
    L30:
        r9 = null;
        goto L32
    L16:
        if (r7 != 2) goto L18;
        r8 = "my_root_folder";
        goto L27
    L18:
        if (r7 != 3) goto L20;
        r8 = "shared";
        goto L27
    L20:
        if (r7 != 4) goto L23;
        r8 = "favorites";
        goto L27
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public final String V90() {
        return (String) this.f.getValue();
    }

    public final OfficeSpaceTab W90() {
        return (OfficeSpaceTab) this.d.getValue();
    }

    public final void onDetach() {
        ConcurrentHashMap<h.a, WeakReference<p>> r0 = h.a;
        h.m(V90(), W90(), this);
        super.onDetach();
    }

    public OfficeListHostFragment() {
        this.d = LazyKt.lazy(new OfficeListHostFragment$tab$2(this));
        this.e = LazyKt.lazy(new OfficeListHostFragment$listConfig$2(this));
        this.f = LazyKt.lazy(new OfficeListHostFragment$runtimeId$2(this));
        this.g = LazyKt.lazy(new OfficeListHostFragment$enterContext$2(this));
        this.h = -1;
        this.p = new OfficeListHostFragment$rootMineRefreshCallback$1(this);
        this.q = LazyKt.lazy(new OfficeListHostFragment$selectPanelHostDelegate$2(this));
    }

    public final void S90() {
        k r0 = getChildFragmentManager().findFragmentById(this.h);
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = this.i;
        StringBuilder r2 = new StringBuilder("bind refresh host to child, tab=");
        r2.append(W90());
        r2.append(", child=");
        r2.append(r0.getClass().getSimpleName());
        r2.append(", hasRefreshHost=");
        if (r1 == null) goto L8;
        boolean r3 = true;
    L9:
        r2.append(r3);
        tt5.a.h("OfficeListHostFragment", r2.toString());
        if ((r0 instanceof k) == false) goto L12;
        r0.cd(r1);
        return;
    L12:
        f1.a(r0, r1);
        return;
    L8:
        r3 = false;
        goto L9
    }

    public final String U90() {
        Fragment r0 = getChildFragmentManager().findFragmentById(this.h);
        if (r0 == null) goto L11;
        StringBuilder r1 = new StringBuilder();
        r1.append(r0.getClass().getSimpleName());
        r1.append(",added=");
        r1.append(r0.isAdded());
        r1.append(",hasView=");
        if (r0.getView() == null) goto L8;
        boolean r2 = true;
    L9:
        r1.append(r2);
        r1.append(",state=");
        r1.append(r0.getLifecycle().getCurrentState());
        return r1.toString();
    L8:
        r2 = false;
        goto L9
    L11:
        return "null,count=" + getChildFragmentManager().getFragments().size();
    }

    @Override // com.bytedance.ee.bear.office.list.p
    public final boolean V() {
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.l) >= 1000) goto L6;
        tt5.a.h("OfficeListHostFragment", "ignore frequent tab reselect, tab=" + W90());
        return true;
    L6:
        this.l = r0;
        k r1 = getChildFragmentManager().findFragmentById(this.h);
        StringBuilder r2 = new StringBuilder("onTabReselected, tab=");
        r2.append(W90());
        r2.append(", child=");
        if (r1 == null) goto L9;
        String r3 = r1.getClass().getSimpleName();
    L10:
        r2.append(r3);
        tt5.a.h("OfficeListHostFragment", r2.toString());
        if ((r1 instanceof k) == true) goto L15;
        int r4 = f1.a;
        return f1.d(r1, this.i);
    L15:
        return r1.xn();
    L9:
        r3 = null;
        goto L10
    }

    public final boolean Y90() {
        k r0 = getChildFragmentManager().findFragmentById(this.h);
        if ((r0 instanceof k) == true) goto L7;
        int r1 = f1.a;
        return f1.d(r0, this.i);
    L7:
        return r0.xn();
    }

    public final void Z90() {
        ed5.d r0 = getChildFragmentManager().findFragmentById(this.h);
        if ((r0 instanceof ed5.d) == false) goto L5;
        ed5.d r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.xk();
    L8:
        ((OfficeSelectPanelHostDelegate) this.q.getValue()).d();
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r2 = com.bytedance.ee.bear.office.export.space.m.a;
        com.bytedance.ee.bear.office.export.space.h r3 = com.bytedance.ee.bear.office.export.space.m.a(V90());
        if (r3 == null) goto L11;
        r3.YJ(new OfficeSpaceSelectionState(W90(), CollectionsKt.emptyList(), false));
    L11:
        ConcurrentHashMap<h.a, WeakReference<p>> r4 = h.a;
        h.i(V90(), false, 0);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void gM() {
        k r0 = getChildFragmentManager().findFragmentById(this.h);
        StringBuilder r1 = new StringBuilder("onOfficePageSelected, tab=");
        r1.append(W90());
        r1.append(", child=");
        if (r0 == null) goto L5;
        String r2 = r0.getClass().getSimpleName();
    L6:
        r1.append(r2);
        tt5.a.h("OfficeListHostFragment", r1.toString());
        if ((r0 instanceof k) == false) goto L9;
        r0.gM();
    L11:
        if (W90() != OfficeSpaceTab.MINE) goto L16;
        boolean r3 = d0.a;
        d0.a = false;
        if (r3 == false) goto L17;
        tt5.a.h("OfficeListHostFragment", "refresh MINE after upload success");
        Y90();
        return;
    L17:
        return;
    L16:
        return;
    L9:
        f1.c(r0);
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroyView() {
        k r0 = getChildFragmentManager().findFragmentById(this.h);
        if (r0 == null) goto L9;
        tt5.a.h("OfficeListHostFragment", "clear refresh host from child, tab=" + W90() + ", child=" + r0.getClass().getSimpleName());
        if ((r0 instanceof k) == false) goto L8;
        r0.cd(null);
        goto L9
    L8:
        f1.a(r0, null);
    L9:
        ((OfficeSelectPanelHostDelegate) this.q.getValue()).e();
        this.i = null;
        this.h = -1;
        Su();
        OfficeSpaceHeaderMoreMenuController r1 = this.j;
        if (r1 == null) goto L15;
        r1.k();
        com.bytedance.ee.bear.office.common.screenmenu.j r3 = r1.c;
        if (r3 == null) goto L14;
        r3.o();
    L14:
        r1.c = null;
    L15:
        this.j = null;
        this.k = false;
        if (W90() != OfficeSpaceTab.MINE) goto L18;
        boolean r2 = d0.a;
        Function0<Boolean> r4 = this.p;
        Intrinsics.checkNotNullParameter(r4, "refresh");
        d0.d.remove(r4);
    L18:
        OfficeListPageMenuCapabilityRegistry r5 = OfficeListPageMenuCapabilityRegistry.a;
        String r6 = V90();
        OfficeSpaceTab r7 = W90();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, "tab");
        OfficeListPageMenuCapabilityRegistry.a r8 = new OfficeListPageMenuCapabilityRegistry.a(OfficeListPageMenuCapabilityRegistry.e(r6), r7);
        OfficeListPageMenuCapabilityRegistry.b.remove(r8);
        OfficeListPageMenuCapabilityRegistry.c.remove(r8);
        tt5.a.h("OfficeListPageMenuCapabilityRegistry", "unregister page menu capabilities, runtime=" + OfficeListPageMenuCapabilityRegistry.g(r8.a) + ", tab=" + r7);
        ConcurrentHashMap<h.a, WeakReference<p>> r9 = h.a;
        h.m(V90(), W90(), this);
        tt5.a.h("OfficeListHostFragment", "destroy view and unregister host, tab=" + W90());
        super.onDestroyView();
    }

    public final void onPause() {
        if (W90() == OfficeSpaceTab.RECENT) goto L5;
    L7:
        super.onPause();
        return;
    L5:
        if (this.n == false) goto L7;
        this.o = true;
        goto L7
    }

    public final void onResume() {
        super.onResume();
        if (W90() == OfficeSpaceTab.RECENT) goto L5;
        return;
    L5:
        if (this.m == false) goto L13;
        View r0 = getView();
        if (r0 == null) goto L12;
        r0.post(new g(this, "onResume"));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.office.list.p
    public final void xT() {
        Z90();
    }

    public static String X90(View r2) {
        return "attached=" + r2.isAttachedToWindow() + ",size=" + r2.getWidth() + 'x' + r2.getHeight() + ",shown=" + r2.isShown() + ",windowFocus=" + r2.hasWindowFocus();
    }

    @Override // ed5.f
    public final void It(ed5.a r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r0 = com.bytedance.ee.bear.office.export.space.m.a;
        com.bytedance.ee.bear.office.export.space.h r1 = com.bytedance.ee.bear.office.export.space.m.a(V90());
        OfficeSpaceSelectionState r2 = new OfficeSpaceSelectionState(W90(), o.b(r6), r6.a);
        if (r1 == null) goto L5;
        r1.YJ(r2);
    L5:
        ConcurrentHashMap<h.a, WeakReference<p>> r3 = h.a;
        h.i(V90(), r6.a, r6.b.size());
        ((OfficeSelectPanelHostDelegate) this.q.getValue()).g(r6, getChildFragmentManager().findFragmentById(this.h));
    }

    public final String ba0(String r2) {
        if (r2 != null) goto L4;
    L10:
        return "default";
    L4:
        if ((!StringsKt.isBlank(r2)) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L10;
        String r3 = Integer.valueOf(r2.hashCode()).toString();
        if (r3 == null) goto L10;
        return r3;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        int r11 = com.bytedance.ee.bear.office.list.adapter.f.b;
        com.bytedance.ee.bear.office.list.adapter.f.a.a((OfficeListConfig) this.e.getValue());
        com.bytedance.ee.bear.office.list.adapter.l.a r12 = com.bytedance.ee.bear.office.list.adapter.l.a;
        c1 r13 = d1.a;
        com.bytedance.ee.bear.office.list.adapter.l.a r14 = com.bytedance.ee.bear.office.list.adapter.l.a;
        if (r13 == r14) goto L6;
        d1.a = r14;
    L6:
        if (getChildFragmentManager().findFragmentById(this.h) == null) goto L71;
        S90();
    L40:
        ConcurrentHashMap<h.a, WeakReference<p>> r15 = h.a;
        String r16 = V90();
        OfficeSpaceTab r1 = W90();
        Intrinsics.checkNotNullParameter(r1, "tab");
        Intrinsics.checkNotNullParameter(this, "host");
        String r17 = h.g(r16);
        tt5.a.h("OfficeListHostRegistry", "register host, runtime=" + h.l(r17) + ", tab=" + r1);
        h.a.put(new h.a(r17, r1), new WeakReference(this));
        h.b(r17, r1);
        OfficeSpaceTab r3 = OfficeSpaceTab.RECENT;
        if (r1 != r3) goto L57;
        if (Intrinsics.areEqual(h.d.remove(r17), Boolean.TRUE) == false) goto L57;
        tt5.a.h("OfficeListHostRegistry", "consume pending recent create refresh, runtime=" + h.l(r17));
        this.m = true;
        tt5.a.h("OfficeListHostFragment", "mark RECENT refresh after office document created");
        if (isResumed() == false) goto L57;
        if (this.o == false) goto L57;
        if (W90() != r3) goto L57;
        if (this.m == false) goto L57;
        View r18 = getView();
        if (r18 == null) goto L57;
        r18.post(new g(this, "lateCreateResultAfterResume"));
    L57:
        if (W90() != OfficeSpaceTab.MINE) goto L59;
        boolean r19 = d0.a;
        Function0<Boolean> r20 = this.p;
        Intrinsics.checkNotNullParameter(r20, "refresh");
        d0.d.add(r20);
        d0.c();
    L59:
        String r21 = V90();
        OfficeSpaceTab r0 = W90();
        Intrinsics.checkNotNullParameter(r0, "tab");
        String r22 = h.g(r21);
        boolean r2 = h.b.remove(r22, r0);
        if (r2 == false) goto L62;
        tt5.a.h("OfficeListHostRegistry", "consume pending page selected, runtime=" + h.l(r22) + ", tab=" + r0);
    L62:
        String r23 = V90();
        OfficeSpaceTab r4 = W90();
        Intrinsics.checkNotNullParameter(r4, "tab");
        String r24 = h.g(r23);
        boolean r5 = h.c.remove(r24, r4);
        if (r5 == false) goto L65;
        tt5.a.h("OfficeListHostRegistry", "consume pending tab reselected, runtime=" + h.l(r24) + ", tab=" + r4);
    L65:
        if (r2 == false) goto L67;
        tt5.a.h("OfficeListHostFragment", "dispatch pending page selected after host ready, tab=" + W90());
        gM();
    L67:
        if (r5 == false) goto L75;
        if (r2 == true) goto L76;
        tt5.a.h("OfficeListHostFragment", "dispatch pending tab reselected after host ready, tab=" + W90());
        V();
        return;
    L76:
        return;
    L75:
        return;
    L71:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L9
        int r26 = f.a;     // Catch: Throwable -> L9
        Object r27 = Result.constructor-impl(f.a(W90(), (OfficeListConfig) this.e.getValue(), V90(), (OfficeSpaceEnterContext) this.g.getValue()));     // Catch: Throwable -> L9
    L11:
        Throwable r6 = Result.exceptionOrNull-impl(r27);
        if (r6 == null) goto L22;
        StringBuilder r28 = new StringBuilder("create office list fragment failed, use fallback. tab=");
        r28.append(W90());
        r28.append(", hasRuntimeId=");
        String r7 = V90();
        if (r7 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        r28.append(!r8);
        tt5.a.e("OfficeListHostFragment", r28.toString(), r6, false);
        r27 = new OfficeListLoadFailedFragment();
        goto L22
    L17:
        if (StringsKt.isBlank(r7) == true) goto L20;
        r8 = false;
    L22:
        Fragment r29 = (Fragment) r27;
        FragmentTransaction r30 = getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L29
        int r31 = this.h;     // Catch: Throwable -> L29
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r30, r29, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r31) == true) goto L27;
        r30.replace(r31, r29);     // Catch: Throwable -> L29
    L27:
        r30.commitNow();     // Catch: Throwable -> L29
        Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L38;
        tt5.a.e("OfficeListHostFragment", "attach office list fragment failed, use fallback. tab=" + W90() + ", containerId=" + this.h, r33, false);
        FragmentTransaction r34 = getChildFragmentManager().beginTransaction();
        int r35 = this.h;
        OfficeListLoadFailedFragment r36 = new OfficeListLoadFailedFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r34, r36, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r35) == true) goto L37;
        r34.replace(r35, r36);
    L37:
        r34.commitNowAllowingStateLoss();
    L38:
        S90();
    L29:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.bytedance.ee.bear.office.list.p
    public final boolean y50(View r12, com.bytedance.ee.bear.office.export.space.i r13) {
        Intrinsics.checkNotNullParameter(r12, "anchor");
        Intrinsics.checkNotNullParameter(r13, "dispatcher");
        OfficeListPageMenuCapabilityRegistry r0 = OfficeListPageMenuCapabilityRegistry.a;
        String r1 = V90();
        OfficeSpaceTab r2 = W90();
        r0.getClass();
        i r3 = OfficeListPageMenuCapabilityRegistry.a(r1, r2);
        if (r3 != null) goto L5;
        r3 = T90();
    L5:
        i r4 = r3;
        boolean r5 = false;
        if (r4 != null) goto L14;
        StringBuilder r6 = new StringBuilder("skip header more menu, capability missing, runtime=");
        r6.append(ba0(V90()));
        r6.append(", tab=");
        r6.append(W90());
        r6.append(", hostAdded=");
        r6.append(isAdded());
        r6.append(", hostState=");
        r6.append(getLifecycle().getCurrentState());
        r6.append(", viewAttached=");
        View r7 = getView();
        if (r7 != null) goto L10;
    L12:
        r6.append(r5);
        r6.append(", childCount=");
        r6.append(getChildFragmentManager().getFragments().size());
        tt5.a.h("OfficeListHostFragment", r6.toString());
        aa0(r12, r13, 1);
        return true;
    L10:
        if (r7.isAttachedToWindow() != true) goto L12;
        r5 = true;
        goto L12
    L14:
        Context r8 = getContext();
        if (r8 != null) goto L18;
        tt5.a.h("OfficeListHostFragment", "skip header more menu, context missing, runtime=" + ba0(V90()) + ", tab=" + W90() + ", hostAdded=" + isAdded() + ", hostState=" + getLifecycle().getCurrentState());
        return false;
    L18:
        OfficeSpaceHeaderMoreMenuController r9 = this.j;
        if (r9 != null) goto L21;
        r9 = new OfficeSpaceHeaderMoreMenuController(r8, new OfficeListHostFragment$showHeaderMoreMenu$controller$1(this));
        this.j = r9;
    L21:
        boolean r14 = r9.n(r12, W90(), r4, r13, V90());
        if (r14 == true) goto L24;
        tt5.a.h("OfficeListHostFragment", "skip header more menu, controller rejected, runtime=" + ba0(V90()) + ", tab=" + W90() + ", hostAdded=" + isAdded() + ", hostState=" + getLifecycle().getCurrentState() + ", anchorAttached=" + r12.isAttachedToWindow() + ", anchorSize=" + r12.getWidth() + 'x' + r12.getHeight());
    L24:
        return r14;
    }

    public final void aa0(View r2, com.bytedance.ee.bear.office.export.space.i r3, int r4) {
        if (this.k == false) goto L6;
        tt5.a.h("OfficeListHostFragment", "skip header more capability retry, retry already pending, runtime=" + ba0(V90()) + ", tab=" + W90() + ", attempt=" + r4 + ", anchor=" + X90(r2) + ", child=" + U90());
        return;
    L6:
        this.k = true;
        r2.postDelayed(new c(this, r2, r4, r3), 100);
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (n.a(r1, r2) == false) goto L6;
        tt5.a.h("OfficeListHostFragment", "refresh after selector result, tab=" + W90() + ", requestCode=" + r1);
        Y90();
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        this.h = View.generateViewId();
        tt5.a.h("OfficeListHostFragment", "create refresh host, tab=" + W90() + ", containerId=" + this.h);
        int r4 = l.a;
        Context r5 = requireContext();
        int r6 = this.h;
        Intrinsics.checkNotNullParameter(r5, "context");
        SmartRefreshLayout r7 = f1.b(r5, r6);
        l.a(r7);
        this.i = r7;
        return r7;
    }
}
