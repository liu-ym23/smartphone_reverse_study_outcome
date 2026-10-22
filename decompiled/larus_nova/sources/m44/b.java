package m44;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f511839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f511840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f511841c;

    public final int hashCode() {
        String r100 = this.f511840b;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = (r101 + 0) * 31;
        String r103 = this.f511841c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((((r102 + r104) * 31) + 0) * 31) + this.f511839a;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public b() {
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        if (r101.f511839a > 0) goto L10;
        if (TextUtils.isEmpty(r101.f511840b) == false) goto L10;
        return false;
    L10:
        if (r101.f511839a == this.f511839a) goto L12;
        return false;
    L12:
        if (TextUtils.equals(r101.f511840b, this.f511840b) == true) goto L14;
        return false;
    L14:
        if (TextUtils.equals(r101.f511841c, this.f511841c) == false) goto L21;
        return true;
    L21:
        return false;
    }
}
