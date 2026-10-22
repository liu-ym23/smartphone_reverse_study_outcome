package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class g {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[androidx.lifecycle.Lifecycle.State.values().length];
        a = r0;
        r0[androidx.lifecycle.Lifecycle.State.DESTROYED.ordinal()] = 1;
        r0[androidx.lifecycle.Lifecycle.State.INITIALIZED.ordinal()] = 2;
        r0[androidx.lifecycle.Lifecycle.State.CREATED.ordinal()] = 3;
        r0[androidx.lifecycle.Lifecycle.State.STARTED.ordinal()] = 4;
        r0[androidx.lifecycle.Lifecycle.State.RESUMED.ordinal()] = 5;
        int[] r1 = new int[androidx.lifecycle.Lifecycle.Event.values().length];
        b = r1;
        r1[androidx.lifecycle.Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r1[androidx.lifecycle.Lifecycle.Event.ON_START.ordinal()] = 2;
        r1[androidx.lifecycle.Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r1[androidx.lifecycle.Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r1[androidx.lifecycle.Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r1[androidx.lifecycle.Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        r1[androidx.lifecycle.Lifecycle.Event.ON_ANY.ordinal()] = 7;
        int[] r2 = new int[Lifecycle.Event.values().length];
        c = r2;
        r2[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r2[Lifecycle.Event.ON_START.ordinal()] = 2;
        r2[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r2[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r2[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r2[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        r2[Lifecycle.Event.ON_ANY.ordinal()] = 7;
    }
}
