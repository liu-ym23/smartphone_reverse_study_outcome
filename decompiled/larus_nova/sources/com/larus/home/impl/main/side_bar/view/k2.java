package com.larus.home.impl.main.side_bar.view;

import android.view.View;
import androidx.core.view.OneShotPreDrawListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<RecyclerView> f345752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<RecyclerView.Adapter<?>> f345753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Boolean> f345754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<RecyclerView.Adapter<?>, eb9.n, Integer> f345755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public eb9.n f345756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f345757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f345758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f345759h;

    public static final class a {
    }

    static {
    }

    public final void b() {
        if (this.f345756e != null) goto L6;
        return;
    L6:
        if (this.f345754c.invoke().booleanValue() == true) goto L8;
    L10:
        this.f345759h = false;
        this.f345757f = true;
        c();
        return;
    L8:
        if (this.f345759h == false) goto L10;
    }

    public final void c() {
        if (this.f345757f == true) goto L5;
        return;
    L5:
        if (this.f345758g == true) goto L38;
        RecyclerView r100 = this.f345752a.invoke();
        if (r100 != null) goto L10;
        return;
    L10:
        RecyclerView.Adapter<?> r101 = this.f345753b.invoke();
        if (r101 != null) goto L13;
        return;
    L13:
        eb9.n r102 = this.f345756e;
        if (r102 != null) goto L17;
        return;
    L17:
        if (r100.getAdapter() == r101) goto L19;
        return;
    L19:
        int r103 = com.larus.home.impl.main.side_bar.feed.arch.g.a(r101, 0, new j2(this, r102));
        if (r103 != (-1)) goto L23;
        FLogger.f375446a.i("SideBarSelectionScroller", "selected Feed item is not rendered yet selectionKey=" + r102);
        return;
    L23:
        RecyclerView.LayoutManager r104 = r100.getLayoutManager();
        if ((r104 instanceof LinearLayoutManager) == true) goto L28;
        r100.scrollToPosition(r103);
        this.f345757f = false;
        return;
    L28:
        if (r100.isComputingLayout() == true) goto L33;
        if (r100.getHeight() <= 0) goto L33;
        a(r100, (LinearLayoutManager) r104, r103);
        this.f345757f = false;
    L33:
        if (this.f345758g == true) goto L39;
        this.f345758g = true;
        OneShotPreDrawListener.add(r100, new l2(r100, this, r100));
        return;
    L39:
        return;
    }

    public final void a(RecyclerView r100, LinearLayoutManager r101, int r102) {
        r100.stopScroll();
        View r103 = r101.findViewByPosition(r102);
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(r101.getDecoratedMeasuredHeight(r103));
    L7:
        if (r103 == null) goto L10;
        if (r104 == null) goto L10;
        int r105 = (r101.getDecoratedTop(r103) + (r104.intValue() / 2)) - (r100.getHeight() / 2);
        r100.scrollBy(0, r105);
        String r106 = "distance=" + r105;
    L11:
        FLogger.f375446a.i("SideBarSelectionScroller", "center selected Feed item position=" + r102 + ' ' + r106 + " selectionKey=" + this.f345756e);
        return;
    L10:
        int r107 = RangesKt.coerceAtLeast(r100.getHeight() / 2, 0);
        r101.scrollToPositionWithOffset(r102, r107);
        r106 = "offset=" + r107;
        goto L11
    L5:
        r104 = null;
        goto L7
    }

    public k2(h1 r100, i1 r101, k1 r102, Function2 r103) {
        Intrinsics.checkNotNullParameter(r100, "recyclerViewProvider");
        Intrinsics.checkNotNullParameter(r101, "rootAdapterProvider");
        Intrinsics.checkNotNullParameter(r102, "isSideBarOpen");
        Intrinsics.checkNotNullParameter(r103, "localPositionResolver");
        this.f345752a = r100;
        this.f345753b = r101;
        this.f345754c = r102;
        this.f345755d = r103;
    }
}
