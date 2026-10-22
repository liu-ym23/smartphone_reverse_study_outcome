package m8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f512539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f512541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f512542d;

    public c() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f512539a, r101.f512539a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512540b, r101.f512540b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f512541c, r101.f512541c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512542d, r101.f512542d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f512539a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f512540b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.f512541c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f512542d;
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
        return "InternalDeviceChallengeData(challengeType=" + this.f512539a + ", nonce=" + this.f512540b + ", certInfo=" + this.f512541c + ", tokenChallengeCode=" + this.f512542d + ')';
    }

    public c(Integer r100, String r101, a r102, String r103) {
        this.f512539a = r100;
        this.f512540b = r101;
        this.f512541c = r102;
        this.f512542d = r103;
    }
}
