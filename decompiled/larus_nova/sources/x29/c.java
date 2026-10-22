package x29;

import com.larus.contextwindow.api.ContextWindowUsageParts;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContextWindowUsageParts f562259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f562260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f562261c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f562259a, r101.f562259a) == true) goto L12;
        return false;
    L12:
        if (this.f562260b == r101.f562260b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f562261c, r101.f562261c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f562259a.hashCode() * 31;
        long r101 = this.f562260b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Long r103 = this.f562261c;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "Success(parts=" + this.f562259a + ", used=" + this.f562260b + ", messageTotal=" + this.f562261c + ')';
    }

    public c(ContextWindowUsageParts r100, long r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "parts");
        this.f562259a = r100;
        this.f562260b = r101;
        this.f562261c = r102;
    }
}
