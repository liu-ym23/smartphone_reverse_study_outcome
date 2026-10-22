package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final enum Floats$LexicographicalComparator extends Enum<Floats$LexicographicalComparator> implements Comparator<float[]> {
    public static final Floats$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Floats$LexicographicalComparator[] f275636a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "Floats.lexicographicalComparator()";
    }

    static {
        Floats$LexicographicalComparator r100 = new Floats$LexicographicalComparator();
        INSTANCE = r100;
        f275636a = new Floats$LexicographicalComparator[]{r100};
    }

    public Floats$LexicographicalComparator() {
        super("INSTANCE", 0);
    }

    public static Floats$LexicographicalComparator[] values() {
        return (Floats$LexicographicalComparator[]) f275636a.clone();
    }

    public static Floats$LexicographicalComparator valueOf(String r100) {
        return (Floats$LexicographicalComparator) r27.a.a(Floats$LexicographicalComparator.class, r100);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(float[] r100, float[] r101) {
        int r102 = Math.min(r100.length, r101.length);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        int r104 = Float.compare(r100[r103], r101[r103]);
        if (r104 != 0) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return r100.length - r101.length;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(float[] r100, float[] r101) {
        return compare2(r100, r101);
    }
}
