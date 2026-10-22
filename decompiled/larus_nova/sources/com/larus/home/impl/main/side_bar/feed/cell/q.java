package com.larus.home.impl.main.side_bar.feed.cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.home.impl.main.side_bar.data.j0;
import com.larus.home.impl.main.side_bar.view.adapter.ShowAllHolder;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import eb9.u;
import eb9.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Integer, j0, Unit> f344702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, j0, Unit> f344703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ShowAllHolder f344704c;

    @Override // eb9.x
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_side_bar_show_all, r100, false);
        Intrinsics.checkNotNull(r101);
        this.f344704c = new ShowAllHolder(r101);
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

    /* JADX WARN: Multi-variable type inference failed */
    public q(Function2<? super Integer, ? super j0, Unit> r100, Function2<? super Integer, ? super j0, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r101, "onItemShown");
        this.f344702a = r100;
        this.f344703b = r101;
    }

    @Override // eb9.x
    public final void c(View r100, u r101) {
        x.a.c(r100, r101);
    }

    @Override // eb9.x
    public final void d(View r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.setOnClickListener(null);
    }

    @Override // eb9.x
    public final void g(View r100, u r101) {
        x.a.b(r100, r101);
    }

    @Override // eb9.x
    public final void a(View r100, eb9.o<?> r101, int r102, u r103) {
        x.a.a(this, r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eb9.x
    public final void e(View r100, eb9.o<?> r101, final int r102, u r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        DATA r104 = r101.f471909c;
        if ((r104 instanceof j0) == false) goto L5;
        final j0 r105 = (j0) r104;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        ShowAllHolder r106 = this.f344704c;
        if (r106 == null) goto L12;
        r106.T3(r105.f344511f, new p(this, r102, r105));
        return;
    L12:
        return;
    L5:
        r105 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eb9.x
    public final void h(eb9.o<?> r100, View r101, int r102, u r103) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        DATA r104 = r100.f471909c;
        if ((r104 instanceof j0) == false) goto L5;
        j0 r105 = (j0) r104;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        this.f344703b.invoke(Integer.valueOf(r102), r105);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
