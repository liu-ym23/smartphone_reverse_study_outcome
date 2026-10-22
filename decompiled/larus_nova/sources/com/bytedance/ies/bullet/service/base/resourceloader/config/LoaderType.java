package com.bytedance.ies.bullet.service.base.resourceloader.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/LoaderType;", "", "GECKO", "BUILTIN", "CDN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum LoaderType extends Enum<LoaderType> {
    public static final LoaderType BUILTIN = null;
    public static final LoaderType CDN = null;
    public static final LoaderType GECKO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoaderType[] f247902a = null;

    public static LoaderType valueOf(String r100) {
        return (LoaderType) a.a(LoaderType.class, r100);
    }

    public static LoaderType[] values() {
        return (LoaderType[]) f247902a.clone();
    }

    static {
        LoaderType r100 = new LoaderType("GECKO", 0);
        GECKO = r100;
        LoaderType r101 = new LoaderType("BUILTIN", 1);
        BUILTIN = r101;
        LoaderType r102 = new LoaderType("CDN", 2);
        CDN = r102;
        f247902a = new LoaderType[]{r100, r101, r102};
    }

    public LoaderType(String r100, int r101) {
        super(r100, r101);
    }
}
