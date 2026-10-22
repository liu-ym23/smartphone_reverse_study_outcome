package com.bytedance.iesgurd.loader;

import com.bytedance.iesgurd.core.BlockType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f250757a = null;

    static {
        int[] r100 = new int[BlockType.values().length];
        f250757a = r100;
        r100[BlockType.LAZY_UPDATE.ordinal()] = 1;
        r100[BlockType.CLEAN_BLOCKLIST.ordinal()] = 2;
        r100[BlockType.LOW_STORAGE.ordinal()] = 3;
        r100[BlockType.OCCASION_UPDATE.ordinal()] = 4;
    }
}
