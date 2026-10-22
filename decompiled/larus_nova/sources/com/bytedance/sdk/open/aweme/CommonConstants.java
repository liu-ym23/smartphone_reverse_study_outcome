package com.bytedance.sdk.open.aweme;

/* JADX INFO: loaded from: classes22.dex */
public interface CommonConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f269600a = "com.aweme.opensdk.action.stay.in.dy";

    public interface AuthErrorCode {
        public static final int ERROR_AUTHORIZATION_NO_PERMISSION = 10011;
        public static final int ERROR_CODE_EXPIRED = 10007;
        public static final int ERROR_CONFIG = 10003;
        public static final int ERROR_NETWORK_CONNECT_TIMEOUT = -13;
        public static final int ERROR_NETWORK_IO = -15;
        public static final int ERROR_NETWORK_NO_CONNECTION = -12;
        public static final int ERROR_NETWORK_SSL = -21;
        public static final int ERROR_NETWORK_TIMEOUT = -14;
        public static final int ERROR_NETWORK_UNKNOWN_HOST_ERROR = -16;
        public static final int ERROR_N_PARAMS = 10005;
        public static final int ERROR_PARAM = 10002;
        public static final int ERROR_REDIRECT_URL = 10006;
        public static final int ERROR_REFRESH_TOKEN = 10010;
        public static final int ERROR_SCOPE = 10004;
        public static final int ERROR_SYSTEM = 10001;
        public static final int ERROR_TICKET = 10009;
        public static final int ERROR_TOKEN = 10008;
    }

    public interface BaseErrorCode {
        public static final int ERROR_CANCEL = -2;
        public static final int ERROR_NET = -3;
        public static final int ERROR_UNKNOW = -1;
        public static final int OK = 0;
    }

    public interface ExtraParams {
        public static final String AUTH_HOST_APP = "aweme_auth_host_app";
    }

    public static final enum InvokeStrategy extends Enum<InvokeStrategy> {
        private static final /* synthetic */ InvokeStrategy[] $VALUES = null;
        public static final InvokeStrategy AUTO = null;
        public static final InvokeStrategy DOUYIN_AND_HOTSOON = null;
        public static final InvokeStrategy DOUYIN_AND_LITE = null;
        public static final InvokeStrategy DOUYIN_ONLY = null;
        public static final InvokeStrategy HOTSOON_ONLY = null;
        public static final InvokeStrategy LITE_AND_HOTSOON = null;
        public static final InvokeStrategy LITE_ONLY = null;

        static {
            InvokeStrategy r100 = new InvokeStrategy("AUTO", 0);
            AUTO = r100;
            InvokeStrategy r101 = new InvokeStrategy("DOUYIN_ONLY", 1);
            DOUYIN_ONLY = r101;
            InvokeStrategy r102 = new InvokeStrategy("LITE_ONLY", 2);
            LITE_ONLY = r102;
            InvokeStrategy r103 = new InvokeStrategy("HOTSOON_ONLY", 3);
            HOTSOON_ONLY = r103;
            InvokeStrategy r104 = new InvokeStrategy("LITE_AND_HOTSOON", 4);
            LITE_AND_HOTSOON = r104;
            InvokeStrategy r105 = new InvokeStrategy("DOUYIN_AND_HOTSOON", 5);
            DOUYIN_AND_HOTSOON = r105;
            InvokeStrategy r110 = new InvokeStrategy("DOUYIN_AND_LITE", 6);
            DOUYIN_AND_LITE = r110;
            $VALUES = new InvokeStrategy[]{r100, r101, r102, r103, r104, r105, r110};
        }

        private InvokeStrategy(String r100, int r101) {
            super(r100, r101);
        }

        public static InvokeStrategy valueOf(String r100) {
            return (InvokeStrategy) r27.a.a(InvokeStrategy.class, r100);
        }

        public static InvokeStrategy[] values() {
            return (InvokeStrategy[]) $VALUES.clone();
        }
    }

    public interface ModeType {
        public static final int OPEN_COMMON_ABILITY_REQUEST = 9;
        public static final int OPEN_COMMON_ABILITY_RESPONSE = 10;
        public static final int OPEN_RECORD_REQUEST = 7;
        public static final int OPEN_RECORD_RESPONSE = 8;
        public static final int SEND_AUTH_REQUEST = 1;
        public static final int SEND_AUTH_RESPONSE = 2;
        public static final int SHARE_CONTENT_TO_TT = 3;
        public static final int SHARE_CONTENT_TO_TT_RESP = 4;
        public static final int SHARE_TO_CONTACTS = 5;
        public static final int SHARE_TO_CONTACT_RESP = 6;
    }

    public interface SDKErrorCode {
        public static final int CLIENT_CODE_ERROR = 41001;
        public static final int CLIENT_TICKET_ERROR = 41002;
        public static final int NET_ERROR = 40005;
        public static final int NOT_IMPLEMENT_SERVICE = 40003;
        public static final int NOT_INIT_ERROR = 40002;
        public static final int PARAM_ERROR = 40004;
        public static final int UNKNOWN_ERROR = 40001;
    }

    public interface SUPPORT {
        public static final int AUTH = 1;
        public static final int COMMON_ABILITY = 5;
        public static final int OPEN_RECORD = 4;
        public static final int SHARE = 2;
        public static final int SHARE_IM = 3;

        public interface AUTH_API {
            public static final int AUTH_REQUIRE_API = 1;
            public static final int AUTH_SUPPORT_DOUYIN_HOT_SOON = Integer.MAX_VALUE;
            public static final int AUTH_SUPPORT_DOUYIN_LITE = 10;
            public static final int AUTH_SUPPORT_SWITCH_ACCOUNT = 9;
            public static final int VERIFY_REQUIRE_API = 6;
        }

        public interface COMMON_API {
            public static final int COMMON_TYPE_JUMP_IM = 1;
            public static final int COMMON_TYPE_JUMP_PRODUCTION = 2;
            public static final int COMMON_TYPE_JUMP_PROFILE = 1;
        }

        public interface CONTACT_API {
            public static final int CONTACT_SUPPORT_IMAGE_HTML = 1;
            public static final int CONTACT_SUPPORT_INVITE_BULLET_CARD = 4;
            public static final int CONTACT_SUPPORT_INVITE_CARD = 2;
            public static final int CONTACT_SUPPORT_MICRO_APP = 5;
            public static final int CONTACT_SUPPORT_UNIFIED_JOIN_GROUP = 3;
        }

        public interface OPEN_RECORD {
            public static final int OPEN_RECORD_API = 1;
        }

        public interface SHARE_API {
            public static final int SHARE_DAILY = 5;
            public static final int SHARE_DAILY_SET_BACKGROUND = 7;
            public static final int SHARE_MUSIC_TO_DAILY = 6;
            public static final int SHARE_REQUIRE_API = 10003;
            public static final int SHARE_SUPPORT_ALBUM = 2;
            public static final int SHARE_SUPPORT_FILEPROVIDER = 10007;
            public static final int SHARE_SUPPORT_LUNA_MUSIC = 3;
            public static final int SHARE_SUPPORT_MIX_CONTENT = 2;
            public static final int SHARE_SUPPORT_TO_PUBLISH = 10008;
            public static final int SHARE_SUPPORT_WITH_MUSIC = 4;
        }
    }

    public interface ShareErrorCode {
        public static final int CANCEL_LOGIN = 20004;
        public static final int CANCEL_PUBLISH = 20013;
        public static final int ERROR_CODE_AUTH_DENIED = -4;
        public static final int ERROR_CODE_SEND_FAIL = -3;
        public static final int ERROR_CODE_UNSUPPORT = -5;
        public static final int GALLERY_PERMISSION_ERROR = 20005;
        public static final int GRANT_NETWORK_ERR = 20006;
        public static final int INVALID_GRANT = 20003;
        public static final int INVALID_PHOTO = 20008;
        public static final int INVALID_VIDEO_LENGTH = 20007;
        public static final int INVALID_VIDEO_RESOLUTION = 22001;
        public static final int INVALID_VIDEO_SIZE_RATIO = 20011;
        public static final int INVALID_VIDEO_TYPE = 20012;
        public static final int LAST_PUBLISH_NOT_FINISH = 20014;
        public static final int PARSE_MEDIA_FAIL = 20010;
        public static final int PUBLISH_FAIL_UNKNOWN = 20016;
        public static final int SAVE_TO_DRAFT = 20015;
        public static final int TIME_STAMP_INVALID = 20009;
    }
}
