package com.bytedance.assem.arch.reused;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class m {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[Lifecycle.State.values().length];
        a = r0;
        Lifecycle.State r1 = Lifecycle.State.CREATED;
        r0[r1.ordinal()] = 1;
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        r0[r2.ordinal()] = 2;
        Lifecycle.State r4 = Lifecycle.State.RESUMED;
        r0[r4.ordinal()] = 3;
        Lifecycle.State r6 = Lifecycle.State.DESTROYED;
        r0[r6.ordinal()] = 4;
        int[] r3 = new int[Lifecycle.State.values().length];
        b = r3;
        r3[r1.ordinal()] = 1;
        r3[r2.ordinal()] = 2;
        r3[r4.ordinal()] = 3;
        r3[r6.ordinal()] = 4;
        r3[Lifecycle.State.INITIALIZED.ordinal()] = 5;
    }
}
