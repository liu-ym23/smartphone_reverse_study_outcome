package mpa;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f514761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Object, Unit> f514763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f514764d;

    public final int hashCode() {
        long r100 = this.f514761a;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f514762b.hashCode()) * 31) + System.identityHashCode(this.f514763c)) * 31) + this.f514764d;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof m) == false) goto L13;
        m r101 = (m) r100;
        if (this.f514761a != r101.f514761a) goto L13;
        if (Intrinsics.areEqual(this.f514762b, r101.f514762b) == false) goto L13;
        if (this.f514763c != r101.f514763c) goto L13;
        if (this.f514764d != r101.f514764d) goto L13;
        return true;
    L13:
        return false;
    }

    public m(long r100, String r101, Function1<Object, Unit> r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f514761a = r100;
        this.f514762b = r101;
        this.f514763c = r102;
        this.f514764d = r103;
    }
}
