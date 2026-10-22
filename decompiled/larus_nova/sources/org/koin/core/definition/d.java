package org.koin.core.definition;

/* JADX INFO: loaded from: classes42.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f526139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f526140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f526141c;

    public d() {
        boolean r100 = false;
        this(r100, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f526139a == r101.f526139a) goto L12;
        return false;
    L12:
        if (this.f526140b == r101.f526140b) goto L15;
        return false;
    L15:
        if (this.f526141c == r101.f526141c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f526139a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f526140b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f526141c;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public final String toString() {
        return "Options(isCreatedAtStart=" + this.f526139a + ", override=" + this.f526140b + ", isExtraDefinition=" + this.f526141c + ')';
    }

    public /* synthetic */ d(boolean r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101, false);
    }

    public d(boolean r100, boolean r101, boolean r102) {
        this.f526139a = r100;
        this.f526140b = r101;
        this.f526141c = r102;
    }
}
