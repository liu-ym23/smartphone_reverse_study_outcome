package g26;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f479727b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f479726a, r101.f479726a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f479727b, r101.f479727b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f479726a.hashCode() * 31) + this.f479727b.hashCode();
    }

    public final String toString() {
        return "LynxCommonData(containerID=" + this.f479726a + ", protocolVersion=" + this.f479727b + ')';
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerID");
        Intrinsics.checkNotNullParameter("1.0", "protocolVersion");
        this.f479726a = r100;
        this.f479727b = "1.0";
    }
}
