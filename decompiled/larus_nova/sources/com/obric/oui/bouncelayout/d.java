package com.obric.oui.bouncelayout;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Integer> f399050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<BounceEdgeEffect[]> f399051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f399052c;

    public final void a() {
        BounceEdgeEffect[] r100 = this.f399051b.invoke();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        BounceEdgeEffect r103 = r100[r102];
        r102 = r102 + 1;
        if (r103 == null) goto L3;
        r103.f398880c = this.f399052c;
        goto L3
    }

    public final void b() {
        int r100 = this.f399050a.invoke().intValue();
        if (r100 <= 0) goto L5;
        this.f399052c = RangesKt.coerceAtLeast(r100, 0.0f);
        a();
        return;
    L5:
        a();
    }

    public d(Function0<Integer> r100, Function0<BounceEdgeEffect[]> r101) {
        Intrinsics.checkNotNullParameter(r100, "sizePxProvider");
        Intrinsics.checkNotNullParameter(r101, "effectsProvider");
        this.f399050a = r100;
        this.f399051b = r101;
    }
}
