package com.google.common.primitives;

import java.util.Comparator;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedInts {

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<int[]> {
        public static final LexicographicalComparator INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f275655a = null;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        static {
            LexicographicalComparator r100 = new LexicographicalComparator();
            INSTANCE = r100;
            f275655a = new LexicographicalComparator[]{r100};
        }

        public LexicographicalComparator() {
            super("INSTANCE", 0);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f275655a.clone();
        }

        public static LexicographicalComparator valueOf(String r100) {
            return (LexicographicalComparator) r27.a.a(LexicographicalComparator.class, r100);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(int[] r100, int[] r101) {
            int r102 = Math.min(r100.length, r101.length);
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            int r104 = r100[r103];
            int r105 = r101[r103];
            if (r104 != r105) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            int r106 = r104 ^ Integer.MIN_VALUE;
            int r107 = Integer.MIN_VALUE ^ r105;
            if (r106 >= r107) goto L9;
            return -1;
        L9:
            if (r106 <= r107) goto L18;
            return 1;
        L18:
            return 0;
        L14:
            return r100.length - r101.length;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(int[] r100, int[] r101) {
            return compare2(r100, r101);
        }
    }

    public static long a(int r100) {
        return ((long) r100) & BodyPartID.bodyIdMax;
    }
}
