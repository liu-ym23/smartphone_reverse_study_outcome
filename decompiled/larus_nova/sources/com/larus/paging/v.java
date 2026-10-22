package com.larus.paging;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f363924d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f363925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f363926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f363927c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f363928a = null;

        static {
            int[] r100 = new int[LoadType.values().length];
            r100[LoadType.APPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LoadType.REFRESH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f363928a = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f363925a, r101.f363925a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f363926b, r101.f363926b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f363927c, r101.f363927c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f363925a.hashCode() * 31) + this.f363926b.hashCode()) * 31) + this.f363927c.hashCode();
    }

    public final String toString() {
        return "LoadStates(refresh=" + this.f363925a + ", prepend=" + this.f363926b + ", append=" + this.f363927c + ')';
    }

    static {
        u.c r100 = u.c.f363923c;
        f363924d = new v(r100, r100, r100);
    }

    public final v b(LoadType r100) {
        u.c r101 = u.c.f363923c;
        Intrinsics.checkNotNullParameter(r100, "loadType");
        Intrinsics.checkNotNullParameter(r101, "newState");
        int r102 = b.f363928a[r100.ordinal()];
        if (r102 == 1) goto L12;
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L9;
        return a(this, r101, null, null, 6);
    L9:
        throw new NoWhenBranchMatchedException();
    L14:
        return a(this, null, r101, null, 5);
    L12:
        return a(this, null, null, r101, 3);
    }

    public v(u r100, u r101, u r102) {
        Intrinsics.checkNotNullParameter(r100, "refresh");
        Intrinsics.checkNotNullParameter(r101, "prepend");
        Intrinsics.checkNotNullParameter(r102, "append");
        this.f363925a = r100;
        this.f363926b = r101;
        this.f363927c = r102;
    }

    public static v a(v r100, u.c r101, u.c r102, u.c r103, int r104) {
        u r105 = r101;
        if ((r104 & 1) == 0) goto L5;
        r105 = r100.f363925a;
    L5:
        u r106 = r102;
        if ((r104 & 2) == 0) goto L8;
        r106 = r100.f363926b;
    L8:
        u r107 = r103;
        if ((r104 & 4) == 0) goto L11;
        r107 = r100.f363927c;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "refresh");
        Intrinsics.checkNotNullParameter(r106, "prepend");
        Intrinsics.checkNotNullParameter(r107, "append");
        return new v(r105, r106, r107);
    }
}
