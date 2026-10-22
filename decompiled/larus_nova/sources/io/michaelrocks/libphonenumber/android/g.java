package io.michaelrocks.libphonenumber.android;

import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f492247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f492248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Phonenumber$PhoneNumber f492249c;

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f492247a), this.f492248b, this.f492249c});
    }

    public final String toString() {
        return "PhoneNumberMatch [" + this.f492247a + "," + (this.f492247a + this.f492248b.length()) + ") " + this.f492248b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f492248b.equals(r101.f492248b) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.f492247a != r101.f492247a) goto L15;
        if (this.f492249c.equals(r101.f492249c) == false) goto L15;
        return true;
    }

    public g(int r100, String r101, Phonenumber$PhoneNumber r102) {
        if (r100 < 0) goto L10;
        if (r101 == null) goto L8;
        this.f492247a = r100;
        this.f492248b = r101;
        this.f492249c = r102;
        return;
    L8:
        throw null;
    L10:
        throw new IllegalArgumentException("Start index must be >= 0.");
    }
}
