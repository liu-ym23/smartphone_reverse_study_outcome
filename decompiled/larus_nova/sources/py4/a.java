package py4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f531025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f531027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f531028d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f531025a, r101.f531025a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f531026b, r101.f531026b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f531027c, r101.f531027c) == true) goto L18;
        return false;
    L18:
        if (this.f531028d == r101.f531028d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f531025a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f531026b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f531027c.hashCode()) * 31;
        if (this.f531028d == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "EventHandlerParams(token=" + this.f531025a + ", module=" + this.f531026b + ", eventType=" + this.f531027c + ", outer=" + this.f531028d + ')';
    }

    public a(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "eventType");
        this.f531025a = r100;
        this.f531026b = r101;
        this.f531027c = r102;
        this.f531028d = r103;
    }
}
