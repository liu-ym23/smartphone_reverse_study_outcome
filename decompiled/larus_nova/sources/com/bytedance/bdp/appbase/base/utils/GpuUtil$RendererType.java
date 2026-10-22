package com.bytedance.bdp.appbase.base.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/bdp/appbase/base/utils/GpuUtil$RendererType", "", "Lcom/bytedance/bdp/appbase/base/utils/GpuUtil$RendererType;", "ADRENO", "MALI", "MEDIATEK", "UNKNOWN", "bdp-appbase_release"}, k = 1, mv = {1, 4, 0})
public final enum GpuUtil$RendererType extends Enum<GpuUtil$RendererType> {
    public static final GpuUtil$RendererType ADRENO = null;
    public static final GpuUtil$RendererType MALI = null;
    public static final GpuUtil$RendererType MEDIATEK = null;
    public static final GpuUtil$RendererType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GpuUtil$RendererType[] f200653a = null;

    static {
        GpuUtil$RendererType r100 = new GpuUtil$RendererType("ADRENO", 0);
        ADRENO = r100;
        GpuUtil$RendererType r101 = new GpuUtil$RendererType("MALI", 1);
        MALI = r101;
        GpuUtil$RendererType r102 = new GpuUtil$RendererType("MEDIATEK", 2);
        MEDIATEK = r102;
        GpuUtil$RendererType r103 = new GpuUtil$RendererType("UNKNOWN", 3);
        UNKNOWN = r103;
        f200653a = new GpuUtil$RendererType[]{r100, r101, r102, r103};
    }

    public static GpuUtil$RendererType valueOf(String r100) {
        return (GpuUtil$RendererType) r27.a.a(GpuUtil$RendererType.class, r100);
    }

    public static GpuUtil$RendererType[] values() {
        return (GpuUtil$RendererType[]) f200653a.clone();
    }

    public GpuUtil$RendererType(String r100, int r101) {
        super(r100, r101);
    }
}
