package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements f1<K, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient ImmutableListMultimap<V, K> f275064f;

    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        public final ImmutableListMultimap<K, V> d() {
            return ImmutableListMultimap.fromMapEntries(this.f275086a.entrySet(), null);
        }

        public a() {
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        public final void c(Map.Entry r100) {
            super.c(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.c
        public final ImmutableMultimap.c b(Object r100, Object r101) {
            super.b(r100, r101);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void e(Object r100, Object r101) {
            super.b(r100, r101);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> r100 = this.f275064f;
        if (r100 != null) goto L11;
        a r101 = builder();
        z2 r102 = entries().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.e(r103.getValue(), r103.getKey());
        goto L6
    L8:
        ImmutableListMultimap<V, K> r104 = r101.d();
        r104.f275064f = this;
        this.f275064f = r104;
        return r104;
    L11:
        return r100;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableMultimap inverse() {
        return inverse();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(q1<? extends K, ? extends V> r100) {
        if (r100.isEmpty() == false) goto L7;
        return of();
    L7:
        if ((r100 instanceof ImmutableListMultimap) == false) goto L12;
        ImmutableListMultimap<K, V> r101 = (ImmutableListMultimap) r100;
        if (r101.isPartialView() == true) goto L12;
        return r101;
    L12:
        return fromMapEntries(r100.asMap().entrySet(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r110) throws IOException, ClassNotFoundException {
        r110.defaultReadObject();
        int r100 = r110.readInt();
        if (r100 < 0) goto L25;
        ImmutableMap.b r101 = ImmutableMap.builder();
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r102 >= r100) goto L28;
        Object r104 = r110.readObject();
        int r105 = r110.readInt();
        if (r105 <= 0) goto L13;
        ImmutableList.a r106 = ImmutableList.builder();
        int r107 = 0;
    L9:
        if (r107 >= r105) goto L11;
        r106.b(r110.readObject());
        r107 = r107 + 1;
        goto L9
    L11:
        r101.e(r104, r106.e());
        r103 = r103 + r105;
        r102 = r102 + 1;
        goto L5
    L13:
        throw new InvalidObjectException("Invalid value count " + r105);
    L28:
        ImmutableMultimap.d.f275087a.a(this, r101.d());
        j2.a<ImmutableMultimap> r111 = ImmutableMultimap.d.f275088b;
        r111.getClass();
        r111.f275479a.set(this, Integer.valueOf(r103));     // Catch: IllegalAccessException -> L18
        return;
    L18:
        e = move-exception;
        throw new AssertionError(e);
    L21:
        e = move-exception;
        throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
    L25:
        throw new InvalidObjectException("Invalid key count " + r100);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        j2.f(this, r100);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public ImmutableList<V> get(K r100) {
        ImmutableList<V> r101 = (ImmutableList) this.map.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public final ImmutableList<V> removeAll(@CheckForNull Object r100) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r100) {
        a r101 = new a();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.c(r102.next());
        goto L4
    L7:
        return r101.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ ImmutableCollection removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection get(Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ List get(Object r100) {
        return get(r100);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ List removeAll(@CheckForNull Object r100) {
        return removeAll(r100);
    }

    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> r100, int r101) {
        super(r100, r101);
    }

    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r100, @CheckForNull Comparator<? super V> r101) {
        if (r100.isEmpty() == true) goto L5;
        ImmutableMap.b r102 = new ImmutableMap.b(r100.size());
        Iterator<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r103 = r100.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<? extends K, ? extends Collection<? extends V>> r105 = r103.next();
        K r106 = r105.getKey();
        Collection<? extends V> r107 = r105.getValue();
        if (r101 != null) goto L12;
        ImmutableList r108 = ImmutableList.copyOf(r107);
    L14:
        if (r108.isEmpty() == true) goto L8;
        r102.e(r106, r108);
        r104 = r104 + r108.size();
        goto L8
    L12:
        r108 = ImmutableList.sortedCopyOf(r101, r107);
        goto L14
    L17:
        return new ImmutableListMultimap(r102.b(true), r104);
    L5:
        return of();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r100, V r101) {
        a r102 = builder();
        r102.e(r100, r101);
        return r102.d();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public final ImmutableList<V> replaceValues(K r100, Iterable<? extends V> r101) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.q1
    public /* bridge */ /* synthetic */ List replaceValues(Object r100, Iterable r101) {
        return replaceValues(r100, r101);
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r100, V r101, K r102, V r103) {
        a r104 = builder();
        r104.e(r100, r101);
        r104.e(r102, r103);
        return r104.d();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105) {
        a r106 = builder();
        r106.e(r100, r101);
        r106.e(r102, r103);
        r106.e(r104, r105);
        return r106.d();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107) {
        a r108 = builder();
        r108.e(r100, r101);
        r108.e(r102, r103);
        r108.e(r104, r105);
        r108.e(r106, r107);
        return r108.d();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r100, V r101, K r102, V r103, K r104, V r105, K r106, V r107, K r108, V r110) {
        a r109 = builder();
        r109.e(r100, r101);
        r109.e(r102, r103);
        r109.e(r104, r105);
        r109.e(r106, r107);
        r109.e(r108, r110);
        return r109.d();
    }
}
