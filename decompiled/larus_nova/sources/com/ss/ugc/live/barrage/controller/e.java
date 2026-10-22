package com.ss.ugc.live.barrage.controller;

import java.util.Comparator;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements Comparator<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f458138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f458139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScrollBarrageController f458140c;

    public e(ScrollBarrageController r100) {
        this.f458140c = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Integer r100, Integer r101) {
        int r102 = r100.intValue();
        int r103 = r101.intValue();
        float r104 = this.f458140c.s(r102);
        float r105 = this.f458140c.s(r103);
        if (r104 >= (this.f458138a - this.f458140c.t())) goto L6;
        r104 = 0.0f;
    L6:
        if (r105 >= (this.f458138a - this.f458140c.t())) goto L9;
        r105 = 0.0f;
    L9:
        if (r104 != r105) goto L28;
        f r106 = this.f458140c.f458113t;
        int r107 = this.f458139b;
        r106.getClass();
        if (r107 < 5) goto L14;
        int r108 = Math.abs(r102 - 2);
    L17:
        int r109 = r107 - r108;
        f r110 = this.f458140c.f458113t;
        int r111 = this.f458139b;
        r110.getClass();
        if (r111 < 5) goto L20;
        int r112 = Math.abs(r103 - 2);
    L23:
        int r113 = r111 - r112;
        if (r109 != r113) goto L27;
        return MathKt.getSign(r102 - r103);
    L27:
        return MathKt.getSign(r113 - r109);
    L20:
        if (r111 < 3) goto L22;
        r112 = Math.abs(r103 - 1);
        goto L23
    L22:
        r112 = r103;
        goto L23
    L14:
        if (r107 < 3) goto L16;
        r108 = Math.abs(r102 - 1);
        goto L17
    L16:
        r108 = r102;
        goto L17
    L28:
        return MathKt.getSign((int) (r104 - r105));
    }
}
