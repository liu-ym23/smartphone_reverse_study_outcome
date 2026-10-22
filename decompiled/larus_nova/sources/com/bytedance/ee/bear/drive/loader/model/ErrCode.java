package com.bytedance.ee.bear.drive.loader.model;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrCode[] f224477a = null;
    private Throwable cause;

    static {
        ErrCode r100 = new ErrCode("DEFAULT", 0);
        DEFAULT = r100;
        ErrCode r101 = new ErrCode("REQUEST_FILE_INFO_EXP", 1);
        REQUEST_FILE_INFO_EXP = r101;
        ErrCode r102 = new ErrCode("FILE_NOT_FOUND", 2);
        FILE_NOT_FOUND = r102;
        ErrCode r103 = new ErrCode("OWNER_DELETED_FILE", 3);
        OWNER_DELETED_FILE = r103;
        ErrCode r104 = new ErrCode("PERMISSION_DENIED", 4);
        PERMISSION_DENIED = r104;
        ErrCode r105 = new ErrCode("POLICY_DENIED", 5);
        POLICY_DENIED = r105;
        ErrCode r110 = new ErrCode("STATIC_RESOURCE_FROZEN_BY_ADMIN", 6);
        STATIC_RESOURCE_FROZEN_BY_ADMIN = r110;
        ErrCode r111 = new ErrCode("STATIC_RESOURCE_SHREDDED_BY_ADMIN", 7);
        STATIC_RESOURCE_SHREDDED_BY_ADMIN = r111;
        ErrCode r112 = new ErrCode("COPY_TIMEOUT", 8);
        COPY_TIMEOUT = r112;
        ErrCode r113 = new ErrCode("COPY_FAILED", 9);
        COPY_FAILED = r113;
        ErrCode r114 = new ErrCode("REQUEST_PREVIEW_URL_EXP", 10);
        REQUEST_PREVIEW_URL_EXP = r114;
        ErrCode r115 = new ErrCode("REQUEST_TRANSFORM_UNKNOW_EXP", 11);
        REQUEST_TRANSFORM_UNKNOW_EXP = r115;
        ErrCode r106 = new ErrCode("REQUEST_TRANSFORM_SERVER_EXP", 12);
        REQUEST_TRANSFORM_SERVER_EXP = r106;
        ErrCode r107 = new ErrCode("REQUEST_TRANSFORM_CANCEL_EXP", 13);
        REQUEST_TRANSFORM_CANCEL_EXP = r107;
        ErrCode r108 = new ErrCode("REQUEST_TRANSFORM_SHUTDOWN_EXP", 14);
        REQUEST_TRANSFORM_SHUTDOWN_EXP = r108;
        ErrCode r109 = new ErrCode("REQUEST_TRANSFORM_FILE_ENCRYPTION", 15);
        REQUEST_TRANSFORM_FILE_ENCRYPTION = r109;
        ErrCode r116 = new ErrCode("DRIVE_FILE_NOT_SUPPORT_PREVIEW", 16);
        DRIVE_FILE_NOT_SUPPORT_PREVIEW = r116;
        ErrCode r117 = new ErrCode("DRIVE_FILE_OVER_SIZE", 17);
        DRIVE_FILE_OVER_SIZE = r117;
        ErrCode r118 = new ErrCode("DRIVE_FILE_ZERO_SIZE", 18);
        DRIVE_FILE_ZERO_SIZE = r118;
        ErrCode r119 = new ErrCode("DRIVE_FILE_ENCRYPTED", 19);
        DRIVE_FILE_ENCRYPTED = r119;
        ErrCode r120 = new ErrCode("RUST_SUBMIT_ERROR", 20);
        RUST_SUBMIT_ERROR = r120;
        ErrCode r121 = new ErrCode("RUST_DOWNLOAD_FAIL", 21);
        RUST_DOWNLOAD_FAIL = r121;
        ErrCode r122 = new ErrCode("RUST_NOT_LOGIN", 22);
        RUST_NOT_LOGIN = r122;
        ErrCode r123 = new ErrCode("CACHE_FILE_MODEL_NOT_FOUND", 23);
        CACHE_FILE_MODEL_NOT_FOUND = r123;
        ErrCode r124 = new ErrCode("FILE_DATA_VERSION_CHANGED", 24);
        FILE_DATA_VERSION_CHANGED = r124;
        ErrCode r125 = new ErrCode("FILE_NOT_CHANGED", 25);
        FILE_NOT_CHANGED = r125;
        ErrCode r126 = new ErrCode("PRELOAD_SIZE_TOO_LARGE", 26);
        PRELOAD_SIZE_TOO_LARGE = r126;
        ErrCode r127 = new ErrCode("MANUAL_CACHE_NEED_WIFI", 27);
        MANUAL_CACHE_NEED_WIFI = r127;
        ErrCode r128 = new ErrCode("PROCESSOR_CACHE_MISS", 28);
        PROCESSOR_CACHE_MISS = r128;
        ErrCode r129 = new ErrCode("COPPING", 29);
        COPPING = r129;
        ErrCode r130 = new ErrCode("DRIVE_DOWNLOAD_FILE_OVER_SIZE", 30);
        DRIVE_DOWNLOAD_FILE_OVER_SIZE = r130;
        ErrCode r131 = new ErrCode("PREVIEW_DOWNGRADE_TO_SIMILAR", 31);
        PREVIEW_DOWNGRADE_TO_SIMILAR = r131;
        ErrCode r132 = new ErrCode("WPS_PREVIEW_EXP", 32);
        WPS_PREVIEW_EXP = r132;
        ErrCode r133 = new ErrCode("WPS_PREVIEW_GET_ACCESS_TOKEN_USER_MEMORY_OVER_LIMIT", 33);
        WPS_PREVIEW_GET_ACCESS_TOKEN_USER_MEMORY_OVER_LIMIT = r133;
        ErrCode r134 = new ErrCode("WPS_PREVIEW_GET_ACCESS_TOKEN_TENANT_MEMORY_OVER_LIMIT", 34);
        WPS_PREVIEW_GET_ACCESS_TOKEN_TENANT_MEMORY_OVER_LIMIT = r134;
        ErrCode r135 = new ErrCode("WPS_PREVIEW_GET_ACCESS_TOKEN_EDITOR_MEMORY_OVER_LIMIT", 35);
        WPS_PREVIEW_GET_ACCESS_TOKEN_EDITOR_MEMORY_OVER_LIMIT = r135;
        ErrCode r136 = new ErrCode("WPS_PREVIEW_GET_ACCESS_TOKEN_EXP", 36);
        WPS_PREVIEW_GET_ACCESS_TOKEN_EXP = r136;
        ErrCode r137 = new ErrCode("NO_NETWORK", 37);
        NO_NETWORK = r137;
        ErrCode r138 = new ErrCode("PERM_ADMIN_CONTROL", 38);
        PERM_ADMIN_CONTROL = r138;
        ErrCode r139 = new ErrCode("SHEET_PREVIEW_EXP", 39);
        SHEET_PREVIEW_EXP = r139;
        ErrCode r140 = new ErrCode("SLIDES_PREVIEW_EXP", 40);
        SLIDES_PREVIEW_EXP = r140;
        ErrCode r141 = new ErrCode("CAC_PREVIEW_CONTROL", 41);
        CAC_PREVIEW_CONTROL = r141;
        ErrCode r142 = new ErrCode("TNS_BLOCK_VIEW", 42);
        TNS_BLOCK_VIEW = r142;
        ErrCode r143 = new ErrCode("VIDEO_MP4_ERROR", 43);
        VIDEO_MP4_ERROR = r143;
        ErrCode r144 = new ErrCode("DLP_INTERANL_CHECKING", 44);
        DLP_INTERANL_CHECKING = r144;
        ErrCode r145 = new ErrCode("DLP_EXTERNAL_CHECKING", 45);
        DLP_EXTERNAL_CHECKING = r145;
        ErrCode r146 = new ErrCode("DLP_INTERANL_SENSATIVE", 46);
        DLP_INTERANL_SENSATIVE = r146;
        ErrCode r147 = new ErrCode("DLP_EXTERNAL_SENSATIVE", 47);
        DLP_EXTERNAL_SENSATIVE = r147;
        ErrCode r148 = new ErrCode("MAILCE_FILE", 48);
        MAILCE_FILE = r148;
        ErrCode r149 = new ErrCode("ENCRYPTION_KEY_DELETED", 49);
        ENCRYPTION_KEY_DELETED = r149;
        ErrCode r150 = new ErrCode("ENCRYPTION_KEY_NOT_SUPPORT", 50);
        ENCRYPTION_KEY_NOT_SUPPORT = r150;
        ErrCode r151 = new ErrCode("DLP_UPLOAD_CONTROL", 51);
        DLP_UPLOAD_CONTROL = r151;
        ErrCode r152 = new ErrCode("PREVIEW_FAILED_DO_NOT_DOWNGRADE", 52);
        PREVIEW_FAILED_DO_NOT_DOWNGRADE = r152;
        ErrCode r153 = new ErrCode("THIRD_SECRET_FILE", 53);
        THIRD_SECRET_FILE = r153;
        f224477a = new ErrCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153};
    }

    public static ErrCode[] values() {
        return (ErrCode[]) f224477a.clone();
    }

    public Throwable getCause() {
        return this.cause;
    }

    public static ErrCode valueOf(String r100) {
        return (ErrCode) a.a(ErrCode.class, r100);
    }

    public void setCause(Throwable r100) {
        this.cause = r100;
    }

    public ErrCode(String r100, int r101) {
        super(r100, r101);
    }
}
