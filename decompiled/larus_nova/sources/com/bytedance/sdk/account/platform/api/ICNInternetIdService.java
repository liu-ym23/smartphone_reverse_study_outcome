package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* JADX INFO: loaded from: classes22.dex */
public interface ICNInternetIdService extends IAuthorizeService {

    public interface ErrorCode {
        public static final String ERROR_UNKONWN = "-1";
        public static final String ERROR_USER_CANCEL = "-2";
        public static final String SUCCESS = "0";
    }

    public interface ResponseConstants {
        public static final String BIZ_SEQ = "biz_seq";
        public static final String CERT_PWD_DATA = "cert_pwd_data";
        public static final String EXTRAS = "extras";
        public static final String ID_CARD_AUTH_DATA = "id_card_auth_data";
        public static final String TYPE = "type";
    }

    boolean authorize(Activity r100, int r101, AuthorizeCallback r102);

    boolean isAppInstalled(Activity r100);

    void onDestroy();
}
