package pd2;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f528661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f528662b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (this.f528661a == r101.f528661a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f528662b, r101.f528662b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f528661a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        HashMap<String, String> r102 = this.f528662b;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "SingPathParam(songId=" + this.f528661a + ", extra=" + this.f528662b + ")";
    }

    public f(long r100, HashMap<String, String> r101) {
        this.f528661a = r100;
        this.f528662b = r101;
    }
}
