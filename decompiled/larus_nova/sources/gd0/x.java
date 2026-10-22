package gd0;

import hh1.v0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei6.a f480900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f480901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f480902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f480903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f480904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f480905f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L18;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f480900a, r101.f480900a) == true) goto L8;
        return false;
    L8:
        if (this.f480901b == r101.f480901b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f480902c, r101.f480902c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480903d, r101.f480903d) == true) goto L14;
        return false;
    L14:
        if (this.f480904e == r101.f480904e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f480905f, r101.f480905f) == true) goto L28;
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
        ei6.a r100 = this.f480900a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f480901b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Map<String, Object> r108 = this.f480902c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        d0 r111 = this.f480903d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f480904e;
        if (r114 == true) goto L21;
        r105 = r114;
    L21:
        int r115 = (r113 + r105) * 31;
        Object r116 = this.f480905f;
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
        return "RtcManagerData(mClient=" + this.f480900a + ", isEngineOn=" + this.f480901b + ", remoteMap=" + this.f480902c + ", liveCore=" + this.f480903d + ", hasLinkAudience4Stop=" + this.f480904e + ", liveClient=" + this.f480905f + ")";
    }

    public x(ei6.a r100, boolean r101, Map<String, Object> r102, d0 r103, boolean r104, Object r105) {
        Intrinsics.checkNotNullParameter(r102, "remoteMap");
        this.f480900a = r100;
        this.f480901b = r101;
        this.f480902c = r102;
        this.f480903d = r103;
        this.f480904e = r104;
        this.f480905f = r105;
    }

    public /* synthetic */ x(ei6.a r100, boolean r101, Map r110, d0 r111, boolean r112, v0 r113, int r114) {
        if ((r114 & 16) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r114 & 32) == 0) goto L9;
        r113 = null;
    L9:
        this(r100, r101, r110, r111, r102, r113);
        return;
    L5:
        r102 = r112;
        goto L7
    }
}
