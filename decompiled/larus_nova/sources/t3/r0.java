package t3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f3.a f544366b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f544365a, r101.f544365a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f544366b, r101.f544366b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String toString() {
        return "DeviceSensorStartError(message=" + this.f544365a + ", errNo=" + this.f544366b + ')';
    }

    public final int hashCode() {
        return (this.f544365a.hashCode() * 31) + this.f544366b.f475285a;
    }

    public r0(String r100, f3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "errNo");
        this.f544365a = r100;
        this.f544366b = r101;
    }
}
