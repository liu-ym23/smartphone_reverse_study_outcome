package com.bytedance.live.livelink.kmp.impl.base.statistic;

import com.bytedance.live.livelink.kmp.api.base.config.Character;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255328a = null;

    static {
        int[] r100 = new int[Character.values().length];
        f255328a = r100;
        r100[Character.ANCHOR.ordinal()] = 1;
        r100[Character.GUEST.ordinal()] = 2;
    }
}
