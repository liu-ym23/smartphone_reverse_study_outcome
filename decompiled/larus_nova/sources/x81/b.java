package x81;

import kotlin.Pair;
import u81.d;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pair<Integer, T>[] f562884a;

    public b() {
        this.f562884a = new Pair[99];
    }

    public final int a(int r100, Integer r101) {
        int r102 = 0;
    L4:
        if (r102 >= 99) goto L15;
        Pair<Integer, T> r103 = this.f562884a[r102];
        if (r103 == null) goto L14;
        int r104 = r103.getFirst().intValue();
        int r105 = r100 * 10;
        if (r101 == null) goto L10;
        int r106 = r101.intValue();
    L12:
        if (r104 != (r105 + r106)) goto L14;
        return r102;
    L10:
        r106 = 0;
    L14:
        r102 = r102 + 1;
        goto L4
    L15:
        return -1;
    }
}
