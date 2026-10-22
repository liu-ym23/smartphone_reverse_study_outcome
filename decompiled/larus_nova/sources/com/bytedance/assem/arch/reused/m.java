package com.bytedance.assem.arch.reused;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f193027a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f193028b = null;

    static {
        int[] r100 = new int[Lifecycle.State.values().length];
        f193027a = r100;
        Lifecycle.State r101 = Lifecycle.State.CREATED;
        r100[r101.ordinal()] = 1;
        Lifecycle.State r102 = Lifecycle.State.STARTED;
        r100[r102.ordinal()] = 2;
        Lifecycle.State r103 = Lifecycle.State.RESUMED;
        r100[r103.ordinal()] = 3;
        Lifecycle.State r104 = Lifecycle.State.DESTROYED;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[Lifecycle.State.values().length];
        f193028b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
        r105[Lifecycle.State.INITIALIZED.ordinal()] = 5;
    }
}
