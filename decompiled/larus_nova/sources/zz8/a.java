package zz8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f574098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f574099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f574100c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f574098a, r101.f574098a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f574099b, r101.f574099b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f574100c, r101.f574100c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f574098a.hashCode() * 31) + this.f574099b.hashCode()) * 31) + this.f574100c.hashCode();
    }

    public final String toString() {
        return "BizAuthRequestConfig(clientId=" + this.f574098a + ", scope=" + this.f574099b + ", clientType=" + this.f574100c + ')';
    }

    public a() {
        Intrinsics.checkNotNullParameter("cli_a872ee858eae100e", "clientId");
        Intrinsics.checkNotNullParameter("internal", "scope");
        Intrinsics.checkNotNullParameter("Lark", "clientType");
        this.f574098a = "cli_a872ee858eae100e";
        this.f574099b = "internal";
        this.f574100c = "Lark";
    }
}
