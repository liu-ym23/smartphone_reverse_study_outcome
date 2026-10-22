package com.bytedance.live.zdanmaku.data;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255837a = null;

    static {
        int[] r100 = new int[Danmaku.State.values().length];
        f255837a = r100;
        r100[Danmaku.State.CREATED.ordinal()] = 1;
        r100[Danmaku.State.PREPARE.ordinal()] = 2;
        r100[Danmaku.State.VISIBLE.ordinal()] = 3;
        r100[Danmaku.State.HIDDEN.ordinal()] = 4;
    }
}
