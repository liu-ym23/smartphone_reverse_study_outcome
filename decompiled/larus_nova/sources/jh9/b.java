package jh9;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f499104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f499105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f499106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f499107d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f499104a == r101.f499104a) goto L12;
        return false;
    L12:
        if (this.f499105b == r101.f499105b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f499106c, r101.f499106c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f499107d, r101.f499107d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f499104a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f499105b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        Boolean r104 = this.f499106c;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return ((r103 + r105) * 31) + this.f499107d.hashCode();
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CreateUgcVoiceVisibilityPolicyInput(audioFeatureEnabled=" + this.f499104a + ", launchInfoVoiceFeatureEnabled=" + this.f499105b + ", hasUgcVoiceRecord=" + this.f499106c + ", allowedLanguages=" + this.f499107d + ')';
    }

    public b(boolean r100, boolean r101, Boolean r102, Set<String> r103) {
        Intrinsics.checkNotNullParameter(r103, "allowedLanguages");
        this.f499104a = r100;
        this.f499105b = r101;
        this.f499106c = r102;
        this.f499107d = r103;
    }
}
