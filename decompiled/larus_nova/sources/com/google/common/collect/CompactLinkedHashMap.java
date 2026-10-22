package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private final boolean accessOrder;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f274988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient int f274989i;

    @CheckForNull
    transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap();
    }

    @Override // com.google.common.collect.CompactHashMap
    public int allocArrays() {
        int r100 = super.allocArrays();
        this.links = new long[r100];
        return r100;
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        this.f274988h = -2;
        this.f274989i = -2;
        long[] r100 = this.links;
        if (r100 == null) goto L8;
        Arrays.fill(r100, 0, size(), 0);
    L8:
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> r100 = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return r100;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int firstEntryIndex() {
        return this.f274988h;
    }

    public CompactLinkedHashMap(int r100) {
        this(r100, false);
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int r100) {
        return new CompactLinkedHashMap(r100);
    }

    @Override // com.google.common.collect.CompactHashMap
    public void accessEntry(int r100) {
        if (this.accessOrder == false) goto L6;
        long[] r101 = this.links;
        Objects.requireNonNull(r101);
        h(((int) (r101[r100] >>> 32)) - 1, getSuccessor(r100));
        h(this.f274989i, r100);
        h(r100, -2);
        incrementModCount();
        return;
    }

    @Override // com.google.common.collect.CompactHashMap
    public Map<K, V> createHashFloodingResistantDelegate(int r100) {
        return new LinkedHashMap(r100, 1.0f, this.accessOrder);
    }

    @Override // com.google.common.collect.CompactHashMap
    public int getSuccessor(int r100) {
        long[] r101 = this.links;
        Objects.requireNonNull(r101);
        return ((int) r101[r100]) - 1;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void init(int r100) {
        super.init(r100);
        this.f274988h = -2;
        this.f274989i = -2;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void resizeEntries(int r100) {
        super.resizeEntries(r100);
        long[] r101 = this.links;
        Objects.requireNonNull(r101);
        this.links = Arrays.copyOf(r101, r100);
    }

    public CompactLinkedHashMap(int r100, boolean r101) {
        super(r100);
        this.accessOrder = r101;
    }

    @Override // com.google.common.collect.CompactHashMap
    public int adjustAfterRemove(int r100, int r101) {
        if (r100 >= size()) goto L5;
        return r100;
    L5:
        return r101;
    }

    public final void h(int r100, int r110) {
        if (r100 != (-2)) goto L5;
        this.f274988h = r110;
    L6:
        if (r110 != (-2)) goto L8;
        this.f274989i = r100;
        return;
    L8:
        long[] r101 = this.links;
        Objects.requireNonNull(r101);
        long r102 = (BodyPartID.bodyIdMax & r101[r110]) | (((long) (r100 + 1)) << 32);
        long[] r103 = this.links;
        Objects.requireNonNull(r103);
        r103[r110] = r102;
        return;
    L5:
        long[] r104 = this.links;
        Objects.requireNonNull(r104);
        long r105 = (r104[r100] & (-4294967296L)) | (((long) (r110 + 1)) & BodyPartID.bodyIdMax);
        long[] r106 = this.links;
        Objects.requireNonNull(r106);
        r106[r100] = r105;
        goto L6
    }

    @Override // com.google.common.collect.CompactHashMap
    public void moveLastEntry(int r100, int r101) {
        int r102 = size() - 1;
        super.moveLastEntry(r100, r101);
        long[] r103 = this.links;
        Objects.requireNonNull(r103);
        h(((int) (r103[r100] >>> 32)) - 1, getSuccessor(r100));
        if (r100 >= r102) goto L5;
        long[] r104 = this.links;
        Objects.requireNonNull(r104);
        h(((int) (r104[r102] >>> 32)) - 1, r100);
        h(r100, getSuccessor(r102));
    L5:
        long[] r105 = this.links;
        Objects.requireNonNull(r105);
        r105[r102] = 0;
    }

    @Override // com.google.common.collect.CompactHashMap
    public void insertEntry(int r100, @ParametricNullness K r101, @ParametricNullness V r102, int r103, int r104) {
        super.insertEntry(r100, r101, r102, r103, r104);
        h(this.f274989i, r100);
        h(r100, -2);
    }
}
