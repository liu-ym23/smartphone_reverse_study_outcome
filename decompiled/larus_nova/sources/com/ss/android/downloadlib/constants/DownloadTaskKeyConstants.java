package com.ss.android.downloadlib.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadTaskKeyConstants {

    @Retention(RetentionPolicy.SOURCE)
    public @interface TaskKeyErrorMsg {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TaskKeyObjectAttr {
        public static final String APP_VERSION = "app_version";
        public static final String FILTERED_DOWNLOAD_URL = "filtered_download_url";
        public static final String PACKAGE_NAME = "package_name";
        public static final String TASK_GROUP = "task_group";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TaskKeyObjectCallScene {
        public static final int ANCHNOR = 4;
        public static final int BUSINESS = 3;
        public static final int DEFAULT = 0;
        public static final int DOWNLOAD_APP_LIST = 9;
        public static final int DOWNLOAD_MANAGEMENT_CENTER = 10;
        public static final int GAME_CP = 11;
        public static final int GAME_STATION = 8;
        public static final int LIVE = 1;
        public static final int ONE_PAGE = 2;
        public static final int ORDER_DOWNLOAD = 1000;
        public static final int ORDER_DOWNLOAD_DIRECT = 1001;
        public static final int SCENE_GAME_ADVERT = 6;
        public static final int SCENE_SEARCH = 7;
        public static final int SMALL_VIDEO = 5;
        public static final int UNKNOWN_SPECIAL = 100;
    }

    public DownloadTaskKeyConstants() {
    }
}
