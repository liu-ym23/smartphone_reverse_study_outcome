package com.bytedance.assem.arch.extensions;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f192921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f192922b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f192923c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f192924d = null;

    static {
        int[] r100 = new int[Lifecycle.Event.values().length];
        f192921a = r100;
        Lifecycle.Event r101 = Lifecycle.Event.ON_DESTROY;
        r100[r101.ordinal()] = 1;
        int[] r102 = new int[Lifecycle.Event.values().length];
        f192922b = r102;
        r102[r101.ordinal()] = 1;
        int[] r103 = new int[Lifecycle.Event.values().length];
        f192923c = r103;
        r103[r101.ordinal()] = 1;
        int[] r104 = new int[Lifecycle.Event.values().length];
        f192924d = r104;
        r104[r101.ordinal()] = 1;
    }
}
