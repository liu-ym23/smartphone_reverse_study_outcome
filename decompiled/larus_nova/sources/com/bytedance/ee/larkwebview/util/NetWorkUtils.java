package com.bytedance.ee.larkwebview.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes19.dex */
public final class NetWorkUtils {

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f242963a = null;
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
            f242963a = new NetworkType[]{r100, r101, r102, r103, r104, r105};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f242963a.clone();
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
        public static final /* synthetic */ int[] f242964a = null;

        static {
            int[] r100 = new int[NetworkType.values().length];
            f242964a = r100;
            r100[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f242964a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f242964a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f242964a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f242964a[NetworkType.MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static boolean a() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isEnable("openflatform.web.allow.report.network.status");
        Log.i("NetWorkUtils", "allow Report web network status:" + r100);
        return r100;
    }

    public static String d() {
        if (a() == true) goto L45;
        return "";
    L45:
        NetworkInfo r100 = ((ConnectivityManager) LarkContext.getApplication().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r100 != null) goto L9;
    L22:
        NetworkType r101 = NetworkType.NONE;     // Catch: Throwable -> L24
    L44:
    L47:
        int r102 = a.f242964a[r101.ordinal()];     // Catch: Exception -> L43
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
        switch(((TelephonyManager) LarkContext.getApplication().getSystemService("phone")).getNetworkType()) {
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

    public static Pair<String, Float> c(String r110, boolean r111, int r112) {
        boolean r100 = TextUtils.isEmpty(r110);
        float r101 = 0.0f;
        Float r102 = Float.valueOf(0.0f);
        if (r100 == false) goto L7;
        return new Pair("", r102);
    L7:
        if (a() == true) goto L11;
        if (r111 == true) goto L11;
        return new Pair("", r102);
    L11:
        OutputStream r113 = null;
        InputStream r114 = null;
        r114 = null;
        r113 = null;
        Process r115 = b(Runtime.getRuntime(), "ping -c " + r112 + " " + r110);     // Catch: Throwable -> L36 Exception -> L38
        OutputStream r116 = r115.getOutputStream();     // Catch: Throwable -> L36 Exception -> L38
        r116.close();     // Catch: Throwable -> L32 Exception -> L34
        long r103 = System.nanoTime();     // Catch: Throwable -> L32 Exception -> L34
        r114 = r115.getInputStream();     // Catch: Throwable -> L32 Exception -> L34
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r114, "UTF8"));     // Catch: Throwable -> L32 Exception -> L34
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L32 Exception -> L34
    L14:
        String r106 = r104.readLine();     // Catch: Throwable -> L32 Exception -> L34
        if (r106 == null) goto L21;
        r105.put(r106);     // Catch: Throwable -> L32 Exception -> L34
        if (r106.contains("From") == true) goto L20;
        if (r106.contains("from") == false) goto L14;
    L20:
        r101 = (System.nanoTime() - r103) / 1000000.0f;     // Catch: Throwable -> L32 Exception -> L34
        goto L14
    L21:
        r115.destroy();     // Catch: Throwable -> L32 Exception -> L34
        Pair<String, Float> r117 = new Pair(r105.toString(), Float.valueOf(r101));     // Catch: Throwable -> L32 Exception -> L34
        r116.close();     // Catch: IOException -> L24
    L26:
        if (r114 != null) goto L71;
    L31:
        return r117;
    L71:
        r114.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        Log.e("NetWorkUtils", e);
    L24:
        e = move-exception;
        Log.e("NetWorkUtils", e);
        goto L26
    L34:
        e = e;
        InputStream r118 = r114;
        r113 = r116;
    L67:
        Log.e("NetWorkUtils", e);     // Catch: Throwable -> L53
        if (r113 != null) goto L73;
    L46:
        if (r118 == null) goto L52;
        r118.close();     // Catch: IOException -> L49
    L49:
        e = move-exception;
        Log.e("NetWorkUtils", e);
    L52:
        return new Pair("", r102);
    L73:
        r113.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        Log.e("NetWorkUtils", e);
    L53:
        th = th;
    L54:
        if (r113 != null) goto L77;
    L59:
        if (r118 == null) goto L89;
        r118.close();     // Catch: IOException -> L62
        throw th;
    L62:
        e = move-exception;
        Log.e("NetWorkUtils", e);
        throw th;
    L89:
        throw th;
    L77:
        r113.close();     // Catch: IOException -> L57
    L57:
        e = move-exception;
        Log.e("NetWorkUtils", e);
    L32:
        th = th;
        r118 = r114;
        r113 = r116;
        goto L54
    L38:
        e = e;
        r118 = null;
    L36:
        th = th;
        r118 = null;
        goto L54
    }
}
