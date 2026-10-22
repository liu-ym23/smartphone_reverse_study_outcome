package k11;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f501350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f501351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f501352c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f501350a, r101.f501350a) == true) goto L8;
        return false;
    L8:
        if (this.f501351b == r101.f501351b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f501352c, r101.f501352c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.f501350a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f501351b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Map<String, String> r105 = this.f501352c;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicLinkInfo(logMap=" + this.f501350a + ", channelId=" + this.f501351b + ", battleParams=" + this.f501352c + ")";
    }

    public c(Map<String, String> r100, long r101, Map<String, String> r102) {
        this.f501350a = r100;
        this.f501351b = r101;
        this.f501352c = r102;
    }
}
