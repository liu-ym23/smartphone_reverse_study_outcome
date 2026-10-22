package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class g5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f387291c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f387292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387293b;

    public static final class a {
        public static g5 a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            return new g5(i0.b(System.currentTimeMillis()), r100);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g5) == true) goto L8;
        return false;
    L8:
        g5 r101 = (g5) r100;
        if (this.f387292a == r101.f387292a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387293b, r101.f387293b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f387292a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f387293b.hashCode();
    }

    public final String toString() {
        return "LabelingObserveRequest(earliestTimeMillis=" + this.f387292a + ", reason=" + this.f387293b + ')';
    }

    public static h5 a(g5 r100) {
        long r101 = System.currentTimeMillis();
        r100.getClass();
        long r102 = r100.f387292a;
        return new h5(r102, RangesKt.coerceAtLeast(r101, r102));
    }

    public g5(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f387292a = r100;
        this.f387293b = r101;
    }
}
