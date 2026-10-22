package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import kotlin.UByte;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f462015a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f462016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f462017c;

    static {
        f462015a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        f462016b = 1;
        f462017c = 0;
    }

    public static String a() {
        return ak.d();
    }

    public static String a(int r100) {
        return aj.a(r100);
    }

    public static String a(Context r100) {
        return com_unicom_online_account_kernel_al_android_telephony_TelephonyManager_getSimOperator((TelephonyManager) r100.getSystemService("phone"));
    }

    public static String a(Context r100, String r101) {
        return b(b(r100, r101));
    L4:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String a(Context r100, String r101, String r102) {
        return a(b(r100, r101), r102.toLowerCase());
    L4:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String a(String r100) {
        MessageDigest r101 = MessageDigest.getInstance(new String(o.b("U0hBMjU2")));     // Catch: NoSuchAlgorithmException -> L15
        r101.update(r100.getBytes());     // Catch: NoSuchAlgorithmException -> L15
        byte[] r102 = r101.digest();     // Catch: NoSuchAlgorithmException -> L15
        StringBuffer r103 = new StringBuffer("");     // Catch: NoSuchAlgorithmException -> L15
        int r104 = 0;
    L5:
        if (r104 >= r102.length) goto L13;
        int r105 = r102[r104];     // Catch: NoSuchAlgorithmException -> L15
        if (r105 >= 0) goto L10;
        r105 = r105 + 256;     // Catch: NoSuchAlgorithmException -> L15
    L10:
        if (r105 >= 16) goto L12;
        r103.append("0");     // Catch: NoSuchAlgorithmException -> L15
    L12:
        r103.append(Integer.toHexString(r105));     // Catch: NoSuchAlgorithmException -> L15
        r104 = r104 + 1;     // Catch: NoSuchAlgorithmException -> L15
        goto L5
    L13:
        return r103.toString();
    L15:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String a(String r100, String r101, String r102) {
        return n.b(r100, r101, r102);
    }

    private static String a(List<String> r110) {
        JSONObject r100 = new JSONObject();
        StringBuffer r101 = new StringBuffer();
        StringBuffer r102 = new StringBuffer();
        if (r110.size() == 0) goto L45;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r104 >= r110.size()) goto L28;
        String r105 = (String) ListProtector.get(r110, r104);
        String r106 = r105.substring(0, 3);
        byte[] r107 = InetAddress.getByName(r105).getAddress();     // Catch: UnknownHostException -> L24
        if (r105.length() == 0) goto L23;
        if (r107.length != 4) goto L19;
        if (r106.equals("127") == true) goto L23;
        if (r106.equals("192") == true) goto L23;
        r101.append(r105);     // Catch: UnknownHostException -> L24
        r101.append("-");     // Catch: UnknownHostException -> L24
        goto L23
    L19:
        if (r105.contains(GXTemplateKey.GAIAX_PE) == true) goto L23;
        if ("::1".equals(r105) == true) goto L23;
        r102.append(r105);     // Catch: UnknownHostException -> L24
        r102.append("-");     // Catch: UnknownHostException -> L24
    L23:
        r104 = r104 + 1;
    L24:
        e = move-exception;
        aj.a(e);
        return "{\"privateIp\":\"0.0.0.0\"}";
    L28:
        if (r101.length() == 0) goto L35;
        if ('-' != r101.charAt(r101.length() - 1)) goto L35;
        StringBuffer r111 = r101.deleteCharAt(r101.length() - 1);
        int r108 = Math.min(r102.length(), 5);
        int r109 = 0;
    L32:
        if (r109 >= r108) goto L35;
        r100.put("privateIp", r111);
        r109 = r109 + 1;
    L35:
        if (r102.length() == 0) goto L42;
        if ('-' != r102.charAt(r102.length() - 1)) goto L42;
        StringBuffer r112 = r102.deleteCharAt(r102.length() - 1);
        int r113 = Math.min(r102.length(), 5);
    L39:
        if (r103 >= r113) goto L42;
        r100.put("privateIp_v6", r112);
        r103 = r103 + 1;
    L42:
        if (r100.length() <= 0) goto L45;
        return r100.toString();
    L45:
        return "{\"privateIp\":\"0.0.0.0\"}";
    }

    private static String a(byte[] r100) {
        String r101 = "";
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L11;
        if (r102 == 0) goto L7;
        r101 = r101 + ":";
    L7:
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L10;
        r101 = r101 + "0";
    L10:
        r101 = r101 + r103;
        r102 = r102 + 1;
        goto L4
    L11:
        return r101;
    }

    private static String a(byte[] r100, String r101) {
        return a(MessageDigest.getInstance(r101).digest(r100));
    L4:
        e = move-exception;
        aj.a(e);
        return "";
    }

    private static boolean a(ConnectivityManager r100) {
        Method r101 = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        return ((Boolean) r101.invoke(r100, new Object[0])).booleanValue();
    L5:
        e = move-exception;
        aj.a(e);
        return true;
    }

    public static int b(Context r100) {
        int r101 = d(r100);
        ak.a(r101);
        return r101;
    }

    public static String b(String r100) {
        MessageDigest r101 = MessageDigest.getInstance(new String(o.b("TUQ1")));     // Catch: NoSuchAlgorithmException -> L15
        r101.update(r100.getBytes());     // Catch: NoSuchAlgorithmException -> L15
        byte[] r102 = r101.digest();     // Catch: NoSuchAlgorithmException -> L15
        StringBuffer r103 = new StringBuffer("");     // Catch: NoSuchAlgorithmException -> L15
        int r104 = 0;
    L5:
        if (r104 >= r102.length) goto L13;
        int r105 = r102[r104];     // Catch: NoSuchAlgorithmException -> L15
        if (r105 >= 0) goto L10;
        r105 = r105 + 256;     // Catch: NoSuchAlgorithmException -> L15
    L10:
        if (r105 >= 16) goto L12;
        r103.append("0");     // Catch: NoSuchAlgorithmException -> L15
    L12:
        r103.append(Integer.toHexString(r105));     // Catch: NoSuchAlgorithmException -> L15
        r104 = r104 + 1;     // Catch: NoSuchAlgorithmException -> L15
        goto L5
    L13:
        return r103.toString();
    L15:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static String b(String r100, String r101, String r102) {
        return n.a(r100, r101, r102);
    }

    private static String b(byte[] r100) {
        SM3Digest r101 = new SM3Digest();     // Catch: Exception -> L4
        r101.update(r100, 0, r100.length);     // Catch: Exception -> L4
        byte[] r102 = new byte[r101.getDigestSize()];     // Catch: Exception -> L4
        r101.doFinal(r102, 0);     // Catch: Exception -> L4
        return a(r102);
    L4:
        e = move-exception;
        aj.a(e);
        return "";
    }

    public static void b() {
        aj.a();
    }

    private static byte[] b(Context r100, String r101) {
        PackageManager r102 = r100.getPackageManager();
        PackageInfo r103 = r102.getPackageInfo(r100.getPackageName(), 64);     // Catch: Exception -> L9
        if (r103.packageName.equals(r101) == true) goto L7;
        return null;
    L7:
        return r103.signatures[0].toByteArray();
    L9:
        e = move-exception;
        aj.a(e);
        return null;
    }

    public static int c() {
        f462017c = 0;
        f462016b = 0;
        return 0;
    }

    public static String c(Context r100) {
        ApplicationInfo r101 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 0);     // Catch: Exception -> L4
        return (String) r100.getPackageManager().getApplicationLabel(r101);
    L4:
        return "";
    }

    public static String c(String r100) {
        SM3Digest r101 = new SM3Digest();
        byte[] r102 = r100.getBytes(Charset.forName("UTF-8"));
        r101.update(r102, 0, r102.length);
        byte[] r103 = new byte[r101.getDigestSize()];
        r101.doFinal(r103, 0);
        return u.a(r103);
    }

    public static int d() {
        return f462016b;
    }

    private static int d(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L24
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L24
        if (r102 != null) goto L6;
    L23:
        return -1;
    L6:
        if (r102.isAvailable() == false) goto L23;
        if (r102.getType() != 1) goto L17;
        if (a(r101) == false) goto L14;
        aj.a("Data and WIFI");     // Catch: Exception -> L24
        return 1;
    L14:
        aj.a("Only WIFI");     // Catch: Exception -> L24
        return 2;
    L17:
        if (r102.getType() != 0) goto L26;
        aj.a("Only Data");     // Catch: Exception -> L24
        String r103 = com_unicom_online_account_kernel_al_android_net_NetworkInfo_getExtraInfo(r102);     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r103) == true) goto L28;
        ak.d(r103);     // Catch: Exception -> L24
        ak.b(ak.e(r103));     // Catch: Exception -> L24
        return 0;
    L28:
        return 0;
    L26:
        return -1;
    L24:
        e = move-exception;
        aj.a(e);
        goto L26
    }

    public static int d(String r100) {
        byte[] r101 = InetAddress.getByName(r100).getAddress();
        int r102 = (((r101[3] & UByte.MAX_VALUE) << 24) | ((r101[2] & UByte.MAX_VALUE) << 16)) | ((r101[1] & UByte.MAX_VALUE) << 8);
        return (r101[0] & UByte.MAX_VALUE) | r102;
    L5:
        return -1;
    }

    public static int e() {
        return f462017c;
    }

    public static void e(String r100) {
        aj.a(0, r100);
    }

    public static int f() {
        int r100 = f462017c;
        if (r100 < 0) goto L9;
        if (r100 > f462016b) goto L9;
        int r101 = r100 + 1;
        f462017c = r101;
        return r101;
    L9:
        return f462016b;
    }

    public static String g() {
        return a(h());
    L4:
        return "{\"privateIp\":\"0.0.0.0\"}";
    }

    private static List<String> h() {
        ArrayList r100 = new ArrayList();
        Enumeration<NetworkInterface> r101 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L29
        if (r101 == null) goto L31;
    L5:
        if (r101.hasMoreElements() == false) goto L31;
        NetworkInterface r102 = r101.nextElement();     // Catch: SocketException -> L29
        if (r102.isVirtual() == true) goto L5;
        if (r102.isUp() == false) goto L5;
        Enumeration<InetAddress> r103 = r102.getInetAddresses();     // Catch: SocketException -> L29
        if (r103 == null) goto L5;
    L14:
        if (r103.hasMoreElements() == false) goto L5;
        InetAddress r104 = r103.nextElement();     // Catch: SocketException -> L29
        if (r104.isLoopbackAddress() == true) goto L14;
        if (r104.isLinkLocalAddress() == true) goto L14;
        if (r104.isMulticastAddress() == true) goto L14;
        if (r104.isAnyLocalAddress() == true) goto L14;
        if ((r104 instanceof Inet4Address) == true) goto L27;
        if ((r104 instanceof Inet6Address) == false) goto L14;
    L27:
        r100.add(r104.getHostAddress());     // Catch: SocketException -> L29
    L31:
        return r100;
    L29:
        e = move-exception;
        aj.a(e);
        goto L31
    }

    private static String com_unicom_online_account_kernel_al_android_net_NetworkInfo_getExtraInfo(NetworkInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        f06.b r112 = new f06.b();
        g06.a r101 = ApiHookConfig.f245611b.get(102026);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        f06.d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getExtraInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String com_unicom_online_account_kernel_al_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimOperator();
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, r113, r111, true);
        return r113;
    }
}
