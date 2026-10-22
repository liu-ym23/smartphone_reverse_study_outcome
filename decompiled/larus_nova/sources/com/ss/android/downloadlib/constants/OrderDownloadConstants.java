package com.ss.android.downloadlib.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public interface OrderDownloadConstants {
    public static final String ADD_ORDER_URL = "https://apps.bytesfield.com/booking/create";
    public static final String API_ADD_ORDER = "/booking/create";
    public static final String API_SELECT_ORDER_STATUS = "/booking/detail";
    public static final String API_WIFI_CHOOSE = "/booking/upd";
    public static final String HOST = "https://apps.bytesfield.com";
    public static final String SELECT_ORDER_STATUS = "https://apps.bytesfield.com/booking/detail";
    public static final String WIFI_CHOOSE_URL = "https://apps.bytesfield.com/booking/upd";

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderCheckStatus {
        public static final int DELETE_LATE_ORDER = 5;
        public static final int INSTALLED = 2;
        public static final int NORMAL = 1;
        public static final int NO_WIFI_PARAM = 4;
        public static final int REPEAT_DOWNLOAD = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderStatus {
        public static final int HANDLE_FAILED = -2;
        public static final int ORDERING = 0;
        public static final int ORDER_CANCEL = 2;
        public static final int ORDER_OVERDUE = 3;
        public static final int QUERY_FAILED = -1;
        public static final int SHELVED = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OrderWifiResult {
        public static final int WIFI_CHOOSE = 1;
        public static final int WIFI_NOT_CHOOSE = 2;
    }
}
