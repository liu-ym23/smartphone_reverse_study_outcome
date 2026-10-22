package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f464840d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f464838b, r101.f464838b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464839c, r101.f464839c) == true) goto L15;
        return false;
    L15:
        if (this.f464840d == r101.f464840d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464838b.hashCode() * 31;
        String r101 = this.f464839c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f464840d == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CollaboratedTemplateSyncAction(widgetId=" + this.f464838b + ", template=" + this.f464839c + ", isValid=" + this.f464840d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464838b;
    }

    public g(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("CollaboratedTemplateSyncAction");
        this.f464838b = r100;
        this.f464839c = r101;
        this.f464840d = r102;
    }
}
