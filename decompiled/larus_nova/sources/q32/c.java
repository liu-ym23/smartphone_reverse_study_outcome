package q32;

import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f531495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f531496b;

    public abstract int a();

    public abstract void c(int r100, int r101, float r102);

    public abstract void d(int r100);

    public c() {
        this.f531495a = -1;
        this.f531496b = -1;
    }

    public final void b(int r100, float r101) {
        float r102 = r100 + r101;
        float r103 = a() - 1;
        if (r102 != r103) goto L5;
        r102 = r103 - 1.0E-4f;
    L5:
        int r104 = (int) r102;
        int r105 = r104 + 1;
        if (r105 <= r103) goto L8;
        return;
    L8:
        if (r104 <= (-1)) goto L30;
        c(r104, r105, r102 % 1);
        int r106 = this.f531495a;
        if (r106 <= (-1)) goto L25;
        if (r104 <= r106) goto L17;
        Iterator<Integer> r107 = RangesKt.until(r106, r104).iterator();
    L15:
        if (r107.hasNext() == false) goto L17;
        d(((IntIterator) r107).nextInt());
    L17:
        int r108 = this.f531496b;
        if (r105 >= r108) goto L25;
        if (r108 > r103) goto L25;
        d(r108);
        Iterator<Integer> r109 = new IntRange(r105 + 1, this.f531496b).iterator();
    L23:
        if (r109.hasNext() == false) goto L25;
        d(((IntIterator) r109).nextInt());
    L25:
        this.f531495a = r104;
        this.f531496b = r105;
        return;
    }
}
