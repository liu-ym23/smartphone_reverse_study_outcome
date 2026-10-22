package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* JADX INFO: loaded from: classes22.dex */
public interface IQQService extends IAuthorizeService {

    public interface ErrorCode {
        public static final int APP_CHECK = 110406;
        public static final int APP_NOT_EXIST = 110401;
        public static final int APP_SOLD_OUT = 110407;
        public static final int ERR_GET_APP_AUTH_INFO = 110501;
        public static final int ERR_GET_TOKEN = 110503;
        public static final int ERR_GET_USER_AUTH_INFO = 110500;
        public static final int ERR_INTERNAL = 110504;
        public static final int ERR_SET_USER_AUTH = 110502;
        public static final int ERR_SIGN = 100044;
        public static final int LOGIN_LIMIT = 110405;
        public static final int NOT_LOGIN = 110201;
        public static final int NO_APP_ID = 110404;
    }

    public interface ResponseConstants {
        public static final String ACCESS_TOKEN = "access_token";
        public static final String EXPIRES_IN = "expires_in";
        public static final String OPENID = "openid";
    }

    public interface Scope {
        public static final String SCOPE_GET_USER_INFO = "get_simple_userinfo";
    }

    void authorize(Activity r100, String r101, AuthorizeCallback r102);

    void onActivityResult(Context r100, int r101, int r102, Intent r103);

    void onDestroy();
}
