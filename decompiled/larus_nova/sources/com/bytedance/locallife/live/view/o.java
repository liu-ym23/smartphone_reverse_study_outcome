package com.bytedance.locallife.live.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class o extends m {
    public o() {
    }

    @Override // com.bytedance.locallife.live.view.m
    public final void b(int r100) {
        int r101 = this.f260830a;
        if (r100 < r101) goto L5;
        if (r101 == (-1)) goto L5;
        return;
    L5:
        this.f260830a = r100;
        int r102 = this.f260831b;
        if (r102 != (-1)) goto L10;
        this.f260831b = r100;
        Function1<? super Integer, Unit> r103 = this.f260833d;
        if (r103 == null) goto L19;
        r103.invoke(Integer.valueOf(r100));
        return;
    L19:
        return;
    L10:
        int r104 = Math.abs(r100 - r102);
        if (r104 <= 10) goto L13;
        this.f260832c = 10;
    L14:
        Function1<? super Integer, Unit> r105 = this.f260833d;
        if (r105 == null) goto L21;
        r105.invoke(Integer.valueOf(a()));
        return;
    L21:
        return;
    L13:
        this.f260832c = r104;
        goto L14
    }
}
