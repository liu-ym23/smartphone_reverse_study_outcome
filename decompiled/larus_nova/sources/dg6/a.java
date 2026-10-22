package dg6;

import ec6.b;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei6.a f468509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f468510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f468511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f468512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f468513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f468514f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f468509a, r101.f468509a) == true) goto L8;
        return false;
    L8:
        if (this.f468510b == r101.f468510b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468511c, r101.f468511c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468512d, r101.f468512d) == true) goto L14;
        return false;
    L14:
        if (this.f468513e == r101.f468513e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f468514f, r101.f468514f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        ei6.a r100 = this.f468509a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f468510b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Map<String, Object> r108 = this.f468511c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        b r111 = this.f468512d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f468513e;
        if (r114 == true) goto L21;
        r105 = r114;
    L21:
        int r115 = (r113 + r105) * 31;
        Object r116 = this.f468514f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RtcManagerDataKt(mClient=" + this.f468509a + ", isEngineOn=" + this.f468510b + ", remoteMap=" + this.f468511c + ", multiLinkBizAVClient=" + this.f468512d + ", hasLinkAudience4Stop=" + this.f468513e + ", liveClient=" + this.f468514f + ")";
    }

    public a(ei6.a r100, boolean r101, Map<String, Object> r102, b r103, boolean r104, Object r105) {
        Intrinsics.checkNotNullParameter(r102, "remoteMap");
        this.f468509a = r100;
        this.f468510b = r101;
        this.f468511c = r102;
        this.f468512d = r103;
        this.f468513e = r104;
        this.f468514f = r105;
    }
}
