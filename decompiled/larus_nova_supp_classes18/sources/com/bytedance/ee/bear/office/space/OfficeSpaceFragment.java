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
import androidx.viewpager2.widget.ViewPager2;
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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
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
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lc5.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J$\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u000203H\u0002J\u0010\u0010=\u001a\u0002012\u0006\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010>\u001a\u0002012\u0006\u0010:\u001a\u00020\u001cH\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u0002012\u0006\u0010D\u001a\u00020\u001cH\u0002J\u0018\u0010E\u001a\u00020$2\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020.H\u0002J\u0010\u0010G\u001a\u0002012\u0006\u0010:\u001a\u00020\u001cH\u0002J \u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020\fH\u0002J \u0010M\u001a\u00020$2\u0006\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00020.2\u0006\u0010L\u001a\u00020\fH\u0002J\u0018\u0010N\u001a\u00020$2\u0006\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00020.H\u0002J\u0016\u0010O\u001a\u00020.2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020.0 H\u0002J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020.0 H\u0002J\b\u0010R\u001a\u000201H\u0002J\u0018\u0010S\u001a\u0002012\u0006\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00020.H\u0002J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020.0 H\u0002J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020.0 H\u0002J\u0010\u0010V\u001a\u0002012\u0006\u0010W\u001a\u00020\u001cH\u0002J\u0010\u0010X\u001a\u0002012\u0006\u0010W\u001a\u00020\u001cH\u0002J\f\u0010Y\u001a\u000201*\u00020ZH\u0002J\n\u0010[\u001a\u0004\u0018\u00010.H\u0002J\b\u0010\\\u001a\u00020$H\u0016J\u0010\u0010]\u001a\u0002012\u0006\u0010^\u001a\u00020.H\u0002J\f\u0010_\u001a\u00020\f*\u00020.H\u0002J\u001a\u0010`\u001a\u0002012\u0006\u0010a\u001a\u00020$2\b\b\u0002\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u000201H\u0016J\b\u0010e\u001a\u000201H\u0016J\u000e\u0010f\u001a\u00020\f*\u0004\u0018\u00010\fH\u0002J\f\u0010g\u001a\u00020\f*\u00020\u001cH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, d2 = {"Lcom/bytedance/ee/bear/office/space/OfficeSpaceFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceRefreshController;", "<init>", "()V", "config", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "getConfig", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceConfig;", "config$delegate", "Lkotlin/Lazy;", "runtimeId", "", "getRuntimeId", "()Ljava/lang/String;", "runtimeId$delegate", "enterContext", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "getEnterContext", "()Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEnterContext;", "enterContext$delegate", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "pageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "tabLayout", "Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabLayout;", "selectionHeader", "Landroid/view/View;", "selectionTitle", "Landroid/widget/TextView;", "normalHeaderButtons", "", "uploadUiHost", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadUiHost;", "pendingHeaderMoreRetry", "", "pendingTabActionType", "hasConsumedInitialPageSelected", "skipNextTabTrackReport", "headerLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "mainHandler", "Landroid/os/Handler;", "scheduledPreloadTabs", "", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceTab;", "hasStartedRecentOpenTiming", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "handleOfficeDocumentCreatedResult", "result", "bindHeaderVisibility", "bindHeaderActions", "dispatchExternalHeaderAction", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceActionResult;", "action", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderAction;", "showInternalHeaderMoreMenu", "anchor", "dispatchInternalHeaderMoreMenu", "tab", "bindPager", "scheduleAdjacentPreloadAfterFirstFrame", "adapter", "Lcom/bytedance/ee/bear/office/space/OfficeSpacePagerAdapter;", "currentTab", "reason", "preloadTabHost", "selectTabFromListRuntime", "initialTabFor", "tabs", "currentTabs", "installMenuConfig", "handleTabClick", "orderedTabs", "visibleTabs", "bindTabLayoutRules", "root", "applyTabLayoutRules", "clearTabRules", "Landroid/widget/RelativeLayout$LayoutParams;", "currentSelectedTab", "refreshCurrentTabWithoutScroll", "updateSelectedTab", "selectedTab", "analyticsClick", "renderSelectionMode", "inSelectionMode", "selectedCount", "", "onDestroyView", "onDestroy", "toLogKey", "headerMoreAnchorState", "Companion", "office-space_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceFragment extends Fragment implements com.bytedance.ee.bear.office.export.space.l {
    public static final /* synthetic */ int v = 0;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public ViewPager2 g;
    public OfficeSpaceFragment$bindPager$callback$1 h;
    public OfficeSpaceTabLayout i;
    public View j;
    public TextView k;
    public List<? extends View> l;
    public OfficeUploadUiHost m;
    public boolean n;
    public String o;
    public boolean p;
    public boolean q;
    public g r;
    public final Handler s;
    public final Set<OfficeSpaceTab> t;
    public boolean u;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OfficeSpaceTabAnchor.values().length];
            r0[OfficeSpaceTabAnchor.PARENT_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r0[OfficeSpaceTabAnchor.MENU_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r0[OfficeSpaceTabAnchor.RIGHT_ACTIONS_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[OfficeSpaceTabAnchor.PARENT_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            a = r0;
            int[] r1 = new int[OfficeSpaceTab.values().length];
            r1[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r1[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r1[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r1[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            b = r1;
        }
    }

    public static final class c implements com.bytedance.ee.bear.office.export.space.i {
        public final /* synthetic */ OfficeSpaceFragment a;

        @Override // com.bytedance.ee.bear.office.export.space.i
        public final com.bytedance.ee.bear.office.export.space.h a() {
            ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r0 = com.bytedance.ee.bear.office.export.space.m.a;
            OfficeSpaceFragment r1 = this.a;
            int r2 = OfficeSpaceFragment.v;
            return com.bytedance.ee.bear.office.export.space.m.a(r1.Z90());
        }

        public c(OfficeSpaceFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.office.export.space.i
        public final OfficeSpaceActionResult b(OfficeSpaceHeaderAction r2) {
            Intrinsics.checkNotNullParameter(r2, "action");
            return OfficeSpaceFragment.S90(this.a, r2);
        }
    }

    public static final class d implements FragmentResultListener {
        public final /* synthetic */ OfficeSpaceFragment a;

        public d(OfficeSpaceFragment r1) {
            this.a = r1;
        }

        public final void onFragmentResult(String r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r3, "<unused var>");
            Intrinsics.checkNotNullParameter(r4, "result");
            OfficeSpaceFragment r5 = this.a;
            int r0 = OfficeSpaceFragment.v;
            r5.getClass();
            String r6 = r4.getString("office_space_document_created_tab");
            Object r1 = null;
            if (r6 != null) goto L17;
        L13:
            ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r7 = com.bytedance.ee.bear.office.list.h.a;
            com.bytedance.ee.bear.office.list.h.f(r5.Z90());
            OfficeSpaceTab r8 = OfficeSpaceTab.MINE;
            if (r1 != r8) goto L19;
            com.bytedance.ee.bear.office.list.h.j(r5.Z90(), r8);
            return;
        L19:
            return;
        L17:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L6
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

    public static final class e implements Runnable {
        public final /* synthetic */ OfficeSpaceFragment a;
        public final /* synthetic */ List<OfficeSpaceTab> b;
        public final /* synthetic */ String c;
        public final /* synthetic */ OfficeSpaceTab d;
        public final /* synthetic */ OfficeSpacePagerAdapter e;

        public static final class a implements Runnable {
            public final /* synthetic */ OfficeSpaceFragment a;
            public final /* synthetic */ List<OfficeSpaceTab> b;
            public final /* synthetic */ String c;
            public final /* synthetic */ OfficeSpaceTab d;
            public final /* synthetic */ OfficeSpacePagerAdapter e;

            /* JADX WARN: Multi-variable type inference failed */
            public a(OfficeSpaceFragment r1, List<? extends OfficeSpaceTab> r2, String r3, OfficeSpaceTab r4, OfficeSpacePagerAdapter r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            public final void a() {
                if (this.a.isAdded() == true) goto L5;
            L14:
                this.a.t.removeAll(CollectionsKt.toSet(this.b));
                StringBuilder r0 = new StringBuilder("[OfficeCreatePerf] stage=adjacent_preload_skip runtime=");
                OfficeSpaceFragment r4 = this.a;
                r0.append(r4.da0(r4.Z90()));
                r0.append(" reason=");
                r0.append(this.c);
                r0.append(" targets=");
                r0.append(this.b);
                r0.append(" cause=fragment_inactive");
                tt5.a.k("OfficeSpaceFragment", r0.toString());
                return;
            L5:
                if (this.a.getView() == null) goto L14;
                StringBuilder r1 = new StringBuilder("[OfficeCreatePerf] stage=adjacent_preload_execute runtime=");
                OfficeSpaceFragment r5 = this.a;
                int r6 = OfficeSpaceFragment.v;
                r1.append(r5.da0(r5.Z90()));
                r1.append(" reason=");
                r1.append(this.c);
                r1.append(" currentTab=");
                r1.append(this.d);
                r1.append(" targets=");
                r1.append(this.b);
                tt5.a.h("OfficeSpaceFragment", r1.toString());
                List<OfficeSpaceTab> r2 = this.b;
                OfficeSpaceFragment r3 = this.a;
                OfficeSpacePagerAdapter r7 = this.e;
                String r8 = this.c;
                Iterator<T> r9 = r2.iterator();
            L9:
                if (r9.hasNext() == false) goto L13;
                OfficeSpaceTab r10 = (OfficeSpaceTab) r9.next();
                if (OfficeSpaceFragment.T90(r3, r7, r10, r8) == true) goto L9;
                r3.t.remove(r10);
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
        public e(OfficeSpaceFragment r1, List<? extends OfficeSpaceTab> r2, String r3, OfficeSpaceTab r4, OfficeSpacePagerAdapter r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OfficeSpaceFragment r1 = this.a;     // Catch: Throwable -> L4
            r1.s.postDelayed(new a(r1, this.b, this.c, this.d, this.e), 50);     // Catch: Throwable -> L4
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
        public AnonymousClass3(Object r8) {
            super(2, r8, OfficeSpaceFragment.class, "renderSelectionMode", "renderSelectionMode(ZI)V", 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke(((Boolean) r1).booleanValue(), ((Number) r2).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r3, int r4) {
            OfficeSpaceFragment r0 = (OfficeSpaceFragment) ((CallableReference) this).receiver;
            int r1 = OfficeSpaceFragment.v;
            r0.ba0(r3, r4);
        }
    }

    static {
    }

    public final OfficeSpaceTab W90() {
        ViewPager2 r0 = this.g;
        if (r0 != null) goto L5;
        return null;
    L5:
        OfficeSpacePagerAdapter r2 = r0.getAdapter();
        if ((r2 instanceof OfficeSpacePagerAdapter) == false) goto L8;
        OfficeSpacePagerAdapter r3 = r2;
    L9:
        if (r3 != null) goto L12;
        return null;
    L12:
        return (OfficeSpaceTab) CollectionsKt.getOrNull(r3.a, r0.getCurrentItem());
    L8:
        r3 = null;
        goto L9
    }

    public final OfficeSpaceConfig Y90() {
        return (OfficeSpaceConfig) this.d.getValue();
    }

    public final String Z90() {
        return (String) this.e.getValue();
    }

    public final List<OfficeSpaceTab> fa0() {
        OfficeSpaceTab.Companion.getClass();
        List r0 = CollectionsKt.listOf(new OfficeSpaceTab[]{OfficeSpaceTab.RECENT, OfficeSpaceTab.MINE, OfficeSpaceTab.SHARED, OfficeSpaceTab.FAVORITE});
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Y90().getEnabledTabs().contains((OfficeSpaceTab) r3) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        boolean r4 = r1.isEmpty();
        List<OfficeSpaceTab> r5 = r1;
        if (r4 == false) goto L12;
        r5 = CollectionsKt.listOf(OfficeSpaceTab.RECENT);
    L12:
        return r5;
    }

    public final void onDestroy() {
        tt5.a.h("OfficeSpaceFragment", "destroy space fragment, keep shared menu config, runtime=" + da0(Z90()));
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r0 = com.bytedance.ee.bear.office.list.h.a;
        String r1 = com.bytedance.ee.bear.office.list.h.g(Z90());
        tt5.a.h("OfficeListHostRegistry", "clear pending page selected, runtime=" + com.bytedance.ee.bear.office.list.h.l(r1));
        com.bytedance.ee.bear.office.list.h.b.remove(r1);
        com.bytedance.ee.bear.office.list.h.c.remove(r1);
        com.bytedance.ee.bear.office.list.h.d.remove(r1);
        com.bytedance.ee.bear.office.list.h.e.remove(r1);
        com.bytedance.ee.bear.office.list.h.f.remove(r1);
        com.bytedance.ee.bear.office.list.h.h.remove(r1);
        Set<com.bytedance.ee.bear.office.list.h.a> r2 = com.bytedance.ee.bear.office.list.h.g.keySet();
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((com.bytedance.ee.bear.office.list.h.a) r5).a, r1) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterator r6 = r3.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        com.bytedance.ee.bear.office.list.h.g.remove((com.bytedance.ee.bear.office.list.h.a) r6.next());
        goto L10
    L12:
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r7 = com.bytedance.ee.bear.office.export.space.m.a;
        String r8 = Z90();
        if (r8 == null) goto L15;
        com.bytedance.ee.bear.office.export.space.m.a.remove(r8);
    L15:
        super.onDestroy();
    }

    public final void onDestroyView() {
        OfficeSpaceFragment$bindPager$callback$1 r0 = this.h;
        if (r0 == null) goto L7;
        tt5.a.h("OfficeSpaceFragment", "unregister page callback, runtime=" + da0(Z90()));
        ViewPager2 r1 = this.g;
        if (r1 == null) goto L7;
        r1.unregisterOnPageChangeCallback(r0);
    L7:
        this.h = null;
        ViewPager2 r2 = this.g;
        if (r2 == null) goto L10;
        r2.setAdapter(null);
    L10:
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r3 = com.bytedance.ee.bear.office.list.h.a;
        com.bytedance.ee.bear.office.list.h.a(Z90());
        String r4 = com.bytedance.ee.bear.office.list.h.g(Z90());
        tt5.a.h("OfficeListHostRegistry", "unregister tab selection requester, runtime=" + com.bytedance.ee.bear.office.list.h.l(r4));
        com.bytedance.ee.bear.office.list.h.e.remove(r4);
        String r5 = com.bytedance.ee.bear.office.list.h.g(Z90());
        tt5.a.h("OfficeListHostRegistry", "unregister tab preload requester, runtime=" + com.bytedance.ee.bear.office.list.h.l(r5));
        com.bytedance.ee.bear.office.list.h.f.remove(r5);
        com.bytedance.ee.bear.office.list.h.h.remove(com.bytedance.ee.bear.office.list.h.g(Z90()));
        this.s.removeCallbacksAndMessages(null);
        this.t.clear();
        OfficeUploadUiHost r6 = this.m;
        if (r6 == null) goto L13;
        r6.f();
    L13:
        this.m = null;
        this.n = false;
        g r7 = this.r;
        if (r7 == null) goto L20;
        View r8 = getView();
        if (r8 == null) goto L20;
        View r9 = r8.findViewById(2131381378);
        if (r9 == null) goto L20;
        r9.removeOnLayoutChangeListener(r7);
    L20:
        this.r = null;
        this.j = null;
        this.k = null;
        this.l = CollectionsKt.emptyList();
        this.g = null;
        this.i = null;
        super.onDestroyView();
    }

    public OfficeSpaceFragment() {
        this.d = LazyKt.lazy(new OfficeSpaceFragment$config$2(this));
        this.e = LazyKt.lazy(new OfficeSpaceFragment$runtimeId$2(this));
        this.f = LazyKt.lazy(new OfficeSpaceFragment$enterContext$2(this));
        this.l = CollectionsKt.emptyList();
        this.s = new Handler(Looper.getMainLooper());
        this.t = new LinkedHashSet();
    }

    @Override // com.bytedance.ee.bear.office.export.space.l
    public final boolean Ei() {
        OfficeSpaceTab r0 = W90();
        boolean r1 = false;
        if (r0 != null) goto L6;
        tt5.a.h("OfficeSpaceFragment", "refresh current tab skipped, runtime=" + da0(Z90()) + ", reason=current_tab_missing");
        return false;
    L6:
        tt5.a.h("OfficeSpaceFragment", "refresh current tab without scroll, runtime=" + da0(Z90()) + ", tab=" + r0);
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r2 = com.bytedance.ee.bear.office.list.h.a;
        com.bytedance.ee.bear.office.list.h.h(Z90(), r0);
        boolean r3 = d0.a;
        if (r0 != OfficeSpaceTab.MINE) goto L9;
        r1 = true;
    L9:
        d0.c = r1;
        d0.c();
        return true;
    }

    public static String aa0(View r2) {
        return "attached=" + r2.isAttachedToWindow() + ",size=" + r2.getWidth() + 'x' + r2.getHeight() + ",shown=" + r2.isShown() + ",windowFocus=" + r2.hasWindowFocus();
    }

    public final void U90(View r13) {
        OfficeSpaceTabLayout r0 = (OfficeSpaceTabLayout) r13.findViewById(2131381386);
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Integer r3 = null;
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L8;
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        View r4 = r13.findViewById(2131381378);
        int r5 = j.a;
        Context r6 = requireContext();
        if (r4 == null) goto L14;
        int r14 = r4.getWidth();
    L15:
        Intrinsics.checkNotNullParameter(r6, "context");
        Resources r7 = r6.getResources();
        float r8 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).density;
        Integer r15 = Integer.valueOf(r14);
        boolean r9 = false;
        if (r15.intValue() <= 0) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
        r3 = r15;
    L21:
        if (r3 == null) goto L23;
        int r16 = r3.intValue();
    L24:
        int r11 = k.a;
        if (r7.getConfiguration().smallestScreenWidthDp < 600) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L31;
    L36:
        boolean r17 = true;
    L38:
        int r18 = q.d;
        boolean r19 = Y90().getHeaderConfig().getShowLeftMenu();
        if (Y90().getHeaderConfig().getShowSearch() == false) goto L41;
    L42:
        r9 = true;
    L43:
        if (r17 == false) goto L46;
        q r110 = new q(OfficeSpaceTabAnchor.PARENT_START, OfficeSpaceTabAnchor.PARENT_END, OfficeSpaceTabAlignment.CENTER);
    L56:
        r2.removeRule(20);
        r2.removeRule(21);
        r2.removeRule(16);
        r2.removeRule(17);
        r2.removeRule(13);
        r2.removeRule(14);
        r2.addRule(15);
        Resources r20 = getResources();
        if (r110.c != OfficeSpaceTabAlignment.START) goto L59;
        int r21 = 2131167881;
    L60:
        r2.setMarginStart(r20.getDimensionPixelSize(r21));
        r2.setMarginEnd(getResources().getDimensionPixelSize(2131167880));
        OfficeSpaceTabAnchor r22 = r110.a;
        int[] r23 = b.a;
        int r24 = r23[r22.ordinal()];
        if (r24 == 1) goto L69;
        if (r24 == 2) goto L68;
        if (r24 == 3) goto L70;
        if (r24 == 4) goto L70;
        throw new NoWhenBranchMatchedException();
    L70:
        int r25 = r23[r110.b.ordinal()];
        if (r25 == 1) goto L79;
        if (r25 == 2) goto L79;
        if (r25 == 3) goto L78;
        if (r25 != 4) goto L77;
        r2.addRule(21);
        goto L79
    L77:
        throw new NoWhenBranchMatchedException();
    L78:
        r2.addRule(16, 2131381381);
    L79:
        r0.setLayoutParams(r2);
        r0.setContentAlignment$office_space_productionChinaRelease(r110.c);
        return;
    L68:
        r2.addRule(17, 2131381379);
        goto L70
    L69:
        r2.addRule(20);
        goto L70
    L59:
        r21 = 2131167880;
        goto L60
    L46:
        if (r19 == false) goto L48;
        OfficeSpaceTabAnchor r26 = OfficeSpaceTabAnchor.MENU_END;
    L49:
        if (r9 == false) goto L51;
        OfficeSpaceTabAnchor r27 = OfficeSpaceTabAnchor.RIGHT_ACTIONS_START;
    L52:
        if (r19 == false) goto L54;
        OfficeSpaceTabAlignment r28 = OfficeSpaceTabAlignment.CENTER;
    L55:
        r110 = new q(r26, r27, r28);
        goto L56
    L54:
        r28 = OfficeSpaceTabAlignment.START;
        goto L55
    L51:
        r27 = OfficeSpaceTabAnchor.PARENT_END;
        goto L52
    L48:
        r26 = OfficeSpaceTabAnchor.PARENT_START;
        goto L49
    L41:
        if (Y90().getHeaderConfig().getShowMore() == false) goto L43;
    L31:
        if (r8 <= 0.0f) goto L37;
        if (r16 <= 0) goto L37;
        if ((r16 / r8) >= 840.0f) goto L36;
    L37:
        r17 = false;
        goto L38
    L27:
        r12 = false;
        goto L28
    L23:
        r16 = WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics()).widthPixels;
        goto L24
    L18:
        r10 = false;
        goto L19
    L14:
        r14 = r13.getWidth();
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    public final void V90(View r5) {
        View r0 = r5.findViewById(2131381379);
        int r2 = 0;
        if (Y90().getHeaderConfig().getShowLeftMenu() == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        View r3 = r5.findViewById(2131381382);
        if (Y90().getHeaderConfig().getShowSearch() == false) goto L9;
        int r4 = 0;
    L10:
        r3.setVisibility(r4);
        View r6 = r5.findViewById(2131381380);
        if (Y90().getHeaderConfig().getShowMore() == false) goto L13;
        int r7 = 0;
    L14:
        r6.setVisibility(r7);
        View r8 = r5.findViewById(2131381381);
        if (Y90().getHeaderConfig().getShowSearch() == false) goto L17;
    L20:
        r8.setVisibility(r2);
        return;
    L17:
        if (Y90().getHeaderConfig().getShowMore() == true) goto L20;
        r2 = 8;
        goto L20
    L13:
        r7 = 8;
        goto L14
    L9:
        r4 = 8;
        goto L10
    L5:
        r1 = 8;
        goto L6
    }

    public final String da0(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return "default";
    L11:
        return "hash=" + r3.hashCode();
    L4:
        if (StringsKt.isBlank(r3) == true) goto L7;
        r0 = false;
        goto L8
    }

    public final void ea0(OfficeSpaceTab r6) {
        OfficeSpaceTabLayout r0 = this.i;
        if (r0 == null) goto L22;
        int r1 = OfficeSpaceTabLayout.k;
        Intrinsics.checkNotNullParameter(r6, "tab");
        if (r0.b == r6) goto L7;
    L9:
        r0.b = r6;
        Iterator<Map.Entry<OfficeSpaceTab, TextView>> r2 = r0.a.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<OfficeSpaceTab, TextView> r3 = r2.next();
        OfficeSpaceTab r4 = r3.getKey();
        TextView r5 = r3.getValue();
        if (r4 != r6) goto L15;
        int r7 = r0.d;
    L16:
        r5.setTextColor(r7);
        goto L11
    L15:
        r7 = r0.e;
        goto L16
    L17:
        r0.d(r6, true, true);
        r0.c(r6, true);
        return;
    L7:
        if (r0.h.getLayoutParams().width <= 0) goto L9;
        r0.c(r6, true);
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        getParentFragmentManager().setFragmentResultListener("office_space_document_created", this, new d(this));
    }

    public static final OfficeSpaceActionResult S90(OfficeSpaceFragment r6, OfficeSpaceHeaderAction r7) {
        r6.getClass();
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r0 = com.bytedance.ee.bear.office.list.h.a;
        com.bytedance.ee.bear.office.list.h.a(r6.Z90());
        OfficeSpaceTab r1 = r6.W90();
        if (r1 != null) goto L5;
        r1 = OfficeSpaceTab.RECENT;
    L5:
        ViewPager2 r2 = r6.g;
        if (r2 != null) goto L8;
        List<OfficeSpaceTab> r3 = r6.fa0();
    L16:
        OfficeSpaceHeaderEventSource r4 = new OfficeSpaceHeaderEventSource(r1, r3);
        if (r7 != OfficeSpaceHeaderAction.CREATE_DOC) goto L19;
    L24:
        String r5 = com.bytedance.ee.bear.office.list.h.g(r6.Z90());
        OfficeSpaceTab r8 = OfficeSpaceTab.RECENT;
        com.bytedance.ee.bear.office.list.p r9 = com.bytedance.ee.bear.office.list.h.c(r5, r8);
        if ((r9 instanceof OfficeListHostFragment) == false) goto L48;
        tt5.a.h("OfficeListHostRegistry", "notify recent create action dispatched, runtime=" + com.bytedance.ee.bear.office.list.h.l(r5));
        OfficeListHostFragment r10 = (OfficeListHostFragment) r9;
        if (r10.W90() != r8) goto L48;
        r10.n = true;
        r10.o = false;
        tt5.a.h("OfficeListHostFragment", "mark RECENT create action dispatched");
    L48:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L37
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r12 = com.bytedance.ee.bear.office.export.space.m.a;     // Catch: Throwable -> L37
        com.bytedance.ee.bear.office.export.space.h r13 = com.bytedance.ee.bear.office.export.space.m.a(r6.Z90());     // Catch: Throwable -> L37
        if (r13 == null) goto L34;
        OfficeSpaceActionResult r14 = r13.Zj(r7, r4);     // Catch: Throwable -> L37
        if (r14 == null) goto L34;
    L35:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L37
    L39:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L44;
        tt5.a.l("OfficeSpaceFragment", "dispatch header action failed, runtime=" + r6.da0(r6.Z90()) + ", action=" + r7, r16);
        r15 = OfficeSpaceActionResult.NotHandled.INSTANCE;
    L44:
        if ((((OfficeSpaceActionResult) r15) instanceof OfficeSpaceActionResult.Handled) == false) goto L47;
        return OfficeSpaceActionResult.Handled.INSTANCE;
    L47:
        return OfficeSpaceActionResult.NotHandled.INSTANCE;
    L34:
        r14 = OfficeSpaceActionResult.NotHandled.INSTANCE;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L19:
        if (r7 == OfficeSpaceHeaderAction.CREATE_PPT) goto L24;
        if (r7 == OfficeSpaceHeaderAction.CREATE_BITABLE) goto L24;
        if (r7 != OfficeSpaceHeaderAction.CREATE_SHEET) goto L48;
    L8:
        OfficeSpacePagerAdapter r18 = r2.getAdapter();
        if ((r18 instanceof OfficeSpacePagerAdapter) == false) goto L11;
        OfficeSpacePagerAdapter r19 = r18;
    L12:
        if (r19 == null) goto L15;
        r3 = r19.a;
        if (r3 != null) goto L16;
    L15:
        r3 = CollectionsKt.listOf(OfficeSpaceTab.RECENT);
        goto L16
    L11:
        r19 = null;
        goto L12
    }

    public final boolean X90(View r3, OfficeSpaceTab r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r1 = com.bytedance.ee.bear.office.list.h.a;     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Boolean.valueOf(com.bytedance.ee.bear.office.list.h.k(Z90(), r4, r3, new c(this))));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r5);
        if (r2 == null) goto L11;
        tt5.a.e("OfficeSpaceFragment", "show header more menu failed, runtime=" + da0(Z90()) + ", tab=" + r4, r2, false);
        r5 = Boolean.FALSE;
    L11:
        return ((Boolean) r5).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void ba0(boolean r11, int r12) {
        View r0 = this.j;
        if (r0 == null) goto L8;
        if (r11 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        TextView r1 = this.k;
        if (r1 == null) goto L14;
        if (r11 == false) goto L12;
        String r13 = StringsKt.replace$default(getString(2131888045), "{{count}}", String.valueOf(r12), false, 4, null);
    L13:
        r1.setText(r13);
        goto L14
    L12:
        r13 = "";
    L14:
        Iterator<T> r14 = this.l.iterator();
    L16:
        if (r14.hasNext() == false) goto L22;
        View r2 = (View) r14.next();
        if (r11 == false) goto L20;
        int r4 = 8;
    L21:
        r2.setVisibility(r4);
        goto L16
    L20:
        r4 = 0;
        goto L21
    L22:
        if (r11 == true) goto L26;
        View r15 = getView();
        if (r15 == null) goto L26;
        V90(r15);
    L26:
        ViewPager2 r16 = this.g;
        if (r16 == null) goto L33;
        r16.setUserInputEnabled(!r11);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v30, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.bytedance.ee.bear.office.space.OfficeSpaceFragment$bindPager$callback$1] */
    public final void onViewCreated(View r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r19, "view");
        super.onViewCreated(r19, r20);
        String r1 = Y90().getMenuConfigJson();
        com.bytedance.ee.bear.widgets.menuconfig.c r2 = com.bytedance.ee.bear.widgets.menuconfig.c.a;
        monitor-enter(r2);
        com.bytedance.ee.bear.widgets.menuconfig.a.a.getClass();     // Catch: Throwable -> L105
        com.bytedance.ee.bear.widgets.menuconfig.c.b = com.bytedance.ee.bear.widgets.menuconfig.a.a(r1);     // Catch: Throwable -> L105
        monitor-exit(r2);
        V90(r19);
        U90(r19);
        View r3 = r19.findViewById(2131381378);
        if (r3 == null) goto L10;
        g r4 = new g(this, r19);
        this.r = r4;
        r3.addOnLayoutChangeListener(r4);
    L10:
        r19.findViewById(2131381379).setOnClickListener(new com.bytedance.ee.bear.office.space.c(this));
        r19.findViewById(2131381382).setOnClickListener(new com.bytedance.ee.bear.office.space.d(this));
        r19.findViewById(2131381380).setOnClickListener(new com.bytedance.ee.bear.office.space.e(this));
        this.j = r19.findViewById(2131381384);
        this.k = (TextView) r19.findViewById(2131381385);
        boolean r9 = false;
        this.l = CollectionsKt.listOf(new View[]{r19.findViewById(2131381379), r19.findViewById(2131381381), r19.findViewById(2131381386)});
        r19.findViewById(2131381383).setOnClickListener(new f(this));
        List<OfficeSpaceTab> r13 = fa0();
        OfficeSpaceTab r5 = Y90().getInitialTab();
        String r6 = null;
        if (r13.contains(r5) == true) goto L14;
        r5 = null;
    L14:
        if (r5 != null) goto L16;
        r5 = (OfficeSpaceTab) CollectionsKt.first(r13);
    L16:
        OfficeSpaceTab r14 = r5;
        tt5.a.h("OfficeSpaceFragment", "bind pager, runtime=" + da0(Z90()) + ", tabs=" + r13 + ", initialTab=" + Y90().getInitialTab() + ", actualInitialTab=" + r14);
        if (this.u == true) goto L44;
        int r7 = com.bytedance.ee.bear.office.list.q.a;
        OfficeSpaceConfig r8 = Y90();
        OfficeSpaceEnterContext r12 = (OfficeSpaceEnterContext) this.f.getValue();
        String r10 = Z90();
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r14, "actualInitialTab");
        Intrinsics.checkNotNullParameter(r12, "enterContext");
        if (com.bytedance.ee.bear.office.list.q.a(r8, r14, r12, r10) == true) goto L21;
        boolean r11 = false;
    L43:
        this.u = r11;
    L62:
        final OfficeSpacePagerAdapter r15 = new OfficeSpacePagerAdapter(this, r13, Y90(), Z90(), (OfficeSpaceEnterContext) this.f.getValue());
        OfficeSpaceTabLayout r16 = (OfficeSpaceTabLayout) r19.findViewById(2131381386);
        Function1<OfficeSpaceTab, Unit> r17 = new OfficeSpaceFragment$bindPager$1$1(this, r15);
        r16.getClass();
        Intrinsics.checkNotNullParameter(r13, "tabs");
        Intrinsics.checkNotNullParameter(r14, "selected");
        Intrinsics.checkNotNullParameter(r17, "listener");
        r16.g.removeAllViews();
        r16.a.clear();
        r16.c = r17;
        Iterator<T> r18 = r13.iterator();
    L64:
        if (r18.hasNext() == false) goto L84;
        OfficeSpaceTab r21 = (OfficeSpaceTab) r18.next();
        TextView r22 = new TextView(r16.getContext());
        int r23 = OfficeSpaceTabLayout.b.b[r21.ordinal()];
        if (r23 != 1) goto L68;
        String r24 = r16.getContext().getString(2131889445);
    L79:
        r22.setText(r24);
        r22.setTextSize(2, 17.0f);
        r22.setIncludeFontPadding(false);
        r22.setTypeface(Typeface.DEFAULT_BOLD);
        r22.setGravity(17);
        if (r21 != r14) goto L82;
        int r25 = r16.d;
    L83:
        r22.setTextColor(r25);
        r22.setOnClickListener(new o(r16, r21));
        LinearLayout r26 = r16.g;
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, r16.b(24.0f));
        int r111 = r16.b(10.0f);
        r110.leftMargin = r111;
        r110.rightMargin = r111;
        Unit r112 = Unit.INSTANCE;
        r26.addView(r22, r110);
        r16.a.put(r21, r22);
        goto L64
    L82:
        r25 = r16.e;
        goto L83
    L68:
        if (r23 != 2) goto L70;
        r24 = r16.getContext().getString(2131889433);
        goto L79
    L70:
        if (r23 != 3) goto L72;
        r24 = r16.getContext().getString(2131889452);
        goto L79
    L72:
        if (r23 != 4) goto L75;
        r24 = r16.getContext().getString(2131889426);
        goto L79
    L75:
        throw new NoWhenBranchMatchedException();
    L84:
        r16.b = r14;
        r16.post(new p(r16, r14));
        this.i = r16;
        ?? r27 = new OfficeSpaceFragment$bindPager$callback$1(r15, this);
        this.h = r27;
        ViewPager2 r28 = r19.findViewById(2131381388);
        r28.setAdapter(r15);
        r28.registerOnPageChangeCallback(r27);
        this.g = r28;
        int r29 = r15.a.indexOf(r14);
        ViewPager2 r30 = this.g;
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r31 = com.bytedance.ee.bear.office.list.h.a;
        String r32 = Z90();
        Function1<OfficeSpaceTab, Boolean> r33 = new OfficeSpaceFragment$bindPager$3(this, r15);
        Intrinsics.checkNotNullParameter(r33, "requester");
        String r34 = com.bytedance.ee.bear.office.list.h.g(r32);
        tt5.a.h("OfficeListHostRegistry", "register tab selection requester, runtime=" + com.bytedance.ee.bear.office.list.h.l(r34));
        com.bytedance.ee.bear.office.list.h.e.put(r34, r33);
        String r35 = Z90();
        Function1<OfficeSpaceTab, Boolean> r36 = new OfficeSpaceFragment$bindPager$4(this, r15);
        Intrinsics.checkNotNullParameter(r36, "requester");
        String r37 = com.bytedance.ee.bear.office.list.h.g(r35);
        tt5.a.h("OfficeListHostRegistry", "register tab preload requester, runtime=" + com.bytedance.ee.bear.office.list.h.l(r37));
        com.bytedance.ee.bear.office.list.h.f.put(r37, r36);
        if (r30 != null) goto L87;
    L89:
        boolean r113 = false;
    L91:
        if (r113 == false) goto L96;
        tt5.a.h("OfficeSpaceFragment", "dispatch initial tab without pager switch, runtime=" + da0(Z90()) + ", tab=" + r14);
        this.p = true;
        ea0(r14);
        com.bytedance.ee.bear.office.list.h.h(Z90(), r14);
        boolean r38 = d0.a;
        if (r14 != OfficeSpaceTab.MINE) goto L95;
        r9 = true;
    L95:
        d0.c = r9;
        d0.c();
    L103:
        ca0(r15, r14, "initial_after_first_frame");
        tt5.a.h("OfficeSpaceFragment", "office_upload_recovery_trace root_fragment_create_upload_host runtime=" + da0(Z90()));
        ViewGroup r39 = (ViewGroup) r19.findViewById(2131381387);
        Intrinsics.checkNotNull(r39);
        LifecycleOwner r114 = getViewLifecycleOwner();
        int r40 = OfficeUploadRecoveryTarget.c;
        List r115 = CollectionsKt.listOf(OfficeUploadRecoveryTarget.a.b());
        View r116 = r19.findViewById(2131381388);
        Resources r0 = requireContext().getResources();
        OfficeUploadUiHost r41 = new OfficeUploadUiHost(r39, r114, r115, r116, 0, (int) (WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * 12));
        r41.e();
        this.m = r41;
        String r42 = Z90();
        AnonymousClass3 r43 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r43, "listener");
        com.bytedance.ee.bear.office.list.h.h.put(com.bytedance.ee.bear.office.list.h.g(r42), r43);
        return;
    L96:
        tt5.a.h("OfficeSpaceFragment", "switch to initial tab, runtime=" + da0(Z90()) + ", tab=" + r14 + ", index=" + r29);
        this.p = false;
        if (r30 == null) goto L99;
        r30.setCurrentItem(r29, false);
    L99:
        ea0(r14);
        boolean r44 = d0.a;
        if (r14 != OfficeSpaceTab.MINE) goto L102;
        r9 = true;
    L102:
        d0.c = r9;
        d0.c();
        goto L103
    L87:
        if (r30.getCurrentItem() != r29) goto L89;
        r113 = true;
        goto L91
    L21:
        x r45 = x.c();
        long r46 = r12.getClickStartMs();
        r45.getClass();
        if (r46 <= 0) goto L38;
        if (r46 <= 0) goto L33;
        Long r47 = (Long) ((ConcurrentHashMap) r45.a).get("init");
        Long r117 = (Long) ((ConcurrentHashMap) r45.a).get("key_open_finish_recent");
        if (r47 == null) goto L33;
        if (r47.longValue() != r46) goto L33;
        if (r117 == null) goto L33;
        if (r117.longValue() != r46) goto L33;
        boolean r48 = true;
    L34:
        if (r48 == true) goto L38;
        r45.i("doc_sdk_init");
        r45.i("doc_tab_fragment_init");
        r45.i("init");
        r45.i("load_from_network");
        r45.i("load_db_data");
        r45.i("update_db_data");
        r45.i("pre_load_db_data");
        r45.i("pre_load_online_data");
        r45.i("pre_load_from_network");
        r45.i("fill_ui");
        r45.i("inflate_doc_tab_layout");
        r45.i("inflate_recent_layout");
        r45.i("inflate_list_layout");
        r45.i("bind_list_item");
        r45.j("key_open_finish_recent");
        r45.k(r46, new String[]{"init", "key_open_finish_recent"});
        r45.d = null;
        r45.f = false;
        r45.e = false;
    L33:
        r48 = false;
    L38:
        if (r10 == null) goto L40;
        r6 = StringsKt.takeLast(r10, 8);
    L40:
        if (r6 != null) goto L42;
        r6 = "";
    L42:
        tt5.a.h("OfficeSpacePerformanceReporter", "start office space open timing, runtime=".concat(r6));
        r11 = true;
        goto L43
    L44:
        int r49 = com.bytedance.ee.bear.office.list.q.a;
        OfficeSpaceConfig r50 = Y90();
        OfficeSpaceEnterContext r51 = (OfficeSpaceEnterContext) this.f.getValue();
        String r118 = Z90();
        Intrinsics.checkNotNullParameter(r50, "config");
        Intrinsics.checkNotNullParameter(r14, "actualInitialTab");
        Intrinsics.checkNotNullParameter(r51, "enterContext");
        if (com.bytedance.ee.bear.office.list.q.a(r50, r14, r51, r118) == false) goto L62;
        x r52 = x.c();
        long r53 = r51.getClickStartMs();
        if (r53 > 0) goto L50;
        r52.getClass();
        goto L62
    L50:
        if (Boolean.TRUE.equals(((ConcurrentHashMap) r52.b).get("key_open_finish_recent")) == true) goto L62;
        Long r54 = (Long) ((ConcurrentHashMap) r52.a).get("init");
        Long r55 = (Long) ((ConcurrentHashMap) r52.a).get("key_open_finish_recent");
        if (r54 != null) goto L55;
    L60:
        r52.i("init");
        r52.j("key_open_finish_recent");
        r52.k(r53, new String[]{"init", "key_open_finish_recent"});
        goto L62
    L55:
        if (r54.longValue() != r53) goto L60;
        if (r55 == null) goto L60;
        if (r55.longValue() != r53) goto L60;
    L105:
        th = move-exception;
        throw th;
    }

    public final void ca0(OfficeSpacePagerAdapter r18, OfficeSpaceTab r19, String r20) {
        View r7 = getView();
        if (r7 != null) goto L6;
        tt5.a.k("OfficeSpaceFragment", "[OfficeCreatePerf] stage=adjacent_preload_skip runtime=" + da0(Z90()) + " reason=" + r20 + " currentTab=" + r19 + " cause=root_missing");
        return;
    L6:
        int r9 = com.bytedance.ee.bear.office.space.b.a;
        List<OfficeSpaceTab> r10 = r18.a;
        Intrinsics.checkNotNullParameter(r10, "tabs");
        Intrinsics.checkNotNullParameter(r19, "currentTab");
        int r11 = r10.indexOf(r19);
        if (r11 >= 0) goto L9;
        List r12 = CollectionsKt.emptyList();
    L26:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L28:
        if (r14.hasNext() == false) goto L32;
        Object r15 = r14.next();
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r16 = com.bytedance.ee.bear.office.list.h.a;
        if (com.bytedance.ee.bear.office.list.h.e(Z90(), (OfficeSpaceTab) r15) == true) goto L28;
        r13.add(r15);
        goto L28
    L32:
        ArrayList r17 = new ArrayList();
        Iterator r110 = r13.iterator();
    L34:
        if (r110.hasNext() == false) goto L39;
        Object r111 = r110.next();
        if (this.t.add((OfficeSpaceTab) r111) == false) goto L34;
        r17.add(r111);
        goto L34
    L39:
        if (r17.isEmpty() == false) goto L42;
        tt5.a.h("OfficeSpaceFragment", "[OfficeCreatePerf] stage=adjacent_preload_skip runtime=" + da0(Z90()) + " reason=" + r20 + " currentTab=" + r19 + " adjacentTabs=" + r12 + " cause=ready_or_scheduled");
        return;
    L42:
        tt5.a.h("OfficeSpaceFragment", "[OfficeCreatePerf] stage=adjacent_preload_schedule runtime=" + da0(Z90()) + " reason=" + r20 + " currentTab=" + r19 + " targets=" + r17 + " visibleTabs=" + r18.a);
        r7.post(new e(this, r17, r20, r19, r18));
        return;
    L9:
        List r112 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(r11 - 1), Integer.valueOf(r11 + 1)});
        ArrayList r113 = new ArrayList();
        Iterator r114 = r112.iterator();
    L11:
        if (r114.hasNext() == false) goto L21;
        Object r115 = r114.next();
        int r116 = ((Number) r115).intValue();
        if (r116 >= 0) goto L15;
    L17:
        boolean r117 = false;
    L18:
        if (r117 == false) goto L11;
        r113.add(r115);
        goto L11
    L15:
        if (r116 >= r10.size()) goto L17;
        r117 = true;
        goto L18
    L21:
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r119 = r113.iterator();
    L23:
        if (r119.hasNext() == false) goto L25;
        r118.add((OfficeSpaceTab) ListProtector.get(r10, ((Number) r119.next()).intValue()));
        goto L23
    L25:
        r12 = r118;
        goto L26
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564118, r3, false);
    }

    public static final boolean T90(OfficeSpaceFragment r12, OfficeSpacePagerAdapter r13, OfficeSpaceTab r14, String r15) {
        ViewPager2 r8 = r12.g;
        if (r8 != null) goto L5;
        tt5.a.k("OfficeSpaceFragment", "[OfficeCreatePerf] stage=tab_preload_skip runtime=" + r12.da0(r12.Z90()) + " tab=" + r14 + " reason=" + r15 + " cause=pager_missing");
        return false;
    L5:
        Integer r16 = Integer.valueOf(r13.a.indexOf(r14));
        if (r16.intValue() < 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        r16 = null;
    L12:
        if (r16 == null) goto L18;
        int r6 = r16.intValue();
        int r17 = r8.getCurrentItem();
        ConcurrentHashMap<com.bytedance.ee.bear.office.list.h.a, WeakReference<com.bytedance.ee.bear.office.list.p>> r0 = com.bytedance.ee.bear.office.list.h.a;
        if (com.bytedance.ee.bear.office.list.h.e(r12.Z90(), r14) == false) goto L16;
        tt5.a.h("OfficeSpaceFragment", "[OfficeCreatePerf] stage=tab_preload_already_ready runtime=" + r12.da0(r12.Z90()) + " tab=" + r14 + " reason=" + r15 + " currentIndex=" + r17 + " targetIndex=" + r6);
    L17:
        return true;
    L16:
        long r10 = System.currentTimeMillis();
        tt5.a.h("OfficeSpaceFragment", "[OfficeCreatePerf] stage=tab_preload_start runtime=" + r12.da0(r12.Z90()) + " tab=" + r14 + " reason=" + r15 + " currentIndex=" + r17 + " targetIndex=" + r6);
        r8.setOffscreenPageLimit(Math.max(1, Math.abs(r17 - r6)));
        r8.post(new h(r12, r14, r15, r8, r6, r10));
        goto L17
    L18:
        tt5.a.k("OfficeSpaceFragment", "[OfficeCreatePerf] stage=tab_preload_skip runtime=" + r12.da0(r12.Z90()) + " tab=" + r14 + " reason=" + r15 + " cause=tab_missing");
        return false;
    L8:
        r5 = false;
        goto L9
    }
}
