package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes41.dex */
public final class OpenHashSet<T> {
    private static final int INT_PHI = -1640531527;
    T[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    public static int mix(int r100) {
        int r101 = r100 * INT_PHI;
        return r101 ^ (r101 >>> 16);
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public void rehash() {
        T[] r100 = this.keys;
        int r101 = r100.length;
        int r102 = r101 << 1;
        int r103 = r102 - 1;
        T[] r104 = (T[]) new Object[r102];
        int r105 = this.size;
    L3:
        int r106 = r105 - 1;
        if (r105 == 0) goto L13;
    L5:
        r101 = r101 - 1;
        T r107 = r100[r101];
        if (r107 == null) goto L5;
        int r108 = mix(r107.hashCode()) & r103;
        if (r104[r108] == null) goto L12;
    L10:
        r108 = (r108 + 1) & r103;
        if (r104[r108] != null) goto L10;
    L12:
        r104[r108] = r100[r101];
        r105 = r106;
        goto L3
    L13:
        this.mask = r103;
        this.maxSize = (int) (r102 * this.loadFactor);
        this.keys = r104;
    }

    public Object[] keys() {
        return this.keys;
    }

    public int size() {
        return this.size;
    }

    public OpenHashSet(int r100) {
        this(r100, 0.75f);
    }

    public boolean add(T r100) {
        T[] r101 = this.keys;
        int r102 = this.mask;
        int r103 = mix(r100.hashCode()) & r102;
        T r104 = r101[r103];
        if (r104 != null) goto L5;
    L13:
        r101[r103] = r100;
        int r105 = this.size + 1;
        this.size = r105;
        if (r105 < this.maxSize) goto L16;
        rehash();
    L16:
        return true;
    L5:
        if (r104.equals(r100) == false) goto L7;
        return false;
    L7:
        r103 = (r103 + 1) & r102;
        T r106 = r101[r103];
        if (r106 == null) goto L13;
        if (r106.equals(r100) == false) goto L7;
        return false;
    }

    public boolean remove(T r100) {
        T[] r101 = this.keys;
        int r102 = this.mask;
        int r103 = mix(r100.hashCode()) & r102;
        T r104 = r101[r103];
        if (r104 != null) goto L6;
        return false;
    L6:
        if (r104.equals(r100) == true) goto L8;
    L9:
        r103 = (r103 + 1) & r102;
        T r105 = r101[r103];
        if (r105 == null) goto L11;
        if (r105.equals(r100) == false) goto L9;
        return removeEntry(r103, r101, r102);
    L11:
        return false;
    L8:
        return removeEntry(r103, r101, r102);
    }

    public OpenHashSet(int r100, float r101) {
        this.loadFactor = r101;
        int r102 = 1 << (32 - Integer.numberOfLeadingZeros(r100 - 1));
        this.mask = r102 - 1;
        this.maxSize = (int) (r101 * r102);
        this.keys = (T[]) new Object[r102];
    }

    public boolean removeEntry(int r100, T[] r101, int r102) {
        this.size--;
    L3:
        int r103 = r100 + 1;
    L4:
        int r104 = r103 & r102;
        T r105 = r101[r104];
        if (r105 == null) goto L6;
        int r106 = mix(r105.hashCode()) & r102;
        if (r100 > r104) goto L13;
        if (r100 >= r106) goto L15;
        if (r106 > r104) goto L15;
    L16:
        r103 = r104 + 1;
    L15:
        r101[r100] = r105;
        r100 = r104;
        goto L3
    L13:
        if (r100 < r106) goto L16;
        if (r106 <= r104) goto L16;
    L6:
        r101[r100] = null;
        return true;
    }
}
