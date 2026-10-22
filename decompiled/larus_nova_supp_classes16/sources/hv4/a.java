package hv4;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Pair<Integer, Integer> f;
    public int g;
    public int h;
    public boolean i;

    public final String toString() {
        return "DragIntent(fromPosition=" + this.a + ", fromLevel=" + this.b + ", dropOverLevelByX=" + this.c + ", moveToPosition=" + this.d + ", moveToParentPosition=" + this.e + ", range=" + this.f + ", moveToLevel=" + this.g + ", dragOffsetLevel=" + this.h + ')';
    }

    public a() {
        this.a = -1;
        this.d = -1;
        this.e = -1;
        this.f = new Pair(0, 0);
    }

    public final void update(int r2, int r3, int r4, int r5, int r6, Pair<Integer, Integer> r7) {
        Intrinsics.checkNotNullParameter(r7, "range");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = r7;
        int r8 = Math.min(Math.max(r4, ((Number) r7.getFirst()).intValue()), ((Number) r7.getSecond()).intValue());
        this.g = r8;
        if (this.d != (-1)) goto L5;
        int r9 = 0;
    L6:
        this.h = r9;
        return;
    L5:
        r9 = r8 - r6;
        goto L6
    }
}
