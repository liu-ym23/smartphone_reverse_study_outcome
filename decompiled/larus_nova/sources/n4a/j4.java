package n4a;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.byted.cast.common.bean.State;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.loc.es;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes32.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f517412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WifiManager f517413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f517414c;

    public static boolean A(Context r100, String r101) {
        if (Build.VERSION.SDK_INT < 23) goto L8;
        if (r100 != null) goto L6;
    L15:
        goto L12
    L6:
        if (C(r100, f5.o(r101)) != 0) goto L15;
    L11:
        return true;
    L8:
        if (r100 == null) goto L15;
        if (r100.checkCallingOrSelfPermission(f5.o(r101)) != 0) goto L15;
    L12:
        return false;
    }

    public static boolean D(Context r100, String r101) throws Throwable {
        if (((Integer) f4.e(r101, "getInt", new Object[]{r100.getContentResolver(), ((String) f4.d(r101, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static byte F() throws NumberFormatException {
        return CastByteProtector.parseByte("1");
    }

    public static boolean G(Context r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (f517413b != null) goto L22;
        f517413b = (WifiManager) e(r100, "wifi");
    L22:
        if (A(r100, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF") == false) goto L12;
        boolean r101 = f517413b.isWifiEnabled();     // Catch: Throwable -> L14
    L16:
        if (r101 == false) goto L18;
        return r101;
    L18:
        if (y() <= 17) goto L26;
        return "true".equals(String.valueOf(f4.c(f517413b, "isScanAlwaysAvailable", new Object[0])));
    L27:
        return r101;
    L26:
        return r101;
    L12:
        c4.g(new Exception("n_aws"), "OPENSDK_UTS", "iwfal_n_aws");     // Catch: Throwable -> L14
    L15:
        r101 = false;
        goto L16
    }

    public static String I(Context r100) {
        if (f517414c != null) goto L6;
        f517414c = t3.a("MD5", v4.d(r100));
    L6:
        return f517414c;
    }

    public static boolean L(Context r100) {
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L32
        int r102 = r100.getApplicationInfo().targetSdkVersion;     // Catch: Throwable -> L32
        if (r101 != 30) goto L7;
        boolean r103 = true;
    L9:
        if (r102 < 23) goto L11;
        boolean r104 = true;
    L13:
        if (r101 != 31) goto L15;
        boolean r105 = true;
    L16:
        if (r102 > 30) goto L19;
        if (r102 < 23) goto L19;
        boolean r106 = true;
    L20:
        if (r103 == false) goto L23;
        if (r104 == false) goto L23;
        boolean r107 = true;
    L24:
        if (r105 == false) goto L27;
        if (r106 == false) goto L27;
        boolean r108 = true;
    L28:
        if (r107 == true) goto L30;
        if (r108 == true) goto L30;
        return false;
    L30:
        return true;
    L27:
        r108 = false;
    L23:
        r107 = false;
    L19:
        r106 = false;
        goto L20
    L15:
        r105 = false;
        goto L16
    L11:
        r104 = false;
        goto L13
    L7:
        r103 = false;
    L36:
        return false;
    }

    public static float a(AMapLocation r100, AMapLocation r101) {
        return c(new double[]{r100.getLatitude(), r100.getLongitude(), r101.getLatitude(), r101.getLongitude()});
    }

    public static float b(DPoint r100, DPoint r101) {
        return c(new double[]{r100.getLatitude(), r100.getLongitude(), r101.getLatitude(), r101.getLongitude()});
    }

    public static float c(double[] r110) {
        float[] r111 = new float[1];
        Location.distanceBetween(r110[0], r110[1], r110[2], r110[3], r111);
        return r111[0];
    }

    public static int d(NetworkInfo r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (r100.isAvailable() == true) goto L9;
        return -1;
    L9:
        if (r100.isConnected() == true) goto L12;
        return -1;
    L12:
        return r100.getType();
    }

    public static Object e(Context r100, String r101) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.getApplicationContext().getSystemService(r101);
    L7:
        th = move-exception;
        c4.g(th, "Utils", "getServ");
        return null;
    }

    public static List<String> g(File r100) {
        ArrayList r101 = new ArrayList();
        BufferedReader r102 = null;
        PolarisFileInputStreamWrapper r103 = t(r100);     // Catch: Throwable -> L15
        InputStreamReader r104 = new InputStreamReader(r103, Charset.defaultCharset());     // Catch: Throwable -> L14
        BufferedReader r105 = new BufferedReader(r104);     // Catch: Throwable -> L13
    L32:
        String r106 = r105.readLine();     // Catch: Throwable -> L12
        if (r106 == null) goto L10;
        r101.add(r106);     // Catch: Throwable -> L12
        goto L32
    L10:
        r105.close();     // Catch: IOException -> L18
        r104.close();     // Catch: IOException -> L18
    L11:
        r103.close();     // Catch: IOException -> L18
    L25:
        return r101;
    L12:
        r102 = r105;
    L16:
        if (r102 == null) goto L20;
        r102.close();     // Catch: IOException -> L18
    L20:
        if (r104 == null) goto L22;
        r104.close();     // Catch: IOException -> L18
    L22:
        if (r103 == null) goto L25;
    L14:
        r104 = null;
    L15:
        r103 = null;
        r104 = null;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L25
    }

    public static void h(PolarisFileWrapper r100, String r101) {
        PolarisFileOutputStreamWrapper r102 = null;
        r102 = z(r100);     // Catch: Throwable -> L11 IOException -> L13
        if (r101 == null) goto L32;
        r102.write(r101.getBytes());     // Catch: Throwable -> L11 IOException -> L13
    L32:
        r102.close();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r102 == null) goto L36;
        r102.close();     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L36:
        return;
    L11:
        th = move-exception;
        if (r102 != null) goto L34;
    L26:
        throw th;
    L34:
        r102.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public static boolean i(Context r100) {
        if (r100 != null) goto L12;
        return false;
    L12:
    L11:
        return false;
    L6:
        if (y() >= 17) goto L10;
        return D(r100, "android.provider.Settings$System");
    L10:
        return D(r100, "android.provider.Settings$Global");
    }

    public static boolean j(SQLiteDatabase r110) {
        boolean r100 = false;
        if (TextUtils.isEmpty("hist") == false) goto L5;
        return false;
    L5:
        String r101 = "2.0.201501131131".replace(".", "");
        if (r110 != null) goto L29;
    L26:
        return false;
    L29:
    L22:
        Cursor r111 = null;
    L23:
        if (r111 == null) goto L32;
        r111.close();
        return true;
    L32:
        return true;
    L9:
        if (r110.isOpen() == false) goto L26;
        r111 = r110.query("sqlite_master", new String[]{"count(*) as c"}, "type = 'table' AND name = 'hist" + r101 + "'", null, null, null, null);     // Catch: Throwable -> L22
        if (r111 != null) goto L27;
    L19:
        if (r111 == null) goto L31;
        r111.close();
    L31:
        return r100;
    L27:
        if (r111.moveToFirst() == false) goto L19;
        if (r111.getInt(0) <= 0) goto L19;
        r100 = true;
        goto L19
    }

    public static boolean k(Location r100, int r101) {
        boolean r102 = r100.isFromMockProvider();     // Catch: Throwable -> L5
    L7:
        if (r102 == false) goto L28;
        return true;
    L28:
        Bundle r103 = r100.getExtras();     // Catch: Throwable -> L25
        if (r103 == null) goto L12;
        int r104 = r103.getInt("satellites");     // Catch: Throwable -> L25
    L13:
        if (r104 > 0) goto L15;
        return true;
    L15:
        if (r101 != 0) goto L24;
        if (r100.getAltitude() != AudioStats.AUDIO_AMPLITUDE_NONE) goto L24;
        if (r100.getBearing() != 0.0f) goto L24;
        if (r100.getSpeed() != 0.0f) goto L24;
        return true;
    L12:
        r104 = 0;
    L24:
        return false;
    L5:
        r102 = false;
        goto L7
    }

    public static boolean l(AMapLocation r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getErrorCode() == 0) goto L9;
        return false;
    L9:
        return w(r100);
    }

    public static boolean n(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (com.alipay.sdk.m.u.c.f25806a.equals(r100) == false) goto L8;
        return false;
    L8:
        if ("02:00:00:00:00:00".equals(r100) == false) goto L11;
        return false;
    L11:
        if (r100.contains(HTTP.HEADER_LINE_DELIM) == true) goto L18;
        return true;
    L18:
        return false;
    }

    public static boolean o(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L22;
        ArrayList<String> r102 = v(r100);
        String[] r103 = r101.toString().split("#");
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L9:
        if (r104 >= r103.length) goto L19;
        if (r103[r104].contains(",nb") == false) goto L13;
    L14:
        r105 = r105 + 1;
        if (r102.contains(r103[r104]) == false) goto L17;
        r106 = r106 + 1;
    L17:
        r104 = r104 + 1;
        goto L9
    L13:
        if (r103[r104].contains(",access") == false) goto L17;
    L19:
        if ((r106 * 2) < (((double) (r102.size() + r105)) * 0.618d)) goto L22;
        return true;
    }

    public static byte[] p(int r100, byte[] r101) {
        if (r101 != null) goto L5;
    L6:
        r101 = new byte[2];
    L7:
        r101[0] = (byte) (r100 & 255);
        r101[1] = (byte) ((r100 & 65280) >> 8);
        return r101;
    L5:
        if (r101.length >= 2) goto L7;
        goto L6
    }

    public static byte[] q(long r100) {
        byte[] r101 = new byte[8];
        int r102 = 0;
    L3:
        if (r102 >= 8) goto L5;
        r101[r102] = (byte) ((r100 >> (r102 * 8)) & 255);
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public static String[] r(TelephonyManager r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getNetworkOperator();
    L5:
        String[] r102 = {"0", "0"};
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L7:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L42;
        r102[0] = r101.substring(0, 3);
        char[] r104 = r101.substring(3).toCharArray();
        int r105 = 0;
    L18:
        if (r105 >= r104.length) goto L22;
        if (Character.isDigit(r104[r105]) == false) goto L22;
        r105 = r105 + 1;
    L22:
        r102[1] = r101.substring(3, r105 + 3);
    L42:
        int r106 = CastIntegerProtector.parseInt(r102[0]);     // Catch: Throwable -> L25
    L27:
        if (r106 != 0) goto L30;
        r102[0] = "0";
    L30:
        if ("0".equals(r102[0]) == true) goto L35;
        if ("0".equals(r102[1]) == true) goto L35;
        f517412a = r102;
        return r102;
    L35:
        if ("0".equals(r102[0]) == true) goto L37;
        return r102;
    L37:
        if ("0".equals(r102[1]) == false) goto L48;
        String[] r107 = f517412a;
        if (r107 != null) goto L41;
        return r102;
    L41:
        return r107;
    L48:
        return r102;
    L25:
        th = move-exception;
        c4.g(th, "Utils", "getMccMnc");
        r106 = 0;
        goto L27
    L9:
        if (TextUtils.isDigitsOnly(r101) == false) goto L7;
        if (r101.length() <= 4) goto L7;
        r103 = true;
        goto L15
    L4:
        r101 = null;
        goto L5
    }

    public static double s(double r100) {
        return ((long) (r100 * 1000000.0d)) / 1000000.0d;
    }

    public static PolarisFileInputStreamWrapper t(File r100) throws IOException {
        if (r100.exists() == false) goto L15;
        if (r100.isDirectory() == true) goto L13;
        if (r100.canRead() == false) goto L11;
        return new PolarisFileInputStreamWrapper(r100);
    L11:
        throw new IOException("File '" + r100 + "' cannot be read");
    L13:
        throw new IOException("File '" + r100 + "' exists but is a directory");
    L15:
        throw new FileNotFoundException("File '" + r100 + "' does not exist");
    }

    public static String u(Context r100) {
        if (TextUtils.isEmpty(c4.f517213h) == true) goto L7;
        return c4.f517213h;
    L7:
        if (r100 != null) goto L37;
        return null;
    L37:
        PackageInfo r101 = r100.getPackageManager().getPackageInfo(v4.d(r100), 64);     // Catch: Throwable -> L12
    L39:
        TextUtils.isEmpty(null);     // Catch: Throwable -> L16
    L18:
        StringBuilder r102 = new StringBuilder();
        if (r101 == null) goto L29;
        ApplicationInfo r103 = r101.applicationInfo;
        if (r103 == null) goto L23;
        CharSequence r104 = r103.loadLabel(r100.getPackageManager());
    L24:
        if (r104 == null) goto L27;
        r102.append(r104.toString());
    L27:
        if (TextUtils.isEmpty(r101.versionName) == true) goto L29;
        r102.append(r101.versionName);
        goto L29
    L23:
        r104 = null;
    L29:
        String r105 = v4.d(r100);
        if (TextUtils.isEmpty(r105) == true) goto L33;
        r102.append(",");
        r102.append(r105);
    L33:
        if (TextUtils.isEmpty(null) == true) goto L35;
        r102.append(",null");
    L35:
        String r106 = r102.toString();
        c4.f517213h = r106;
        return r106;
    L16:
        th = move-exception;
        c4.g(th, "Utils", "getAppName");
    L12:
        th = move-exception;
        c4.g(th, "Utils", "getAppName part");
        r101 = null;
        goto L39
    }

    public static ArrayList<String> v(String r100) {
        ArrayList<String> r101 = new ArrayList();
        if (TextUtils.isEmpty(r100) == true) goto L13;
        String[] r102 = r100.split("#");
        int r103 = 0;
    L6:
        if (r103 >= r102.length) goto L13;
        if (r102[r103].contains(",nb") == false) goto L10;
    L11:
        r101.add(r102[r103]);
    L12:
        r103 = r103 + 1;
        goto L6
    L10:
        if (r102[r103].contains(",access") == false) goto L12;
    L13:
        return r101;
    }

    public static boolean w(AMapLocation r100) {
        double r101 = r100.getLongitude();
        double r102 = r100.getLatitude();
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L8;
        return false;
    L8:
        if (r101 <= 180.0d) goto L10;
        return false;
    L10:
        if (r102 <= 90.0d) goto L13;
        return false;
    L13:
        if (r101 >= (-180.0d)) goto L15;
        return false;
    L15:
        if (r102 < (-90.0d)) goto L22;
        return true;
    L22:
        return false;
    }

    public static byte[] x(int r100, byte[] r101) {
        if (r101 != null) goto L5;
    L6:
        r101 = new byte[4];
    L7:
        int r102 = 0;
    L9:
        if (r102 >= r101.length) goto L11;
        r101[r102] = (byte) ((r100 >> (r102 * 8)) & 255);
        r102 = r102 + 1;
        goto L9
    L11:
        return r101;
    L5:
        if (r101.length >= 4) goto L7;
        goto L6
    }

    public static PolarisFileOutputStreamWrapper z(PolarisFileWrapper r100) throws IOException {
        if (r100.exists() == true) goto L5;
        File r101 = r100.getParentFile();
        if (r101 != null) goto L16;
    L24:
        return new PolarisFileOutputStreamWrapper(r100, false);
    L16:
        if (r101.mkdirs() == false) goto L18;
    L22:
        r100.createNewFile();
        goto L24
    L18:
        if (r101.isDirectory() == true) goto L22;
        throw new IOException("Directory '" + r101 + "' could not be created");
    L5:
        if (r100.isDirectory() == true) goto L12;
        if (r100.canWrite() == true) goto L24;
        throw new IOException("File '" + r100 + "' cannot be written to");
    L12:
        throw new IOException("File '" + r100 + "' exists but is a directory");
    }

    public static int y() {
        return ((Integer) f4.d("android.os.Build$VERSION", "SDK_INT")).intValue();
    L5:
        return CastIntegerProtector.parseInt(f4.d("android.os.Build$VERSION", "SDK").toString());
    L7:
        return 0;
    }

    public static boolean E(Context r100) {
        if (r100.getApplicationInfo().targetSdkVersion >= 29) goto L5;
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L13;
        return true;
    L13:
        Context r101 = ((Application) r100).getBaseContext();     // Catch: Throwable -> L9
        String[] r102 = b3.M;     // Catch: Throwable -> L9
        int r103 = ((Integer) f4.c(r101, "checkSelfPermission", new Object[]{"android.permission.ACCESS_BACKGROUND_LOCATION"})).intValue();     // Catch: Throwable -> L9
    L10:
        if (r103 == 0) goto L17;
        return false;
    L17:
        return true;
    L9:
        r103 = 0;
        goto L10
    }

    public static String H(Context r100) {
        NetworkInfo r101 = x4.s(r100);     // Catch: Throwable -> L4
    L6:
        if (r101 != null) goto L8;
        return State.DISCONNECTED;
    L8:
        if (r101.isConnectedOrConnecting() == false) goto L41;
        int r102 = r101.getType();
        if (r102 != 1) goto L13;
        return "WIFI";
    L13:
        if (r102 != 0) goto L30;
        String r103 = r101.getSubtypeName();
        switch(r101.getSubtype()) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L29;
            case 4: goto L20;
            case 5: goto L29;
            case 6: goto L29;
            case 7: goto L20;
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L20;
            case 12: goto L29;
            case 13: goto L19;
            case 14: goto L29;
            case 15: goto L29;
            case 16: goto L20;
            case 17: goto L29;
            default: goto L17;
        };
    L19:
        return "4G";
    L20:
        return "2G";
    L29:
        return "3G";
    L17:
        if ("GSM".equalsIgnoreCase(r103) == true) goto L20;
        if ("TD-SCDMA".equalsIgnoreCase(r103) == true) goto L29;
        if ("WCDMA".equalsIgnoreCase(r103) == true) goto L29;
        if ("CDMA2000".equalsIgnoreCase(r103) == true) goto L29;
        return r103;
    L30:
        return "UNKNOWN";
    L41:
        return State.DISCONNECTED;
    L4:
        th = move-exception;
        c4.g(th, "Utils", "getNetWorkInfo");
        r101 = null;
        goto L6
    }

    public static boolean J(Context r100) {
        boolean r101 = true;
        if (Build.VERSION.SDK_INT < 31) goto L12;
        if (r100 == null) goto L12;
        if (C(r100, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L12;
        if (C(r100, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == true) goto L47;
        if (K(r100) == true) goto L47;
        String r103 = Build.MANUFACTURER;     // Catch: Throwable -> L48
        String r104 = Build.BRAND;     // Catch: Throwable -> L48
        if (r103.equalsIgnoreCase(RomUtils.BRAND_HUAWEI) == true) goto L21;
        if (r104.toLowerCase().contains(RomUtils.BRAND_HUAWEI) == false) goto L22;
    L21:
        boolean r105 = true;
    L23:
        if (r105 == false) goto L42;
        if (L(r100) == false) goto L42;
        if (Build.VERSION.SDK_INT < 23) goto L34;
        if (r100 != null) goto L32;
    L50:
        goto L39
    L32:
        if (C(r100, "com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) goto L50;
    L37:
        boolean r106 = true;
    L40:
        if (r106 == false) goto L42;
        boolean r107 = true;
    L43:
        if (r107 == true) goto L47;
        r101 = false;
        goto L47
    L34:
        if (r100 == null) goto L50;
        if (r100.checkCallingOrSelfPermission("com.huawei.permission.ACCESS_APPROXIMATELY_LOCATION") != 0) goto L50;
    L39:
        r106 = false;
    L42:
        r107 = false;
    L22:
        r105 = false;
    L59:
        return false;
    L47:
        return r101;
    L12:
        r102 = false;
        goto L13
    }

    public static boolean K(Context r100) {
        String r101 = Build.MANUFACTURER;     // Catch: Throwable -> L31
        String r102 = Build.BRAND;     // Catch: Throwable -> L31
        if (r101.equalsIgnoreCase(DimLocationCheckUtil.VIVO) == true) goto L7;
        if (r102.toLowerCase().contains(DimLocationCheckUtil.VIVO) == false) goto L8;
    L7:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
    L30:
        return false;
    L11:
        if (L(r100) == false) goto L30;
        Cursor r104 = B(r100.getContentResolver(), Uri.parse("content://com.vivo.permissionmanager.provider.permission/fuzzy_location_apps"), new String[]{"package_name", "selected_fuzzy"}, new String[]{r100.getPackageName()});     // Catch: Throwable -> L25
        boolean r105 = false;
    L14:
        if (r104 == null) goto L23;
        if (r104.moveToNext() == false) goto L23;
        if (r104.getString(0) == null) goto L14;
        if (r104.getInt(1) != 1) goto L14;
        r105 = true;
    L26:
        if (r104 == null) goto L28;
    L27:
        r104.close();
    L28:
        if (r105 == false) goto L30;
        return true;
    L23:
        if (r104 == null) goto L28;
    L25:
        r104 = null;
        r105 = false;
    L8:
        r103 = false;
        goto L9
    }

    public static boolean m(es r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ("8".equals(r100.N) == false) goto L9;
        return false;
    L9:
        if ("5".equals(r100.N) == false) goto L12;
        return false;
    L12:
        if ("6".equals(r100.N) == false) goto L15;
        return false;
    L15:
        return w(r100);
    }

    public static int C(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_loc_fy_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String f(long r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L23;
        r101 = "yyyy-MM-dd HH:mm:ss";
    L23:
        SimpleDateFormat r102 = new SimpleDateFormat(r101, Locale.CHINA);     // Catch: Throwable -> L10
        r102.applyPattern(r101);     // Catch: Throwable -> L8
    L14:
        if (r100 > 0) goto L16;
        r100 = System.currentTimeMillis();
    L16:
        if (r102 != null) goto L20;
        return "NULL";
    L20:
        return r102.format(Long.valueOf(r100));
    L8:
        th = th;
    L12:
        c4.g(th, "Utils", "formatUTC");
    L10:
        th = th;
        r102 = null;
        goto L12
    }

    public static Cursor B(ContentResolver r110, Uri r111, String[] r112, String[] r113) {
        f06.c r114 = new f06.c();
        Object[] r115 = {r111, r112, "package_name=?", r113, null};
        f06.b r116 = new f06.b();
        f06.d r100 = r114.b(240004, "android/content/ContentResolver", "query", r110, r115, "android.database.Cursor", r116);
        if (r100.f474982a == false) goto L6;
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, null, r116, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, "package_name=?", r113, null);
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, r101, r116, true);
        return r101;
    }
}
