package com.bytedance.ee.bear.doc.structure.pad.viewmodel;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CatalogMode f218262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CatalogMode f218263b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f218262a == r101.f218262a) goto L12;
        return false;
    L12:
        if (this.f218263b == r101.f218263b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        CatalogMode r100 = this.f218262a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        CatalogMode r104 = this.f218263b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CatalogModeChanging(oldCatalogMode=" + this.f218262a + ", newCatalogMode=" + this.f218263b + ')';
    }

    public a(int r100) {
        this.f218262a = null;
        this.f218263b = null;
    }
}
