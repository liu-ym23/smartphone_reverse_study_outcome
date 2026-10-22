package com.bytedance.assem.arch.reused;

import com.bytedance.assem.arch.core.InflateMode;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f193031a = null;

    static {
        int[] r100 = new int[InflateMode.values().length];
        f193031a = r100;
        r100[InflateMode.ASYNC.ordinal()] = 1;
        r100[InflateMode.X2C.ordinal()] = 2;
        r100[InflateMode.ASYNC_X2C.ordinal()] = 3;
        r100[InflateMode.SYNC.ordinal()] = 4;
    }
}
