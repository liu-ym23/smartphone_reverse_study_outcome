package com.bytedance.locallife.live.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends m {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.locallife.live.view.m
    public final void b(int r100) {
        if (r100 <= 999) goto L5;
        r100 = 1000;
    L5:
        int r101 = this.f260830a;
        if (r100 > r101) goto L8;
        if (r101 == (-1)) goto L8;
        return;
    L8:
        this.f260830a = r100;
        int r102 = this.f260831b;
        if (r102 != (-1)) goto L13;
        this.f260831b = r100;
        Function1<? super Integer, Unit> r103 = this.f260833d;
        if (r103 == null) goto L19;
        r103.invoke(Integer.valueOf(r100));
        return;
    L19:
        return;
    L13:
        int r104 = Math.abs(r100 - r102);
        if (r104 <= 10) goto L16;
        this.f260832c = 10;
        return;
    L16:
        this.f260832c = r104;
    }
}
