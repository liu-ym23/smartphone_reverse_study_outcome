package com.bytedance.sdk.xbridge.cn;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "", "LYNX", "WEB", "WORKER", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PlatformType extends Enum<PlatformType> {
    public static final PlatformType LYNX = null;
    public static final PlatformType WEB = null;
    public static final PlatformType WORKER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlatformType[] f269800a = null;

    public static PlatformType valueOf(String r100) {
        return (PlatformType) a.a(PlatformType.class, r100);
    }

    public static PlatformType[] values() {
        return (PlatformType[]) f269800a.clone();
    }

    static {
        PlatformType r100 = new PlatformType("LYNX", 0);
        LYNX = r100;
        PlatformType r101 = new PlatformType("WEB", 1);
        WEB = r101;
        PlatformType r102 = new PlatformType("WORKER", 2);
        WORKER = r102;
        f269800a = new PlatformType[]{r100, r101, r102};
    }

    public PlatformType(String r100, int r101) {
        super(r100, r101);
    }
}
