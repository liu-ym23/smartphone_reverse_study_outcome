package com.bytedance.forest.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/forest/utils/PoolType;", "", "Preload", "Normal", "Manger", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum PoolType extends Enum<PoolType> {
    public static final PoolType Manger = null;
    public static final PoolType Normal = null;
    public static final PoolType Preload = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoolType[] f244498a = null;

    static {
        PoolType r100 = new PoolType("Preload", 0);
        Preload = r100;
        PoolType r101 = new PoolType("Normal", 1);
        Normal = r101;
        PoolType r102 = new PoolType("Manger", 2);
        Manger = r102;
        f244498a = new PoolType[]{r100, r101, r102};
    }

    public static PoolType valueOf(String r100) {
        return (PoolType) r27.a.a(PoolType.class, r100);
    }

    public static PoolType[] values() {
        return (PoolType[]) f244498a.clone();
    }

    public PoolType(String r100, int r101) {
        super(r100, r101);
    }
}
