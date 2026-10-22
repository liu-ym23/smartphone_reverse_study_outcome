package com.ixigua.lib.list;

import android.util.SparseArray;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutInflater f278498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a<?, ?>> f278499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Integer> f278500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f278501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakHashMap<Object, Integer> f278502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ListAdapter f278503f;

    public final int a(Object r100) {
        if (r100 != null) goto L24;
        return Integer.MIN_VALUE;
    L24:
        Integer r101 = this.f278502e.get(r100);     // Catch: Throwable -> L11
        if (r101 != null) goto L8;
    L12:
        System.currentTimeMillis();
        Iterator<Integer> r102 = this.f278500c.iterator();
    L14:
        if (r102.hasNext() == false) goto L23;
        Integer r103 = r102.next();
        if (Intrinsics.compare(r103.intValue(), 0) <= 0) goto L14;
        boolean r104 = b(r103.intValue()).accept(r100);     // Catch: Throwable -> L22
        ListAgency.f278497d.getClass();     // Catch: Throwable -> L22
        if (r104 == false) goto L14;
        this.f278502e.put(r100, r103);     // Catch: Throwable -> L22
        return r103.intValue();
    L22:
        ListAgency.f278497d.getClass();
        goto L14
    L23:
        return Integer.MIN_VALUE;
    L8:
        if (r101.intValue() <= 0) goto L12;
        return r101.intValue();
    L11:
        ListAgency.f278497d.getClass();
        goto L12
    }

    public final a<Object, RecyclerView.ViewHolder> b(int r100) {
        SparseArray<a<?, ?>> r101 = this.f278499b;
        a<?, ?> r102 = r101.get(r100, r101.get(Integer.MIN_VALUE));
        if (r102 == null) goto L7;
        return r102;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.ixigua.lib.list.Delegate<kotlin.Any, androidx.recyclerview.widget.RecyclerView.ViewHolder>");
    }

    public b(ListAdapter r100, List<? extends a<?, ?>> r101) {
        this.f278503f = r100;
        this.f278498a = LayoutInflater.from(r100.f278493e.a());
        this.f278499b = new SparseArray();
        this.f278500c = new ArrayList();
        this.f278501d = 1000000;
        this.f278502e = new WeakHashMap(1024);
        if ((!r101.isEmpty()) == false) goto L8;
        Iterator<? extends a<?, ?>> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        a<?, ?> r103 = r102.next();
        int r104 = this.f278501d + 1;
        this.f278501d = r104;
        this.f278499b.put(r104, r103);
        this.f278500c.add(Integer.valueOf(r104));
    L8:
        this.f278499b.put(Integer.MIN_VALUE, zx7.a.f573890a);
        this.f278500c.add(Integer.MIN_VALUE);
    }
}
