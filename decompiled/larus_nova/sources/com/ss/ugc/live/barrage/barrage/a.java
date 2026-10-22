package com.ss.ugc.live.barrage.barrage;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f458083a = null;

    static {
        int[] r100 = new int[AbsBarrage.State.values().length];
        f458083a = r100;
        r100[AbsBarrage.State.CREATED.ordinal()] = 1;
        r100[AbsBarrage.State.ADDED.ordinal()] = 2;
        r100[AbsBarrage.State.PREPARING.ordinal()] = 3;
        r100[AbsBarrage.State.VISIBLE.ordinal()] = 4;
        r100[AbsBarrage.State.HIDDEN.ordinal()] = 5;
    }
}
