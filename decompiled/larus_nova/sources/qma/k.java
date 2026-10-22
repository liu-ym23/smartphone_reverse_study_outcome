package qma;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f533971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f533972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f533973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f533974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c> f533975e;

    public k() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f533971a, r101.f533971a) == true) goto L12;
        return false;
    L12:
        if (this.f533972b == r101.f533972b) goto L15;
        return false;
    L15:
        if (this.f533973c == r101.f533973c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f533974d, r101.f533974d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f533975e, r101.f533975e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f533971a.hashCode() * 31) + this.f533972b) * 31;
        long r101 = this.f533973c;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f533974d.hashCode()) * 31) + this.f533975e.hashCode();
    }

    public final String toString() {
        return "TextEffectSpec(id=" + this.f533971a + ", version=" + this.f533972b + ", durationMs=" + this.f533973c + ", loop=" + this.f533974d + ", stages=" + this.f533975e + ')';
    }

    public k(String r100, long r101, g.b r102, List r103, int r104) {
        if ((r104 & 2) == 0) goto L5;
        int r105 = 1;
    L6:
        g r106 = r102;
        if ((r104 & 8) == 0) goto L9;
        r106 = g.c.f533960a;
    L9:
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r106, "loop");
        Intrinsics.checkNotNullParameter(r103, "stages");
        this.f533971a = r100;
        this.f533972b = r105;
        this.f533973c = r101;
        this.f533974d = r106;
        this.f533975e = r103;
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
