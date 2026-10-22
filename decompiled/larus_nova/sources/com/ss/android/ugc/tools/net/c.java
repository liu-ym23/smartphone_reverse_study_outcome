package com.ss.android.ugc.tools.net;

/* JADX INFO: loaded from: classes40.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f454842a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f454843b = null;

    static {
        int[] r100 = new int[NetworkState.values().length];
        f454842a = r100;
        NetworkState r101 = NetworkState.NOT_AVAILABLE;
        r100[r101.ordinal()] = 1;
        NetworkState r102 = NetworkState.FAKE;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[NetworkState.values().length];
        f454843b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        int[] r104 = new int[NetworkState.values().length];
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
    }
}
