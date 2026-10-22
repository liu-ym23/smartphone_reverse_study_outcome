package com.google.common.util.concurrent;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes23.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ boolean a(Unsafe r100, Object r101, long r102, Object r103, Object r104) {
    L3:
        if (r100.compareAndSwapObject(r101, r102, r103, r104) == true) goto L4;
        if (r100.getObject(r101, r102) == r103) goto L3;
        return false;
    L4:
        return true;
    }
}
