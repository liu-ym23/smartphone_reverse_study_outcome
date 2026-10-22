package com.ss.android.ugc.route_monitor.impl.route_out.control;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements List<c>, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f454621a;

    @Override // java.util.List
    public final boolean addAll(int r100, Collection<? extends c> r101) {
        return this.f454621a.addAll(r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends c> r100) {
        return this.f454621a.addAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f454621a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> r100) {
        return this.f454621a.containsAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f454621a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator<c> iterator() {
        return this.f454621a.iterator();
    }

    @Override // java.util.List
    public final ListIterator<c> listIterator() {
        return this.f454621a.listIterator();
    }

    @Override // java.util.List
    public final ListIterator<c> listIterator(int r100) {
        return this.f454621a.listIterator(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> r100) {
        return this.f454621a.removeAll(r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> r100) {
        return this.f454621a.retainAll(r100);
    }

    @Override // java.util.List
    public final List<c> subList(int r100, int r101) {
        return this.f454621a.subList(r100, r101);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] r100) {
        return (T[]) CollectionToArray.toArray(this, r100);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f454621a.size();
    }

    public e(int r100) {
        this.f454621a = new ArrayList();
    }

    public final c a(int r100) {
        c r101 = (c) ListProtector.get(this.f454621a, r100);
        if (r101.f454616d == false) goto L12;
        ListProtector.remove(this.f454621a, r100);
        mhc.b r102 = j.f454635a;
        List<c> r103 = j.f454638d;
        monitor-enter(r103);
        ((ArrayList) r103).add(r101);     // Catch: Throwable -> L9
        monitor-exit(r103);
    L9:
        th = move-exception;
        throw th;
    L12:
        return r101;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object r100) {
        List<c> r101 = this.f454621a;
        return r101.add((c) r100);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object r100) {
        if ((r100 instanceof c) == false) goto L6;
        List<c> r101 = this.f454621a;
        return r101.contains((c) r100);
    L6:
        return false;
    }

    @Override // java.util.List
    public final c get(int r100) {
        return (c) ListProtector.get(this.f454621a, r100);
    }

    @Override // java.util.List
    public final int indexOf(Object r100) {
        if ((r100 instanceof c) == false) goto L6;
        List<c> r101 = this.f454621a;
        return r101.indexOf((c) r100);
    L6:
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object r100) {
        if ((r100 instanceof c) == false) goto L6;
        List<c> r101 = this.f454621a;
        return r101.lastIndexOf((c) r100);
    L6:
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object r100) {
        if ((r100 instanceof c) == false) goto L6;
        List<c> r101 = this.f454621a;
        return r101.remove((c) r100);
    L6:
        return false;
    }

    @Override // java.util.List
    public final c remove(int r100) {
        return (c) ListProtector.remove(this.f454621a, r100);
    }

    @Override // java.util.List
    public final void add(int r100, c r101) {
        List<c> r102 = this.f454621a;
        ListProtector.add(r102, r100, r101);
    }

    @Override // java.util.List
    public final c set(int r100, c r101) {
        List<c> r102 = this.f454621a;
        return (c) ListProtector.set(r102, r100, r101);
    }
}
