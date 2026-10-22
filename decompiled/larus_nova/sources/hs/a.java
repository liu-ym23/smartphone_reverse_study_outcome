package hs;

import com.bytedance.android.gamecp.business.download.b;
import cw.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f486928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f486929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f486930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f486932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f486933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f486934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final cw.a f486935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f486936i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f486928a, r101.f486928a) == true) goto L8;
        return false;
    L8:
        if (this.f486929b == r101.f486929b) goto L10;
        return false;
    L10:
        if (this.f486930c == r101.f486930c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486931d, r101.f486931d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f486932e, r101.f486932e) == true) goto L16;
        return false;
    L16:
        if (this.f486933f == r101.f486933f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486934g, r101.f486934g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f486935h, r101.f486935h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f486936i, r101.f486936i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v23 */
    public final int hashCode() {
        String r100 = this.f486928a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f486929b;
        int r104 = ((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f486930c) * 31;
        String r105 = this.f486931d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f486932e;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f486933f;
        ?? r112 = r111;
        if (r111 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r110 + r112) * 31;
        b r114 = this.f486934g;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        cw.a r117 = this.f486935h;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        c r120 = this.f486936i;
        if (r120 == null) goto L29;
        r101 = r120.hashCode();
    L29:
        return r119 + r101;
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ACRestoreModel(gameName=" + this.f486928a + ", curTime=" + this.f486929b + ", restoreFrom=" + this.f486930c + ", sourceApk=" + this.f486931d + ", targetApk=" + this.f486932e + ", isForceRestore=" + this.f486933f + ", downloadShortInfo=" + this.f486934g + ", airCompressListener=" + this.f486935h + ", callback=" + this.f486936i + ")";
    }

    public a() {
        this("", 0, 0, "", "", false, null, null, null);
    }

    public a(String r100, long r101, int r102, String r103, String r104, boolean r105, b r106, cw.a r110, c r111) {
        Intrinsics.checkNotNullParameter(r100, "gameName");
        Intrinsics.checkNotNullParameter(r103, "sourceApk");
        Intrinsics.checkNotNullParameter(r104, "targetApk");
        this.f486928a = r100;
        this.f486929b = r101;
        this.f486930c = r102;
        this.f486931d = r103;
        this.f486932e = r104;
        this.f486933f = r105;
        this.f486934g = r106;
        this.f486935h = r110;
        this.f486936i = r111;
    }
}
