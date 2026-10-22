package er9;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f473646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f473647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f473648c;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f473646a == r101.f473646a) goto L12;
        return false;
    L12:
        if (this.f473647b == r101.f473647b) goto L15;
        return false;
    L15:
        if (this.f473648c == r101.f473648c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f473646a * 31) + this.f473647b) * 31) + this.f473648c;
    }

    public final String toString() {
        return "ProjectListDataSourcePagingConfig(firstPageSize=" + this.f473646a + ", secondPageSize=" + this.f473647b + ", pageSize=" + this.f473648c + ')';
    }

    public /* synthetic */ b(int r100) {
        this(5, 10, 20);
    }

    public b(int r100, int r101, int r102) {
        this.f473646a = r100;
        this.f473647b = r101;
        this.f473648c = r102;
    }
}
