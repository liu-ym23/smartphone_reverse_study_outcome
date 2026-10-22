package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;

/* JADX INFO: loaded from: classes3.dex */
public interface IDouYin2Service extends IAuthorizeService {

    /* JADX INFO: loaded from: classes22.dex */
    public interface Extra {
        public static final String COMMENT_ID = "comment_id";
        public static final String IS_SKIP_UI_IN_THIRD_AUTH = "is_skip_ui_in_third_auth";
        public static final String IS_THIRD_AUTH_DIALOG = "is_third_auth_dialog";
        public static final String REQURE_MOBILE_BIND = "require_tel_num_bind";
        public static final String THIRD_AUTH_SCENE = "third_auth_scene";
        public static final String VERIFY_OPENID = "verify_openid";
        public static final String VERIFY_SCOPE = "verify_scope";
        public static final String VERIFY_TIC = "verify_tic";
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface ResponseConstants {
        public static final String AUTH_CODE = "auth_code";
        public static final String EXTRA = "extras";
        public static final String GRANTED_PERMISSION = "granted_permission";
        public static final String STATE = "state";
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface Scope {
        public static final String MOBILE = "mobile";
        public static final String MOBILE_ALERT = "mobile_alert";
        public static final String USER_INFO = "user_info";
    }

    boolean authorize(Activity r100, Request r101, AuthorizeCallback r102);

    String getSdkVersion(Activity r100);

    boolean isAppInstalled(Activity r100, boolean r101);

    boolean isAppSupportAuthBindMobile(Activity r100, boolean r101);

    boolean isAppSupportAuthorization(Activity r100, boolean r101);

    boolean isAppSupportSwitchAccount(Activity r100, boolean r101);

    void onActivityResult(int r100, int r101, Intent r102);

    void onDestroy();
}
