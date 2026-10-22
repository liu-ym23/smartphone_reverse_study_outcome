package com.bytedance.jedi.ext.adapter.internal;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f251031a = null;

    static {
        int[] r100 = new int[Lifecycle.State.values().length];
        f251031a = r100;
        r100[Lifecycle.State.INITIALIZED.ordinal()] = 1;
        r100[Lifecycle.State.DESTROYED.ordinal()] = 2;
        r100[Lifecycle.State.CREATED.ordinal()] = 3;
        r100[Lifecycle.State.STARTED.ordinal()] = 4;
        r100[Lifecycle.State.RESUMED.ordinal()] = 5;
    }
}
