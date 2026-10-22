package com.larksuite.component.universe_design.tab;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class UDTabLayoutCoordinator2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDTabLayout f285280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager2 f285281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f285282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f285283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UDTabLayoutCoordinator2$onPageChangeCallback$1 f285284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f285285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UDTabLayoutCoordinator2$pagerAdapterObserver$1 f285286g;

    public interface a {
        void a(int r100, com.larksuite.component.universe_design.tab.b r101);
    }

    public static final class b implements UDTabLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDTabLayoutCoordinator2 f285287a;

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void a(com.larksuite.component.universe_design.tab.b r100) {
            Intrinsics.checkNotNullParameter(r100, "tab");
        }

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void c(com.larksuite.component.universe_design.tab.b r100) {
            Intrinsics.checkNotNullParameter(r100, "tab");
        }

        public b(UDTabLayoutCoordinator2 r100) {
            this.f285287a = r100;
        }

        @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
        public final void b(com.larksuite.component.universe_design.tab.b r100) {
            Intrinsics.checkNotNullParameter(r100, "tab");
            int r101 = this.f285287a.f285281b.getCurrentItem();
            int r102 = r100.f285297f;
            if (r101 == r102) goto L6;
            this.f285287a.f285281b.setCurrentItem(r102);
            return;
        }
    }

    public final void a() {
        if ((!this.f285283d) == false) goto L14;
        if (this.f285281b.getAdapter() == null) goto L12;
        this.f285283d = true;
        this.f285280a.addOnTabSelectedListener(this.f285285f);
        this.f285281b.registerOnPageChangeCallback(this.f285284e);
        RecyclerView.Adapter r100 = this.f285281b.getAdapter();
        if (r100 == null) goto L9;
        r100.registerAdapterDataObserver(this.f285286g);
    L9:
        b();
        return;
    L12:
        throw new IllegalStateException("UDTabLayoutCoordinator2 attached before viewPager2 has an adapter".toString());
    L14:
        throw new IllegalStateException("UDTabLayoutCoordinator2 is already attached".toString());
    }

    public final void b() {
        this.f285280a.removeAllTabs();
        RecyclerView.Adapter r100 = this.f285281b.getAdapter();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.getItemCount();
        int r102 = this.f285281b.getCurrentItem();
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L8;
        com.larksuite.component.universe_design.tab.b r104 = this.f285280a.newTab();
        this.f285282c.a(r103, r104);
        this.f285280a.addTab(r104);
        r103 = r103 + 1;
        goto L6
    L8:
        if (r101 <= 0) goto L14;
        if (r102 >= r101) goto L15;
        if (r102 < 0) goto L16;
        this.f285280a.selectTabAt$universe_ui_tab_release(r102, true);
        return;
    L16:
        return;
    L15:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2$onPageChangeCallback$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator2$pagerAdapterObserver$1] */
    public UDTabLayoutCoordinator2(UDTabLayout r100, ViewPager2 r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "tabLayout");
        Intrinsics.checkNotNullParameter(r101, "viewPager");
        Intrinsics.checkNotNullParameter(r102, "tabConfig");
        this.f285280a = r100;
        this.f285281b = r101;
        this.f285282c = r102;
        this.f285284e = new UDTabLayoutCoordinator2$onPageChangeCallback$1(this);
        this.f285285f = new b(this);
        this.f285286g = new UDTabLayoutCoordinator2$pagerAdapterObserver$1(this);
    }
}
