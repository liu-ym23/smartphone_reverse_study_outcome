package com.bytedance.timonbase.scene;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f270885a = null;

    static {
        int[] r100 = new int[Lifecycle.Event.values().length];
        f270885a = r100;
        r100[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r100[Lifecycle.Event.ON_START.ordinal()] = 2;
        r100[Lifecycle.Event.ON_STOP.ordinal()] = 3;
    }
}
