package com.larus.home.impl.main.side_bar.view.group.render;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.home.impl.main.side_bar.feed.arch.FlowFeedAdapter;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public abstract class o<ITEM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zb9.s<ITEM> f345685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q<ITEM> f345686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<zb9.i<ITEM>> f345687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<zb9.i<ITEM>> f345688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f345689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f345690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f345691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f345692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f345693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f345694j;

    public static final class a implements zb9.u<ITEM> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o<ITEM> f345695a;

        public a(o<ITEM> r100) {
            this.f345695a = r100;
        }

        @Override // zb9.u
        public final void a(zb9.k<zb9.i<ITEM>> r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            int r101 = this.f345695a.f345687c.size();
            int r102 = this.f345695a.f345688d.size();
            o<ITEM> r103 = this.f345695a;
            boolean r104 = !r103.f345692h;
            r103.f345687c = r103.f345686b.f345704c.e(CollectionsKt.emptyList(), r100.f571195a);
            r103.f345689e = r100.f571196b;
            r103.s();
            o<ITEM> r105 = this.f345695a;
            boolean r106 = false;
            if (r101 == r105.f345687c.size()) goto L5;
        L10:
            boolean r107 = true;
        L11:
            if (r104 == true) goto L14;
            if (r107 == true) goto L14;
        L18:
            o<ITEM> r108 = this.f345695a;
            if (r108.f345692h == true) goto L24;
            r108.f345692h = true;
            Function0<Unit> r109 = r108.f345693i;
            if (r109 == null) goto L25;
            r109.invoke();
            return;
        L25:
            return;
        L24:
            return;
        L14:
            int r110 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
            StringBuilder r111 = new StringBuilder();
            r111.append(r105.w());
            r111.append(" phase=source result=");
            r111.append(r100.f571195a.size());
            r111.append(" loaded=");
            r111.append(r101);
            r111.append("->");
            r111.append(r105.f345687c.size());
            r111.append(" displayed=");
            r111.append(r102);
            r111.append("->");
            r111.append(r105.f345688d.size());
            r111.append(" hasMore=");
            r111.append(r100.f571196b);
            r111.append(" error=");
            if (r100.f571197c == null) goto L17;
            r106 = true;
        L17:
            r111.append(r106);
            com.larus.home.impl.main.side_bar.feed.arch.t.c("content_result", r111.toString());
            goto L18
        L5:
            if (r102 != r105.f345688d.size()) goto L10;
            if (r100.f571197c != null) goto L10;
            r107 = false;
            goto L11
        }

        @Override // zb9.u
        public final void b(zb9.i<ITEM> r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            o<ITEM> r101 = this.f345695a;
            Object r102 = r101.f345686b.f345704c.c(r100);
            Iterator<zb9.i<ITEM>> r103 = r101.f345687c.iterator();
            int r104 = 0;
        L4:
            if (r103.hasNext() == false) goto L9;
            zb9.i<ITEM> r105 = r103.next();
            if (Intrinsics.areEqual(r101.f345686b.f345704c.c(r105), r102) == true) goto L10;
            r104 = r104 + 1;
        L10:
            if (r104 < 0) goto L16;
            List r106 = CollectionsKt.toMutableList(r101.f345687c);
            ListProtector.set(r106, r104, r101.f345686b.f345704c.b((zb9.i) ListProtector.get(r106, r104), r100));
            r101.f345687c = CollectionsKt.sortedWith(r106, r101.f345686b.f345704c.a(r101.f345685a.e()));
            r101.s();
            return;
        L16:
            return;
        L9:
            r104 = -1;
            goto L10
        }
    }

    public abstract FlowFeedAdapter t();

    public abstract void u(List<? extends ITEM> r100);

    public final void a() {
        boolean r100 = false;
        if (this.f345689e == false) goto L5;
        int r101 = this.f345694j;
        if (r101 != 0) goto L18;
        r100 = true;
    L18:
        this.f345694j = r101 + 1;
        z r102 = this.f345686b.f345702a;
        if (r100 == false) goto L21;
        int r103 = r102.f345737b;
    L22:
        int r104 = RangesKt.coerceAtLeast(r103, 1);
        this.f345686b.f345703b.c(r104);
        int r105 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("content_load_more", w() + " pageSize=" + r104 + " display=" + this.f345688d.size() + " loaded=" + this.f345687c.size());
        this.f345685a.a(new zb9.j(r104, this.f345686b.f345705d.invoke()));
        return;
    L21:
        r103 = r102.f345738c;
        goto L22
    L5:
        if (this.f345688d.size() >= this.f345687c.size()) goto L24;
        int r106 = this.f345694j;
        if (r106 != 0) goto L9;
        r100 = true;
    L9:
        this.f345694j = r106 + 1;
        z r107 = this.f345686b.f345702a;
        if (r100 == false) goto L12;
        int r108 = r107.f345737b;
    L13:
        int r109 = RangesKt.coerceAtLeast(r108, 1);
        this.f345686b.f345703b.c(r109);
        int r110 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("content_expand_window", w() + " pageSize=" + r109 + " display=" + this.f345688d.size() + " loaded=" + this.f345687c.size());
        s();
        return;
    L12:
        r108 = r107.f345738c;
        goto L13
    }

    public final boolean hasMore() {
        if (this.f345689e == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f345688d.size() < this.f345687c.size()) goto L8;
        return false;
    }

    public final void k() {
        if (this.f345692h == true) goto L5;
        int r100 = RangesKt.coerceAtLeast(this.f345686b.f345702a.f345736a, 1);
        int r101 = this.f345686b.f345703b.b(r100);
        if (r101 <= r100) goto L13;
        int r102 = 1;
    L14:
        this.f345694j = r102;
        if (this.f345691g == true) goto L18;
        this.f345691g = true;
        this.f345685a.d(this.f345690f);
    L18:
        this.f345685a.g(new zb9.j(r101, this.f345686b.f345705d.invoke()));
        int r103 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("content_first_load", w() + " pageSize=" + r100 + " window=" + r101);
        return;
    L13:
        r102 = 0;
        goto L14
    L5:
        if (this.f345691g == true) goto L8;
        this.f345691g = true;
        this.f345685a.d(this.f345690f);
    L8:
        int r104 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("content_first_load_reuse", w() + " loaded=" + this.f345687c.size() + " displayed=" + this.f345688d.size());
    }

    public final void s() {
        List<zb9.i<ITEM>> r100 = this.f345686b.f345703b.a(this.f345687c, this.f345689e);
        this.f345688d = r100;
        List<zb9.i<ITEM>> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((zb9.i) r103.next()).f571188a);
        goto L4
    L6:
        u(r102);
    }

    public void v() {
        if (this.f345691g == true) goto L5;
        return;
    L5:
        this.f345685a.f(this.f345690f);
        this.f345691g = false;
        int r100 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("content_release", w() + " loaded=" + this.f345687c.size() + " displayed=" + this.f345688d.size());
    }

    public final String w() {
        return "content=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this) + " source=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this.f345685a) + " adapter=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(t());
    }

    public /* bridge */ /* synthetic */ void p(Object r100) {
        x((GroupSortPolicy) r100);
    }

    public final void x(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "policy");
        this.f345685a.h(r100);
        GroupSortPolicy r101 = this.f345685a.e();
        this.f345687c = this.f345686b.f345704c.d(CollectionsKt.emptyList(), this.f345687c, r101);
        s();
    }

    public o(zb9.s<ITEM> r100, q<ITEM> r101) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r101, "adapterConfig");
        this.f345685a = r100;
        this.f345686b = r101;
        this.f345687c = CollectionsKt.emptyList();
        this.f345688d = CollectionsKt.emptyList();
        this.f345690f = new a(this);
    }
}
