package com.bytedance.live.artist.render;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f254849a = null;

    static {
        int[] r100 = new int[EntityState.values().length];
        f254849a = r100;
        r100[EntityState.Prepared.ordinal()] = 1;
        r100[EntityState.WaitDestroy.ordinal()] = 2;
        r100[EntityState.Destroyed.ordinal()] = 3;
    }
}
