package com.bytedance.android.shopping.store.hybridproduct;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[LoadStatus.values().length];
        a = r0;
        r0[LoadStatus.Initialize.ordinal()] = 1;
        r0[LoadStatus.InitializeSuccess.ordinal()] = 2;
        r0[LoadStatus.InitializeError.ordinal()] = 3;
        r0[LoadStatus.InitializeEmpty.ordinal()] = 4;
        int[] r1 = new int[Lifecycle.Event.values().length];
        b = r1;
        r1[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
        r1[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
        r1[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
    }
}
