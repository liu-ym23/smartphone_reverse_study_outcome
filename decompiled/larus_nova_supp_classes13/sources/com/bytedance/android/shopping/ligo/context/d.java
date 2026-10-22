package com.bytedance.android.shopping.ligo.context;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class d {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[Lifecycle.Event.values().length];
        a = r0;
        r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
        r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
        int[] r1 = new int[Lifecycle.Event.values().length];
        b = r1;
        r1[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r1[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
    }
}
