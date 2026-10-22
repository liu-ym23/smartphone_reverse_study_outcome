package com.bytedance.ies.bullet.service.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/CustomLoaderType;", "", "HIGH", "LOW", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum CustomLoaderType extends Enum<CustomLoaderType> {
    public static final CustomLoaderType HIGH = null;
    public static final CustomLoaderType LOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomLoaderType[] f247772a = null;

    public static CustomLoaderType valueOf(String r100) {
        return (CustomLoaderType) r27.a.a(CustomLoaderType.class, r100);
    }

    public static CustomLoaderType[] values() {
        return (CustomLoaderType[]) f247772a.clone();
    }

    static {
        CustomLoaderType r100 = new CustomLoaderType("HIGH", 0);
        HIGH = r100;
        CustomLoaderType r101 = new CustomLoaderType("LOW", 1);
        LOW = r101;
        f247772a = new CustomLoaderType[]{r100, r101};
    }

    public CustomLoaderType(String r100, int r101) {
        super(r100, r101);
    }
}
