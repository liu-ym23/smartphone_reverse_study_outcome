package e37;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f470930d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f470927a, r101.f470927a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470928b, r101.f470928b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470929c, r101.f470929c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470930d, r101.f470930d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f470927a.hashCode() * 31) + this.f470928b.hashCode()) * 31;
        String r101 = this.f470929c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f470930d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationTraceContext(traceName=" + this.f470927a + ", traceId=" + this.f470928b + ", pageId=" + this.f470929c + ", widgetInstanceId=" + this.f470930d + ")";
    }

    public j(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "traceName");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        this.f470927a = r100;
        this.f470928b = r101;
        this.f470929c = r102;
        this.f470930d = r103;
    }
}
