package zb3;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f571138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f571139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f571140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f571141e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f571137a, r101.f571137a) == true) goto L8;
        return false;
    L8:
        if (this.f571138b == r101.f571138b) goto L10;
        return false;
    L10:
        if (this.f571139c == r101.f571139c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571140d, r101.f571140d) == true) goto L14;
        return false;
    L14:
        if (this.f571141e == r101.f571141e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f571137a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f571138b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f571139c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.f571140d;
        if (r107 == null) goto L9;
        r101 = r107.hashCode();
    L9:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f571141e;
        ?? r110 = r109;
        if (r109 == false) goto L13;
        r110 = 1;
    L13:
        return r108 + r110;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentListRequestParam(productId=" + this.f571137a + ", cursor=" + this.f571138b + ", count=" + this.f571139c + ", entrance=" + this.f571140d + ", needAdaptAddr=" + this.f571141e + ")";
    }

    public d() {
        this("", 0, 0, "", false);
    }

    public d(String r100, long r101, long r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r103, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        this.f571137a = r100;
        this.f571138b = r101;
        this.f571139c = r102;
        this.f571140d = r103;
        this.f571141e = r104;
    }
}
