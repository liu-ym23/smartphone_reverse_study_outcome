package kd2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f502711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f502713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f502714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f502715e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.f502711a == r101.f502711a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f502712b, r101.f502712b) == true) goto L10;
        return false;
    L10:
        if (this.f502713c == r101.f502713c) goto L12;
        return false;
    L12:
        if (this.f502714d == r101.f502714d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f502715e, r101.f502715e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        long r100 = this.f502711a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f502712b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        boolean r106 = this.f502713c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L9;
        r108 = 1;
    L9:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f502714d;
        if (r110 == true) goto L13;
        r107 = r110;
    L13:
        int r111 = (r109 + r107) * 31;
        String r112 = this.f502715e;
        if (r112 == null) goto L17;
        r103 = r112.hashCode();
    L17:
        return r111 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "RecognitionParams(source=" + this.f502711a + ", appId=" + this.f502712b + ", isRetry=" + this.f502713c + ", anchorIsSinger=" + this.f502714d + ", userId=" + this.f502715e + ")";
    }

    public a(String r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "userId");
        this.f502711a = 0;
        this.f502712b = r100;
        this.f502713c = r101;
        this.f502714d = r102;
        this.f502715e = r103;
    }

    public /* synthetic */ a(boolean r100, boolean r101, String r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 8) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 16) == 0) goto L11;
        r102 = "";
    L11:
        this(null, r100, r101, r102);
    }
}
