package com.bytedance.sdk.account.platform.api;

import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public interface IDouYinService extends IAuthorizeService {

    public interface Extra {
        public static final String REQURE_MOBILE_BIND = "require_tel_num_bind";
    }

    public interface ResponseConstants {
        public static final String AUTH_CODE = "auth_code";
        public static final String EXTRA = "extras";
        public static final String GRANTED_PERMISSION = "granted_permission";
        public static final String STATE = "state";
    }

    public interface Scope {
        public static final String MOBILE = "mobile";
        public static final String MOBILE_ALERT = "mobile_alert";
        public static final String USER_INFO = "user_info";
    }

    public static final enum TargetAPP extends Enum<TargetAPP> {
        private static final /* synthetic */ TargetAPP[] $VALUES = null;
        public static final TargetAPP AWEME = null;
        public static final TargetAPP TIKTOK = null;

        static {
            TargetAPP r100 = new TargetAPP("AWEME", 0);
            AWEME = r100;
            TargetAPP r101 = new TargetAPP("TIKTOK", 1);
            TIKTOK = r101;
            $VALUES = new TargetAPP[]{r100, r101};
        }

        public static TargetAPP[] values() {
            return (TargetAPP[]) $VALUES.clone();
        }

        public static TargetAPP valueOf(String r100) {
            return (TargetAPP) a.a(TargetAPP.class, r100);
        }

        private TargetAPP(String r100, int r101) {
            super(r100, r101);
        }
    }

    boolean authorize(Request r100, AuthorizeCallback r101);

    boolean authorizeNative(Request r100, AuthorizeCallback r101);

    boolean authorizeWeb(Request r100, AuthorizeCallback r101);

    boolean authorizeWeb(Request r100, Class r101, AuthorizeCallback r102);

    String getSdkVersion();

    boolean isAppInstalled();

    boolean isAppSupportAuthBindMobile();

    boolean isAppSupportAuthorization();

    void onDestroy();
}
