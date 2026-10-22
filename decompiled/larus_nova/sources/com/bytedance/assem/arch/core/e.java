package com.bytedance.assem.arch.core;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f192891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f192892b = null;

    static {
        int[] r100 = new int[Lifecycle.State.values().length];
        f192891a = r100;
        r100[Lifecycle.State.CREATED.ordinal()] = 1;
        r100[Lifecycle.State.STARTED.ordinal()] = 2;
        r100[Lifecycle.State.RESUMED.ordinal()] = 3;
        r100[Lifecycle.State.DESTROYED.ordinal()] = 4;
        int[] r101 = new int[Lifecycle.Event.values().length];
        f192892b = r101;
        r101[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r101[Lifecycle.Event.ON_START.ordinal()] = 2;
        r101[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r101[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r101[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r101[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
    }
}
