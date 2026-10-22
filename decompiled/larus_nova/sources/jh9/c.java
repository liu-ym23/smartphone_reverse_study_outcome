package jh9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f499109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f499110c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f499108a, r101.f499108a) == true) goto L12;
        return false;
    L12:
        if (this.f499109b == r101.f499109b) goto L15;
        return false;
    L15:
        if (this.f499110c == r101.f499110c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f499108a.hashCode() * 31;
        int r101 = 1231;
        if (this.f499109b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f499110c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UgcVoiceAuthorizeCacheDecision(cacheKey=" + this.f499108a + ", cacheKeyChanged=" + this.f499109b + ", shouldHydrateFromLaunchInfo=" + this.f499110c + ')';
    }

    public c(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        this.f499108a = r100;
        this.f499109b = r101;
        this.f499110c = r102;
    }
}
