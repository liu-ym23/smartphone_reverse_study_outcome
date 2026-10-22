package ib8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f489005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kb8.a f489006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mb8.a f489007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nb8.m f489008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final do8.k f489009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kc8.o f489010f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f489005a, r101.f489005a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f489006b, r101.f489006b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f489007c, r101.f489007c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f489008d, r101.f489008d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f489009e, r101.f489009e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f489010f, r101.f489010f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f489005a.hashCode() * 31;
        kb8.a r101 = this.f489006b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        mb8.a r105 = this.f489007c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        nb8.m r108 = this.f489008d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        do8.k r111 = this.f489009e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        kc8.o r114 = this.f489010f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContainerVmData(foldContainerVmData=" + this.f489005a + ", queryKeywordReferencesVMData=" + this.f489006b + ", blockListVMData=" + this.f489007c + ", deepThinkContentVMData=" + this.f489008d + ", vlmVmData=" + this.f489009e + ", containerVmConfig=" + this.f489010f + ')';
    }

    public b(c0 r100, kb8.a r101, mb8.a r102, nb8.m r103, do8.k r104, kc8.o r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r106 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r106 & 32) == 0) goto L17;
        r105 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, "foldContainerVmData");
        this.f489005a = r100;
        this.f489006b = r101;
        this.f489007c = r102;
        this.f489008d = r103;
        this.f489009e = r104;
        this.f489010f = r105;
    }
}
