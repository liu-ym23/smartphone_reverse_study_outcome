package com.bytedance.ug.sdk.luckydog.api.depend.container.model;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType H5 = null;
    public static final ContainerType LYNX = null;
    public static final ContainerType LYNX_POPUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f271568a = null;

    static {
        ContainerType r100 = new ContainerType("H5", 0);
        H5 = r100;
        ContainerType r101 = new ContainerType("LYNX", 1);
        LYNX = r101;
        ContainerType r102 = new ContainerType("LYNX_POPUP", 2);
        LYNX_POPUP = r102;
        f271568a = new ContainerType[]{r100, r101, r102};
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f271568a.clone();
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) a.a(ContainerType.class, r100);
    }

    public ContainerType(String r100, int r101) {
        super(r100, r101);
    }
}
