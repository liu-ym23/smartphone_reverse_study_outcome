package im7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f490545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f490546c;

    public h() {
        this("", "", false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f490544a, r101.f490544a) == false) goto L16;
        if (Intrinsics.areEqual(this.f490545b, r101.f490545b) == false) goto L16;
        if (this.f490546c != r101.f490546c) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L16;
    L13:
        r102 = false;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f490544a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f490545b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f490546c;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WidgetSecondPageModel(widgetName=" + this.f490544a + ", secondJumpSchema=" + this.f490545b + ", enableJumpSecondPage=" + this.f490546c + ")";
    }

    public h(String r100, String r101, boolean r102) {
        this.f490544a = r100;
        this.f490545b = r101;
        this.f490546c = r102;
    }
}
