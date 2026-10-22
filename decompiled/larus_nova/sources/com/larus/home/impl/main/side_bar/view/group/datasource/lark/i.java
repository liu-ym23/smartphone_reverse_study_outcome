package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import com.larus.home.impl.main.side_bar.data.j0;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class i implements zb9.s<j0> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f345419l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f345420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f345421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HumanFeedScope f345422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zb9.t<j0> f345423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f345424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<d> f345425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f345426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f345427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f345428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GroupSortPolicy f345429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j f345430k;

    public static final class a {
    }

    static {
    }

    public final void c() {
        Object r100 = this.f345424e;
        monitor-enter(r100);
        boolean r101 = false;
        if (this.f345428i == true) goto L9;
        this.f345428i = true;     // Catch: Throwable -> L14
        this.f345425f = CollectionsKt.emptyList();     // Catch: Throwable -> L14
        this.f345427h = false;     // Catch: Throwable -> L14
        r101 = true;
    L9:
        monitor-exit(r100);
        if (r101 == true) goto L12;
        return;
    L12:
        this.f345420a.g(this.f345430k);
        int r102 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("human_release", i());
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final String i() {
        return "human=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this);
    }

    @Override // zb9.s
    public final GroupSortPolicy e() {
        return this.f345429j;
    }

    @Override // zb9.s
    public final void a(zb9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Object r101 = this.f345424e;
        monitor-enter(r101);
        Pair r102 = TuplesKt.to(Integer.valueOf(RangesKt.coerceAtLeast(r100.f571193a, 1)), Boolean.valueOf(this.f345427h));     // Catch: Throwable -> L10
        monitor-exit(r101);
        int r103 = ((Number) r102.component1()).intValue();
        if (((Boolean) r102.component2()).booleanValue() == false) goto L15;
        BuildersKt.launch$default(this.f345421b, null, null, new LarkConversationSource$launchLoad$1(this, false, r103, null), 3, null);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // zb9.s
    public final void d(zb9.u<j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345423d.a(r100);
    }

    @Override // zb9.s
    public final void f(zb9.u<j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345423d.d(r100);
    }

    @Override // zb9.s
    public final void g(zb9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Object r101 = this.f345424e;
        monitor-enter(r101);
        int r102 = RangesKt.coerceAtLeast(r100.f571193a, 1);     // Catch: Throwable -> L10
        if (this.f345422c != HumanFeedScope.Pinned) goto L7;
        r102 = 1;
    L7:
        monitor-exit(r101);
        BuildersKt.launch$default(this.f345421b, null, null, new LarkConversationSource$launchLoad$1(this, true, r102, null), 3, null);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // zb9.s
    public final void h(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f345429j = r100;
    }

    public static final List b(i r210, List r211) {
        HumanFeedScope r100 = r210.f345422c;
        List r101 = r211;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        e r103 = (e) r102.next();
        Intrinsics.checkNotNullParameter(r103, "meta");
        r110.add(new d(r103.f345411a, r103.f345412b / 1000, r103.f345413c / 1000, r103.f345414d, r103.f345416f));
        goto L4
    L7:
        if (r110.isEmpty() == true) goto L32;
        int r104 = 0;
        if (r110.isEmpty() == false) goto L12;
        int r105 = 0;
    L20:
        int r106 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        StringBuilder r107 = new StringBuilder("scope=");
        r107.append(r100);
        r107.append(" in=");
        r107.append(r110.size());
        r107.append(" onTop=");
        r107.append(r105);
        r107.append(" kept=");
        if (r110.isEmpty() == true) goto L31;
        Iterator r108 = r110.iterator();
    L25:
        if (r108.hasNext() == false) goto L31;
        if (r100.matches((d) r108.next()) == false) goto L25;
        r104 = r104 + 1;
        if (r104 >= 0) goto L25;
        CollectionsKt.throwCountOverflow();
    L31:
        r107.append(r104);
        r107.append(' ');
        r107.append(CollectionsKt.joinToString$default(r110, null, "[", "]", 0, null, new k(), 25, null));
        com.larus.home.impl.main.side_bar.feed.arch.t.c("human_scope_filter", r107.toString());
        goto L32
    L12:
        Iterator r109 = r110.iterator();
        r105 = 0;
    L14:
        if (r109.hasNext() == false) goto L20;
        if (((d) r109.next()).b() == false) goto L14;
        r105 = r105 + 1;
        if (r105 >= 0) goto L14;
        CollectionsKt.throwCountOverflow();
    L32:
        ArrayList r111 = new ArrayList();
        Iterator r112 = r110.iterator();
    L34:
        if (r112.hasNext() == false) goto L39;
        Object r113 = r112.next();
        if (r100.matches((d) r113) == false) goto L34;
        r111.add(r113);
        goto L34
    L39:
        return l.c(r111);
    }

    public i(g r100, CoroutineScope r101, HumanFeedScope r102, int r103) {
        this.f345420a = r100;
        this.f345421b = r101;
        this.f345422c = r102;
        this.f345423d = new zb9.t();
        this.f345424e = new Object();
        this.f345425f = CollectionsKt.emptyList();
        if (r102 == HumanFeedScope.Pinned) goto L5;
        boolean r104 = true;
    L6:
        this.f345426g = r104;
        this.f345427h = r104;
        RangesKt.coerceAtLeast(r103, 1);
        this.f345429j = GroupSortPolicy.UpdateTime;
        j r105 = new j(this);
        this.f345430k = r105;
        r100.j(r105);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
