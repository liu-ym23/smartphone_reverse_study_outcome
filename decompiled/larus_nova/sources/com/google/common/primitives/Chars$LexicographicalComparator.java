package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final enum Chars$LexicographicalComparator extends Enum<Chars$LexicographicalComparator> implements Comparator<char[]> {
    public static final Chars$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Chars$LexicographicalComparator[] f275633a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "Chars.lexicographicalComparator()";
    }

    static {
        Chars$LexicographicalComparator r100 = new Chars$LexicographicalComparator();
        INSTANCE = r100;
        f275633a = new Chars$LexicographicalComparator[]{r100};
    }

    public Chars$LexicographicalComparator() {
        super("INSTANCE", 0);
    }

    public static Chars$LexicographicalComparator[] values() {
        return (Chars$LexicographicalComparator[]) f275633a.clone();
    }

    public static Chars$LexicographicalComparator valueOf(String r100) {
        return (Chars$LexicographicalComparator) r27.a.a(Chars$LexicographicalComparator.class, r100);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(char[] r100, char[] r101) {
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
    public /* bridge */ /* synthetic */ int compare(char[] r100, char[] r101) {
        return compare2(r100, r101);
    }
}
