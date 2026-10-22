package com.google.common.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = null;
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    public final transient Object f275303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f275304f;

    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient ImmutableMap<K, V> f275305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Object[] f275306d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f275307e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient int f275308f;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public z2<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f275308f;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        public static /* synthetic */ int access$000(EntrySet r100) {
            return r100.f275308f;
        }

        public static /* synthetic */ Object[] access$100(EntrySet r100) {
            return r100.f275306d;
        }

        public static /* synthetic */ int access$200(EntrySet r100) {
            return r100.f275307e;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            if ((r100 instanceof Map.Entry) == false) goto L10;
            Map.Entry r101 = (Map.Entry) r100;
            Object r102 = r101.getKey();
            Object r103 = r101.getValue();
            if (r103 != null) goto L7;
            return false;
        L7:
            if (r103.equals(this.f275305c.get(r102)) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] r100, int r101) {
            return asList().copyIntoArray(r100, r101);
        }

        public EntrySet(ImmutableMap<K, V> r100, Object[] r101, int r102, int r103) {
            this.f275305c = r100;
            this.f275306d = r101;
            this.f275307e = r102;
            this.f275308f = r103;
        }
    }

    public static final class KeySet<K> extends ImmutableSet<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient ImmutableMap<K, ?> f275309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient ImmutableList<K> f275310d;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f275309c.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public z2<K> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f275310d;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r100) {
            if (this.f275309c.get(r100) == null) goto L5;
            return true;
        L5:
            return false;
        }

        public KeySet(ImmutableMap<K, ?> r100, ImmutableList<K> r101) {
            this.f275309c = r100;
            this.f275310d = r101;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] r100, int r101) {
            return asList().copyIntoArray(r100, r101);
        }
    }

    public static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient Object[] f275311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient int f275312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient int f275313e;

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f275313e;
        }

        @Override // java.util.List
        public Object get(int r100) {
            com.google.common.base.m.j(r100, this.f275313e);
            Object r101 = this.f275311c[(r100 * 2) + this.f275312d];
            Objects.requireNonNull(r101);
            return r101;
        }

        public KeysOrValuesAsList(Object[] r100, int r101, int r102) {
            this.f275311c = r100;
            this.f275312d = r101;
            this.f275313e = r102;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    static {
        EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.f275304f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.f275304f));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.f275304f);
    }

    @Override // java.util.Map
    public int size() {
        return this.f275304f;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object r100) {
        V r101 = (V) get(this.f275303e, this.alternatingKeysAndValues, this.f275304f, 0, r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101;
    }

    public static <K, V> RegularImmutableMap<K, V> create(int r100, Object[] r101) {
        return create(r100, r101, null);
    }

    public RegularImmutableMap(@CheckForNull Object r100, Object[] r101, int r102) {
        this.f275303e = r100;
        this.alternatingKeysAndValues = r101;
        this.f275304f = r102;
    }

    public static <K, V> RegularImmutableMap<K, V> create(int r100, Object[] r101, ImmutableMap.b<K, V> r102) {
        if (r100 != 0) goto L6;
        return (RegularImmutableMap) EMPTY;
    L6:
        if (r100 != 1) goto L9;
        Objects.requireNonNull(r101[0]);
        Objects.requireNonNull(r101[1]);
        return new RegularImmutableMap(null, r101, 1);
    L9:
        com.google.common.base.m.m(r100, r101.length >> 1);
        Object r103 = a(r101, r100, ImmutableSet.chooseTableSize(r100), 0);
        if ((r103 instanceof Object[]) == false) goto L17;
        Object[] r104 = (Object[]) r103;
        ImmutableMap.b.a r105 = (ImmutableMap.b.a) r104[2];
        if (r102 == null) goto L15;
        r102.f275073c = r105;
        Object r106 = r104[0];
        int r107 = ((Integer) r104[1]).intValue();
        r101 = Arrays.copyOf(r101, r107 * 2);
        r103 = r106;
        r100 = r107;
        goto L17
    L15:
        throw r105.a();
    L17:
        return new RegularImmutableMap(r103, r101, r100);
    }

    @CheckForNull
    public static Object a(Object[] r110, int r111, int r112, int r113) {
        ImmutableMap.b.a r100 = null;
        if (r111 != 1) goto L6;
        Objects.requireNonNull(r110[r113]);
        Objects.requireNonNull(r110[r113 ^ 1]);
        return null;
    L6:
        int r101 = r112 - 1;
        int r102 = -1;
        if (r112 > 128) goto L27;
        byte[] r103 = new byte[r112];
        Arrays.fill(r103, (byte) -1);
        int r104 = 0;
        int r105 = 0;
    L9:
        if (r104 >= r111) goto L22;
        int r114 = (r104 * 2) + r113;
        int r115 = (r105 * 2) + r113;
        Object r116 = r110[r114];
        Objects.requireNonNull(r116);
        Object r117 = r110[r114 ^ 1];
        Objects.requireNonNull(r117);
        int r118 = u0.b(r116.hashCode());
    L11:
        int r119 = r118 & r101;
        int r120 = r103[r119] & UByte.MAX_VALUE;
        if (r120 == 255) goto L13;
        if (r116.equals(r110[r120]) == true) goto L19;
        r118 = r119 + 1;
        goto L11
    L19:
        int r121 = r120 ^ 1;
        Object r122 = r110[r121];
        Objects.requireNonNull(r122);
        r100 = new ImmutableMap.b.a(r116, r117, r122);
        r110[r121] = r117;
    L20:
        r104 = r104 + 1;
        goto L9
    L13:
        r103[r119] = (byte) r115;
        if (r105 >= r104) goto L16;
        r110[r115] = r116;
        r110[r115 ^ 1] = r117;
    L16:
        r105 = r105 + 1;
        goto L20
    L22:
        if (r105 != r111) goto L25;
        return r103;
    L25:
        return new Object[]{r103, Integer.valueOf(r105), r100};
    L27:
        if (r112 > 32768) goto L46;
        short[] r106 = new short[r112];
        Arrays.fill(r106, -1);
        int r107 = 0;
        int r108 = 0;
    L29:
        if (r107 >= r111) goto L42;
        int r123 = (r107 * 2) + r113;
        int r124 = (r108 * 2) + r113;
        Object r125 = r110[r123];
        Objects.requireNonNull(r125);
        Object r126 = r110[r123 ^ 1];
        Objects.requireNonNull(r126);
        int r127 = u0.b(r125.hashCode());
    L31:
        int r128 = r127 & r101;
        int r129 = r106[r128] & 65535;
        if (r129 == 65535) goto L33;
        if (r125.equals(r110[r129]) == true) goto L39;
        r127 = r128 + 1;
        goto L31
    L39:
        int r130 = r129 ^ 1;
        Object r131 = r110[r130];
        Objects.requireNonNull(r131);
        r100 = new ImmutableMap.b.a(r125, r126, r131);
        r110[r130] = r126;
    L40:
        r107 = r107 + 1;
        goto L29
    L33:
        r106[r128] = (short) r124;
        if (r108 >= r107) goto L36;
        r110[r124] = r125;
        r110[r124 ^ 1] = r126;
    L36:
        r108 = r108 + 1;
        goto L40
    L42:
        if (r108 != r111) goto L45;
        return r106;
    L45:
        return new Object[]{r106, Integer.valueOf(r108), r100};
    L46:
        int[] r109 = new int[r112];
        Arrays.fill(r109, -1);
        int r132 = 0;
        int r133 = 0;
    L47:
        if (r132 >= r111) goto L60;
        int r134 = (r132 * 2) + r113;
        int r135 = (r133 * 2) + r113;
        Object r136 = r110[r134];
        Objects.requireNonNull(r136);
        Object r137 = r110[r134 ^ 1];
        Objects.requireNonNull(r137);
        int r138 = u0.b(r136.hashCode());
    L49:
        int r139 = r138 & r101;
        int r140 = r109[r139];
        if (r140 == r102) goto L51;
        if (r136.equals(r110[r140]) == true) goto L57;
        r138 = r139 + 1;
        r102 = -1;
        goto L49
    L57:
        int r141 = r140 ^ 1;
        Object r142 = r110[r141];
        Objects.requireNonNull(r142);
        r100 = new ImmutableMap.b.a(r136, r137, r142);
        r110[r141] = r137;
    L58:
        r132 = r132 + 1;
        r102 = -1;
        goto L47
    L51:
        r109[r139] = r135;
        if (r133 >= r132) goto L54;
        r110[r135] = r136;
        r110[r135 ^ 1] = r137;
    L54:
        r133 = r133 + 1;
        goto L58
    L60:
        if (r133 != r111) goto L63;
        return r109;
    L63:
        return new Object[]{r109, Integer.valueOf(r133), r100};
    }

    @CheckForNull
    public static Object createHashTableOrThrow(Object[] r100, int r101, int r102, int r103) {
        Object r104 = a(r100, r101, r102, r103);
        if ((r104 instanceof Object[]) == true) goto L6;
        return r104;
    L6:
        throw ((ImmutableMap.b.a) ((Object[]) r104)[2]).a();
    }

    @CheckForNull
    public static Object get(@CheckForNull Object r100, Object[] r101, int r102, int r103, @CheckForNull Object r104) {
        if (r104 != null) goto L6;
        return null;
    L6:
        if (r102 != 1) goto L11;
        Object r105 = r101[r103];
        Objects.requireNonNull(r105);
        if (r105.equals(r104) == false) goto L50;
        Object r106 = r101[r103 ^ 1];
        Objects.requireNonNull(r106);
        return r106;
    L50:
        return null;
    L11:
        if (r100 != null) goto L14;
        return null;
    L14:
        if ((r100 instanceof byte[]) == false) goto L25;
        byte[] r107 = (byte[]) r100;
        int r108 = r107.length - 1;
        int r109 = u0.b(r104.hashCode());
    L16:
        int r110 = r109 & r108;
        int r111 = r107[r110] & UByte.MAX_VALUE;
        if (r111 == 255) goto L18;
        if (r104.equals(r101[r111]) == true) goto L22;
        r109 = r110 + 1;
        goto L16
    L22:
        return r101[r111 ^ 1];
    L18:
        return null;
    L25:
        if ((r100 instanceof short[]) == false) goto L35;
        short[] r112 = (short[]) r100;
        int r113 = r112.length - 1;
        int r114 = u0.b(r104.hashCode());
    L27:
        int r115 = r114 & r113;
        int r116 = r112[r115] & 65535;
        if (r116 == 65535) goto L29;
        if (r104.equals(r101[r116]) == true) goto L33;
        r114 = r115 + 1;
        goto L27
    L33:
        return r101[r116 ^ 1];
    L29:
        return null;
    L35:
        int[] r117 = (int[]) r100;
        int r118 = r117.length - 1;
        int r119 = u0.b(r104.hashCode());
    L36:
        int r120 = r119 & r118;
        int r121 = r117[r120];
        if (r121 == (-1)) goto L38;
        if (r104.equals(r101[r121]) == true) goto L42;
        r119 = r120 + 1;
        goto L36
    L42:
        return r101[r121 ^ 1];
    L38:
        return null;
    }
}
