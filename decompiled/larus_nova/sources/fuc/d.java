package fuc;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.Instant;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes5.dex */
@Serializable(with = iuc.b.class)
public final class d implements Comparable<d> {
    public static final a Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f478930b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f478931c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Instant f478932a;

    public static final class a {
        public a() {
        }

        public final juc.d<d> serializer() {
            return iuc.b.f495906a;
        }

        public static d a(long r100, long r101) {
            return new d(Instant.ofEpochSecond(r100, r101));
        L4:
            e = move-exception;
            if ((e instanceof ArithmeticException) == true) goto L12;
            if ((e instanceof DateTimeException) == true) goto L12;
            throw e;
        L12:
            if (r100 <= 0) goto L14;
            d r102 = d.f478931c;
        L16:
            return r102;
        L14:
            r102 = d.f478930b;
            goto L16
        }
    }

    static {
        Companion = new a();
        new d(Instant.ofEpochSecond(-3217862419201L, 999999999));
        new d(Instant.ofEpochSecond(3093527980800L, 0));
        f478930b = new d(Instant.MIN);
        f478931c = new d(Instant.MAX);
    }

    public final long a() {
        return this.f478932a.toEpochMilli();
    L5:
        if (this.f478932a.isAfter(Instant.EPOCH) == false) goto L7;
        return Long.MAX_VALUE;
    L7:
        return Long.MIN_VALUE;
    }

    public final int hashCode() {
        return this.f478932a.hashCode();
    }

    public final String toString() {
        return this.f478932a.toString();
    }

    public d(Instant r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f478932a = r100;
    }

    @Override // java.lang.Comparable
    public final int compareTo(d r100) {
        d r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return this.f478932a.compareTo2(r101.f478932a);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
    L9:
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(this.f478932a, ((d) r100).f478932a) == false) goto L8;
        goto L8
    }
}
