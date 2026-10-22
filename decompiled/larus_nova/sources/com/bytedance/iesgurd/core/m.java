package com.bytedance.iesgurd.core;

import com.bytedance.geckox.GeckoGlobalConfig;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f250674a = null;

    static {
        int[] r100 = new int[GeckoGlobalConfig.ENVType.values().length];
        f250674a = r100;
        r100[GeckoGlobalConfig.ENVType.DEV.ordinal()] = 1;
        r100[GeckoGlobalConfig.ENVType.PROD.ordinal()] = 2;
        r100[GeckoGlobalConfig.ENVType.BOE.ordinal()] = 3;
    }
}
