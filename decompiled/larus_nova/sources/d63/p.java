package d63;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o> f467164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f467165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f467166c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L12;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f467164a, r101.f467164a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f467165b, r101.f467165b) == true) goto L10;
        return false;
    L10:
        if (this.f467166c == r101.f467166c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<o> r100 = this.f467164a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f467165b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f467166c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LogisticLineVO(logisticItems=" + this.f467164a + ", jumpUrl=" + this.f467165b + ", type=" + this.f467166c + ")";
    }

    public p() {
        this(null, null, 0);
    }

    public final long getType() {
        return this.f467166c;
    }

    public p(List<o> r100, String r101, long r102) {
        this.f467164a = r100;
        this.f467165b = r101;
        this.f467166c = r102;
    }
}
