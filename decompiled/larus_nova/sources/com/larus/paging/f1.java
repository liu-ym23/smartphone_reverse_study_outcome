package com.larus.paging;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f363841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f363842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f363843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f363844d;

    public static final class a extends f1 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f363845e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f363846f;

        public final String toString() {
            return StringsKt.trimMargin$default("ViewportHint.Access(\n            |    pageOffset=" + this.f363845e + ",\n            |    indexInPage=" + this.f363846f + ",\n            |    presentedItemsBefore=" + this.f363841a + ",\n            |    presentedItemsAfter=" + this.f363842b + ",\n            |    originalPageOffsetFirst=" + this.f363843c + ",\n            |    originalPageOffsetLast=" + this.f363844d + ",\n            |)", null, 1, null);
        }

        @Override // com.larus.paging.f1
        public final int hashCode() {
            return (super.hashCode() + this.f363845e) + this.f363846f;
        }

        @Override // com.larus.paging.f1
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f363845e == r101.f363845e) goto L11;
        L21:
            return false;
        L11:
            if (this.f363846f != r101.f363846f) goto L21;
            if (this.f363841a != r101.f363841a) goto L21;
            if (this.f363842b != r101.f363842b) goto L21;
            if (this.f363843c != r101.f363843c) goto L21;
            if (this.f363844d != r101.f363844d) goto L21;
            return true;
        }

        public a(int r100, int r101, int r102, int r103, int r104, int r105) {
            super(r102, r103, r104, r105);
            this.f363845e = r100;
            this.f363846f = r101;
        }
    }

    public static final class b extends f1 {
        public final String toString() {
            return StringsKt.trimMargin$default("ViewportHint.Initial(\n            |    presentedItemsBefore=" + this.f363841a + ",\n            |    presentedItemsAfter=" + this.f363842b + ",\n            |    originalPageOffsetFirst=" + this.f363843c + ",\n            |    originalPageOffsetLast=" + this.f363844d + ",\n            |)", null, 1, null);
        }

        public b(int r100, int r101, int r102, int r103) {
            super(r100, r101, r102, r103);
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363847a = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f363847a = r100;
        }
    }

    public int hashCode() {
        return ((this.f363841a + this.f363842b) + this.f363843c) + this.f363844d;
    }

    public final int a(LoadType r100) {
        Intrinsics.checkNotNullParameter(r100, "loadType");
        int r101 = c.f363847a[r100.ordinal()];
        if (r101 == 1) goto L14;
        if (r101 == 2) goto L12;
        if (r101 != 3) goto L10;
        return this.f363842b;
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        return this.f363841a;
    L14:
        throw new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r101 = (f1) r100;
        if (this.f363841a == r101.f363841a) goto L11;
    L17:
        return false;
    L11:
        if (this.f363842b != r101.f363842b) goto L17;
        if (this.f363843c != r101.f363843c) goto L17;
        if (this.f363844d != r101.f363844d) goto L17;
        return true;
    }

    public f1(int r100, int r101, int r102, int r103) {
        this.f363841a = r100;
        this.f363842b = r101;
        this.f363843c = r102;
        this.f363844d = r103;
    }
}
