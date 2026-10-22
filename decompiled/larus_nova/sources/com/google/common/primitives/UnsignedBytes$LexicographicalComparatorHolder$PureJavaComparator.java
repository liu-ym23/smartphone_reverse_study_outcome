package com.google.common.primitives;

import java.util.Comparator;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
final enum UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator extends Enum<UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator> implements Comparator<byte[]> {
    public static final UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[] f275653a = null;

    @Override // java.lang.Enum
    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
    }

    static {
        UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator r100 = new UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator();
        INSTANCE = r100;
        f275653a = new UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[]{r100};
    }

    public UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator() {
        super("INSTANCE", 0);
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[] values() {
        return (UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator[]) f275653a.clone();
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator valueOf(String r100) {
        return (UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator) r27.a.a(UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator.class, r100);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(byte[] r100, byte[] r101) {
        int r102 = Math.min(r100.length, r101.length);
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        byte r104 = r100[r103];
        byte r105 = r101[r103];
        int r106 = (r104 & UByte.MAX_VALUE) - (r105 & UByte.MAX_VALUE);
        if (r106 != 0) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r106;
    L9:
        return r100.length - r101.length;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(byte[] r100, byte[] r101) {
        return compare2(r100, r101);
    }
}
