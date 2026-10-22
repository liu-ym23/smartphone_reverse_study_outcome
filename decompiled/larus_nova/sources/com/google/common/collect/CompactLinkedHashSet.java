package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class CompactLinkedHashSet<E> extends CompactHashSet<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    public transient int[] f274990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @CheckForNull
    public transient int[] f274991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient int f274992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f274993h;

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet();
    }

    @Override // com.google.common.collect.CompactHashSet
    public int allocArrays() {
        int r100 = super.allocArrays();
        this.f274990e = new int[r100];
        this.f274991f = new int[r100];
        return r100;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.f274992g = -2;
        this.f274993h = -2;
        int[] r100 = this.f274990e;
        if (r100 != null) goto L8;
    L10:
        super.clear();
        return;
    L8:
        if (this.f274991f == null) goto L10;
        Arrays.fill(r100, 0, size(), 0);
        Arrays.fill(this.f274991f, 0, size(), 0);
        goto L10
    }

    @Override // com.google.common.collect.CompactHashSet
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> r100 = super.convertToHashFloodingResistantImplementation();
        this.f274990e = null;
        this.f274991f = null;
        return r100;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] r100 = new Object[size()];
        b2.b(this, r100);
        return r100;
    }

    public CompactLinkedHashSet() {
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        return this.f274992g;
    }

    public CompactLinkedHashSet(int r100) {
        super(r100);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> r100) {
        CompactLinkedHashSet<E> r101 = createWithExpectedSize(r100.size());
        r101.addAll(r100);
        return r101;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int r100) {
        return new CompactLinkedHashSet(r100);
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int r100) {
        int[] r101 = this.f274991f;
        Objects.requireNonNull(r101);
        return r101[r100] - 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int r100) {
        super.init(r100);
        this.f274992g = -2;
        this.f274993h = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int r100) {
        super.resizeEntries(r100);
        int[] r101 = this.f274990e;
        Objects.requireNonNull(r101);
        this.f274990e = Arrays.copyOf(r101, r100);
        int[] r102 = this.f274991f;
        Objects.requireNonNull(r102);
        this.f274991f = Arrays.copyOf(r102, r100);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r100) {
        return (T[]) b2.c(this, r100);
    }

    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> create(E... r100) {
        CompactLinkedHashSet<E> r101 = createWithExpectedSize(r100.length);
        Collections.addAll(r101, r100);
        return r101;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int r100, int r101) {
        if (r100 >= size()) goto L5;
        return r100;
    L5:
        return r101;
    }

    public final void e(int r100, int r101) {
        if (r100 != (-2)) goto L5;
        this.f274992g = r101;
    L6:
        if (r101 != (-2)) goto L8;
        this.f274993h = r100;
        return;
    L8:
        int[] r102 = this.f274990e;
        Objects.requireNonNull(r102);
        r102[r101] = r100 + 1;
        return;
    L5:
        int[] r103 = this.f274991f;
        Objects.requireNonNull(r103);
        r103[r100] = r101 + 1;
        goto L6
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveLastEntry(int r100, int r101) {
        int r102 = size() - 1;
        super.moveLastEntry(r100, r101);
        int[] r103 = this.f274990e;
        Objects.requireNonNull(r103);
        e(r103[r100] - 1, getSuccessor(r100));
        if (r100 >= r102) goto L5;
        int[] r104 = this.f274990e;
        Objects.requireNonNull(r104);
        e(r104[r102] - 1, r100);
        e(r100, getSuccessor(r102));
    L5:
        int[] r105 = this.f274990e;
        Objects.requireNonNull(r105);
        r105[r102] = 0;
        int[] r106 = this.f274991f;
        Objects.requireNonNull(r106);
        r106[r102] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int r100, @ParametricNullness E r101, int r102, int r103) {
        super.insertEntry(r100, r101, r102, r103);
        e(this.f274993h, r100);
        e(r100, -2);
    }
}
