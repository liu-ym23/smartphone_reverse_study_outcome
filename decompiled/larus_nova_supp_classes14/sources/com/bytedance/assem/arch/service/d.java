package com.bytedance.assem.arch.service;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[Lifecycle.Event.values().length];
        a = r0;
        Lifecycle.Event r1 = Lifecycle.Event.ON_DESTROY;
        r0[r1.ordinal()] = 1;
        int[] r2 = new int[Lifecycle.Event.values().length];
        b = r2;
        r2[r1.ordinal()] = 1;
        int[] r3 = new int[Lifecycle.Event.values().length];
        c = r3;
        r3[r1.ordinal()] = 1;
    }
}
