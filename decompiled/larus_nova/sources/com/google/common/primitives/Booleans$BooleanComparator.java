package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final enum Booleans$BooleanComparator extends Enum<Booleans$BooleanComparator> implements Comparator<Boolean> {
    public static final Booleans$BooleanComparator FALSE_FIRST = null;
    public static final Booleans$BooleanComparator TRUE_FIRST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Booleans$BooleanComparator[] f275631a = null;
    private final String toString;
    private final int trueValue;

    static {
        Booleans$BooleanComparator r100 = new Booleans$BooleanComparator("TRUE_FIRST", 0, 1, "Booleans.trueFirst()");
        TRUE_FIRST = r100;
        Booleans$BooleanComparator r101 = new Booleans$BooleanComparator("FALSE_FIRST", 1, -1, "Booleans.falseFirst()");
        FALSE_FIRST = r101;
        f275631a = new Booleans$BooleanComparator[]{r100, r101};
    }

    public static Booleans$BooleanComparator[] values() {
        return (Booleans$BooleanComparator[]) f275631a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.toString;
    }

    public static Booleans$BooleanComparator valueOf(String r100) {
        return (Booleans$BooleanComparator) r27.a.a(Booleans$BooleanComparator.class, r100);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Boolean r100, Boolean r101) {
        int r102 = 0;
        if (r100.booleanValue() == false) goto L5;
        int r103 = this.trueValue;
    L7:
        if (r101.booleanValue() == false) goto L10;
        r102 = this.trueValue;
    L10:
        return r102 - r103;
    L5:
        r103 = 0;
        goto L7
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Boolean r100, Boolean r101) {
        return compare2(r100, r101);
    }

    public Booleans$BooleanComparator(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.trueValue = r102;
        this.toString = r103;
    }
}
