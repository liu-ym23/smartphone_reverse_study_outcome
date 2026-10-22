package xm0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f564535d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f564532a, r101.f564532a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f564533b, r101.f564533b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f564534c, r101.f564534c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f564535d, r101.f564535d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f564532a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f564533b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f564534c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f564535d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HybridActionEvent(actionName=" + this.f564532a + ", url=" + this.f564533b + ", containerId=" + this.f564534c + ", extraJson=" + this.f564535d + ')';
    }

    public a(String r100, String r101) {
        this.f564532a = "hybrid_container_destroy";
        this.f564533b = r100;
        this.f564534c = r101;
        this.f564535d = "";
    }
}
