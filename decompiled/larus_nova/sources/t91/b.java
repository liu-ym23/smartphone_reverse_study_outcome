package t91;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Integer> f545072a;

    public b() {
        this.f545072a = CollectionsKt.listOf(new Integer[]{3, 5, 6});
    }

    @Override // s91.c
    public final u91.a a(Object r100) {
        ((Number) r100).intValue();
        return new u91.a(new o91.b.f());
    }

    @Override // s91.c
    public final boolean b(boolean r100, int r101, Integer r102) {
        int r103 = r102.intValue();
        if (r100 == true) goto L6;
        if (r101 != 1) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L10;
    L18:
        return false;
    L10:
        if (r103 != 11) goto L13;
        if (r100 == true) goto L13;
        return true;
    L13:
        if (r103 != 10) goto L16;
        if (r100 == false) goto L16;
        return true;
    L16:
        if (this.f545072a.contains(Integer.valueOf(r103)) == false) goto L18;
        return true;
    L6:
        r104 = false;
        goto L7
    }
}
