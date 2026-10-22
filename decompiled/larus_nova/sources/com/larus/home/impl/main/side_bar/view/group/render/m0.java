package com.larus.home.impl.main.side_bar.view.group.render;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class m0 implements eb9.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.datasource.lark.h f345684a;

    @Override // eb9.x
    public final void a(View r100, eb9.o<?> r101, int r102, eb9.u r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public m0(com.larus.home.impl.main.side_bar.view.group.datasource.lark.h r100) {
        Intrinsics.checkNotNullParameter(r100, "renderer");
        this.f345684a = r100;
    }

    @Override // eb9.x
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f345684a.a(r100);
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
        this.f345684a.i(r100);
    }

    @Override // eb9.x
    public final void g(View r100, eb9.u r101) {
        eb9.x.a.b(r100, r101);
    }

    @Override // eb9.x
    public final void e(View r100, eb9.o<?> r101, int r102, eb9.u r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r104 = a0.a(r101);
        if (r104 != null) goto L6;
        return;
    L6:
        if (this.f345684a.d(r100, r104) == false) goto L8;
        return;
    L8:
        int r105 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.a("human_bind_miss", "cell=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this) + " view=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(r100) + " id=" + com.larus.home.impl.main.side_bar.feed.arch.t.d(r104) + " position=" + r102);
    }

    @Override // eb9.x
    public final void h(eb9.o<?> r100, View r101, int r102, eb9.u r103) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r104 = a0.a(r100);
        if (r104 != null) goto L5;
        return;
    L5:
        this.f345684a.b(r101, r104);
    }
}
