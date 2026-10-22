package com.bytedance.sdk.account.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkUtils {

    /* JADX INFO: loaded from: classes22.dex */
    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        public static final NetworkType WIFI_MOBILE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f269535a = null;
        final int nativeInt;

        static {
            NetworkType r100 = new NetworkType(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            NetworkType r101 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r101;
            NetworkType r102 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r102;
            NetworkType r103 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r103;
            NetworkType r104 = new NetworkType("WIFI", 4, 4);
            WIFI = r104;
            NetworkType r105 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r105;
            NetworkType r110 = new NetworkType("WIFI_MOBILE", 6, 6);
            WIFI_MOBILE = r110;
            f269535a = new NetworkType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f269535a.clone();
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) r27.a.a(NetworkType.class, r100);
        }

        public NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static fc7.c c(String r100) {
        fc7.c r101 = new fc7.c(r100);
        fc7.c.c(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION);
        r101.f269554a.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, String.valueOf(60592));
        if (com.bytedance.sdk.account.settings.a.a() == false) goto L5;
        r101.b("use_new_token_expire_rule", "true");
    L5:
        r101.b("request_from_account_sdk", "1");
        r101.b("is_from_ttaccountsdk", "1");
        return r101;
    }

    public static boolean d(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r101 == null) goto L12;
        if (r101.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static wqa.k b(String r100, Map r101, List r102) throws Exception {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.O == false) goto L17;
        HashMap r103 = new HashMap();
        if (r101 == null) goto L7;
        r103.putAll(r101);
    L7:
        wqa.h r104 = com.ss.android.account.k.f406319c;
        if (r104 == null) goto L14;
        Map<String, String> r105 = r104.f560774a;
        if (r105 == null) goto L14;
        if (((HashMap) r105).isEmpty() == true) goto L14;
        r103.putAll(r105);
    L14:
        r103.put("account_sdk_source", "app");
        r103.put("passport_support_flow", jb7.b.f498011c);
        com.ss.android.account.k.d().d();
        r103.put("multi_login", "1");
        return a(c(r100).toString(), r103, r102, 0);
    L17:
        return a(r100, r101, r102, 0);
    }

    public static wqa.k a(String r100, Map r101, List r102, int r103) throws Exception {
        sa7.k r104 = com.ss.android.account.k.d().a();
        if (r104 != null) goto L5;
        return null;
    L5:
        return r104.b(r100, r101, r102, r103);
    }
}
