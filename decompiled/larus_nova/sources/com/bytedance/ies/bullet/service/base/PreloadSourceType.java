package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/PreloadSourceType;", "", "GECKO", "CDN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PreloadSourceType extends Enum<PreloadSourceType> {
    public static final PreloadSourceType CDN = null;
    public static final PreloadSourceType GECKO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadSourceType[] f247776a = null;

    public static PreloadSourceType valueOf(String r100) {
        return (PreloadSourceType) r27.a.a(PreloadSourceType.class, r100);
    }

    public static PreloadSourceType[] values() {
        return (PreloadSourceType[]) f247776a.clone();
    }

    static {
        PreloadSourceType r100 = new PreloadSourceType("GECKO", 0);
        GECKO = r100;
        PreloadSourceType r101 = new PreloadSourceType("CDN", 1);
        CDN = r101;
        f247776a = new PreloadSourceType[]{r100, r101};
    }

    public PreloadSourceType(String r100, int r101) {
        super(r100, r101);
    }
}
