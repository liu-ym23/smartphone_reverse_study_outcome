package sz2;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f543912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f543914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f543915d;

    public final jz2.b a() {
        return new jz2.b(MapsKt.mapOf(new Pair[]{TuplesKt.to("container_load_error_code", Integer.valueOf(this.f543912a)), TuplesKt.to("container_load_error_msg", this.f543913b)}));
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f543912a == r101.f543912a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f543913b, r101.f543913b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f543914c, r101.f543914c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f543915d, r101.f543915d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f543912a * 31) + this.f543913b.hashCode()) * 31) + this.f543914c.hashCode()) * 31) + this.f543915d.hashCode();
    }

    public final String toString() {
        return "ContainerError(errCode=" + this.f543912a + ", errorMsg=" + this.f543913b + ", virtualAid=" + this.f543914c + ", biz=" + this.f543915d + ')';
    }

    public b(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "virtualAid");
        Intrinsics.checkNotNullParameter(r103, "biz");
        this.f543912a = r100;
        this.f543913b = r101;
        this.f543914c = r102;
        this.f543915d = r103;
    }
}
