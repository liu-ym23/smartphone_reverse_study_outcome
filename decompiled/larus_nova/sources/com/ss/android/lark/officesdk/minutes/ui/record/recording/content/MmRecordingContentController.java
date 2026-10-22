package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingContentController {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f436298p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mwb.e f436299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f436300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Fragment f436301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MmRecordingViewModel f436302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MmRecordingPagerAdapter f436303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f436304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f436305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f436306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f436307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f436308j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f436309k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<? extends h> f436310l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f436311m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f436312n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Runnable f436313o;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f436314a = null;

        static {
            int[] r100 = new int[MmRecordingUITab.values().length];
            r100[MmRecordingUITab.SUBTITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MmRecordingUITab.SUMMARY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f436314a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingContentController f436315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f436316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f436317c;

        public c(MmRecordingContentController r100, int r101, String r102) {
            this.f436315a = r100;
            this.f436316b = r101;
            this.f436317c = r102;
        }

        public final void a() {
            if (this.f436315a.f436299a.b().getCurrentItem() != this.f436316b) goto L6;
            int r100 = bwb.b.f21271a;
            bwb.b.f(MmUiLogScene.CONTENT, "switchToTab", "post sync tab selected, reason=" + this.f436317c + ", position=" + this.f436316b, this.f436315a.c());
            this.f436315a.e(this.f436316b, this.f436317c + "_post", Intrinsics.areEqual(this.f436317c, "goToSubtitle"));
            return;
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

    public final String c() {
        return (String) this.f436300b.getValue();
    }

    public MmRecordingContentController(mwb.e r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingView");
        this.f436299a = r100;
        this.f436300b = LazyKt.lazy(new MmRecordingContentController$logDetail$2(this));
        this.f436306h = -1;
        this.f436307i = -1;
        this.f436310l = CollectionsKt.emptyList();
    }

    public static final void a(MmRecordingContentController r100) {
        ViewPager2 r101 = r100.f436299a.b();
        if (r101.getWidth() <= 0) goto L6;
        r100.f436307i = r101.getWidth();
        return;
    }

    public final void d(final MmRecordingFragment r100, final String r101) {
        if (this.f436312n == false) goto L5;
        return;
    L5:
        Runnable r102 = this.f436313o;
        if (r102 == null) goto L8;
        this.f436299a.b().removeCallbacks(r102);
    L8:
        Runnable r103 = new MmRecordingContentController$scheduleDelayedViewPagerSetup$delayedSetup$1(this, r100, r101);
        this.f436313o = r103;
        this.f436299a.b().postDelayed(r103, 100);
    }

    public final void f(MmRecordingUITab r100, String r101) {
        Iterator<? extends h> r102 = this.f436310l.iterator();
        int r103 = 0;
    L3:
        boolean r104 = true;
        if (r102.hasNext() == false) goto L12;
        if (r102.next().getTabType() != r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r103 < 0) goto L29;
        int r106 = this.f436299a.b().getCurrentItem();
        com.larksuite.component.universe_design.tab.b r107 = this.f436299a.a().getTabAt(r103);
        if (r107 == null) goto L21;
        View r108 = r107.f285296e;
        if (r108 == null) goto L21;
        if (r108.isSelected() != true) goto L21;
    L22:
        int r109 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.CONTENT, "switchToTab", "reason=" + r101 + ", tab=" + r100 + ", position=" + r103 + ", currentItem=" + r106 + ", isTabSelected=" + r104, c());
        if (r103 == r106) goto L25;
        this.f436299a.b().setCurrentItem(r103, false);
    L25:
        e(r103, r101, Intrinsics.areEqual(r101, "goToSubtitle"));
        this.f436299a.a().post(new c(this, r103, r101));
        return;
    L21:
        r104 = false;
        goto L22
    L29:
        return;
    L8:
        r105 = false;
        goto L9
    L12:
        r103 = -1;
        goto L13
    }

    public final void e(int r100, String r101, boolean r102) {
        int r103 = this.f436299a.a().getSelectPosition();
        int r104 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.CONTENT, "selectTabAt", "reason=" + r101 + ", position=" + r100 + ", currentSelectedPosition=" + r103 + ", forceIndicator=" + r102, c());
        if (r102 == false) goto L6;
        if (r103 != r100) goto L6;
        this.f436299a.a().selectTabAt(-1);
    L6:
        this.f436299a.a().selectTabAt(r100);
    }

    public final void b(MmRecordingViewModel r100, MmRecordingFragment r101, MmRecordingFragment r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        this.f436302d = r100;
        this.f436301c = r101;
        this.f436311m = r103;
        List<? extends h> r104 = CollectionsKt.mutableListOf(new h[]{new i()});
        if (this.f436311m == true) goto L5;
        r104.add(new j());
    L5:
        this.f436310l = r104;
        if (this.f436311m == false) goto L12;
        this.f436299a.c().f516044b.setVisibility(8);
        mwb.d r105 = this.f436299a.f516059i;
        if (r105 == null) goto L17;
        View r106 = r105.f516047e;
        if (r106 == null) goto L17;
        r106.setVisibility(8);
    L17:
        this.f436303e = new MmRecordingPagerAdapter(r101, this.f436310l);
        this.f436299a.b().setAdapter(this.f436303e);
        d(r101, "bind");
        new UDTabLayoutCoordinator2(this.f436299a.a(), this.f436299a.b(), new f(this)).a();
        this.f436304f = new g(this.f436299a.a(), this.f436299a.c().f516046d);
        f(r100.getState().f436254q, SVGRenderEngine.RESTORE);
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r102), MmRecordingContentController$subscribeTabState$1.INSTANCE, new MmRecordingContentController$subscribeTabState$2(this, null));
        r100.selectSubscribe(LifecycleOwnerKt.getLifecycleScope(r102), MmRecordingContentController$subscribeHintState$1.INSTANCE, new MmRecordingContentController$subscribeHintState$2(this, null));
        this.f436299a.b().post(new com.ss.android.lark.officesdk.minutes.ui.record.recording.content.a(this));
        return;
    L12:
        this.f436299a.c().f516044b.setVisibility(0);
        mwb.d r107 = this.f436299a.f516059i;
        if (r107 == null) goto L17;
        View r108 = r107.f516047e;
        if (r108 == null) goto L17;
        r108.setVisibility(0);
        goto L17
    }
}
