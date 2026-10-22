package com.larus.home.impl.main.side_bar.view.group.render;

import androidx.collection.SieveCacheKt;
import com.baidu.platform.comapi.map.MapController;
import com.larus.home.impl.main.side_bar.data.i0;
import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes29.dex */
public abstract class k0<ITEM extends com.larus.home.impl.main.side_bar.data.i0> extends o<ITEM> implements fb9.e, fb9.j<GroupSortPolicy>, fb9.h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f345669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f345670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<? extends ITEM> f345671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f345672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f345673o;

    public boolean A(ITEM r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return false;
    }

    public abstract void C(List<? extends ITEM> r100);

    public int D() {
        return -1;
    }

    public long y() {
        return 0;
    }

    @Override // fb9.h
    public final int d() {
        List<? extends ITEM> r100 = this.f345671m;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (A((com.larus.home.impl.main.side_bar.data.i0) r103) == true) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
        long r105 = 0;
    L10:
        if (r104.hasNext() == false) goto L13;
        r105 = r105 + ((long) RangesKt.coerceAtLeast(((com.larus.home.impl.main.side_bar.data.i0) r104.next()).a(), 0));
        goto L10
    L13:
        return (int) RangesKt.coerceAtMost(((long) ((int) RangesKt.coerceAtMost(r105, SieveCacheKt.NodeLinkMask))) + RangesKt.coerceAtLeast(y(), 0), SieveCacheKt.NodeLinkMask);
    }

    public boolean B() {
        if (D() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public List<fb9.a> z() {
        return CollectionsKt.emptyList();
    }

    @Override // fb9.e
    public final boolean e() {
        return this.f345669k;
    }

    @Override // fb9.e
    public final void j(Integer r100) {
        if (this.f345670l == true) goto L6;
        return;
    L6:
        if (B() == false) goto L8;
        return;
    L8:
        int r101 = RangesKt.coerceAtLeast(this.f345686b.f345702a.f345736a, 1);
        int r102 = this.f345688d.size();
        this.f345686b.f345703b.d(r101);
        this.f345694j = 0;
        s();
        int r103 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("content_reset_window", w() + " pageSize=" + r101 + " displayed=" + r102 + "->" + this.f345688d.size() + " loaded=" + this.f345687c.size());
    }

    @Override // fb9.h
    public final void q(com.larus.home.impl.main.side_bar.view.group.module.u r100) {
        this.f345672n = r100;
    }

    @Override // com.larus.home.impl.main.side_bar.view.group.render.o
    public final void u(List<? extends ITEM> r100) {
        Intrinsics.checkNotNullParameter(r100, "items");
        boolean r101 = this.f345671m.isEmpty();
        this.f345671m = r100;
        C(r100);
        Function0<Unit> r102 = this.f345672n;
        if (r102 == null) goto L5;
        r102.invoke();
    L5:
        boolean r103 = ((ArrayList) r100).isEmpty();
        if (r103 == r101) goto L11;
        Function1<? super Boolean, Unit> r104 = this.f345673o;
        if (r104 == null) goto L12;
        r104.invoke(Boolean.valueOf(r103));
        return;
    L12:
        return;
    }

    public k0(zb9.s<ITEM> r100, q<ITEM> r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r101, "adapterConfig");
        super(r100, r101);
        this.f345669k = r102;
        this.f345670l = r103;
        this.f345671m = CollectionsKt.emptyList();
    }
}
