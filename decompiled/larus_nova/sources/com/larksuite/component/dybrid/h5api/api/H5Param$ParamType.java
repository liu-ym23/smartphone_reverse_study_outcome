package com.larksuite.component.dybrid.h5api.api;

import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum H5Param$ParamType extends Enum<H5Param$ParamType> {
    public static final H5Param$ParamType BOOLEAN = null;
    public static final H5Param$ParamType DOUBLE = null;
    public static final H5Param$ParamType INT = null;
    public static final H5Param$ParamType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ H5Param$ParamType[] f283990a = null;

    static {
        H5Param$ParamType r100 = new H5Param$ParamType("BOOLEAN", 0);
        BOOLEAN = r100;
        H5Param$ParamType r101 = new H5Param$ParamType("STRING", 1);
        STRING = r101;
        H5Param$ParamType r102 = new H5Param$ParamType("INT", 2);
        INT = r102;
        H5Param$ParamType r103 = new H5Param$ParamType("DOUBLE", 3);
        DOUBLE = r103;
        f283990a = new H5Param$ParamType[]{r100, r101, r102, r103};
    }

    public static H5Param$ParamType[] values() {
        return (H5Param$ParamType[]) f283990a.clone();
    }

    public static H5Param$ParamType valueOf(String r100) {
        return (H5Param$ParamType) a.a(H5Param$ParamType.class, r100);
    }

    public H5Param$ParamType(String r100, int r101) {
        super(r100, r101);
    }
}
