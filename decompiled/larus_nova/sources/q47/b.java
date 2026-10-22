package q47;

import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Iterator<a.C7277a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f531644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f531645b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int r100 = this.f531644a;
        if (r100 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= this.f531645b.f531642c) goto L7;
        return true;
    }

    @Override // java.util.Iterator
    public final a.C7277a next() {
        a.b r100 = this.f531645b;
        int r101 = this.f531644a;
        int r102 = r100.f531641b + r101;
        a.C7277a[] r103 = r100.f531640a;
        a.C7277a r104 = r103[r102 % r103.length];
        if (r104 == null) goto L5;
        this.f531644a = r101 + 1;
    L5:
        return r104;
    }

    public b(a.b r100, int r101) {
        this.f531645b = r100;
        this.f531644a = r100.b(r101);
    }
}
