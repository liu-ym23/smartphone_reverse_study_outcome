package com.google.android.gms.internal.common;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: loaded from: classes23.dex */
@NullMarked
public abstract class zzag extends zzac implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f274657b = null;

    @Override // com.google.android.gms.internal.common.zzac, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzo(0);
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return zzo(0);
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final zzag zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final f zze() {
        return zzo(0);
    }

    static {
        f274657b = new d(zzai.f274658zza, 0);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int r100 = size();
        int r101 = 0;
        int r102 = 1;
    L3:
        if (r101 >= r100) goto L5;
        r102 = (r102 * 31) + get(r101).hashCode();
        r101 = r101 + 1;
        goto L3
    L5:
        return r102;
    }

    public zzag() {
    }

    public static zzag zzl() {
        return zzai.f274658zza;
    }

    public static zzag zzj(Iterable r100) {
        r100.getClass();
        if ((r100 instanceof Collection) == true) goto L18;
        Iterator r101 = r100.iterator();
        if (r101.hasNext() == false) goto L19;
        Object r102 = r101.next();
        if (r101.hasNext() == false) goto L20;
        c r103 = new c();
        r103.a(r102);
    L13:
        if (r101.hasNext() == false) goto L15;
        r103.a(r101.next());
        goto L13
    L15:
        r103.f274645c = true;
        return zzi(r103.f274643a, r103.f274644b);
    L20:
        return zzm(r102);
    L19:
        return zzai.f274658zza;
    L18:
        return zzk((Collection) r100);
    }

    public static zzag zzk(Collection r100) {
        if ((r100 instanceof zzac) == false) goto L8;
        zzag r101 = ((zzac) r100).zzd();
        if (r101.zzf() == false) goto L10;
        Object[] r102 = r101.toArray();
        return zzi(r102, r102.length);
    L10:
        return r101;
    L8:
        Object[] r103 = r100.toArray();
        int r104 = r103.length;
        e.a(r103, r104);
        return zzi(r103, r104);
    }

    public static zzag zzm(Object r100) {
        Object[] r101 = {r100};
        e.a(r101, 1);
        return zzi(r101, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object r100) {
        if (indexOf(r100) < 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof List) == false) goto L45;
        List r101 = (List) r100;
        int r102 = size();
        if (r102 != r101.size()) goto L45;
        if ((r101 instanceof RandomAccess) == false) goto L26;
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L57;
        Object r104 = ListProtector.get(this, r103);
        Object r105 = ListProtector.get(r101, r103);
        if (r104 == r105) goto L22;
        if (r104 != null) goto L19;
    L21:
        boolean r106 = false;
    L23:
        if (r106 == false) goto L45;
        r103 = r103 + 1;
        goto L14
    L19:
        if (r104.equals(r105) == false) goto L21;
    L22:
        r106 = true;
        goto L23
    L57:
        return true;
    L26:
        Iterator r107 = iterator();
        Iterator r108 = r101.iterator();
    L28:
        if (r107.hasNext() == false) goto L43;
        if (r108.hasNext() == false) goto L45;
        Object r109 = r107.next();
        Object r110 = r108.next();
        if (r109 == r110) goto L39;
        if (r109 != null) goto L36;
    L38:
        boolean r111 = false;
    L40:
        if (r111 == true) goto L28;
    L36:
        if (r109.equals(r110) == false) goto L38;
    L39:
        r111 = true;
        goto L40
    L43:
        if (r108.hasNext() == true) goto L45;
        return true;
    L45:
        return false;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r101 = size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L14;
        if (r100.equals(ListProtector.get(this, r102)) == true) goto L11;
        r102 = r102 + 1;
        goto L6
    L11:
        return r102;
    L14:
        return -1;
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r101 = size() - 1;
    L6:
        if (r101 < 0) goto L14;
        if (r100.equals(ListProtector.get(this, r101)) == true) goto L11;
        r101 = r101 - 1;
        goto L6
    L11:
        return r101;
    L14:
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int r100) {
        return zzo(r100);
    }

    @Override // java.util.List
    public final Object remove(int r100) {
        throw new UnsupportedOperationException();
    }

    public final g zzo(int r100) {
        int r101 = size();
        if (r100 < 0) goto L12;
        if (r100 > r101) goto L12;
        if (isEmpty() == false) goto L10;
        return f274657b;
    L10:
        return new d(this, r100);
    L12:
        throw new IndexOutOfBoundsException(m.c(r100, r101, "index"));
    }

    public static zzag zzi(Object[] r100, int r101) {
        if (r101 != 0) goto L6;
        return zzai.f274658zza;
    L6:
        return new zzai(r100, r101);
    }

    public static zzag zzn(Object r100, Object r101) {
        Object[] r102 = {r100, r101};
        e.a(r102, 2);
        return zzi(r102, 2);
    }

    @Override // java.util.List
    public final void add(int r100, Object r101) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int r100, Collection r101) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int r100, Object r101) {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ List subList(int r100, int r101) {
        return zzh(r100, r101);
    }

    @Override // com.google.android.gms.internal.common.zzac
    public int zza(Object[] r100, int r101) {
        int r102 = size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100[r103] = get(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public zzag zzh(int r100, int r101) {
        m.b(r100, r101, size());
        int r102 = r101 - r100;
        if (r102 != size()) goto L5;
        return this;
    L5:
        if (r102 != 0) goto L9;
        return zzai.f274658zza;
    L9:
        return new zzaf(this, r100, r102);
    }
}
