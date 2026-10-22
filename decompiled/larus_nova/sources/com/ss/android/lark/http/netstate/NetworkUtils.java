package com.ss.android.lark.http.netstate;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes36.dex */
public final class NetworkUtils {

    public static final enum CompressType extends Enum<CompressType> {
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CompressType[] f425865a = null;
        final int nativeInt;

        static {
            CompressType r100 = new CompressType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            CompressType r101 = new CompressType("GZIP", 1, 1);
            GZIP = r101;
            CompressType r102 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r102;
            f425865a = new CompressType[]{r100, r101, r102};
        }

        public static CompressType[] values() {
            return (CompressType[]) f425865a.clone();
        }

        public static CompressType valueOf(String r100) {
            return (CompressType) r27.a.a(CompressType.class, r100);
        }

        public CompressType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f425866a = null;
        final int nativeInt;
        private final String nativeName;

        static {
            NetworkType r100 = new NetworkType(UserProfileEvent.POSITION_NONE, 0, 0, "unvailable");
            NONE = r100;
            NetworkType r101 = new NetworkType("MOBILE", 1, 1, "mobile");
            MOBILE = r101;
            NetworkType r102 = new NetworkType("MOBILE_2G", 2, 2, "mobile_2g");
            MOBILE_2G = r102;
            NetworkType r103 = new NetworkType("MOBILE_3G", 3, 3, "mobile_3g");
            MOBILE_3G = r103;
            NetworkType r104 = new NetworkType("WIFI", 4, 4, "wifi");
            WIFI = r104;
            NetworkType r105 = new NetworkType("MOBILE_4G", 5, 5, "mobile_4g");
            MOBILE_4G = r105;
            NetworkType r110 = new NetworkType("UNKNOWN", 6, 6, "unknown");
            UNKNOWN = r110;
            f425866a = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f425866a.clone();
        }

        public com.larksuite.framework.utils.NetworkUtils.NetworkType toType() {
            if (this != NONE) goto L7;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.NONE;
        L7:
            if (this != UNKNOWN) goto L11;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.UNKNOWN;
        L11:
            if (this != WIFI) goto L15;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.WIFI;
        L15:
            if (this != MOBILE_2G) goto L19;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_2G;
        L19:
            if (this != MOBILE_3G) goto L23;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_3G;
        L23:
            if (this != MOBILE_4G) goto L27;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_4G;
        L27:
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE;
        }

        public String getNativeName() {
            return this.nativeName;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType from(com.larksuite.framework.utils.NetworkUtils.NetworkType r100) {
            if (r100 != com.larksuite.framework.utils.NetworkUtils.NetworkType.NONE) goto L7;
            return NONE;
        L7:
            if (r100 != com.larksuite.framework.utils.NetworkUtils.NetworkType.UNKNOWN) goto L11;
            return UNKNOWN;
        L11:
            if (r100 != com.larksuite.framework.utils.NetworkUtils.NetworkType.WIFI) goto L15;
            return WIFI;
        L15:
            if (r100 != com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_2G) goto L19;
            return MOBILE_2G;
        L19:
            if (r100 != com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_3G) goto L23;
            return MOBILE_3G;
        L23:
            if (r100 != com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_4G) goto L27;
            return MOBILE_4G;
        L27:
            return MOBILE;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) r27.a.a(NetworkType.class, r100);
        }

        public NetworkType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.nativeInt = r102;
            this.nativeName = r103;
        }
    }

    public static NetworkType a(Context r100) {
        return NetworkType.from(com.larksuite.framework.utils.NetworkUtils.b(r100));
    }
}
