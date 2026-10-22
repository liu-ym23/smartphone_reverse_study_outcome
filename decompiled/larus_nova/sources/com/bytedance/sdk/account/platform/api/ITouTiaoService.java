package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;

/* JADX INFO: loaded from: classes22.dex */
public interface ITouTiaoService extends IAuthorizeService {

    public interface ResponseConstants {
        public static final String AUTH_CODE = "auth_code";
        public static final String EXTRA = "extras";
        public static final String GRANTED_PERMISSION = "grantedPermissions";
        public static final String STATE = "state";
    }

    public interface Scope {
        public static final String TT_SCOPE_INFO = "user_info";
    }

    boolean authorize(Activity r100, Request r101, AuthorizeCallback r102);

    boolean isAppInstalled();

    boolean isAppSupportAuthorization();

    void onActivityResult(int r100, int r101, Intent r102);

    void onDestroy();
}
