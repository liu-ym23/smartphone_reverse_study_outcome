package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.TrafficStats;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.apm.util.m;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class NetworkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f384383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f384384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f384385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f384386d;

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NetworkType[] f384387a = null;
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
            f384387a = new NetworkType[]{r100, r101, r102, r103, r104, r105};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f384387a.clone();
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

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f384388a = null;

        static {
            int[] r100 = new int[NetworkType.values().length];
            f384388a = r100;
            r100[NetworkType.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f384388a[NetworkType.MOBILE_2G.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f384388a[NetworkType.MOBILE_3G.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f384388a[NetworkType.MOBILE_4G.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f384388a[NetworkType.MOBILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static String d() {
        String r100 = "none";
        Enumeration<NetworkInterface> r101 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L21
    L4:
        if (r101.hasMoreElements() == false) goto L23;
        NetworkInterface r102 = r101.nextElement();     // Catch: SocketException -> L21
        String r103 = r102.getName();     // Catch: SocketException -> L21
        if (r103 == null) goto L4;
        if (TextUtils.equals(r103.toLowerCase(), "eth0") == true) goto L12;
        if (TextUtils.equals(r103.toLowerCase(), "wlan0") == false) goto L4;
    L12:
        Enumeration<InetAddress> r104 = r102.getInetAddresses();     // Catch: SocketException -> L21
    L14:
        if (r104.hasMoreElements() == false) goto L4;
        InetAddress r105 = r104.nextElement();     // Catch: SocketException -> L21
        if ((r105 instanceof Inet4Address) == false) goto L14;
        if (r105.isLoopbackAddress() == true) goto L14;
        r100 = r105.getHostAddress();     // Catch: SocketException -> L21
    L23:
        return r100;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    }

    public static String a(Context r100) {
        int r101 = r100.getApplicationInfo().uid;
        long r102 = TrafficStats.getTotalRxBytes() / 1024;
        if (r102 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r103 = System.currentTimeMillis();
        long r104 = ((r102 - f384383a) * 1000) / (r103 - f384385c);
        f384385c = r103;
        f384383a = r102;
        return String.valueOf(r104) + " KB/s";
    }

    public static List<String> b(Context r100) {
        ArrayList r101 = new ArrayList();
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L15
        NetworkInfo r103 = r102.getActiveNetworkInfo();     // Catch: Exception -> L15
        Network[] r104 = r102.getAllNetworks();     // Catch: Exception -> L15
        int r105 = r104.length;     // Catch: Exception -> L15
        int r106 = 0;
    L4:
        if (r106 >= r105) goto L17;
        Network r107 = r104[r106];     // Catch: Exception -> L15
        if (r102.getNetworkInfo(r107).getType() != r103.getType()) goto L14;
        Iterator<RouteInfo> r108 = r102.getLinkProperties(r107).getRoutes().iterator();     // Catch: Exception -> L15
    L9:
        if (r108.hasNext() == false) goto L14;
        InetAddress r109 = r108.next().getGateway();     // Catch: Exception -> L15
        if (r109 == null) goto L9;
        r101.add(r109.getHostAddress());     // Catch: Exception -> L15
    L14:
        r106 = r106 + 1;
    L17:
        return r101;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static List<String> c(Context r100) {
        ArrayList r101 = new ArrayList();
        ConnectivityManager r102 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L13
        NetworkInfo r103 = r102.getActiveNetworkInfo();     // Catch: Exception -> L13
        Network[] r104 = r102.getAllNetworks();     // Catch: Exception -> L13
        int r105 = r104.length;     // Catch: Exception -> L13
        int r106 = 0;
    L4:
        if (r106 >= r105) goto L15;
        Network r107 = r104[r106];     // Catch: Exception -> L13
        if (r102.getNetworkInfo(r107).getType() != r103.getType()) goto L12;
        Iterator<InetAddress> r108 = r102.getLinkProperties(r107).getDnsServers().iterator();     // Catch: Exception -> L13
    L9:
        if (r108.hasNext() == false) goto L12;
        r101.add(r108.next().getHostAddress());     // Catch: Exception -> L13
    L12:
        r106 = r106 + 1;
    L15:
        return r101;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static String e(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L21
        if (r101 != null) goto L6;
    L19:
        NetworkType r102 = NetworkType.NONE;     // Catch: Throwable -> L21
    L42:
    L45:
        int r103 = a.f384388a[r102.ordinal()];     // Catch: Exception -> L41
        if (r103 != 1) goto L25;
        return "wifi";
    L25:
        if (r103 == 2) goto L50;
        if (r103 == 3) goto L49;
        if (r103 == 4) goto L48;
        if (r103 != 5) goto L39;
        return "mobile";
    L48:
        return CJPayBasicUtils.NETWORK_4G;
    L49:
        return CJPayBasicUtils.NETWORK_3G;
    L50:
        return CJPayBasicUtils.NETWORK_2G;
    L39:
        return "";
    L6:
        if (r101.isAvailable() == false) goto L19;
        int r104 = r101.getType();     // Catch: Throwable -> L21
        if (1 != r104) goto L11;
        r102 = NetworkType.WIFI;     // Catch: Throwable -> L21
        goto L42
    L11:
        if (r104 == 0) goto L13;
        r102 = NetworkType.MOBILE;     // Catch: Throwable -> L21
        goto L42
    L13:
        switch(((TelephonyManager) r100.getSystemService("phone")).getNetworkType()) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L16;
            case 15: goto L16;
            default: goto L14;
        };     // Catch: Throwable -> L21
    L14:
        r102 = NetworkType.MOBILE;     // Catch: Throwable -> L21
        goto L42
    L15:
        r102 = NetworkType.MOBILE_4G;     // Catch: Throwable -> L21
        goto L42
    L16:
        r102 = NetworkType.MOBILE_3G;     // Catch: Throwable -> L21
        goto L42
    L17:
        r102 = NetworkType.MOBILE_2G;     // Catch: Throwable -> L21
    L21:
        r102 = NetworkType.MOBILE;
        goto L45
    }

    public static String f(Context r100) {
        int r101 = r100.getApplicationInfo().uid;
        long r102 = TrafficStats.getTotalTxBytes() / 1024;
        if (r102 != (-1)) goto L6;
        return "UNSUPPORTED";
    L6:
        long r103 = System.currentTimeMillis();
        long r104 = ((r102 - f384384b) * 1000) / (r103 - f384386d);
        f384386d = r103;
        f384384b = r102;
        return String.valueOf(r104) + " KB/s";
    }

    public static boolean g(Context r100) {
        NetworkInfo r101 = ((ConnectivityManager) r100.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isAvailable() == false) goto L17;
        if (1 != r101.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static List<String> h(String r100) {
        ArrayList r101 = new ArrayList();
        InetAddress[] r102 = InetAddress.getAllByName(r100);     // Catch: UnknownHostException -> L11
        if (r102 != null) goto L6;
    L13:
        return r101;
    L6:
        if (r102.length <= 0) goto L13;
        int r103 = r102.length;     // Catch: UnknownHostException -> L11
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L13;
        r101.add(r102[r104].getHostAddress());     // Catch: UnknownHostException -> L11
        r104 = r104 + 1;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static boolean i(String r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();
        boolean r103 = false;
        HttpURLConnection r104 = null;
        r104 = m.a(r100);     // Catch: Throwable -> L9 Exception -> L11
        r104.setRequestMethod("GET");     // Catch: Throwable -> L9 Exception -> L11
        r104.setReadTimeout(30000);     // Catch: Throwable -> L9 Exception -> L11
        r104.setConnectTimeout(30000);     // Catch: Throwable -> L9 Exception -> L11
        r104.setDoInput(true);     // Catch: Throwable -> L9 Exception -> L11
        r104.setDoOutput(true);     // Catch: Throwable -> L9 Exception -> L11
        r104.setUseCaches(false);     // Catch: Throwable -> L9 Exception -> L11
        String r105 = j9a.a.f497829a;     // Catch: Throwable -> L9 Exception -> L11
        r104.setRequestProperty("Charset", "UTF-8");     // Catch: Throwable -> L9 Exception -> L11
        int r106 = r104.getResponseCode();     // Catch: Throwable -> L9 Exception -> L11
        r102.put("statusCode", r106);     // Catch: Throwable -> L9 Exception -> L11
        r102.put("header", b.a(r104.getHeaderFields()));     // Catch: Throwable -> L9 Exception -> L11
        r101.put(r100, r102);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r106 != 200) goto L7;
        r103 = true;
    L7:
        r104.disconnect();
        return r103;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        r101.put(r100, e.getMessage());     // Catch: Throwable -> L9 JSONException -> L17
        if (r104 == null) goto L16;
        r104.disconnect();
    L16:
        return false;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
        if (r104 == null) goto L21;
        r104.disconnect();
    L21:
        return false;
    L9:
        th = move-exception;
        if (r104 == null) goto L24;
        r104.disconnect();
    L24:
        throw th;
    }
}
