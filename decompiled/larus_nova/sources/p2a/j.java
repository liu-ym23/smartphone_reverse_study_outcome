package p2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j<T> extends m<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f527473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f527475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f527476e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f527473b == r101.f527473b) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527474c, r101.f527474c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f527475d, r101.f527475d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f527476e, r101.f527476e) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f527473b;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f527474c;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f527475d;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        T r109 = this.f527476e;
        if (r109 == null) goto L15;
        r103 = r109.hashCode();
    L15:
        return r108 + r103;
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "UgcVoiceFail(code=" + this.f527473b + ", message=" + this.f527474c + ", localizedMessage=" + this.f527475d + ", value=" + this.f527476e + ')';
    }

    public j(long r100, String r101, String r102, T r103) {
        super(r103);
        this.f527473b = r100;
        this.f527474c = r101;
        this.f527475d = r102;
        this.f527476e = r103;
    }
}
