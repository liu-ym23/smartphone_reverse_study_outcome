package pc8;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f528567d;

    public c() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f528564a, r101.f528564a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528565b, r101.f528565b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528566c, r101.f528566c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528567d, r101.f528567d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f528564a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f528565b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f528566c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f528567d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerExtra(serverRequire=" + this.f528564a + ", diversionTracking=" + this.f528565b + ", popupScene=" + this.f528566c + ", ext=" + this.f528567d + ')';
    }

    public c(String r100, String r101, String r102, Map<String, String> r103) {
        this.f528564a = r100;
        this.f528565b = r101;
        this.f528566c = r102;
        this.f528567d = r103;
    }
}
