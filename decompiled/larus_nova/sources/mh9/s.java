package mh9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514020b;

    public s() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f514019a, r101.f514019a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514020b, r101.f514020b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f514019a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f514020b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceSettingRecommendFrom(scene=" + this.f514019a + ", requestId=" + this.f514020b + ')';
    }

    public s(String r100, String r101) {
        this.f514019a = r100;
        this.f514020b = r101;
    }
}
