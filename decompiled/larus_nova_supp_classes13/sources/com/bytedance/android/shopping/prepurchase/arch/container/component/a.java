package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[Lifecycle.Event.values().length];
        a = r0;
        r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r0[Lifecycle.Event.ON_START.ordinal()] = 2;
        r0[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r0[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        r0[Lifecycle.Event.ON_ANY.ordinal()] = 7;
    }
}
