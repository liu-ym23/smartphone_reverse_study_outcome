package y46;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f566043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f566044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f566045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f566046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f566047e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f566043a == r101.f566043a) goto L12;
        return false;
    L12:
        if (this.f566044b == r101.f566044b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566045c, r101.f566045c) == true) goto L18;
        return false;
    L18:
        if (this.f566046d == r101.f566046d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566047e, r101.f566047e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f566043a * 31) + this.f566044b) * 31) + this.f566045c.hashCode()) * 31;
        long r101 = this.f566046d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        Set<String> r103 = this.f566047e;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "DiffResult(screenWidth=" + this.f566043a + ", screenHeight=" + this.f566044b + ", diffResultItem=" + this.f566045c + ", timeGap=" + this.f566046d + ", firstScreenViewGroupSet=" + this.f566047e + ')';
    }

    public b(int r100, int r101, List<c> r102, long r103, Set<String> r104) {
        Intrinsics.checkNotNullParameter(r102, "diffResultItem");
        this.f566043a = r100;
        this.f566044b = r101;
        this.f566045c = r102;
        this.f566046d = r103;
        this.f566047e = r104;
    }
}
