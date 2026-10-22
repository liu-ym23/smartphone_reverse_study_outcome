package com.bytedance.locallife.cube.api.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/cube/api/config/LoadType;", "", "OLD_PRELOAD", "NEW_PRELOAD_WITHOUT_DATA", "NEW_PRELOAD_WITH_DATA", "OLD_PRELOAD_WITH_DATA", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum LoadType extends Enum<LoadType> {
    public static final LoadType NEW_PRELOAD_WITHOUT_DATA = null;
    public static final LoadType NEW_PRELOAD_WITH_DATA = null;
    public static final LoadType OLD_PRELOAD = null;
    public static final LoadType OLD_PRELOAD_WITH_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadType[] f257184a = null;

    public static LoadType valueOf(String r100) {
        return (LoadType) a.a(LoadType.class, r100);
    }

    public static LoadType[] values() {
        return (LoadType[]) f257184a.clone();
    }

    static {
        LoadType r100 = new LoadType("OLD_PRELOAD", 0);
        OLD_PRELOAD = r100;
        LoadType r101 = new LoadType("NEW_PRELOAD_WITHOUT_DATA", 1);
        NEW_PRELOAD_WITHOUT_DATA = r101;
        LoadType r102 = new LoadType("NEW_PRELOAD_WITH_DATA", 2);
        NEW_PRELOAD_WITH_DATA = r102;
        LoadType r103 = new LoadType("OLD_PRELOAD_WITH_DATA", 3);
        OLD_PRELOAD_WITH_DATA = r103;
        f257184a = new LoadType[]{r100, r101, r102, r103};
    }

    public LoadType(String r100, int r101) {
        super(r100, r101);
    }
}
