package com.bytedance.ee.bear.office.space;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadRecoveryTarget;
import com.bytedance.ee.bear.office.common.upload.OfficeUploadUiHost;
import com.bytedance.ee.bear.office.common.upload.d0;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.OfficeListHostFragment;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lc5.x;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J$\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u000203H\u0002J\u0010\u0010=\u001a\u0002012\u0006\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010>\u001a\u0002012\u0006\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u0002012\u0006\u0010D\u001a\u00020\u001cH\u0002J\u0018\u0010E\u001a\u00020$2\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020.H\u0002J\u0010\u0010G\u001a\u0002012\u0006\u0010:\u001a\u00020\u001cH\u0002J \u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020\fH\u0002J \u0010M\u001a\u00020$2\u0006\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00020.2\u0006\u0010L\u001a\u00020\fH\u0002J\u0018\u0010N\u001a\u00020$2\u0006\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00020.H\u0002J\u0016\u0010O\u001a\u00020.2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020.0 H\u0002J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020.0 H\u0002J\b\u0010R\u001a\u000201H\u0002J\u0018\u0010S\u001a\u0002012\u0006\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00020.H\u0002J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020.0 H\u0002J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020.0 H\u0002J\u0010\u0010V\u001a\u0002012\u0006\u0010W\u001a\u00020\u001cH\u0002J\u0010\u0010X\u001a\u0002012\u0006\u0010W\u001a\u00020\u001cH\u0002J\f\u0010Y\u001a\u000201*\u00020ZH\u0002J\n\u0010[\u001a\u0004\u0018\u00010.H\u0002J\b\u0010\\\u001a\u00020$H\u0016J\u0010\u0010]\u001a\u0002012\u0006\u0010^\u001a\u00020.H\u0002J\f\u0010_\u001a\u00020\f*\u00020.H\u0002J\u001a\u0010`\u001a\u0002012\u0006\u0010a\u001a\u00020$2\b\b\u0002\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u000201H\u0016J\b\u0010e\u001a\u000201H\u0016J\u000e\u0010f\u001a\u00020\f*\u0004\u0018\u00010\fH\u0002J\f\u0010g\u001a\u00020\f*\u00020\u001cH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/bytedance/ee/bear/office/space/OfficeSpaceFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceRefreshController;", "<init>", "()V", "config", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "getConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "config$delegate", "Lkotlin/Lazy;", "runtimeId", "", "getRuntimeId", "()Ljava/lang/String;", "runtimeId$delegate", "enterContext", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "getEnterContext", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "enterContext$delegate", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "pageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "tabLayout", "Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabLayout;", "selectionHeader", "Landroid/view/View;", "selectionTitle", "Landroid/widget/TextView;", "normalHeaderButtons", "", "uploadUiHost", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadUiHost;", "pendingHeaderMoreRetry", "", "pendingTabActionType", "hasConsumedInitialPageSelected", "skipNextTabTrackReport", "headerLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "mainHandler", "Landroid/os/Handler;", "scheduledPreloadTabs", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "hasStartedRecentOpenTiming", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "handleOfficeDocumentCreatedResult", "result", "bindHeaderVisibility", "bindHeaderActions", "dispatchExternalHeaderAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "action", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "showInternalHeaderMoreMenu", "anchor", "dispatchInternalHeaderMoreMenu", "tab", "bindPager", "scheduleAdjacentPreloadAfterFirstFrame", "adapter", "Lcom/bytedance/ee/bear/office/space/OfficeSpacePagerAdapter;", "currentTab", "reason", "preloadTabHost", "selectTabFromListRuntime", "initialTabFor", "tabs", "currentTabs", "installMenuConfig", "handleTabClick", "orderedTabs", "visibleTabs", "bindTabLayoutRules", RootDescription.ROOT_ELEMENT, "applyTabLayoutRules", "clearTabRules", "Landroid/widget/RelativeLayout$LayoutParams;", "currentSelectedTab", "refreshCurrentTabWithoutScroll", "updateSelectedTab", "selectedTab", "analyticsClick", "renderSelectionMode", "inSelectionMode", "selectedCount", "", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "toLogKey", "headerMoreAnchorState", "Companion", "office-space_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceFragment extends Fragment implements com.bytedance.ee.bear.office.export.space.l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f236036v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f236037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f236038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f236039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewPager2 f236040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OfficeSpaceFragment$bindPager$callback$1 f236041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OfficeSpaceTabLayout f236042i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f236043j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f236044k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<? extends View> f236045l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OfficeUploadUiHost f236046m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f236047n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f236048o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f236049p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f236050q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public g f236051r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Handler f236052s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Set<OfficeSpaceTab> f236053t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f236054u;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f236055a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f236056b = null;

        static {
            int[] r100 = new int[OfficeSpaceTabAnchor.values().length];
            r100[OfficeSpaceTabAnchor.PARENT_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[OfficeSpaceTabAnchor.MENU_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r100[OfficeSpaceTabAnchor.RIGHT_ACTIONS_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[OfficeSpaceTabAnchor.PARENT_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            f236055a = r100;
            int[] r101 = new int[OfficeSpaceTab.values().length];
            r101[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r101[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r101[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r101[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            f236056b = r101;
        }
    }

    public static final class c implements com.bytedance.ee.bear.office.export.space.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSpaceFragment f236059a;

        @Override // com.bytedance.ee.bear.office.export.space.i
        public final com.bytedance.ee.bear.office.export.space.h a() {
            ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r100 = com.bytedance.ee.bear.office.export.space.m.f235477a;
            OfficeSpaceFragment r101 = this.f236059a;
            int r102 = OfficeSpaceFragment.f236036v;
            return com.bytedance.ee.bear.office.export.space.m.a(r101.Z90());
        }

        public c(OfficeSpaceFragment r100) {
            this.f236059a = r100;
        }

        @Override // com.bytedance.ee.bear.office.export.space.i
        public final OfficeSpaceActionResult b(OfficeSpaceHeaderAction r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return OfficeSpaceFragment.S90(this.f236059a, r100);
        }
    }

    public static final class d implements FragmentResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSpaceFragment f236060a;

        public d(OfficeSpaceFragment r100) {
            this.f236060a = r100;
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public final void onFragmentResult(String r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "result");
            OfficeSpaceFragment r102 = this.f236060a;
            int r103 = OfficeSpaceFragment.f236036v;
            r102.getClass();
            String r104 = r101.getString("office_space_document_created_tab");
            Object r105 = null;
            if (r104 != null) goto L17;
        L13:
            ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r106 = com.bytedance.ee.bear.office.list.h.f235894a;
            com.bytedance.ee.bear.office.list.h.f(r102.Z90());
            OfficeSpaceTab r107 = OfficeSpaceTab.MINE;
            if (r105 != r107) goto L19;
            com.bytedance.ee.bear.office.list.h.j(r102.Z90(), r107);
            return;
        L19:
            return;
        L17:
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L6
            Object r109 = Result.m9449constructorimpl(OfficeSpaceTab.valueOf(r104));     // Catch: Throwable -> L6
        L9:
            if (Result.m9455isFailureimpl(r109) == true) goto L12;
            r105 = r109;
        L12:
            r105 = (OfficeSpaceTab) r105;
        L6:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L9
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSpaceFragment f236061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<OfficeSpaceTab> f236062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f236063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OfficeSpaceTab f236064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ OfficeSpacePagerAdapter f236065e;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OfficeSpaceFragment f236066a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List<OfficeSpaceTab> f236067b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f236068c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ OfficeSpaceTab f236069d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ OfficeSpacePagerAdapter f236070e;

            /* JADX WARN: Multi-variable type inference failed */
            public a(OfficeSpaceFragment r100, List<? extends OfficeSpaceTab> r101, String r102, OfficeSpaceTab r103, OfficeSpacePagerAdapter r104) {
                this.f236066a = r100;
                this.f236067b = r101;
                this.f236068c = r102;
                this.f236069d = r103;
                this.f236070e = r104;
            }

            public final void a() {
                if (this.f236066a.isAdded() == true) goto L5;
            L14:
                this.f236066a.f236053t.removeAll(CollectionsKt.toSet(this.f236067b));
                StringBuilder r100 = new StringBuilder("[OfficeCreatePerf] stage=adjacent_preload_skip runtime=");
                OfficeSpaceFragment r101 = this.f236066a;
                r100.append(r101.da0(r101.Z90()));
                r100.append(" reason=");
                r100.append(this.f236068c);
                r100.append(" targets=");
                r100.append(this.f236067b);
                r100.append(" cause=fragment_inactive");
                tt5.a.k("OfficeSpaceFragment", r100.toString());
                return;
            L5:
                if (this.f236066a.getView() == null) goto L14;
                StringBuilder r102 = new StringBuilder("[OfficeCreatePerf] stage=adjacent_preload_execute runtime=");
                OfficeSpaceFragment r103 = this.f236066a;
                int r104 = OfficeSpaceFragment.f236036v;
                r102.append(r103.da0(r103.Z90()));
                r102.append(" reason=");
                r102.append(this.f236068c);
                r102.append(" currentTab=");
                r102.append(this.f236069d);
                r102.append(" targets=");
                r102.append(this.f236067b);
                tt5.a.h("OfficeSpaceFragment", r102.toString());
                List<OfficeSpaceTab> r105 = this.f236067b;
                OfficeSpaceFragment r106 = this.f236066a;
                OfficeSpacePagerAdapter r107 = this.f236070e;
                String r108 = this.f236068c;
                Iterator<T> r109 = r105.iterator();
            L9:
                if (r109.hasNext() == false) goto L13;
                OfficeSpaceTab r110 = (OfficeSpaceTab) r109.next();
                if (OfficeSpaceFragment.T90(r106, r107, r110, r108) == true) goto L9;
                r106.f236053t.remove(r110);
                goto L9
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

        /* JADX WARN: Multi-variable type inference failed */
        public e(OfficeSpaceFragment r100, List<? extends OfficeSpaceTab> r101, String r102, OfficeSpaceTab r103, OfficeSpacePagerAdapter r104) {
            this.f236061a = r100;
            this.f236062b = r101;
            this.f236063c = r102;
            this.f236064d = r103;
            this.f236065e = r104;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeSpaceFragment r100 = this.f236061a;     // Catch: Throwable -> L4
            r100.f236052s.postDelayed(new a(r100, this.f236062b, this.f236063c, this.f236064d, this.f236065e), 50);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.office.space.OfficeSpaceFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<Boolean, Integer, Unit> {
        public AnonymousClass3(Object r100) {
            super(2, r100, OfficeSpaceFragment.class, "renderSelectionMode", "renderSelectionMode(ZI)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Integer r101) {
            invoke(r100.booleanValue(), r101.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r100, int r101) {
            OfficeSpaceFragment r102 = (OfficeSpaceFragment) this.receiver;
            int r103 = OfficeSpaceFragment.f236036v;
            r102.ba0(r100, r101);
        }
    }

    static {
    }

    public final OfficeSpaceTab W90() {
        ViewPager2 r100 = this.f236040g;
        if (r100 != null) goto L5;
        return null;
    L5:
        RecyclerView.Adapter r101 = r100.getAdapter();
        if ((r101 instanceof OfficeSpacePagerAdapter) == false) goto L8;
        OfficeSpacePagerAdapter r102 = (OfficeSpacePagerAdapter) r101;
    L9:
        if (r102 != null) goto L12;
        return null;
    L12:
        return (OfficeSpaceTab) CollectionsKt.getOrNull(r102.f236071a, r100.getCurrentItem());
    L8:
        r102 = null;
        goto L9
    }

    public final OfficeSpaceConfig Y90() {
        return (OfficeSpaceConfig) this.f236037d.getValue();
    }

    public final String Z90() {
        return (String) this.f236038e.getValue();
    }

    public final List<OfficeSpaceTab> fa0() {
        OfficeSpaceTab.Companion.getClass();
        List r100 = CollectionsKt.listOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE});
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Y90().getEnabledTabs().contains((OfficeSpaceTab) r103) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        boolean r104 = r101.isEmpty();
        List<OfficeSpaceTab> r105 = r101;
        if (r104 == false) goto L12;
        r105 = CollectionsKt.listOf(OfficeSpaceTab.RECENT);
    L12:
        return r105;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        tt5.a.h("OfficeSpaceFragment", "destroy space fragment, keep shared menu config, runtime=" + da0(Z90()));
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r100 = com.bytedance.ee.bear.office.list.h.f235894a;
        String r101 = com.bytedance.ee.bear.office.list.h.g(Z90());
        tt5.a.h("OfficeListHostRegistry", "clear pending page selected, runtime=" + com.bytedance.ee.bear.office.list.h.l(r101));
        com.bytedance.ee.bear.office.list.h.f235895b.remove(r101);
        com.bytedance.ee.bear.office.list.h.f235896c.remove(r101);
        com.bytedance.ee.bear.office.list.h.f235897d.remove(r101);
        com.bytedance.ee.bear.office.list.h.f235898e.remove(r101);
        com.bytedance.ee.bear.office.list.h.f235899f.remove(r101);
        com.bytedance.ee.bear.office.list.h.f235901h.remove(r101);
        Set<com.bytedance.ee.bear.office.list.h.a> r102 = com.bytedance.ee.bear.office.list.h.f235900g.keySet();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.office.list.h.a) r105).f235902a, r101) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        Iterator r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        com.bytedance.ee.bear.office.list.h.f235900g.remove((com.bytedance.ee.bear.office.list.h.a) r106.next());
        goto L10
    L12:
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r107 = com.bytedance.ee.bear.office.export.space.m.f235477a;
        String r108 = Z90();
        if (r108 == null) goto L15;
        com.bytedance.ee.bear.office.export.space.m.f235477a.remove(r108);
    L15:
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        OfficeSpaceFragment$bindPager$callback$1 r100 = this.f236041h;
        if (r100 == null) goto L7;
        tt5.a.h("OfficeSpaceFragment", "unregister page callback, runtime=" + da0(Z90()));
        ViewPager2 r101 = this.f236040g;
        if (r101 == null) goto L7;
        r101.unregisterOnPageChangeCallback(r100);
    L7:
        this.f236041h = null;
        ViewPager2 r102 = this.f236040g;
        if (r102 == null) goto L10;
        r102.setAdapter(null);
    L10:
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r103 = com.bytedance.ee.bear.office.list.h.f235894a;
        com.bytedance.ee.bear.office.list.h.a(Z90());
        String r104 = com.bytedance.ee.bear.office.list.h.g(Z90());
        tt5.a.h("OfficeListHostRegistry", "unregister tab selection requester, runtime=" + com.bytedance.ee.bear.office.list.h.l(r104));
        com.bytedance.ee.bear.office.list.h.f235898e.remove(r104);
        String r105 = com.bytedance.ee.bear.office.list.h.g(Z90());
        tt5.a.h("OfficeListHostRegistry", "unregister tab preload requester, runtime=" + com.bytedance.ee.bear.office.list.h.l(r105));
        com.bytedance.ee.bear.office.list.h.f235899f.remove(r105);
        com.bytedance.ee.bear.office.list.h.f235901h.remove(com.bytedance.ee.bear.office.list.h.g(Z90()));
        this.f236052s.removeCallbacksAndMessages(null);
        this.f236053t.clear();
        OfficeUploadUiHost r106 = this.f236046m;
        if (r106 == null) goto L13;
        r106.f();
    L13:
        this.f236046m = null;
        this.f236047n = false;
        g r107 = this.f236051r;
        if (r107 == null) goto L20;
        View r108 = getView();
        if (r108 == null) goto L20;
        View r109 = r108.findViewById(R.id.office_space_header);
        if (r109 == null) goto L20;
        r109.removeOnLayoutChangeListener(r107);
    L20:
        this.f236051r = null;
        this.f236043j = null;
        this.f236044k = null;
        this.f236045l = CollectionsKt.emptyList();
        this.f236040g = null;
        this.f236042i = null;
        super.onDestroyView();
    }

    public OfficeSpaceFragment() {
        this.f236037d = LazyKt.lazy(new OfficeSpaceFragment$config$2(this));
        this.f236038e = LazyKt.lazy(new OfficeSpaceFragment$runtimeId$2(this));
        this.f236039f = LazyKt.lazy(new OfficeSpaceFragment$enterContext$2(this));
        this.f236045l = CollectionsKt.emptyList();
        this.f236052s = new Handler(Looper.getMainLooper());
        this.f236053t = new LinkedHashSet();
    }

    @Override // com.bytedance.ee.bear.office.export.space.l
    public final boolean Ei() {
        OfficeSpaceTab r100 = W90();
        boolean r101 = false;
        if (r100 != null) goto L6;
        tt5.a.h("OfficeSpaceFragment", "refresh current tab skipped, runtime=" + da0(Z90()) + ", reason=current_tab_missing");
        return false;
    L6:
        tt5.a.h("OfficeSpaceFragment", "refresh current tab without scroll, runtime=" + da0(Z90()) + ", tab=" + r100);
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r102 = com.bytedance.ee.bear.office.list.h.f235894a;
        com.bytedance.ee.bear.office.list.h.h(Z90(), r100);
        boolean r103 = d0.f235354a;
        if (r100 != OfficeSpaceTab.MINE) goto L9;
        r101 = true;
    L9:
        d0.f235356c = r101;
        d0.c();
        return true;
    }

    public static String aa0(View r100) {
        return "attached=" + r100.isAttachedToWindow() + ",size=" + r100.getWidth() + Permission.EXECUTE + r100.getHeight() + ",shown=" + r100.isShown() + ",windowFocus=" + r100.hasWindowFocus();
    }

    public final void U90(View r110) {
        OfficeSpaceTabLayout r100 = (OfficeSpaceTabLayout) r110.findViewById(R.id.office_space_tab_layout);
        if (r100 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Integer r102 = null;
        if ((r101 instanceof RelativeLayout.LayoutParams) == false) goto L8;
        RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r101;
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        View r104 = r110.findViewById(R.id.office_space_header);
        int r105 = j.f236117a;
        Context r106 = requireContext();
        if (r104 == null) goto L14;
        int r111 = r104.getWidth();
    L15:
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r107 = r106.getResources();
        float r108 = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).density;
        Integer r112 = Integer.valueOf(r111);
        boolean r109 = false;
        if (r112.intValue() <= 0) goto L18;
        boolean r113 = true;
    L19:
        if (r113 == false) goto L21;
        r102 = r112;
    L21:
        if (r102 == null) goto L23;
        int r114 = r102.intValue();
    L24:
        int r115 = k.f236118a;
        if (r107.getConfiguration().smallestScreenWidthDp < 600) goto L27;
        boolean r116 = true;
    L28:
        if (r116 == false) goto L31;
    L36:
        boolean r117 = true;
    L38:
        int r118 = q.f236130d;
        boolean r119 = Y90().getHeaderConfig().getShowLeftMenu();
        if (Y90().getHeaderConfig().getShowSearch() == false) goto L41;
    L42:
        r109 = true;
    L43:
        if (r117 == false) goto L46;
        q r120 = new q(OfficeSpaceTabAnchor.PARENT_START, OfficeSpaceTabAnchor.PARENT_END, OfficeSpaceTabAlignment.CENTER);
    L56:
        r103.removeRule(20);
        r103.removeRule(21);
        r103.removeRule(16);
        r103.removeRule(17);
        r103.removeRule(13);
        r103.removeRule(14);
        r103.addRule(15);
        Resources r121 = getResources();
        if (r120.f236133c != OfficeSpaceTabAlignment.START) goto L59;
        int r122 = R.dimen.office_space_tab_layout_margin_start_aligned;
    L60:
        r103.setMarginStart(r121.getDimensionPixelSize(r122));
        r103.setMarginEnd(getResources().getDimensionPixelSize(R.dimen.office_space_tab_layout_margin_default));
        OfficeSpaceTabAnchor r123 = r120.f236131a;
        int[] r124 = b.f236055a;
        int r125 = r124[r123.ordinal()];
        if (r125 == 1) goto L69;
        if (r125 == 2) goto L68;
        if (r125 == 3) goto L70;
        if (r125 == 4) goto L70;
        throw new NoWhenBranchMatchedException();
    L70:
        int r126 = r124[r120.f236132b.ordinal()];
        if (r126 == 1) goto L79;
        if (r126 == 2) goto L79;
        if (r126 == 3) goto L78;
        if (r126 != 4) goto L77;
        r103.addRule(21);
        goto L79
    L77:
        throw new NoWhenBranchMatchedException();
    L78:
        r103.addRule(16, R.id.office_space_right_actions);
    L79:
        r100.setLayoutParams(r103);
        r100.setContentAlignment$office_space_productionChinaRelease(r120.f236133c);
        return;
    L68:
        r103.addRule(17, R.id.office_space_menu_button);
        goto L70
    L69:
        r103.addRule(20);
        goto L70
    L59:
        r122 = R.dimen.office_space_tab_layout_margin_default;
        goto L60
    L46:
        if (r119 == false) goto L48;
        OfficeSpaceTabAnchor r127 = OfficeSpaceTabAnchor.MENU_END;
    L49:
        if (r109 == false) goto L51;
        OfficeSpaceTabAnchor r128 = OfficeSpaceTabAnchor.RIGHT_ACTIONS_START;
    L52:
        if (r119 == false) goto L54;
        OfficeSpaceTabAlignment r129 = OfficeSpaceTabAlignment.CENTER;
    L55:
        r120 = new q(r127, r128, r129);
        goto L56
    L54:
        r129 = OfficeSpaceTabAlignment.START;
        goto L55
    L51:
        r128 = OfficeSpaceTabAnchor.PARENT_END;
        goto L52
    L48:
        r127 = OfficeSpaceTabAnchor.PARENT_START;
        goto L49
    L41:
        if (Y90().getHeaderConfig().getShowMore() == false) goto L43;
    L31:
        if (r108 <= 0.0f) goto L37;
        if (r114 <= 0) goto L37;
        if ((r114 / r108) >= 840.0f) goto L36;
    L37:
        r117 = false;
        goto L38
    L27:
        r116 = false;
        goto L28
    L23:
        r114 = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).widthPixels;
        goto L24
    L18:
        r113 = false;
        goto L19
    L14:
        r111 = r110.getWidth();
        goto L15
    L8:
        r103 = null;
        goto L9
    }

    public final void V90(View r100) {
        View r101 = r100.findViewById(R.id.office_space_menu_button);
        int r102 = 0;
        if (Y90().getHeaderConfig().getShowLeftMenu() == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        View r104 = r100.findViewById(R.id.office_space_search_button);
        if (Y90().getHeaderConfig().getShowSearch() == false) goto L9;
        int r105 = 0;
    L10:
        r104.setVisibility(r105);
        View r106 = r100.findViewById(R.id.office_space_more_button);
        if (Y90().getHeaderConfig().getShowMore() == false) goto L13;
        int r107 = 0;
    L14:
        r106.setVisibility(r107);
        View r108 = r100.findViewById(R.id.office_space_right_actions);
        if (Y90().getHeaderConfig().getShowSearch() == false) goto L17;
    L20:
        r108.setVisibility(r102);
        return;
    L17:
        if (Y90().getHeaderConfig().getShowMore() == true) goto L20;
        r102 = 8;
        goto L20
    L13:
        r107 = 8;
        goto L14
    L9:
        r105 = 8;
        goto L10
    L5:
        r103 = 8;
        goto L6
    }

    public final String da0(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return "default";
    L11:
        return "hash=" + r100.hashCode();
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public final void ea0(OfficeSpaceTab r100) {
        OfficeSpaceTabLayout r101 = this.f236042i;
        if (r101 == null) goto L22;
        int r102 = OfficeSpaceTabLayout.f236079k;
        Intrinsics.checkNotNullParameter(r100, "tab");
        if (r101.f236081b == r100) goto L7;
    L9:
        r101.f236081b = r100;
        Iterator<Map.Entry<OfficeSpaceTab, TextView>> r103 = r101.f236080a.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<OfficeSpaceTab, TextView> r104 = r103.next();
        OfficeSpaceTab r105 = r104.getKey();
        TextView r106 = r104.getValue();
        if (r105 != r100) goto L15;
        int r107 = r101.f236083d;
    L16:
        r106.setTextColor(r107);
        goto L11
    L15:
        r107 = r101.f236084e;
        goto L16
    L17:
        r101.d(r100, true, true);
        r101.c(r100, true);
        return;
    L7:
        if (r101.f236087h.getLayoutParams().width <= 0) goto L9;
        r101.c(r100, true);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        getParentFragmentManager().setFragmentResultListener("office_space_document_created", this, new d(this));
    }

    public static final OfficeSpaceActionResult S90(OfficeSpaceFragment r100, OfficeSpaceHeaderAction r101) {
        r100.getClass();
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r102 = com.bytedance.ee.bear.office.list.h.f235894a;
        com.bytedance.ee.bear.office.list.h.a(r100.Z90());
        OfficeSpaceTab r103 = r100.W90();
        if (r103 != null) goto L5;
        r103 = OfficeSpaceTab.RECENT;
    L5:
        ViewPager2 r104 = r100.f236040g;
        if (r104 != null) goto L8;
        List<OfficeSpaceTab> r105 = r100.fa0();
    L16:
        OfficeSpaceHeaderEventSource r106 = new OfficeSpaceHeaderEventSource(r103, r105);
        if (r101 != OfficeSpaceHeaderAction.CREATE_DOC) goto L19;
    L24:
        String r107 = com.bytedance.ee.bear.office.list.h.g(r100.Z90());
        OfficeSpaceTab r108 = OfficeSpaceTab.RECENT;
        com.bytedance.ee.bear.office.list.p r109 = com.bytedance.ee.bear.office.list.h.c(r107, r108);
        if ((r109 instanceof OfficeListHostFragment) == false) goto L48;
        tt5.a.h("OfficeListHostRegistry", "notify recent create action dispatched, runtime=" + com.bytedance.ee.bear.office.list.h.l(r107));
        OfficeListHostFragment r110 = (OfficeListHostFragment) r109;
        if (r110.W90() != r108) goto L48;
        r110.f235538n = true;
        r110.f235539o = false;
        tt5.a.h("OfficeListHostFragment", "mark RECENT create action dispatched");
    L48:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L37
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r112 = com.bytedance.ee.bear.office.export.space.m.f235477a;     // Catch: Throwable -> L37
        com.bytedance.ee.bear.office.export.space.h r113 = com.bytedance.ee.bear.office.export.space.m.a(r100.Z90());     // Catch: Throwable -> L37
        if (r113 == null) goto L34;
        OfficeSpaceActionResult r114 = r113.Zj(r101, r106);     // Catch: Throwable -> L37
        if (r114 == null) goto L34;
    L35:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L37
    L39:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L44;
        tt5.a.l("OfficeSpaceFragment", "dispatch header action failed, runtime=" + r100.da0(r100.Z90()) + ", action=" + r101, r116);
        r115 = OfficeSpaceActionResult.NotHandled.INSTANCE;
    L44:
        if ((((OfficeSpaceActionResult) r115) instanceof OfficeSpaceActionResult.Handled) == false) goto L47;
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L47:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L34:
        r114 = OfficeSpaceActionResult.NotHandled.INSTANCE;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L19:
        if (r101 == OfficeSpaceHeaderAction.CREATE_PPT) goto L24;
        if (r101 == OfficeSpaceHeaderAction.CREATE_BITABLE) goto L24;
        if (r101 != OfficeSpaceHeaderAction.CREATE_SHEET) goto L48;
    L8:
        RecyclerView.Adapter r118 = r104.getAdapter();
        if ((r118 instanceof OfficeSpacePagerAdapter) == false) goto L11;
        OfficeSpacePagerAdapter r119 = (OfficeSpacePagerAdapter) r118;
    L12:
        if (r119 == null) goto L15;
        r105 = r119.f236071a;
        if (r105 != null) goto L16;
    L15:
        r105 = CollectionsKt.listOf(OfficeSpaceTab.RECENT);
        goto L16
    L11:
        r119 = null;
        goto L12
    }

    public final boolean X90(View r100, OfficeSpaceTab r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r103 = com.bytedance.ee.bear.office.list.h.f235894a;     // Catch: Throwable -> L4
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(com.bytedance.ee.bear.office.list.h.k(Z90(), r101, r100, new c(this))));     // Catch: Throwable -> L4
    L6:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L11;
        tt5.a.e("OfficeSpaceFragment", "show header more menu failed, runtime=" + da0(Z90()) + ", tab=" + r101, r105, false);
        r104 = Boolean.FALSE;
    L11:
        return ((Boolean) r104).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void ba0(boolean r110, int r111) {
        View r100 = this.f236043j;
        if (r100 == null) goto L8;
        if (r110 == false) goto L6;
        int r101 = 0;
    L7:
        r100.setVisibility(r101);
        goto L8
    L6:
        r101 = 8;
    L8:
        TextView r102 = this.f236044k;
        if (r102 == null) goto L14;
        if (r110 == false) goto L12;
        String r112 = StringsKt.replace$default(getString(R.string.Doc_Permission_AddUserSelectedTips), "{{count}}", String.valueOf(r111), false, 4, null);
    L13:
        r102.setText(r112);
        goto L14
    L12:
        r112 = "";
    L14:
        Iterator<T> r113 = this.f236045l.iterator();
    L16:
        if (r113.hasNext() == false) goto L22;
        View r103 = (View) r113.next();
        if (r110 == false) goto L20;
        int r104 = 8;
    L21:
        r103.setVisibility(r104);
        goto L16
    L20:
        r104 = 0;
        goto L21
    L22:
        if (r110 == true) goto L26;
        View r114 = getView();
        if (r114 == null) goto L26;
        V90(r114);
    L26:
        ViewPager2 r115 = this.f236040g;
        if (r115 == null) goto L33;
        r115.setUserInputEnabled(!r110);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v30, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.bytedance.ee.bear.office.space.OfficeSpaceFragment$bindPager$callback$1] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r210);
        String r100 = Y90().getMenuConfigJson();
        com.bytedance.ee.bear.widgets.menuconfig.c r101 = com.bytedance.ee.bear.widgets.menuconfig.c.f240244a;
        monitor-enter(r101);
        com.bytedance.ee.bear.widgets.menuconfig.a.f240242a.getClass();     // Catch: Throwable -> L105
        com.bytedance.ee.bear.widgets.menuconfig.c.f240245b = com.bytedance.ee.bear.widgets.menuconfig.a.a(r100);     // Catch: Throwable -> L105
        monitor-exit(r101);
        V90(r110);
        U90(r110);
        View r102 = r110.findViewById(R.id.office_space_header);
        if (r102 == null) goto L10;
        g r103 = new g(this, r110);
        this.f236051r = r103;
        r102.addOnLayoutChangeListener(r103);
    L10:
        r110.findViewById(R.id.office_space_menu_button).setOnClickListener(new com.bytedance.ee.bear.office.space.c(this));
        r110.findViewById(R.id.office_space_search_button).setOnClickListener(new com.bytedance.ee.bear.office.space.d(this));
        r110.findViewById(R.id.office_space_more_button).setOnClickListener(new com.bytedance.ee.bear.office.space.e(this));
        this.f236043j = r110.findViewById(R.id.office_space_selection_header);
        this.f236044k = (TextView) r110.findViewById(R.id.office_space_selection_title);
        boolean r104 = false;
        this.f236045l = CollectionsKt.listOf(new View[]{r110.findViewById(R.id.office_space_menu_button), r110.findViewById(R.id.office_space_right_actions), r110.findViewById(R.id.office_space_tab_layout)});
        r110.findViewById(R.id.office_space_selection_cancel).setOnClickListener(new f(this));
        List<OfficeSpaceTab> r111 = fa0();
        OfficeSpaceTab r105 = Y90().getInitialTab();
        String r106 = null;
        if (r111.contains(r105) == true) goto L14;
        r105 = null;
    L14:
        if (r105 != null) goto L16;
        r105 = (OfficeSpaceTab) CollectionsKt.first(r111);
    L16:
        OfficeSpaceTab r112 = r105;
        tt5.a.h("OfficeSpaceFragment", "bind pager, runtime=" + da0(Z90()) + ", tabs=" + r111 + ", initialTab=" + Y90().getInitialTab() + ", actualInitialTab=" + r112);
        if (this.f236054u == true) goto L44;
        int r107 = com.bytedance.ee.bear.office.list.q.f235952a;
        OfficeSpaceConfig r108 = Y90();
        OfficeSpaceEnterContext r113 = (OfficeSpaceEnterContext) this.f236039f.getValue();
        String r114 = Z90();
        Intrinsics.checkNotNullParameter(r108, "config");
        Intrinsics.checkNotNullParameter(r112, "actualInitialTab");
        Intrinsics.checkNotNullParameter(r113, "enterContext");
        if (com.bytedance.ee.bear.office.list.q.a(r108, r112, r113, r114) == true) goto L21;
        boolean r109 = false;
    L43:
        this.f236054u = r109;
    L62:
        final OfficeSpacePagerAdapter r115 = new OfficeSpacePagerAdapter(this, r111, Y90(), Z90(), (OfficeSpaceEnterContext) this.f236039f.getValue());
        OfficeSpaceTabLayout r116 = (OfficeSpaceTabLayout) r110.findViewById(R.id.office_space_tab_layout);
        Function1<OfficeSpaceTab, Unit> r117 = new OfficeSpaceFragment$bindPager$1$1(this, r115);
        r116.getClass();
        Intrinsics.checkNotNullParameter(r111, "tabs");
        Intrinsics.checkNotNullParameter(r112, "selected");
        Intrinsics.checkNotNullParameter(r117, "listener");
        r116.f236086g.removeAllViews();
        r116.f236080a.clear();
        r116.f236082c = r117;
        Iterator<T> r118 = r111.iterator();
    L64:
        if (r118.hasNext() == false) goto L84;
        OfficeSpaceTab r119 = (OfficeSpaceTab) r118.next();
        TextView r120 = new TextView(r116.getContext());
        int r121 = OfficeSpaceTabLayout.b.f236091b[r119.ordinal()];
        if (r121 != 1) goto L68;
        String r122 = r116.getContext().getString(R.string.LarkCCM_Doubao_Drive_Recent_Tab);
    L79:
        r120.setText(r122);
        r120.setTextSize(2, 17.0f);
        r120.setIncludeFontPadding(false);
        r120.setTypeface(Typeface.DEFAULT_BOLD);
        r120.setGravity(17);
        if (r119 != r112) goto L82;
        int r123 = r116.f236083d;
    L83:
        r120.setTextColor(r123);
        r120.setOnClickListener(new o(r116, r119));
        LinearLayout r124 = r116.f236086g;
        LinearLayout.LayoutParams r125 = new LinearLayout.LayoutParams(-2, r116.b(24.0f));
        int r126 = r116.b(10.0f);
        r125.leftMargin = r126;
        r125.rightMargin = r126;
        Unit r127 = Unit.INSTANCE;
        r124.addView(r120, r125);
        r116.f236080a.put(r119, r120);
        goto L64
    L82:
        r123 = r116.f236084e;
        goto L83
    L68:
        if (r121 != 2) goto L70;
        r122 = r116.getContext().getString(R.string.LarkCCM_Doubao_Drive_Mine_Tab);
        goto L79
    L70:
        if (r121 != 3) goto L72;
        r122 = r116.getContext().getString(R.string.LarkCCM_Doubao_Drive_Shared_Tab);
        goto L79
    L72:
        if (r121 != 4) goto L75;
        r122 = r116.getContext().getString(R.string.LarkCCM_Doubao_Drive_Favorites_Tab);
        goto L79
    L75:
        throw new NoWhenBranchMatchedException();
    L84:
        r116.f236081b = r112;
        r116.post(new p(r116, r112));
        this.f236042i = r116;
        ?? r128 = new OfficeSpaceFragment$bindPager$callback$1(r115, this);
        this.f236041h = r128;
        ViewPager2 r129 = (ViewPager2) r110.findViewById(R.id.office_space_view_pager);
        r129.setAdapter(r115);
        r129.registerOnPageChangeCallback(r128);
        this.f236040g = r129;
        int r130 = r115.f236071a.indexOf(r112);
        ViewPager2 r131 = this.f236040g;
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r132 = com.bytedance.ee.bear.office.list.h.f235894a;
        String r133 = Z90();
        Function1<OfficeSpaceTab, Boolean> r134 = new OfficeSpaceFragment$bindPager$3(this, r115);
        Intrinsics.checkNotNullParameter(r134, "requester");
        String r135 = com.bytedance.ee.bear.office.list.h.g(r133);
        tt5.a.h("OfficeListHostRegistry", "register tab selection requester, runtime=" + com.bytedance.ee.bear.office.list.h.l(r135));
        com.bytedance.ee.bear.office.list.h.f235898e.put(r135, r134);
        String r136 = Z90();
        Function1<OfficeSpaceTab, Boolean> r137 = new OfficeSpaceFragment$bindPager$4(this, r115);
        Intrinsics.checkNotNullParameter(r137, "requester");
        String r138 = com.bytedance.ee.bear.office.list.h.g(r136);
        tt5.a.h("OfficeListHostRegistry", "register tab preload requester, runtime=" + com.bytedance.ee.bear.office.list.h.l(r138));
        com.bytedance.ee.bear.office.list.h.f235899f.put(r138, r137);
        if (r131 != null) goto L87;
    L89:
        boolean r139 = false;
    L91:
        if (r139 == false) goto L96;
        tt5.a.h("OfficeSpaceFragment", "dispatch initial tab without pager switch, runtime=" + da0(Z90()) + ", tab=" + r112);
        this.f236049p = true;
        ea0(r112);
        com.bytedance.ee.bear.office.list.h.h(Z90(), r112);
        boolean r140 = d0.f235354a;
        if (r112 != OfficeSpaceTab.MINE) goto L95;
        r104 = true;
    L95:
        d0.f235356c = r104;
        d0.c();
    L103:
        ca0(r115, r112, "initial_after_first_frame");
        tt5.a.h("OfficeSpaceFragment", "office_upload_recovery_trace root_fragment_create_upload_host runtime=" + da0(Z90()));
        ViewGroup r141 = (ViewGroup) r110.findViewById(R.id.office_space_upload_overlay);
        Intrinsics.checkNotNull(r141);
        LifecycleOwner r142 = getViewLifecycleOwner();
        int r143 = OfficeUploadRecoveryTarget.f235302c;
        List r144 = CollectionsKt.listOf(OfficeUploadRecoveryTarget.a.b());
        View r145 = r110.findViewById(R.id.office_space_view_pager);
        Resources r146 = requireContext().getResources();
        OfficeUploadUiHost r147 = new OfficeUploadUiHost(r141, r142, r144, r145, 0, (int) (WindowDisplayMetricsOverride.apply(r146, r146.getDisplayMetrics()).density * 12));
        r147.e();
        this.f236046m = r147;
        String r148 = Z90();
        AnonymousClass3 r149 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r149, "listener");
        com.bytedance.ee.bear.office.list.h.f235901h.put(com.bytedance.ee.bear.office.list.h.g(r148), r149);
        return;
    L96:
        tt5.a.h("OfficeSpaceFragment", "switch to initial tab, runtime=" + da0(Z90()) + ", tab=" + r112 + ", index=" + r130);
        this.f236049p = false;
        if (r131 == null) goto L99;
        r131.setCurrentItem(r130, false);
    L99:
        ea0(r112);
        boolean r150 = d0.f235354a;
        if (r112 != OfficeSpaceTab.MINE) goto L102;
        r104 = true;
    L102:
        d0.f235356c = r104;
        d0.c();
        goto L103
    L87:
        if (r131.getCurrentItem() != r130) goto L89;
        r139 = true;
        goto L91
    L21:
        x r151 = x.c();
        long r152 = r113.getClickStartMs();
        r151.getClass();
        if (r152 <= 0) goto L38;
        if (r152 <= 0) goto L33;
        Long r153 = (Long) ((ConcurrentHashMap) r151.f508597a).get("init");
        Long r154 = (Long) ((ConcurrentHashMap) r151.f508597a).get("key_open_finish_recent");
        if (r153 == null) goto L33;
        if (r153.longValue() != r152) goto L33;
        if (r154 == null) goto L33;
        if (r154.longValue() != r152) goto L33;
        boolean r155 = true;
    L34:
        if (r155 == true) goto L38;
        r151.i("doc_sdk_init");
        r151.i("doc_tab_fragment_init");
        r151.i("init");
        r151.i("load_from_network");
        r151.i("load_db_data");
        r151.i("update_db_data");
        r151.i("pre_load_db_data");
        r151.i("pre_load_online_data");
        r151.i("pre_load_from_network");
        r151.i("fill_ui");
        r151.i("inflate_doc_tab_layout");
        r151.i("inflate_recent_layout");
        r151.i("inflate_list_layout");
        r151.i("bind_list_item");
        r151.j("key_open_finish_recent");
        r151.k(r152, new String[]{"init", "key_open_finish_recent"});
        r151.f508600d = null;
        r151.f508602f = false;
        r151.f508601e = false;
    L33:
        r155 = false;
    L38:
        if (r114 == null) goto L40;
        r106 = StringsKt.takeLast(r114, 8);
    L40:
        if (r106 != null) goto L42;
        r106 = "";
    L42:
        tt5.a.h("OfficeSpacePerformanceReporter", "start office space open timing, runtime=".concat(r106));
        r109 = true;
        goto L43
    L44:
        int r156 = com.bytedance.ee.bear.office.list.q.f235952a;
        OfficeSpaceConfig r157 = Y90();
        OfficeSpaceEnterContext r158 = (OfficeSpaceEnterContext) this.f236039f.getValue();
        String r159 = Z90();
        Intrinsics.checkNotNullParameter(r157, "config");
        Intrinsics.checkNotNullParameter(r112, "actualInitialTab");
        Intrinsics.checkNotNullParameter(r158, "enterContext");
        if (com.bytedance.ee.bear.office.list.q.a(r157, r112, r158, r159) == false) goto L62;
        x r160 = x.c();
        long r161 = r158.getClickStartMs();
        if (r161 > 0) goto L50;
        r160.getClass();
        goto L62
    L50:
        if (Boolean.TRUE.equals(((ConcurrentHashMap) r160.f508598b).get("key_open_finish_recent")) == true) goto L62;
        Long r162 = (Long) ((ConcurrentHashMap) r160.f508597a).get("init");
        Long r163 = (Long) ((ConcurrentHashMap) r160.f508597a).get("key_open_finish_recent");
        if (r162 != null) goto L55;
    L60:
        r160.i("init");
        r160.j("key_open_finish_recent");
        r160.k(r161, new String[]{"init", "key_open_finish_recent"});
        goto L62
    L55:
        if (r162.longValue() != r161) goto L60;
        if (r163 == null) goto L60;
        if (r163.longValue() != r161) goto L60;
    L105:
        th = move-exception;
        throw th;
    }

    public final void ca0(OfficeSpacePagerAdapter r110, OfficeSpaceTab r111, String r210) {
        View r100 = getView();
        if (r100 != null) goto L6;
        tt5.a.k("OfficeSpaceFragment", "[OfficeCreatePerf] stage=adjacent_preload_skip runtime=" + da0(Z90()) + " reason=" + r210 + " currentTab=" + r111 + " cause=root_missing");
        return;
    L6:
        int r101 = com.bytedance.ee.bear.office.space.b.f236101a;
        List<OfficeSpaceTab> r102 = r110.f236071a;
        Intrinsics.checkNotNullParameter(r102, "tabs");
        Intrinsics.checkNotNullParameter(r111, "currentTab");
        int r112 = r102.indexOf(r111);
        if (r112 >= 0) goto L9;
        List r103 = CollectionsKt.emptyList();
    L26:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r103.iterator();
    L28:
        if (r114.hasNext() == false) goto L32;
        Object r115 = r114.next();
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r116 = com.bytedance.ee.bear.office.list.h.f235894a;
        if (com.bytedance.ee.bear.office.list.h.e(Z90(), (OfficeSpaceTab) r115) == true) goto L28;
        r113.add(r115);
        goto L28
    L32:
        ArrayList r117 = new ArrayList();
        Iterator r118 = r113.iterator();
    L34:
        if (r118.hasNext() == false) goto L39;
        Object r119 = r118.next();
        if (this.f236053t.add((OfficeSpaceTab) r119) == false) goto L34;
        r117.add(r119);
        goto L34
    L39:
        if (r117.isEmpty() == false) goto L42;
        tt5.a.h("OfficeSpaceFragment", "[OfficeCreatePerf] stage=adjacent_preload_skip runtime=" + da0(Z90()) + " reason=" + r210 + " currentTab=" + r111 + " adjacentTabs=" + r103 + " cause=ready_or_scheduled");
        return;
    L42:
        tt5.a.h("OfficeSpaceFragment", "[OfficeCreatePerf] stage=adjacent_preload_schedule runtime=" + da0(Z90()) + " reason=" + r210 + " currentTab=" + r111 + " targets=" + r117 + " visibleTabs=" + r110.f236071a);
        r100.post(new e(this, r117, r210, r111, r110));
        return;
    L9:
        List r120 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(r112 - 1), Integer.valueOf(r112 + 1)});
        ArrayList r121 = new ArrayList();
        Iterator r122 = r120.iterator();
    L11:
        if (r122.hasNext() == false) goto L21;
        Object r123 = r122.next();
        int r124 = ((Number) r123).intValue();
        if (r124 >= 0) goto L15;
    L17:
        boolean r125 = false;
    L18:
        if (r125 == false) goto L11;
        r121.add(r123);
        goto L11
    L15:
        if (r124 >= r102.size()) goto L17;
        r125 = true;
        goto L18
    L21:
        ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r127 = r121.iterator();
    L23:
        if (r127.hasNext() == false) goto L25;
        r126.add((OfficeSpaceTab) ListProtector.get(r102, ((Number) r127.next()).intValue()));
        goto L23
    L25:
        r103 = r126;
        goto L26
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.office_space_fragment, r101, false);
    }

    public static final boolean T90(OfficeSpaceFragment r110, OfficeSpacePagerAdapter r111, OfficeSpaceTab r112, String r113) {
        ViewPager2 r100 = r110.f236040g;
        if (r100 != null) goto L5;
        tt5.a.k("OfficeSpaceFragment", "[OfficeCreatePerf] stage=tab_preload_skip runtime=" + r110.da0(r110.Z90()) + " tab=" + r112 + " reason=" + r113 + " cause=pager_missing");
        return false;
    L5:
        Integer r114 = Integer.valueOf(r111.f236071a.indexOf(r112));
        if (r114.intValue() < 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        r114 = null;
    L12:
        if (r114 == null) goto L18;
        int r102 = r114.intValue();
        int r115 = r100.getCurrentItem();
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r103 = com.bytedance.ee.bear.office.list.h.f235894a;
        if (com.bytedance.ee.bear.office.list.h.e(r110.Z90(), r112) == false) goto L16;
        tt5.a.h("OfficeSpaceFragment", "[OfficeCreatePerf] stage=tab_preload_already_ready runtime=" + r110.da0(r110.Z90()) + " tab=" + r112 + " reason=" + r113 + " currentIndex=" + r115 + " targetIndex=" + r102);
    L17:
        return true;
    L16:
        long r116 = System.currentTimeMillis();
        tt5.a.h("OfficeSpaceFragment", "[OfficeCreatePerf] stage=tab_preload_start runtime=" + r110.da0(r110.Z90()) + " tab=" + r112 + " reason=" + r113 + " currentIndex=" + r115 + " targetIndex=" + r102);
        r100.setOffscreenPageLimit(Math.max(1, Math.abs(r115 - r102)));
        r100.post(new h(r110, r112, r113, r100, r102, r116));
        goto L17
    L18:
        tt5.a.k("OfficeSpaceFragment", "[OfficeCreatePerf] stage=tab_preload_skip runtime=" + r110.da0(r110.Z90()) + " tab=" + r112 + " reason=" + r113 + " cause=tab_missing");
        return false;
    L8:
        r101 = false;
        goto L9
    }
}
