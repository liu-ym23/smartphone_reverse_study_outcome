package og3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f523186b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f523185a, r101.f523185a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f523186b, r101.f523186b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f523185a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f523186b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BtmInfo(pageBtm=" + this.f523185a + ", btmSource=" + this.f523186b + ")";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter("a1.b8094", "pageBtm");
        this.f523185a = "a1.b8094";
        this.f523186b = r100;
    }
}
