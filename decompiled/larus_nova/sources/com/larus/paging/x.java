package com.larus.paging;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes29.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f363936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function1<i, Unit>> f363937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f363938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u f363939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f363940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v f363941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v f363942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StateFlowImpl f363943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1 f363944i;

    public final void b() {
        u r100 = this.f363938c;
        u r101 = this.f363941f.f363925a;
        v r102 = this.f363942g;
        i r103 = null;
        if (r102 == null) goto L5;
        u r104 = r102.f363925a;
    L6:
        this.f363938c = a(r100, r101, r101, r104);
        u r105 = this.f363939d;
        v r106 = this.f363941f;
        u r107 = r106.f363925a;
        u r108 = r106.f363926b;
        v r109 = this.f363942g;
        if (r109 == null) goto L9;
        u r110 = r109.f363926b;
    L10:
        this.f363939d = a(r105, r107, r108, r110);
        u r111 = this.f363940e;
        v r112 = this.f363941f;
        u r113 = r112.f363925a;
        u r114 = r112.f363927c;
        v r115 = this.f363942g;
        if (r115 == null) goto L13;
        u r116 = r115.f363927c;
    L14:
        u r117 = a(r111, r113, r114, r116);
        this.f363940e = r117;
        if (this.f363936a == false) goto L18;
        r103 = new i(this.f363938c, this.f363939d, r117, this.f363941f, this.f363942g);
    L18:
        if (r103 == null) goto L23;
        this.f363943h.setValue(r103);
        Iterator<Function1<i, Unit>> r118 = this.f363937b.iterator();
    L21:
        if (r118.hasNext() == false) goto L25;
        r118.next().invoke(r103);
        goto L21
    L25:
        return;
    L23:
        return;
    L13:
        r116 = null;
        goto L14
    L9:
        r110 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public x() {
        this.f363937b = new CopyOnWriteArrayList();
        u.c r100 = u.c.f363923c;
        this.f363938c = r100;
        this.f363939d = r100;
        this.f363940e = r100;
        this.f363941f = v.f363924d;
        StateFlowImpl r101 = j1.a(null);
        this.f363943h = r101;
        this.f363944i = new FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1(r101);
    }

    public static u a(u r100, u r101, u r102, u r103) {
        if (r103 != null) goto L5;
        return r102;
    L5:
        if ((r100 instanceof u.b) == false) goto L14;
        if ((r101 instanceof u.c) == false) goto L12;
        if ((r103 instanceof u.c) == true) goto L14;
    L12:
        if ((r103 instanceof u.a) == true) goto L14;
        return r100;
    L14:
        return r103;
    }
}
