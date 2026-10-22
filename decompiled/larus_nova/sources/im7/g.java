package im7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f490542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f490543c;

    public g() {
        this("", "", false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f490541a, r101.f490541a) == false) goto L16;
        if (Intrinsics.areEqual(this.f490542b, r101.f490542b) == false) goto L16;
        if (this.f490543c != r101.f490543c) goto L13;
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
        String r100 = this.f490541a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f490542b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f490543c;
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
        return "WidgetBubbleModel(widgetName=" + this.f490541a + ", bubbleText=" + this.f490542b + ", enableShow=" + this.f490543c + ")";
    }

    public g(String r100, String r101, boolean r102) {
        this.f490541a = r100;
        this.f490542b = r101;
        this.f490543c = r102;
    }
}
