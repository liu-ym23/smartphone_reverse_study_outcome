package ik9;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f490282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f490283c;

    public d() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f490281a, r101.f490281a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f490282b, r101.f490282b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f490283c, r101.f490283c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f490281a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f490282b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f490283c;
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
        return "MiniArtifactProductLoadFinish(title=" + this.f490281a + ", artifactId=" + this.f490282b + ", trackParams=" + this.f490283c + ')';
    }

    public d(String r100, String r101, Map<String, ? extends Object> r102) {
        this.f490281a = r100;
        this.f490282b = r101;
        this.f490283c = r102;
    }
}
