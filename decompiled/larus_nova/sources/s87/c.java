package s87;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f540975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f540976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f540977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Object, Unit> f540978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f540979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f540980f;

    public final int hashCode() {
        long r100 = this.f540975a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f540976b;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f540977c.hashCode()) * 31) + System.identityHashCode(this.f540978d)) * 31;
        if (this.f540979e == false) goto L5;
        int r104 = 1231;
    L7:
        return ((r103 + r104) * 31) + this.f540980f;
    L5:
        r104 = 1237;
        goto L7
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == false) goto L17;
        c r101 = (c) r100;
        if (this.f540975a != r101.f540975a) goto L17;
        if (this.f540976b != r101.f540976b) goto L17;
        if (Intrinsics.areEqual(this.f540977c, r101.f540977c) == false) goto L17;
        if (this.f540978d != r101.f540978d) goto L17;
        if (this.f540979e != r101.f540979e) goto L17;
        if (this.f540980f != r101.f540980f) goto L17;
        return true;
    L17:
        return false;
    }

    public c(long r100, long r101, String r102, Function1<Object, Unit> r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f540975a = r100;
        this.f540976b = r101;
        this.f540977c = r102;
        this.f540978d = r103;
        this.f540979e = r104;
        this.f540980f = r105;
    }
}
