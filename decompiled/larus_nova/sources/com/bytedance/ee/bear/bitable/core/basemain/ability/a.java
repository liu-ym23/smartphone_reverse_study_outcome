package com.bytedance.ee.bear.bitable.core.basemain.ability;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f210126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f210127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f210128c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f210126a == r101.f210126a) goto L12;
        return false;
    L12:
        if (this.f210127b == r101.f210127b) goto L15;
        return false;
    L15:
        if (this.f210128c == r101.f210128c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f210126a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f210127b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f210128c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BaseMainLoadingConfig(enableShareRecordLoading=" + this.f210126a + ", isShareRecord=" + this.f210127b + ", isBaseAdd=" + this.f210128c + ')';
    }

    public a(boolean r100, boolean r101, boolean r102) {
        this.f210126a = r100;
        this.f210127b = r101;
        this.f210128c = r102;
    }
}
