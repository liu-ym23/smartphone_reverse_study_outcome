package com.larus.home.impl.main.side_bar.feed.arch;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e0 implements eb9.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f344613a = null;

    static {
        f344613a = new e0();
    }

    public e0() {
    }

    @Override // eb9.x
    public final void e(View r100, eb9.o<?> r101, int r102, eb9.u r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // eb9.x
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = new View(r100.getContext());
        r101.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        return r101;
    }

    @Override // eb9.x
    public final View f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return r100;
    }

    @Override // eb9.x
    public final View i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return r100;
    }

    @Override // eb9.x
    public final void c(View r100, eb9.u r101) {
        eb9.x.a.c(r100, r101);
    }

    @Override // eb9.x
    public final void d(View r100, eb9.u r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // eb9.x
    public final void g(View r100, eb9.u r101) {
        eb9.x.a.b(r100, r101);
    }

    @Override // eb9.x
    public final void a(View r100, eb9.o<?> r101, int r102, eb9.u r103) {
        eb9.x.a.a(this, r100, r101, r102, r103);
    }

    @Override // eb9.x
    public final void h(eb9.o<?> r100, View r101, int r102, eb9.u r103) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
