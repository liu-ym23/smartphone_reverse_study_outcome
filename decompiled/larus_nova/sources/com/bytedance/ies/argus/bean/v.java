package com.bytedance.ies.argus.bean;

/* JADX INFO: loaded from: classes19.dex */
public final class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f246054c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EncryptAlgorithm f246055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DigestAlgorithm f246056b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f246055a == r101.f246055a) goto L12;
        return false;
    L12:
        if (this.f246056b == r101.f246056b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        EncryptAlgorithm r100 = this.f246055a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        DigestAlgorithm r104 = this.f246056b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SignAlgorithm(encryptAlgorithm=" + this.f246055a + ", digestAlgorithm=" + this.f246056b + ')';
    }

    public v(EncryptAlgorithm r100, DigestAlgorithm r101) {
        this.f246055a = r100;
        this.f246056b = r101;
    }
}
