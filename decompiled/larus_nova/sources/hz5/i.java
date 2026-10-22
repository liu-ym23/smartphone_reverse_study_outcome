package hz5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f487692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f487694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f487695d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f487692a, r101.f487692a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f487693b, r101.f487693b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f487694c, r101.f487694c) == true) goto L12;
        return false;
    L12:
        if (this.f487695d == r101.f487695d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    @Override // hz5.f
    public final String getTag() {
        return "JsbEvent";
    }

    public final int hashCode() {
        String r100 = this.f487692a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f487693b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f487694c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f487695d;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "JsbEvent(url=" + this.f487692a + ", moduleName=" + this.f487693b + ", methodName=" + this.f487694c + ", timestamp=" + this.f487695d + ")";
    }

    public i() {
        long r100 = System.currentTimeMillis();
        this.f487692a = "";
        this.f487693b = "";
        this.f487694c = "";
        this.f487695d = r100;
    }
}
