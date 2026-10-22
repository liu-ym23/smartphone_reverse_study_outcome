package com.bytedance.locallife.cube.api.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/cube/api/config/CubeCreateThreadStrategy;", "", "ON_UI_THREAD", "ON_IO_THREAD", "ON_CALLER_THREAD", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum CubeCreateThreadStrategy extends Enum<CubeCreateThreadStrategy> {
    public static final CubeCreateThreadStrategy ON_CALLER_THREAD = null;
    public static final CubeCreateThreadStrategy ON_IO_THREAD = null;
    public static final CubeCreateThreadStrategy ON_UI_THREAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CubeCreateThreadStrategy[] f257183a = null;

    public static CubeCreateThreadStrategy valueOf(String r100) {
        return (CubeCreateThreadStrategy) a.a(CubeCreateThreadStrategy.class, r100);
    }

    public static CubeCreateThreadStrategy[] values() {
        return (CubeCreateThreadStrategy[]) f257183a.clone();
    }

    static {
        CubeCreateThreadStrategy r100 = new CubeCreateThreadStrategy("ON_UI_THREAD", 0);
        ON_UI_THREAD = r100;
        CubeCreateThreadStrategy r101 = new CubeCreateThreadStrategy("ON_IO_THREAD", 1);
        ON_IO_THREAD = r101;
        CubeCreateThreadStrategy r102 = new CubeCreateThreadStrategy("ON_CALLER_THREAD", 2);
        ON_CALLER_THREAD = r102;
        f257183a = new CubeCreateThreadStrategy[]{r100, r101, r102};
    }

    public CubeCreateThreadStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
