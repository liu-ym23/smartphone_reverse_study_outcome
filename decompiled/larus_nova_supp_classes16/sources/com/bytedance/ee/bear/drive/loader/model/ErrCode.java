package com.bytedance.ee.bear.drive.loader.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum ErrCode extends Enum<ErrCode> {
    public static final ErrCode CACHE_FILE_MODEL_NOT_FOUND = null;
    public static final ErrCode CAC_PREVIEW_CONTROL = null;
    public static final ErrCode COPPING = null;
    public static final ErrCode COPY_FAILED = null;
    public static final ErrCode COPY_TIMEOUT = null;
    public static final ErrCode DEFAULT = null;
    public static final ErrCode DLP_EXTERNAL_CHECKING = null;
    public static final ErrCode DLP_EXTERNAL_SENSATIVE = null;
    public static final ErrCode DLP_INTERANL_CHECKING = null;
    public static final ErrCode DLP_INTERANL_SENSATIVE = null;
    public static final ErrCode DLP_UPLOAD_CONTROL = null;
    public static final ErrCode DRIVE_DOWNLOAD_FILE_OVER_SIZE = null;
    public static final ErrCode DRIVE_FILE_ENCRYPTED = null;
    public static final ErrCode DRIVE_FILE_NOT_SUPPORT_PREVIEW = null;
    public static final ErrCode DRIVE_FILE_OVER_SIZE = null;
    public static final ErrCode DRIVE_FILE_ZERO_SIZE = null;
    public static final ErrCode ENCRYPTION_KEY_DELETED = null;
    public static final ErrCode ENCRYPTION_KEY_NOT_SUPPORT = null;
    public static final ErrCode FILE_DATA_VERSION_CHANGED = null;
    public static final ErrCode FILE_NOT_CHANGED = null;
    public static final ErrCode FILE_NOT_FOUND = null;
    public static final ErrCode MAILCE_FILE = null;
    public static final ErrCode MANUAL_CACHE_NEED_WIFI = null;
    public static final ErrCode NO_NETWORK = null;
    public static final ErrCode OWNER_DELETED_FILE = null;
    public static final ErrCode PERMISSION_DENIED = null;
    public static final ErrCode PERM_ADMIN_CONTROL = null;
    public static final ErrCode POLICY_DENIED = null;
    public static final ErrCode PRELOAD_SIZE_TOO_LARGE = null;
    public static final ErrCode PREVIEW_DOWNGRADE_TO_SIMILAR = null;
    public static final ErrCode PREVIEW_FAILED_DO_NOT_DOWNGRADE = null;
    public static final ErrCode PROCESSOR_CACHE_MISS = null;
    public static final ErrCode REQUEST_FILE_INFO_EXP = null;
    public static final ErrCode REQUEST_PREVIEW_URL_EXP = null;
    public static final ErrCode REQUEST_TRANSFORM_CANCEL_EXP = null;
    public static final ErrCode REQUEST_TRANSFORM_FILE_ENCRYPTION = null;
    public static final ErrCode REQUEST_TRANSFORM_SERVER_EXP = null;
    public static final ErrCode REQUEST_TRANSFORM_SHUTDOWN_EXP = null;
    public static final ErrCode REQUEST_TRANSFORM_UNKNOW_EXP = null;
    public static final ErrCode RUST_DOWNLOAD_FAIL = null;
    public static final ErrCode RUST_NOT_LOGIN = null;
    public static final ErrCode RUST_SUBMIT_ERROR = null;
    public static final ErrCode SHEET_PREVIEW_EXP = null;
    public static final ErrCode SLIDES_PREVIEW_EXP = null;
    public static final ErrCode STATIC_RESOURCE_FROZEN_BY_ADMIN = null;
    public static final ErrCode STATIC_RESOURCE_SHREDDED_BY_ADMIN = null;
    public static final ErrCode THIRD_SECRET_FILE = null;
    public static final ErrCode TNS_BLOCK_VIEW = null;
    public static final ErrCode VIDEO_MP4_ERROR = null;
    public static final ErrCode WPS_PREVIEW_EXP = null;
    public static final ErrCode WPS_PREVIEW_GET_ACCESS_TOKEN_EDITOR_MEMORY_OVER_LIMIT = null;
    public static final ErrCode WPS_PREVIEW_GET_ACCESS_TOKEN_EXP = null;
    public static final ErrCode WPS_PREVIEW_GET_ACCESS_TOKEN_TENANT_MEMORY_OVER_LIMIT = null;
    public static final ErrCode WPS_PREVIEW_GET_ACCESS_TOKEN_USER_MEMORY_OVER_LIMIT = null;
    public static final /* synthetic */ ErrCode[] a = null;
    private Throwable cause;

    static {
        ErrCode r0 = new ErrCode("DEFAULT", 0);
        DEFAULT = r0;
        ErrCode r1 = new ErrCode("REQUEST_FILE_INFO_EXP", 1);
        REQUEST_FILE_INFO_EXP = r1;
        ErrCode r3 = new ErrCode("FILE_NOT_FOUND", 2);
        FILE_NOT_FOUND = r3;
        ErrCode r5 = new ErrCode("OWNER_DELETED_FILE", 3);
        OWNER_DELETED_FILE = r5;
        ErrCode r7 = new ErrCode("PERMISSION_DENIED", 4);
        PERMISSION_DENIED = r7;
        ErrCode r9 = new ErrCode("POLICY_DENIED", 5);
        POLICY_DENIED = r9;
        ErrCode r11 = new ErrCode("STATIC_RESOURCE_FROZEN_BY_ADMIN", 6);
        STATIC_RESOURCE_FROZEN_BY_ADMIN = r11;
        ErrCode r13 = new ErrCode("STATIC_RESOURCE_SHREDDED_BY_ADMIN", 7);
        STATIC_RESOURCE_SHREDDED_BY_ADMIN = r13;
        ErrCode r16 = new ErrCode("COPY_TIMEOUT", 8);
        COPY_TIMEOUT = r16;
        ErrCode r14 = new ErrCode("COPY_FAILED", 9);
        COPY_FAILED = r14;
        ErrCode r12 = new ErrCode("REQUEST_PREVIEW_URL_EXP", 10);
        REQUEST_PREVIEW_URL_EXP = r12;
        ErrCode r10 = new ErrCode("REQUEST_TRANSFORM_UNKNOW_EXP", 11);
        REQUEST_TRANSFORM_UNKNOW_EXP = r10;
        ErrCode r8 = new ErrCode("REQUEST_TRANSFORM_SERVER_EXP", 12);
        REQUEST_TRANSFORM_SERVER_EXP = r8;
        ErrCode r6 = new ErrCode("REQUEST_TRANSFORM_CANCEL_EXP", 13);
        REQUEST_TRANSFORM_CANCEL_EXP = r6;
        ErrCode r4 = new ErrCode("REQUEST_TRANSFORM_SHUTDOWN_EXP", 14);
        REQUEST_TRANSFORM_SHUTDOWN_EXP = r4;
        ErrCode r2 = new ErrCode("REQUEST_TRANSFORM_FILE_ENCRYPTION", 15);
        REQUEST_TRANSFORM_FILE_ENCRYPTION = r2;
        ErrCode r17 = new ErrCode("DRIVE_FILE_NOT_SUPPORT_PREVIEW", 16);
        DRIVE_FILE_NOT_SUPPORT_PREVIEW = r17;
        ErrCode r18 = new ErrCode("DRIVE_FILE_OVER_SIZE", 17);
        DRIVE_FILE_OVER_SIZE = r18;
        ErrCode r19 = new ErrCode("DRIVE_FILE_ZERO_SIZE", 18);
        DRIVE_FILE_ZERO_SIZE = r19;
        ErrCode r20 = new ErrCode("DRIVE_FILE_ENCRYPTED", 19);
        DRIVE_FILE_ENCRYPTED = r20;
        ErrCode r21 = new ErrCode("RUST_SUBMIT_ERROR", 20);
        RUST_SUBMIT_ERROR = r21;
        ErrCode r22 = new ErrCode("RUST_DOWNLOAD_FAIL", 21);
        RUST_DOWNLOAD_FAIL = r22;
        ErrCode r23 = new ErrCode("RUST_NOT_LOGIN", 22);
        RUST_NOT_LOGIN = r23;
        ErrCode r24 = new ErrCode("CACHE_FILE_MODEL_NOT_FOUND", 23);
        CACHE_FILE_MODEL_NOT_FOUND = r24;
        ErrCode r26 = new ErrCode("FILE_DATA_VERSION_CHANGED", 24);
        FILE_DATA_VERSION_CHANGED = r26;
        ErrCode r27 = new ErrCode("FILE_NOT_CHANGED", 25);
        FILE_NOT_CHANGED = r27;
        ErrCode r28 = new ErrCode("PRELOAD_SIZE_TOO_LARGE", 26);
        PRELOAD_SIZE_TOO_LARGE = r28;
        ErrCode r29 = new ErrCode("MANUAL_CACHE_NEED_WIFI", 27);
        MANUAL_CACHE_NEED_WIFI = r29;
        ErrCode r30 = new ErrCode("PROCESSOR_CACHE_MISS", 28);
        PROCESSOR_CACHE_MISS = r30;
        ErrCode r31 = new ErrCode("COPPING", 29);
        COPPING = r31;
        ErrCode r32 = new ErrCode("DRIVE_DOWNLOAD_FILE_OVER_SIZE", 30);
        DRIVE_DOWNLOAD_FILE_OVER_SIZE = r32;
        ErrCode r33 = new ErrCode("PREVIEW_DOWNGRADE_TO_SIMILAR", 31);
        PREVIEW_DOWNGRADE_TO_SIMILAR = r33;
        ErrCode r34 = new ErrCode("WPS_PREVIEW_EXP", 32);
        WPS_PREVIEW_EXP = r34;
        ErrCode r36 = new ErrCode("WPS_PREVIEW_GET_ACCESS_TOKEN_USER_MEMORY_OVER_LIMIT", 33);
        WPS_PREVIEW_GET_ACCESS_TOKEN_USER_MEMORY_OVER_LIMIT = r36;
        ErrCode r37 = new ErrCode("WPS_PREVIEW_GET_ACCESS_TOKEN_TENANT_MEMORY_OVER_LIMIT", 34);
        WPS_PREVIEW_GET_ACCESS_TOKEN_TENANT_MEMORY_OVER_LIMIT = r37;
        ErrCode r38 = new ErrCode("WPS_PREVIEW_GET_ACCESS_TOKEN_EDITOR_MEMORY_OVER_LIMIT", 35);
        WPS_PREVIEW_GET_ACCESS_TOKEN_EDITOR_MEMORY_OVER_LIMIT = r38;
        ErrCode r39 = new ErrCode("WPS_PREVIEW_GET_ACCESS_TOKEN_EXP", 36);
        WPS_PREVIEW_GET_ACCESS_TOKEN_EXP = r39;
        ErrCode r40 = new ErrCode("NO_NETWORK", 37);
        NO_NETWORK = r40;
        ErrCode r41 = new ErrCode("PERM_ADMIN_CONTROL", 38);
        PERM_ADMIN_CONTROL = r41;
        ErrCode r42 = new ErrCode("SHEET_PREVIEW_EXP", 39);
        SHEET_PREVIEW_EXP = r42;
        ErrCode r43 = new ErrCode("SLIDES_PREVIEW_EXP", 40);
        SLIDES_PREVIEW_EXP = r43;
        ErrCode r44 = new ErrCode("CAC_PREVIEW_CONTROL", 41);
        CAC_PREVIEW_CONTROL = r44;
        ErrCode r46 = new ErrCode("TNS_BLOCK_VIEW", 42);
        TNS_BLOCK_VIEW = r46;
        ErrCode r47 = new ErrCode("VIDEO_MP4_ERROR", 43);
        VIDEO_MP4_ERROR = r47;
        ErrCode r48 = new ErrCode("DLP_INTERANL_CHECKING", 44);
        DLP_INTERANL_CHECKING = r48;
        ErrCode r49 = new ErrCode("DLP_EXTERNAL_CHECKING", 45);
        DLP_EXTERNAL_CHECKING = r49;
        ErrCode r50 = new ErrCode("DLP_INTERANL_SENSATIVE", 46);
        DLP_INTERANL_SENSATIVE = r50;
        ErrCode r51 = new ErrCode("DLP_EXTERNAL_SENSATIVE", 47);
        DLP_EXTERNAL_SENSATIVE = r51;
        ErrCode r52 = new ErrCode("MAILCE_FILE", 48);
        MAILCE_FILE = r52;
        ErrCode r53 = new ErrCode("ENCRYPTION_KEY_DELETED", 49);
        ENCRYPTION_KEY_DELETED = r53;
        ErrCode r54 = new ErrCode("ENCRYPTION_KEY_NOT_SUPPORT", 50);
        ENCRYPTION_KEY_NOT_SUPPORT = r54;
        ErrCode r56 = new ErrCode("DLP_UPLOAD_CONTROL", 51);
        DLP_UPLOAD_CONTROL = r56;
        ErrCode r57 = new ErrCode("PREVIEW_FAILED_DO_NOT_DOWNGRADE", 52);
        PREVIEW_FAILED_DO_NOT_DOWNGRADE = r57;
        ErrCode r58 = new ErrCode("THIRD_SECRET_FILE", 53);
        THIRD_SECRET_FILE = r58;
        a = new ErrCode[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10, r8, r6, r4, r2, r17, r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r36, r37, r38, r39, r40, r41, r42, r43, r44, r46, r47, r48, r49, r50, r51, r52, r53, r54, r56, r57, r58};
    }

    public static ErrCode[] values() {
        return (ErrCode[]) a.clone();
    }

    public Throwable getCause() {
        return this.cause;
    }

    public static ErrCode valueOf(String r1) {
        return (ErrCode) a.a(ErrCode.class, r1);
    }

    public void setCause(Throwable r1) {
        this.cause = r1;
    }

    public ErrCode(String r1, int r2) {
        super(r1, r2);
    }
}
