package mab;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements a<Integer> {
    @Override // mab.a
    public final int getItemsCount() {
        return 99;
    }

    @Override // mab.a
    public final String a() {
        return String.valueOf(99);
    }

    public b() {
    }

    public final Integer b(int r100) {
        if (r100 < 0) goto L8;
        if (r100 >= 99) goto L8;
        return Integer.valueOf(1 + (r100 * 1));
    L8:
        return 0;
    }

    @Override // mab.a
    public final /* bridge */ /* synthetic */ Integer getItem(int r100) {
        return b(r100);
    }

    @Override // mab.a
    public final int indexOf(Integer r100) {
        return (r100.intValue() - 1) / 1;
    }
}
