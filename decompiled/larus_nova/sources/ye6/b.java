package ye6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f567398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xe6.c f567399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xe6.a f567400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xe6.b f567401d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f567398a, r101.f567398a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f567399b, r101.f567399b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f567400c, r101.f567400c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f567401d, r101.f567401d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f567398a.hashCode() * 31) + this.f567399b.hashCode()) * 31) + this.f567400c.hashCode()) * 31) + this.f567401d.hashCode();
    }

    public final String toString() {
        return "TraceInitConfig(appInfo=" + this.f567398a + ", networkTypeProvider=" + this.f567399b + ", eventReporter=" + this.f567400c + ", logger=" + this.f567401d + ')';
    }

    public b(a r100) {
        di9.c r101 = di9.c.f468865a;
        di9.a r102 = di9.a.f468863a;
        di9.b r103 = di9.b.f468864a;
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r101, "networkTypeProvider");
        Intrinsics.checkNotNullParameter(r102, "eventReporter");
        Intrinsics.checkNotNullParameter(r103, "logger");
        this.f567398a = r100;
        this.f567399b = r101;
        this.f567400c = r102;
        this.f567401d = r103;
    }
}
