package mc7;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C6800a f513237h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f513238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f513239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f513240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f513241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f513242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f513243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f513244g;

    /* JADX INFO: renamed from: mc7.a$a, reason: collision with other inner class name */
    public static final class C6800a {
        public C6800a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L31:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L30;
        a r101 = (a) r100;
        if (this.f513238a != r101.f513238a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L30;
        if (Intrinsics.areEqual(this.f513239b, r101.f513239b) == false) goto L30;
        if (Intrinsics.areEqual(this.f513240c, r101.f513240c) == false) goto L30;
        if (this.f513241d != r101.f513241d) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L30;
        if (Intrinsics.areEqual(this.f513242e, r101.f513242e) == false) goto L30;
        if (Intrinsics.areEqual(this.f513243f, r101.f513243f) == false) goto L30;
        if (this.f513244g != r101.f513244g) goto L27;
        boolean r104 = true;
    L28:
        if (r104 == false) goto L30;
    L27:
        r104 = false;
        goto L28
    L18:
        r103 = false;
        goto L19
    L9:
        r102 = false;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f513238a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        Set<String> r104 = this.f513239b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        Set<String> r108 = this.f513240c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f513241d;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        Set<String> r114 = this.f513242e;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f513243f;
        if (r117 == null) goto L23;
        r105 = r117.hashCode();
    L23:
        int r118 = (r116 + r105) * 31;
        boolean r119 = this.f513244g;
        if (r119 == true) goto L28;
        r101 = r119;
    L28:
        return r118 + r101;
    L19:
        r115 = 0;
        goto L20
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "RequestUseCellularConfig(isEnable=" + this.f513238a + ", carriers=" + this.f513239b + ", paths=" + this.f513240c + ", isEnableIpv4Opt=" + this.f513241d + ", ipv4OptCarriers=" + this.f513242e + ", ipv4Host=" + this.f513243f + ", isEnableAlternativeNetOpt=" + this.f513244g + ")";
    }

    static {
        f513237h = new C6800a();
    }

    public a(boolean r100, Set<String> r101, Set<String> r102, boolean r103, Set<String> r104, String r105, boolean r106) {
        this.f513238a = r100;
        this.f513239b = r101;
        this.f513240c = r102;
        this.f513241d = r103;
        this.f513242e = r104;
        this.f513243f = r105;
        this.f513244g = r106;
    }
}
