package io.noties.markwon.ext.tables;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f492517a;

    public f() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L13:
        return true;
    L5:
        if ((r100 instanceof f) == true) goto L7;
    L12:
        return false;
    L7:
        if (this.f492517a != ((f) r100).f492517a) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
    L9:
        r101 = false;
        goto L10
    }

    public final int hashCode() {
        boolean r100 = this.f492517a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "TableOptions(generateExcelLiteral=" + this.f492517a + ")";
    }

    public f(boolean r100) {
        this.f492517a = r100;
    }
}
