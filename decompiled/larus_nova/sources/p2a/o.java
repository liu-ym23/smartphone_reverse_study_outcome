package p2a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class o<T> extends m<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f527486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f527488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f527489e;

    public o() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f527486b, r101.f527486b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527487c, r101.f527487c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f527488d, r101.f527488d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f527489e, r101.f527489e) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f527486b;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f527487c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f527488d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f527489e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UgcVoiceSuccess(value=" + this.f527486b + ", payload=" + this.f527487c + ", message=" + this.f527488d + ", code=" + this.f527489e + ')';
    }

    public o(T r100, String r101, String r102, Long r103) {
        super(r100);
        this.f527486b = r100;
        this.f527487c = r101;
        this.f527488d = r102;
        this.f527489e = r103;
    }
}
