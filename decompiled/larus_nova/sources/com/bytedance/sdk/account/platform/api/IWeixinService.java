package com.bytedance.sdk.account.platform.api;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface IWeixinService extends IAuthorizeService {

    /* JADX INFO: loaded from: classes22.dex */
    public interface ResponseConstants {
        public static final String AUTH_CODE = "auth_code";
        public static final String OPEN_ID = "openId";
        public static final String STATE = "state";
        public static final String URL = "url";
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface Scope {
        public static final String WX_SCOPE_BASE = "snsapi_base";
        public static final String WX_SCOPE_INFO = "snsapi_userinfo";
    }

    boolean authorize(String r100, String r101, AuthorizeCallback r102);

    String getWxAppId();

    boolean isWXAppSupportAPI();

    void onDestroy();
}
