package com.ss.ugc.effectplatform.cache;

import com.ss.ugc.effectplatform.model.algorithm.FetchModelType;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f457270a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f457271b = null;

    static {
        int[] r100 = new int[FetchModelType.values().length];
        f457270a = r100;
        FetchModelType r101 = FetchModelType.ORIGIN;
        r100[r101.ordinal()] = 1;
        FetchModelType r102 = FetchModelType.ZIP;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[FetchModelType.values().length];
        f457271b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
