package i11;

import com.bytedance.android.livesdk.link.model.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f487938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f487939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f487940c;

    public f() {
        this(null, false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f487938a, r101.f487938a) == true) goto L8;
        return false;
    L8:
        if (this.f487939b == r101.f487939b) goto L10;
        return false;
    L10:
        if (this.f487940c == r101.f487940c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        r r100 = this.f487938a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f487939b;
        ?? r104 = r103;
        if (r103 == false) goto L9;
        r104 = 1;
    L9:
        int r105 = (r102 + r104) * 31;
        long r106 = this.f487940c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "PreloadLinkListData(data=" + this.f487938a + ", isRequesting=" + this.f487939b + ", timestamp=" + this.f487940c + ")";
    }

    public f(r r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r102 & 4) == 0) goto L11;
        i97.a r103 = i97.a.f488802a;
        long r104 = System.currentTimeMillis();
    L12:
        this.f487938a = r100;
        this.f487939b = r101;
        this.f487940c = r104;
        return;
    L11:
        r104 = 0;
        goto L12
    }
}
