package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495897c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f495895a, r101.f495895a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495896b, r101.f495896b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495897c, r101.f495897c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495895a.hashCode() * 31) + this.f495896b.hashCode()) * 31;
        String r101 = this.f495897c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRecordingWebConfig(path=" + this.f495895a + ", appBrand=" + this.f495896b + ", appVersion=" + this.f495897c + ')';
    }

    public x(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "appBrand");
        this.f495895a = r100;
        this.f495896b = r101;
        this.f495897c = r102;
    }
}
