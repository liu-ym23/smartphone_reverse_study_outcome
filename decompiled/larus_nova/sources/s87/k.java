package s87;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f540989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f540990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Object, Unit> f540991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f540992d;

    public final int hashCode() {
        long r100 = this.f540989a;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f540990b.hashCode()) * 31) + System.identityHashCode(this.f540991c)) * 31) + this.f540992d;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof k) == false) goto L13;
        k r101 = (k) r100;
        if (this.f540989a != r101.f540989a) goto L13;
        if (Intrinsics.areEqual(this.f540990b, r101.f540990b) == false) goto L13;
        if (this.f540991c != r101.f540991c) goto L13;
        if (this.f540992d != r101.f540992d) goto L13;
        return true;
    L13:
        return false;
    }

    public k(long r100, String r101, Function1<Object, Unit> r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f540989a = r100;
        this.f540990b = r101;
        this.f540991c = r102;
        this.f540992d = r103;
    }
}
