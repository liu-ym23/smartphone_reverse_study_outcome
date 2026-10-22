package com.bytedance.frameworks.baselib.netx.cache;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/frameworks/baselib/netx/cache/CacheSource;", "", "FROM_NETWORK", "FROM_DISK", "netx_release"}, k = 1, mv = {1, 4, 1})
public final enum CacheSource extends Enum<CacheSource> {
    public static final CacheSource FROM_DISK = null;
    public static final CacheSource FROM_NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheSource[] f244800a = null;

    static {
        CacheSource r100 = new CacheSource("FROM_NETWORK", 0);
        FROM_NETWORK = r100;
        CacheSource r101 = new CacheSource("FROM_DISK", 1);
        FROM_DISK = r101;
        f244800a = new CacheSource[]{r100, r101};
    }

    public static CacheSource valueOf(String r100) {
        return (CacheSource) a.a(CacheSource.class, r100);
    }

    public static CacheSource[] values() {
        return (CacheSource[]) f244800a.clone();
    }

    public CacheSource(String r100, int r101) {
        super(r100, r101);
    }
}
