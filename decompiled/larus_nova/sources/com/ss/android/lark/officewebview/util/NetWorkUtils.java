package com.ss.android.lark.officewebview.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes37.dex */
public final class NetWorkUtils {

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f437534a = null;
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
            f437534a = new NetworkType[]{r100, r101, r102, r103, r104, r105};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f437534a.clone();
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) r27.a.a(NetworkType.class, r100);
        }

        public NetworkType(String r100, int r101, int r102) {
            super(r100, r101);
            this.nativeInt = r102;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f437535a = null;

        static {
            int[] r100 = new int[NetworkType.values().length];
            f437535a = r100;
            r100[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f437535a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f437535a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f437535a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f437535a[NetworkType.MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static boolean a() {
        int r100 = com.ss.android.lark.officesdk.utils.di.g.f437223a;
        boolean r101 = com.ss.android.lark.officesdk.utils.di.g.a.a("openflatform.web.allow.report.network.status");
        com.ss.android.lark.officesdk.utils.di.j.e("NetWorkUtils", "allow Report web network status:" + r101);
        return r101;
    }

    public static String c() {
        if (a() == true) goto L45;
        return "";
    L45:
        NetworkInfo r100 = ((ConnectivityManager) com.ss.android.lark.officesdk.utils.di.d.a().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r100 != null) goto L9;
    L22:
        NetworkType r101 = NetworkType.NONE;     // Catch: Throwable -> L24
    L44:
    L47:
        int r102 = a.f437535a[r101.ordinal()];     // Catch: Exception -> L43
        if (r102 != 1) goto L28;
        String r103 = "wifi";
    L42:
        return r103;
    L28:
        if (r102 != 2) goto L30;
        r103 = CJPayBasicUtils.NETWORK_2G;
        goto L42
    L30:
        if (r102 != 3) goto L32;
        r103 = CJPayBasicUtils.NETWORK_3G;
        goto L42
    L32:
        if (r102 != 4) goto L34;
        r103 = CJPayBasicUtils.NETWORK_4G;
        goto L42
    L34:
        if (r102 != 5) goto L49;
        r103 = "mobile";
        goto L42
    L49:
        return "";
    L50:
        return "";
    L9:
        if (r100.isAvailable() == false) goto L22;
        int r104 = r100.getType();     // Catch: Throwable -> L24
        if (1 != r104) goto L14;
        r101 = NetworkType.WIFI;     // Catch: Throwable -> L24
        goto L44
    L14:
        if (r104 == 0) goto L16;
        r101 = NetworkType.MOBILE;     // Catch: Throwable -> L24
        goto L44
    L16:
        switch(((TelephonyManager) com.ss.android.lark.officesdk.utils.di.d.a().getSystemService("phone")).getNetworkType()) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L17;
        };     // Catch: Throwable -> L24
    L17:
        r101 = NetworkType.MOBILE;     // Catch: Throwable -> L24
        goto L44
    L18:
        r101 = NetworkType.MOBILE_4G;     // Catch: Throwable -> L24
        goto L44
    L19:
        r101 = NetworkType.MOBILE_3G;     // Catch: Throwable -> L24
        goto L44
    L20:
        r101 = NetworkType.MOBILE_2G;     // Catch: Throwable -> L24
    L24:
        r101 = NetworkType.MOBILE;
        goto L47
    }

    public static Process b(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
