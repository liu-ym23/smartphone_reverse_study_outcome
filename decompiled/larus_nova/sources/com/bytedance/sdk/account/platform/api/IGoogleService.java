package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.account.platform.base.ActivityResultHandler;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public interface IGoogleService extends IAuthorizeService {
    public static final int APP_AUTH_0 = 0;
    public static final int APP_AUTH_1 = 1;
    public static final int APP_AUTH_2 = 2;

    public interface CallbackHandler extends ActivityResultHandler {
        void onDestroy();
    }

    public interface CheckOneTapCallback {
        void onResult(int r100, String r101);
    }

    public interface RequestKey {
        public static final String AUTO_SELECT_ENABLED = "auto_select_enabled";
        public static final String FILTER_BY_AUTHORIZED_ACCOUNTS = "filter_by_authorized_accounts";
        public static final String NONCE = "nonce";
    }

    public interface ResponseKey {
        public static final String DISPLAY_NAME = "display_name";
        public static final String EMAIL = "email";
        public static final String EXPIRE_IN = "expire_in";
        public static final String FAMILY_NAME = "family_name";
        public static final String GIVEN_NAME = "given_name";
        public static final String GRANTED_SCOPES = "granted_scopes";
        public static final String ID = "id";
        public static final String ID_TOKEN = "idToken";
        public static final String NONCE = "nonce";
        public static final String PASSWORD = "password";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String PROFILE_PICTURE_URI = "profile_picture_uri";
        public static final String SERVER_AUTH_CODE = "server_auth_code";
    }

    CallbackHandler authorize(Activity r100, int r101, AuthorizeCallback r102);

    CallbackHandler authorize(Activity r100, int r101, Set<String> r102, boolean r103, AuthorizeCallback r104);

    CallbackHandler authorizeOneTap(Activity r100, Bundle r101, AuthorizeCallback r102);

    void canShowGoogleOneTap(Activity r100, Bundle r101, CheckOneTapCallback r102);

    void googleSignOut(Activity r100);

    boolean isGooglePlayServiceAvailable();

    void revokeAccess();
}
