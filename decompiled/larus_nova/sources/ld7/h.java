package ld7;

import java.util.Arrays;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f508742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f508743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f508744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f508745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, Integer> f508746e;

    public h() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f508742a == r101.f508742a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508743b, r101.f508743b) == true) goto L15;
        return false;
    L15:
        if (this.f508744c == r101.f508744c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f508745d, r101.f508745d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f508746e, r101.f508746e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f508742a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + Arrays.hashCode(this.f508743b)) * 31;
        if (this.f508744c == true) goto L11;
        r100 = 1237;
    L11:
        return ((((r102 + r100) * 31) + Arrays.hashCode(this.f508745d)) * 31) + this.f508746e.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "JSBAuthMethodAuthTypeSetting(enableWebForcePrivate=" + this.f508742a + ", webPublicMethod=" + Arrays.toString(this.f508743b) + ", enableLynxForcePrivate=" + this.f508744c + ", lynxPublicMethod=" + Arrays.toString(this.f508745d) + ", commonSecureMethod=" + this.f508746e + ')';
    }

    public h(Object r100) {
        String[] r101 = new String[0];
        String[] r102 = new String[0];
        Map<String, Integer> r103 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r101, "webPublicMethod");
        Intrinsics.checkNotNullParameter(r102, "lynxPublicMethod");
        Intrinsics.checkNotNullParameter(r103, "commonSecureMethod");
        this.f508742a = false;
        this.f508743b = r101;
        this.f508744c = true;
        this.f508745d = r102;
        this.f508746e = r103;
    }
}
