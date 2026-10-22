package li6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f509382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f509383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f509384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f509385d;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f509382a, r101.f509382a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509383b, r101.f509383b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509384c, r101.f509384c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509385d, r101.f509385d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f509382a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f509383b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f509384c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        d r110 = this.f509385d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveRTCExtInfo(infoString=" + this.f509382a + ", rtcBusinessId=" + this.f509383b + ", rtcEngineConfig=" + this.f509384c + ", rtcVideoParam=" + this.f509385d + ")";
    }

    public c(int r100) {
        this.f509382a = null;
        this.f509383b = null;
        this.f509384c = null;
        this.f509385d = null;
    }
}
