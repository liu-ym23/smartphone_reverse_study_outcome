package com.bytedance.ee.bear.office.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.MyRootFolderFragment;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceSelectionState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.selectpanel.OfficeSelectPanelHostDelegate;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import dd5.c1;
import dd5.d1;
import dd5.f1;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001QB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010/\u001a\u00020-H\u0016J\u0012\u00100\u001a\u00020-2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u00101\u001a\u00020-H\u0016J\b\u00102\u001a\u000203H\u0016J\"\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u000203H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u001eH\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u000203H\u0016J \u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0019H\u0016J\u0010\u0010F\u001a\u0002032\u0006\u0010B\u001a\u00020\u0001H\u0016J\b\u0010G\u001a\u00020-H\u0002J\b\u0010H\u001a\u00020-H\u0002J\u0012\u0010I\u001a\u00020-2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010J\u001a\u00020-2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010K\u001a\u00020-H\u0016J\b\u0010L\u001a\u000203H\u0016J\n\u0010M\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010N\u001a\u00020\u0001H\u0002J\b\u0010O\u001a\u00020-H\u0002J\b\u0010P\u001a\u00020-H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b#\u0010$¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/office/list/OfficeMyRootFolderHostFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionStateListener;", "Lcom/bytedance/ee/bear/list/folder/FolderChildNavigationHost;", "Lcom/bytedance/ee/bear/office/list/OfficeListRefreshDelegate;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionHost;", "<init>", "()V", "officeArgs", "Landroid/os/Bundle;", "getOfficeArgs", "()Landroid/os/Bundle;", "officeArgs$delegate", "Lkotlin/Lazy;", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "tab$delegate", "listConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "getListConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "listConfig$delegate", "runtimeId", "", "getRuntimeId", "()Ljava/lang/String;", "runtimeId$delegate", "containerId", "", "refreshHost", "Landroid/view/View;", "selectPanelHostDelegate", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelHostDelegate;", "getSelectPanelHostDelegate", "()Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelHostDelegate;", "selectPanelHostDelegate$delegate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onViewCreated", "", "view", "onDestroyView", "bindRefreshLayout", "onOfficePageSelected", "onOfficeTabReselected", "", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "refreshCurrentListAfterSelectorResult", "onSelectionStateChanged", "state", "Lcom/bytedance/ee/bear/list/list/multiselect/BaseListMultiSelectState;", "navigationContainerId", "navigationFragmentManager", "Landroidx/fragment/app/FragmentManager;", "canNavigateToFolderChild", "openFolderChild", "source", "document", "Lcom/bytedance/ee/bear/list/dto/Document;", "currentModule", "popBackToFolderHost", "attachRootFolderFragment", "requestExitSelectionForCurrentChild", "requestEnterSelection", "requestToggleSelection", "requestExitSelection", "isInSelectionMode", "currentChild", "createPersonalChild", "bindRefreshLayoutToActiveChild", "unregisterCurrentPageMenuCapability", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyRootFolderHostFragment extends Fragment implements ed5.f, uc5.k, k, ed5.d {
    public static final /* synthetic */ int k = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public int h;
    public View i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    @Override // ed5.d
    public final /* synthetic */ boolean KL(ListSelectPanelAction r1, List r2, ed5.g r3) {
        return false;
    }

    public final String U90() {
        return (String) this.g.getValue();
    }

    public final OfficeSpaceTab V90() {
        return (OfficeSpaceTab) this.e.getValue();
    }

    public OfficeMyRootFolderHostFragment() {
        this.d = LazyKt.lazy(new OfficeMyRootFolderHostFragment$officeArgs$2(this));
        this.e = LazyKt.lazy(new OfficeMyRootFolderHostFragment$tab$2(this));
        this.f = LazyKt.lazy(new OfficeMyRootFolderHostFragment$listConfig$2(this));
        this.g = LazyKt.lazy(new OfficeMyRootFolderHostFragment$runtimeId$2(this));
        this.h = -1;
        this.j = LazyKt.lazy(new OfficeMyRootFolderHostFragment$selectPanelHostDelegate$2(this));
    }

    public final void S90() {
        k r0 = T90();
        StringBuilder r1 = new StringBuilder("bind refresh host to personal child, child=");
        if (r0 == null) goto L5;
        String r2 = r0.getClass().getSimpleName();
    L6:
        r1.append(r2);
        tt5.a.h("OfficeMyRootFolderHost", r1.toString());
        if ((r0 instanceof k) == false) goto L9;
        r0.cd(this.i);
        return;
    L9:
        int r3 = f1.a;
        f1.a(r0, this.i);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final Fragment T90() {
        return getChildFragmentManager().findFragmentByTag("office_mine_personal_child");
    }

    public final void W90() {
        ed5.d r0 = T90();
        if ((r0 instanceof ed5.d) == false) goto L5;
        ed5.d r1 = r0;
    L7:
        if (r1 == null) goto L11;
        boolean r3 = true;
        if (r1.ZT() != true) goto L11;
    L12:
        if (r1 == null) goto L14;
        r1.xk();
    L14:
        ((OfficeSelectPanelHostDelegate) this.j.getValue()).d();
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r2 = com.bytedance.ee.bear.office.export.space.m.a;
        com.bytedance.ee.bear.office.export.space.h r4 = com.bytedance.ee.bear.office.export.space.m.a(U90());
        if (r4 == null) goto L17;
        r4.YJ(new OfficeSpaceSelectionState(V90(), CollectionsKt.emptyList(), false));
    L17:
        tt5.a.h("OfficeMyRootFolderHost", "request exit selection, wasInSelectionMode=" + r3);
        return;
    L11:
        r3 = false;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    @Override // ed5.d
    public final boolean ZT() {
        ed5.d r0 = T90();
        if ((r0 instanceof ed5.d) == false) goto L5;
        ed5.d r1 = r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.ZT() != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.office.list.k
    public final void gM() {
        k r0 = T90();
        StringBuilder r1 = new StringBuilder("forward page selected to personal child, child=");
        if (r0 == null) goto L5;
        String r2 = r0.getClass().getSimpleName();
    L6:
        r1.append(r2);
        tt5.a.h("OfficeMyRootFolderHost", r1.toString());
        if ((r0 instanceof k) == false) goto L9;
        r0.gM();
        return;
    L9:
        f1.c(r0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // uc5.k
    public final FragmentManager lf() {
        return getParentFragmentManager();
    }

    @Override // uc5.k
    public final int mc() {
        return getId();
    }

    public final void onDestroyView() {
        Fragment r0 = T90();
        if (r0 == null) goto L6;
        OfficeListPageMenuCapabilityRegistry r1 = OfficeListPageMenuCapabilityRegistry.a;
        String r2 = U90();
        OfficeSpaceTab r3 = V90();
        r1.getClass();
        OfficeListPageMenuCapabilityRegistry.h(r2, r3, r0);
    L6:
        ((OfficeSelectPanelHostDelegate) this.j.getValue()).e();
        cd(null);
        this.i = null;
        this.h = -1;
        super.onDestroyView();
    }

    @Override // uc5.k
    public final boolean wO() {
        if (isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (getId() == (-1)) goto L9;
        if (getId() == 0) goto L9;
        return true;
    }

    @Override // com.bytedance.ee.bear.office.list.k
    public final boolean xn() {
        k r0 = T90();
        StringBuilder r1 = new StringBuilder("forward tab reselected to personal child, child=");
        if (r0 == null) goto L5;
        String r2 = r0.getClass().getSimpleName();
    L6:
        r1.append(r2);
        tt5.a.h("OfficeMyRootFolderHost", r1.toString());
        if ((r0 instanceof k) == true) goto L11;
        int r3 = f1.a;
        return f1.d(r0, this.i);
    L11:
        return r0.xn();
    L5:
        r2 = null;
        goto L6
    }

    @Override // ed5.d
    public final void xk() {
        W90();
    }

    @Override // uc5.k
    public final boolean BX(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        getParentFragmentManager().popBackStack();     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L5
    L7:
        Boolean r0 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L11;
        r5 = r0;
    L11:
        return ((Boolean) r5).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // ed5.d
    public final void Dt(Document r3) {
        ed5.d r0 = T90();
        if ((r0 instanceof ed5.d) == false) goto L5;
        ed5.d r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.Dt(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ed5.f
    public final void It(ed5.a r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r0 = com.bytedance.ee.bear.office.export.space.m.a;
        com.bytedance.ee.bear.office.export.space.h r1 = com.bytedance.ee.bear.office.export.space.m.a(U90());
        if (r1 == null) goto L5;
        r1.YJ(new OfficeSpaceSelectionState(V90(), o.b(r6), r6.a));
    L5:
        ConcurrentHashMap<h.a, WeakReference<p>> r2 = h.a;
        h.i(U90(), r6.a, r6.b.size());
        ((OfficeSelectPanelHostDelegate) this.j.getValue()).g(r6, T90());
    }

    @Override // com.bytedance.ee.bear.office.list.k
    public final void cd(View r3) {
        this.i = r3;
        StringBuilder r0 = new StringBuilder("bind refresh host from outer host, hasRefreshHost=");
        if (r3 == null) goto L5;
        boolean r4 = true;
    L6:
        r0.append(r4);
        tt5.a.h("OfficeMyRootFolderHost", r0.toString());
        S90();
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // ed5.d
    public final void sT(Document r3) {
        ed5.d r0 = T90();
        if ((r0 instanceof ed5.d) == false) goto L5;
        ed5.d r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.sT(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        int r8 = com.bytedance.ee.bear.office.list.adapter.f.b;
        com.bytedance.ee.bear.office.list.adapter.f.a.a((OfficeListConfig) this.f.getValue());
        com.bytedance.ee.bear.office.list.adapter.l.a r9 = com.bytedance.ee.bear.office.list.adapter.l.a;
        c1 r10 = d1.a;
        com.bytedance.ee.bear.office.list.adapter.l.a r11 = com.bytedance.ee.bear.office.list.adapter.l.a;
        if (r10 == r11) goto L6;
        d1.a = r11;
    L6:
        if (getChildFragmentManager().findFragmentByTag("office_mine_personal_child") == null) goto L43;
        tt5.a.h("OfficeMyRootFolderHost", "root folder child already exists, rebind refresh host");
        S90();
        return;
    L43:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L9
        MyRootFolderFragment r13 = new MyRootFolderFragment();     // Catch: Throwable -> L9
        r13.setArguments(new Bundle((Bundle) this.d.getValue()));     // Catch: Throwable -> L9
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L9
    L11:
        Throwable r1 = Result.exceptionOrNull-impl(r14);
        if (r1 == null) goto L22;
        StringBuilder r15 = new StringBuilder("create my root folder fragment failed, use fallback. tab=");
        r15.append(V90());
        r15.append(", hasRuntimeId=");
        String r3 = U90();
        if (r3 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        r15.append(!r4);
        tt5.a.e("OfficeMyRootFolderHost", r15.toString(), r1, false);
        r14 = new OfficeListLoadFailedFragment();
        goto L22
    L17:
        if (StringsKt.isBlank(r3) == true) goto L20;
        r4 = false;
    L22:
        Fragment r16 = (Fragment) r14;
        tt5.a.h("OfficeMyRootFolderHost", "attach my root folder child, fragment=".concat(r16.getClass().getSimpleName()));
        FragmentTransaction r2 = getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L29
        int r5 = this.h;     // Catch: Throwable -> L29
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "office_mine_personal_child", r5) == true) goto L27;
        r2.replace(r5, r16, "office_mine_personal_child");     // Catch: Throwable -> L29
    L27:
        r2.commitNow();     // Catch: Throwable -> L29
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L38;
        tt5.a.e("OfficeMyRootFolderHost", "attach my root folder fragment failed, use fallback. tab=" + V90() + ", containerId=" + this.h, r18, false);
        FragmentTransaction r19 = getChildFragmentManager().beginTransaction();
        int r0 = this.h;
        OfficeListLoadFailedFragment r20 = new OfficeListLoadFailedFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r19, r20, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "office_mine_personal_child", r0) == true) goto L37;
        r19.replace(r0, r20, "office_mine_personal_child");
    L37:
        r19.commitNowAllowingStateLoss();
    L38:
        S90();
        return;
    L29:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // uc5.k
    public final boolean Qz(Fragment r2, Document r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "document");
        Intrinsics.checkNotNullParameter(r4, "currentModule");
        return e.b(r2, r3, r4);
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (n.a(r1, r2) == false) goto L9;
        tt5.a.h("OfficeMyRootFolderHost", "refresh after selector result, tab=" + V90() + ", requestCode=" + r1);
        k r4 = T90();
        if ((r4 instanceof k) == false) goto L7;
        r4.xn();
        return;
    L7:
        int r5 = f1.a;
        f1.d(r4, this.i);
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        this.h = View.generateViewId();
        FrameLayout r4 = new FrameLayout(requireContext());
        r4.setId(this.h);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return r4;
    }
}
