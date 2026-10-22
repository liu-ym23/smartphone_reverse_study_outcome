package hv4;

import com.bytedance.ee.bear.sheet.filter.FilterData;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f487297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f487298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f487299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f487300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f487301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Pair<Integer, Integer> f487302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f487303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f487304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f487305i;

    public final String toString() {
        return "DragIntent(fromPosition=" + this.f487297a + ", fromLevel=" + this.f487298b + ", dropOverLevelByX=" + this.f487299c + ", moveToPosition=" + this.f487300d + ", moveToParentPosition=" + this.f487301e + ", range=" + this.f487302f + ", moveToLevel=" + this.f487303g + ", dragOffsetLevel=" + this.f487304h + ')';
    }

    public a() {
        this.f487297a = -1;
        this.f487300d = -1;
        this.f487301e = -1;
        this.f487302f = new Pair(0, 0);
    }

    public final void update(int r100, int r101, int r102, int r103, int r104, Pair<Integer, Integer> r105) {
        Intrinsics.checkNotNullParameter(r105, FilterData.FilterOptionItem.Type.RANGE);
        this.f487297a = r100;
        this.f487298b = r101;
        this.f487299c = r102;
        this.f487300d = r103;
        this.f487302f = r105;
        int r106 = Math.min(Math.max(r102, r105.getFirst().intValue()), r105.getSecond().intValue());
        this.f487303g = r106;
        if (this.f487300d != (-1)) goto L5;
        int r107 = 0;
    L6:
        this.f487304h = r107;
        return;
    L5:
        r107 = r106 - r104;
        goto L6
    }
}
