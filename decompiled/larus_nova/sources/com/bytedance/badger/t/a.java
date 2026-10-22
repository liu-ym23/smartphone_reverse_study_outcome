package com.bytedance.badger.t;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f199193a = 0;

    static {
    }

    public a() {
    }

    public static d a(int r100, Object r101, Function1 r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = b.f199194a;
    L8:
        c r104 = new c(r100);
        r102.invoke(r104);
        return r104.a(r101);
    }
}
