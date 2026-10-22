package com.bytedance.forest.chain.fetchers;

import com.bytedance.forest.model.ResourceFrom2;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f244201a = null;

    static {
        int[] r100 = new int[ResourceFrom2.values().length];
        f244201a = r100;
        r100[ResourceFrom2.CDN.ordinal()] = 1;
        r100[ResourceFrom2.CDN_CACHE.ordinal()] = 2;
        r100[ResourceFrom2.GECKO.ordinal()] = 3;
        r100[ResourceFrom2.GECKO_UPDATE.ordinal()] = 4;
        r100[ResourceFrom2.GECKO_OFFLINE_CDN.ordinal()] = 5;
        r100[ResourceFrom2.BUILTIN.ordinal()] = 6;
    }
}
