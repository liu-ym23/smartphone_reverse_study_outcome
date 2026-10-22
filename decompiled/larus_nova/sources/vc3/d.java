package vc3;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f554102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f554104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f554105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f554106e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f554102a, r101.f554102a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f554103b, r101.f554103b) == true) goto L10;
        return false;
    L10:
        if (this.f554104c == r101.f554104c) goto L12;
        return false;
    L12:
        if (this.f554105d == r101.f554105d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f554106e, r101.f554106e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f554102a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f554103b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f554104c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f554105d;
        if (r111 == true) goto L17;
        r108 = r111;
    L17:
        int r112 = (r110 + r108) * 31;
        View r113 = this.f554106e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SlcOpenActionParams(area=" + this.f554102a + ", btm=" + this.f554103b + ", btmAppendIndex=" + this.f554104c + ", btmTokenAppendBcm=" + this.f554105d + ", view=" + this.f554106e + ")";
    }

    public d(String r100, String r101, boolean r102, boolean r103, View r104) {
        Intrinsics.checkNotNullParameter(r100, "area");
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r104, "view");
        this.f554102a = r100;
        this.f554103b = r101;
        this.f554104c = r102;
        this.f554105d = r103;
        this.f554106e = r104;
    }
}
