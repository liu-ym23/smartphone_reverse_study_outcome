package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import com.bytedance.sdk.account.platform.base.ActivityResultHandler;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* JADX INFO: loaded from: classes22.dex */
public interface ITwitterService extends IAuthorizeService {

    public interface CallbackHandler extends ActivityResultHandler {
    }

    public interface ResponseConstants {
        public static final String AUTH_TOKEN = "auth_token";
        public static final String ID = "id";
        public static final String SECRET = "secret";
        public static final String USER_NAME = "user_name";
    }

    CallbackHandler authorize(Activity r100, AuthorizeCallback r101);
}
