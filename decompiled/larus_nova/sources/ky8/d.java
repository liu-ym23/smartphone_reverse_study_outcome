package ky8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f506693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f506694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ny8.c f506695d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f506692a, r101.f506692a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506693b, r101.f506693b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506694c, r101.f506694c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506695d, r101.f506695d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506692a.hashCode() * 31;
        Long r101 = this.f506693b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f506694c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f506695d.hashCode();
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasReconnectParam(localId=" + this.f506692a + ", canvasId=" + this.f506693b + ", canvasSubId=" + this.f506694c + ", callback=" + this.f506695d + ')';
    }

    public d(String r100, Long r101, Long r102, ny8.c r103) {
        Intrinsics.checkNotNullParameter(r100, "localId");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f506692a = r100;
        this.f506693b = r101;
        this.f506694c = r102;
        this.f506695d = r103;
    }
}
