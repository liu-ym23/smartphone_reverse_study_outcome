package com.larus.home.impl.main.side_bar.view.group.module;

import com.larus.home.impl.main.side_bar.feed.arch.FlowFeedAdapter;
import com.larus.home.impl.main.side_bar.view.group.render.GroupHeaderAdapter;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f345551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GroupHeaderAdapter f345552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.render.o<?> f345553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f345554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f345555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Boolean, Unit> f345556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f345557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f345558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f345559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<com.larus.home.impl.main.side_bar.feed.arch.d> f345560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super y, Unit> f345561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f345562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f345563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f345564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final GroupModule$contentDataObserver$1 f345565o;

    public final boolean a() {
        if (this.f345553c.t().getItemCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.f345563m == false) goto L7;
        return false;
    L7:
        if (this.f345554d == true) goto L9;
        return true;
    L9:
        com.larus.home.impl.main.side_bar.view.group.render.o<?> r100 = this.f345553c;
        if ((r100 instanceof com.larus.home.impl.main.side_bar.view.group.render.k0) == false) goto L12;
        com.larus.home.impl.main.side_bar.view.group.render.k0 r101 = (com.larus.home.impl.main.side_bar.view.group.render.k0) r100;
    L13:
        if (r101 != null) goto L17;
        return a();
    L17:
        return !r101.f345671m.isEmpty();
    L12:
        r101 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.larus.home.impl.main.side_bar.view.group.module.u] */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.recyclerview.widget.RecyclerView$AdapterDataObserver, com.larus.home.impl.main.side_bar.view.group.module.GroupModule$contentDataObserver$1] */
    public y(String r100, GroupHeaderAdapter r101, com.larus.home.impl.main.side_bar.view.group.render.o r102, boolean r110, boolean r111, f0 r112) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "headerAdapter");
        Intrinsics.checkNotNullParameter(r102, "contentAdapter");
        Intrinsics.checkNotNullParameter(r112, "onExpandedChanged");
        this.f345551a = r100;
        this.f345552b = r101;
        this.f345553c = r102;
        this.f345554d = r110;
        this.f345555e = r111;
        this.f345556f = r112;
        this.f345557g = true;
        String r113 = r100 + "/header";
        this.f345558h = r113;
        String r103 = r100 + "/content";
        this.f345559i = r103;
        com.larus.home.impl.main.side_bar.feed.arch.d[] r114 = new com.larus.home.impl.main.side_bar.feed.arch.d[2];
        r114[0] = new com.larus.home.impl.main.side_bar.feed.arch.d(r113, r101, r101.f345581c);
        FlowFeedAdapter r104 = r102.t();
        boolean r105 = r102 instanceof com.larus.home.impl.main.side_bar.view.group.render.k0;
        com.larus.home.impl.main.side_bar.view.group.render.k0 r106 = null;
        if (r105 == false) goto L5;
        com.larus.home.impl.main.side_bar.view.group.render.k0 r107 = (com.larus.home.impl.main.side_bar.view.group.render.k0) r102;
    L6:
        if (r107 == null) goto L11;
        List r108 = CollectionsKt.plus(CollectionsKt.listOf(r107), r107.z());
        if (r108 == null) goto L11;
    L15:
        r114[1] = new com.larus.home.impl.main.side_bar.feed.arch.d(r103, r104, r108);
        this.f345560j = CollectionsKt.listOf(r114);
        ?? r109 = new GroupModule$contentDataObserver$1(this);
        this.f345565o = r109;
        if ((r102 instanceof fb9.h) == false) goto L18;
        final fb9.h r115 = (fb9.h) r102;
    L19:
        Function0<Integer> r116 = new t(r115);
        Intrinsics.checkNotNullParameter(r116, ShortVideoSegments.KEY_PROP_PROVIDER);
        r101.f345583e = r116;
        r101.notifyItemChanged(0);
        if (r115 == 0) goto L22;
        r115.q(new u(this));
    L22:
        Function0<Boolean> r117 = new v(this);
        Intrinsics.checkNotNullParameter(r117, ShortVideoSegments.KEY_PROP_PROVIDER);
        r101.f345584f = r117;
        GroupModule$5 r118 = new GroupModule$5(this);
        Intrinsics.checkNotNullParameter(r118, "listener");
        r101.f345582d = r118;
        if (r105 == false) goto L25;
        r106 = (com.larus.home.impl.main.side_bar.view.group.render.k0) r102;
    L25:
        if (r106 == null) goto L27;
        Function1<? super Boolean, Unit> r119 = new w(this);
        Intrinsics.checkNotNullParameter(r119, "listener");
        r106.f345673o = r119;
        r106.f345693i = new x(this);
        return;
    L27:
        r102.t().registerAdapterDataObserver(r109);
        this.f345564n = true;
        return;
    L18:
        r115 = 0;
    L11:
        if ((r102 instanceof fb9.a) == false) goto L13;
        fb9.a r120 = (fb9.a) r102;
    L14:
        r108 = CollectionsKt.listOfNotNull(r120);
        goto L15
    L13:
        r120 = null;
        goto L14
    L5:
        r107 = null;
        goto L6
    }
}
