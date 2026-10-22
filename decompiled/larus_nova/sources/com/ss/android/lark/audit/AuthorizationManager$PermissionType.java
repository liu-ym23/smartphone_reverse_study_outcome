package com.ss.android.lark.audit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AuthorizationManager$PermissionType {
    public static final int BAIKE_REPO_VIEW = 27;
    public static final int DOC_DOWNLOAD = 24;
    public static final int DOC_EXPORT = 25;
    public static final int DOC_PREVIEW_AND_OPEN = 17;
    public static final int DOC_PRINT = 26;
    public static final int FILE_ACCESS_FOLDER = 7;
    public static final int FILE_APP_OPEN = 6;
    public static final int FILE_COMMENT = 10;
    public static final int FILE_COPY = 11;
    public static final int FILE_DELETE = 12;
    public static final int FILE_DOWNLOAD = 3;
    public static final int FILE_EDIT = 9;
    public static final int FILE_EXPORT = 4;
    public static final int FILE_IMPORT = 2;
    public static final int FILE_PRINT = 5;
    public static final int FILE_READ = 8;
    public static final int FILE_SHARE = 13;
    public static final int FILE_UPLOAD = 1;
    public static final int LOCAL_FILE_PREVIEW = 16;
    public static final int LOCAL_FILE_SHARE = 15;
    public static final int MOBILE_PASTE_PROTECTION = 21;
    public static final int MOBILE_SCREEN_PROTECT = 22;
    public static final int PC_PASTE_PROTECTION = 19;
    public static final int PC_SCREEN_PROTECT = 23;
    public static final int PRIVACY_GPS_LOCATION = 18;
    public static final int SDK_SWITCH = 28;
    public static final int SEARCH = 14;
    public static final int UNKNOWN = 0;
    public static final int WEB_PASTE_PROTECTION = 20;
}
