package d18;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements e18.a<Integer> {
    public f() {
    }

    @Override // e18.a
    public final int getItemsCount() {
        return 12;
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    @Override // e18.a
    public final Integer getItem(int r100) {
        if (r100 != 0) goto L6;
        r100 = 12;
    L14:
        return Integer.valueOf(r100);
    L6:
        if (r100 < 0) goto L9;
        if (r100 >= 12) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L14;
        r100 = 0;
    L9:
        r101 = false;
        goto L10
    }

    @Override // e18.a
    public final int indexOf(Integer r100) {
        int r101 = r100.intValue();
        if (r101 != 12) goto L6;
        return 0;
    L6:
        return r101;
    }
}
