package d18;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements e18.a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f466417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466419c;

    @Override // e18.a
    public final int getItemsCount() {
        return ((this.f466418b - this.f466417a) / this.f466419c) + 1;
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    @Override // e18.a
    public final Integer getItem(int r100) {
        int r101 = 0;
        if (r100 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        r101 = this.f466417a + (r100 * this.f466419c);
    L11:
        return Integer.valueOf(r101);
    L5:
        if (r100 >= getItemsCount()) goto L7;
        r102 = true;
        goto L8
    }

    @Override // e18.a
    public final int indexOf(Integer r100) {
        return (r100.intValue() - this.f466417a) / this.f466419c;
    }

    public b(int r100, int r101) {
        this.f466417a = r100;
        this.f466418b = r101;
        this.f466419c = 1;
    }

    public b(int r100, int r101, int r102) {
        this.f466417a = 0;
        this.f466418b = r100;
        this.f466419c = r101;
    }
}
