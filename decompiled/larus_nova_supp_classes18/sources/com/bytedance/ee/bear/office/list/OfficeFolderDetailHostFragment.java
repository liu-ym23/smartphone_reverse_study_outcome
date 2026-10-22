package com.bytedance.ee.bear.office.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folder.FolderDetailFragment;
import com.bytedance.ee.bear.list.folder.SubFolderFragment;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadRecoveryTarget;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadUiHost;
import com.bytedance.ee.bear.office.common.upload.d0;
import com.bytedance.ee.bear.office.export.space.OfficeFolderActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.bytedance.ee.bear.office.export.space.OfficeListConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceSelectionState;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.adapter.OfficeFolderMoreMenuController;
import com.bytedance.ee.bear.office.list.selectpanel.OfficeSelectPanelHostDelegate;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.c1;
import dd5.d1;
import dd5.f1;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 u2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001uB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010H\u001a\u00020A2\u0006\u0010I\u001a\u0002022\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010J\u001a\u00020AH\u0016J\u0010\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0010\u0010M\u001a\u00020A2\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020\u001fH\u0016J\b\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020,H\u0016J \u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0012H\u0016J\"\u0010Y\u001a\u00020A2\u0006\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u001f2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010^\u001a\u00020,H\u0002J\u0006\u0010_\u001a\u00020,J\u0010\u0010`\u001a\u00020,2\u0006\u0010U\u001a\u00020\u0001H\u0016J\u0006\u0010a\u001a\u00020,J\b\u0010b\u001a\u00020AH\u0002J\b\u0010c\u001a\u00020\u0001H\u0002J\b\u0010d\u001a\u00020AH\u0002J\n\u0010e\u001a\u0004\u0018\u00010fH\u0002J\b\u0010g\u001a\u00020AH\u0002J\b\u0010h\u001a\u00020AH\u0002J\b\u0010i\u001a\u00020AH\u0002J\b\u0010j\u001a\u00020AH\u0002J\b\u0010k\u001a\u00020AH\u0002J\u0010\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u000202H\u0002J\u0010\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0002J\b\u0010r\u001a\u00020AH\u0016J\b\u0010s\u001a\u00020AH\u0016J\b\u0010t\u001a\u00020\u0007H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b)\u0010\u0014R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000b\u001a\u0004\b-\u0010.R\u000e\u00100\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020,0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u000b\u001a\u0004\b=\u0010>¨\u0006v"}, d2 = {"Lcom/bytedance/ee/bear/office/list/OfficeFolderDetailHostFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionStateListener;", "Lcom/bytedance/ee/bear/list/folder/FolderChildNavigationHost;", "<init>", "()V", "hostArgs", "Landroid/os/Bundle;", "getHostArgs", "()Landroid/os/Bundle;", "hostArgs$delegate", "Lkotlin/Lazy;", "request", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "getRequest", "()Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageRequest;", "request$delegate", "folderToken", "", "getFolderToken", "()Ljava/lang/String;", "folderToken$delegate", "folderTitle", "getFolderTitle", "folderTitle$delegate", "tab", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "getTab", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "tab$delegate", "ownerType", "", "getOwnerType", "()I", "ownerType$delegate", "listConfig", "Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "getListConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeListConfig;", "listConfig$delegate", "runtimeId", "getRuntimeId", "runtimeId$delegate", "runtimeOwnedByFragment", "", "getRuntimeOwnedByFragment", "()Z", "runtimeOwnedByFragment$delegate", "containerId", "refreshHost", "Landroid/view/View;", "headerView", "Lcom/bytedance/ee/bear/office/list/OfficeFolderHeaderView;", "moreMenuController", "Lcom/bytedance/ee/bear/office/list/adapter/OfficeFolderMoreMenuController;", "uploadUiHost", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadUiHost;", "uploadFolderRefreshCallback", "Lkotlin/Function0;", "selectPanelHostDelegate", "Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelHostDelegate;", "getSelectPanelHostDelegate", "()Lcom/bytedance/ee/bear/office/list/selectpanel/OfficeSelectPanelHostDelegate;", "selectPanelHostDelegate$delegate", "onCreate", "", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "handleOfficeDocumentCreatedResult", "result", "onSelectionStateChanged", "state", "Lcom/bytedance/ee/bear/list/list/multiselect/BaseListMultiSelectState;", "navigationContainerId", "navigationFragmentManager", "Landroidx/fragment/app/FragmentManager;", "canNavigateToFolderChild", "openFolderChild", "source", "document", "Lcom/bytedance/ee/bear/list/dto/Document;", "currentModule", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "refreshCurrentListAfterSelectorResult", "refreshCurrentFolderAfterCreate", "popBackToFolderHost", "handleBack", "attachFolderDetailFragment", "createChildFragment", "handleSearch", "resolveDelegate", "Lcom/bytedance/ee/bear/office/export/space/OfficeFolderPageDelegate;", "unregisterCurrentPageMenuCapability", "bindRefreshLayoutToChild", "clearRefreshLayoutFromChild", "requestExitSelectionIfNeeded", "dispatchEmptySelectionState", "showMoreMenu", "anchor", "dispatchHeaderAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "action", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "onResume", "onPause", "buildChildArgs", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeFolderDetailHostFragment extends Fragment implements ed5.f, uc5.k {
    public static final /* synthetic */ int t = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public int m;
    public SmartRefreshLayout n;
    public OfficeFolderHeaderView o;
    public OfficeFolderMoreMenuController p;
    public OfficeUploadUiHost q;
    public final Function0<Boolean> r;
    public final Lazy s;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeFolderActionResult.values().length];
            r0[OfficeFolderActionResult.Handled.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[OfficeFolderActionResult.Rejected.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[OfficeFolderActionResult.NotHandled.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements FragmentResultListener {
        public final /* synthetic */ OfficeFolderDetailHostFragment a;

        public c(OfficeFolderDetailHostFragment r1) {
            this.a = r1;
        }

        public final void onFragmentResult(String r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r3, "<unused var>");
            Intrinsics.checkNotNullParameter(r4, "result");
            OfficeFolderDetailHostFragment r5 = this.a;
            int r0 = OfficeFolderDetailHostFragment.t;
            r5.getClass();
            String r6 = r4.getString("office_space_document_created_tab");
            Object r1 = null;
            if (r6 != null) goto L17;
        L13:
            boolean r7 = r5.ba0();
            ConcurrentHashMap<h.a, WeakReference<p>> r2 = h.a;
            h.f(r5.Z90());
            if (r7 == true) goto L19;
            tt5.a.k("OfficeFolderDetailHost", "refresh current folder after office document created failed. folder=" + r5.V90().hashCode() + ", tab=" + r5.aa0() + ", sourceTab=" + r1);
            return;
        L19:
            return;
        L17:
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L6
            Object r9 = Result.constructor-impl(OfficeSpaceTab.valueOf(r6));     // Catch: Throwable -> L6
        L9:
            if (Result.isFailure-impl(r9) == true) goto L12;
            r1 = r9;
        L12:
            r1 = (OfficeSpaceTab) r1;
        L6:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        }
    }

    static {
    }

    public final void T90() {
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r0 = com.bytedance.ee.bear.office.export.space.m.a;
        com.bytedance.ee.bear.office.export.space.h r1 = com.bytedance.ee.bear.office.export.space.m.a(Z90());
        if (r1 == null) goto L5;
        r1.YJ(new OfficeSpaceSelectionState(aa0(), CollectionsKt.emptyList(), false));
    L5:
        ConcurrentHashMap<h.a, WeakReference<p>> r2 = h.a;
        h.i(Z90(), false, 0);
    }

    public final String V90() {
        return (String) this.f.getValue();
    }

    public final Bundle W90() {
        return (Bundle) this.d.getValue();
    }

    public final int X90() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final OfficeFolderPageRequest Y90() {
        return (OfficeFolderPageRequest) this.e.getValue();
    }

    public final String Z90() {
        return (String) this.k.getValue();
    }

    public final OfficeSpaceTab aa0() {
        return (OfficeSpaceTab) this.h.getValue();
    }

    public final void onPause() {
        boolean r0 = d0.a;
        d0.d(V90(), false);
        super.onPause();
    }

    public OfficeFolderDetailHostFragment() {
        this.d = LazyKt.lazy(new OfficeFolderDetailHostFragment$hostArgs$2(this));
        this.e = LazyKt.lazy(new OfficeFolderDetailHostFragment$request$2(this));
        this.f = LazyKt.lazy(new OfficeFolderDetailHostFragment$folderToken$2(this));
        this.g = LazyKt.lazy(new OfficeFolderDetailHostFragment$folderTitle$2(this));
        this.h = LazyKt.lazy(new OfficeFolderDetailHostFragment$tab$2(this));
        this.i = LazyKt.lazy(new OfficeFolderDetailHostFragment$ownerType$2(this));
        this.j = LazyKt.lazy(new OfficeFolderDetailHostFragment$listConfig$2(this));
        this.k = LazyKt.lazy(new OfficeFolderDetailHostFragment$runtimeId$2(this));
        this.l = LazyKt.lazy(new OfficeFolderDetailHostFragment$runtimeOwnedByFragment$2(this));
        this.m = -1;
        this.r = new OfficeFolderDetailHostFragment$uploadFolderRefreshCallback$1(this);
        this.s = LazyKt.lazy(new OfficeFolderDetailHostFragment$selectPanelHostDelegate$2(this));
    }

    public final void S90() {
        Fragment r0 = getChildFragmentManager().findFragmentByTag("office_folder_detail_child");
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = f1.a;
        f1.a(r0, this.n);
    }

    public final boolean ba0() {
        Fragment r0 = getChildFragmentManager().findFragmentByTag("office_folder_detail_child");
        int r1 = f1.a;
        return f1.d(r0, this.n);
    }

    public final void ca0() {
        ed5.d r0 = getChildFragmentManager().findFragmentByTag("office_folder_detail_child");
        if ((r0 instanceof ed5.d) == false) goto L7;
        ed5.d r1 = r0;
        if (r1.ZT() == false) goto L7;
        r1.xk();
    L7:
        ((OfficeSelectPanelHostDelegate) this.s.getValue()).d();
        OfficeFolderHeaderView r2 = this.o;
        if (r2 == null) goto L10;
        r2.setSelectionMode(false);
    L10:
        T90();
    }

    public final com.bytedance.ee.bear.office.export.space.b da0() {
        com.bytedance.ee.bear.office.export.space.b r0 = getParentFragment();
        if ((r0 instanceof com.bytedance.ee.bear.office.export.space.b) == false) goto L5;
        com.bytedance.ee.bear.office.export.space.b r1 = r0;
    L6:
        if (r1 != null) goto L11;
        com.bytedance.ee.bear.office.export.space.b r2 = getActivity();
        if ((r2 instanceof com.bytedance.ee.bear.office.export.space.b) == true) goto L13;
        return null;
    L13:
        return r2;
    L11:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean l1() {
        ed5.d r0 = getChildFragmentManager().findFragmentByTag("office_folder_detail_child");
        if ((r0 instanceof ed5.d) == false) goto L11;
        ed5.d r1 = r0;
        if (r1.ZT() == false) goto L11;
        r1.xk();
        ((OfficeSelectPanelHostDelegate) this.s.getValue()).d();
        OfficeFolderHeaderView r2 = this.o;
        if (r2 == null) goto L9;
        r2.setSelectionMode(false);
    L9:
        T90();
        tt5.a.h("OfficeFolderDetailHost", "handleBack exit selection first, ownerType=" + X90());
        return true;
    L11:
        OfficeFolderPageRequest r3 = Y90();
        if (r3 == null) goto L18;
        com.bytedance.ee.bear.office.export.space.b r4 = da0();
        if (r4 == null) goto L16;
        OfficeFolderActionResult r5 = r4.r50(r3);
    L17:
        if (r5 == null) goto L18;
    L20:
        if (r5 != OfficeFolderActionResult.Handled) goto L22;
    L27:
        return true;
    L22:
        if (r5 == OfficeFolderActionResult.Rejected) goto L27;
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L27;
        r6.finish();
        goto L27
    L16:
        r5 = null;
    L18:
        r5 = OfficeFolderActionResult.NotHandled;
        goto L20
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
        ca0();
        ((OfficeSelectPanelHostDelegate) this.s.getValue()).e();
        Fragment r0 = getChildFragmentManager().findFragmentByTag("office_folder_detail_child");
        if (r0 == null) goto L6;
        f1.a(r0, null);
    L6:
        this.n = null;
        OfficeUploadUiHost r1 = this.q;
        if (r1 == null) goto L9;
        r1.f();
    L9:
        this.q = null;
        OfficeFolderMoreMenuController r2 = this.p;
        if (r2 == null) goto L15;
        r2.e();
        com.bytedance.ee.bear.office.common.screenmenu.j r3 = r2.d;
        if (r3 == null) goto L14;
        r3.o();
    L14:
        r2.d = null;
    L15:
        this.p = null;
        boolean r4 = d0.a;
        String r5 = V90();
        Function0<Boolean> r6 = this.r;
        Intrinsics.checkNotNullParameter(r5, "folderToken");
        Intrinsics.checkNotNullParameter(r6, "refresh");
        Map<String, Set<Function0<Boolean>>> r7 = d0.e;
        Set r8 = (Set) ((LinkedHashMap) r7).get(r5);
        if (r8 == null) goto L21;
        r8.remove(r6);
        if (r8.isEmpty() == false) goto L21;
        r7.remove(r5);
        d0.f.remove(r5);
    L21:
        this.o = null;
        Fragment r9 = getChildFragmentManager().findFragmentByTag("office_folder_detail_child");
        if (r9 == null) goto L26;
        OfficeListPageMenuCapabilityRegistry r10 = OfficeListPageMenuCapabilityRegistry.a;
        String r11 = Z90();
        OfficeSpaceTab r12 = aa0();
        r10.getClass();
        OfficeListPageMenuCapabilityRegistry.h(r11, r12, r9);
    L26:
        if (((Boolean) this.l.getValue()).booleanValue() == false) goto L30;
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r13 = com.bytedance.ee.bear.office.export.space.m.a;
        String r14 = Z90();
        if (r14 == null) goto L30;
        com.bytedance.ee.bear.office.export.space.m.a.remove(r14);
    L30:
        super.onDestroyView();
        this.m = -1;
    }

    public final void onResume() {
        super.onResume();
        boolean r0 = d0.a;
        d0.d(V90(), true);
        String r1 = V90();
        Intrinsics.checkNotNullParameter(r1, "folderToken");
        if (d0.b.remove(r1) == false) goto L6;
        tt5.a.h("OfficeFolderDetailHost", "refresh folder after upload success, tokenHash=" + V90().hashCode());
        ba0();
        return;
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

    @Override // uc5.k
    public final boolean BX(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L7;
        r3.finish();
        return true;
    L7:
        return true;
    }

    @Override // ed5.f
    public final void It(ed5.a r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        OfficeFolderHeaderView r0 = this.o;
        if (r0 == null) goto L5;
        r0.setSelectionMode(r6.a);
    L5:
        ConcurrentHashMap<h.a, WeakReference<p>> r1 = h.a;
        h.i(Z90(), r6.a, r6.b.size());
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r2 = com.bytedance.ee.bear.office.export.space.m.a;
        com.bytedance.ee.bear.office.export.space.h r3 = com.bytedance.ee.bear.office.export.space.m.a(Z90());
        if (r3 == null) goto L8;
        r3.YJ(new OfficeSpaceSelectionState(aa0(), o.b(r6), r6.a));
    L8:
        ((OfficeSelectPanelHostDelegate) this.s.getValue()).g(r6, getChildFragmentManager().findFragmentByTag("office_folder_detail_child"));
    }

    public final OfficeSpaceActionResult U90(OfficeSpaceHeaderAction r5) {
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r0 = com.bytedance.ee.bear.office.export.space.m.a;
        com.bytedance.ee.bear.office.export.space.h r1 = com.bytedance.ee.bear.office.export.space.m.a(Z90());
        if (r1 == null) goto L6;
        OfficeSpaceActionResult r2 = r1.Zj(r5, new OfficeSpaceHeaderEventSource(aa0(), CollectionsKt.listOf(aa0())));
        if (r2 == null) goto L6;
    L7:
        tt5.a.h("OfficeFolderDetailHost", "dispatch folder header action, action=" + r5 + ", result=" + r2);
        return r2;
    L6:
        r2 = OfficeSpaceActionResult.NotHandled.INSTANCE;
        goto L7
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        getParentFragmentManager().setFragmentResultListener("office_space_document_created", this, new c(this));
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        int r14 = com.bytedance.ee.bear.office.list.adapter.f.b;
        com.bytedance.ee.bear.office.list.adapter.f.a.a((OfficeListConfig) this.j.getValue());
        com.bytedance.ee.bear.office.list.adapter.l.a r15 = com.bytedance.ee.bear.office.list.adapter.l.a;
        c1 r16 = d1.a;
        com.bytedance.ee.bear.office.list.adapter.l.a r0 = com.bytedance.ee.bear.office.list.adapter.l.a;
        if (r16 == r0) goto L5;
        d1.a = r0;
    L5:
        tt5.a.h("OfficeFolderDetailHost", "office_upload_recovery_trace folder_fragment_create_upload_host folder=" + V90().hashCode());
        OfficeFolderHeaderView r17 = this.o;
        boolean r1 = true;
        List r3 = null;
        if (r17 == null) goto L16;
        Integer r18 = Integer.valueOf(r17.getHeight());
        if (r18.intValue() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r18 = null;
    L14:
        if (r18 == null) goto L16;
    L28:
        int r19 = r18.intValue();
    L29:
        int r9 = r19;
        ViewGroup r5 = (ViewGroup) r12;
        LifecycleOwner r6 = getViewLifecycleOwner();
        int r110 = OfficeUploadRecoveryTarget.c;
        OfficeUploadRecoveryTarget r111 = OfficeUploadRecoveryTarget.a.a(V90());
        if (r111 == null) goto L34;
        r3 = CollectionsKt.listOf(r111);
    L34:
        if (r3 != null) goto L36;
        List r7 = CollectionsKt.emptyList();
    L37:
        OfficeUploadUiHost r112 = new OfficeUploadUiHost(r5, r6, r7, this.n, r9, com.bytedance.ee.bear.office.common.upload.e.a(requireContext(), 12));
        r112.e();
        this.q = r112;
        if (getChildFragmentManager().findFragmentByTag("office_folder_detail_child") == null) goto L78;
        S90();
    L68:
        boolean r113 = d0.a;
        String r114 = V90();
        Function0<Boolean> r115 = this.r;
        Intrinsics.checkNotNullParameter(r114, "folderToken");
        Intrinsics.checkNotNullParameter(r115, "refresh");
        if (StringsKt.isBlank(r114) == true) goto L80;
        LinkedHashMap r2 = (LinkedHashMap) d0.e;
        Object r8 = r2.get(r114);
        if (r8 != null) goto L74;
        r8 = new LinkedHashSet();
        r2.put(r114, r8);
    L74:
        ((Set) r8).add(r115);
        d0.b(r114);
        return;
    L80:
        return;
    L78:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L45
        FolderVersion.a r117 = FolderVersion.Companion;     // Catch: Throwable -> L45
        Integer r10 = Integer.valueOf(X90());     // Catch: Throwable -> L45
        r117.getClass();     // Catch: Throwable -> L45
        if (FolderVersion.a.c(r10) == false) goto L42;
        Fragment r118 = new SubFolderFragment();     // Catch: Throwable -> L45
    L43:
        r118.setArguments(new Bundle(W90()));     // Catch: Throwable -> L45
        Object r119 = Result.constructor-impl(r118);     // Catch: Throwable -> L45
    L47:
        Throwable r11 = Result.exceptionOrNull-impl(r119);
        if (r11 == null) goto L51;
        tt5.a.e("OfficeFolderDetailHost", "create office folder child fragment failed. tokenHash=" + V90().hashCode() + ", titleLength=" + ((String) this.g.getValue()).length() + ", ownerType=" + X90(), r11, false);
        r119 = new OfficeListLoadFailedFragment();
    L51:
        Fragment r120 = (Fragment) r119;
        FragmentTransaction r20 = getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L58
        int r21 = this.m;     // Catch: Throwable -> L58
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r20, r120, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "office_folder_detail_child", r21) == true) goto L56;
        r20.replace(r21, r120, "office_folder_detail_child");     // Catch: Throwable -> L58
    L56:
        r20.commitNow();     // Catch: Throwable -> L58
        S90();     // Catch: Throwable -> L58
        Object r121 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L58
    L60:
        Throwable r122 = Result.exceptionOrNull-impl(r121);
        if (r122 == null) goto L68;
        tt5.a.e("OfficeFolderDetailHost", "attach office folder child fragment failed. tokenHash=" + V90().hashCode() + ", titleLength=" + ((String) this.g.getValue()).length() + ", ownerType=" + X90(), r122, false);
        FragmentTransaction r123 = getChildFragmentManager().beginTransaction();
        int r22 = this.m;
        OfficeListLoadFailedFragment r23 = new OfficeListLoadFailedFragment();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r123, r23, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "office_folder_detail_child", r22) == true) goto L66;
        r123.replace(r22, r23, "office_folder_detail_child");
    L66:
        r123.commitNowAllowingStateLoss();
    L58:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r121 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L60
    L42:
        r118 = new FolderDetailFragment();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r119 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L36:
        r7 = r3;
        goto L37
    L10:
        r4 = false;
    L16:
        OfficeFolderHeaderView r124 = this.o;
        if (r124 == null) goto L26;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        if (r125 == null) goto L26;
        r18 = Integer.valueOf(r125.height);
        if (r18.intValue() > 0) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L26;
    L27:
        if (r18 != null) goto L28;
        r19 = com.bytedance.ee.bear.office.common.upload.e.a(requireContext(), 60);
    L26:
        r18 = null;
        goto L27
    }

    @Override // uc5.k
    public final boolean Qz(Fragment r6, Document r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "document");
        Intrinsics.checkNotNullParameter(r8, "currentModule");
        e r0 = e.a;
        Bundle r1 = W90();
        Context r2 = requireContext();
        r0.getClass();
        OfficeFolderPageRequest r3 = e.a(r1, r7, r8, r2);
        com.bytedance.ee.bear.office.export.space.b r4 = da0();
        if (r4 == null) goto L6;
        OfficeFolderActionResult r5 = r4.pH(r3);
        if (r5 == null) goto L6;
    L7:
        int r9 = b.a[r5.ordinal()];
        if (r9 != 1) goto L10;
        ca0();
        return true;
    L10:
        if (r9 != 2) goto L12;
        tt5.a.h("OfficeFolderDetailHost", "child folder navigation rejected, tokenHash=" + r3.getFolderToken().hashCode());
        return true;
    L12:
        if (r9 != 3) goto L23;
        tt5.a.k("OfficeFolderDetailHost", "child folder delegate not handled. tokenHash=" + r3.getFolderToken().hashCode());
        if (r3.getPayload().getListConfig().getDisableInternalFolderFallback() == false) goto L17;
        tt5.a.d("OfficeFolderDetailHost", "child folder delegate not handled and internal fallback disabled. tokenHash=" + r3.getFolderToken().hashCode() + ", currentTokenHash=" + V90().hashCode());
        return true;
    L17:
        boolean r10 = e.b(r6, r7, r8);
        if (r10 == false) goto L20;
        ca0();
    L21:
        return r10;
    L20:
        S90();
        goto L21
    L23:
        throw new NoWhenBranchMatchedException();
    L6:
        r5 = OfficeFolderActionResult.NotHandled;
        goto L7
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (n.a(r1, r2) == false) goto L6;
        tt5.a.h("OfficeFolderDetailHost", "refresh after selector result, tab=" + aa0() + ", requestCode=" + r1);
        ba0();
        return;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        this.m = View.generateViewId();
        FrameLayout r8 = new FrameLayout(requireContext());
        r8.setBackgroundColor(ContextCompat.getColor(r8.getContext(), 2131100548));
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LinearLayout r9 = new LinearLayout(requireContext());
        r9.setOrientation(1);
        r9.setBackgroundColor(ContextCompat.getColor(r9.getContext(), 2131100548));
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        OfficeFolderHeaderView r10 = new OfficeFolderHeaderView(requireContext());
        String r1 = (String) this.g.getValue();
        if (StringsKt.isBlank(r1) == false) goto L5;
        r1 = getString(2131887757);
    L5:
        r10.setTitle(r1);
        r10.setOnBackClick(new OfficeFolderDetailHostFragment$onCreateView$1$2(this));
        r10.setOnCancelSelectionClick(new OfficeFolderDetailHostFragment$onCreateView$1$3(this));
        r10.setOnSearchClick(new OfficeFolderDetailHostFragment$onCreateView$1$4(this));
        r10.setOnMoreClick(new OfficeFolderDetailHostFragment$onCreateView$1$5(this));
        this.o = r10;
        r9.addView(r10);
        int r11 = f1.a;
        View r12 = f1.b(requireContext(), this.m);
        l.a(r12);
        this.n = r12;
        r9.addView(r12, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r8.addView(r9);
        return r8;
    }
}
