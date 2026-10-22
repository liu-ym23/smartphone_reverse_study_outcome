package com.bytedance.caijing.sdk.biz.googleiap.api.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes15.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface CJIAPResultCode {
    public static final int INIT_FAIL = 101;
    public static final int NET_FAIL = 201;
    public static final int PARAM_ILLEGAL = 103;
    public static final int PAY_CANCEL = 1002;
    public static final int PAY_FAIL = 1001;
    public static final int PAY_PENDING = 1005;
    public static final int PAY_PROCESSING = 1003;
    public static final int PAY_QUERY_PURCHASE_FAIL = 2001;
    public static final int PAY_QUERY_PURCHASE_SUCCESS = 2000;
    public static final int PAY_SUCCESS = 1000;
    public static final int PAY_UN_ACK = 1004;
    public static final int QUERY_PRODUCT_SUCCESS = 3000;
    public static final int SUCCESS = 0;
    public static final int UN_INIT = 102;
    public static final int UN_KNOW = -1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DetailCode {
        public static final int Google_Code_BILLING_UNAVAILABLE = 209;
        public static final int Google_Code_DEVELOPER_ERROR = 205;
        public static final int Google_Code_ERROR = 201;
        public static final int Google_Code_FEATURE_NOT_SUPPORTED = 204;
        public static final int Google_Code_ITEM_ALREADY_OWNED = 211;
        public static final int Google_Code_ITEM_NOT_OWNED = 212;
        public static final int Google_Code_ITEM_UNAVAILABLE = 210;
        public static final int Google_Code_NETWORK_ERROR = 203;
        public static final int Google_Code_OK = 200;
        public static final int Google_Code_SERVICE_DISCONNECTED = 207;
        public static final int Google_Code_SERVICE_TIMEOUT = 206;
        public static final int Google_Code_SERVICE_UNAVAILABLE = 208;
        public static final int Google_Code_USER_CANCELED = 202;
        public static final int PAY_CHANNEL_START_FAIL = 101;
        public static final int UN_KNOW = -1;
    }
}
