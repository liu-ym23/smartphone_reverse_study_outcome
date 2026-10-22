package uac;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f549301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f549302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f549303c;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f549301a, r101.f549301a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549302b, r101.f549302b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549303c, r101.f549303c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f549301a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f549302b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f549303c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceAsrRetryConfig(maxRetryCount=" + this.f549301a + ", firstResultTimeoutMs=" + this.f549302b + ", finalResultTimeoutMs=" + this.f549303c + ')';
    }

    public b(int r100) {
        this.f549301a = null;
        this.f549302b = null;
        this.f549303c = null;
    }
}
