package com.bytedance.assem.arch.core;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class e {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[Lifecycle.State.values().length];
        a = r0;
        r0[Lifecycle.State.CREATED.ordinal()] = 1;
        r0[Lifecycle.State.STARTED.ordinal()] = 2;
        r0[Lifecycle.State.RESUMED.ordinal()] = 3;
        r0[Lifecycle.State.DESTROYED.ordinal()] = 4;
        int[] r1 = new int[Lifecycle.Event.values().length];
        b = r1;
        r1[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r1[Lifecycle.Event.ON_START.ordinal()] = 2;
        r1[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r1[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r1[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r1[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
    }
}
