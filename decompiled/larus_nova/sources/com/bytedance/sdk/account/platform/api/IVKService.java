package com.bytedance.sdk.account.platform.api;

import android.app.Activity;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.sdk.account.platform.base.ActivityResultHandler;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public interface IVKService extends IAuthorizeService {

    public interface CallbackHandler extends ActivityResultHandler {
    }

    public interface ResponseConstants {
        public static final String ACCESS_TOKEN = "access_token";
        public static final String CREATED = "created";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String PHONE_ACCESS_KEY = "phone_access_key";
        public static final String SECRET = "secret";
        public static final String USER_ID = "user_id";
    }

    public static final enum VKPermission extends Enum<VKPermission> {
        private static final /* synthetic */ VKPermission[] $VALUES = null;
        public static final VKPermission ADS = null;
        public static final VKPermission AUDIO = null;
        public static final VKPermission DOCS = null;
        public static final VKPermission EMAIL = null;
        public static final VKPermission FRIENDS = null;
        public static final VKPermission GROUPS = null;
        public static final VKPermission MARKET = null;
        public static final VKPermission MESSAGES = null;
        public static final VKPermission NOTES = null;
        public static final VKPermission NOTIFICATIONS = null;
        public static final VKPermission NOTIFY = null;
        public static final VKPermission OFFLINE = null;
        public static final VKPermission PAGES = null;
        public static final VKPermission PHONE = null;
        public static final VKPermission PHOTOS = null;
        public static final VKPermission STATS = null;
        public static final VKPermission STATUS = null;
        public static final VKPermission STORIES = null;
        public static final VKPermission VIDEO = null;
        public static final VKPermission WALL = null;

        static {
            VKPermission r100 = new VKPermission(HTTP.NOTIFY, 0);
            NOTIFY = r100;
            VKPermission r101 = new VKPermission("FRIENDS", 1);
            FRIENDS = r101;
            VKPermission r102 = new VKPermission("PHOTOS", 2);
            PHOTOS = r102;
            VKPermission r103 = new VKPermission("AUDIO", 3);
            AUDIO = r103;
            VKPermission r104 = new VKPermission("VIDEO", 4);
            VIDEO = r104;
            VKPermission r105 = new VKPermission("STORIES", 5);
            STORIES = r105;
            VKPermission r110 = new VKPermission("PAGES", 6);
            PAGES = r110;
            VKPermission r111 = new VKPermission(CommonConstant.RETKEY.STATUS, 7);
            STATUS = r111;
            VKPermission r112 = new VKPermission("NOTES", 8);
            NOTES = r112;
            VKPermission r113 = new VKPermission("MESSAGES", 9);
            MESSAGES = r113;
            VKPermission r114 = new VKPermission("WALL", 10);
            WALL = r114;
            VKPermission r115 = new VKPermission("ADS", 11);
            ADS = r115;
            VKPermission r106 = new VKPermission("OFFLINE", 12);
            OFFLINE = r106;
            VKPermission r107 = new VKPermission("DOCS", 13);
            DOCS = r107;
            VKPermission r108 = new VKPermission("GROUPS", 14);
            GROUPS = r108;
            VKPermission r109 = new VKPermission("NOTIFICATIONS", 15);
            NOTIFICATIONS = r109;
            VKPermission r116 = new VKPermission("STATS", 16);
            STATS = r116;
            VKPermission r117 = new VKPermission(CommonConstant.RETKEY.EMAIL, 17);
            EMAIL = r117;
            VKPermission r118 = new VKPermission("MARKET", 18);
            MARKET = r118;
            VKPermission r119 = new VKPermission("PHONE", 19);
            PHONE = r119;
            $VALUES = new VKPermission[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        }

        public static VKPermission[] values() {
            return (VKPermission[]) $VALUES.clone();
        }

        public static VKPermission valueOf(String r100) {
            return (VKPermission) a.a(VKPermission.class, r100);
        }

        private VKPermission(String r100, int r101) {
            super(r100, r101);
        }
    }

    CallbackHandler authorize(Activity r100, AuthorizeCallback r101);

    CallbackHandler authorize(Activity r100, List<VKPermission> r101, AuthorizeCallback r102);
}
