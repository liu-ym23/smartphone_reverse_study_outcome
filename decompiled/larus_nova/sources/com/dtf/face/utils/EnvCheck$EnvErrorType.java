package com.dtf.face.utils;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum EnvCheck$EnvErrorType extends Enum<EnvCheck$EnvErrorType> {
    public static final EnvCheck$EnvErrorType ENV_ERROR_LOW_OS = null;
    public static final EnvCheck$EnvErrorType ENV_ERROR_NO_FRONT_CAMERA = null;
    public static final EnvCheck$EnvErrorType ENV_ERROR_NO_PERMISSION_OF_CAMERA = null;
    public static final EnvCheck$EnvErrorType ENV_ERROR_UNSUPPORTED_CPU = null;
    public static final EnvCheck$EnvErrorType ENV_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnvCheck$EnvErrorType[] f273691a = null;

    static {
        EnvCheck$EnvErrorType r100 = new EnvCheck$EnvErrorType("ENV_SUCCESS", 0);
        ENV_SUCCESS = r100;
        EnvCheck$EnvErrorType r101 = new EnvCheck$EnvErrorType("ENV_ERROR_LOW_OS", 1);
        ENV_ERROR_LOW_OS = r101;
        EnvCheck$EnvErrorType r102 = new EnvCheck$EnvErrorType("ENV_ERROR_UNSUPPORTED_CPU", 2);
        ENV_ERROR_UNSUPPORTED_CPU = r102;
        EnvCheck$EnvErrorType r103 = new EnvCheck$EnvErrorType("ENV_ERROR_NO_PERMISSION_OF_CAMERA", 3);
        ENV_ERROR_NO_PERMISSION_OF_CAMERA = r103;
        EnvCheck$EnvErrorType r104 = new EnvCheck$EnvErrorType("ENV_ERROR_NO_FRONT_CAMERA", 4);
        ENV_ERROR_NO_FRONT_CAMERA = r104;
        f273691a = new EnvCheck$EnvErrorType[]{r100, r101, r102, r103, r104};
    }

    public static EnvCheck$EnvErrorType[] values() {
        return (EnvCheck$EnvErrorType[]) f273691a.clone();
    }

    public static EnvCheck$EnvErrorType valueOf(String r100) {
        return (EnvCheck$EnvErrorType) a.a(EnvCheck$EnvErrorType.class, r100);
    }

    public EnvCheck$EnvErrorType(String r100, int r101) {
        super(r100, r101);
    }
}
