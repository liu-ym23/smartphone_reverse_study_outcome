package ot1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f526628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f526629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f526630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f526631f;

    /* JADX INFO: renamed from: ot1.a$a, reason: collision with other inner class name */
    public static final class C7110a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f526626a, r101.f526626a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f526627b, r101.f526627b) == true) goto L10;
        return false;
    L10:
        if (this.f526628c == r101.f526628c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f526629d, r101.f526629d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f526630e, r101.f526630e) == true) goto L16;
        return false;
    L16:
        if (this.f526631f == r101.f526631f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f526626a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f526627b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f526628c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f526629d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f526630e;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return ((r111 + r101) * 31) + this.f526631f;
    L13:
        r110 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShareFansParams(anchorId=" + this.f526626a + ", secAnchorId=" + this.f526627b + ", roomId=" + this.f526628c + ", enterFromMerge=" + this.f526629d + ", enterMethod=" + this.f526630e + ", actionType=" + this.f526631f + ")";
    }

    public a() {
        this("0", "", 0, "", "", 0);
    }

    public a(String r100, String r101, long r102, String r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        Intrinsics.checkNotNullParameter(r101, "secAnchorId");
        Intrinsics.checkNotNullParameter(r103, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r104, "enterMethod");
        this.f526626a = r100;
        this.f526627b = r101;
        this.f526628c = r102;
        this.f526629d = r103;
        this.f526630e = r104;
        this.f526631f = r105;
    }
}
