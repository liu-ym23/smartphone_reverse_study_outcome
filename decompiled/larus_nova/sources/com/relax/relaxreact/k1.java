package com.relax.relaxreact;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k1<T> extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Pair<? extends T, l1<T>> f405544c;

    public k1(T r100) {
        super(HookType.State);
        l1 r101 = new l1();
        Pair<? extends T, l1<T>> r102 = new Pair(r100, r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405544c = r102;
        r101.f405548a = this;
    }

    public void update(T r100) {
        Pair<? extends T, l1<T>> r101 = this.f405544c;
        Pair<? extends T, l1<T>> r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("value");
        r101 = null;
    L6:
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (p0.a(r101.getFirst(), r100) == true) goto L20;
        Pair<? extends T, l1<T>> r103 = this.f405544c;
        if (r103 == null) goto L11;
        r102 = r103;
    L12:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Pair<? extends T, l1<T>> r104 = new Pair(r100, r102.getSecond());
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f405544c = r104;
        d r105 = this.f405462b;
        if (r105 == null) goto L21;
        Intrinsics.checkNotNull(r105);
        x0 r106 = r105.f405481h;
        if (r106 == null) goto L22;
        Scheduler r107 = r106.f405597b;
        if (r107 == null) goto L23;
        d r108 = this.f405462b;
        Intrinsics.checkNotNull(r108);
        r107.b(r108);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L11:
        Intrinsics.throwUninitializedPropertyAccessException("value");
        goto L12
    }
}
