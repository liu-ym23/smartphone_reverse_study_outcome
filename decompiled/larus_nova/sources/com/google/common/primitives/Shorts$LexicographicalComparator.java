package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final enum Shorts$LexicographicalComparator extends Enum<Shorts$LexicographicalComparator> implements Comparator<short[]> {
    public static final Shorts$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Shorts$LexicographicalComparator[] f275651a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "Shorts.lexicographicalComparator()";
    }

    static {
        Shorts$LexicographicalComparator r100 = new Shorts$LexicographicalComparator();
        INSTANCE = r100;
        f275651a = new Shorts$LexicographicalComparator[]{r100};
    }

    public Shorts$LexicographicalComparator() {
        super("INSTANCE", 0);
    }

    public static Shorts$LexicographicalComparator[] values() {
        return (Shorts$LexicographicalComparator[]) f275651a.clone();
    }

    public static Shorts$LexicographicalComparator valueOf(String r100) {
        return (Shorts$LexicographicalComparator) r27.a.a(Shorts$LexicographicalComparator.class, r100);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(short[] r100, short[] r101) {
        int r102 = Math.min(r100.length, r101.length);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        int r104 = r100[r103] - r101[r103];
        if (r104 != 0) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return r100.length - r101.length;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(short[] r100, short[] r101) {
        return compare2(r100, r101);
    }
}
