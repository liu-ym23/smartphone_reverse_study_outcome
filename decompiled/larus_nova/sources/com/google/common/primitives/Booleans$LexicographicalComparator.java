package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final enum Booleans$LexicographicalComparator extends Enum<Booleans$LexicographicalComparator> implements Comparator<boolean[]> {
    public static final Booleans$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Booleans$LexicographicalComparator[] f275632a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "Booleans.lexicographicalComparator()";
    }

    static {
        Booleans$LexicographicalComparator r100 = new Booleans$LexicographicalComparator();
        INSTANCE = r100;
        f275632a = new Booleans$LexicographicalComparator[]{r100};
    }

    public Booleans$LexicographicalComparator() {
        super("INSTANCE", 0);
    }

    public static Booleans$LexicographicalComparator[] values() {
        return (Booleans$LexicographicalComparator[]) f275632a.clone();
    }

    public static Booleans$LexicographicalComparator valueOf(String r100) {
        return (Booleans$LexicographicalComparator) r27.a.a(Booleans$LexicographicalComparator.class, r100);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(boolean[] r100, boolean[] r101) {
        int r102 = Math.min(r100.length, r101.length);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        boolean r104 = r100[r103];
        if (r104 != r101[r103]) goto L7;
        int r105 = 0;
    L10:
        if (r105 != 0) goto L11;
        r103 = r103 + 1;
        goto L3
    L11:
        return r105;
    L7:
        if (r104 == false) goto L9;
        r105 = 1;
        goto L10
    L9:
        r105 = -1;
        goto L10
    L14:
        return r100.length - r101.length;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(boolean[] r100, boolean[] r101) {
        return compare2(r100, r101);
    }
}
