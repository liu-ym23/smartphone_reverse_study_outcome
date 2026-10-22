package com.bytedance.bdinstall;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f199819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f199820b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, h0> f199821c = null;

    public static final class a implements h0 {
        public static Class[] i() {
            Class<?>[] r100 = null;
            Method[] r101 = TelephonyManager.class.getDeclaredMethods();     // Catch: Exception -> L12
            int r102 = r101.length;     // Catch: Exception -> L12
            int r103 = 0;
        L4:
            if (r103 >= r102) goto L14;
            Method r104 = r101[r103];     // Catch: Exception -> L12
            if ("getDeviceId".equals(r104.getName()) == false) goto L11;
            r100 = r104.getParameterTypes();     // Catch: Exception -> L12
            if (r100.length < 1) goto L11;
            t.a("length:" + r100.length);     // Catch: Exception -> L12
        L11:
            r103 = r103 + 1;
        L14:
            return r100;
        L12:
            e = move-exception;
            e.printStackTrace();
            t.c(e.getMessage(), e);
            goto L14
        }

        @Override // com.bytedance.bdinstall.h0
        public final JSONArray h() {
            JSONArray r100 = new JSONArray();
        L44:
            e = move-exception;
            e.printStackTrace();
        L46:
            return r100;
        L4:
            if (NetworkInterface.getNetworkInterfaces() == null) goto L6;
            Iterator r101 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Exception -> L44
        L9:
            if (r101.hasNext() == false) goto L46;
            NetworkInterface r102 = (NetworkInterface) r101.next();     // Catch: Exception -> L44
            String r103 = r102.getName();     // Catch: Exception -> L44
            if ("dummy0".equals(r103) == true) goto L16;
            if ("wlan0".equals(r103) == false) goto L9;
        L16:
            Iterator r104 = Collections.list(r102.getInetAddresses()).iterator();     // Catch: Exception -> L44
        L18:
            if (r104.hasNext() == false) goto L9;
            String r105 = ((InetAddress) r104.next()).getHostAddress();     // Catch: Exception -> L44
            if (TextUtils.isEmpty(r105) == true) goto L18;
            if (r105.indexOf(58) >= 0) goto L24;
            boolean r106 = true;
        L25:
            if (r106 == true) goto L18;
            int r107 = r105.indexOf(37);     // Catch: Exception -> L44
            if ("dummy0".equals(r103) == true) goto L29;
            if ("wlan0".equals(r103) == true) goto L38;
            if ("fe80".equalsIgnoreCase(r105.split("::")[0]) == false) goto L18;
        L38:
            JSONObject r108 = new JSONObject();     // Catch: Exception -> L44
            r108.put("type", "client_anpi");     // Catch: Exception -> L44
            if (r107 < 0) goto L42;
            r105 = r105.substring(0, r107);     // Catch: Exception -> L44
        L42:
            r108.put("value", r105.toUpperCase());     // Catch: Exception -> L44
            r100.put(r108);     // Catch: Exception -> L44
            goto L18
        L29:
            JSONObject r109 = new JSONObject();     // Catch: Exception -> L44
            r109.put("type", "client_tun");     // Catch: Exception -> L44
            if (r107 < 0) goto L33;
            r105 = r105.substring(0, r107);     // Catch: Exception -> L44
        L33:
            r109.put("value", r105.toUpperCase());     // Catch: Exception -> L44
            r100.put(r109);     // Catch: Exception -> L44
            goto L18
        L24:
            r106 = false;
            goto L25
        L6:
            return new JSONArray();
        }

        public a() {
        }

        @Override // com.bytedance.bdinstall.h0
        public final String[] c(o0 r100) {
            f84.c r101 = r100.M;
        L20:
            th = move-exception;
            th.printStackTrace();
            return null;
        L4:
            int r102 = 0;
            if (Build.VERSION.SDK_INT < 22) goto L27;
            List<SubscriptionInfo> r103 = r101.c();     // Catch: SecurityException -> L17 Throwable -> L20
            if (r103 == null) goto L16;
            if (r103.isEmpty() == true) goto L16;
            String[] r104 = new String[r103.size()];     // Catch: SecurityException -> L17 Throwable -> L20
        L13:
            if (r102 >= r103.size()) goto L28;
            r104[r102] = r101.h((SubscriptionInfo) ListProtector.get(r103, r102));     // Catch: SecurityException -> L17 Throwable -> L20
            r102 = r102 + 1;     // Catch: SecurityException -> L17 Throwable -> L20
            goto L13
        L28:
            return r104;
        L16:
            return new String[0];
        L17:
            t.a("getSSN , no permission, ignore");     // Catch: Throwable -> L20
            return null;
        L27:
            return new String[]{r101.r()};
        }

        @Override // com.bytedance.bdinstall.h0
        public final String a(Context r210, o0 r211) {
            f84.c r100 = r211.M;
            if (Build.VERSION.SDK_INT >= 26) goto L5;
        L9:
            String r101 = null;
        L11:
            if (TextUtils.isEmpty(r101) == false) goto L13;
        L14:
            ArrayList r102 = new ArrayList();
            Object[] r110 = new Object[0];
            f06.b r111 = new f06.b();
            g06.a r103 = ApiHookConfig.f245611b.get(102002);
            if (r103 == null) goto L17;
            f06.a[] r104 = r103.f479473i;
        L18:
            f06.a[] r112 = r104;
            int r113 = r112.length;
            int r105 = 0;
        L20:
            if (r105 >= r113) goto L27;
            f06.a r106 = r112[r105];
            int r114 = r105;
            int r115 = r113;
            f06.a[] r212 = r112;
            f06.d r107 = r106.preInvoke(102002, "android/os/Build", "SERIAL", Build.class, r110, "java.lang.String", r111);     // Catch: Exception -> L40
            if (r107.f474982a == true) goto L29;
            r102.add(r106);     // Catch: Exception -> L40
        L29:
            if (r107.f474982a == false) goto L31;
            r101 = (String) r107.f474983b;
        L33:
            if (TextUtils.isEmpty(r101) == false) goto L35;
            return "";
        L35:
            if (TextUtils.equals(r101, "unknown") == true) goto L48;
            return r101;
        L48:
            return "";
        L31:
            r101 = Build.SERIAL;
        L26:
            r105 = r114 + 1;
            r113 = r115;
            r112 = r212;
            goto L20
        L27:
            r107 = new f06.d(false, null);
            goto L29
        L17:
            r104 = ApiHookConfig.f245613d;
            goto L18
        L13:
            if (TextUtils.equals(r101, "unknown") == false) goto L33;
        L5:
            if (r210.getApplicationInfo().targetSdkVersion < 26) goto L9;
            r101 = r100.p();     // Catch: Throwable -> L8
            goto L11
        }

        @Override // com.bytedance.bdinstall.h0
        public final String b(Context r100, int r101) {
            TelephonyManager r102 = (TelephonyManager) r100.getSystemService("phone");     // Catch: Exception -> L7
            Method r103 = r102.getClass().getMethod("getDeviceId", i());     // Catch: Exception -> L7
            if (r101 < 0) goto L9;
            Object r104 = r103.invoke(r102, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L7
        L10:
            String r105 = (String) r104;
            t.a("getDeviceId  deviceId=" + r105);
            return r105;
        L9:
            r104 = null;
        L7:
            e = move-exception;
            e.printStackTrace();
            t.c(e.getMessage(), e);
            goto L9
        }

        @Override // com.bytedance.bdinstall.h0
        public final String d(int r100, o0 r101) {
            return r101.M.i(r100);
        }

        @Override // com.bytedance.bdinstall.h0
        public final String e(Context r100, o0 r101) {
        L13:
            t.d("no get_phone_state permission,getDeviceId return null");
        L14:
            return null;
        L4:
            if (i84.f.a(r100) == false) goto L10;
            if (z0.f199820b.compareAndSet(false, true) == false) goto L10;
            return r101.M.f();
        L10:
            if (z0.f199820b.get() == false) goto L14;
            t.a("getDefaultImeiOrMeid# get Meid from memory cache： null");     // Catch: Exception -> L13
            return null;
        }

        @Override // com.bytedance.bdinstall.h0
        public final String f(Context r100, o0 r110) {
            if (r100 != null) goto L46;
        L11:
            WifiInfo r101 = null;
        L12:
            f84.c r102 = r110.M;
            String r111 = r102.j(r101);
            if ("02:00:00:00:00:00".equals(r111) == false) goto L15;
        L48:
            Enumeration<NetworkInterface> r103 = r102.l();     // Catch: Exception -> L41
            String r104 = "wlan0";
            String r105 = (String) i84.u.a("wifi.interface");     // Catch: Exception -> L21
            if (TextUtils.isEmpty(r105) == true) goto L24;
            r104 = r105;
        L24:
            if (r103.hasMoreElements() == false) goto L63;
            NetworkInterface r106 = r103.nextElement();     // Catch: Exception -> L41
            if (r106.getName().equals(r104) == false) goto L24;
            byte[] r107 = r102.g(r106);     // Catch: Exception -> L41
            if (r107 == null) goto L24;
            if (r107.length == 0) goto L24;
            StringBuilder r108 = new StringBuilder();     // Catch: Exception -> L41
            int r109 = r107.length;     // Catch: Exception -> L41
            int r112 = 0;
        L34:
            if (r112 >= r109) goto L37;
            r108.append(String.format("%02X:", new Object[]{Byte.valueOf(r107[r112])}));     // Catch: Exception -> L41
            r112 = r112 + 1;     // Catch: Exception -> L41
            goto L34
        L37:
            if (r108.length() <= 0) goto L39;
            r108.deleteCharAt(r108.length() - 1);     // Catch: Exception -> L41
        L39:
            return r108.toString();
        L63:
            return r111;
        L21:
            e = move-exception;
            e.printStackTrace();     // Catch: Exception -> L41
        L41:
            e = move-exception;
            e.printStackTrace();
            return r111;
        L15:
            if (TextUtils.isEmpty(r111) == true) goto L48;
            return r111;
        L46:
            f84.c r113 = r110.M;     // Catch: Exception -> L9
            r101 = r113.d();     // Catch: Exception -> L9
            String r114 = r113.o(r101);     // Catch: Exception -> L9
            if (((ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L11;
            if (r114 == null) goto L11;
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L11
        }

        @Override // com.bytedance.bdinstall.h0
        public final String g(int r100, o0 r101) {
            return r101.M.k(r100);
        }
    }

    static {
        f199819a = new a();
        f199820b = new AtomicBoolean(false);
        f199821c = new ConcurrentHashMap();
    }

    public static h0 a(String r100) {
        h0 r101 = f199821c.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return f199819a;
    }
}
