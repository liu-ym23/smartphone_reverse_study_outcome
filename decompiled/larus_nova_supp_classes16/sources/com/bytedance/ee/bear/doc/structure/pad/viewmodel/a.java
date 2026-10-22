package com.bytedance.ee.bear.doc.structure.pad.viewmodel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public CatalogMode a;
    public CatalogMode b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        CatalogMode r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CatalogMode r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CatalogModeChanging(oldCatalogMode=" + this.a + ", newCatalogMode=" + this.b + ')';
    }

    public a(int r1) {
        this.a = null;
        this.b = null;
    }
}
