package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final enum SignedBytes$LexicographicalComparator extends Enum<SignedBytes$LexicographicalComparator> implements Comparator<byte[]> {
    public static final SignedBytes$LexicographicalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SignedBytes$LexicographicalComparator[] f275652a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "SignedBytes.lexicographicalComparator()";
    }

    static {
        SignedBytes$LexicographicalComparator r100 = new SignedBytes$LexicographicalComparator();
        INSTANCE = r100;
        f275652a = new SignedBytes$LexicographicalComparator[]{r100};
    }

    public SignedBytes$LexicographicalComparator() {
        super("INSTANCE", 0);
    }

    public static SignedBytes$LexicographicalComparator[] values() {
        return (SignedBytes$LexicographicalComparator[]) f275652a.clone();
    }

    public static SignedBytes$LexicographicalComparator valueOf(String r100) {
        return (SignedBytes$LexicographicalComparator) r27.a.a(SignedBytes$LexicographicalComparator.class, r100);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(byte[] r100, byte[] r101) {
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
    public /* bridge */ /* synthetic */ int compare(byte[] r100, byte[] r101) {
        return compare2(r100, r101);
    }
}
