package fd2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f476483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f476484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f476485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f476486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f476487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f476488f;

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        long r100 = this.f476483a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f476484b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f476485c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.f476486d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.f476487e) * 31;
        String r112 = this.f476488f;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return r111 + r103;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "MvServiceParam(songId=" + this.f476483a + ", songName=" + this.f476484b + ", orderUid=" + this.f476485c + ", songOffset=" + this.f476486d + ", fetchType=" + this.f476487e + ", url=" + this.f476488f + ")";
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof d0) == false) goto L12;
        d0 r101 = (d0) r100;
        if (r101.f476483a == this.f476483a) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(this.f476485c, r101.f476485c) == false) goto L9;
        return true;
    L12:
        return super.equals(r100);
    }

    public d0(long r100, String r101, String r102, Long r103, int r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r102, "orderUid");
        this.f476483a = r100;
        this.f476484b = r101;
        this.f476485c = r102;
        this.f476486d = r103;
        this.f476487e = r104;
        this.f476488f = null;
    }
}
