package com.bytedance.assem.arch.service;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f193043a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f193044b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f193045c = null;

    static {
        int[] r100 = new int[Lifecycle.Event.values().length];
        f193043a = r100;
        Lifecycle.Event r101 = Lifecycle.Event.ON_DESTROY;
        r100[r101.ordinal()] = 1;
        int[] r102 = new int[Lifecycle.Event.values().length];
        f193044b = r102;
        r102[r101.ordinal()] = 1;
        int[] r103 = new int[Lifecycle.Event.values().length];
        f193045c = r103;
        r103[r101.ordinal()] = 1;
    }
}
