package com.google.common.collect;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class SortedLists {

    public static abstract enum KeyAbsentBehavior extends Enum<KeyAbsentBehavior> {
        public static final KeyAbsentBehavior INVERTED_INSERTION_INDEX = null;
        public static final KeyAbsentBehavior NEXT_HIGHER = null;
        public static final KeyAbsentBehavior NEXT_LOWER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KeyAbsentBehavior[] f275325a = null;

        public KeyAbsentBehavior() {
            throw null;
        }

        public abstract int resultIndex(int r100);

        static {
            final String r100 = "NEXT_LOWER";
            final int r101 = 0;
            KeyAbsentBehavior r102 = new AnonymousClass1(r100, r101);
            NEXT_LOWER = r102;
            final String r103 = "NEXT_HIGHER";
            final int r104 = 1;
            KeyAbsentBehavior r105 = new AnonymousClass2(r103, r104);
            NEXT_HIGHER = r105;
            final String r106 = "INVERTED_INSERTION_INDEX";
            final int r107 = 2;
            KeyAbsentBehavior r108 = new AnonymousClass3(r106, r107);
            INVERTED_INSERTION_INDEX = r108;
            f275325a = new KeyAbsentBehavior[]{r102, r105, r108};
        }

        public static KeyAbsentBehavior[] values() {
            return (KeyAbsentBehavior[]) f275325a.clone();
        }

        public static KeyAbsentBehavior valueOf(String r100) {
            return (KeyAbsentBehavior) r27.a.a(KeyAbsentBehavior.class, r100);
        }

        public KeyAbsentBehavior(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static abstract enum KeyPresentBehavior extends Enum<KeyPresentBehavior> {
        public static final KeyPresentBehavior ANY_PRESENT = null;
        public static final KeyPresentBehavior FIRST_AFTER = null;
        public static final KeyPresentBehavior FIRST_PRESENT = null;
        public static final KeyPresentBehavior LAST_BEFORE = null;
        public static final KeyPresentBehavior LAST_PRESENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KeyPresentBehavior[] f275326a = null;

        public KeyPresentBehavior() {
            throw null;
        }

        public abstract <E> int resultIndex(Comparator<? super E> r100, @ParametricNullness E r101, List<? extends E> r102, int r103);

        static {
            final String r100 = "ANY_PRESENT";
            final int r101 = 0;
            KeyPresentBehavior r102 = new AnonymousClass1(r100, r101);
            ANY_PRESENT = r102;
            final String r103 = "LAST_PRESENT";
            final int r104 = 1;
            KeyPresentBehavior r105 = new AnonymousClass2(r103, r104);
            LAST_PRESENT = r105;
            final String r106 = "FIRST_PRESENT";
            final int r107 = 2;
            KeyPresentBehavior r108 = new AnonymousClass3(r106, r107);
            FIRST_PRESENT = r108;
            final String r109 = "FIRST_AFTER";
            final int r110 = 3;
            KeyPresentBehavior r111 = new AnonymousClass4(r109, r110);
            FIRST_AFTER = r111;
            final String r112 = "LAST_BEFORE";
            final int r113 = 4;
            KeyPresentBehavior r114 = new AnonymousClass5(r112, r113);
            LAST_BEFORE = r114;
            f275326a = new KeyPresentBehavior[]{r102, r105, r108, r111, r114};
        }

        public static KeyPresentBehavior[] values() {
            return (KeyPresentBehavior[]) f275326a.clone();
        }

        public static KeyPresentBehavior valueOf(String r100) {
            return (KeyPresentBehavior) r27.a.a(KeyPresentBehavior.class, r100);
        }

        public KeyPresentBehavior(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public static int a(ImmutableList r100, com.google.common.base.g r101, Comparable r102, KeyPresentBehavior r103, KeyAbsentBehavior r110) {
        r102.getClass();
        return b(r100, r101, r102, Ordering.natural(), r103, r110);
    }

    public static int b(ImmutableList r100, com.google.common.base.g r101, @ParametricNullness Object r102, Ordering r103, KeyPresentBehavior r104, KeyAbsentBehavior r105) {
        if ((r100 instanceof RandomAccess) == false) goto L5;
        List r106 = new Lists.TransformingRandomAccessList(r100, r101);
    L6:
        r103.getClass();
        r104.getClass();
        r105.getClass();
        if ((r106 instanceof RandomAccess) == true) goto L9;
        r106 = Lists.b(r106);
    L9:
        int r107 = r106.size() - 1;
        int r108 = 0;
    L10:
        if (r108 > r107) goto L18;
        int r109 = (r108 + r107) >>> 1;
        int r110 = r103.compare(r102, ListProtector.get(r106, r109));
        if (r110 < 0) goto L13;
        if (r110 <= 0) goto L26;
        r108 = r109 + 1;
        goto L10
    L26:
        return r108 + r104.resultIndex(r103, r102, r106.subList(r108, r107 + 1), r109 - r108);
    L13:
        r107 = r109 - 1;
        goto L10
    L18:
        return r105.resultIndex(r108);
    L5:
        r106 = new Lists.TransformingSequentialList(r100, r101);
        goto L6
    }
}
