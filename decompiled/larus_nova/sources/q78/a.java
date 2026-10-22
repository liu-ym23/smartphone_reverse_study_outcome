package q78;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f531974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f531976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f531977d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f531974a == r101.f531974a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f531975b, r101.f531975b) == true) goto L15;
        return false;
    L15:
        if (this.f531976c == r101.f531976c) goto L18;
        return false;
    L18:
        if (this.f531977d == r101.f531977d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f531974a * 31) + this.f531975b.hashCode()) * 31) + this.f531976c) * 31;
        if (this.f531977d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AudioDeviceInfoWrapper(id=" + this.f531974a + ", productName=" + this.f531975b + ", type=" + this.f531976c + ", isSource=" + this.f531977d + ')';
    }

    public final int getType() {
        return this.f531976c;
    }

    public a(int r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "productName");
        this.f531974a = r100;
        this.f531975b = r101;
        this.f531976c = r102;
        this.f531977d = r103;
    }
}
