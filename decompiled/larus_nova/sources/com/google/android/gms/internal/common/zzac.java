package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Use ImmutableList.of or another implementation")
@NullMarked
public abstract class zzac extends AbstractCollection implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f274654a = null;

    static {
        f274654a = new Object[0];
    }

    public int zza(Object[] r100, int r101) {
        throw null;
    }

    int zzb() {
        throw null;
    }

    int zzc() {
        throw null;
    }

    public zzag zzd() {
        throw null;
    }

    public abstract f zze();

    public abstract boolean zzf();

    @CheckForNull
    public Object[] zzg() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f274654a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return zze();
    }

    public zzac() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] r100) {
        r100.getClass();
        int r101 = size();
        int r102 = r100.length;
        if (r102 >= r101) goto L11;
        Object[] r103 = zzg();
        if (r103 != null) goto L10;
        if (r102 == 0) goto L8;
        r100 = Arrays.copyOf(r100, 0);
    L8:
        r100 = Arrays.copyOf(r100, r101);
    L13:
        zza(r100, 0);
        return r100;
    L10:
        return Arrays.copyOfRange(r103, zzc(), zzb(), r100.getClass());
    L11:
        if (r102 <= r101) goto L13;
        r100[r101] = null;
        goto L13
    }
}
