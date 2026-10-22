package mt4;

import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f515639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f515640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f515641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Integer> f515642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f515643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f515644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f515645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f515646h;

    public final int b() {
        return RangesKt.coerceAtLeast(this.f515645g - this.f515643e, this.f515646h);
    }

    public e() {
        this.f515639a = new int[0];
        n.v();
        this.f515642d = new ArrayList();
        this.f515643e = -1;
        this.f515644f = new c(0, -n.d(100));
        this.f515645g = n.d(300);
        this.f515646h = n.d(100);
    }

    public final int a(int r100) {
        int[] r101 = this.f515639a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r101.length > r100) goto L6;
        return 0;
    L6:
        return r101[r100];
    }

    public final void c(int r100) {
        int r101 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r100, 0), this.f515641c);
        if (r101 > 0) goto L5;
        c r102 = new c(0, 0);
    L12:
        this.f515643e = r101;
        this.f515644f = r102;
        return;
    L5:
        int r103 = this.f515642d.size();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        if (((Number) ListProtector.get(this.f515642d, r104)).intValue() > r101) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        int r105 = r104 - 1;
        r102 = new c(r105, -(r101 - ((Number) ListProtector.get(this.f515642d, r105)).intValue()));
        goto L12
    L11:
        r102 = new c(0, 0);
        goto L12
    }

    public final void update(int[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "colWidths");
        this.f515639a = r100;
        int r102 = ArraysKt.sum(r100);
        this.f515640b = r102;
        this.f515641c = r102 - r101;
        this.f515642d.clear();
        this.f515642d.add(0);
        int r103 = 1;
        int r104 = r100.length + 1;
    L3:
        if (r103 >= r104) goto L5;
        ArrayList<Integer> r105 = this.f515642d;
        int r106 = r103 - 1;
        r105.add(Integer.valueOf(((Number) ListProtector.get(r105, r106)).intValue() + r100[r106]));
        r103 = r103 + 1;
        goto L3
    }
}
