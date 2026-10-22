package com.larus.camera.impl.ui.arch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx8.d;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d> f321794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f321795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f321796c;

    public final void a() {
        ((ArrayList) this.f321794a).clear();
        ((ArrayList) this.f321795b).clear();
        ((ArrayList) this.f321796c).clear();
    }

    public final List<d> c() {
        return CollectionsKt.plus(CollectionsKt.plus(this.f321794a, this.f321795b), this.f321796c);
    }

    public a() {
        this.f321794a = new ArrayList();
        this.f321795b = new ArrayList();
        this.f321796c = new ArrayList();
    }

    public final List<d> b(List<? extends d> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        a();
        Iterator<? extends d> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        d r102 = r101.next();
        c r103 = r102.getPriority();
        if (Intrinsics.areEqual(r103, c.f321811b) == true) goto L7;
        if (Intrinsics.areEqual(r103, c.f321810a) == true) goto L10;
        if (Intrinsics.areEqual(r103, c.f321812c) == false) goto L4;
        ((ArrayList) this.f321794a).add(r102);
        goto L4
    L10:
        ((ArrayList) this.f321796c).add(r102);
        goto L4
    L7:
        ((ArrayList) this.f321795b).add(r102);
        goto L4
    L15:
        return c();
    }
}
